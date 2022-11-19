/*
Write a new class called MovableRectangle, which composes
    - two MovablePoints (representing the top-left and bottom-right corners) and
    - implements the Movable Interface.
    - Make sure that the two points has the same speed.
 */

package MovableInterfacePackege;

public class MovableRectangle implements MovableInterface {
    private MovablePoint topLeft, bottomRight;

    // -------- constructor
    public MovableRectangle( int x1, int y1,
                             int x2, int y2,
                             int xSpeed, int ySpeed) {
        if ( xSpeed != ySpeed ) {
            throw new IllegalArgumentException("");
        }
        else {
            topLeft = new MovablePoint( x1, y1, xSpeed, ySpeed );
            bottomRight = new MovablePoint( x2, y2, xSpeed, ySpeed );
        }
    }

    // ------- toString()
    @Override
    public String toString() {
        return String.format("MovableRectangle with topLeft: %1$s and bottomRight: %2$s",
                topLeft.toString(), bottomRight.toString());
    }


    // -------- Override the abstract methods
    @Override
    public void moveUp() {
        topLeft.y -= topLeft.ySpeed;
        bottomRight.y -= bottomRight.ySpeed;
    }

    @Override
    public void moveDown() {
        topLeft.y += topLeft.ySpeed;
        bottomRight.y += bottomRight.ySpeed;
    }

    @Override
    public void moveLeft() {
        topLeft.x -= topLeft.xSpeed;
        bottomRight.x -= bottomRight.xSpeed;
    }

    @Override
    public void moveRight() {
        topLeft.x += topLeft.xSpeed;
        bottomRight.x += bottomRight.xSpeed;
    }
}
