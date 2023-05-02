package br.edu.ifpb.detranDataBase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoBanco {
	   
	private static Connection conn;

	    public static Connection getConnection() {
	      
	    	if (conn == null) {
	            try {
	                conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/basedetran", "postgres", "12345678");
	                System.out.println("Conexão com o banco de dados estabelecida!");
	            } catch (SQLException e) {
	                System.out.println("Erro ao conectar-se ao banco de dados: " + e.getMessage());
	            }
	        }
	        return conn;
	    }

	    public static void closeConnection() {
	        try {
	            if (conn != null) {
	                conn.close();
	                conn = null;
	            }
	        } catch (SQLException ex) {
	            System.out.println("Erro ao fechar a conexão com o banco de dados: " + ex.getMessage());
	        }
	    }
}
