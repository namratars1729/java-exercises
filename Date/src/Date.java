/*
A Date class models a calendar date with day, month and year. It contains the following members:

3 private instance variables day, month, and year.
Constructors, public getters and setters for the private instance variables.
A method setDate(), which sets the day, month and year.
A toString(), which returns "DD/MM/YYYY", with leading zero for DD and MM if applicable.
Write the Date class and a test driver to test all the public methods. No Input validations are required for day, month, and year.
 */

public class Date {
    // ------- The private instance variables
    private int year, month, day;

    // ------- The constructor which constructs a Date object given day, month and year.
    // No input validation.
    public Date( int day, int month, int year){
        setDay( day );
        setMonth( month );
        setYear( year );
    }

    // -------- Getters --------------------
    public int getDay(){
        return this.day;
    }

    public int getMonth(){
        return this.month;
    }

    public int getYear(){
        return this.year;
    }

    // -------- Setters ---------------------
    public void setDay(int day){
        this.day = day;
    }

    public void setMonth(int month){
        this.month = month;
    }

    public void setYear(int year){
        this.year = year;
    }

    // -------- Helper Methods ------------

    // Sets year, month and day. No input validation
    public void setDate( int day, int month, int year){
        this.day = day;
        this.month = month;
        this.year = year;
    }

    // Returns a descriptive String in the form "MM/DD/YYYY" with leading zeroes
    // for day and month
    // Uses the built-in function String.format() to form a formatted String
    public String toString(){
        String formattedString = String.format("%02d/%02d/%4d", getDay() , getMonth() , getYear() );
        return formattedString;
    }

}
