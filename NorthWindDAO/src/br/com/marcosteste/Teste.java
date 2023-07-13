package br.com.marcosteste;

import java.io.File;
import java.io.FileWriter;
import java.util.HashSet;
import java.util.Iterator;
import java.util.function.Consumer;

import javax.json.Json;
import javax.json.JsonObjectBuilder;

import org.json.JSONObject;


public class Teste {
	
	private static File file;
	private static Orders order = new Orders();
	
	
	public static void main(String[] args) {
		
		NorthWindDAO dao = new NorthWindDAO();
		
		//dao.getCustomersJsonList();
		//dao.getJsonOrders();
		dao.generateOrderJsonFile();
		
	}

}
