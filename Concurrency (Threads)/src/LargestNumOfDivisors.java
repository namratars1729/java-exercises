/*
https://math.hws.edu/javanotes/c12/ex3-ans.html

Find the integer in the range 1 to 100000 that has the largest number of divisors.
Write a program that uses multiple threads to solve the same problem.
By using threads, your program will take less time to do the computation when it is
run on a multiprocessor computer.
At the end of the program, output
- the elapsed time
- the integer that has the largest number of divisors, and
- the number of divisors that it has. There might be several numbers that have the
  maximum number of divisors. Only one of them is output.

------------ Use:
- a thread pool,
- a ConcurrentLinkedQueue for the task queue and
- a LinkedBlockingQueue for the result queue.
When several threads are available for performing tasks, those threads are called a thread pool.
Thread pools are used to avoid creating a new thread to perform each task. Instead, when a task
needs to be performed, it can be assigned to any idle thread in the "pool."
Once all the threads in the thread pool are busy, any additional tasks will have to wait until
one of the threads becomes idle.
This is a natural application for a queue.
Associated with the thread pool is a queue of waiting tasks. As tasks become available, they are
added to the queue.
Every time that a thread finishes a task, it goes to the queue to get another task to work on.

Note that there is only one task queue for the thread pool.
All the threads in the pool use the same queue, so the queue is a shared resource.
As always with shared resources, race conditions are possible and synchronization is essential.
Without synchronization, for example, it is possible that two threads trying to get items from
the queue at the same time will end up retrieving the same item.

Java has a built-in class to solve this problem: ConcurrentLinkedQueue.
It is a parameterized class:
    ConcurrentLinkedQueue<Runnable> queue = new ConcurrentLinkedQueue<>();
It is a queue, implemented as a linked list, in which operations on the queue are properly synchronized.
The method for adding a new item, x, to the end of queue is queue.add(x).
The method for removing an item from the front of queue is queue.poll().
The queue.poll() method returns null if the queue is empty; thus, poll() can be used to test whether
the queue is empty and to retrieve an item if it is not.
It makes sense to do things in this way because testing whether the queue is non-empty before taking
an item from the queue involves a race condition: Without synchronization, it is possible for another
thread to remove the last item from the queue between the time when you check that the queue is
non-empty and the time when you try to take the item from the queue. By the time you try to get the
item, there's nothing there! On the other hand, queue.poll() is an "atomic" operation
(An atomic operation is something that cannot be interrupted. It is an all-or-nothing affair.
It cannot be partly completed.)

---------------- For this exercise,-----------------------------------------------------------------

you should simply divide up the problem into parts and create one thread to do each part:
- divide the integers between 1 and 100000 into groups
- assign each group of integers to a thread
- each thread has two pieces of data to report AFTER it has completed its computation
    - the largest number of divisors that it found in its assigned range of integers and
    - the integer that had that many divisors
    - update the variables maxDivisorCount and intWithMaxDivisorCount.

Note:
If there are T threads and N integers, then each thread gets at least N/T integers
(where N/T means the integer quotient, discarding any remainder).
But after assigning N/T integers to each thread, there might still be a few integers left over.
(The number of leftovers is actually N % T.)
In your program, just add these extra integers onto the group of integers assigned to the last thread,
so the last thread might have more integers to process than the other threads.
Do this by making sure that the last number assigned to the last thread is 100000.

static final int MAX = 100000;
int integersPerThread = MAX/numberOfThreads;
int start = 1;  // Starting point of the range of ints for first thread.
int end = start + integersPerThread - 1;   // End point of the range of ints.
for (int i = 0; i < numberOfThreads; i++) {
   if (i == numberOfThreads - 1) {
      end = MAX;  // Make sure that the last thread's range goes all
                     // the way up to 100000.  Because of rounding, this
                     // is not automatic.
   }
   worker[i] = new CountDivisorsUsingThreads ( start, end );
   start = end + 1;    // Determine the range of ints for the NEXT thread.
   end = start + integersPerThread - 1;
}

Use the following variables/methods/class
- private static ConcurrentLinkedQueue<Task> taskQueue;
    A queue to hold the tasks.
    Tasks are represented as objects of type Task, a nested class that is defined below.
    Note that queue operations must be synchronized because the queue is used by multiple threads.
    a ConcurrentLinkedQueue handles synchronization internally
    We have to be careful not to start the threads until the tasks are in the queue.

    ConcurrentLinkedQueue:
    - is an unbounded, thread-safe, and non-blocking queue.
    - no provision to specify the queue size during creation
    - It is a lock-free queue
    - it does not block a thread once the queue is empty. Instead, it returns null.
    - Since its unbounded, it'll throw a java.lang.OutOfMemoryError if there's no extra memory to
      add new elements.
    - In any producer-consumer scenario, consumers will not contend with producers; however, multiple
      producers will contend with one another.

- private static LinkedBlockingQueue<Result> resultQueue;
    A queue to hold the results from the tasks.
    Results are defined by the nested class, Result, which is defined below.
    This is a blocking queue since the thread that takes results from the queue should block when
    the queue is empty until a result becomes available.

    LinkedBlockingQueue:
    - is an optionally-bounded blocking queue implementation, meaning that the queue size can
      be specified if needed.
    - It is a lock-based queue
    - If the queue is full, then adding a new element will block the accessing thread unless
      there is space available for the new element. Similarly, if the queue is empty, then accessing
      an element blocks the calling thread. The take method() blocks the calling thread.
    - Often when we use a thread pool, we want to keep the threads around to work on more than one job.
      When a blocking queue is faced with an empty queue, it waits for an item to become available in the queue.
      We can then start the queue whenever we want, and the threads will wait, if necessary, for tasks to be
      added to the queue. If we had more jobs for the thread pool, the threads would just wait around between
      jobs and would become active again as soon as tasks from a new job are enqueued.
    - The blocking feature of the LinkedBlockingQueue is associated with some cost.
      This cost is because every put or the take operation is lock contended between the producer
      or the consumer threads. Therefore, in scenarios with many producers and consumers, put and
      take actions could be slower.

- private record Task(int min, int max) {
    public void compute(){ }
  }
  A class to represent the task of finding the number in a given range of integers that has the
  largest number of divisors.
  The range is specified in the constructor.
  The task is executed when the compute() method is called.
  At the end of the compute() method, a Result object is created to represent the results from this
  task, and the result object is added to resultQueue.
     ( An array consists of a sequence of items, where individual items are referred to by their
      numerical position in the sequence. In a record, on the other hand, the positions in the data
      structure have names instead of numbers.
      The items in a record are called its "fields," and the names for the items are "field names."
      A field is accessed using its field name.
      We recognize records as similar to objects, with the fields in a record playing the same role
      as instance variables in an object
      A record is used instead of a class and allows to avoid the usual ceremony of creating
      hashCode(), equals(), toString(), getters, and constructor.
      Instance fields need to be present in the record's parameters but record can define static fields.
      eg. public record Employee(int id, String firstName, String lastName) {}
      firstName, lastName are the instance fields, written as parameters
      The constructor, getter methods, toString(), equals(), and hashCode() are generated by the
      Java compiler during compile time.
      One thing to note here is that records do not provide setter methods, as it is expected that
      the value to instance variables is provided while creating the object.
      A record cannot be extended, i.e. cannot be inherited, and is immutable as well.
      https://math.hws.edu/javanotes/c7/s4.html )

- private record Result(int maxDivisorFromTask, int intWithMaxFromTask) { }
  A class to represent the result from one task.
  The result consists of the maximum number of divisors in the range of integers assigned to that task, and
  the integer in the range that gave the maximum number of divisors.

- private static class CountDivisorsThread extends Thread
  A thread belonging to this class counts the number of divisors for all the integers in an assigned
  range of integers.
  The range is specified in the constructor.
  The thread finds the integer in the range that has the largest number of divisors, and
  a number that has that many divisors.
  At the end of its computation, the thread reports its answer by calling the report() method.

- private static void countDivisorsWithThreads(int numberOfThreads)
  Finds the number in the range 1 to MAX that has the largest number of divisors, dividing the
  work into tasks that will be executed by threads in a thread pool.
  This method creates the task and result queues.
  It adds all the tasks to the task queue.
  Then it creates the threads for the thread pool and starts them.
  (Note that this must be done AFTER all the tasks are in the task queue, since the threads exit
   when they see an empty queue.)
  Finally, it reads results from the result queue and combines them to get the overall answer.

- The main() routine just gets the number of threads from the user and
  calls countDivisorsWithThreads() to do the actual work.

*/

import java.util.Scanner;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class LargestNumOfDivisors {
    private static final int MAX = 100000;
    private static ConcurrentLinkedQueue<Task> taskQueue;
    private static BlockingQueue<Result> resultQueue;  // a LinkedBlockingQueue

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

    // a class to find the number with the largest number of divisors
    private record Task( int start, int end ){
        public void findMaxDivisorsAndInteger(){
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
            resultQueue.add( new Result( maxCountOfDivisors, intWithMaxDivisors ) );
        }
    }

    // A class to represent the result from one task.
    //  The result consists of the maximum number of divisors in the range of integers assigned to that task, and
    //  the integer in the range that gave the maximum number of divisors.
    private record Result( int maxCountOfDivisors, int intWithMaxDivisors ) {};

    // the thread class
    private static class ComputeMaxDivisorThread extends Thread {
        @Override
        public void run() {
            while( true ){
                Task getTask = taskQueue.poll();
                if ( getTask == null )
                    break;
                getTask.findMaxDivisorsAndInteger();
            }
        }
    }

    // instantiate the queues and thread pool.
    // create tasks and add to the taskQueue
    // add threads to the thread pool
    // compute the result from the resultQueue
    private static void compute( int numThreads ) {
        // instantiate the queues
        taskQueue = new ConcurrentLinkedQueue<>();
        resultQueue = new LinkedBlockingQueue<>();

        // create tasks and add to the taskQueue
        int numberOfTasks = ( MAX + 999 ) / 1000;
        for ( int i = 0; i < numberOfTasks; i++ ) {
            int start = i * 1000 + 1;
            int end = ( i+1 ) * 1000;
            if ( end > MAX )
                end = MAX;
            taskQueue.add( new Task(start, end) );
        }

        // As the tasks are all in the taskQueue, now create a thread pool and
        // start the threads
        ComputeMaxDivisorThread [] threadPool = new ComputeMaxDivisorThread[ numThreads ];
        for( int i = 0; i < threadPool.length; ++i ){
            threadPool[ i ] = new ComputeMaxDivisorThread();
        }

        for( int i = 0; i < threadPool.length; ++i ){
            threadPool[ i ].start();
        }

        // Once the threads have started, the result of each thread's execution
        // is placed in the resultQueue.
        // Get the maximum value and the corresponding integer from the resultQueue.
        int maxDivisors = 0;
        int intWithMaxNumOfDivisors = 0;
        for ( int i = 0; i < numberOfTasks; ++i ) {
            try {
                Result result = resultQueue.take();
                if ( result.maxCountOfDivisors > maxDivisors ){
                    maxDivisors = result.maxCountOfDivisors;
                    intWithMaxNumOfDivisors = result.intWithMaxDivisors;
                }
            } catch ( InterruptedException ex ){}
        }

        // print the results
        System.out.println( String.format("\n%d has the largest number of divisors = %d",
                intWithMaxNumOfDivisors, maxDivisors ) );
    }

    public static void main(String[] args) {

        // First check how many processors are there in this computer
        int processors = Runtime.getRuntime().availableProcessors();
        System.out.println("Your computer has " + processors + " available processor.\n");

        long startTime = System.currentTimeMillis();
        compute( 10 ); // compute using 10 threads
        long elapsedTime = System.currentTimeMillis() - startTime;
        System.out.println("Total elapsed time:  " +
                (elapsedTime/1000.0) + " seconds.\n");
    }
}
