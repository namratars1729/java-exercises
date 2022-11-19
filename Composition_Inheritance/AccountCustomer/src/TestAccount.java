public class TestAccount {
    public static void main(String[] args) {
        // Test Constructors
        Account a1 = new Account(123456789,
                                 new Customer(189, "Namrata", 'f'),
                                 2000.45 );
        Account a2 = new Account(456789123,
                                 new Customer( 23, "Aaaaaaa", 'm') ) ;

        // Test toString()
        System.out.println("\nAccount1 = " + a1 +
                "\nAccount2 = " + a2);

        // Test getters
        System.out.println("\na1 Account # " + a1.getID() );
        System.out.println("a1 Account getCustomer(): " + a1.getCustomer() );
        System.out.println("a1 Account customer name: " + a1.getCustomerName() );
        System.out.println("a1 Balance = " + a1.getBalance() );
        System.out.println("a1 withdraw 1000 ---> " + a1.withdraw( 1000 ) );
        System.out.println("a1 Balance after withdrawing 1000 = " + a1.getBalance() );

        try{
            a1.withdraw( 2000 );
        }
        catch (IllegalArgumentException e){
            System.out.println("\nAmount withdrawn exceeds the current balance! ");
        }

        System.out.println("a1 deposit 3000 ---> " + a1.deposit( 3000 ) );
        System.out.println("a1 Balance after deposit 3000 = " + a1.getBalance() );
        System.out.println("a1 withdraw 1000 ---> " + a1.withdraw( 1000 ) );
        System.out.println("a1 Balance after withdrawing 1000 = " + a1.getBalance() );

        System.out.println("\na2 Account # " + a2.getID() );
        System.out.println("a2 Account getCustomer(): " + a2.getCustomer() );
        System.out.println("a2 Account customer name: " + a2.getCustomerName() );
        System.out.println("a2 Balance = " + a2.getBalance() );
        a2.setBalance(50);
        System.out.println("a2 setBalance(50) ---> ");
        System.out.println("a2 Balance after setting 50 = " + a2.getBalance() );

        // Test chaining
        try {
            a2.withdraw(300);
        }
        catch (IllegalArgumentException e) {
            System.out.println("\nAmount withdrawn exceeds the current balance! ");
            System.out.println("\nChaining.......deposit(5000).withdraw(1000");
            a2.deposit(5000).withdraw(1000);
            System.out.println("After chaining....\na1 balance = " + a2.getBalance() );
        }

    }
}
