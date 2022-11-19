import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/*
HashSet<E>

Direct Known Subclasses:
            - JobStateReasons,
            - LinkedHashSet

- A HashSet is an unordered and unsorted implementation of the Set<E> interface
  It DOES NOT maintain insertion order.

- Allows only unique elements ( no duplicates )

- Permits the null element

- It determines whether an object is unique based on the equals() of the object
  The equivalence between objects is based on the equals() and the hashCode() methods

  The equals() method of the Object class is inadequate as it simply compares
  the objects by reference. i.e. by its memory location or the memory address
  of the two objects, rather than the attributes of two objects.
  i.e the equals() method does not check what is stored inside the Object.
      It only checks if two objects belongs to the same memory location.

  Eg, Human human1 = new Human(21,"Sham");
      Human human2 = new Human(42,"Paul");  // different memory location
      Human human3 = new Human(42, "Paul); // different memory location, but the attributes
                                              are same as human2
      human2.equals(human3) will return false because memory addresses are different

  We NEED TO OVERRIDE THE EQUALS(), so that the Set implementation can
  test for equality and duplication.
  i.e it checks for equality of the attributes ( what is stored inside the object)

  Eg, choose the id as the distinguishing feature. We override equals() to return true
  if two books have the same id.  Two books are equal if they have the same id
  The equals method must accept an item of type Object.
  The body of the method then needs to type cast this item back to the required
  type (Book in this case)
                   @Override
                   public boolean equals(Object o) {
                      return o != null && o instanceof Book && this.id == ((Book)o).id;
                   }

  Similarly, the hashCode() of the Object class generates the hashCode
  number from the memory address of the object, so two “equal” objects could have
  different hashCode values. T
            // create two "equal" books
        Book b1 = new Book("9999999999", "Clowning Around", "Joe King");
        Book b2 = new Book("9999999999", "Clowning Around", "Joe King");
        // check their hashCode numbers
        System.out.println(b1.hashCode()); // 1044036744
        System.out.println(b2.hashCode()); // 1826771953

  We ALSO NEED TO OVERRIDE THE HASHCODE() to be consistent with equals() since two objects
  which are equal have the same hash code.
               // To be consistent with equals(). Two objects which are equal have the same hash code.
               @Override
               public int hashCode() {
                  return id.hashcode();
               }
- It is backed by a hash table using a HashMap instance.
  i.e. it stores the elements in a hash table ( hashed via the hashcode() ).
  When an instance of the HashSet is created, this internal HashMap gets initialized:

        public HashSet() {
            map = new HashMap<>();
        }

- The hashcode of the object being inserted into the collection is used, so the more
  efficient your override of the hashCode() method of the Object class is, the more
  efficient the HashSet.

- this implementation is not synchronized.

- This type of set makes no guarantees over iteration order and in particular no
  guarantees that the iteration order will remain constant over time.

- If you want to find out if an object exists within the set, or if you want to
  delete an object from the set, then you need a reference to the object in question.
  HashSet does not have any method to retrieve the object from the HashSet.
  The only way to get objects from the HashSet is via Iterator.

- The addAll() and retainAll() perform set union and set intersection operations, respectively.

Internal working of a HashSet
-------------------------------
It'd be a good idea to get familiar with the hashcode first to get a detailed understanding
of how the elements are organized in hash-based data structures.
- A HashMap is an array of buckets with a default capacity of 16 elements.
  Each bucket corresponds to a different hashcode value
- If various objects have the same hashcode value, they get stored in a single bucket
- If the load factor is reached, a new array gets created twice the size of the previous
  one and all elements get rehashed and redistributed among new corresponding buckets
- To retrieve a value, we hash a key, mod it, and then go to a corresponding bucket and
  search through the potential linked list in case of there's more than a one object

How HashSet Maintains Uniqueness?
--------------------------------
- When we put an object into a HashSet, it uses the object's hashcode value to determine if
  an element is not in the set already.
- Each hash code value corresponds to a certain bucket location which can contain various
  elements, for which the calculated hash value is the same.
- However, TWO OBJECTS WITH THE SAME HASHCODE MAY NOT BE EQUAL
- Therefore, objects within the same bucket will be compared using the equals() method.

Performance of HashSet
-----------------------
The performance of a HashSet is affected mainly by two parameters:
- its Initial Capacity ( default initial capacity = 16 )
- the Load Factor ( default = 0.75 ) describes what is the maximum fill level, above which,
  a set will need to be resized

It is essential to maintain the right HashSet capacity.
- A low initial capacity reduces space complexity but increases the frequency
  of rehashing which is an expensive process.
- On the other hand, a high initial capacity increases the cost of iteration and the
  initial memory consumption.

As a rule of thumb:
- A high initial capacity is good for a large number of entries coupled with little to no iteration
- A low initial capacity is good for few entries with a lot of iteration

It's, therefore, very important to strike the correct balance between the two.
Usually, the default implementation is optimized and works just fine.

 ---------------------------------------------------------------------------------------------------- */
/*
In the UK, the first letter of the registration number was at one time used to
determine the time period when the vehicle came to market.
A registration beginning with ‘S’, for example, denoted a vehicle that came to
market between August 1998 and February 1999, while a registration beginning
with ‘T’ denoted a vehicle that came to market between March 1999 and July 1999.

Iterate through the collection of registration numbers and display all
registrations after ‘T’.

 */
public class Main {
    public static void main(String[] args) {
        // Initializing HashSet at the Time of Construction using streams
        Set<String> regNumsSet =
                Stream.of("W79TRV", "V53PLS", "L22SBG", "S41IPLE", "XT11SAM")
                      .collect( Collectors.toCollection( HashSet :: new ) );

        regNumsSet.add("X85ADZ");
        regNumsSet.add("E16UEL");

        // make a copy of this set for later use
        Set<String> copyRegNumsSet =
                regNumsSet.stream()
                          .collect( Collectors.toCollection( HashSet :: new ) );

       // regNumsSet.add("CAT");

        System.out.println( "regNumsSet Before = " + regNumsSet );
        //System.out.println( "copyRegNumsSet Before = " + copyRegNumsSet );

        // create a Predicate<String> object which checks if the string is greater than  "T"
        Predicate<String> greaterThanT = reg -> reg.charAt( 0 ) > 'T';

        // iterate over the Hashset, filter and collect the stream to a new List
        List<String> filteredList = regNumsSet.stream()
                .filter( greaterThanT )
                .collect( Collectors.toCollection( ArrayList:: new ) );

        System.out.println( "Filtered List = " + filteredList );

        // we now wish to modify the original regNumSet so that registrations
        // prior or equal to ‘T’ are removed.
        // Use Iterator's forEachRemaining() and lambda expression
        Iterator<String> iter = regNumsSet.iterator();

        // the lambda expression is applied to each remaining item in the collection
        iter.forEachRemaining( reg -> {
                if ( reg.charAt(0) <= 'T')
                    iter.remove();
        } );

        System.out.println( "regNumsSet after = " + regNumsSet );

       // -----------------------------------------------------------------------

        // add some registration numbers ending with 'S
        copyRegNumsSet.addAll(
                Stream.of( "Y417NRS", "A45IXYS", "T999ZZS")
                      .collect( Collectors.toSet() ) );

        System.out.println( "\ncopyRegNumsSet Before = " + copyRegNumsSet );

        // display all registrations ending in ‘S’.
        Predicate<String> endsWithS = reg -> reg.endsWith("S") ;

        List<String> endsWithSList = copyRegNumsSet.stream()
                .filter( endsWithS )
                .collect( Collectors.toList() );

        System.out.println( "copyRegNumsSet ends with 'S' = " + endsWithSList );

        // remove those ending with "S"
        Iterator<String> iterS = copyRegNumsSet.iterator();
        iterS.forEachRemaining( reg -> {
            if ( reg.endsWith("S") )
                iterS.remove();
        });
        System.out.println( "copyRegNumsSet after = " + copyRegNumsSet );

    }
}