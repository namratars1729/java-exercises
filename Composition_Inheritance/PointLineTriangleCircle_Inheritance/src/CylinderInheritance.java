/*
A subclass inherits all the variables and methods from its superclasses,
including its immediate parent as well as all the ancestors.
It is important to note that a subclass is NOT a "subset" of a superclass.
In contrast, subclass is a "superset" of a superclass. It is because a subclass
inherits all the variables and methods of the superclass; in addition, it extends
the superclass by providing more variables and methods.

A Cylinder is a Circle plus a height.

The class Cylinder inherits all the member variables (radius and color)
and methods (getRadius(), getArea(), among others) from its superclass Circle.
It further defines a variable called height, two public methods - getHeight() and
getVolume() and its own constructors,

 */

public class CylinderInheritance extends CircleBaseClass  {
    private double height;

    // ------ overloaded constructors
    public CylinderInheritance() { // default constructor
        super(); // invoke the Circle's default constructor i.e. radius =1 .0 and color = red
        this.setHeight( 1.0 ); // the cylinder's default height
    }

    public CylinderInheritance( double height) {
        super(); // invoke the Circle's default constructor i.e. radius =1 .0 and color = red
        this.setHeight( height );
    }

    public CylinderInheritance ( double height, double radius) {
        // radius of the circle has to be initialised through the
        // Circle's constructor which accepts radius i.e. CircleBaseClass( double radius)
        super( radius );
        this.setHeight( height );
    }

    public CylinderInheritance ( double height, double radius, String color ) {
        // radius and color have to be initialised through the
        // CircleBaseClass( double radius, String color ) constructor
        super( radius, color );
        this.setHeight( height );
    }

    // ------ toString()
    /* toString() method of the Cylinder class, which overrides the toString()
    inherited from the superclass Circle
    */

    @Override
    public String toString() {
        // use Circle's toString()
        return String.format("Cylinder: subclass of %s, height = %.2f%n",
                super.toString(), this.getHeight() );
    }

    //    @Override
//    public String toString() {
//        return String.format("This is a Cylinder[ %s, %.2f ]",
//                              super.toString() , this.getHeight() ) ;
//    }


    // ----- getters
    public double getHeight() {
        return this.height;
    }

    /*
    ---------------------------------------------------------------------------------------------
    Try overriding the getArea() method in the subclass Cylinder to compute the surface
    area (=2π×radius×height + 2×base-area) of the cylinder instead of base area.

    That is, if getArea() is called by a Circle instance, it returns the area.
    If getArea() is called by a Cylinder instance, it returns the surface area of
    the cylinder.

    If you override the getArea() in the subclass Cylinder, the getVolume() no longer
    works. This is because the getVolume() uses the overridden getArea() method found
    in the same class. (Java runtime will search the superclass only if it cannot
    locate the method in this class).
    Fix the getVolume().

    Hints: After overriding the getArea() in subclass Cylinder, you can choose to invoke
    the getArea() of the superclass Circle by calling super.getArea().
    --------------------------------------------------------------------------------------
     */

    public double getArea() {
        // surface area of the cylinder = 2π×radius×height + 2×base-area
        // i.e. 2πrh + 2πr*r
       return 2 * Math.PI * this.getRadius() * this.getHeight() + ( 2 * super.getArea() );
    }
/*
    public double getVolume() {
        // inherits getArea() method from its superclass Circle.
        return this.getArea() * this.getHeight(); // uses the Circle's getArea()
    }
*/
    public double getVolume() {
        // need the area of the Circle (NOT the surface area of the Cylinder). Therefore,
        // we have to invoke the Circle's getArea() using "super"
        return super.getArea() * this.getHeight();
    }

    // ------ setter
    public void setHeight( double height ){
        this.height = height;
    }


}
