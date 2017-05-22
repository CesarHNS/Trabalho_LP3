package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JOptionPane;

import dal.ModuloConexao;
import model.Login;
import view.TelaControle;
import view.TelaLogin;

public class LoginDAO {

	/************************************************************************
	 * Este m�todo procura o Usu�rio no banco e faz o login se encotr�-lo
	 ***********************************************************************/
	public void logar(Login l) {

		Connection conexao = ModuloConexao.conector();
		PreparedStatement pst = null;
		ResultSet rs = null;	

		String sql = "select * from funcionarios where login_func=? and senha_func =?";
		try {
			// as linhas abaixo preparam a consulta ao banco em
			// fun��o do que foi digitado nas caixas de texto
			// o ? � substituido pelos conte�dos de getLogin e getPassword.
			pst = conexao.prepareStatement(sql);
			pst.setString(1, l.getLogin());
			pst.setString(2, l.getPassword());

			// a linha abaixo executa a query(consulta a banco de dados)
			rs = pst.executeQuery();
			
			// se existir usu�rio e senha correspondente
			if (rs.next()) {

				TelaControle ObjTelaControle = new TelaControle();
				ObjTelaControle.setVisible(true);							
				conexao.close();
			} else {
				JOptionPane.showMessageDialog(null, "Usu�rio e/ou senha inv�lido(s)");
			}

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e);
		}
	}

}
