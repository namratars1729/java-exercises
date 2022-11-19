/*
A Test Driver for the Time class

 */
public class TestTime {
    public static void main( String ... args){
        Time t1, t2;

        // Case 1: valid input
        t1 = new Time(23,58,58);
        System.out.println("t1 = " + t1 );

        try {
            // Case 2: invalid input
            // throw exception.
            // Skip the rest, goto "catch".
            // Else complete "try", skip "catch"
            t2 = new Time(24,58,58);
        } catch (IllegalArgumentException ex){
          //  ex.printStackTrace();
            System.out.println( "Error in input....Setting to default value");
            t2 = new Time() ;
        }

        System.out.println("t2 = " + t2 );

        // Test Setters and Getters
        t1.setHour( 4 );
        t1.setMinute( 5 );
        t1.setSecond( 6 );
        System.out.println("t1 = " + t1 );
        System.out.println("t1.hour = " + t1.getHour() );
        System.out.println("t1.minute = " + t1.getMinute() );
        System.out.println("t1.second = " + t1.getSecond() );

        // Test setTime()
        t1.setTime( 23, 59, 58);
        System.out.println("t1 = " + t1 );

        // Test nextSecond() and chaining
        System.out.println( "t1.nextSecond() = " + t1.nextSecond() );
        System.out.println( "t1.nextSecond().nextSecond().nextSecond() = " +
                t1.nextSecond().nextSecond().nextSecond() );
    }
}
