public class TestTriangle {
    public static void main(String[] args)
    {
        Triangle t1 = new Triangle(1,1,  3,5,  6,2);
        Triangle t2 = new Triangle(new Point(1,1), new Point(7,7), new Point(7,7));
        // If a triangle's vertices' coordinates are integers, then it will not be equilateral.

        System.out.println( t1 +" is "+ t1.getType() +" and has perimeter "+t1.getPerimeter());
        System.out.println( t2 +" is "+ t2.getType() +" and has perimeter "+t2.getPerimeter());
    }
}
