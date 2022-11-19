/*
The company wishes to create a slight modification to the Account class that filters out
zero-valued transactions.

Design a new class called FilteredAccount whose instances can be used in place of an
Account object but which include the extra behavior of not processing transactions with
a value of 0.
More specifically, the new class should indicate that a zero-valued transaction was
approved but shouldn't call the process method in the Account class to process it.

Your class should have a single constructor that accepts a parameter of type Client,
and it should include the following method:
- public double percentFiltered()	returns the percent of transactions filtered out
(between 0.0 and 100.0);
returns 0.0 if no transactions submitted

Assume that all transactions enter the system by a call on the process method described
above.
 */

public class FilteredAccount extends Account {
    private int zeroCount = 0;
    private int totalProcess = 0;

    public FilteredAccount( Client client ) {
        super(client);
    }

    public boolean process( Transaction t ) {
        // indicates that a zero-valued transaction was approved but
        // shouldn't call the process method in the Account class to process it.

        totalProcess += 1;

        if( t.value() == 0 ) {  // if transaction value == 0, do not process it.
            zeroCount += 1;
            return true;
        }
        return super.process( t );   // else process it
    }

    public double percentFiltered(){
        // returns the percent of transactions filtered out
        // returns 0.0 if no transactions submitted
        if ( this.totalProcess == 0 )
            return 0.0;
        else
            return (double) 100 * this.zeroCount/this.totalProcess;
    }
}