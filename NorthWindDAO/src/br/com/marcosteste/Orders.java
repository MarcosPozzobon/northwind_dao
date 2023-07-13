package br.com.marcosteste;

import java.util.*;
import java.math.BigDecimal;
import java.util.Date;

public class Orders {
	
	
	    private static BigDecimal id;
	    
	    private static BigDecimal employee_id;
	    
	    private static BigDecimal customer_id;
	    
	    private static Date order_date;
	    
	    private static Date shipped_date; 
	    
	    private static BigDecimal shipper_id;
	    
	    private static String ship_name; 
	    
	    private static String ship_adress; 
	    
	    private static String ship_city; 
	    
	    private static String ship_state_province; 
	    
	    private static BigDecimal ship_zip_postal_code; 
	    
	    private static BigDecimal shipping_free; 
	    
	    private static String payment_type; 
	    
	    private static Date paid_date;

		public static BigDecimal getId() {
			return id;
		}

		public static void setId(BigDecimal id) {
			Orders.id = id;
		}

		public static BigDecimal getEmployee_id() {
			return employee_id;
		}

		public static void setEmployee_id(BigDecimal employee_id) {
			Orders.employee_id = employee_id;
		}

		public static BigDecimal getCustomer_id() {
			return customer_id;
		}

		public static void setCustomer_id(BigDecimal customer_id) {
			Orders.customer_id = customer_id;
		}

		public static Date getOrder_date() {
			return order_date;
		}

		public static void setOrder_date(Date order_date) {
			Orders.order_date = order_date;
		}

		public static Date getShipped_date() {
			return shipped_date;
		}

		public static void setShipped_date(Date shipped_date) {
			Orders.shipped_date = shipped_date;
		}

		public static BigDecimal getShipper_id() {
			return shipper_id;
		}

		public static void setShipper_id(BigDecimal shipper_id) {
			Orders.shipper_id = shipper_id;
		}

		public static String getShip_name() {
			return ship_name;
		}

		public static void setShip_name(String ship_name) {
			Orders.ship_name = ship_name;
		}

		public static String getShip_adress() {
			return ship_adress;
		}

		public static void setShip_adress(String ship_adress) {
			Orders.ship_adress = ship_adress;
		}

		public static String getShip_city() {
			return ship_city;
		}

		public static void setShip_city(String ship_city) {
			Orders.ship_city = ship_city;
		}

		public static String getShip_state_province() {
			return ship_state_province;
		}

		public static void setShip_state_province(String ship_state_province) {
			Orders.ship_state_province = ship_state_province;
		}

		public static BigDecimal getShip_zip_postal_code() {
			return ship_zip_postal_code;
		}

		public static void setShip_zip_postal_code(BigDecimal ship_zip_postal_code) {
			Orders.ship_zip_postal_code = ship_zip_postal_code;
		}

		public static BigDecimal getShipping_free() {
			return shipping_free;
		}

		public static void setShipping_free(BigDecimal shipping_free) {
			Orders.shipping_free = shipping_free;
		}

		public static String getPayment_type() {
			return payment_type;
		}

		public static void setPayment_type(String payment_type) {
			Orders.payment_type = payment_type;
		}

		public static Date getPaid_date() {
			return paid_date;
		}

		public static void setPaid_date(Date paid_date) {
			Orders.paid_date = paid_date;
		}
	    
	    
	
}

