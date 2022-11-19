import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

class StockItem_Override_Equals {
    private String stockNumber;
    private String name;
    private double price;
    private int totalStock;

    // ------- constructor
    public StockItem_Override_Equals(String stockNumber,
                                     String name, double price) {
        this.stockNumber = stockNumber;
        this.name = name;
        setPrice( price );
    }

    // ----- override ----------
    // toString()
    @Override
    public String toString() {
        return String.format("Stock #: %s, name: %s, total stocks: %d, price: %.2f",
                              this.stockNumber, this.name, this.totalStock, this.price);
    }

/*
If equal, then same hash codes too.
Same hash codes no guarantee of being equal.
 */

    // override equals() to check stcckNumber
//    @Override
//    public boolean equals(Object obj) {
//        if (this == obj)   // if 2 instances are the same instances
//             return true;
//        if ( obj == null )
//            return false;
//        if ( obj instanceof StockItem_Override_Equals ){
//            StockItem_Override_Equals otherStock = ( StockItem_Override_Equals ) obj;
//            if ( this.stockNumber == otherStock.stockNumber )
//                return true;
//        }
//        return false;
//    }

    // hashcode()
//    @Override
//    public int hashCode() {
//        // 1. start with a prime non-zero number, our initial hash
//        int hash = 7;
//        // 2. For every attribute in the class that contributes to
//        // equality, we need to combine them with our initial hash
//
//        return this.getStockNumber().hashCode();
//    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StockItem_Override_Equals that = (StockItem_Override_Equals) o;
        return getStockNumber().equals(that.getStockNumber()) && getName().equals(that.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash( getStockNumber(), getName() );
    }

    // --------- getters ---------
   public String getStockNumber() {
       return this.stockNumber;
   }

   public String getName() {
        return this.name;
   }

    public int getTotalStock() {
        return this.totalStock;
    }

    public double getPrice() {
        return this.price;
    }

    //----------- setter --------
    public void setPrice(double price) {
        this.price = price;
    }

    // ------ method
    public void increaseTotalStock( int quantity ){
        this.totalStock += quantity;
    }

    public double calculateTotalPrice() {
        return this.totalStock * this.price;
    }

    public static void main(String[] args) {
        Set<StockItem_Override_Equals> stocksSet = new HashSet<>();

        StockItem_Override_Equals stock1 = new StockItem_Override_Equals( "12345", "Java Coffee", 23.03);
        stocksSet.add( stock1 );
        stocksSet.add(
                new StockItem_Override_Equals( "62890", "Book Inc", 50.30) );
        stocksSet.add(
                new StockItem_Override_Equals( "12312", "Facebook", 14.56) );
        stocksSet.add(
                new StockItem_Override_Equals( "13445", "IBM", 26.13) );
        stocksSet.add(
                new StockItem_Override_Equals( "11675", "Dell", 33.33) );

        stocksSet.stream().forEach( System.out :: println);

        StockItem_Override_Equals stock2 = new StockItem_Override_Equals( "12225", "Java Bean", 23.03);

        System.out.println( "\n" + stocksSet.contains( stock1 ) );
        System.out.println( stocksSet.contains(stock2) );
    }
}
