/*
A test driver program for the Author class.
 */
public class TestAuthor {
        public static void main(String[] args) {

            Author ahTeck = new Author("Tan Ah Teck", "ahteck@nowhere.com"); // Test the constructor
            System.out.println(ahTeck);  // Test toString()
            ahTeck.setEmail("paulTan@nowhere.com");  // Test setter
            System.out.println("name = " + ahTeck.getName());     // Test getter
            System.out.println("eamil = " + ahTeck.getEmail());   // Test getter
        }
}
