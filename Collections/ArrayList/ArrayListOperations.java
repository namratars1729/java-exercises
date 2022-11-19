import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ArrayListOperations{
    public static void main(String[] args) {

        // Declare and initialize an ArrayList
        // List is an interface, and ArrayList is an implementing class.
        //It's almost always preferable to code against the interface
        // and NOT the implementation.
        //This way, if you need to change the implementation later, it won't break
        // consumers who code against the interface.

        //Therefore, you should declare it as a List<T>, and initialize it as an ArrayList<T>.

        //------ 1) An empty ArrayList
        List<Integer> emptyArrayList = new ArrayList<>();

        //------ 2a) An ArrayList with a specified size (it can grow or shrink later)
        List<String> withSizeList = new ArrayList<>(5);

        // ------ b) ArrayList(Collection c)
        // An ArrayList initialized with the elements from any other Collection c.
        // This is useful to convert other List implementations to the ArrayList.

        // ------ c) using Arrays.asList() method
        //The asList() method of Arrays class converts an array to a MUTABLE ArrayList.
        List<String> arrAsList = new ArrayList<>(
                Arrays.asList("Basketball", "Cricket", "Hockey")
        );

        // ------ d) Anonymous inner class method
        List<Integer> annIntList = new ArrayList<>() {
            {
                add(1);
                add(5);
                add(2);
                add(9);
                add(5);
                add(8);
                add(11);
                add(2);
                add(3);
            }
        };

        // make a copy for other manipulations
        List<Integer> copyIntList = annIntList;

        // --------- e) with multiple same elements using Collections.ncopies()
        // an ArrayList of 10 elements that are all 999
        List<Integer> sameElementsList = new ArrayList<>(Collections.nCopies(10, 999));

        // --------- f) Immutable Singleton List i.e a fixed List with only 1 element
        // (trying to change it will cause an UnsupportedOperationException exception to be thrown).
        List<String> singletonList = new ArrayList<>(Collections.singletonList("I AM IMMUTABLE"));

        /*------------------- Add Methods
        1.	boolean add(Object o): is used to append a specified element to the end of a list.
        2.	void add(int index, Object element): is used to insert a specific element at a specific
            position index in a list.
        3.	boolean addAll(int index, Collection C): is used to insert all the elements from a specific
            Collection starting at the specified position into our ArrayList.
        4.	boolean addAll(Collection C):  is used to append all the elements from a specific collection
            to the end of the mentioned list, in such a order that the values are returned by the specified
            collection’s iterator.
         */

        // ---------- insert elements
        System.out.println("\nInitial arrAsList = " + arrAsList );

        arrAsList.add("Basketball");
        arrAsList.add( null );
        System.out.println("arrAsList can have duplicates and null = " + arrAsList );

        arrAsList.add( 1, "Soccer");
        System.out.println("\nAfter adding Soccer at index 1, arrAsList = " + arrAsList );

        // ---------- sublist --------------------------------------------------
        /*
        The subList method throws
        - IndexOutOfBoundsException – if the specified indexes are out of the
          range of ArrayList (fromIndex < 0 || toIndex > size).
        - IllegalArgumentException – if the starting index is greater than the
          end point index (fromIndex > toIndex).
         */

        // populate the emptyArrayList
        emptyArrayList.add(-999);
        emptyArrayList.add( 111 );
        emptyArrayList.add( 737);

            //Storing the sublist into another ArrayList
        try {
            System.out.println("\nInitial emptyArrayList = " + emptyArrayList );

            List<Integer> subArrList = annIntList.subList(2, annIntList.size() - 2);
            System.out.println("subArrList = " + subArrList );

            // add the sublist to emptyArrayList
            emptyArrayList.addAll( subArrList );

            System.out.println("After adding subArrList = " + emptyArrayList );

            // containsAll(Collection c)
            System.out.println("\nemptyArrayList contains subArrList = " +
                    emptyArrayList.containsAll( subArrList ) );

            // removeIf (Predicate<? super E> filter): removes all of the elements
            // of this collection that satisfy the given predicate.
            //  NullPointerException if predicate is null.
            System.out.println("\nInitial annIntList = " + annIntList);
            annIntList.removeIf( ( num ) -> num * num > 30 );
            System.out.println("After filtering annIntList = " + annIntList);

            // filter using streams
            System.out.println("\nInitial copyIntList = " + copyIntList);
            System.out.println("After filtering copyIntList = " );
            copyIntList.stream()
                    .filter( ( num ) -> num + 5 > 7 )
                    .forEach( System.out:: println );

        }
        catch (IndexOutOfBoundsException | IllegalArgumentException | NullPointerException e) {
                System.out.println("Exception while getting sublist: " + e);
        }
    }
}
