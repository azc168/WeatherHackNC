package weather;

import java.io.*;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        WeatherUtil weather = new WeatherUtil("historysummary_data.csv");
        double temp = weather.getYearData(2002).getAvgTemp()[0];
        //System.out.println(temp);
    }
}

