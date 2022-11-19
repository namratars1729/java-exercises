/*
Base class to demonstrate inheritance
 */

public class CircleBaseClass {
    private double radius;
    private String color;

    // ----- overloaded constructors
    public CircleBaseClass() {
        setRadius( 1.0 );
        setColor( "red" );
    }

    public CircleBaseClass( double radius) {
        setRadius( radius );
        setColor( "red" );
    }

    public CircleBaseClass( double radius, String color ) {
        setRadius( radius );
        setColor( color );
    }

    // ------ toString()
    @Override
    public String toString() {
        return String.format("Circle[ radius = %.2f, color = %s ]",
                              this.getRadius(), this.getColor() ) ;
    }

    // ------- getters
    public double getRadius() {
        return this.radius;
    }

    public String getColor() {
        return this.color;
    }

    public double getArea() {
        return Math.PI * this.getRadius() * this.getRadius();
    }

    // ------ setters
     public void setRadius ( double radius ) {
        this.radius = radius;
     }

    public void setColor(String color) {
        this.color = color;
    }
}
