public class TestLine {
    public static void main(String[] args) {
        Line aLine = new Line(0, 0, 3, 4);
        System.out.println(aLine);

        System.out.println("Line 1 begin is "+aLine.getBegin());
        System.out.println("Line 1 end is "+aLine.getEnd());
        System.out.println("Line 1 begin X is "+aLine.getBeginX());
        System.out.println("Line 1 begin Y is "+aLine.getBeginY());
        System.out.println("Line 1 end X is "+aLine.getEndX());
        System.out.println("Line 1 end Y is "+aLine.getEndY());
        System.out.println("Line 1 length is "+aLine.getLength());
        System.out.println("Line 1 gradient is "+aLine.getGradient());
        System.out.println("=====================");

        System.out.println("Change line 1 params...");
        aLine.setBegin(new Point(9, 20));
        aLine.setEnd(new Point(4, 5));
        System.out.println("Line 1 begin is "+aLine.getBegin());
        System.out.println("Line 1 end is "+aLine.getEnd());
        System.out.println("Line 1 length is "+aLine.getLength());
        System.out.println("Line 1 gradient is "+aLine.getGradient());
        System.out.println("=====================");


        Line aLine2 = new Line(new Point(0, 0), new Point(3, 4));
        System.out.println(aLine2);
        System.out.println("Line 2 begin is "+aLine2.getBegin());
        System.out.println("Line 2 end is "+aLine2.getEnd());
        System.out.println("Line 2 begin X is "+aLine2.getBeginX());
        System.out.println("Line 2 begin Y is "+aLine2.getBeginY());
        System.out.println("Line 2 end X is "+aLine2.getEndX());
        System.out.println("Line 2 end Y is "+aLine2.getEndY());
        System.out.println("Line 2 length is "+aLine2.getLength());
        System.out.println("Line 2 gradient is "+aLine2.getGradient());
        System.out.println("=====================");

        System.out.println("Change line 2 params...");
        aLine2.setBeginXY(2, 2);
        aLine2.setEndXY(5, 6);
        System.out.println("Line 2 begin is "+aLine2.getBegin());
        System.out.println("Line 2 end is "+aLine2.getEnd());
        System.out.println("Line 2 length is "+aLine2.getLength());
        System.out.println("Line 2 gradient is "+aLine2.getGradient());
        System.out.println("=====================");
    }
}
