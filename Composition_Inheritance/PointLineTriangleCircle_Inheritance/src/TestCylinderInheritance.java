public class TestCylinderInheritance {
    public static void main(String[] args) {
        // Test default Circle and Cylinder
        CylinderInheritance cy1 = new CylinderInheritance();
        System.out.println("cy1 = " + cy1);

        // Test methods
        System.out.println("cy1 Radius = " + cy1.getRadius()
            + "\ncy1 Height = " + cy1.getHeight()
            + "\ncy1 Color = " + cy1.getColor()
            + "\ncy1 Surface Area = " + cy1.getArea()
            + "\ncy1 Volume = " + cy1.getVolume() );

         // Test Cylinder(height, radius) ==>  Circle with Circle(radius)
        CylinderInheritance  cy2 = new CylinderInheritance(5.0, 2.0) ;
        System.out.println("cy1 = " + cy1);

        System.out.println("\ncy2 Radius = " + cy2.getRadius()
                + "\ncy2 Height = " + cy2.getHeight()
                + "\ncy2 Color = " + cy2.getColor()
                + "\ncy2 Surface Area = " + cy2.getArea()
                + "\ncy2 Volume = " + cy2.getVolume() );
    }
}
