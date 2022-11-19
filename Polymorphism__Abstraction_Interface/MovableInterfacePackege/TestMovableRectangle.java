package MovableInterfacePackege;

public class TestMovableRectangle {
    public static void main(String[] args) {
        try {
            // upcast and test same speeds
            MovableInterface m1 = new MovableRectangle(0, 0, 50, 50, 10, 10);
            System.out.println(m1);
            m1.moveLeft();
            System.out.println(m1);

            // upcast and test different speeds
            MovableInterface m2 = new MovableRectangle(20, 20, 80, 80, 5, 55);
            System.out.println(m2);
            m2.moveRight();
            System.out.println(m2);
        }
        catch (IllegalArgumentException e) {
            System.out.println("xSpeed is not equal to ySpeed");
        }
    }
}
