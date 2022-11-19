import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ListWithIterator {
    public static void main(String[] args) {
        //---- Declare a List<String> (List of String) implemented by an ArrayList<String>
        List<String> coffeeList = new ArrayList<>();

        // add elements to the List
        coffeeList.add("Latte");
        coffeeList.add("Cappuccino");
        coffeeList.add("Espresso");

        System.out.println("coffeeList = " + coffeeList + "\n");

        // ----- Use an Iterator<String> to traverse through all the elements
        // The standard Java collection interface Collection contains a method called iterator().
        // By calling iterator() you can obtain an iterator from the given Collection.
        Iterator<String> iterCoffeeList = coffeeList.iterator();
        String coffeeName;

        while( iterCoffeeList.hasNext() ){
            coffeeName = iterCoffeeList.next();
            System.out.println( coffeeName );
        }

        System.out.println( );

        // Use an enhanced for-each loop (JDK 5) to traverse through the list
        for( String coffee : coffeeList )
            System.out.println( coffee.toUpperCase() );

        System.out.println( );

        // A List supports numerical index access, where index begins at 0
        // Use a regular for loop
        for( int i = 0; i < coffeeList.size(); i++)
            System.out.println( coffeeList.get( i ).toLowerCase() );
    }

}
