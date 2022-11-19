/*
A Test Driver for the Point class
 */

public class TestPoint {
    public static void main( String ... args){
        Point p1 = new Point( 1,2 );
        System.out.println( "p1 = " + p1 );

        Point p2 = new Point();
        System.out.println( "p2 = " + p2 );

        p1.setX( 3 ) ;
        p1.setY( 4 );
        System.out.println( "p1 = " + p1 );
        System.out.println( "p1.x = " + p1.getX() );
        System.out.println( "p1.y = " + p1.getY() );

        p1.setXY(5,6);
        System.out.println( "p1 = " + p1 );
        System.out.println( "p1.x = " + p1.getX() );
        System.out.println( "p1.y = " + p1.getY() );

        System.out.printf("Distance between p1 and (10,11) = %.2f%n", p1.distance(10, 11));
        p2.setXY( 10, 11);
        System.out.printf("Distance between p1 and p2 = %.2f%n", p1.distance(p2));
        System.out.printf("Distance between p1 and (0,0) = %.2f%n", p1.distance());
    }
}
