public class Point {
    private int x,y;

    // ----- overloaded constructors
    public Point(){
        this.setXY(0,0);
    }

    public Point( int x, int y){
        this.setXY( x,y );
    }

    // ---- toString()
    @Override
    public String toString() {
        return String.format("(%d,%d)", this.getX(), this.getY()) ;
    }

    // ----- getters
    public int getX() {
        return this.x;
    }
    public int getY() {
        return this.y;
    }
    public int[] getXY() {
        int[] xyArray = new int[]{0, 0};

        xyArray[0] = this.getX();
        xyArray[1] = this.getY();
        return xyArray;
    }

    // ------ setters

    public void setX(int x) {
        this.x = x;
    }
    public void setY(int y) {
        this.y = y;
    }
    public void setXY(int x, int y) {
        setX( x );
        setY( y );
    }

    // ----- overloaded distance methods
    // d = √ ( (x2 – x1)² + (y2 – y1)² )

    public double distance ( int x, int y ) {
        // distance between this instance and x,y
        int xdelta, ydelta;
        xdelta = this.x - x;
        ydelta = this.y - y;
        return Math.sqrt( (xdelta * xdelta) + (ydelta * ydelta) );
    }

    public double distance( Point another ){
        // distance between this instance and another Point instance
        int xdelta, ydelta;
        xdelta = this.x - another.getX() ;
        ydelta = this.y - another.getY() ;
        return Math.sqrt( (xdelta * xdelta) + (ydelta * ydelta) );
    }

    public double distance () {
        // distance between this instance and the origin
        int x = getX(), y = getY() ;

        return Math.sqrt( ( x * x) + (y * y) );
    }
}
