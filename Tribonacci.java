/*
Tribonacci numbers are a sequence of numbers T(n) similar to Fibonacci numbers,
except that a number is formed by adding the three previous numbers,
i.e., T(n) = T(n-1) + T(n-2) + T(n-3) where n >= 3.
T(1) = T(2) = 1, and T(3) = 2.

E.g. First 10 Tribonacci numbers = 1 1 2 4 7 13 24 44 81 149

Write a program called Tribonacci to produce the first twenty Tribonacci numbers.
 */

public class Tribonacci {

// -------------- WITH RECURSION --------------------------------------
    static int trib(int number){
        if ( number == 1 || number == 2 )
            return 1; // return 1 if it is the 1st or 2nd term of the series
        else if ( number == 3 )
            return 2; // return 2 if it is the 3rd term of the series
        else
            return trib( number-1) + trib(number-2) + trib( number-3);
    }

    public static void main( String args[]){
        int END = 20; // From 1 - 20

        for (int i = 1; i <= END; i++ )
            System.out.print( trib(i) + " " );

 /* ------------ WITHOUT RECURSION ----------------------------------

        int FIRST = 1;
        int SECOND = 1;
        int THIRD = FIRST + SECOND;

        System.out.print( FIRST + " " + SECOND + " " + THIRD + " ");

        for (int i = 4; i <= 10; i++){
            int sum = FIRST + SECOND + THIRD;
            System.out.print( sum + " " );

            FIRST = SECOND;
            SECOND = THIRD;
            THIRD = sum;
        }
 */
    }
}
