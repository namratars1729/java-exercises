public class Circle {
    private Point center;
    private int radius;

    // ----- overloaded constructors
    public Circle() {
        this.setCenter( new Point( 0, 0) );
        this.setRadius( 1 );
    }

    public Circle( int x, int y, int radius ) {
        this.setCenter( new Point( x,y ) );
        this.setRadius( radius );
    }

    public Circle( Point center, int radius ) {
        this.setCenter( center );
        this.setRadius( radius );
    }

    // ------- toString()
    @Override
    public String toString() {
        return String.format("Circle[ radius = %d, center = %s ]",
                             this.getRadius(), this.getCenter() );
    }

    // ----- getters
    public int getRadius() {
        return this.radius;
    }

    public Point getCenter() {
        return this.center;
    }

    public int getCenterX() {
        return this.center.getX();
    }

    public int getCenterY() {
        return this.center.getY();
    }

    public int[] getCenterXY() {
        int[] xyArray = new int[] {0,0};
        xyArray[0] = this.getCenterX();
        xyArray[1] = this.getCenterY();
        return xyArray;
    }

    public double getArea() {
        return Math.PI * this.getRadius() * this.getRadius();
    }

    public double getCircumference() {
        return 2 * Math.PI * this.getRadius();
    }

    // ---- setters
    public void setRadius( int radius ) {
        this.radius = radius;
    }

    public void setCenter( Point center) {
        this.center = center;
    }

    public void setCenterX( int x ) {
        this.center.setX( x );
    }

    public void setCenterY( int y ) {
        this.center.setY( y );
    }

    public void setCenterXY( int x, int y ) {
        this.center.setXY( x, y );
    }

    // ----- methods
    public double distance( Circle another) {
        // distance between 2 circles = the distance between
        // the 2 centers (which is a straight line, therefore,
        // the length of the line );
         return this.center.distance( another.getCenter() );
    }
}
