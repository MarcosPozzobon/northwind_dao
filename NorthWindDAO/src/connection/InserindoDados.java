package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

import com.mysql.cj.exceptions.UnsupportedConnectionStringException;

public class InserindoDados {
	
	private static final String USER = "root";
    private static final String PASS = "password";
    private static final String URL = "jdbc:mysql://localhost/clientes";
    private static Scanner scanner = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		try {
			
			String sql = "INSERT INTO dados_clientes (id, email, nome_completo) VALUES (?,?,?)";	
			Connection connection = DriverManager.getConnection(URL, USER, PASS);
			PreparedStatement stmt = connection.prepareStatement(sql);
			
			System.out.println("Digite o id a ser inserido na tabela: ");
			String id_inserido = scanner.nextLine();
			
			System.out.println("Digite o nome a ser inserido na tabela: ");
			String nome_inserido = scanner.nextLine();
			
			System.out.println("Digite o email a ser inserido na tabela: ");
			String email_inserido = scanner.nextLine();
			
			stmt.setString(1, id_inserido);
			stmt.setString(2, email_inserido);
			stmt.setString(3, nome_inserido);
			
			stmt.execute();
			
			System.out.println("Dados atualizados!");

			
		} catch (Exception e) {
			throw new UnsupportedConnectionStringException("Algum erro de configuração ocorreu! Revisar o código.");
		}
		
	}

}
