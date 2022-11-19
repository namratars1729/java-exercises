import java.sql.*;

class Select_1 {
    public static void main(String[] args) throws ClassNotFoundException {
        // check if JDBC Driver class exists
        Class.forName("com.mysql.cj.jdbc.Driver");

        // The database-url is in the form of "jdbc:mysql://{host}:{port}/{database-name}"
        String url = "jdbc:mysql://localhost:3306/ebookshop";
        String userName = "myuser";
        String password = "nrsdbuser";

        try
            // Step 1: Establish connection with the database
            // allocate a Connection object (called conn) via
            // DriverManager.getConnection(database-url, db-user, password)
                (Connection conn = DriverManager.getConnection(url, userName, password) ) {

            System.out.println("Connection created");

            // Step 2: Construct a 'Statement' object called 'stmt' inside the Connection created
            try (Statement stmt = conn.createStatement()) {

                // Step 3: Write a SQL query string.
                String selectQuery = "select title, price, qty from books where price > 20.0";
                System.out.println("The SQL statement is: " + selectQuery + "\n"); // Echo For debugging

                // Execute the SQL query via the 'Statement'.
                // Note: executeQuery() is used while querying the database, and
                //  executeUpdate() to update the database
                //  The query result is returned in a 'ResultSet' object called 'resultSet'.
                // a ResultSet object models the returned table
                try (ResultSet resultSet = stmt.executeQuery(selectQuery);) {

                    // Step 4: Iterate over the 'ResultSet' by scrolling the cursor forward via next().
                    //  For each row, retrieve the contents of the cells with getXxx(columnName).
                    System.out.println("The records selected are:");

                    // Row-cursor is initially positioned BEFORE the first row of the 'ResultSet'.
                    // resultSet.next() inside the whole-loop repeatedly moves the cursor to the next row.
                    // It returns false if no more rows.
                    int rowCount = 0;
                    while (resultSet.next()) {
                        String bookTitle = resultSet.getString("title");
                        double price = resultSet.getDouble("price");
                        int quantity = resultSet.getInt("qty");
                        System.out.println("\t" + bookTitle + ", price = " + price + ", quantity = " + quantity);
                        ++rowCount;
                    }
                    System.out.println("\nTotal number of records = " + rowCount);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } // Step 5: Close conn and stmt - Done automatically by try-with-resources (JDK 7)
    }
}

