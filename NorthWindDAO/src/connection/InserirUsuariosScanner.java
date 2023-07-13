package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;


public class InserirUsuariosScanner {
	
	private static final String USER = "root";
	private static final String PASS = "password";
	private static final String URL = "jdbc:mysql://localhost/clientes";
	private static final Scanner sc = new Scanner(System.in);
	private static InserirUsuariosScanner main = new InserirUsuariosScanner();
	
	public static void main(String[] args) throws SQLException {
		
	
			
			String sql = "INSERT INTO dados_clientes (id, email, nome_completo)"
					+ "VALUES(?,?,?);";
			
			Connection connection = DriverManager.getConnection(URL, USER, PASS);
			PreparedStatement stmt = connection.prepareStatement(sql);
			
			
			System.out.println("Digite o nome a ser inserido na tabela:  ");
			String new_name = sc.nextLine();
			
			
			System.out.println("Digite o email a ser inserido na tabela:  ");
			String new_email = sc.nextLine();

			
			System.out.println("Digite o id a ser inserido na tabela:  ");
			int new_id = sc.nextInt();
			
			
			stmt.setInt(1, new_id);
			stmt.setString(2, new_email);
			stmt.setString(3, new_name);
			
			stmt.executeUpdate();
			
			System.out.println("Dados inseridos com sucesso na tabela.");
			
			connection.close();
			stmt.close();
			
	}
}
