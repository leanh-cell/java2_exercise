import java.sql.*;

public class JbdcSelectTest { //Save as "JdbcSelectTest.java" (JDK 7 and above)
    public static void main(String[] args) {
        try(
                Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ebookshop", "root",""); //For MySQL only
                //The format is: "jdbc:mysql://hostname:port/databaseName", "user", "password"
                //Step 2: Allocate a 'Statement' object in the Connection
                Statement stmt = conn.createStatement();
        ) {
            String strSelect = "select title, price, qty from books";
            System.out.println("The SQL statement is: " + strSelect + "\n");

            ResultSet rset = stmt.executeQuery(strSelect);

            System.out.println("The records selected are: ");
            int rowCount = 0;
            while (rset.next()){
                String title = rset.getString("title");
                double price = rset.getDouble("price");
                int qty = rset.getInt("qty");
                System.out.println(title + " , " + price + ", " + qty);
                ++rowCount;
            }
            System.out.println("Total number of records = " + rowCount);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
