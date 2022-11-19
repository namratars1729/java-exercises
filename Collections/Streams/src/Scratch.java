import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class Product {
    private String stockNumber;
    private String manufacturer;
    private String item;
    private double unitPrice;

    public Product (String stockNumberIn, String manufacturerIn, String itemIn, double unitPriceIn)     {
        stockNumber = stockNumberIn;
        manufacturer = manufacturerIn;
        item = itemIn;
        unitPrice = unitPriceIn;
    }

    public Product() { }

    @Override
    public String toString() {
        return stockNumber + " " + manufacturer + " " + item + " " + unitPrice;
    }

    public String getStockNumber() {
        return stockNumber;
    }

    public void setStockNumber(String stockNumberIn) {
        stockNumber = stockNumberIn;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturerIn) {
        manufacturer = manufacturerIn;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String itemIn) {
        item = itemIn;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPriceIn) {
        unitPrice = unitPriceIn;
    }
}

public class Scratch {
    public static void main(String[] args) {
        List<Product> productList = new ArrayList<>(); // create a list of products
        int count = 0;

        // add four products to the list
        productList.add(new Product("1076543", "Acme", "Vacuum Cleaner", 180.11));
        productList.add(new Product("3756354", "Nadir", "Washing Machine", 178.97));
        productList.add(new Product("1234567", "Zenith", "Fridge", 151.98));
        productList.add(new Product("7876161", "Zenith", "Tumble Drier", 159.99));

        // Display All items
        System.out.println("All items - ");
        productList.stream()
                .forEach(prod -> System.out.println( prod.getManufacturer() + " " +
                                                     prod.getItem() + " " +
                                                     prod.getUnitPrice() ) );

        // ITEMS COSTING LESS THAN 170
        System.out.println("\nItems costing < 170 - ");
        productList.stream()
                .filter( prod -> prod.getUnitPrice() < 170)
                .forEach( prod -> System.out.println( prod.getManufacturer() + " " +
                                                        prod.getItem() + " " +
                                                        prod.getUnitPrice() ));

        // There are 2 items costing less than 170
        Integer countLess170 = productList.stream()
                .filter( prod -> prod.getUnitPrice() < 170)
                .collect( Collectors.collectingAndThen(
                                                Collectors.counting(), Long::intValue ) );
        System.out.println("\nThere are " + countLess170 + " items costing less than 170\n");

        Stream<String> colors = Stream.of( "Purple", "Blue", "Red", "Yellow", "Green",
                                            "Yellow", "Purple", "Orange", "Black");
        // get the 1st 2 char of the colors
        colors.distinct()
                .sorted()
                .map( color -> color.substring(0, 2) )
                .collect( Collectors.collectingAndThen(
                        Collectors.joining( ","), System.out::print ) );
    }
}
