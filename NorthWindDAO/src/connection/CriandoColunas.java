package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CriandoColunas {

    private static final String USER = "root";
    private static final String PASS = "password";
    private static final String URL = "jdbc:mysql://localhost/clientes";

    private static final String sql = "CREATE TABLE dados_clientes ("
            + "id INT(255) PRIMARY KEY NOT NULL, "
            + "email VARCHAR(255) NOT NULL, "
            + "nome_completo VARCHAR(255) NOT NULL);";

    public static void main(String[] args) throws SQLException {
   
            Connection connection = DriverManager.getConnection(URL, USER, PASS);
            PreparedStatement stmt = connection.prepareStatement(sql);

            stmt.execute();
            stmt.close();
            connection.close();

            System.out.println("Tabela criada com sucesso!");
        
    }
}
