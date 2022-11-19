/*
For teachers, we need to maintain the courses taught currently,
and able to add or remove a course taught.
Assume that a teacher teaches not more than 5 courses concurrently.
 */

import java.util.ArrayList;
import java.util.List;

public class TeacherSubClass extends PersonBaseClass {
    private int numCourses;
    private List<String> courses;

    // ----- constructor
    public TeacherSubClass( String name, String address ) {
        super( name, address);
        this.numCourses = 0;
        this.courses = new ArrayList<String>();
    }

    // ------ toString()
    @Override
    public String toString() {
        return String.format("Teacher: %s", super.toString() ) ;
    }

    // ------ methods
    public boolean addCourse( String course ) {
        /** Adds a course. Returns false if the course already exists */
        if ( this.courses.size() < 5 ) {
            if ( this.courses.contains( course ) )
                return false;
            else {
                this.courses.add( course );
                return true;
            }
        }
        return false; // more than 5 courses
    }

    public boolean removeCourse(String course) {
        /** Removes a course. Returns false if the course cannot be found
         * in the course list */
        if ( this.courses.contains( course) ) {
            this.courses.remove(course);
            return true;
        }
        return false; // course not found
    }
}
