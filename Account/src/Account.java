/*
A class called Account, which models a bank account. It contains the following members:

- Two private instance variables: accountNumber (int), and balance (double) which maintains the
current account balance.
- Constructors (overloaded).
- Getters and Setters for the private instance variables.
There is no setter for accountNumber as it is not designed to be changed.
- public methods credit() and debit(), which adds/subtracts the given amount to/from the balance, respectively.
- A toString(), which returns "A/C no:xxx, Balance=$xxx.xx", with balance rounded to two decimal places.
- A transferTo() that transfers the given amount to Account another, if balance >= amount

Chain these methods so that you can do e.g., a1.credit(10).credit(20).debit(5).transferTo(5.5, a2)
Throw an exception instead printing an error message where needed.

Write the Account class and a test driver to test all the public methods.
 */

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Account {
    private int number;
    private double balance;

    // ------- overloaded constructors -----------------
    public Account( int number ){
        this.number = number;
        this.balance = 0.0;
    }

    public Account( int number, double balance ){
        this.number = number;
        this.balance = balance;
    }

    // -------- getters ---------------------------------
    public int getNumber() {
        return this.number;
    }

    public double getBalance() {
        return this.roundAmount( this.balance );
    }

    // --------- toString() ---------------------------
    public String toString() {
        return String.format("A/C no: %d, Balance = $%.2f", this.number, this.balance );
    }

    // --------- method credit() which adds the given amount to the balance -------------
    public Account credit( double amount ){
        this.balance +=  amount;
        return this; // for chaining
    }

    // --------- method debit() which subtracts the given amount from the balance -------------
    public Account debit( double amount ){
        if ( getBalance() >= amount ) {
            this.balance -= amount;

            return this; // for chaining
        }
        else {
            throw new IllegalArgumentException("Amount exceeded balance....cannot debit the amount");
        }
    }

    // --------- transferTo() that transfers the given amount to Account another, if balance >= amount ----------
    public Account transferTo( double amount, Account another ){
        if (getBalance() >= amount  ) {
            this.balance -= amount;
            another.balance += amount;

            return this; // for chaining
        }
        else {
            throw new IllegalArgumentException("Amount exceeded the available balance....cannot transfer");
        }
    }

    // using BigDecimal to round the amount to 2 decimal places
    public double roundAmount( double amount ){
        BigDecimal bd = new BigDecimal(amount).setScale(2, RoundingMode.HALF_EVEN );
        return ( bd.doubleValue() );
    }

}
