/*
Suppose that our application requires us to model students.
A student has a name and an address.
We are required to keep track of the courses taken by each student, together with the
grades (between 0 and 100) for each of the courses.
A student shall not take more than 30 courses for the entire program.
We are required to print all course grades, and also the overall average grade.

The Student class contains the following members:

- private instance variables name (String), address (String), numCourses (int),
course (String[30]) and grades (int[30]).
The numCourses keeps track of the number of courses taken by this student so far.
The courses and grades are two parallel arrays, storing the courses taken
(e.g., {"IM101", "IM102", "IM103"}) and their respective grades (e.g. {89, 56, 98}).
- A constructor that constructs an instance with the given name and Address.
It also constructs the courses and grades arrays and set the numCourses to 0.
- Getters for name and address; setter for address.
No setter is defined for name as it is not designed to be changed.
- A toString(), which prints "name(address)".
- A method addCourseGrade(course, grade), which appends the given course and grade into the
courses and grades arrays, respectively; and increments numCourses.
- A method printGrades(), which prints "name course1:grade1, course2:grade2,...".
- A method getAverageGrade(), which returns the average grade of all the courses taken.
 */

public class Student {
    private String name, email;
    private int numCourses;
    private String[] courses;
    private int[] grades;

    private static final int MAX_COURSES = 5; // for testing

    // ------ constructor
    public Student( String name, String email){
        this.name = name;
        setAddress( email );
        this.numCourses = 0; // no courses so far
        this.courses = new String[ MAX_COURSES ]; // allocate array
        this.grades = new int[ MAX_COURSES ]; // allocate array
    }

    // ----- getters ---------
    public String getName(){
        return this.name;
    }

    public String getAddress() {
        return this.email;
    }

    // ------ setter ---------
    public void setAddress( String email ){
        this.email = email;
    }

    // ----- toString() --------------
    public String toString(){
        return String.format("%s( %s ) ", this.name, this.email );
    }

    // ------- methods ---------------
    public void addCourseGrade ( String courseName, int grade ){
        // appends the given course and grade into the courses and grades
        // arrays, respectively; and increments numCourses.
        if (this.numCourses <= this.courses.length - 1) {
            if (grade >= 0 && grade <= 100) {
                this.courses[this.numCourses] = courseName;
                this.grades[this.numCourses] = grade;
                ++numCourses;
            } else {
                throw new IllegalArgumentException("Invalid grade ( grade must be between 0 and 100");
            }
        }
        else {
            throw new ArrayIndexOutOfBoundsException("Exceeded the maximum number of courses (30) !");
        }
    }

    public void printGrades(){
        // Prints the student's name and all courses and their grades
        System.out.println("Name: " + getName() );
        for ( int i =0 ; i < numCourses; ++i )
            System.out.printf("%s : %d%n", this.courses[i], this.grades[i] );
    }

    public double getAverageGrade(){
        // Computes the average grade
        double sum = 0.0;
        for(int i = 0; i < numCourses; ++i )
            sum += this.grades[i];
        return (double) sum/numCourses;
    }
}
