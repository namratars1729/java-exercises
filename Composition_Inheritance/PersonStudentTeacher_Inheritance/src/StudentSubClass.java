/*
Subclass Student -
For students, we need to maintain
- the courses taken
- their respective grades
- add a course with grade
- print all courses taken
- the average grade.
Assume that a student takes no more than 30 courses for the entire program.
 */

import java.util.ArrayList;
import java.util.List;

public class StudentSubClass extends PersonBaseClass {
    private final static int MAX_COURSES = 5; // instead of 30
    private int numCourses;
    private List<String> courses;
    private List<Integer> grades;

    // ----- constructor
    public StudentSubClass( String name, String eAddress) {
        super( name,eAddress );
        this.numCourses = 0;
        this.courses = new ArrayList<String>();
        this.grades = new ArrayList<Integer>();
    }

    // -------- toString()
    public String toString() {
        return String.format("Student: %s", super.toString() );
    }

    // -------- getter
    public double getAverageGrade() {
        // using Streams API
        // java.util.stream.IntStream is the int primitive-type specialization
        // of a stream which exposes sum(), average() and other similar operations.

        return this.grades.stream()
                .mapToDouble(d -> d)
                .average()  // average() method in IntStream class returns an OptionalDouble.
                .orElse(0.0); // return 0.0 (or a Double.NaN) in case the Optional
                                   // is found empty.
    }

    // ---------- methods
    public void addCourseGrade( String course, int grade ) {
        this.courses.add( course );
        this.grades.add( grade );
    }

    public void printGrades() {
        for( int i = 0; i<this.grades.size() && i<this.courses.size(); i++ ){
            System.out.printf("%s: %d%n", this.courses.get(i), this.grades.get(i));
        }
    }
}
