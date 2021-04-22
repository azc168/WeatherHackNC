package weather;

public class Grapher {
  private final WeatherUtil data;
  private String[] stringOfYears = new String[18];
  private double[][] data_array = new double[18][4];
  private double minOfMaxTemps = 10000;
  private double minOfMinTemps = 10000;

  public Grapher(WeatherUtil data) {
    if ( data == null) {
      throw new IllegalArgumentException();
    }
    this.data = data;

  }

  public String[] stringYears() {
     String[] stringOfYears = new String[18];
    for (int i = 0; i < 18; i++) {
      String stringYear = Integer.toString((2002 + i));
      stringOfYears[i] = stringYear;
    }
    return stringOfYears;
  }

  public double[][] makeAnArray() {
    for ( int i = 0; i < 18; i++) {
      int j = 0;
      int year = 2002 + i;
      data_array[i][j] = year;
      j++;
      data_array[i][j] = data.getYearData(year).getAvgTempHigh();
      j++;
      data_array[i][j] = data.getYearData(year).getAvgPrecipitation();
      j++;
      data_array[i][j] = data.getYearData(year).getAvgTempLow();
    }
    this.deltaMax();
    this.deltaMin();
    return data_array;
  }

  private void deltaMax() {
    for ( int i = 0; i < 18; i++) {
      if ( data_array[i][1] < minOfMaxTemps) {
        minOfMaxTemps = data_array[i][1];
      }
    }
    for (int j = 0; j < 18; j++) {
      data_array[j][1] = (data_array[j][1] - minOfMaxTemps);
    }
  }
  private void deltaMin() {
    for ( int i = 0; i < 18; i++) {
      if ( data_array[i][3] < minOfMinTemps) {
        minOfMinTemps = data_array[i][3];
      }
    }
    for (int j = 0; j < 18; j++) {
      data_array[j][3] = (data_array[j][3] - minOfMinTemps);
    }
  }
  public double getMinOfMaxTemps() {
    return Math.round(minOfMaxTemps);
  }
  public double getMinOfMinTemps() {
    return Math.round(minOfMinTemps);
  }
  public double getMaxSlope() {
    int index = 1;
    double sum = 0;
    for (int i = 0; i < 17; i++) {
      sum = sum + Math.abs((data_array[i + 1][index] - data_array[i][index]));
    }
    return (double)Math.round((sum / 17) * 100.0) / 100.0;
  }
  public double getPrecipitationSlope() {
    int index = 2;
    double sum = 0;
    double[] delta = new double[17];
    for (int i = 0; i < 17; i++) {
      delta[i] =  Math.abs((data_array[i + 1][index] - data_array[i][index]));
    }
    for( int j = 0; j < 16; j++) {
      sum = sum + Math.abs((delta[j+1] - delta[j]));
    }
    return (double)Math.round((sum / 16) * 100.0) / 100.0;
  }
  public double getMinSlope() {
    int index = 3;
    double sum = 0;
    for (int i = 0; i < 17; i++) {
      sum = sum + Math.abs((data_array[i + 1][index] - data_array[i][index]));
    }
    return (double)Math.round((sum / 17) * 100.0) / 100.0;
  }
}
