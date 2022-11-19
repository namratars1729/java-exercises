// Implement Comparable and Override compareTo()

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Student implements Comparable<Student>{
    private int age, rollNum;
    private String name;

    public Student (String name, int age, int rollNum) {
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

    // Override the abstract method
    @Override
    public int compareTo(Student otherStudent) {
        // --- natuaral ordering is ascending order
        // --- can compare only 1 data member at a time

        //return Integer.compare( this.getAge(), otherStudent.getAge() ); // age in ascending order
        // ----- For age in descending order, either Override OR use Collections.reverse()
        // return Integer.compare( otherStudent.getAge(), this.getAge() );

        //return Integer.compare( this.getRollNum() , otherStudent.getRollNum() ); // rollNum in ascending order
        // ----- For rollNum in descending order, either Override OR use Collections.reverse()
        //return Integer.compare(otherStudent.getRollNum(), this.getRollNum () ); // rollNum in descending order

        //return ( this.getName().compareTo(otherStudent.getName()) ); // name in ascending order
        // ----- For name in descending order, either Override OR use Collections.reverse()
        return ( otherStudent.getName().compareTo(this.getName()) ); // name in descending order
    }
}

// --------------------------------------------------------------------------------------------------------

class StudentComparable {
    public static void main(String[] args) {
        List<Student> studentList = new ArrayList<>(){
            {
                add( new Student("Pragna", 23, 6789) );
                add( new Student("Manisha", 19, 5673) );
                add( new Student("James Bond", 66, 9999) );
                add( new Student("Modi", 72, 1) );
                add( new Student("AAAA", 12, 56) );
                add( new Student("BB", 40, -854) );
            }
        };

        System.out.println("Before studentList = ");
        studentList.stream()
                .forEach(System.out :: println);

        System.out.println();

        System.out.println("After studentList in ascending order = ");
        Collections.sort( studentList );
        studentList.stream()
                .forEach( System.out :: println );

        System.out.println();

        System.out.println("After studentList in descending order = ");
        Collections.reverse(studentList);
        studentList.stream()
                .forEach( System.out :: println );
    }
}