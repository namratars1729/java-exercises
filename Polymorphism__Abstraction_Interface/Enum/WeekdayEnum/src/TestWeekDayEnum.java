/*
Create a public enum Weekday with constants for MONDAY, TUESDAY,... until SUNDAY.

The enum should have
    - an instance method boolean isWeekDay() and
    - an instance method boolean isHoliday().

The isHoliday() method should return the opposite of isWeekDay().

Write a program which demonstrates how this enum could be used, which has a method
which takes a Weekday as the argument and prints a message depending on whether
the Weekday is a holiday or not.

We suggest that the main method loops over all values in the Weekday enum and sends
them as argument to the method.

Hint: every enum in Java has a static values() method, which returns an array of the
values in the enum, so you may use a for-each-loop (the enhanced for loop) for this.

Hint: every enum has a toString() implementation which return the constant name
as it was declared in the enum, e.g. "FRIDAY".
------------------------------------------------------

Declare a Weekday sat = Weekday.SATURDAY;.

Use a loop over Weekday.values() with day as loop variable and print out each value
and whether it is less than, equal to or greater than sat, using the
call day.compareTo(sat) - remember that the compareTo() method returns
an int such that:
    - a negative value means that day is less than sat
    - zero means that day is considered equal to sat (when comparing them on order)
    - a positive value means that day is greater than sat
 */

import java.util.Arrays;

enum WeekDayEnum {
    MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY;

    boolean isWeekday() {
        return this != SATURDAY && this != SUNDAY;
    }

    boolean isHoliday() {
        return !isWeekday();
    }
}

public class TestWeekDayEnum {

    void checkDay( WeekDayEnum day, WeekDayEnum sat ) {
        String finalStr, afterStr, beforeStr, equalStr, dayStr;

        int satCheck = day.compareTo(sat), dayIndex;

        afterStr = " is greater than (after) ";
        beforeStr = " is less than (before) ";
        equalStr = " is the same as ";

        dayIndex = Arrays.asList( WeekDayEnum.values() ).indexOf( day );
        dayStr = dayIndex >= 5 && dayIndex <= 6 ? "is a HOLIDAY! Stay home" : "is a WEEKDAY, go to work";
        finalStr = satCheck > 0 ?
                     day + afterStr + " " + sat : satCheck < 0 ?
                                          day + beforeStr + " " + sat : day + equalStr + " " + sat;

        System.out.printf("%s %s. %n%s%n", day, dayStr, finalStr);

    }

    public static void main(String[] args) {
        TestWeekDayEnum testDayObj = new TestWeekDayEnum();
        WeekDayEnum sat = WeekDayEnum.SATURDAY;
        for( WeekDayEnum day : WeekDayEnum.values() )
            testDayObj.checkDay( day, sat );
    }
}
