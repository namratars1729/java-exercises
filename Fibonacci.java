/*
Write a program called Fibonacci to print the first 20 Fibonacci numbers F(n),
where F(n)=F(n–1)+F(n–2) and
F(1)=F(2)=1.
Also compute their average.

The output shall look like:

The first 20 Fibonacci numbers are:
1 1 2 3 5 8 13 21 34 55 89 144 233 377 610 987 1597 2584 4181 6765
The average is 885.5
 */

public class Fibonacci {

// -------- WITH RECURSION ------------------------------------

    // Function to print the fibonacci series
    static int fib (int number){
        if (number <= 2)
            return 1; // return 1 if the number is the 1st or 2nd term in the series
        else
            return fib(number -1 ) + fib(number - 2);
    }

    public static void main(String args[]){
        final int START = 1; // From 1 - 20
        final int END = 20;

        for (int i = START; i <= END; i++) {
            System.out.print( fib(i) + " " );
        }

    }



/* -------- WITHOUT RECURSION ------------------------------------

   public static void main( String []args ){
        int FIRST = 1;
        int SECOND = 1;
        int sum = 0;

        System.out.print(FIRST + " " + SECOND + " ");

        for ( int i=3; i <= 20; i++ ){
            sum = FIRST + SECOND;
            System.out.print(sum + " ");
            SECOND = FIRST;
            FIRST = sum;
        }
    }
 */

}
