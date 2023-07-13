package connection;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.mysql.cj.MysqlConnection;


public class ConnectionFactory {
	
	
	public static Connection connection = null;
	public static PreparedStatement stmt = null;
	public static ResultSet rs = null;

	// COMEÇA A CONEXÃO COM O BANCO
	public synchronized static final Connection getConnection(){
		
	    try {
	        String USER = "root";
	        String PASS = "password";
	        String URL = "jdbc:mysql://localhost/northwind";

	        Connection connection = DriverManager.getConnection(URL, USER, PASS);

	        return connection;
	    } catch (Exception e) {
	        e.printStackTrace();
	        return null;
	    }
	}
	
	//MOSTRA OS CLIENTES
	public synchronized static final Connection viewCustomers() {
	    Connection connection = null;

	    try {
	        String sql = "SELECT * FROM customers";

	        connection = ConnectionFactory.getConnection();
	        PreparedStatement stmt = connection.prepareStatement(sql);
	        ResultSet rs = stmt.executeQuery();

	        while (rs.next()) {
	            int id = rs.getInt("id");
	            String name = rs.getString("first_name");
	            String last_name = rs.getString("last_name");

	            System.out.println("ID: " + id + " NAME: " + name + " LAST NAME: " + last_name);
	        }

	        rs.close();
	        stmt.close();
	    } catch (Exception e) {
	        e.printStackTrace();
	    } finally {
	        try {
	            if (connection != null) {
	                connection.close();
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }

	    return connection;
	}
	
	
	// MOSTRA OS TIPOS DE TRANSAÇÕES FEITAS NO INVENTÁRIO
	public synchronized static final Connection viewInventoryTransactionTypes() {
	    Connection connection = null;
	    PreparedStatement stmt = null;
	    ResultSet rs = null;
	    
	    try {
	        connection = ConnectionFactory.getConnection();
	        String sql = "SELECT * FROM inventory_transaction_types";
	        stmt = connection.prepareStatement(sql);
	        rs = stmt.executeQuery();
	        
	        while (rs.next()) {
	            int id = rs.getInt("id");
	            String type_name = rs.getString("type_name");

	            System.out.println("ID: " + id);
	            System.out.println("TYPE NAME: " + type_name);
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } finally {
	        try {
	            if (rs != null) {
	                rs.close();
	            }
	            if (stmt != null) {
	                stmt.close();
	            }
	            if (connection != null) {
	                connection.close();
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
	    return connection;
	}
	
	
	// MOSTRA OS PRIVILEGIOS DOS EMPREGADOS
	public synchronized static final Connection viewEmployeePrivileges() {
		
		try {
			
			Connection connection = null;
			String sql = "SELECT * FROM employee_privilege";
			connection = ConnectionFactory.getConnection();
			PreparedStatement stmt = connection.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				int employee_id = rs.getInt("employee_id");
				int privilege_id = rs.getInt("privilege_id");
				
				System.out.println("EMPLOYEE: " + employee_id + " PRIVILEGE: " + privilege_id);
			}
			
			stmt.close();
			rs.close();
			connection.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return connection;
	}
	
	
	// MOSTRA UMA LISTA DOS EMPREGADOS
	public synchronized static final Connection showEmployees() {
		
		try {
			String sql = null;
			Connection connection = null;
			PreparedStatement stmt = null;
			ResultSet rs = null;
			
			
			connection = ConnectionFactory.getConnection();
			stmt = connection.prepareStatement(sql);
			rs = stmt.executeQuery();
			sql = "SELECT * FROM employees";
			while(rs.next()) {
				int id = rs.getInt("id");
				String company = rs.getString("company");
				String last_name = rs.getString("last_name");
				String first_name = rs.getString("first_name");
				String email_adress = rs.getString("email_adress");
				
				
				System.out.println("ID:" + id + " COMPANY: " + company + " LAST NAME: " + last_name + " FIRST NAME: " + first_name + " EMAIL ADRESS: " + email_adress);
			}
			
			connection.close();
			stmt.close();
			rs.close();

		} catch (SQLException e) {
			e.printStackTrace();
		} 
		
		return connection;
		
	}
	
	// MOSTRA OS TIPOS DE TRANSACOES FEITAS NO INVENTARIO
	public synchronized static final Connection ShowInventoryTransactions() {
		
		try {
			
			String sql = null;
			Connection connection = null;
			PreparedStatement stmt = null;
			ResultSet rs = null;
			
			
			connection = ConnectionFactory.getConnection();
			stmt = connection.prepareStatement(sql);
			rs = stmt.executeQuery();
			sql = "SELECT * FROM inventory_transactions";
			while(rs.next()) {
				long id = rs.getLong("id");
				int transaction_type = rs.getInt("transaction_type");
				String transaction_created_date = rs.getString("transaction_created_date");
				String transaction_modified_date = rs.getString("transaction_modified_date");
				long product_id = rs.getLong("product_id");
				double quantity = rs.getDouble("quantity");
				long purchase_order_id = rs.getLong("purchase_order_id");
				long customer_id = rs.getLong("customer_id");
				
				System.out.println("ID: " + id + " TRANSACTION TYPE: " + transaction_type + " TRANSACTION CREATED DATE: " + transaction_created_date +
				" TRANSACTION MODIFIED DATE:" + transaction_modified_date + " PRODUCT ID: " + product_id + " QUANTITY: " + quantity + 
				" PURCHASE ORDER ID: " + purchase_order_id + " CUSTOMER ID: " + customer_id );	
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				
				if(connection != null) {
					connection.close();
				}
				if(stmt != null) {
					stmt.close();
				}
				if(rs != null) {
					rs.close();
				}
				
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return connection;
		
	}
	public synchronized static Connection showInvoices() {
		
		try {
			java.util.Date invoice_date = new java.util.Date();
			String sql;
			Connection connection = null;
			PreparedStatement stmt = null;
			ResultSet rs = null;
			
			sql = "SELECT * FROM invoices";
			connection = ConnectionFactory.getConnection();
			stmt = connection.prepareStatement(sql);
			rs = stmt.executeQuery();
			
			
			while(rs.next()) {
				int id = rs.getInt("id");
				int order_id = rs.getInt("order_id");
				invoice_date = rs.getDate("invoice_date");
				double tax = rs.getInt("tax");
				double shipping = rs.getDouble("shipping");
				double amount_due = rs.getDouble("amount_due");
				
				System.out.println("ID: " + id + " ORDER_ID: " + order_id + " INVOICE_DATE: " +
				invoice_date + " TAX: " + tax + " SHIPPING: " + shipping + " AMOUNT DUE: " + amount_due );
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
		
	}
	
}


