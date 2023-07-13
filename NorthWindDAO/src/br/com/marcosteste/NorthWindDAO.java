package br.com.marcosteste;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import java.util.List;
import java.util.Properties;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;



import connection.ConnectionFactory;

public class NorthWindDAO {
	
	
	
	
	private static Connection connection = ConnectionFactory.getConnection();
	private static PreparedStatement stmt;
	private static ResultSet rs;
	private static List<Orders> orders = new ArrayList<>();


	// COMEÇA A CONEXÃO COM O BANCO
	public synchronized static final Connection getConnection(){
	    try {
	    	
	        //Properties props = new Properties();
	    	Properties properties = new Properties();
	        FileInputStream in = new FileInputStream("D:\\DADOS DO USUARIO\\Desktop\\TUDO\\porcariada\\projetos\\cfgNorthWind\\config.properties");
	        properties.load(in);
	        in.close();
	        
	        String USER = properties.getProperty("user");
	        String PASS = properties.getProperty("password");
	        String URL = properties.getProperty("url");

	        Connection connection = DriverManager.getConnection(URL, USER, PASS);
	        
	        //System.out.println("Conectado!");

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
			String sql;
			Connection connection = null;
			PreparedStatement stmt = null;
			ResultSet rs = null;
			
			sql = "SELECT * FROM employees";
			connection = ConnectionFactory.getConnection();
			stmt = connection.prepareStatement(sql);
			rs = stmt.executeQuery();
			
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
			
			String sql;
			Connection connection = null;
			PreparedStatement stmt = null;
			ResultSet rs = null;
			
			sql = "SELECT * FROM inventory_transactions";
			connection = ConnectionFactory.getConnection();
			stmt = connection.prepareStatement(sql);
			rs = stmt.executeQuery();
			
			while(rs.next()) {
				long id = rs.getLong("id");
				int transaction_type = rs.getInt("transaction_type");
				String transaction_created_date = rs.getString("transaction_created_date");
				String transaction_modified_date = rs.getString("transaction_modified_date");
				long product_id = rs.getLong("product_id");
				double quantity = rs.getDouble("quantity");
				long purchase_order_id = rs.getLong("purchase_order_id");
				long customer_id = rs.getLong("customer_order_id");
				
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
				
				connection.close();
				stmt.close();
				rs.close();
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return connection;
		
	}
	
	@SuppressWarnings("static-access")
	public synchronized static final List<Orders> showOrders() {
		
		try {
			String sql;
			sql = "SELECT * FROM orders";
			java.util.Date order_date = new java.util.Date();
			java.util.Date shipped_date = new java.util.Date();
			java.util.Date paid_date = new java.util.Date();
			
			ConnectionFactory connection = null;
			PreparedStatement stmt = NorthWindDAO.connection.prepareStatement(sql);
			ResultSet rs = null;
			
			
			
			
			connection.getConnection();
			stmt.execute(sql);
			rs = stmt.executeQuery();
			
			
			while(rs.next()) {
				
				
				Orders ordersInfo = new Orders();
				

				BigDecimal id = rs.getBigDecimal("id");
                BigDecimal employee_id = rs.getBigDecimal("employee_id");
                BigDecimal customer_id = rs.getBigDecimal("customer_id");
                BigDecimal shipper_id = rs.getBigDecimal("shipper_id");
                String ship_name = rs.getString("ship_name");
               // String ship_address = rs.getString("ship_address");
                String ship_city = rs.getString("ship_city");
                String ship_state_province = rs.getString("ship_state_province");
                BigDecimal ship_zip_postal_code = rs.getBigDecimal("ship_zip_postal_code");
               // BigDecimal shipping_fee = rs.getBigDecimal("shipping_fee");
                String payment_type = rs.getString("payment_type");
               // Date paid_date = rs.getDate("paid_date");
               // Date order_date = rs.getDate("order_date");
              //  Date shipped_date = rs.getDate("shipped_date");
				
				ordersInfo.setId(id);
				ordersInfo.setEmployee_id(employee_id);
				ordersInfo.setCustomer_id(customer_id);
				ordersInfo.setShipper_id(shipper_id);
				ordersInfo.setShip_name(ship_name);
				//ordersInfo.setShip_adress(ship_adress);
				ordersInfo.setShip_city(ship_city);
				ordersInfo.setShip_state_province(ship_state_province);
				ordersInfo.setShip_zip_postal_code(ship_zip_postal_code);
				//ordersInfo.setShipping_free(shipping_free);
				ordersInfo.setPayment_type(payment_type);
				ordersInfo.setOrder_date(order_date);
				ordersInfo.setPaid_date(paid_date);
				ordersInfo.setShipped_date(shipped_date);

				//ADICIONA A LISTA
				orders.add(ordersInfo);
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
					stmt.close();
				}
				
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		
		return orders;
		
	}
	
	 public static List<JsonObject> getCustomersJsonList() {
	        List<JsonObject> customersJsonList = new ArrayList<>();

	        try {
	            String sql = "SELECT * FROM customers";
	            Connection connection = ConnectionFactory.getConnection();
	            PreparedStatement stmt = connection.prepareStatement(sql);
	            ResultSet rs = stmt.executeQuery();

	            while (rs.next()) {
	                int id = rs.getInt("id");
	                String company = rs.getString("company");
	                String first_name = rs.getString("first_name");
	                String last_name = rs.getString("last_name");
	                String job_title = rs.getString("job_title");
	                String address = rs.getString("address");
	                String city = rs.getString("city");
	                Long zip_postal_code = rs.getLong("zip_postal_code");

	                JsonObjectBuilder customerJsonBuilder = Json.createObjectBuilder()
	                        .add("id", id);
	                
	                        

	                if (company != null) {
	                    customerJsonBuilder.add("company", company);
	                }

	                if (first_name != null) {
	                    customerJsonBuilder.add("first_name", first_name);
	                }

	                if (last_name != null) {
	                    customerJsonBuilder.add("last_name", last_name);
	                }

	                if (job_title != null) {
	                    customerJsonBuilder.add("job_title", job_title);
	                }

	                if (address != null) {
	                    customerJsonBuilder.add("address", address);
	                }

	                if (city != null) {
	                    customerJsonBuilder.add("city", city);
	                }

	                if (zip_postal_code != null) {
	                    customerJsonBuilder.add("zip_postal_code", zip_postal_code);
	                }

	                JsonObject customerJsonObject = customerJsonBuilder.build();
	                customersJsonList.add(customerJsonObject);
	                
	                
	                
	            }
	            
	          //  for (JsonObject customerJson : customersJsonList) {
	          //      System.out.println(customerJson);
	            //}
	    
	            rs.close();
	            stmt.close();
	            connection.close();
	        } catch (Exception e) {
	            e.printStackTrace();
	        }

	        return customersJsonList;
	    }
	 
	 
	 public synchronized static List<JsonObject> getJsonOrders() {

	        List<JsonObject> ordersJsonList = new ArrayList<>();
	       
	        try {
	            String sql = "SELECT * FROM orders";

	            Connection connection = ConnectionFactory.getConnection();
	            PreparedStatement stmt = connection.prepareStatement(sql);
	            ResultSet rs = stmt.executeQuery();
	               
	            JsonObjectBuilder jsonOrderBuilder = Json.createObjectBuilder();

	            while (rs.next()) {

	                BigDecimal id = rs.getBigDecimal("id");
	                BigDecimal employee_id = rs.getBigDecimal("employee_id");
	                BigDecimal customer_id = rs.getBigDecimal("customer_id");
	                BigDecimal shipper_id = rs.getBigDecimal("shipper_id");
	                String ship_name = rs.getString("ship_name");
	                String ship_address = rs.getString("ship_address");
	                String ship_city = rs.getString("ship_city");
	                String ship_state_province = rs.getString("ship_state_province");
	                BigDecimal ship_zip_postal_code = rs.getBigDecimal("ship_zip_postal_code");
	                BigDecimal shipping_fee = rs.getBigDecimal("shipping_fee");
	                String payment_type = rs.getString("payment_type");
	                Date paid_date = rs.getDate("paid_date");
	                Date order_date = rs.getDate("order_date");
	                Date shipped_date = rs.getDate("shipped_date");

	                
	                Orders orders = new Orders();
	            	Orders.setPaid_date(paid_date);
	            	Orders.setOrder_date(order_date);
	            	Orders.setShipped_date(shipped_date);
	            	
	            	if(id != null) {
	                	jsonOrderBuilder.add("id", id);
	                }
	                if(employee_id != null) {
	                	jsonOrderBuilder.add("employee_id", employee_id);
	                }
	                if(customer_id != null) {
	                	jsonOrderBuilder.add("customer_id", customer_id);
	                }
	                if(shipper_id != null) {
	                	jsonOrderBuilder.add("shipper_id", shipper_id);
	                }
	                if(ship_name != null) {
	                	jsonOrderBuilder.add("ship_name", ship_name);
	                }
	                if(ship_address != null) {
	                	jsonOrderBuilder.add("shipp_adress", ship_address);
	                }
	                if(ship_city != null) {
	                	jsonOrderBuilder.add("ship_city", ship_city);
	                }
	                if(ship_state_province != null) {
	                	 jsonOrderBuilder.add("ship_state_province", ship_state_province);
	                }
	                if(ship_zip_postal_code != null) {
	                	jsonOrderBuilder.add("ship_zip_postal_code", ship_zip_postal_code);
	                }
	                if(shipping_fee != null) {
	                	jsonOrderBuilder.add("shiping_fee", shipping_fee);
	                }
	                if(payment_type != null) {
	                	jsonOrderBuilder.add("payment_type", payment_type);
	                }
	                if(Orders.getPaid_date() != null) {
	                	jsonOrderBuilder.add("paid_date", Orders.getPaid_date().toString());
	                }
	                if(Orders.getOrder_date() != null) {
	                	jsonOrderBuilder.add("order_date", Orders.getOrder_date().toString());
	                }
	                if(Orders.getShipped_date() != null) {
	                	jsonOrderBuilder.add("shipped_date", Orders.getOrder_date().toString());
	                }
	                
	               JsonObject jsonOrder = jsonOrderBuilder.build();
		           ordersJsonList.add(jsonOrder);

	            }

	        } catch (Exception e) {
	            e.printStackTrace();
	        }

	        return ordersJsonList;
	    }
	 
	 public static void generateOrderJsonFile() {
		 
		 try {
			
			 List<JsonObject> ordersJsonList = getJsonOrders(); 
			 
	            StringBuilder sb = new StringBuilder();
	            sb.append(ordersJsonList.toString());

	            FileOutputStream fio = new FileOutputStream("D:\\DADOS DO USUARIO\\Desktop\\Nova pasta\\fodase.json");
	            OutputStreamWriter osw = new OutputStreamWriter(fio, "UTF-8");
	            Writer out = new BufferedWriter(osw);

	            System.out.println("Json gerado com sucesso.");
	            
	            out.write(sb.toString());
	            out.close();
	            osw.close();
	            fio.close();
			 
		} catch (Exception e) {
			e.printStackTrace();
		}
		 
	 }
}

