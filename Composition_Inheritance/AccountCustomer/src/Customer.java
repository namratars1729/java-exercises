public class Customer {
    private int ID;
    private String name;
    private char gender;

    // --- constructor
    public Customer( int id, String name, char gender ){
        this.ID = id;
        this.name = name;
        this.gender = gender;
    }

    // ---- toString()
    @Override
    public String toString() {
        return String.format("%s ( %d )", this.getName(), this.getID());
    }

    // ---- getters
    public int getID() {
        return this.ID;
    }
    public String getName() {
        return this.name;
    }
    public char getGender() {
        return this.gender ;
    }
}
