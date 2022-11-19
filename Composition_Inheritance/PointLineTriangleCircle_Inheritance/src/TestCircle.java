public class TestCircle {
    public static void main(String[] args) {
        // Test Constructors and toString()
        Circle c1 = new Circle();
        System.out.println("c1 = " + c1);  // Circle's toString()
        Circle c2 = new Circle(1, 2, 3);
        System.out.println("c2 = " + c2);  // Circle's toString()
        Circle c3 = new Circle(new Point(4, 5), 6);   // an anonymous Point instance
        System.out.println("c3 = " + c3);  // Circle's toString()

        // Test Setters and Getters
        c1.setCenter(new Point(11, 12));
        c1.setRadius(13);
        System.out.println("c1 new center and radius = " + c1);  // Circle's toString()
        System.out.println("c1 center is: " + c1.getCenter());  // Point's toString()
        System.out.println("c1 radius is: " + c1.getRadius());

        c1.setCenterX(21);
        c1.setCenterY(22);
        System.out.println("c1 setCenterX(21), setCenterY(22) = " + c1);  // Circle's toString()
        System.out.println("c1 center's x is: " + c1.getCenterX());
        System.out.println("c1 center's y is: " + c1.getCenterY());
        c1.setCenterXY(31, 32);
        System.out.println("c1 setCenterXY(31, 32) = " + c1);  // Circle's toString()
        System.out.println("c1 center's x is: " + c1.getCenterXY()[0]);
        System.out.println("c1 center's y is: " + c1.getCenterXY()[1]);

        // Test getArea() and getCircumference()
        System.out.printf("c1 area is: %.2f%n", c1.getArea());
        System.out.printf("c1 circumference is: %.2f%n", c1.getCircumference());

        // Test distance()
        System.out.printf("distance between c1 and c2 is: %.2f%n", c1.distance(c2));
        System.out.printf("distance between c2 and c1 is: %.2f%n", c2.distance(c1));
        System.out.printf("distance between c2 and c3 is: %.2f%n", c2.distance(c3));
    }
}
