/*
A class called Triangle, which models a triangle with 3 vertices.
It uses three Point instances as the three vertices.
A method getType(), which prints "equilateral" if all the three sides are equal,
"isosceles" if any two of the three sides are equal, or "scalene" if the three sides are different.
 */

public class Triangle {
    private Point v1, v2, v3; // the 3 vertices

    // ----- overloaded constructors
    public Triangle (int x1, int y1, int x2, int y2, int x3, int y3) {
        this.v1 = new Point(x1, y1 );
        this.v2 = new Point(x2, y2);
        this.v3 = new Point(x3, y2);
    }

    public Triangle (Point v1, Point v2, Point v3) {
        this.v1 = v1;
        this.v2 = v2;
        this.v3 = v3;
    }

    // -------- toString()
    @Override
    public String toString() {
        return String.format( "Triangle[ v1 = %s, v2 = %s, v3 = %s",
                              this.v1, this.v2, this.v3 ) ;
    }

    // -------- methods
    public double getPerimeter() {
        // "distance" of the 3 lines
        double side1, side2, side3;
        side1 = this.v1.distance( v2 ); // length of v1-v2
        side2 = this.v2.distance( v3 ); // length of v2-v3
        side3 = this.v3.distance( v1 ); // length of v3-v1

        return side1 + side2 + side3;
    }

    public String getType(){
        // equilateral or isosceles or scalene
        double side1, side2, side3;
        side1 = this.v1.distance( v2 ); // length of v1-v2
        side2 = this.v2.distance( v3 ); // length of v2-v3
        side3 = this.v3.distance( v1 ); // length of v3-v1

        if( side1 == side2 && side2 == side3 && side3 == side1 )
            return ("Equilateral");
        else if ( ( side1 == side2 && side2 != side3 ) ||
                  ( side2 == side3 && side3 != side1 ) ||
                  ( side3 == side1 && side1 != side2 ) )
            return "Isoceles";
        else
            return "Scalene";
    }
}
