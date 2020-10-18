package weather;

import java.awt.Dimension;
import java.io.*;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        WeatherUtil weather = new WeatherUtil("historysummary_data.csv");
        double temp = weather.getYearData(2002).getAvgTemp()[0];
        //turns hash map of data into 2d array, gets necessary variables for graph
        Grapher grapher = new Grapher(weather);
        double[][] arrayOfData = grapher.makeAnArray();
        String[] years = grapher.stringYears();
        double minOfMaxTemps = grapher.getMinOfMaxTemps();
        double minOfMinTemps = grapher.getMinOfMinTemps();
        // creates graph
        LineGraph lineGraph = new LineGraph("Line Graph", arrayOfData, years, minOfMaxTemps,
            minOfMinTemps);
        //output the graph using graphInfo()
        lineGraph.graphInfo();
        //getting slopes for interpretations
        double maxSlope = grapher.getMaxSlope();
        double precipitationSlope = grapher.getPrecipitationSlope();
        double minSlope = grapher.getMinSlope();
        //get interpretations of slope
        Interpretations interpretations = new Interpretations(precipitationSlope, maxSlope,
            minSlope);
        interpretations.precipitationSlopeInterpretation();
        interpretations.minAndMaxSlopeInterpretation();
    }
}

