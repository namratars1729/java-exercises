/*
No setter for name
 */

public class Author {
    private String name, email;

    // ----- constructor
    public Author( String name, String email ){
        this.name = name ;
        this.email = email ;
    }

    // ------ toString()
    @Override
    public String toString() {
        return String.format("Author[ name = %s, email = %s ]", this.getName(), this.getEmail()) ;
    }

    // --------- getters
    public String getName() {
        return this.name;
    }

    public String getEmail() {
        return this.email;
    }

    // ------- setter
    public void setEmail(String email) {
        this.email = getEmail();
    }
}
