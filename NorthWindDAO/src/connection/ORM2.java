package connection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ORM2 {
    
    public static void main(String[] args) {
		
    	try {
    		
    		Connection connection = ConnectionFactory.viewCustomers();
    		
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
