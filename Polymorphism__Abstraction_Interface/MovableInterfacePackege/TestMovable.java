package MovableInterfacePackege;

public class TestMovable {
    public static void main(String[] args) {

        MovableInterface mp1 = new MovablePoint( 5, 6, 10, 15); // upcast
        System.out.println("mp1 = " + mp1);
        mp1.moveLeft();
        System.out.println("mp1 = " + mp1);

        MovableInterface mc1 = new MovableCircle( 1, 2, 3, 4, 20); // upcast
        System.out.println("mc1 = " + mc1);
        mc1.moveRight();
        System.out.println("mc1 = " + mc1);
    }
}
