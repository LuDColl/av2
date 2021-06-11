package classes.factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conection {
    private final String USERNAEM = "root";
    private final String PASSWORD = "root";
    private final String DATABASE_URL = "jdbc:mysql://localhost:3306/aplicativo_java";
    private Connection conn;

    public Connection createConnectionToMySQL() {
        driverJ();
        conn = null;
        try {
            conn = DriverManager.getConnection(DATABASE_URL, USERNAEM, PASSWORD);
            System.out.println("Conexão obtida!");
        } catch (SQLException ex) {
            System.out.println("Falha na conexção!");
        } finally{
            System.out.println();
        }
        return conn;
    }

    private void driverJ() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver funcionando!");
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally{
            System.out.println();
        }
    }
}
