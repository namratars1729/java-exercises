/*

A superclass called Person to store common properties such as name and address.

 */

public class PersonBaseClass {
    private String name, address;

    // ----- constructor
    public PersonBaseClass( String name, String eAddress ){
        this.name = name;
        setAddress( eAddress );
    }

    // ------ toString()
    public String toString(){
        return String.format("%s( %s )", this.name, this.address );
    }

    // ---- getters
    public String getName(){
        return this.name;
    }

    public String getAddress() {
        return this.address;
    }

    // ---- setter

    public void setAddress(String address) {
        this.address = address;
    }
}
