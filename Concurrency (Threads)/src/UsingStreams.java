// https://math.hws.edu/javanotes/c12/ex4-ans.html

package src;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;

public class UsingStreams {
    private final static int MAX = 100000;

    private record Result(int maxDivisorFromTask, int intWithMaxFromTask) { }

    private static int getCountOfDivisors( int number ) {
        int count = 0; //variable to store the result

        //start a loop and check for each number if it can divide the given number
        for ( int i = 1; i <= number; ++i ) {
            if ( number % i == 0 ) {
                // if the reminder is zero, increment the result variable
                count++;
            }
        }
        return count;
    }

    private record Task( int start, int end ) implements Callable<Result>{
        @Override
        public Result call() throws Exception {
            int maxCountOfDivisors = 0;
            int intWithMaxDivisors = 0;
            int countOfDivisors = 0;
            for ( int number = start; number < end; ++number ){
                countOfDivisors = getCountOfDivisors( number );
                if( countOfDivisors > maxCountOfDivisors ){
                    maxCountOfDivisors = countOfDivisors;
                    intWithMaxDivisors = number;
                }
            }
            return new Result( maxCountOfDivisors, intWithMaxDivisors);
        }
    }

    private static Result getResult( List<Task> taskList ) {
        // comparator for max
        Comparator<Result> maxComparator =
                (result1, result2) -> Integer.compare( result2.maxDivisorFromTask, result1.maxDivisorFromTask );

        Result result =
                taskList.parallelStream()
                        .map( eachTask -> {
                            try {
                                return eachTask.call();
                            } catch (Exception e) {
                                throw new RuntimeException(e);
                            }
                        })
                        .max( maxComparator )
                        .get();
        return result;
    }

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        List<Task> taskList = new ArrayList<>();

        int numberOfTasks = ( MAX + 999 ) / 1000;
        for ( int i = 0; i < numberOfTasks; i++ ) {
            int start = i * 1000 + 1;
            int end = (i + 1) * 1000;
            if (end > MAX)
                end = MAX;
            taskList.add(new Task(start, end));
        }

        Result result = getResult( taskList );

        long elapsedTime = System.currentTimeMillis() - startTime;

        System.out.println( "\nThe largest number of divisors " +
                "for numbers between 1 and " + MAX +
                " is " + result.maxDivisorFromTask );
        System.out.println( "An integer with that many divisors is " +
                result.intWithMaxFromTask );
        System.out.println( "Total elapsed time:  " +
                (elapsedTime/1000.0) + " seconds.\n" );
    }
}
