import java.sql.*;

public class Insert_Delete_3 {

    public static void main(String[] args) throws ClassNotFoundException {
        // 1. Check if Driver class exists
        Class.forName("com.mysql.cj.jdbc.Driver");

        // set up the parameters needed for making a Connection object
        // The database-url is in the form of "jdbc:mysql://{host}:{port}/{database-name}"
        String database_name = "ebookshop";
        String url = "jdbc:mysql://localhost:3306/" + database_name;
        String username = "myuser", password = "nrsdbuser";

        // 2. Establish connection and statement objects
        try (
                Connection conn = DriverManager.getConnection( url, username, password );
                Statement statement = conn.createStatement();
        ) {
            System.out.println("Connection created");

            // ============= SINGLE INSERT ======================================================================

            // 3: Write a SQL query string.
            String sqlInsert = "insert into books values(3001, 'Gone Fishing', 'Kumar', 11.11, 11)";

            // 4. Through the statement object executeUpdate() to update the
            // database with the sql query
            // executeUpdate() return an int count of rows affected/modified
            int countInserted = statement.executeUpdate( sqlInsert );
            System.out.println(countInserted + " records inserted.\n");

            // ============= SINGLE DELETE ======================================================================

            String sqlDelete = "delete from books where id > 3000 and id < 4000";
            int countDeleted = statement.executeUpdate( sqlDelete );
            System.out.println( countDeleted + " records deleted.\n" );

        } catch( SQLException e ) {
            e.printStackTrace();
        }
    }
}
