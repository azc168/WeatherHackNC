package weather;

import javax.swing.JFrame;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.DefaultCategoryDataset;



public class LineGraph extends JFrame {

  private static final long serialVersion = 1L;
  private double minOfMaxTemps;

  public LineGraph(String title, double[][] data_array, String[] stringOfYears, Double minOfMaxTemps) {
    super(title);
    this.minOfMaxTemps = minOfMaxTemps;
    // Create dataset
    DefaultCategoryDataset dataset = createDataSet(data_array, stringOfYears);
    // Create chart
    JFreeChart chart = ChartFactory.createLineChart(
        "Temp and Precipitation against Year",
        "Year",
        "Measurement",
        dataset
    );

    ChartPanel panel = new ChartPanel(chart);
    setContentPane(panel);

  }
  private DefaultCategoryDataset createDataSet(double[][] data_array, String[] stringOfYears) {

    String varOne = "Number of degrees above " + minOfMaxTemps;
    String varTwo = "Average Precipitation";

    DefaultCategoryDataset dataset = new DefaultCategoryDataset();

    // adding the maximum temperatures
    for (int i = 0; i < 17; i++) {
      dataset.addValue(data_array[i][1], varOne, stringOfYears[i]);
    }

    // adding the average precipitations
    for (int i = 0; i < 17; i++) {
      dataset.addValue(data_array[i][2], varTwo, stringOfYears[i]);
    }

    return dataset;
  }


}
