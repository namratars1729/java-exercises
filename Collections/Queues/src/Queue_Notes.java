/*

Queue is used to hold the elements that are about to be processed in
FIFO (First In First Out) order.
It is an ordered list of objects with its use limited to inserting elements at the end of the
list and deleting elements from the start of the list,
(i.e.), it follows the FIFO or the First-In-First-Out principle.


------------------ Queue operations ---------------------------------------------------

The operations of inserting and removing elements are called enqueue and dequeue.

-------Add elements Queue -------
The Java Queue interface contains two methods you can use to add elements to a Queue
These two methods add an element to the end of the Queue.
  - add()
  - offer()
The add() and offer() methods differ in how they behave if the Queue is full, such that
no more elements can be added:
- add() method throws an exception in that case, whereas
- offer() method just returns FALSE.

the offer() method is more preferred for queues.

------- Take/Remove Element From Queue -------
The poll() and remove() both removes the first element in the Queue.
  - poll() or
  - remove()
They differ in how they behave if the Queue is empty.
The poll() method returns NULL if the Queue is empty, whereas
the remove() method throws an exception if the Queue is empty.

------- Peek at the Queue -------
You can peek at the element at the head of a Queue without taking the
element out of the Queue.
This is done via
 - element() or
 - peek()
The element() method returns the first element in the Queue.
If the Queue is empty, the element() method throws a NoSuchElementException.
The peek() works like the element() method except it does not throw an exception
if the Queue is empty. Instead, it just returns NULL.

--------------------- Queue interfaces --------------------------------------------------------

The Queue interface is extended by the Deque interface, BlockingQueue interface etc

The Deque interface is implemented by:
- ArrayDeque and LinkedList
- PriorityQueue (which extends the AbstractQueue class)
The BlockingQueue interface is implemented:
- ArrayBlockingQueue
- PriorityBlockingQueue
  These are bounded queues that is used in multithreading.

-------------------- The Deque interface -----------------------------------------------------
The name Deque is an abbreviation of Double Ended Queue, meaning a queue where
you can add and remove elements to and from both ends of the queue.
The word Deque is pronounced "deck" - like a "deck" of cards.

Because you can enqueue and dequeue from both ends of a Java Deque,
you can use a Deque as both a queue and a stack
- FIFO (first-in, first-out) queue. or
- LIFO (last-in, first-out) queue, like a stack.

- The Deque interface extends the Queue interface
- allows adding elements from BOTH ends of the queue
  - addFirst(), offerFirst(), push()
  - addLast(), offerLast()
- allows removing elements from BOTH ends of the queue
  - removeFirst(), pollFirst(), pop()
  - removeLast(), pollLast()
  - removeFirstOccurrence(), removeLastOccurrence()
- allows retrieving elements from BOTH ends of the queue
  - getFirst(), peekFirst()
  - getLast(), peekLast()
- Adding elements in the middle of queue is not supported.
- allows an iterator object to iterate over its elements in reverse order (from tail to head)
  - descendingIterator()

---------- Implementing classes --------

The Deque interface is implemented by the following 2 classes:
- ArrayDeque
  Utilizes a resizeable array to store items
  implemented if deque is used as a LIFO queue (or a stack)
  The push() and pop() methods are commonly used to enable a Deque to function as a stack.

  // Create a Deque and use it as stack.
  Deque<String> dq = new ArrayDeque<>();
  dq.push("John");
  dq.push("Richard");
  dq.push("Donna");
  dq.push("Ken");
  dq.push("Peter");

   while (dq.peek() != null){
       System.out.println("Element at top: " + dq.peek());
       System.out.println("Popped: " + dq.pop());
       System.out.println("Stack: " + dq);
   }

- LinkedList
  implemented if deque is used as a FIFO queue (or simply as a queue).
  Utilizes the doubly linked list principle to store items
  This makes it fast to insert elements at the end (tail) of the list, and remove
  elements from the beginning (head) of the list.
  A common use case for LinkedList is designing website navigation.
  The structure allows the linking of web resources together, enabling forward and backward
  navigation across browser windows.

  // Create a Deque and add elements at its tail using addLast() or offerLast() method
  Deque<String> dq = new LinkedList<>();

   dq.addLast("John");
   dq.offerLast("Richard");
   dq.offerLast("Donna");
   dq.offerLast("Ken");
   dq.offer("Peter");

- PriorityQueue
The AbstractQueue class is an abstract implementation of a Queue.
The Sub-classes must provide methods for addLast(Object) and removeFirst().
The implementations in AbstractQueue class are appropriate when the base implementation
does not allow null elements.
Methods add, remove, and element are based on offer, poll, and peek, respectively,
but throw exceptions instead of indicating failure via false or null returns.

PriorityQueue extends AbstractQueue class.

is a queue or collection of elements in which elements are stored in order of their priority.
 --- does NOT permit null elements.
 --- The underlying data structure for implementing PriorityQueue is Binary Heap.
 --- An ordinary queue is a first-in-first-out (FIFO) data structure.
     But,in PriorityQueue, elements are stored in order of their priority.
 --- The insertion order is not retained in the PriorityQueue.
 --- While the elements entering a priority queue are not necessarily sorted, they are
  always retrieved in sorted (priority) order.
  Priority is decided by the Comparator provided in the constructor
  PriorityQueue(initialCapacity, Comparator) when the priority queue is instantiated.
  If no comparator is provided, PriorityQueue orders its elements according to their
  natural ordering using the Comparable interface.
  In simple words, by default, the priority is based on the natural order of the elements.
 --- It does not allow the insertion of non-comparable objects
 --- When accessing elements, the element with the highest priority is removed first before
  the element with lower priority.
  --- The element at the head of the priority queue is the smallest element with respect to
  the specified ordering. That is, the element having the smallest value will be
  assigned with the highest priority and removed first from the queue.
  The element having the greatest value will be assigned with the lowest priority and, it
  will be placed at the tail of priority queue.
 --- The iterator returned by the iterator() method does not guarantee that it will traverse
  elements in their sorted order.
  However, when we will use peek() or remove() method, the correct element will be peeked at
  or removed, which is based on the element’s priority.
  Eg. while (pq.peek() != null) {
           System.out.println("Head Element: " + pq.peek());
           System.out.println("Removed Element from Queue: " +pq.remove());
           System.out.println("Priority queue: " + pq);
      }

-------------------- The BlockingQueue interface -----------------------------------------------------

The elements are only ordered as FIFO (first-in-first-out).
It means that the head of this queue is the oldest element of the elements present in
this queue.
The tail of this queue is the newest element of the elements of this queue.
The newly inserted elements are always inserted at the tail of the queue, and the
queue retrieval operations obtain elements at the head of the queue.

- PriorityBlockingQueue
  The methods in this interface typically wait for elements to appear or for
  space to become available.
- ArrayBlockingQueue
- LinkedBlockingQueue




 */
