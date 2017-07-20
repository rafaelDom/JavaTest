package testejava.conexaosql;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Conexao {

	private Connection con; // Variável de conexão que passará a url de conexão
	private Statement smt; 
	public ResultSet msql;
	static final String jdbcDriver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
	static final String databaseUrl = "jdbc:sqlserver://SUPORTE02\\IMPORTACAO;databaseName=testeJava";
	static final String user = "sa";
	static final String password = "43690Windows";

	public Connection conecta() {
		try {
			Class.forName(jdbcDriver);
			//System.out.println("Driver carregado");
			try {
				con = java.sql.DriverManager.getConnection(databaseUrl, user,
						password);
				//System.out.println("Connectado!!!");
			} catch (SQLException ex) {
				Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE,
						null, ex);
				System.out.println("Problema com SQL!");
				ex.printStackTrace();
			}
		} catch (ClassNotFoundException ex) {
			Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null,
					ex);
			ex.printStackTrace();
			System.out.println("Não carregou o Driver!");
		}
		return con;
	}

}
