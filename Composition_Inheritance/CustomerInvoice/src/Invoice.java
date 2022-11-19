/*
A class called Invoice, which models an invoice for a particular customer and
composes an instance of Customer as its instance variable
 */

public class Invoice {
    private int id;
    private double amount;
    private Customer customer;

    // ----- constructor
    public Invoice (int id, Customer customer, double amount ){
        this.id = id;
        this.amount = amount;
        this.customer = customer;
    }

    // ----- toString()
    @Override
    public String toString() {
        return String.format("Invoice[ id = %d, " +
                            " customer = %s," +
                            " amount = %.2f",
                             this.getInvoiceID(),
                             this.getCustomer(),
                             this.getAmount() ) ;
    }

    // ------ getters
    public int getInvoiceID() {
        return this.id;
    }

    public Customer getCustomer() {
        return this.customer;
    }

    public double getAmount() {
        return this.amount;
    }
    public int getCustomerID(){
        return this.customer.getID();
    }
    public String getCustomerName() {
        return this.customer.getName();
    }
    public int getCustomerDiscount(){
        return this.customer.getDiscount();
    }
    public double getAmountAfterDiscount(){
         return (this.amount -  ( (double) this.customer.getDiscount()/100 * this.amount ) );
    }

    // ----- setters
    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
    public void setAmount(double amount) {
        this.amount = amount;
    }
}
