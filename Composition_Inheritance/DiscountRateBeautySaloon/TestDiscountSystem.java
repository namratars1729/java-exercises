package DiscountRateBeautySaloon;

import java.util.Date;

public class TestDiscountSystem {
    public static void main (String[] args) {

        Customer c1 = new Customer("Namrata");
        Customer c2 = new Customer("Pragna");
        Customer c3 = new Customer("Manisha");
        System.out.println("c1 = " + c1 + "\nc2 = " + c2 + "\nc3 = " + c3);

        c2.setMemberType("premium");
        c3.setMemberType("gold");
        System.out.println("\nc1 = " + c1 + "\nc2 = " + c2 + "\nc3 = " + c3);


        Visit v1 = new Visit( c1.getName(), new Date(2022, 10, 02) );
        Visit v2 = new Visit( c2.getName(), new Date(2022, 06, 15) );
        Visit v3 = new Visit( c3.getName(), new Date(2015, 01, 01) );
        System.out.println("\nv1 = " + v1 + "\nv2 = " + v2 + "\nv3 = " + v3 );
//
//        v1.setProductExpense(4.5);
//        v1.setServiceExpense(8.5);
//        v1.setProductExpense(1.5);
//        System.out.println(v1.toString());
//        System.out.println("Total expense made by " + v1.getName() + " = " + v1.getTotalExpense());

    }
}
