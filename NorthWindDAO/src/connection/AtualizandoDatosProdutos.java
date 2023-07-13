package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class AtualizandoDatosProdutos {
	

	private static final String USER = "root";
	private static final String PASS = "password";
	private static final String URL = "jdbc:mysql://localhost/northwind";
	
	
	public static void main(String[] args) {
		
		
		try {
	
			String sql = "SELECT * FROM products;";
			
			Connection connection = DriverManager.getConnection(URL, USER, PASS);
			PreparedStatement stmt = connection.prepareStatement(sql);
			
			ResultSet rs = stmt.executeQuery();
			rs.getArray(1);
			
			   while (rs.next()) {
	                int productId = rs.getInt("id");
	                String productName = rs.getString("product_name");
	                double price = rs.getDouble("price");

	                // Fazer algo com os dados obtidos
	                System.out.println("ID: " + productId + ", Nome do Produto: " + productName + ", Preço: " + price);
	            }

			stmt.close();
			connection.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
