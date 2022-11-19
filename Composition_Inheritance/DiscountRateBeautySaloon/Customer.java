/*
You are asked to write a discount system for a beauty saloon, which provides services and sells beauty products.
It offers 3 types of memberships: Premium, Gold and Silver.
Premium, gold and silver members receive a discount of 20%, 15%, and 10%, respectively, for all services provided.
Customers without membership receive no discount.
All members receive a flat 10% discount on products purchased (this might change in future).

Your system shall consist of three classes: Customer, Discount and Visit, as shown in the class diagram.
It shall compute the total bill if a customer purchases $x of products and $y of services, for a visit.
 */

package DiscountRateBeautySaloon;

public class Customer {
    private String name, memberType;
    private boolean member;

    // ------ constructor
    public Customer( String name ){
        this.name = name;
        member = false;
        this.memberType = "Non-member";
    }

    // ------ toString()
    @Override
    public String toString() {
        String str = "";
        str = this.member ? "Yes" : "No";
        return String.format("Customer: %s, Member: %s, Membership Type: %s",
                              this.getName(), str, this.getMemberType());
    }

    // -------- getters
    public String getName() {
        return this.name;
    }

    public String getMemberType() {
        return this.memberType;
    }

    // ------ setters
    public void setMember( boolean member) {
        this.member = member;
    }

    public void setMemberType( String type ) {
        switch (type.toUpperCase()) {
            case "PREMIUM":
            case "GOLD":
            case "SILVER":
                this.memberType = type.toUpperCase();
                this.member = true;
                break;
            default:
                this.memberType = "Non-member";
        }
    }

    // --------- methods
    public boolean isMember() {
        return this.member;
    }
}
