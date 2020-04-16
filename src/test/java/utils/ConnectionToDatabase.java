package utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.concurrent.TimeUnit;

public class ConnectionToDatabase {
    public static final String NAME = "lv493";
    public static final String PASSWORD = "Lv493-TAQC";
    public static final String URL = "jdbc:mysql://192.168.182.132:3306/opencart";

    private Connection connection;

    public Statement createStatement() throws SQLException {
        if (connection == null) {
            connection  = DriverManager.getConnection(URL, NAME, PASSWORD);
            return connection.createStatement();
        }
        return connection.createStatement();
    }

    public void closeConnection() {
        try {
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            connection = null;
        }
    }
}