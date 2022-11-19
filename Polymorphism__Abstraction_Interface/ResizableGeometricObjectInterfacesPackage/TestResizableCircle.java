package ResizableGeometricObjectInterfacesPackage;

public class TestResizableCircle {
    public static void main(String[] args) {
        GeometricObjectInterface geomObj1 = new Circle(5.0);
        System.out.println(geomObj1);
        System.out.println("Perimeter = "+geomObj1.getPerimeter());
        System.out.println("Area = "+geomObj1.getArea());

        ResizableInterface geomObj2 = new ResizableCircle(5.0);
        System.out.println(geomObj2);
        // System.out.println("Perimeter = "+geomObj2.getPerimeter());
        // System.out.println("Area = "+geomObj2.getArea());
        geomObj2.resize(50);
        System.out.println(geomObj2);
        // System.out.println("Perimeter = "+geomObj2.getPerimeter());
        // System.out.println("Area = "+geomObj2.getArea());

        GeometricObjectInterface geomObj3 = (GeometricObjectInterface) geomObj2;
        System.out.println(geomObj3);
        System.out.println("Perimeter = "+geomObj3.getPerimeter());
        System.out.println("Area = "+geomObj3.getArea());
    }
}
