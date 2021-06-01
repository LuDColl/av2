package factory;

import java.sql.Connection;
import java.sql.DriverManager;

public class AlunoFactory {
    private final String USERNAEM = "root";
    private final String PASSWORD = "root";
    private final String DATABASE_URL = "jdbc:mysql://localhost:3306/aplicativo_java";

    public Connection createConnectionToMySQL() throws Exception {
        Connection connection = null;

        try {
            connection = DriverManager.getConnection(DATABASE_URL, USERNAEM, PASSWORD);
            System.out.println("Conexão obtida!");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return connection;
    }

}
