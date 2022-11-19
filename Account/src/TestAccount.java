public class TestAccount {
    public static void main(String[] args) {
        // Test Constructors
        Account a1 = new Account( 5566 ),
                a2 = new Account(1234, 99.9 ) ;

        // Test toString()
        System.out.println("Account1 = " + a1 +
                           "\nAccount2 = " + a2);

        // Test getters
        System.out.println("\na1 Account # " + a1.getNumber() );
        System.out.println("a1 Balance = " + a1.getBalance() );
        System.out.println("a2 Account # " + a2.getNumber() );
        System.out.println("a2 Balance = " + a2.getBalance() );

        // Test credit()
        a1.credit(11.1);
        System.out.println("\n------- a1 balance after credit = " + a1);

        // Test debit()
        try {
            a1.debit(500); // ----Test debit() error
            System.out.println("\n------- a1 balance after debit = " + a1);
        }
        catch (IllegalArgumentException e) {
            //e.printStackTrace();
            System.out.println("\nERROR!!!! Amount exceeded balance....cannot debit the amount");
        }

        // Test transferTo()
        try{
            a2.transferTo(40.0, a1);
            System.out.println("\n------- a1 balance after transfer = " + a1);
            System.out.println("------- a2 balance after transfer = " + a2);
        }
        catch (IllegalArgumentException  ex ){
            System.out.println("\nAmount exceeded the available balance....cannot transfer");
        }

        // Test chaining
        try {
            System.out.println("\nBefore chaining....\na1 balance = " + a1.getBalance() +
                               "\na2 balance = " + a2.getBalance() );
            a1.credit(10).credit(20).debit(5).transferTo(5.5, a2);
            System.out.println("After chaining....\na1 balance = " + a1.getBalance() +
                    "\na2 balance = " + a2.getBalance() );
        }
        catch (IllegalArgumentException e) { }
    }
}
