/*
https://math.hws.edu/javanotes/c12/ex4-ans.html

Find the integer in the range 1 to 100000 that has the largest number of divisors.
Write a program that uses multiple threads to solve the same problem.
By using threads, your program will take less time to do the computation when it is
run on a multiprocessor computer.
At the end of the program, output
- the elapsed time
- the integer that has the largest number of divisors, and
- the number of divisors that it has. There might be several numbers that have the
  maximum number of divisors. Only one of them is output.
 */

package src;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class UsingExecutorService {
    private static final int MAX = 100000;

    // returns the count of divisors for a number
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
    // we want to submit the tasks to an ExecutorService, so we need tasks that implement
    // the Callable interface.
    // The tasks compute outputs of type Result, so in fact, Task implements Callable<Result>.
    // At the end of the call() method, a Result object is created to represent the results
    // from this task, and the result object is returned as the value of call()

    private record Result( int maxCountOfDivisors, int intWithMaxDivisors ){}

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

    public static void compute( int numberOfThreads ){
        // ------- 1. create a thread pool
        ExecutorService exService = Executors.newFixedThreadPool( numberOfThreads );
        List<Future<Result>> resultArrList = new ArrayList<>(); // to hold all the results

        // ------- 2. create and submit each task to the ExecutorService.
        // Submit will automatically start a thread
        // and the result of each thread (a Future) is added to the resultArrList.
        int numberOfTasks = ( MAX + 999 ) / 1000;
        for ( int i = 0; i < numberOfTasks; i++ ) {
            int start = i * 1000 + 1;
            int end = ( i+1 ) * 1000;
            if ( end > MAX )
                end = MAX;
            // the result after a thread runs a task
            Future<Result> singleTaskResult = exService.submit( new Task( start, end ) );
            // add the result to the resultArrList
            resultArrList.add( singleTaskResult );
        }

        // -------- 3. The results of each thread's execution is in the resultArrList
        // Get the maximum value and the corresponding integer from the resultArrList.
        int maxDivisorsCount = 0;
        int intWithMaxDivisors = 0;
        for ( Future<Result> r : resultArrList ){
            try {
                Result result = r.get();
                if (result.maxCountOfDivisors > maxDivisorsCount ){
                    maxDivisorsCount = result.maxCountOfDivisors;
                    intWithMaxDivisors = result.intWithMaxDivisors;
                }
            } catch (InterruptedException | ExecutionException ex ) {}
        }

        // --------- 4. Print the results
        // print the results
        System.out.println( String.format("\n%d has the largest number of divisors = %d",
                intWithMaxDivisors, maxDivisorsCount ) );

        // ------- 6. terminate the threads
        exService.shutdown();
        try {
            if ( !exService.awaitTermination(800, TimeUnit.MILLISECONDS) ) {
                exService.shutdownNow();
            }
        } catch (InterruptedException e) {
            exService.shutdownNow();
        }
    }

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        compute( 10 ); // compute using 10 threads
        long elapsedTime = System.currentTimeMillis() - startTime;
        System.out.println("Total elapsed time:  " +
                (elapsedTime/1000.0) + " seconds.\n");
    }
}
