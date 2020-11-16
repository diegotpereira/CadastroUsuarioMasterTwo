package br.com.java.dao;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

public class FabricaConexoes {
	
	String driver = "com.mysql.cj.jdbc.Driver";
	String url = "jdbc:mysql://localhost:3306/dbcadastrousuariomastertwo?useSSL=false&serverTimezone=UTC&useLegacyDatetimeCode=false";
	String usuario = "root";
	String senha = "root";
	
	private static FabricaConexoes conexao;
	
	private FabricaConexoes() {
		
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			// TODO: handle exception
			throw new RuntimeException(e);
		}
	}
	public Connection getConnection() throws SQLException {
		
		Connection CON = null;
		CON = DriverManager.getConnection(url, usuario, senha);
		return CON;
		
	}
	public static FabricaConexoes getInstance() {
		if (conexao == null) {
			conexao = new FabricaConexoes();
		}
		return conexao;
		
	}

}
