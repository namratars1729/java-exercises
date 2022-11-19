/*
A test driver program for the Book class.
 */

public class TestBook {
    public static void main(String[] args) {

        // Declare and instantiate the array of Author
        Author[] authors = new Author[ 4 ] ;
        authors[ 0 ] = new Author( "ORielly", "orielly@nowhere.com");
        authors[ 1 ] = new Author( "AAAAAA", "aaaaa@here.com");
        authors[ 2 ] = new Author( "BBBBBB", "bbbbb@here.com");
        authors[ 3 ] = new Author( "CCCCCC", "ccccc@here.com");

        // check constructors and toString()
        Book javaBook = new Book("Java for Beginners", authors, 49.99, 5 );
        System.out.println("javaBook = " + javaBook);

/*
        // check anonymous Author instance to create a Book instance
        Book resetBook = new Book("Reset",
                                new Author("Dr.Subramaniam Swamy", "swamy@india.gov"),
                                29.99, 5);
        System.out.println("\nresetBook = " + resetBook);
*/

        // Test getters and setters
        System.out.println("/nPrice = $" + javaBook.getPrice() +
                           "\nQuantity = " + javaBook.getQty() );

        javaBook.setQty(10);
        System.out.println("\njavaBook new quantity = " + javaBook.getQty());

        javaBook.setPrice( 39.99);
        System.out.println("\njavaBook new price = $" + javaBook.getPrice() );

        System.out.println("\nThe authors are: " + javaBook.getAuthorNames() );
/*
        // Printing the name and email of the author from a Book instance
        System.out.println("\nresetBook.getAuthor().getName() = " + resetBook.getAuthor().getName() +
                          "\nresetBook.getAuthor().getEmail() = " + resetBook.getAuthor().getEmail() );
*/
    }

}
