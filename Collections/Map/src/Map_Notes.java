/*
There are two interfaces for implementing Map in java.
They are Map and SortedMap,
and three classes:
- HashMap ( allows null values ),
- LinkedHashMap ( allows null values ), and
- TreeMap ( no null values )

The Map interface represents a mapping between a key and a value

The Java Map interface is NOT a subtype of the Collection interface.
Therefore, it behaves a bit different from the rest of the collection types.

The Java Collections API contains the following Map implementations:

java.util.HashMap
java.util.Hashtable
java.util.EnumMap
java.util.IdentityHashMap
java.util.LinkedHashMap
java.util.Properties
java.util.TreeMap
java.util.WeakHashMap

The most commonly used Map implementations are HashMap and TreeMap.

HashMap maps a key and a value.
It does not guarantee any order of the elements stored internally in the map.

TreeMap also maps a key and a value.
Furthermore, it guarantees the order in which keys or values are
iterated - which is the sort order of the keys or values.

---------- Create a Map

Map<String, Integer> map = new HashMap<String, Integer>();

This Map can now only accept String objects for keys,
and Integer instances for values.

---------- Access and iterate keys and values

for(String key : map.keySet() ){    // get keys
   Integer intValue = map.get(key);
}

for(Integer intObject : map.values() ){  // get values
   System.out.print( intObject )
}

------- Inserting elements into a Map ( use "put" )
To add elements to a Map you call its put() method

map.put("key1", "element 1");
map.put("key2", "element 2");
map.put("key3", "element 3");

------ Autoboxing primitive types
Only Java objects can be used as keys and values in a Java Map.
In case you pass primitive values (e.g. int, double etc.) to a Map as key or
value, the primitive values will be auto-boxed before being passed as parameters.
Eg.,
map.put("key", 123);
The value passed to the put() method is a primitive int.
Java auto-boxes it inside an Integer instance though, because the put() method
requires an Object instance as both key and value.
Auto-boxing would also happen if you passed a primitive as key to the put() method.

------ can have null as a key and as a value
eg.,
map.put(null, "NULL value");  // key is null
String value = map.get(null);

map.put("D", null); // value is null
Object value = map.get("D"); // null
                            // get returns an Object, so cast it appropriately

------ Inserting all the elements from another map ( use "putAll" )
mapB will contain mapB + mapA elements
mapB.putAll(mapA);

----- Get elements from a Map ( "get" returns an Object, so cast it if not using Generics )
Eg.,
Map map = new HashMap();  // without Generics
map.put("key1", "value 1");
String element1 = (String) map.get("key1");

Map<String, String> map = new HashMap<>(); // with Generics
map.put("key1", "value 1");
String element1 = map.get("key1");

--------- getOrDefault()
returns a default value supplied by you - in case no value is stored in the Map
by the given key.

Map<String, String> map = new HashMap<>();
map.put("A", "1");
map.put("B", "2");
map.put("C", "3");
String value = map.getOrDefault("E", "default value");

-------- Map contains a specific key ( using containsKey() )
boolean hasKey = map.containsKey("123"); // true or false

-------- Map contains a certain value( using containsValue() )
boolean hasValue = map.containsValue("value 1"); // true or false

-------- get a set view or create a new set from the map ( using entrySet() )
map.entrySet()

-------- Iterating the Keys and values
- Via the key Iterator ( or values iterator )
Iterator<String> iterator = map.keySet().iterator(); // or map.values().iterator()
while(iterator.hasNext(){
  String key   = iterator.next();
  String value = map.get(key);
}

- Via the for-each loop
for(String key : map.keySet()) {  // or map.values()
    String value = map.get(key);
}

- Via a Stream
Stream<String> stream = map.keySet().stream(); // or map.values().stream()
stream.forEach( System.out :: println );

-------- Iterating the Entries of a Map ( a key + value pair is called an entry )
We can iterate both the keys and the values at the same time:
- Using an Entry Iterator
  an entry Iterator obtained from the entrySet

Set< Map.Entry<String, String> > entries = map.entrySet();
Iterator< Map.Entry<String, String> > iterator = entries.iterator();

while(iterator.hasNext()) {
    Map.Entry<String, String> entry = iterator.next();
    String key   = entry.getKey();
    String value = entry.getValue();
}

- Using the for-each loop
for( Map.Entry<String, String> entry : map.entrySet() ){
    String key = entry.getKey();
    String value = entry.getValue();
}

-------- Removing Entries ( using remove( name-of-key ) )
map.remove("key1"); // mapA will no longer contain an entry (key + value pair)
                    // for the key key1.

------- Removing All Entries ( clear() )
mapA.clear()

------- Replacing an Entry, only if the key/entry exists
map.replace("key", "val2"); //no "key" entry, no replace
map.put("key", "val1");     //now contains "key" entry
map.replace("key", "val2"); //now "key" entry replaced

--------  check for equality between two maps ( equals() )
mapA.equals(mapB)

--------------------- Functional Operations ----------------------------------------------------
- compute()
takes a key object and a lambda expression as parameters.
The lambda expression must implement the java.util.function.BiFunction interface.
i.e. it must contain 2 arguments - key and value

Eg. no key -> null mapping stored in the Map.
If the lambda expression returns null, the entry is removed.
If an exception is thrown by the lambda expression, the entry is removed.

map.compute( "123", (key, value) ->
                   value == null ? null : value.toString().toUpperCase() );

- computeIfAbsent()
only called if no entry exists for the given key.
The value returned by the lambda expression is inserted into the Map.
If the lambda expression returns null, no entry is inserted.
If an exception is thrown by the lambda expression, no entry is inserted either.

map.computeIfAbsent("123", (key) -> "abc");  // insert "123"

The lambda expression can calculate the value in any way
e.g. extract the value from another object, or concatenate it from other values etc.

- computeIfPresent()
only called if an entry already exists in the Map for that key
The value returned by the lambda expression will be inserted into the Map instance.
If the lambda expression returns null, the entry for the given key is removed.
If the lambda expression throws an exception, the exception is rethrown,
and the current entry for the given key is left unchanged.

- merge()
The Map merge() method takes a key, a value, and a lambda expression implementing
the BiFunction interface as parameters.

If the Map does not have an entry for the key, or if the value for the key is null,
the value passed as parameter to the merge() method is inserted for the given key.
If, however, the given key has a value, the lambda expression passed as parameter
is called. The value returned by the lambda expression is then concatenated into
the Map for the given key.
The lambda expression thus gets a chance to merge the existing value with a new value.
If the lambda expression returns null, the entry for the given key is removed.
If an exception is thrown by the lambda expression, the exception is rethrown,
and the current mapping for the given key is kept unchanged.

map.merge("123", "XYZ",
    (oldValue, newValue) -> newValue + "-abc");

insert the value XYZ into the Map if no value is mapped to the key (123),
or if null is mapped to the key
If the key already has a value, the lambda expression is called.
The lambda expression returns the new value (XYZ) + the value -abc, i.e. XYZ-abc

================== Examples of using Aggregate Functions ============================

---- Group employees by department
Map<Department, List<Employee>> byDept = employees.stream()
                          .collect(Collectors.groupingBy(Employee::getDepartment));

---- compute the sum of all salaries by department:
Map<Department, Integer> totalByDept = employees.stream()
          .collect(Collectors.groupingBy(
                               Employee::getDepartment,
                               Collectors.summingInt(Employee::getSalary) ) );

---- group students by passing or failing grades:
// Partition students into passing and failing
Map<Boolean, List<Student>> passingFailing = students.stream()
                  .collect(Collectors.partitioningBy(
                                     s -> s.getGrade() >= PASS_THRESHOLD) );

----  group people by city:
// Classify Person objects by city
Map<String, List<Person>> peopleByCity =
                 personStream.collect(Collectors.groupingBy(Person::getCity));

----  cascade two collectors to classify people by state and city:
// Cascade Collectors
Map<String, Map<String, List<Person>>> peopleByStateAndCity
  = personStream.collect(Collectors.groupingBy(Person::getState,
                         Collectors.groupingBy(Person::getCity) ) )p


============================ SortedMap interface ==========================================================
SortedMap interface, java.util.SortedMap, is a sub-interface of the Java Map interface.

- Sort Order
    Natural ordering is ascending
    For descending order - TreeMap.descendingKeySet()

- Iterating
  Iterator iterator = sortedMap.keySet().iterator(); OR
  Iterator iterator = sortedMap.descendingKeySet().iterator();
    while(iterator.hasNext()) {
    String key = iterator.next();
    String value = sortedMap.get(key);
  }

- Get Comparator Used
  If your Java SortedMap was created using a Comparator, you can obtain the
  Comparator used via the SortedMap comparator() method
    Comparator comparator = sortedMap.comparator();

- Get First Key
  the lowest/first key if sorted in ascending order
  the highest/first key if sorted in descending order
    String firstKey = sortedMap.firstKey();

- Get Last Key
  the highest/last key if sorted in ascending order
  the lowest/last key if sorted in descending order
    String firstKey = sortedMap.lastKey();

- Head Map
  returns a new Map which contains the first elements of the SortedMap according to the sort order used.
      sortedMap.put("a", "1");
      sortedMap.put("c", "3");
      sortedMap.put("e", "5");
      sortedMap.put("d", "4");
      sortedMap.put("b", "2");

      SortedMap headMap = sortedMap.headMap("c");
      System.out.println(headMap); //   ("a", "1") and ("b", "2")

- Tail Map
  returns a new Map which contains the last elements of the SortedMap according to the sort order used.
    sortedMap.put("a", "1");
    sortedMap.put("c", "3");
    sortedMap.put("e", "5");
    sortedMap.put("d", "4");
    sortedMap.put("b", "2");

    SortedMap tailMap = sortedMap.tailMap("c");    // ("c", "3"), ("d", "4") and ("e", "5")
    System.out.println(tailMap);

- Submap
  returns a new Map which is a submap of the SortedMap.
  The subMap() method takes two parameters which act as delimiters for what elements are
  included in the returned submap.
    sortedMap.put("a", "1");
    sortedMap.put("c", "3");
    sortedMap.put("e", "5");
    sortedMap.put("d", "4");
    sortedMap.put("b", "2");

    SortedMap subMap = sortedMap.subMap("b", "e");
    System.out.println(subMap);  // ("b", "2), ("c", "3") and ("d", "4")

=======================NavigableMap interface and TreeMap class ==============================================================

NavigableMap interface, java.util.NavigableMap, is a sub-interface of the Java SortedMap interface.
The java.util package only has one implementation of the NavigableMap interface:
java.util.TreeMap class

- Constructor
  - SortedMap<String, Integer> = new TreeMap<>()  // keys sorted according to the natural ordering
  - SortedMap<String, Integer> = new TreeMap<>( Comparator Object )  // Comparator will be used to
                                                                     // sort the keys of the entries

- descendingKeySet()
  The descendingKeySet() method returns a NavigableSet in which the order of the elements
  is reversed compared to the original key set.
  The returned "view" is backed by the original NavigableSet key Set, so changes to the
  descending key Set are also reflected in the original set.
    NavigableSet reverse = map.descendingKeySet();

- descendingMap()
  The descendingMap() method returns a NavigableMap which is a view of the original Map.
  The order of the elements in this view map is reverse of the order of the original map.
  Being a view of the original map, any changes to this view is also reflected in the original map.
    NavigableMap descending = map.descendingMap();

- ceilingKey()
  The ceilingKey() method returns the least (smallest) key in this map that is greater
  than or equal to the element passed as parameter to the ceilingKey() method.
        s.put(2,"Welcome");
        s.put(12,"to");
        s.put(31,"Educative.io");
        s.put(18,"Learn");
        s.put(25,"Coding");
        s.put(36,"Java");
        System.out.println( s.ceilingKey(20) );  // 25
        System.out.println( s.ceilingKey(18) ); // 18

- floorKey()
  The, floorKey() returns the greatest key which is less than or equal to the parameter
  value passed to floorKey().

- higherKey()
  The higherKey() method returns the least (smallest) element in this map that is
  greater than ( NOT equal too) the element passed as parameter to the higherKey() method.
    original.put("1", "1");
    original.put("2", "2");
    original.put("3", "3");
    String higherKey = original.higherKey("2");  // "3"

- lowerKey()
  opposite of higherKey()

--------- methods to get the entry for a given key, rather than the key itself.
--------- They return a Map.Entry instead of the key object itself. ---------------------------------------------------

- ceilingEntry()
 The ceilingEntry() method returns the key + value stored for the least (smallest) key
 in the NavigableMap which is higher than or equal to the parameter value passed to
 the ceilingEntry() method

- floorEntry()
  The floorEntry() method returns the key + value for the greatest key which is
  equal to or lower than the parameter value passed to the floorEntry() method.

- higherEntry()
  The higherEntry() method returns the key + value stored for the smallest key that
  is higher than the parameter value passed to the higherEntry() method.
    original.put("a", "1");
    original.put("c", "3");
    original.put("e", "5");
    original.put("d", "4");
    original.put("b", "2");
    Map.Entry higherEntry = original.higherEntry("c"); // ("d", "4").

- lowerEntry()
  Opposite of higherEntry()

- pollFirstEntry()
  The pollFirstEntry() method returns and removes the "first" entry (key + value)
  in the NavigableMap or null if the map is empty.
  "First" means smallest element according to the sort order of the keys
    Map.Entry first = original.pollFirstEntry(); //first is ("a", "1")

- pollLastEntry()
  opposite of pollFirstEntry()




 */
