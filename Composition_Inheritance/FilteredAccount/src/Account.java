// https://practiceit.cs.washington.edu/problem/view/bjp5/chapter9/e11-FilteredAccount
public class Account {
    public boolean __processCalled;

    public Account(Client c) {
        __processCalled = false;
    }

    public boolean process(Transaction t) {
        __processCalled = true;
        return t.value() > -100 && t.value() < 1000000;
    }
    // ------------------------------------------------------------

    public class Client {}

    // ------------------------------------------------------------

    public class Transaction {
        private int value;

        public Transaction(int v) {
            value = v;
        }

        public int value() {
            return value;
        }
    }
}