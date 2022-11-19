/*
In Java there are the following ways to round a double to 2 (or more) decimal places:
1. DecimalFormat("0.00")
2. String.format("%.2f")
3. BigDecimal

diameter = 2.0 * radius;
area = Math.PI * radius * radius;
circumference = 2.0 * Math.PI * radius;

 */

import java.util.Scanner;
import java.text.DecimalFormat;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class RoundingDouble {
    // class variable -
    private static final DecimalFormat df = new DecimalFormat("0.00");


    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the radius:  ");
        double radius = scan.nextDouble();

        double PI = Math.PI;
        double diameter = 2 * radius;
        double area = PI * radius * radius;
        double circumference = 2 * PI * radius;

        /* 1) Using DecimalFormat :
              ---------------------
           import java.math.RoundingMode;
           import java.text.DecimalFormat;

            // class variable -
            private static final DecimalFormat df = new DecimalFormat("0.00");

            // local variable -
            double input = 3.14159265359;

           System.out.println("double : " + df.format(input)); //3.14

          // DecimalFormat, default is RoundingMode.HALF_EVEN
          df.setRoundingMode(RoundingMode.DOWN);
          System.out.println("\ndouble (RoundingMode.DOWN) : " + df.format(input));  //3.14

          df.setRoundingMode(RoundingMode.UP);
          System.out.println("double (RoundingMode.UP)  : " + df.format(input)); //3.15

        2) String.format(“%.2f”)
           -----------------------
           Use printf to print a formatted string
           %.2f for a double with 2 decimal digits
           %n for a newline
           System.out.printf("Diameter = %.2f \nArea = %.2f \nCircumference = %.2f", diameter, area, circumference) ;

        3) Big Decimal
          -------------
          import java.math.BigDecimal;
          import java.math.RoundingMode;

          BigDecimal bd = new BigDecimal(input).setScale(2, RoundingMode.HALF_UP);
          double newInput = bd.doubleValue();

          System.out.println("double : " + newInput);
 */

        BigDecimal bdDiameter = new BigDecimal(diameter).setScale(2, RoundingMode.HALF_UP);
        BigDecimal bdArea = new BigDecimal(area).setScale(2, RoundingMode.HALF_UP);
        BigDecimal bdCircumference = new BigDecimal(circumference).setScale(2, RoundingMode.HALF_UP);

        diameter = bdDiameter.doubleValue();
        area = bdArea.doubleValue();
        circumference = bdCircumference.doubleValue();

        System.out.println("Diameter =  " + diameter +
                "\nArea = " + area + "\nCircumference = " + circumference);
    }

}
