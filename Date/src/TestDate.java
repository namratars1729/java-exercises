/*
A Test Driver for the Date class.
 */

import java.util.Scanner;

public class TestDate {
    public static void main(String ... args){

        // Test the constructor (day, month, year)
        Date date1 = new Date( 2,8, 2020);

        // Test toString()
        System.out.println("date1 = " + date1 );

        // Test Setters
        date1.setDay( 15 );
        date1.setMonth( 12 );
        date1.setYear( 2022 );
        System.out.println("new date1 = " + date1 );

        // Test Getters
        System.out.println("new day = " + date1.getDay() );
        System.out.println("new month = " + date1.getMonth() );
        System.out.println("new year = " + date1.getYear() );

         // Test setDate()
        date1.setDate( 9, 9, 1999);
        System.out.println("setDate = " + date1 );
    }
}
