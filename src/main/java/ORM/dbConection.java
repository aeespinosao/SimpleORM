package ORM;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class dbConection {

	public static Connection getConnection() throws Exception {

        /*Este info se debe leer desde un archovi de configuracion*/
        String url = "jdbc:mysql://localhost:3306/";
        String dbName = "orm";
        String driver = "com.mysql.jdbc.Driver";
        String userName = "adminAndres";
        String password = "Andres300594";

        Class.forName("com.mysql.jdbc.Driver").newInstance();
        Connection conn;
        try {

            conn = DriverManager.getConnection(url + dbName, userName,password);

        } catch (SQLException e) {
            return null;
        }
       
        return conn;
    }
	
	public static void closeConnection(Connection conn) {

        try {

            conn.close();

        } catch (SQLException e) {

        }

    }
        
        public static void executeQuery(String query) {
            try {
                Connection conn = getConnection();
                Statement statement = conn.createStatement();  
                int rs= statement.executeUpdate(query); 
            } catch (Exception ex) {
                Logger.getLogger(dbConection.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
	
	
}
