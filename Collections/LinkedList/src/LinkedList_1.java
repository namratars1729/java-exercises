
import java.util.*;
import java.util.stream.Stream;

public class LinkedList_1 {
    public static void main(String[] args) {
        LinkedList<String> citiesLL = new LinkedList<String>(
                Arrays.asList ("Bangalore ", "Delhi ", "Chennai ","Srinagar ") );
        System.out.println("\ncitiesLL initially - ");
        citiesLL.stream().forEach( System.out :: print );
        System.out.println("\n--------------------------------------------------------");

        // - LinkedList implements List and Deque interface.
        // - besides standard add() and addAll() methods you can
        // find addFirst() and addLast(), which adds an element in the
        // beginning or the end, respectively.
        citiesLL.addFirst("Mysore ");
        citiesLL.addLast("Dharwad ");
        System.out.println("citiesLL added - ");
        citiesLL.stream().forEach( System.out :: print );
        System.out.println("\n--------------------------------------------------------");

        // create an ArrayList and add it to the LinkedList
        List<String> newCitiesList = new ArrayList<>(
                Arrays.asList("Austin ", "Dallas ", "Houston ", "Austin ", "Dallas ", "Houston ") );
        citiesLL.addAll( newCitiesList );
        System.out.println("citiesLL addAll() - ");
        citiesLL.stream().forEach( System.out :: print );
        System.out.println("\n--------------------------------------------------------");

        //  removeFirst() and removeLast().
        // Also, there are removeFirstOccurence() and removeLastOccurence() which removes
        // the element if the collection contained it, and returns  boolean (true)
        citiesLL.removeLastOccurrence("Austin ");
        System.out.println("citiesLL.removeLastOccurrence(\"Austin\") ");
        citiesLL.stream().forEach( System.out :: print );
        System.out.println("\n--------------------------------------------------------");

        citiesLL.removeFirstOccurrence("Dallas ");
        System.out.println("citiesLL.removeFirstOccurrence(\"Dallas\") ");
        citiesLL.stream().forEach( System.out :: print );
        System.out.println("\n--------------------------------------------------------");

        /* Queue Operations
        Deque interface provides queue-like behaviors (actually Deque extends Queue interface):
        the offer() and poll() methods make LinkedList to work as a Queue.
        These methods retrieve the first element and remove it from the list.
         - poll() --->  retrieves and removes the head (first element) of this list,
                        throws NoSuchElementException() on empty list
         - pop() ---> returns null if this list is empty.
         - poll() ---> Retrieves and removes the first element of this list
         - pollFirst() ---> Retrieves and removes the first element of this list,
                            OR returns NULL if this list is empty.
         - pollLast() ---> Retrieves and removes the last element of this list,
                           OR returns NULL if this list is empty.
         - descendingIterator() ----> returns an iterator over the elements in this deque in
                                      reverse sequential order.
          */

        System.out.println("citiesLL.poll() removes and returns the 1st element = " +
                                                                    citiesLL.poll() );
        citiesLL.stream().forEach( System.out :: print );
        System.out.println("\n--------------------------------------------------------");

        System.out.println("citiesLL.descendingIterator() = " );
        Iterator descIter =  citiesLL.descendingIterator();
        while( descIter.hasNext() )
            System.out.println( descIter.next() );
        System.out.println("\n--------------------------------------------------------");
        /*
         Stack operations
         - 	pop() Pops an element from the stack represented by this list.
         -	push(E e)  inserts the element as the head of the collection
                       ( as a stack representation of this list )
         - peek etc only retrieve but DO NOT remove
         */

        // ---- list.sort() for sorting
        // Comparator.comparing() to sort in ascending order based on the length of the strings
        System.out.println("Comparator.comparingInt( String :: length ) ascending = " );
        Collections.sort( citiesLL, Comparator.comparingInt( String :: length ) );
        citiesLL.stream().forEach( System.out :: print );

        System.out.println("\n\nComparator.comparingInt( String :: length ) descending = " );
        Collections.sort( citiesLL, Comparator.comparingInt( String :: length ).reversed() );
        citiesLL.stream().forEach( System.out :: print );
    }
}
