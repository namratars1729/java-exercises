/*
A class called Time, which models a time instance with hour, minute and second.
It contains the following members:

3 private instance variables hour, minute, and second.
Constructors, getters and setters.
A method setTime() to set hour, minute and second.
A toString() that returns "hh:mm:ss" with leading zero if applicable.
A method nextSecond() that advances this instance by one second. It returns this instance to
support chaining (cascading) operations, e.g., t1.nextSecond().nextSecond().
Take note that the nextSecond() of 23:59:59 is 00:00:00.

Validate the inputs to ensure that 0 ≤ hour≤ 23, 0 ≤ minute ≤ 59, and 0 ≤ second ≤ 59.
Take note that ALL THE VALIDATIONS ARE DONE IN THE SETTERS..
All other methods (such as constructors and setTime()) INVOKE THE SETTERS TO PERFORM INPUT VALIDATION.

Write the Time class and a test driver to test all the public methods.
 */

public class Time {
    // The private access modifier means that ONLY code inside the class itself can access
    // this Java field.
    private int hour, minute, second;

    //constructor
    public Time(){
        this.hour = 0;
        this.minute = 0;
        this.second = 0;
    }
    public Time( int hour, int minute, int second ){
        this.setTime( hour, minute, second );
    }

    // getters
    public int getHour() {
        return this.hour;
    }

    public int getMinute() {
        return this.minute;
    }

    public int getSecond() {
        return this.second;
    }

    // setters
    public void setHour(int hour) {
        // Validate the input to ensure that 0 ≤ hour ≤ 23
        if (hour >=0 && hour <= 23)
            this.hour = hour;
        else
            throw new IllegalArgumentException("invalid hour");
    }
    public void setMinute(int minute) {
        // Validate the input to ensure that 0 ≤ minute ≤ 59
        if (minute >=0 && minute <= 59)
            this.minute = minute;
        else
            throw new IllegalArgumentException("invalid minute");
    }
    public void setSecond(int second) {
        // Validate the input to ensure that 0 ≤ second ≤ 59
        if (second >=0 && second <= 59)
            this.second = second;
        else
            throw new IllegalArgumentException("invalid second");
    }

    //  method to set hour, minute and second
    public void setTime( int hour, int minute, int second ){
        this.setHour( hour );
        this.setMinute( minute );
        this.setSecond( second );
    }

    // A toString() that returns "hh:mm:ss" with leading zero if applicable.
    public String toString(){
        String formattedString = String.format( "%02d:%02d:%02d", hour,minute,second );
        return formattedString;
    }

    // A method nextSecond() that advances this instance by one second.
    // It returns this instance to support chaining (cascading) operations,
    // e.g., t1.nextSecond().nextSecond().
    //Take note that the nextSecond() of 23:59:59 is 00:00:00.
    //
    // ++x is a prefix form - It increments the variables expression then uses the new value
    // in the expression.
    // x++ is a postfix form - The variables value is first used in the expression and then it
    // is incremented after the operation.
    public Time nextSecond(){
        ++second;
        if ( second >= 60 ) {
            second = 0;
            minute += 1;

            if (minute >= 60) {
                minute = 0;
                hour += 1;
                if (hour >= 24) {
                    hour = 0;
                    minute = 0;
                    second = 0;
                }
            }
        }
        return this;
    }
}
