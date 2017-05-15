package dal;

import java.sql.*;

import javax.swing.JOptionPane;

public class ModuloConexao {
	// m�todo resons�vel por estabelecer a conex�o com o banco
	public static Connection conector() {

		java.sql.Connection conexao = null;

		// a linha abaixo chama o driver
		String driver = "com.mysql.jdbc.Driver";

		// armazenando informa��es referentes ao banco
		String url = "jdbc:mysql://localhost:3306/db_oficina_mecanica?autoReconnect=true&useSSL=false";
		String user = "root";
		String password = "chs123";

		// estabelecendo a conex�o com o banco
		try {
			Class.forName(driver);
			conexao = DriverManager.getConnection(url, user, password);
			return conexao;
			
		} catch (Exception e) {
			return null;
		}		

	}

}
