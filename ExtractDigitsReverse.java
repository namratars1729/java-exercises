/*
Write a program called ExtractDigits to extract each digit from an int, in the reverse order.
For example, if the int is 15423, the output shall be "3 2 4 5 1", with a space separating the digits.

Hints:
The coding pattern for extracting individual digits from an integer n is:

Use (n % 10) to extract the last (least-significant) digit.
Use n = n / 10 to drop the last (least-significant) digit.
Repeat if (n > 0), i.e., more digits to extract.

Take note that n is destroyed in the process. You may need to clone a copy.
 */

public class ExtractDigitsReverse {
    public static void main( String []args){
        int number = 32451;
        int numberCopy = number;

        System.out.print("The given number = " + number +
                         "\nThe reversed number = ");

        while ( numberCopy > 0 ){
            int digit = numberCopy % 10;  // gives the remainder i.e the digit in the units place
            System.out.print( digit );
            numberCopy /= 10; // gives the remaining numbers i.e 3245
        }

    }
}
