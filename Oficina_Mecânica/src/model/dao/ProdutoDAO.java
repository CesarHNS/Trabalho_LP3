package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dal.ModuloConexao;
import model.Cliente;
import model.Fornecedor;

public class ProdutoDAO {
	
	public List<Fornecedor> selectFornecedor(Fornecedor f) {
		Connection conexao = ModuloConexao.conector();
		PreparedStatement pst = null;
		ResultSet rs = null;

		List<Fornecedor> fornecedores = new ArrayList<Fornecedor>();

		String sql = "select * from fornecedores";

		try {
			pst = conexao.prepareStatement(sql);
			rs = pst.executeQuery();
			// enquanto existir um valor ele vai guardar no objeto
			while (rs.next()) {
				f = new Fornecedor();

				
				f.setNome(rs.getString("nome_forn"));
				
				fornecedores.add(f);

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			ModuloConexao.closeConnection(conexao, pst, rs);
		}
		return fornecedores;

	}

}
