package sergii.kryvenko.selenium;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class AppTestJDBC {
    
    public static final String QUERY = "SELECT * FROM opencart.oc_product_description";
    
    
    public static void main(String[] args) {

        String jdbcUrl = "jdbc:mysql://192.168.88.128:3306/opencart?useSSL=false&serverTimezone=UTC";
        String user = "lv493";
        String pass = "lv493_Taqc";
        try {
            System.out.println("Connection to database: " + jdbcUrl);
            
            Connection myConn = DriverManager.getConnection(jdbcUrl, user, pass);
            
            System.out.println("Connecton successful!");
            
            Statement statement = myConn.createStatement();
            
            try (ResultSet result = statement.executeQuery(QUERY)) {

                ResultSetMetaData meta = result.getMetaData();
                int numColumns = meta.getColumnCount();
                for (int i = 1; i <= numColumns; i++) {
                    System.out.printf("Column %d in the songs table is names %s\n", i, meta.getColumnName(i));
                }
            } catch (SQLException e) {
                System.out.println("Query failed: " + e.getMessage());
            }
            
            System.out.println("---------------------------------");
            ResultSet result = statement.executeQuery(QUERY);
            while (result.next()) {
                System.out.println(result.getString(3));
            }
            
            statement.close();
            myConn.close();
            
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}
