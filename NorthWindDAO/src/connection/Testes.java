package connection;

import java.sql.Connection;

import br.com.marcosteste.NorthWindDAO;

public class Testes {
	
	public static void main(String[] args) {
		
		
		Connection teste = ConnectionFactory.getConnection();
		NorthWindDAO dao = new NorthWindDAO();
		
		dao.ShowInventoryTransactions();
		//dao.getConnection();
		//primeiroMetodo.viewInventoryTransactionTypes();
		
		
		
	}
	
}
