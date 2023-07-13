package connection;

public class Cliente {
	
	private static String nome;
	private static String email;
	private static int id;
	
	
	
	
	public static String getNome() {
		return nome;
	}
	public static void setNome(String nome) {
		Cliente.nome = nome;
	}
	public static String getEmail() {
		return email;
	}
	public static void setEmail(String email) {
		Cliente.email = email;
	}
	public static int getId() {
		return id;
	}
	public static void setId(int id) {
		Cliente.id = id;
	}
	
}
