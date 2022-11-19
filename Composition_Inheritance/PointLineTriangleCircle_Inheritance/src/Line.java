/*
A class called MyLine, which models a line with a begin point at (x1, y1) and an end point at (x2, y2).
The MyLine class uses two MyPoint instances as its begin and end points.
Write the MyLine class. Also write a test driver to test all the public methods in the MyLine class.
 */

import java.util.Arrays;

public class Line {
    private Point begin, end; // a line from begin(x,y) to end(x,y)

    // -------- overloaded constructors
    public Line(int x1, int y1, int x2, int y2 ) {
        this.begin =  new Point(x1, y1);
        this.end = new Point(x2, y2);
    }
    public Line( Point begin, Point end) {
        setBegin( begin );
        setEnd( end );
    }

    // ------ toString()
    @Override
    public String toString() {
        return String.format( "Line[ begin=%s, end=%s ]", this.begin, this.end ) ;
    }

    // ------- getters
    public Point getBegin() {
        return this.begin;
    }

    public Point getEnd() {
        return this.end;
    }

    public int getBeginX(){
        return this.begin.getX();
    }

    public int getBeginY() {
        return this.begin.getY();
    }

    public int getEndX(){
        return this.end.getX();
    }

    public int getEndY(){
        return this.end.getY();
    }

    public int[] getBeginXY(){
        int[] xyArray = new int[]{0,0};
        xyArray[ 0 ] = this.begin.getX();
        xyArray[ 1 ] = this.begin.getY();
        return xyArray;
    }

    public int[] getEndXY() {
        int [] xyArray = new int[]{0,0};
        xyArray[ 0 ] = this.end.getX();
        xyArray[ 1 ] = this.end.getY();
        return xyArray;
    }

    public double getLength(){
        return this.begin.distance( this.end );
    }

    public double getGradient(){
        // return the gradient in radians
        // use Math.atan2(yDiff, xDiff)
        double xDiff, yDiff;
        xDiff = this.end.getX() - this.begin.getX();
        yDiff = this.end.getY() - this.begin.getY();
        return Math.atan2( yDiff, xDiff );
    }

    // ------- setters
    public void setBegin( Point begin ) {
        this.begin = begin;
    }

    public void setEnd( Point end ) {
        this.end = end;
    }

    public void setBeginX( int x ) {
        this.begin.setX( x );
    }

    public void setBeginY( int y ) {
        this.begin.setY( y );
    }

    public void setEndX( int x ) {
        this.end.setX( x );
    }

    public void setEndY( int y ) {
        this.end.setY( y );
    }

    public void setBeginXY( int x, int y) {
        this.begin.setX( x );
        this.begin.setY( y );
    }

    public void setEndXY( int x, int y) {
        this.end.setX( x );
        this.end.setY( y );
    }
}
