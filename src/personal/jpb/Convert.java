
package personal.jpb;

public class Convert {
  // Converts the string s to double form; terminates the
  // program if s does not represent a valid double value
  public static double toDouble(String s) {
    double d = 0.0;
    try {
      d = Double.valueOf(s).doubleValue();
    } catch (NumberFormatException e) {
      System.out.println("Error in Convert.toDouble: " +
                         e.getMessage());
      System.exit(-1);
    }
    return d;
  }

  // Converts the string s to float form; terminates the
  // program if s does not represent a valid float value
  public static float toFloat(String s) {
    float f = 0.0f;
    try {
      f = Float.valueOf(s).floatValue();
    } catch (NumberFormatException e) {
      System.out.println("Error in Convert.toFloat: " +
                         e.getMessage());
      System.exit(-1);
    }
    return f;
  }
}


