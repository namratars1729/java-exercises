package DiscountRateBeautySaloon;

/*
The class DiscountRate contains only static variables and methods
 */
public class StaticDiscountRate {
    private static final double serviceDiscountPremium = 0.2; // 20%
    private static final double serviceDiscountGold = 0.15; // 15%
    private static final double serviceDiscountSilver = 0.1; // 10%

    // All members receive a flat 10% discount on products
    // purchased (this might change in future).
    private static final double productDiscountPremium = 0.1;
    private static final double productDiscountGold = 0.1;
    private static final double productDiscountSilver = 0.1;

    public static double getServiceDiscountRate(String type){
        double discount;

        switch ( type ) {
            case "PREMIUM":
                discount =  serviceDiscountPremium;
                break;
            case "GOLD":
                discount =  serviceDiscountGold;
                break;
            case "SILVER":
                discount =  serviceDiscountSilver;
                break;
            default:
                discount =  0.0;
       }
       return discount;
    }

    public static double getProductDiscountRate(String type){
        double discount;

        switch ( type ) {
            case "PREMIUM":
                discount =  productDiscountPremium;
                break;
            case "GOLD":
                discount =  productDiscountGold;
                break;
            case "SILVER":
                discount =  productDiscountSilver;
                break;
            default:
                discount = 0.0;
        }
        return discount;
    }
}
