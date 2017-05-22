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
	 * Este método procura o Usuário no banco e faz o login se encotrá-lo
	 ***********************************************************************/
	public void logar(Login l) {

		Connection conexao = ModuloConexao.conector();
		PreparedStatement pst = null;
		ResultSet rs = null;	

		String sql = "select * from funcionarios where login_func=? and senha_func =?";
		try {
			// as linhas abaixo preparam a consulta ao banco em
			// função do que foi digitado nas caixas de texto
			// o ? é substituido pelos conteúdos de getLogin e getPassword.
			pst = conexao.prepareStatement(sql);
			pst.setString(1, l.getLogin());
			pst.setString(2, l.getPassword());

			// a linha abaixo executa a query(consulta a banco de dados)
			rs = pst.executeQuery();
			
			// se existir usuário e senha correspondente
			if (rs.next()) {

				TelaControle ObjTelaControle = new TelaControle();
				ObjTelaControle.setVisible(true);							
				conexao.close();
			} else {
				JOptionPane.showMessageDialog(null, "Usuário e/ou senha inválido(s)");
			}

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e);
		}
	}

}
