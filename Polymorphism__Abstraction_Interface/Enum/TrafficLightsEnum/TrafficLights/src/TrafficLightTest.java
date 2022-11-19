// enum outside the class

enum TrafficLight {
    RED( 30 ),
    AMBER( 10 ),
    GREEN( 30 );

    private final int seconds;

    // ----- constructor
    private TrafficLight( int seconds ) {
        this.seconds = seconds;
    }

    // ------ getter
    public int getSeconds() {
        return this.seconds;
    }

}

public class TrafficLightTest {
    public static void main(String[] args) {
        // instances of enum type TrafficLight are generated via values()
        for( TrafficLight traffLight : TrafficLight.values() )
            System.out.printf( "%s: %d seconds %n", traffLight, traffLight.getSeconds() );
    }
}
