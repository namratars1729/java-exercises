package ResizableGeometricObjectInterfacesPackage;

public class ResizableCircle extends Circle implements ResizableInterface {

    // -------- constructor
    public ResizableCircle(double radius) {
        super(radius);
    }

    // ------ toString()
    @Override
    public String toString() {
        return String.format("ResizableCircle[ %s ]", super.toString() );
    }

    // Override abstract method
    @Override
    public void resize(int percent) {
        this.radius *= (double) percent/100;
    }
}
