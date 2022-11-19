// https://practiceit.cs.washington.edu/problem/view/bjp5/chapter9/e10-DiscountBill

import java.util.ArrayList;
import java.util.List;

public class GroceryBill {
    private Employee clerk;
    private List<Item> receipt;
    private double total;
    private double internalDiscount;

    public GroceryBill(Employee clerk) {
        this.clerk = clerk;
        receipt = new ArrayList<Item>();
        total = 0.0;
        internalDiscount = 0.0;
    }

    public void add(Item i) {
        receipt.add(i);
        total += i.getPrice();
        internalDiscount += i.getDiscount();
    }

    public double getTotal() {
        return Math.rint(total * 100) / 100.0;
    }

    public Employee getClerk() {
        return clerk;
    }

    public void printReceipt() {
        System.out.println(this);
    }

    private String valueToString(double value) {
        value = Math.rint(value * 100) / 100.0;
        String result = "" + Math.abs(value);
        if (result.indexOf(".") == result.length() - 2) {
            result += "0";
        }
        result = "$" + result;
        return result;
    }

    public String receiptToString() {
        String build = "items:\n";
        for (int i = 0; i < receipt.size(); i++) {
            build += "   " + receipt.get(i);
            if (i != receipt.size() - 1) {
                build += "\n";
            }
        }
        return build;
    }

    public String toString() {
        return receiptToString() + "\ntotal: " + valueToString(total);
    }

    public String discountToString() {
        return receiptToString() + "\nsub-total: " + valueToString(total) + "\ndiscount: " + valueToString(internalDiscount) + "\ntotal: " + valueToString(total - internalDiscount);
    }

    //----------------- STATIC CLASS EMPLOYEE --------------------------------------------------------------------
    // you need to create the instance of the static nested class because it has instance method getName()
    // But you don't have to create the object of the Outer class because the nested class is static and,
    // static properties, methods, or classes can be accessed without an object.
    public static class Employee {
        private String name;

        public Employee(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }
    }

    //----------------- STATIC CLASS Item --------------------------------------------------------------------
    // you need to create the instance of the static nested class because it has instance methods getPrice(),
    // getDiscount() and valueToString().
    // But you don't have to create the object of the Outer class because the nested class is static and,
    // static properties, methods, or classes can be accessed without an object.

    public static class Item {
        private String name;
        private double price;
        private double discount;

        public Item(String name, double price, double discount) {
            this.name = name;
            this.price = price;
            this.discount = discount;
        }

        public double getPrice() {
            return price;
        }

        public double getDiscount() {
            return discount;
        }

        private String valueToString(double value) {
            String result = "" + Math.abs(value);
            if (result.indexOf(".") == result.length() - 2) {
                result += "0";
            }
            result = "$" + result;
            return result;
        }

        public String toString() {
            return name + " " + valueToString(price) + " (-" + valueToString(discount) + ")";
        }
    }

    // ----------- CLASS DISCOUNTBILL --------------------------------------------------------------------------------

    public static class DiscountBill extends GroceryBill{
        private boolean preferred;
        private static int discountCount;
        private double discountAmount;
        private Item item;

        public DiscountBill( Employee employee, boolean preferred) {
            super( employee );
            this.preferred  = preferred ;
            this.discountCount = 0;
            this.discountAmount = 0.0;
        }

        public int getDiscountCount() {
            if (this.preferred ) {
                this.discountCount++;
                this.discountAmount = item.getDiscount();
            }
            return this.discountCount;
        }

        public double getDiscountAmount() {
            return this.discountAmount;
        }
        public double getDiscountPercent() {
            // returns the percent of the total discount as a percent
            // of what the total would have been otherwise
            return (this.discountAmount * 100)/super.getTotal();
        }
    }
}
