/*
A Point class models a 2D point at (x,y). It contains the following members:

2 private instance variables x and y, which maintain the location of the point.
2 Constructors (default, and with x and y values), getters and setters.
A method setXY(), which sets the x and y of the point; and
a method getXY(), which returns the x and y in a 2-element int array.
A toString(), which returns "(x,y)".
3 versions of overloaded distance():
    distance(int x, int y) returns the distance from this instance to the given point at (x,y).
    distance(Point another) returns the distance from this instance to the given Point instance
    (called another).
    distance() returns the distance from this instance to (0,0).
 */

public class Point {
    private int x, y;

    // constructors overloaded
    public Point() {
        setXY(0, 0);
    }

    public Point(int x, int y) {
        setXY(x, y);
    }

    // setter
    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setXY(int x, int y) {
        this.x = x;
        this.y = y;
    }

    // getter
    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    public int[] getXY() {
        int[] xyArray = new int[]{0, 0};
        xyArray[0] = getX();
        xyArray[1] = getY();
        return xyArray; // returns the x and y in a 2-element int array.
    }

    // toString(), which returns "(x,y)"
    public String toString() {
        return "(" + getX() + "," + getY() + ")";
    }

    // ------ overloaded distance(). d = √ ( (x2 – x1)² + (y2 – y1)² ).
    public double distance(int x, int y) {
        //returns the distance from this instance to the given point at (x,y).
        int xDiff = getX() - x;
        int yDiff = getY() - y;

        return Math.sqrt((xDiff * xDiff) + (yDiff * yDiff));
    }

    public double distance(Point another) {
        // returns the distance from this instance to the given Point instance (called another).
        int xDiff = getX() - another.x;
        int yDiff = getY() - another.y;

        return Math.sqrt( (xDiff * xDiff) + (yDiff * yDiff) );
    }

    public double distance(){
        // returns the distance from this instance to (0,0).
        return Math.sqrt( (getX() * getX()) + (getY() * getY()) );
    }

}
