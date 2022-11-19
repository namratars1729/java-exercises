public class TestStudent {
    public static void main(String[] args) {
        // Test constructor
        Student s1 = new Student("Pragna", "pogoji@abc.com");

        // Test toString()
        System.out.println("s1 = " + s1);

        // Test getters and setters
        s1.setAddress("abc@123.com");
        System.out.println("\nAfter....s1 = " + s1);
        System.out.println("s1.getName() = " + s1.getName() );
        System.out.println("s1 New address = " + s1.getAddress() );

        // Test addCourseGrade()
        try{
            s1.addCourseGrade("CS101", 89);
            s1.addCourseGrade("CS102", 90);
            s1.addCourseGrade("CS103", 75);
            s1.addCourseGrade("CS104", 91);
          //  s1.addCourseGrade("CS105", 109);// IllegalArgument
            s1.addCourseGrade("CS105", 88); // to test ArrayIndexOutOfBounds exception
            s1.addCourseGrade("CS106", 84); // ArrayIndexOutOfBounds
        }
        catch (IllegalArgumentException e){
            System.out.println("\nInvalid grade ( grade must be between 0 and 100)");
        }
        catch (ArrayIndexOutOfBoundsException e){
            System.out.println("\nExceeded the maximum number of courses (5) )");
        }

        // Test printGrades()
        System.out.println();
        s1.printGrades();

        // Test getAverageGrade()
        System.out.printf("The average grade for %s is %.2f%n", s1.getName(), s1.getAverageGrade());
    }
}
