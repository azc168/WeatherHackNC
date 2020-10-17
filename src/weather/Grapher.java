package weather;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

public class Grapher {
  private final WeatherUtil data;
  private String[] stringOfYears = new String[17];
  private double[][] data_array = new double[17][3];
  private double minOfMaxTemps = 10000;

  public Grapher(WeatherUtil data) {
    if ( data == null) {
      throw new IllegalArgumentException();
    }
    this.data = data;

  }

  public String[] stringYears() {
     String[] stringOfYears = new String[17];
    for (int i = 0; i < 17; i++) {
      String stringYear = Integer.toString((2002 + i));
      stringOfYears[i] = stringYear;
    }
    return stringOfYears;
  }

  public double[][] makeAnArray() {
    for ( int i = 0; i < 17; i++) {
      int j = 0;
      int year = 2002 + i;
      data_array[i][j] = year;
      j++;
      data_array[i][j] = data.getYearData(year).getAvgTempHigh();
      j++;
      data_array[i][j] = data.getYearData(year).getAvgPrecipitation();
    }
    this.delta();
    return data_array;
  }

  private void delta() {
    for ( int i = 0; i < 17; i++) {
      if ( data_array[i][1] < minOfMaxTemps) {
        minOfMaxTemps = data_array[i][1];
      }
    }
    for (int j = 0; j < 17; j++) {
      data_array[j][1] = (data_array[j][1] - minOfMaxTemps);
    }
  }
  public double getMinOfMaxTemps() {
    return Math.round(minOfMaxTemps);
  }





}
