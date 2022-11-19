package ResizableGeometricObjectInterfacesPackage;

public class Circle implements GeometricObjectInterface{
    protected double radius;

    // ----- constructor
    public Circle( double radius){
        this.radius = radius;
    }

    // ----- toString()
    @Override
    public String toString() {
        return String.format("Circle[ radius = %.2f%n", this.radius );
    }

    // ------- Override the abstract methods i.e provide implementations
    @Override
    public double getPerimeter() {
        return 2 * Math.PI * this.radius;
    }

    @Override
    public double getArea() {
        return 2 * Math.PI * this.radius * this.radius;
    }
}
