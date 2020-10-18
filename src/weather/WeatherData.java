package weather;

public class WeatherData {

    private int year;
    private double tempHigh[];
    private double tempLow[];
    private double avgTemp[];
    private double precipitation[];
    private double cloudCover[];

    public WeatherData(int year) {
        this.year = year;
        this.tempHigh = new double[12];
        this.tempLow = new double[12];
        this.avgTemp = new double[12];
        this.precipitation = new double[12];
        this.cloudCover = new double[12];
    }

    public void setTempHigh(int month, double temp) {
        tempHigh[month] = temp;
    }

    public void setTempLow(int month, double temp) {
        tempLow[month] = temp;
    }

    public void setAvgTemp(int month, double temp) {
        avgTemp[month] = temp;
        //System.out.println(avgTemp[month]);
    }

    public void setPrecipitation(int month, double temp) {
        precipitation[month] = temp;
    }

    public void setCloudCover(int month, double temp) {
        cloudCover[month] = temp;
    }

    public int getYear() {
        return year;
    }

    public double[] getTempHigh() {
        return tempHigh;
    }

    public double[] getTempLow() {
        return tempLow;
    }

    public double[] getAvgTemp() {
        return avgTemp;
    }

    public double[] getPrecipitation() {
        return precipitation;
    }

    public double[] getCloudCover() {
        return cloudCover;
    }

    public double getAvgTempHigh() {
        double sum = 0;
        for (int i = 0; i < tempHigh.length; i++) {
            sum = sum + tempHigh[i];
        }
        return (sum / (tempHigh.length));
    }

    public double getAvgPrecipitation() {
        double sum = 0;
        for (int i = 0; i < precipitation.length; i++) {
            sum = sum + precipitation[i];
        }
        return (sum / (precipitation.length));
    }

    public double getAvgTempLow() {
        double sum = 0;
        for (int i = 0; i < tempLow.length; i++) {
            sum = sum + tempLow[i];
        }
        return (sum / (tempLow.length));
    }
}


