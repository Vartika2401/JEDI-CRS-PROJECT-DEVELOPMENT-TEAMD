package CRS_JEDI_FLIPKART_JAVA_POS.src.com.flipkart.utils;

/**
 * Author: Group-D
 * Vartika
 * Rohan Mitra
 * Rishabh Verma
 * Shivali Gupta
 * Srujana Sri
 * Asritha Dama
 * Prajwal Rayal
 **/

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBUtils {

    /**
     * Establishes and returns a connection to the database.
     * @return The connection to the database
     */
    public static Connection getConnection() {
        Connection connection = null;
        if (connection != null)
            return connection;
        else {
            try {
                Properties prop = new Properties();
                InputStream inputStream = new FileInputStream("CRS_JEDI_FLIPKART_JAVA_POS/src/com/flipkart/config.properties");
                prop.load(inputStream);
                String driver = prop.getProperty("driver");
                String url = prop.getProperty("url");
                String user = prop.getProperty("user");
                String password = prop.getProperty("password");
                Class.forName(driver);
                connection = DriverManager.getConnection(url, user, password);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return connection;
        }
    }
}
