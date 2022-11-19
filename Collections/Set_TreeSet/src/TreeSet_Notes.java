/*

TreeSet no longer supports the addition of null.

--- create a TreeSet in 2 ways:
1) Set<String> treeSet = new TreeSet<>(); OR

2) Create a TreeSet With a Comparator
it possible to pass a Comparator, java.util.Comparator implementation to the constructor of the TreeSet.
This Comparator will then decide the sort order of the elements in the TreeSet.
Eg: Set<String> treeSet = new TreeSet<>( Comparator.comparing(String::length) );

If the elements do not implement the Comparable interface, the elements have no natural ordering.
In that case you must pass a Comparator implementation to the SortedSet when you create it.
Eg: Comparator comparator = new MyComparator();
    SortedSet sortedSet = new TreeSet(comparator);

--- SORT ORDER
By default the elements of a SortedSet are iterated in ascending order,
starting with the "smallest" and moving towards the "largest".
But it is also possible to iterate the elements in descending order using
the method TreeSet.descendingIterator(), OR
Set<String> treeSet = new TreeSet<>( Comparator.reversed());

---- Get Comparator Used
If you created your SortedSet with a Comparator, you can obtain that Comparator via the
SortedSet comparator() method.
Comparator comparator = sortedSet.comparator();

---- Get First Element ( and Last element similarly )
You can get the first element/last element of a SortedSet according to its sort order by calling
the first()/last() method of the SortedSet.
Object firstElement = sortedSet.first();
Object lastElement = sortedSet.last();

You can retrieve first element and last elements of the SortedSet.
You can’t access SortedSet elements randomly. i.e Random access is denied.

--- Get Head Set ( and Tail Set )
headSet() returns another SortedSet with all elements that are smaller than (ahead of)
a given parameter value, according to the sort order used by the SortedSet
tailSet() returns another SortedSet with all elements that are greater than or equal to (tailing)
a given parameter value,

SortedSet sortedSet = new TreeSet();
sortedSet.add("a");
sortedSet.add("b");
sortedSet.add("c");
sortedSet.add("d");
sortedSet.add("e");
SortedSet headSet = sortedSet.headSet("c"); // a,b since these two elements are smaller than
                                              (ahead of) the parameter value "c"
Sorted tailSet = sortedSet.tailSet("c"); // c,d,e

--- Get subset
SortedSet subSet = sortedSet.subSet("c", "e"); // c,d

SortedSets returned by headSet(), tailSet() and subSet() methods are just views of the original set.
So, changes in the returned set are reflected in the original set and vice versa.

 */