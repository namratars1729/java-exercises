/*
The LineSub class, subclass of PointBaseClass.
It inherits the begin point from the superclass, and adds an end point.
*/

public class LineSubClass extends Point {
    private Point end; // Declare end as instance of Point

    // -------- overloaded constructors
    public LineSubClass( int x1, int y1, int x2, int y2 ) {
        super( x1, y1 );
        this.end = new Point( x2, y2 );
    }

    public LineSubClass ( Point begin, Point end) {
        /** Constructs a LineSub instance with the 2 given Point instances */
        super(begin.getX(), begin.getY() );  // Need to construct super
        setEnd(end);
    }

    // ------ toString()
    @Override
    public String toString() {
        return String.format( "Line[ begin=%s, end=%s ]", su, this.end ) ;
    }

    // ------- setters



}
