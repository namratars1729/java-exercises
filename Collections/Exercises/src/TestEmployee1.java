import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.groupingBy;

public class TestEmployee1 {

    private static class Query {
        static void getEmployee1List(Stream<String> linesStream ){
            List<Employee1> empList = linesStream
                    .map( eachLine -> eachLine.split(",") )  // split eachLine on ","
                    .map( eachLine -> new Employee1( Integer.parseInt ( eachLine[0]) , eachLine[1],
                            Integer.parseInt( eachLine[2] ), eachLine[3],
                            eachLine[4], Integer.parseInt ( eachLine[5] ),
                            Double.parseDouble( eachLine[ 6 ] ) ) )
                    .collect( Collectors.toUnmodifiableList() );

            // empList.stream().forEach( System.out :: println );
            performQueries( empList );
        }

        static void performQueries( List<Employee1> empList ){
            // --------- 1. How many male and female employees are there in the organization?
            Map<String, Long> mfCount = empList.stream()
                    .collect( groupingBy( Employee1::getGender,
                                                     Collectors.counting() ));
            System.out.print("1. There are " + mfCount + " employees" );

            // --------- 2. Print the name of all departments in the organization
            System.out.print("\n2. The departments are - " );
            empList.stream()
                    .map( Employee1::getDepartment )
                    .distinct()
                    .forEach( System.out :: println );

            // --------- 3. What is the average age of male and female employees?
            System.out.print("\n3. The average ages of male and female employees are - " );
            Map<String, Double> avgAgeMF =
                    empList.stream()
                            .collect( groupingBy( Employee1 :: getGender,
                                                             Collectors.averagingInt( Employee1 :: getAge ) ) );
            System.out.println( avgAgeMF );

            // --------- 4. Get the details of highest paid employee in the organization?
            // collectingAndThen(Collector d, Function f)  performs a final function f, on the result of d.
            // maxBy returns an Optional
            Optional<Employee1> highestPaidEmpName = empList.stream()
                    .collect( Collectors.maxBy( Comparator.comparing(Employee1::getSalary ) ) );

            System.out.print("\n4. The highest paid employee in the organization is - \n" +
                                    highestPaidEmpName.get() );

            // Get the employee with the Second Highest salary
            Employee1 secondHighest = empList.stream()
                    .sorted(Comparator.comparing(Employee1 :: getSalary).reversed() )
                    .skip(1)
                    .findFirst()
                    .get();

            System.out.print("\n The second highest paid employee in the organization is - \n" +
                    secondHighest + "\n" );

            // --------- 5. Get the names of all employees who have joined after 2015?
            System.out.println("\n5. The employees who have joined after 2015 are - ");
            empList.stream()
                    .filter( emp -> emp.getYearOfJoining() > 2015 )
                    .map(Employee1 :: getName )
                    .forEach( System.out :: println);

            // --------- 6. Count the number of employees in each department
            Map<String, Long> numEachDeptMap = empList.stream()
                    .collect( groupingBy( Employee1::getDepartment,
                                                     Collectors.counting() ) );

            System.out.println("\n6. The number of employees in each department - " );
            Set<Map.Entry<String, Long>> numEachDeptSet = numEachDeptMap.entrySet();
            for( Map.Entry<String,Long> entry : numEachDeptSet )
                System.out.println(entry.getKey() + " : " + entry.getValue() );

            // --------- 7. What is the average salary of each department?
            System.out.println("\n7. The average salary of each department - " );
            Map<String, Double> mapAvgSalEachDept = empList.stream()
                    .collect( groupingBy(
                                                  Employee1::getDepartment,
                                                  Collectors.averagingDouble( Employee1::getSalary )
                    ));
            Set<Map.Entry<String, Double>> setAvgSalDept = mapAvgSalEachDept.entrySet();
            for( Map.Entry<String, Double> entry : setAvgSalDept )
                System.out.println(entry.getKey() + " : " + entry.getValue() );

            // --------- 8. Get the details of the youngest male employee in the product development department
            System.out.println("\n8. The youngest male employee in the product development department - " );
            Employee1 youngestMaleEmp = empList.stream()
                    .filter( emp -> emp.getGender().equalsIgnoreCase("Male") &&
                                  emp.getDepartment().equalsIgnoreCase("Product Development") )
                    .min(Comparator.comparingInt(Employee1::getAge))
                    .orElse( null );
            System.out.println("youngestMaleEmp =  " + youngestMaleEmp );

            // --------- 9. Who has the most working experience in the organization?
            System.out.println("\n9. The the most experienced employee - " );
            Employee1 mostExpEmp = empList.stream()
                    .min( Comparator.comparingInt(Employee1::getYearOfJoining) )
                    .orElse( null );
            System.out.println( "mostExpEmp = " + mostExpEmp );

            // --------- 10. How many male and female employees are there in the sales and marketing team?
            System.out.println("\n10. Number of male and female employees in Sales and Marketing - ");
            // Collectors.counting() returns a Long
            // It is implemented as:
            //      reducing(0L, e -> 1L, Long::sum)
            // To get an int value from Collectors.counting():
            //      .collect(Collectors.reducing(0, e -> 1, Integer::sum)

            Map<String, Map<String, Long>> mapAllDeptMandFcount =
                    empList.stream()
                            .collect(
                                    Collectors.groupingBy(Employee1::getDepartment,
                                                         Collectors.groupingBy(Employee1::getGender,
                                                                               Collectors.counting())));

          //  mapAllDeptMandFcount.entrySet().stream().forEach( System.out::println );
//            Map<String, Map<String, Long>> countMFsalesAndMarketing =
//                    (Map<String, Map<String, Long>>) mapAllDeptMandFcount.entrySet().stream()
//                            .filter( key -> key.getKey() == "Sales And Marketing")
//                            .findFirst()
//                            .get();
 //           System.out.println( mapAllDeptMandFcount.entrySet();

            for( Map.Entry<String, Map<String, Long>> entry : mapAllDeptMandFcount.entrySet() ){
                if ( entry.getKey() == "Sales and Marketing")
                    System.out.println( entry.getKey() + " : " + entry.getValue() );
            }

            // --------- 11. What is the average salary of male and female employees?
            Map<String, Double> avgSalaryMF =
                    empList.stream()
                            .collect( Collectors.groupingBy( Employee1::getGender,
                                                             Collectors.averagingDouble( Employee1 :: getSalary ) ) );
            System.out.println("\n11. The average salary of male and female employees = ");
            System.out.println( avgSalaryMF );

            // --------- 12. List the names of all employees in each department
            Map<String, List<String>> listEmpNamesByDept =
                    empList.stream()
                            .collect( Collectors.groupingBy(Employee1 :: getDepartment,
                                                            Collectors.mapping(Employee1::getName, Collectors.toList() )
                                                           ) );
            System.out.println("\n12. The names of all the employees in each department = ");
            for(Map.Entry< String, List<String>> entry : listEmpNamesByDept.entrySet() ){
                System.out.println( "\n-----------------------------------\n" +
                       "Employees in" + entry.getKey() + "\n------------------------------------" );
                entry.getValue().stream().forEach( System.out :: println );
            }

            // --------- 13. What is the average salary and total salary of the whole organization?
            System.out.println("\n13. The average salary and total salary of the whole organization -");
            DoubleSummaryStatistics summaryStatistics =
                    empList.stream()
                            .collect( Collectors.summarizingDouble(Employee1 :: getSalary) );

            System.out.println("average salary = " + summaryStatistics.getAverage() +
                               "\ntotal salary = " + summaryStatistics.getSum() );

            // --------- 14. Separate the employees who are younger or equal to 25 years from those
            //               employees who are older than 25 years.
            System.out.println("\n14. Employees partitioned by age 25 -");
            Map<Boolean, List<String>> partitionAge25 =
                    empList.stream()
                            .collect( Collectors.partitioningBy(emp -> emp.getAge() > 25,
                                                                Collectors.mapping( Employee1::getName, Collectors.toList() )));

           for (Map.Entry< Boolean, List<String>> entry : partitionAge25.entrySet() ) {
               System.out.println("\n----------------------------------------------------");
               if (entry.getKey() )
                   System.out.println("Employees older than 25 years ");
               else
                   System.out.println("Employees younger than or equal to 25 years ");

               System.out.println("----------------------------------------------------");
               entry.getValue().stream().forEach(System.out :: println );
           }

           // --------- 15. Who is the oldest employee in the organization?
          //                What is his age and which department does he belong to?
            System.out.println("\n15. The oldest employee in the organization - ");
           Employee1 oldestEmp =
                   empList.stream()
                           .collect( Collectors.maxBy( Comparator.comparing( Employee1 :: getAge)))
                           .get();
            System.out.println( String.format("Name = %s | Age = %d | Department = %s",
                    oldestEmp.getName(), oldestEmp.getAge(), oldestEmp.getDepartment() ) );
        }
    }

    public static void main( String ... args ) throws FileNotFoundException, IOException {
        String filename = "src/EmployeeInfo.txt";
        Path filePath = Paths.get( filename );

        // ---- read the file into a stream
        // JDK 8 offers the lines() method inside the Files class
        // it lets BufferedReader return content as Stream of String elements
        // Files.lines() method DOES NOT include line-termination character ("\n")
        try ( Stream<String> linesStream = Files.lines( filePath ) ){

            Query.getEmployee1List( linesStream );

        } catch ( IOException ex ) {
            System.out.println(String.format( "File %s cannot be found",
                                              filename ) );
            ex.printStackTrace();
        }
    }
}
