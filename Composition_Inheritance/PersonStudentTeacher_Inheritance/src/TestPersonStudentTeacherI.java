import java.util.ArrayList;
import java.util.List;

/**
 * A test driver for Person and its subclasses.
 */

public class TestPersonStudentTeacherI {
    public static void main(String[] args) {
        /* Test Student class */
        StudentSubClass s1 = new StudentSubClass( "John", "john@student.com");
        s1.addCourseGrade("CS101", 97);
        s1.addCourseGrade("CS102", 68);
        System.out.println("s1.printGrades() -------");
        s1.printGrades();
        System.out.printf("s1 average = %.2f%n%n", s1.getAverageGrade() );

        /* Test Teacher class */
        TeacherSubClass t1 = new TeacherSubClass("Mr.Paul", "paul@abc.com");
        System.out.printf("t1 = %s%n", t1);
        List<String> t1Courses = new ArrayList<String>(
                List.of("CS101", "CS102", "CS101") );

        String str1, str2;
        for (String course: t1Courses ) {
            str1 = t1.addCourse(course) ? "Added course " + course : course + " cannot be added (repeated)";
            System.out.println( str1 );
        }
        System.out.println();

        for (String course : t1Courses) {
            str2 = t1.removeCourse(course) ? course + " removed" : course + " cannot be removed";
            System.out.println( str2 );
        }
        // ---------------------------------------------------------------------------------

        TeacherSubClass t2 = new TeacherSubClass("Mr.X", "x@abc.com");
        System.out.printf("t2 = %s%n", t2);
        List<String> t2Courses = new ArrayList<String>(
                List.of("CS101", "CS102", "CS103", "CS104", "CS105", "CS106") );

        String str3, str4;
        for (String course: t2Courses ) {
            str3 = t2.addCourse(course) ? "Added course " + course : course + " cannot be added";
            System.out.println( str3 );
        }
        System.out.println();

        for (String course : t2Courses) {
            str4 = t2.removeCourse(course) ? course + " removed" : course + " cannot be removed";
            System.out.println( str4 );
        }
    }
}
