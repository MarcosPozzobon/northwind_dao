package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class InserindoColuna {
	
	private static final String USER = "root";
	private static final String PASS = "password";
	private static final String URL = "jdbc:mysql://localhost/northwind";
	
	public static void main(String[] args) {
		
		try {
			
			String sql = "CREATE TABLE produtos("
				    + "id INT NOT NULL PRIMARY KEY,"
				    + "product_name VARCHAR(255) NOT NULL,"
				    + "price INT NOT NULL"
				    + ");";

			
			Connection connection = DriverManager.getConnection(URL, USER, PASS);
			PreparedStatement stmt = connection.prepareStatement(sql);
			
			
			stmt.execute();
			
			System.out.println("Tabela criada com sucesso!");
			
			stmt.close();
			connection.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
