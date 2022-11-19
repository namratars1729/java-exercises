package DiscountRateBeautySaloon;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.text.DateFormat;

public class Visit {
    private Customer customer;
    private Date date;
    private double serviceExpense, productExpense;

    // -------- constructor
    public Visit( String name, Date date){
        this.customer = new Customer( name );
        this.date = date;
    }

    // ---------- toString()
    @Override
    public String toString() {
        String datePattern, strDate;

        datePattern = "EEE, d MMM yyyy";
        DateFormat dtf = new SimpleDateFormat( datePattern );
        strDate = dtf.format( this.date );
        return String.format("%s %nVisited on: %s%n " +
                        "%nService Expense: %.2f%nProduct Expense: %.2f%n" +
                        "-------------------- %nTOTAL AMOUNT: %.2f%n" +
                        "--------------------%n",
                        customer.toString(), strDate,
                        this.getServiceExpense(), this.getProductExpense(),
                        this.getTotalExpense() );
    }

    // --------- getters
    public String getName() {
        return this.customer.getName();
    }

    public double getServiceExpense() {
        return this.serviceExpense;
    }

    public double getProductExpense() {
        return this.productExpense;
    }

    public double getTotalExpense() {
        // compute the total bill if a customer purchases $x of products
        // and $y of services, for a visit
        return this.getServiceExpense() + this.productExpense;
    }

    // -------- setters
    public void setProductExpense(double productExpense) {
        double productDiscountRate = StaticDiscountRate.getProductDiscountRate(this.customer.getMemberType() );
        this.productExpense = productExpense - ( productDiscountRate * productExpense );
    }

    public void setServiceExpense(double serviceExpense) {
        double serviceDiscountRate = StaticDiscountRate.getServiceDiscountRate( this.customer.getMemberType() );
        this.serviceExpense = serviceExpense = ( serviceDiscountRate * serviceExpense );
    }
}
