package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.exceptions.UnsupportedConnectionStringException;

public class TesteConexao {
	
	   private static final String USER = "root";
	   private static final String PASS = "password";
	   private static final String URL = "jdbc:mysql://localhost/clientes";
	
	public static void main(String[] args) {
		
		
		try {
			Connection conexao = DriverManager.getConnection(URL, USER, PASS);
			Statement stmt = conexao.createStatement();
			System.out.println("Conexão realizada com sucesso.");
			
			stmt.close();
			conexao.close();
			
		} catch (Exception e) {
			throw new UnsupportedConnectionStringException("Erro ao conectar-se ao banco de dados.");
		}
		
		
	}

}
