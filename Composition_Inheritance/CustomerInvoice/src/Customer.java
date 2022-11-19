/*
A class called Customer, which models a customer in a transaction
*/

public class Customer {
    private int id, discount; // discount as a percent
    private String name;

    // -----constructor
    public Customer( int id, String name, int discount ){
        this.id = id;
        this.name = name;
        this.discount = discount ;
    }

    // ---- toString()
    @Override
    public String toString() {
        return String.format("%s( (%d) (%d)%% )",
                this.getName(), this.getID(), this.getDiscount() ) ;
    }

    // ----- getters
    public int getID() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public int getDiscount() {
        return this.discount;
    }

    // ------- setter
    public void setDiscount(int discount) {
        this.discount = discount;
    }
}
