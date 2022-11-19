///*
//
//Class Employee
//  - id, name, salary
//  + Employee( int, String, double )
//  + getId() : int
//  + getName() : String
//  + getSalary() : double
//  + setId( int ) : void
//  + setName( String) : void
//  + setSalary( double ) : void
//
//Complete the functions:
//displayEmployeesBySimpleForLoop(empList);
//displayEmployeesByIterator(empList);
//List<Employee> sortedNameSalaryEmpList = sortEmpByNameAndSalary(empList);
//List<Employee> sortedNameEmpList = sortEmpByName(empList);
//List<Employee> sortedSalaryEmpList = sortEmpBySalary(empList);
//int empId = 6;
//Employee empRemoved = removeById(empList, empId);
//HashMap<String, Employee> empMap = convertListToMap(empList);
//displayEmpMap(empMap);
//String nameOfTheEmp = "Mohit";
//removeByNameFromMap(empMap, nameOfTheEmp);
//List<Employee> empListWithoutDuplicate = removeDuplicateEntriesFromList(empList);
//private static void displayEmployeesByForEach(List<Employee> empList)
//private static void displayEmployeesByIterator(List<Employee> empList)
//
//// return a sorted list of employees by name and then salary
//private static List<Employee> sortEmpByNameAndSalary(List<Employee> empList)
//
//private static List<Employee> sortEmpBySalary(List<Employee> empList)
//private static List<Employee> sortEmpByName(List<Employee> empList)
//private static Employee removeById(List<Employee> empList, int empId)
//
//// Create a map using the list,keys = employee name, value = the employee object
//private static HashMap<String, Employee> convertListToMap(List<Employee> empList)
//
//// Iterate the whole map and print both keys and values
//private static void displayEmpMap(HashMap<String, Employee> empMap)
//
////Remove all the entries from the map where emp name is "Mohit"
//private static void removeByNameFromMap(HashMap<String, Employee> empMap, String nameOfTheEmp)
//
////Remove all the duplicate entries from the list and return the list .
//private static List<Employee> removeDuplicateEntriesFromList(List<Employee> empList)
//
// */
//
//import java.util.*;
//import java.util.stream.Collectors;
//import java.util.stream.IntStream;
//import java.util.stream.Stream;
//
//public class Complete_the_functions {
//
//    private static void displayEmployeesByForEach( List<Employee> empList ){
//        empList.stream().forEach( System.out :: println);
//    }
//
//    private static List<Employee> sortEmpByNameAndSalary( List<Employee> empList ){
//       return empList.stream()
//                .sorted( Comparator.comparing( Employee :: getName )   // name in ascending order
//                                   .thenComparing( Employee :: getSalary, Comparator.reverseOrder() ) )
//               .collect(Collectors.toList());
//    }
//
//    private static List<Employee> sortEmpByName( List<Employee> empList){
//        return empList.stream()
//                .sorted( Comparator.comparing( Employee :: getName ) )
//                .collect( Collectors.toList() );
//    }
//
//    private static List<Employee> sortEmpBySalary( List<Employee> empList){
//        return empList.stream()
//                .sorted( Comparator.comparing( Employee :: getSalary ).reversed() )   // descending order
//                .collect( Collectors.toList() );
//    }
//
//    private static Employee removeById( List<Employee> empList, int empId ){
//        try {
//            // get the index of Employee with id = empId
//            int index = IntStream.range( 0, empList.size() )
//                    .filter( i -> empList.get(i).getId() == empId )
//                    .findFirst()
//                    .getAsInt() ;
//            return empList.remove(index);
//        }
//        catch (IndexOutOfBoundsException  | NullPointerException | NoSuchElementException ex ){
//            System.out.println( String.format("\nId %d does not exist", empId ) );
//            return null;
//        }
//    }
//
//    private static HashMap<String, Employee> convertListToMap( List<Employee> empList ) {
//        /*
//        Create a map using the list, names of the employees as keys and the employee
//        object as value
//         */
//        HashMap<String, Employee > empHashMap = new HashMap<>();
//        // get the name of the employee and add it as key
//        // get the ids and salary and add them to a list
//        // add the list as value
//        for( Employee emp : empList ){
//            empHashMap.put( emp.getName(), emp );
//        }
//          return empList.stream();
//    }
//
//    private static void displayEmpMap(HashMap<String, Employee> empMap) {
//         empMap.entrySet().forEach( System.out :: println ) ;
//    }
//
//    private static void removeByNameFromMap(HashMap<String, Employee> empMap, String nameOfTheEmp) {
//        empMap.entrySet()
//              .removeIf(
//                        entry -> ( nameOfTheEmp == entry.getKey() ) );
//    }
//
//    private static List<Employee> removeDuplicateEntriesFromList(List<Employee> empList) {
//        HashSet<String> empSet = new HashSet<>();
//        ArrayList<String> duplicateNamesList = new ArrayList<>();
//
//        for( Employee emp : empList) {
//            String name = emp.getName();
//            if( !empSet.add( name ) ){
//                duplicateNamesList.add( name );
//            }
//        }
//        System.out.println("\nThe duplicate names are: ");
//        duplicateNamesList.stream().forEach( System.out :: println );
//
//        List<Employee> noDuplicateList = empList.stream()
//                .collect( Collectors.collectingAndThen(
//                        Collectors.toCollection( () -> new TreeSet<>( Comparator.comparing(Employee::getName) ) ),
//                        ArrayList::new )
//                );
//
//        return noDuplicateList;
//    }
//
//    public static void main(String[] args) {
//        int[] empIdArr = { 1, 2, 3, 4, 5, 3, 7 };
//        String[] empNameArr = { "Mohit", "Rahul", "Shyam", "Mohit", "Swaraj", "Shyam", "Anish" };
//        double[] empSalaryArr = { 23443.0, 4335656.0, 45443.0, 878788.0, 767755.0, 45443.0, 35546.0 };
//
///*
//        The primitive and object versions of data types (i.e. int and Integer, double and Double, etc.) are
//        not really compatible with each other in Java. They are made compatible through the extra step of
//        auto-boxing/unboxing.
//        Thus, if you have a stream of primitive ints and if you try to use the object versions of
//        Stream and Function (i.e. Stream<Integer> and Function<Integer, Integer>), you will incur the
//        cost of boxing and unboxing the elements.
//
//        To eliminate this problem, the function package contains primitive specialized versions of
//        streams as well as functional interfaces.
//        For example, instead of using Stream<Integer>, you should use IntStream.
//        You can now process each element of the stream using IntFunction. T
//        his will avoid auto-boxing/unboxing altogether.
//
//        Thus, whenever you want to process streams of primitive elements, you should use the
//        primitive specialized streams (i.e. IntStream, LongStream, and DoubleStream) and primitive
//        specialized functional interfaces (i.e. IntFunction, IntConsumer, IntSupplier, etc.) to achieve
//        better performance.
//
//        Let's take some examples:
//
//        Stream<Object> stream1 = Stream.of(1, 2, 3); //Will compile fine
//        IntStream intStream1 = IntStream.of(4, 5, 6); //Will compile fine
//
//        Stream<Object> stream2 = IntStream.of(4, 5, 6); //Does not compile
//        Stream<Object> stream3 = IntStream.of(4, 5, 6).mapToObj(e -> e); //mapToObj method is needed
//        IntStream intStream2 = Stream.of(4, 5, 6).mapToInt(e -> e); //mapToInt method is needed
//
// */
//        //get the max of all the array sizes to traverse all the arrays
//        int maxSize = Math.max( empIdArr.length , Math.max( empNameArr.length, empSalaryArr.length ) );
//
//        List<Employee> empList = IntStream.range( 0, maxSize )  // iterate over the arrays
//                           .mapToObj( i -> new Employee(      // create new Employee objects
//                                   empIdArr[i],empNameArr[i], empSalaryArr[i] ) )
//                           .collect( Collectors.toCollection( ArrayList :: new ) ); // new ArrayList of Employee objects
//
//        List<Employee>  copyEmpList = new ArrayList<>( empList );
//
//        System.out.println("empList = " );
//        displayEmployeesByForEach( empList );
//
//        System.out.println("\nSort employee by name and salary = ");
//        List<Employee> sortedNameSalaryEmpList = sortEmpByNameAndSalary( empList );
//        displayEmployeesByForEach( sortedNameSalaryEmpList );
//
//        System.out.println("\nSort employee by name  = ");
//        List<Employee> sortedNameEmpList = sortEmpByName(empList);
//        displayEmployeesByForEach( sortedNameEmpList );
//
//        System.out.println("\nSort employee by salary = ");
//        List<Employee> sortedSalaryEmpList = sortEmpBySalary(empList);
//        displayEmployeesByForEach( sortedSalaryEmpList );
//
//        int empId = 7;
//        Employee empRemoved = removeById( empList, empId );  // the removed Employee
//        System.out.println("\nRemoved ----- " + empRemoved + " ----- (emp id " + empId + ") ");
//        displayEmployeesByForEach( empList );
//
//        // --------------------- Maps -------------------------------
//
//        HashMap<String, Employee> empMap = convertListToMap( empList );
//        System.out.println("\nempMap = ");
//        displayEmpMap( empMap );
//
//        String empName = "Mohit";
//        System.out.println( String.format("\nAfter removing %s.....", empName) );
//        removeByNameFromMap( empMap, empName);
//        displayEmpMap( empMap );
//
//        System.out.println("\nBefore removing duplicates = ");
//        displayEmployeesByForEach( copyEmpList );
//        List<Employee> noDuplicatesList = removeDuplicateEntriesFromList( copyEmpList );
//        System.out.println("\nAfter removing the duplicate names, empList = ");
//        displayEmployeesByForEach( noDuplicatesList );
//    }
//}
