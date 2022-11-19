import java.util.Scanner;

public class Swap2Integers {

    public static void main( String []args ){
        Scanner scan = new Scanner( System.in );

        System.out.print( "Enter the 1st integer: " );
        int int1 = scan.nextInt();

        System.out.print( "Enter the 2nd integer: " );
        int int2 = scan.nextInt();

        System.out.println( "int1 = " + int1 + "\nint2 = " + int2);

        int1 = int1 ^ int2;
        int2 = int1 ^ int2;
        int1 = int1 ^ int2;

        System.out.println( "After swapping.....\nint1 = " + int1 +
                "\nint2 = " + int2);
    }
}
