package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ORM {
	
	private static final String USER = "root";
	private static final String PASS = "password";
	private static final String URL = "jdbc:mysql://localhost/clientes";
	private static final Scanner sc = new Scanner(System.in);
	
	private static Cliente novoCliente = new Cliente();
	private static Cliente novoCliente2 = new Cliente();
	
	
	
	public static void main(String[] args) throws SQLException{
		
	
		novoCliente.setNome("Matheus");
		novoCliente.setEmail("matheus@teste.com.br");
		novoCliente.setId(5);
		
		
		novoCliente2.setNome("João");
		novoCliente2.setEmail("joão@teste.com.br");
		novoCliente2.setId(4);
		
		
		
		
		String sql = "INSERT INTO dados_clientes (id, email, nome_completo) VALUES (?, ?, ?)";
		
		Connection conexao = DriverManager.getConnection(URL, USER, PASS);
		PreparedStatement stmt = conexao.prepareStatement(sql);

		
		stmt.setInt(1, novoCliente.getId());
		stmt.setString(2, novoCliente.getEmail());
		stmt.setString(3, novoCliente.getNome());
		stmt.executeUpdate();
		
		
		
		
		System.out.println("Tabela atualizada com sucesso!");
		
		stmt.close();
		conexao.close();
		
	}


}
