package weather;


public class Interpretations {
  private double minSlope;
  private double maxSlope;
  private double precipitationSlope;

  public Interpretations(double precipitationSlope, double maxSlope, double minSlope) {
    this.precipitationSlope = precipitationSlope;
    this.maxSlope = maxSlope;
    this.minSlope = minSlope;
  }

  public void precipitationSlopeInterpretation() {
    if (precipitationSlope > 0) {
      System.out.println( "The second derivative of the line of average precipitation is " + precipitationSlope + ".\n "
          + "This indicates that the variation among the average precipitation received per month of each given year\n "
          + "in Chapel Hill increases as the years progress. Greater variation in precipitation received indicates \n"
          + "a decreased ability to predict weather patterns, thus making it more difficult for farmers to plant\n "
          + "crops and produce the maximum yield.\n");
    }
    else {
      System.out.println(
          "The variation among average precipitation received per month of each given year decreases as\n "
              + "the years progress.\n");
    }
  }

  public void minAndMaxSlopeInterpretation() {
    if (minSlope > 0 && maxSlope > 0) {
      System.out.println("The slope of the line of minimum yearly temperature is " + minSlope
          + " and the slope of the line\n "
          + "of the maximum yearly temperature is " + maxSlope
          + ". Since both slopes are positive, this indicates\n "
          + "that the temperatures in Chapel Hill are characterized by an increasing trend from year to year. This\n "
          + "is concerning for farmers because rise in average temperature inhibits the ability of farmers to grow\n "
          + "crops. For example, three staple crops are wheat, rice, and soybean and the yields of each of these\n "
          + "crops decreases by 10% for every 1°F of warming.\n");
    } else {
      System.out.println(
          "The slope of the average minimum and maximum yearly temperatures does not indicate a trend of warming\n "
              + "in Chapel Hill.\n");
    }
  }


}
