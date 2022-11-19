import java.util.Arrays;

/*
A class called Book is designed to model a book written by many authors.
You shall re-use the Author class written earlier.

In this design, once a Book instance is created, you cannot add or remove the author.

It contains:

- Four private instance variables:
    - name (String),
    - authors (Author[]) ...of the class Author... a book can be written by one or more authors
    - price (double), and
    - qty (int) = 0;
- Two constructors:
    - public Book (String name, Author[] author, double price) { ...... }
    - public Book (String name, Author[] author, double price, int qty) { ...... }
- public methods
    - getName(),
    - getAuthors(),
    - getAuthorNames()    // cannot use author.name as name is private in Author class
    - getPrice(),
    - setPrice(),
    - getQty(),
    - setQty()
- A toString() that returns "Book[name=?,authors={Author[name=?,email=?,gender=?],......},price=?,qty=?]".

Also write a test driver called TestBook to test all the public methods in the class Book.
Take Note that you have to construct an instance of Author before you can construct an
instance of Book.
 */
public class Book {
    private String name;
    private Author[] authors;
    private double price;
    private int qty;

    // ------ constructors
    public Book( String name, Author[] authors, double price) {
        this.name = name;
        this.authors = authors;
        this.price = price;
        this.qty = 0;
    }
    public Book( String name, Author[] authors, double price, int qty) {
        this.name = name;
        this.authors = authors;
        this.price = price;
        this.qty = qty;
    }
    // ------ toString()
     @Override
     public String toString() { // use Author's toString() for author's information
        return String.format("Book[ name = %s " +
                             "authors = { %s } " +
                              "price = %f " +
                              "quantity = %d ]",
                              this.getName(),
                              Arrays.toString( getAuthors() ),
                              this.getPrice(), this.getQty() );
     }

     // ------ getters
    public String getName() {
        return this.name;
    }

    public Author[] getAuthors() {
        return this.authors;
    }

    public double getPrice() {
        return this.price;
    }

    public int getQty() {
        return this.qty;
    }
    public String getAuthorNames(){
        String names = "";
        for( int i=0; i < authors.length; ++i){
            if (i >= 0 && i < authors.length-1)
                names = names + authors[i].getName() + ",";
            else
                names = names + authors[i].getName();
        }
        return names;
    }

    // ------ setters
    public void setPrice( double price ) {
        this.price = price;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }
}

