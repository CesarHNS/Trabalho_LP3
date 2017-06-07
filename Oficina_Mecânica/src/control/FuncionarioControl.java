package control;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import dal.ModuloConexao;
import model.Cliente;
import model.Funcionario;

public class FuncionarioControl {
	String nomeFunc;
	short codFunc;

	public void create(Funcionario c) {
		Connection conexao = ModuloConexao.conector();
		PreparedStatement pst = null;

		String sql = "insert into funcionarios (codigo_func,nome_func,cpf_func,senha_func,login_func,cargo_func,endereco_func,bairro_func,cep_func,cidade_func,estado_func,email_func,telefone_func,celular_func) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

		try {
			pst = conexao.prepareStatement(sql);

			pst.setShort(1, c.getCodigo());
			pst.setString(2, c.getNome());
			pst.setString(3, c.getCpf());
			pst.setString(4, c.getSenha());
			pst.setString(5, c.getLogin());
			pst.setString(6, c.getCargo());
			pst.setString(7, c.getEndereco());
			pst.setString(8, c.getBairro());
			pst.setString(9, c.getCep());
			pst.setString(10, c.getCidade());
			pst.setString(11, c.getEstado());
			pst.setString(12, c.getEmail());
			pst.setString(13, c.getTelefone());
			pst.setString(14, c.getCelular());

			pst.executeUpdate();

			JOptionPane.showMessageDialog(null, "Salvo com sucesso");
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Erro ao salvar: " + e);
		} finally {
			ModuloConexao.closeConnection(conexao, pst);
		}

	}

	public void update(Funcionario c) {

		Connection conexao = ModuloConexao.conector();
		PreparedStatement pst = null;

		String sql = "UPDATE funcionarios SET codigo_func=?,nome_func=?,cpf_func=?,senha_func=?,login_func=?,cargo_func=?,endereco_func=?,bairro_func=?,cep_func=?,cidade_func=?,estado_func=?,email_func=?,telefone_func=?,celular_func=? WHERE codigo_func=?";

		try {
			pst = conexao.prepareStatement(sql);

			pst.setShort(1, c.getCodigo());
			pst.setString(2, c.getNome());
			pst.setString(3, c.getCpf());
			pst.setString(4, c.getSenha());
			pst.setString(5, c.getLogin());
			pst.setString(6, c.getCargo());
			pst.setString(7, c.getEndereco());
			pst.setString(8, c.getBairro());
			pst.setString(9, c.getCep());
			pst.setString(10, c.getCidade());
			pst.setString(11, c.getEstado());
			pst.setString(12, c.getEmail());
			pst.setString(13, c.getTelefone());
			pst.setString(14, c.getCelular());
			pst.setShort(15, c.getCodigo());

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

		String sql = "delete from funcionarios where codigo_func = ?";
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
	public List<Funcionario> read(Funcionario c) {
		Connection conexao = ModuloConexao.conector();
		PreparedStatement pst = null;
		ResultSet rs = null;

		List<Funcionario> listaFunc = new ArrayList<Funcionario>();

		String sql = "select * from funcionarios";

		try {
			pst = conexao.prepareStatement(sql);
			rs = pst.executeQuery();
			// enquanto existir um valor ele vai guardar no objeto
			while (rs.next()) {
				c = new Funcionario();

				c.setCodigo(rs.getShort("codigo_func"));
				c.setNome(rs.getString("nome_func"));
				c.setCpf(rs.getString("cpf_func"));
				c.setSenha(rs.getString("senha_func"));
				c.setLogin(rs.getString("login_func"));
				c.setCargo(rs.getString("cargo_func"));
				c.setEndereco(rs.getString("endereco_func"));
				c.setBairro(rs.getString("bairro_func"));
				c.setCep(rs.getString("cep_func"));
				c.setCidade(rs.getString("cidade_func"));
				c.setEstado(rs.getString("estado_func"));
				c.setEmail(rs.getString("email_func"));
				c.setTelefone(rs.getString("telefone_func"));
				c.setCelular(rs.getString("celular_func"));

				listaFunc.add(c);

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			ModuloConexao.closeConnection(conexao, pst, rs);
		}
		return listaFunc;

	}

	public List<Funcionario> buscaFuncionario(Funcionario c) {
		Connection conexao = ModuloConexao.conector();
		PreparedStatement pst = null;
		ResultSet rs = null;

		List<Funcionario> listaFunc = new ArrayList<Funcionario>();

		String sql = "select * from funcionarios where nome_func like '%" + c.getPesquisa() + "%'";

		try {
			pst = conexao.prepareStatement(sql);
			rs = pst.executeQuery();
			// enquanto existir um valor ele vai guardar no objeto
			while (rs.next()) {
				c = new Funcionario();

				c.setCodigo(rs.getShort("codigo_func"));
				c.setNome(rs.getString("nome_func"));
				c.setCpf(rs.getString("cpf_func"));
				c.setSenha(rs.getString("senha_func"));
				c.setLogin(rs.getString("login_func"));
				c.setCargo(rs.getString("cargo_func"));
				c.setEndereco(rs.getString("endereco_func"));
				c.setBairro(rs.getString("bairro_func"));
				c.setCep(rs.getString("cep_func"));
				c.setCidade(rs.getString("cidade_func"));
				c.setEstado(rs.getString("estado_func"));
				c.setEmail(rs.getString("email_func"));
				c.setTelefone(rs.getString("telefone_func"));
				c.setCelular(rs.getString("celular_func"));

				listaFunc.add(c);

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			ModuloConexao.closeConnection(conexao, pst, rs);
		}
		return listaFunc;

	}

}
