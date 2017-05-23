package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import dal.ModuloConexao;
import model.Cliente;
import model.Fornecedor;

public class FornecedorDAO {
	public void create(Fornecedor f) {
		Connection conexao = ModuloConexao.conector();
		PreparedStatement pst = null;

		String sql = "insert into fornecedores (codigo_forn,nome_forn,telefone_forn,email_forn,celular_forn,cnpj_forn,endereco_forn,bairro_forn,cep_forn,cidade_forn,estado_forn) values(?,?,?,?,?,?,?,?,?,?,?)";

		try {
			pst = conexao.prepareStatement(sql);

			pst.setShort(1, f.getId());
			pst.setString(2, f.getNome());
			pst.setString(3, f.getTelefone());
			pst.setString(4, f.getEmail());
			pst.setString(5, f.getCelular());
			pst.setString(6, f.getCnpj());
			pst.setString(7, f.getEndereco());
			pst.setString(8, f.getBairro());
			pst.setString(9, f.getCep());
			pst.setString(10, f.getCidade());
			pst.setString(11, f.getEstado());			

			pst.executeUpdate();

			JOptionPane.showMessageDialog(null, "Salvo com sucesso");
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Erro ao salvar: " + e);
		} finally {
			ModuloConexao.closeConnection(conexao, pst);
		}

	}

	public void update(Fornecedor f) {

		Connection conexao = ModuloConexao.conector();
		PreparedStatement pst = null;

		String sql = "UPDATE fornecedores SET codigo_forn=?,nome_forn=?,telefone_forn=?,email_forn=?,celular_forn=?,cnpj_forn=?,endereco_forn=?,bairro_forn=?,cep_forn=?,cidade_forn=?,estado_forn=? WHERE codigo_forn=?";
		try {
			pst = conexao.prepareStatement(sql);

			pst.setShort(1, f.getId());
			pst.setString(2, f.getNome());
			pst.setString(3, f.getTelefone());
			pst.setString(4, f.getEmail());
			pst.setString(5, f.getCelular());
			pst.setString(6, f.getCnpj());
			pst.setString(7, f.getEndereco());
			pst.setString(8, f.getBairro());
			pst.setString(9, f.getCep());
			pst.setString(10, f.getCidade());
			pst.setString(11, f.getEstado());
			pst.setShort(12, f.getId());

			pst.executeUpdate();
			JOptionPane.showMessageDialog(null, "Modificado com sucesso");
			
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Erro ao modificar: " + e);
		} finally {
			ModuloConexao.closeConnection(conexao, pst);
		}
	}

	public void delete(short id) {
		Connection conexao = ModuloConexao.conector();
		PreparedStatement pst = null;

		String sql = "delete from fornecedores where codigo_forn = ?";
		try {
			pst = conexao.prepareStatement(sql);

			pst.setShort(1, id);

			pst.executeUpdate();

			JOptionPane.showMessageDialog(null, "Deletado com sucesso");
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Erro ao deletar: " + e);
		} finally {
			ModuloConexao.closeConnection(conexao, pst);
		}
	}

	// seleciona todos os clientes da classe clientes
	public List<Fornecedor> read(Fornecedor f) {
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

				f.setId(rs.getShort("codigo_forn"));
				f.setNome(rs.getString("nome_forn"));
				f.setTelefone(rs.getString("telefone_forn"));
				f.setEmail(rs.getString("email_forn"));
				f.setCelular(rs.getString("celular_forn"));
				f.setCnpj(rs.getString("cnpj_forn"));
				f.setEndereco(rs.getString("endereco_forn"));
				f.setBairro(rs.getString("bairro_forn"));
				f.setCep(rs.getString("cep_forn"));
				f.setCidade(rs.getString("cidade_forn"));
				f.setEstado(rs.getString("estado_forn"));
				
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
