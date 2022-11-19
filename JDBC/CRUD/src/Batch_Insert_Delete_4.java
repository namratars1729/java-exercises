import java.sql.*;

/*
Batch Processing allows you to group related SQL statements into a batch and submit them
with one call to the database.
When you send several SQL statements to the database at once, you reduce the amount of
communication overhead, thereby improving performance.

The addBatch() method of Statement, PreparedStatement, and CallableStatement is used to add
individual statements to the batch.
- The executeBatch() is used to start the execution of all the statements grouped together.
- The executeBatch() returns an int[], and each element of the array represents the update
  count for the respective update statement.
- Just as you can add statements to a batch for processing, you can remove them with
  the clearBatch() method.
  This method removes all the statements you added with the addBatch() method.
  However, you cannot selectively choose which statement to remove.

Here is a typical sequence of steps to use Batch Processing with Statement object:
1) Create a Statement object using any of the createStatement() methods.
2) Set auto-commit to false using setAutoCommit().
3) Add as many as SQL statements you like into batch using addBatch() method
   on the created statement object.
4) Execute all the SQL statements using executeBatch() method on created statement object.
5) Finally, COMMIT all the changes using commit() method.
 */


public class Batch_Insert_Delete_4 {
    private static final String dbName = "ebookshop";
    private static final String url = "jdbc:mysql://localhost:3306/" + dbName;
    private static final String username = "myuser";
    private static final String password = "nrsdbuser";

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName( "com.mysql.cj.jdbc.Driver" );

        String sqlInsert = "INSERT INTO books VALUES( ?, ?, ?, ?, ? )";
        String sqlDelete = "DELETE FROM books WHERE id >=100 AND id <= 105";

        Savepoint save1 = null;

        try( Connection conn = DriverManager.getConnection( url, username, password ) )
        {
            System.out.println("Connection established");

            // Turn off auto-commit for each SQL statement
          //  conn.setAutoCommit( false );

            try( PreparedStatement prepStmt = conn.prepareStatement( sqlInsert, PreparedStatement.RETURN_GENERATED_KEYS );
                 Statement delStmt = conn.createStatement(); )
            {
                // Set a savepoint
                save1 = conn.setSavepoint();
/*
                // record 1
                prepStmt.setInt(1, 100 );
                prepStmt.setString(2, "Head First Java" );
                prepStmt.setString(3, "Kathy Sierra & Bert Bates");
                prepStmt.setDouble(4, 38.50 );
                prepStmt.setInt(5, 100);
                prepStmt.addBatch();  // add the statement for batch processing

                // record 2
                prepStmt.setInt(1, 101 );
                prepStmt.setString(2, "Java: A Beginner’s Guide" );
                prepStmt.setString(3, "Herbert Schildt");
                prepStmt.setDouble(4, 35.68 );
                prepStmt.setInt(5, 10);
                prepStmt.addBatch();  // add the statement for batch processing

                // record 3
                prepStmt.setInt(1, 102 );
                prepStmt.setString(2, "Java for Dummies " );
                prepStmt.setString(3, "Barry A. Burd");
                prepStmt.setDouble(4, 48 );
                prepStmt.setInt(5, 20);
                prepStmt.addBatch();  // add the statement for batch processing

                // record 4
                prepStmt.setInt(1, 103 );
                prepStmt.setString(2, "Effective Java " );
                prepStmt.setString(3, "Joshua Bloch");
                prepStmt.setDouble(4, 42.49 );
                prepStmt.setInt(5, 15);
                prepStmt.addBatch();  // add the statement for batch processing

                // record 4
                prepStmt.setInt(1, 104 );
                prepStmt.setString(2, "Head First Design Patterns" );
                prepStmt.setString(3, "Eric Freeman");
                prepStmt.setDouble(4, 32.38 );
                prepStmt.setInt(5, 25);
                prepStmt.addBatch();  // add the statement for batch processing

                // record 4
                prepStmt.setInt(1, 105 );
                prepStmt.setString(2, "Spring in Action " );
                prepStmt.setString(3, "Craig Walls and Ryan Breidenbach");
                prepStmt.setDouble(4, 39.51 );
                prepStmt.setInt(5, 8);
                prepStmt.addBatch();  // add the statement for batch processing

                // execute the batch
                // executeBatch() returns an int array, keeping the return codes of all statements
                int[] returnCodes = prepStmt.executeBatch();

                System.out.print("Return codes are: ");
                for (int code: returnCodes )
                    System.out.println( code );

                // commit the update
              //  conn.commit();
*/
                // ---------------- DELETE ------------------------------------------------------------------
        //        conn.setAutoCommit( true );
                int deleteCount = delStmt.executeUpdate( sqlDelete );
                System.out.printf( "%d rows deleted %n", deleteCount );


            } catch (SQLException e) {
                conn.rollback( save1 );
                e.getMessage();
            }
            finally {
                conn.setAutoCommit( true );  //reset auto commit
            }
        }
    }
}


