package weather;

import javax.swing.JFrame;
import javax.swing.WindowConstants;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.DefaultCategoryDataset;



public class LineGraph extends JFrame {

  private static final long serialVersion = 1L;
  private double minOfMaxTemps;
  private double minOfMinTemps;

  public LineGraph(String title, double[][] data_array, String[] stringOfYears, double minOfMaxTemps, double minOfMinTemps) {
    super(title);
    this.minOfMaxTemps = minOfMaxTemps;
    this.minOfMinTemps = minOfMinTemps;
    // Create dataset
    DefaultCategoryDataset dataset = createDataSet(data_array, stringOfYears);
    // Create chart
    JFreeChart chart = ChartFactory.createLineChart(
        "Temperature and Precipitation Data in Chapel Hill, 2002-2019",
        "Year",
        "Measurement",
        dataset
    );

    ChartPanel panel = new ChartPanel(chart);
    setContentPane(panel);

  }
  private DefaultCategoryDataset createDataSet(double[][] data_array, String[] stringOfYears) {

    String varOne = "Max Temps (# of degrees above " + minOfMaxTemps + "°F)";
    String varTwo = "Min Temps (# of degrees above " + minOfMinTemps + "°F)";
    String varThree = "Average Precipitation (inches)";

    DefaultCategoryDataset dataset = new DefaultCategoryDataset();

    // adding the average precipitations
    for (int i = 0; i < 18; i++) {
      dataset.addValue(data_array[i][2], varThree, stringOfYears[i]);
    }

    // adding the maximum temperatures
    for (int i = 0; i < 18; i++) {
      dataset.addValue(data_array[i][1], varOne, stringOfYears[i]);
    }

    // adding the minimum temperatures
    for (int i = 0; i < 18; i++) {
      dataset.addValue(data_array[i][3], varTwo, stringOfYears[i]);
    }

    return dataset;
  }

  //this method actually runs the graph
  public void graphInfo() {
    this.setAlwaysOnTop(true);
    this.pack();
    this.setSize(800, 600);
    this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    this.setVisible(true);
  }


}
