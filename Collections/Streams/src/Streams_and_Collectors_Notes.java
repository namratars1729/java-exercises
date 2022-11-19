/*

public static List<Person> createPeople() {
    return List.of(
         new Person("Sara", 20),
         new Person("Nancy", 23),
         new Person("Bob", 20),
         new Person("Paula", 32),
         new Person("Paul", 3),
         new Person("Paul", 39),
         new Person("Jack", 72),
         new Person("Bill", 11),
         new Person("Jill", 19),
         new Person("Jill", 56),
    );
}

----- map transforms each element ------------
- map
  It applies its argument, a Function<T, R>, and returns a Stream<R>
  It is an intermediate stream operation that transforms each element.

- map vs. mapping
  map --> when you do the transformation in the stream itself
  mapping --> when you do the transformation in the middle of a reduce operation
              i.e inside collect

- flatMap().stream()
  Sometimes the mapping function will return an arbitrary number of results,
  wrapped in another type, like java.util.List
  We want to work on the list’s content, not the list itself.
  By using flatMap, we can map the Stream<List<String>> to a Stream<String>

  For Eg. a 1-to-1 mapping will give you 1 output for 1 input
      For instance, 1 Person - 1 firstname
           numbersList.stream()              // numbersList = [1,2,3,4,5]
                .map( num -> num * 2 )
                .collect( toList() )   // [2,4,6,8,10]
     i.e Stream<T> ==> Stream<T>

  However, a 1-to-many mapping will give you many outputs for each input
  For instance, when you want All the email addresses of a Person i.e a List of List of emailIDs
     numbersList.stream()              // numbersList = [1,2,3,4,5]
                .map( num -> List.of( num * 2, num * 3, num * 4 )
                .collect( toList() )   // [ [2,3,4], [2,6,8], [3,6,9], [4,8,12], [5,10,15] ]
      i.e Stream<T> ==> Stream< List<T> >

  I don't want a List of List of emails.....I want a single list of emails

  Use flatMap().stream()
        numbersList.stream()              // numbersList = [1,2,3,4,5]
                .flatMap( num -> List.of( num * 2, num * 3, num * 4 ).stream()
                .collect( toList() )   // [ 2,3,4, 2,6,8, 3,6,9, 4,8,12, 5,10,15 ]

  Conclusion:
  use map() when:
  - a 1-to-1 mapping will give you 1 output for 1 input in a single collection
    i.e Stream<T> ==> Stream<R>
  - a 1-to-many mapping will give you many outputs for each input in a nested collection
    i.e Stream<T> ==> Stream< List<R> >

  use fatMap().stream() when:
  - a 1-to-many mapping will give you many outputs for each input in a single collection
    i.e Stream<T> ==> Stream<<R>

- flatMap().stream() vs flatMapping.stream()
  flatMap().stream() --> when you do the flatMap() in the stream itself
  flatMapping.stream() --> when you do the flatMap() in the middle of a reduce operation
                           i.e, inside collect

   // all the character's of a Person's Name who are of the same age
         createPeople.stream()
         .collect( Collectors.groupBy( Person::getAge,
                                       Collectors.mapping( Person::getName,
                                                           Collectors.flatMapping(
                                                                name -> Stream.of( name.split( "" ))),
                                                           toList()
                                                          )
                                     )
                  );
         .




------ filter ---------------------------------
- filter
  For filtering elements
  If the predicate returns true, the elements will travel further down the
  stream
  To filter by false: (Java 11)
      .filter(Predicate.not(value -> value % 2L == 0))
  -------
      // Helper class for Java < 11
  class StreamHelpers {
    static <T> Predicate<T> not(Predicate<? super T> predicate) {
        Objects.requireNonNull(predicate);
        return (Predicate<T>) predicate.negate();
    }
  }
  // How to use it in our code
  List.of(1L, 2L, 3L, 5L, 8L, 13L)
    .stream()
    .filter(StreamHelpers.not(value -> value % 2L == 0))  // The helper class could also be
                                                          //import static, so we can
                                                          // omit StreamHelpers
    .forEach(System.out::println);
  ----------
https://belief-driven-design.com/functional-programm-with-java-map-filter-reduce-77e479bd73e/

- filter vs filtering
  filter --> when you do the transformation in the stream itself
  filtering --> when you do the filtering in the middle of a reduce operation
                i.e inside collect

  Eg.
       createPeople.stream()
             .collect(
                 Collectors.groupingBy(
                                        Person::Age,
                                        Collectors.mapping( Person::getName,
                                                            Collectors.filtering(name -> name.length() > 4),
                                                            toList()
                                                           )
                                      )
             )

------------------------------- reduce -----------------------------------------------------------
reduce, collect, sum, max, min etc are all reduce operations

------------------------- Using Optional ----------------------------------------------------------

    Map<String, String> books = new HashMap<>();
    books.put( "978-0201633610", "Design patterns");
    books.put( "978-1617291999", "Java 8 in Action");
    books.put("978-0134685991", "Effective Java");   // there is only 1 title

Say we are interested in finding the ISBN for the book titled “Effective Java”
This book may or not be present.
In such cases use Optional:
    Optional<String> optionalISBN = books.entrySet().stream()
                                       .filter( entry -> entry.getValue().equals("Effective Java")
                                       .map(Map.Entry :: getKey)
                                       .findFirst()
    // if there are more than 1 titles, collect the stream to a Collection like list
-----------------------------------------------------------------------------------------------------

- Collect toMap( a key function, a value function )

- If we are asked to get all the age values and make sure that it is immutable
  i.e the ageList cannot be changed.....collect to an UnModifiableList()/ or Set/ or Map

- - joining
  Say we want to comma separated list of names in uppercase, of people older than 30
        createPeople().stream()
        .filter( person -> person.getAge() > 30 )
        .map(Person::getName)
        .map(String::toUpperCase)
        .collect( joining(',') )

- Collector
  A Collector's job is to take the values that are given from a stream()
  and collect it into a data structure.
  It contains 3 parametric arguments i.e Collector< T,A,R >
        - T is the object you are dealing with
        - A is the accumulator that takes the values
        - R is used to join the various values (used in concurrency)

-------------partitioningBy ---------------------------------------------------------------------
  Partitions into only 2 groups
  Will always return a Map with two entries, one for where the predicate is true
  and one for where it is false
  Will return a map whose key is always a Boolean value
  It is possible that both entries will have empty lists, but they will exist.
  At the extreme case, if you send an empty stream to partitioningBy you will
  still get two entries in the map

    2 overloaded constructors:
  - takes only a predicate as a parameter
       partitioningBy(Predicate<? super T> predicate)
  - takes both predicate and a collector instance as parameters
       partitioningBy( Predicate<? super T>predicate,
                       Collector<? super T, A, D> downstream)

   Say we want 2 separate collections of people, those with even numbered age and
   those with odd numbered age
        createPeople().stream()
        .collect(Collectors.partitioningBy( person -> person.getAge() % 2 == 0 ))

    - Collectors.counting() method to count the number of elements in the 2 partitions
        createPeople().stream()
        .collect(Collectors.partitioningBy( person -> person.getAge() % 2 == 0 )),
                                            Collectors.counting() )

------------------- groupingBy -----------------------------------------------------------------------
https://www.baeldung.com/java-groupingby-collector
https://stackabuse.com/java-8-streams-definitive-guide-to-partitioningby/

  Groups objects by some given property and stores the results in a Map instance.
  Can have multiple groups
  Returns a Map, the key can be of any Object type, and a list of values
        Map<String, List<Employee>> employeesByCity = employees.stream()
                                 .collect( Collectors.groupingBy(Employee::getCity));

        Output: {New York=[Charles], Hong Kong=[Dorothy], London=[Alice, Bob]}

     3 overloaded constructors:
     - groupingBy(Function) ==> returns a Collector which makes a Map<K, List<T>>
            Function - a classification function which maps elements to a key of type K
            Collector makes a Map whose keys are the values resulting from applying the
            classification function on the input elements.

     - When just grouping isn't quite enough, you can also supply a downstream collector
       groupingBy(Function, Collector)
       Function  - a mapper/classifier to be applied to the input elements and
       Collector – a downstream collector which will accept mapped values
       ==> returns a Collector that groups the input elements according to the
           classification function, afterwards applying a reduction operation on the
           values using the specified downstream Collector.

           Say we want to group the people by their ages i.e,get all the same age people
            createPeople().stream()    //  <----- Stream<Person>
                      .map( Person :: getAge )    // get all the ages <----- Stream<Integer>
                   // at this point, we lost the Person object, so we don't have access
                   // to say the name of the Person
                  // we only have the age (Integer)
                 // map is therefore a reduce operation and we don't want it so early in the process
           // We want map( Person :: getAge )  right in the middle of a reduce
           // because we want to process the name first and then perform the map( Person :: getAge )

           Eg. to group by city, and then names of people that belong to each city as a List
           Collectors.mapping() adapts a collector accepting elements of one type to accept
           a different type by applying a mapping function to each input element before
           accumulation. In our case, we'll map each Student to their name

           Here, Collector groupingBy takes a Function getCity() and another Collector mapping
           which takes another Function getName() and Collector toList()
           i.e Collector(Function, Collector( Function, Collector) )

           Map<String, List<String> studentsByCity =
                    studentsList.stream()
                                .collect( Collectors.groupingBy(
                                                Student::getCity,
                                                Collectors.mapping( Student::getName,
                                                                    Collectors.toList()
                                                                   )
                                                )
                                         );



       - Collectors.groupingBy() with a Classification Function, Downstream Collector and Supplier
         To allow multiple groupingBy
             groupingBy(Function<? super T,? extends K> classifier,
                        Supplier<M> mapFactory,
                        Collector<? super T,A,D> downstream )
            Supplier - method provides the specific Map implementation we want to use to
                       contain our end result
            ==> returns a Collector that:
                       1) groups the input elements according to the classification function,
                       2) afterwards applies a reduction operation on the values associated with a
                          given key using the specified downstream Collector.
                       3) Meanwhile, the Map is implemented using the supplied mapFactory supplier.

            Eg,
            Map<String, List<String>> namesByCity = students.stream()
                        .collect(Collectors.groupingBy(
                                Student::getCity,
                                TreeMap::new,
                                Collectors.mapping(Student::getName, Collectors.toList())));


------------- CollectingAndThen() -------------------------------------------------------------------------------

collectingAndThen( Collector, Function that operates on the Collector )

collectingAndThen() can be used to chain Collectors


If you want a count of the grouped values, use:
    Collectors.counting()
which returns a Long. What if we want an Integer?

Eg.
groupingBy returns a Collector.
Take the Collector returned by the groupingBy, AND THEN
                   - count the number of elements in it using Collectors.counting() and
                   - apply a function that returns an Integer value of each Long value
                     returned by Collectors.counting()

Map<String, Integer> countByName =
               createPeople().stream()
                    .collect( Collectors.groupBy( People::getCity,
                                                  Collectors.collectingAndThen( Collectors.counting(),
                                                                                Long :: intValue
                                                                               )
                                                )
                             );

The format is:
stream.collect(groupingBy(
        groupingBy(
            collectingAndThen(
                downstream,
                finisher
            )
        )
    )
);

----------------- maxBy and minBy -----------------------------------------------------------------------------

min and max can be used as a reduce operation only for an Integer stream
However, the collection/stream could also be empty.
Therefore max() and min() will return an OptionalInt, while sum() will
return 0 (sum of an empty stream)

What if we are not interested in the Integer values but in say, the Person itself?
i.e, the Person object with the max/min age?
Like....the Person who has worked the longest time, or the Person who is the youngest

That's where maxBy or minBy come in.
maxBy applies a comparison. Therefore, you need to apply a Comparator to it.
maxBy is also a collect/reduce operation

      maxBy(Comparator) ==> returns the maximum (or minimum for minBy()) value
                            of all the elements of the stream as an Optional value
                            This is because in case the stream has no elements then
                            to avoid sending a bare null value which can result in a
                            NullPointerException, the value is sent as an Optional.

Eg.
        String maxSalaryEmp =
            employeeList.stream()
            .collect( Collectors.collectingAndThen(
                         Collectors.maxBy( Comparator.comparing(Employee::getSalary)), // <===== Optional<Employee>
                         person => person.map( Person::getName)
                                         .orElse("")
                     )
             );
       System.out.println("Employee with max salary = " + maxSalaryEmp
            + (maxSalaryEmp.isPresent()? maxSalaryEmp : "Not Applicable"));
      ----------------------------------------------------
       Optional<Employee> minAgeEmp =
            employeeList.stream()
            .collect(Collectors.minBy( Comparator.comparing(Employee::getAge)) );

       System.out.println("Employee with min age:"
            + (minAgeEmp.isPresent()? minAgeEmp:"Not Applicable"));

-------------------- Collectors.averagingInt(), averagingDouble*() and averagingLong() ------------------------------------------

The ToIntFunction, ToDoubleFunction and ToLongFunction from java.util.function
enable us to perform conversions (reductions) from object types to their
primitive int, double or long fields.

The averaging methods returns a Collector that produces the arithmetic mean of an
integer/double.long-valued function applied to the input elements and
get the intValue/doubleValue/longValue through a method reference

Eg:
List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
Double average = numbers.stream()
                        .collect( Collectors.averagingInt(Integer::intValue) );
-------------
Double averageAge = students.stream()
                            .collect( Collectors.averagingInt(Student::getAge) );

--------------------- teeing ----------------------------------------------------------------------------------------

Allows you to combine 2 Collectors

groupingBy and mapping allowed us to take a Function and combine with a Collector - ( Function, Collector )
comparingAndThen allowed us to take a Collector and a Function - ( Collector, Function )

teeing allows us to take 2 Collectors which are evaluated separately and merged based on an operation
- ( Collector, Collector, operation which is a BiFunction )











 */