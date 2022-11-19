package MovableInterfacePackege;

public class MovableCircle implements MovableInterface {
    private int radius;
    private MovablePoint center;

    // ------ constructor
    public MovableCircle( int x, int y, int xSpeed, int ySpeed,
                          int radius ) {
        center = new MovablePoint( x, y, xSpeed, ySpeed);

        this.radius = radius;
    }

    // ----- toString()
    @Override
    public String toString() {
        return String.format("%s, radius = %d",
                              this.center, this.radius );
    }

    // ------- Override abstract methods (provide implementations)
    @Override
    public void moveUp() {
        center.y -= center.ySpeed;
    }

    @Override
    public void moveDown(){
        center.y += center.ySpeed;
    }

    @Override
    public void moveLeft(){
        center.x -= center.xSpeed;
    }

    @Override
    public void moveRight(){
        center.x += center.xSpeed;
    }
}
