/*
You are given n lines.
In each line there are zero or more integers.

You need to answer a few queries where you need to tell the
number located in y position of x line.

Take your input from System.in.

Input Format
The first line has an integer n.
In each of the next n lines there will be an integer d denoting number of
integers on that line and then there will be d space-separated integers.
In the next line there will be an integer q denoting number of queries.
Each query will consist of two integers x and y.

Constraints
1 <= n <= 20000
0 <= d <= 50000
1 <= q <= 1000
1 <= x <= n

Output Format
In each line, output the number located in  position of  line. If there is no such position, just print "ERROR!"

Sample Input:
5
5 41 77 74 22 44
1 12
4 37 34 36 52
0
3 20 22 33
5
1 3
3 4
3 1
4 3
5 5

Sample Output:
74
52
37
ERROR!
ERROR!

 */

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HackerRank_1 {
    public static void main(String[] args) {
        /*
        Sample Input:
        5
        5 41 77 74 22 44
        1 12
        4 37 34 36 52
        0
        3 20 22 33
         */
        System.out.println( "Start: ");

        Scanner input = new Scanner( System.in );
        int numLines = input.nextInt();

        // instantiate a 2D jagged ArrayList with capacity = numLines
        List< List<Integer> > allLinesArrList = new ArrayList<>( numLines );

        // read the next "numLines", where the 1st element = numElements in that line
        for( int line = 0; line < numLines; ++line ) {
            int numElementsLine = input.nextInt();

            // instantiate a 1D ArrayList for each line
            List<Integer>  lineArrList = new ArrayList<>();

            // read the elements of that line and add that line's elements to lineArrList
            for ( int i = 0; i < numElementsLine && input.hasNextInt(); ++i ) {
                lineArrList.add( input.nextInt() );
            }
            allLinesArrList.add( lineArrList );  // add lineArrList to allLinesArrList
        }
       // allLinesArrList.stream().forEach( System.out :: println );

        /*
        Queries -
        5
        1 3
        3 4
        3 1
        4 3
        5 5
         */

        // get the number of queries
        int numQueries = input.nextInt();

        // instantiate a 2d jagged ArrayList to store all the queries
        List< List<Integer> > allQueriesArrList = new ArrayList<>( numQueries );

        // read each line/query
        for( int qline = 0; qline < numQueries && input.hasNextInt(); ++qline ){
            int x = input.nextInt();
            int y = input.nextInt();
            // add each line (query) to a new 1D ArrayList
            List< Integer > qLineArrList = new ArrayList<Integer>();
            qLineArrList.add( x );   // qLineArrList[0]
            qLineArrList.add( y );   // qLineArrList[1]

            // add to allQueriesArrList
            allQueriesArrList.add( qLineArrList );
        }
       // allQueriesArrList.stream().forEach( System.out :: println );

        // iterate over allQueriesArrList and get the x, y coordinates from each ArrayList
        for( List<Integer> eachQList : allQueriesArrList ) {
                int x = eachQList.get( 0 ) - 1;
                int y = eachQList.get( 1 ) - 1;
                if( y > allLinesArrList.get( x ).size() )
                    System.out.println( "ERROR!" );
                else
                    System.out.println( allLinesArrList.get( x ).get( y ));
        }
    }
}
