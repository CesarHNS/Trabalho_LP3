package dal;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JOptionPane;

public class ModuloConexao {

	// a linha abaixo chama o driver
	private final static String driver = "com.mysql.jdbc.Driver";

	// armazenando informações referentes ao banco
	private final static String url = "jdbc:mysql://localhost:3306/db_oficina_mecanica?autoReconnect=true&useSSL=false";
	private final static String user = "root";
	private final static String password = "chs123";
	static java.sql.Connection conexao = null;

	// método resonsável por estabelecer a conexão com o banco
	public static Connection conector() {

		// estabelecendo a conexão com o banco
		try {
			Class.forName(driver);
			conexao = DriverManager.getConnection(url, user, password);
			return conexao;

		} catch (ClassNotFoundException | SQLException e) {
			return null;

		}
	}

	public static void closeConnection(Connection conexao) {
		if (conexao != null) {
			try {
				conexao.close();
			} catch (SQLException e) {
				Logger.getLogger(ModuloConexao.class.getName()).log(Level.SEVERE, null, e);
			}

		}
	}
	
	public static void closeConnection(Connection conexao, PreparedStatement pst) {
		
			closeConnection(conexao);
		
			try {
				if(pst != null){
					pst.close();					
				}
			} catch (SQLException e) {
				Logger.getLogger(ModuloConexao.class.getName()).log(Level.SEVERE, null, e);
			}
		
	}
	
	public static void closeConnection(Connection conexao, PreparedStatement pst,ResultSet rs) {
		
		closeConnection(conexao);
		closeConnection(conexao,pst);
		
		try {
			if(rs != null){
				rs.close();					
			}
		} catch (SQLException e) {
			Logger.getLogger(ModuloConexao.class.getName()).log(Level.SEVERE, null, e);
		}
	
}


}
