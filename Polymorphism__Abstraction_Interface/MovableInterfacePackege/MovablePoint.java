package MovableInterfacePackege;


public class MovablePoint implements MovableInterface {
    int x, y, xSpeed, ySpeed;  // default package access

    // -------- constructor
    public MovablePoint( int x, int y, int xSpeed, int ySpeed) {
        this.x = x;
        this.y = y;
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
    }

    // ---- toString()
    @Override
    public String toString() {
        return String.format("(%d, %d) speed = (%d,%d)",
                                x, y, xSpeed, ySpeed );
    }

    // ------- Override abstract methods (provide implementations)
    @Override
    public void moveUp(){
        y -= ySpeed;
    }

    @Override
    public void moveDown(){
        y += ySpeed;
    }

    @Override
    public void moveLeft(){
        x -= xSpeed;
    }

    @Override
    public void moveRight(){
        x += xSpeed;
    }
}
