package factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Factory {
    private final String USERNAEM = "root";
    private final String PASSWORD = "root";
    private final String DATABASE_URL = "jdbc:mysql://localhost:3306/aplicativo_java";

    public Connection createConnectionToMySQL() throws Exception {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver funcionando!");
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        Connection conn = null;
        try {
            conn = DriverManager.getConnection(DATABASE_URL, USERNAEM, PASSWORD);
            System.out.println("Conexão obtida!");

            // Do something with the Connection

        } catch (SQLException ex) {
            // handle any errors
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return conn;
    }

}
