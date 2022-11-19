package Sorting;/*
Comparator.comparing( <data_member_to_be_sorted> )

The Comparator.comparing(), introduced in Java 8, returns a Comparator object that will
use the specified field as the sort key.

The Comparator interface is a functional interface in Java 8, and
the method implemented is compare(arg1, arg2).

The compare() is implemented by the comparing() using the specified key.
    ===============================================

How to use Comparator.comparing():
    1. NO NEED to implement the Comparator interface
       i.e class Employee implements Comparator<T>  ---- NOT REQUIRED

    2. Comparator.comparing() accepts an ArrayList and a Comparator object
       The comparing() returns a Comparator object and NOT a value
       ( like Comparable's compareTo() which returns -1, 0 or 1 )

       i.e.,
       Comparator compObj = Comparator.comparing( ArrayList, Comparator Obj )

       ArrayList ---> the ArrayList to be sorted,
       Obj ----> a lambda expression that defines the sorting order on the field.

    3. First, get the Comparator (compObj) object based on the sorting criteria.
       Pass this Comparator object to the sort()

       Eg. Sort employee names in the natural sorting order
       Comparator<Employee> employeeNameComparator = Comparator.comparing(Employee::getName);
       Arrays.sort(employees, employeeNameComparator);  OR
       Collections.sort(employees, employeeNameComparator);

       Eg. custom sorting order - sort Employee names, by their length in descending order
       Comparator<StudentInfo> studentNameDescendingLength =
                Comparator.comparing( StudentInfo::getName, (s1,s2) -> s2.compareTo(s1) );

    4. Because comparing() returns a Comparator rather than a value,you can chain
       multiple comparisons.
       For instance: Comparator.comparing(Person::getLastName)
                               .thenComparing(Person::getFirstName);

*/



import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class StudentInfo{
    private int age, rollNum;
    private String name;

    public StudentInfo (String name, int age, int rollNum) {
        setName(name);
        setAge(age);
        setRollNum(rollNum);
    }

    @Override
    public String toString() {
        return "Student [ " +
                "name = " + name +
                ", age = " + age +
                ", rollNum = " + rollNum +
                " ]";
    }

    // ---- getters
    public int getAge() {
        return age;
    }

    public int getRollNum() {
        return rollNum;
    }

    public String getName() {
        return name;
    }

    // ------ setters
    public void setAge(int age) {
        this.age = age;
    }

    public void setRollNum(int rollNum) {
        this.rollNum = rollNum;
    }

    public void setName(String name) {
        this.name = name;
    }
}

// ----------------------------------------------------------------------------

public class StudentComparator {
    public static void main(String[] args) {
        List<StudentInfo> studentInfoList = new ArrayList<>(){
            {
                add( new StudentInfo("Pragna", 23, 6789) );
                add( new StudentInfo("Manisha", 19, 5673) );
                add( new StudentInfo("James Bond", 66, 9999) );
                add( new StudentInfo("Modi", 72, 1) );
                add( new StudentInfo("AAAA", 12, 56) );
                add( new StudentInfo("BB", 40, -854) );
            }
        };

        System.out.println("------- Before studentInfoList = ");
        studentInfoList.forEach( System.out :: println );

        System.out.println();

//        // sort by name, age,and rollNum by natural sorting order
//        Comparator<StudentInfo> nameComparator = Comparator.comparing(StudentInfo::getName);
//        studentInfoList.sort(nameComparator);
//        List<StudentInfo> sortedNameList = new ArrayList<>(studentInfoList);
//        System.out.println("------ After studentInfoList by name = ");
//        sortedNameList.forEach(System.out :: println );
//
//        System.out.println();

        System.out.println("------ After studentInfoList by name length in descending order = ");
        Comparator<StudentInfo> studentNameDescendingLengthComparator =
                Comparator.comparing( StudentInfo::getName,
                                      (s1, s2) -> Integer.compare( s2.length(), s1.length() ) );
        studentInfoList.sort(studentNameDescendingLengthComparator);
        studentInfoList.forEach(System.out :: println);
    }
}