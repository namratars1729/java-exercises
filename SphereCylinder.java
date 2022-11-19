/*
Write a program called SphereComputation that prompts user for the radius of a sphere in floating point number.
The program shall read the input as double;
compute the volume and surface area of the sphere in double;
and print the values rounded to 2 decimal places.

The formulas are:
surfaceArea = 4 * Math.PI * radius * radius;
volume = 4 /3 * Math.PI * radius * radius * radius;   // But this does not work in programming?! Why?
------------------------------------------------------------------------------------------------------------------
Write a program called CylinderComputation that prompts user for the base radius and height of a cylinder
in floating point number.
The program shall read the inputs as double;
compute the base area, surface area, and volume of the cylinder;
and print the values rounded to 2 decimal places.

The formulas are:
baseArea = Math.PI * radius * radius;
surfaceArea = 2.0 * Math.PI * radius + 2.0 * baseArea;
volume = baseArea * height;
 */

import java.util.Scanner;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class SphereCylinder {
    private double getDouble( double value){
        BigDecimal bd = new BigDecimal( value ).setScale( 2, RoundingMode.HALF_EVEN );

        return bd.doubleValue();
    }

    public static void main( String []args ){

        SphereCylinder sp_cy_obj = new SphereCylinder();
        boolean flag = true;

        Scanner scan = new Scanner( System.in );

        System.out.print("Enter radius of sphere: ");
        double sphRadius = scan.nextDouble();

        double sphSA = sp_cy_obj.getDouble(4 * Math.PI * sphRadius * sphRadius );
        double sphVol = sp_cy_obj.getDouble( 4 /3 * Math.PI * sphRadius * sphRadius * sphRadius );

        System.out.println( "Surface Area of the sphere = " + sphSA +
                "\nVolume of the sphere = " + sphVol );

        System.out.print("\nEnter radius of cylinder: ");
        double cylRadius = scan.nextDouble();

        double cylBaseArea = Math.PI * cylRadius * cylRadius;
        double cylSA = sp_cy_obj.getDouble(2.0 * Math.PI * cylRadius + 2.0 * cylBaseArea );
        double cylVol = sp_cy_obj.getDouble( cylBaseArea * cylBaseArea );

        System.out.println( "Surface Area of the cylinder = " + cylSA +
                "\nVolume of the cylinder = " + cylVol );
    }
}
