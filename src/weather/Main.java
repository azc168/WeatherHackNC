package weather;

import java.io.*;
import javax.swing.WindowConstants;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        WeatherUtil weather = new WeatherUtil("historysummary_data.csv");
        double temp = weather.getYearData(2002).getAvgTemp()[0];
        //System.out.println(temp);
        Grapher grapher = new Grapher(weather);
        double[][] arrayOfData = grapher.makeAnArray();
        String[] years = grapher.stringYears();
        double minOfMaxTemps = grapher.getMinOfMaxTemps();
        LineGraph lineGraph = new LineGraph("Line Graph", arrayOfData, years, minOfMaxTemps);
        lineGraph.setAlwaysOnTop(true);
        lineGraph.pack();
        lineGraph.setSize(800, 600);
        lineGraph.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        lineGraph.setVisible(true);
    }
}

