import java.sql.*;

/*
There are two types of updates you can perform on a database:
- Update record values
- Delete records

In order to update the database:
1) you need to use a Statement.
2) call the executeUpdate() method, which
   returns an int rowsAffected,
   that tells how many records in the database were affected by the SQL statement.

SQL UPDATE|INSERT|DELETE does not return a table, but an int indicating the number of records affected.
*/

// execute the SQL statement that increases the price by 7% and qty by 1 for id = 1001
// "update books set price = price*1.07, qty = qty+1 where id = 1001"

public class Update_2 {
    public static void main(String ... args) throws ClassNotFoundException {
        // check if JDBC driver exists
        Class.forName("com.mysql.cj.jdbc.Driver");

        // The database-url is in the form of "jdbc:mysql://{host}:{port}/{database-name}"
        String url = "jdbc:mysql://localhost:3306/ebookshop";
        String username = "myuser", password = "nrsdbuser";

        try( Connection conn = DriverManager.getConnection(url, username, password ) ) {
            System.out.println("Connection created");
            try( Statement stmt = conn.createStatement() ) {
                System.out.println("\nBefore ---> ");
                String selectQuery = "select * from books where id = 1001";
                ResultSet resultSet = stmt.executeQuery(selectQuery);
                while (resultSet.next() ) {
                    int id = resultSet.getInt(1);
                    String title = resultSet.getString(2);
                    String author = resultSet.getString(3);
                    double price = resultSet.getDouble(4);
                    int quantity = resultSet.getInt(5);
                    System.out.printf("id = %d, title = %s, author = %s, " +
                                    "price = %.2f, quantity = %d",
                            id, title, author, price, quantity);
                }

                String updateQuery = "update books set price = price * 1.07, qty = qty + 1 where id = 1001";
                System.out.println("\nupdateQuery = " + updateQuery );

                int rowsAffected = stmt.executeUpdate( updateQuery );
                System.out.println( rowsAffected + " records affected.\n" );

                // check if the row is updated
                System.out.println("selectQuery = " + selectQuery );
                ResultSet resultSet2 = stmt.executeQuery( selectQuery );
                System.out.println("\nAfter ---> ");
                while (resultSet2.next() ) {
                    int id2 = resultSet2.getInt(1);
                    String title2 = resultSet2.getString(2);
                    String author2 = resultSet2.getString(3);
                    double price2 = resultSet2.getDouble(4);
                    int quantity2 = resultSet2.getInt(5);
                    System.out.printf("id = %d, title = %s, author = %s, " +
                                    "price = %.2f, quantity = %d",
                                     id2, title2, author2, price2, quantity2);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
