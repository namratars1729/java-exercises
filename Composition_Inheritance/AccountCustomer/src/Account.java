public class Account {
    private int id;
    private Customer customer;
    private double balance;

    //------ constructors
    public Account( int id, Customer customer, double balance ){
        this.id = id;
        this.customer = customer;
        this.balance = balance;
    }
    public Account( int id, Customer customer){
        this.id = id;
        this.customer = customer;
        this.balance = 0.0;
    }

    // ----- toString()
    @Override
    public String toString() {
        return String.format("%s( %d ) balance = $%.2f",
                             this.getCustomerName(),
                             this.getID(),
                             this.getBalance() ) ;
    }

    // ------ getters
    public int getID() {
        return this.id;
    }
    public Customer getCustomer() {
        return this.customer;
    }
    public double getBalance() {
        return this.balance;
    }
    public String getCustomerName(){
        return this.getCustomer().getName();
    }

    // ------ setter
    public void setBalance(double balance) {
        this.balance = balance;
    }

    // ---- methods
    public Account deposit( double amount){
        this.balance += amount;
        return this;
    }
    public Account withdraw( double amount){
        if ( this.balance >= amount)
            this.balance -= amount;
        else
            throw new IllegalArgumentException("Insufficient balance!");
        return this;
    }
}
