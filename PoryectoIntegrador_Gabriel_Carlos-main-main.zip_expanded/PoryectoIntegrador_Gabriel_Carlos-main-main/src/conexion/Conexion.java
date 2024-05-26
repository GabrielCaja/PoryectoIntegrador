package conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
	private String url, user, pass;
	private static Connection conn = null;
	
	private Conexion() {
		this.url = "jdbc:mysql://localhost:3306/proyectointegrador?serverTimezone=Europe/Madrid&amp";
		this.user = "root";
		this.pass = "";
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(url, user, pass);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static Connection getConnection() {
		if(conn==null) {
			new Conexion();
		}
		return conn;
	}
}
