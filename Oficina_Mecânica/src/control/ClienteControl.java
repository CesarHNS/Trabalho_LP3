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
import model.Fornecedor;
import model.Produtos;
import model.tables.ClienteTableModel;
import model.tables.FornecedorTableModel;

public class ClienteControl {
	String nomeCliente;
	short codCliente;

	public void create(Cliente c) {
		Connection conexao = ModuloConexao.conector();
		PreparedStatement pst = null;

		String sql = "insert into clientes (codigo_cliente,nome_cliente,dataNasc_cliente,cpf_cliente,endereco_cliente,bairro_cliente,cep_cliente,cidade_cliente,estado_cliente,email_cliente,telefone_cliente,celular_cliente) values(?,?,?,?,?,?,?,?,?,?,?,?)";

		try {
			pst = conexao.prepareStatement(sql);

			pst.setShort(1, c.getId());
			pst.setString(2, c.getNome());
			pst.setString(3, c.getDataNasc());
			pst.setString(4, c.getCpf());
			pst.setString(5, c.getEndereco());
			pst.setString(6, c.getBairro());
			pst.setString(7, c.getCep());
			pst.setString(8, c.getCidade());
			pst.setString(9, c.getEstado());
			pst.setString(10, c.getEmail());
			pst.setString(11, c.getTelefone());
			pst.setString(12, c.getCelular());

			pst.executeUpdate();

			JOptionPane.showMessageDialog(null, "Salvo com sucesso");
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Erro ao salvar: " + e);
		} finally {
			ModuloConexao.closeConnection(conexao, pst);
		}

	}

	public void update(Cliente c) {

		Connection conexao = ModuloConexao.conector();
		PreparedStatement pst = null;

		String sql = "UPDATE clientes SET codigo_cliente=?,nome_cliente=?,dataNasc_cliente=?,cpf_cliente=?,endereco_cliente=?,bairro_cliente=?,cep_cliente=?,cidade_cliente=?,estado_cliente=?,email_cliente=?,telefone_cliente=?,celular_cliente=? WHERE codigo_cliente=?";
		try {
			pst = conexao.prepareStatement(sql);

			pst.setShort(1, c.getId());
			pst.setString(2, c.getNome());
			pst.setString(3, c.getDataNasc());
			pst.setString(4, c.getCpf());
			pst.setString(5, c.getEndereco());
			pst.setString(6, c.getBairro());
			pst.setString(7, c.getCep());
			pst.setString(8, c.getCidade());
			pst.setString(9, c.getEstado());
			pst.setString(10, c.getEmail());
			pst.setString(11, c.getTelefone());
			pst.setString(12, c.getCelular());
			pst.setShort(13, c.getId());

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

		String sql = "delete from clientes where codigo_cliente = ?";
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
	public List<Cliente> read(Cliente c) {
		Connection conexao = ModuloConexao.conector();
		PreparedStatement pst = null;
		ResultSet rs = null;

		List<Cliente> clientes = new ArrayList<Cliente>();

		String sql = "select * from clientes";

		try {
			pst = conexao.prepareStatement(sql);
			rs = pst.executeQuery();
			// enquanto existir um valor ele vai guardar no objeto
			while (rs.next()) {
				c = new Cliente();

				c.setId(rs.getShort("codigo_cliente"));
				c.setNome(rs.getString("nome_cliente"));
				c.setDataNasc(rs.getString("dataNasc_cliente"));
				c.setCpf(rs.getString("cpf_cliente"));
				c.setEndereco(rs.getString("endereco_cliente"));
				c.setBairro(rs.getString("bairro_cliente"));
				c.setCep(rs.getString("cep_cliente"));
				c.setCidade(rs.getString("cidade_cliente"));
				c.setEstado(rs.getString("estado_cliente"));
				c.setEmail(rs.getString("email_cliente"));
				c.setTelefone(rs.getString("telefone_cliente"));
				c.setCelular(rs.getString("celular_cliente"));

				clientes.add(c);

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			ModuloConexao.closeConnection(conexao, pst, rs);
		}
		return clientes;

	}

	public List<Cliente> buscaCliente(Cliente c) {
		Connection conexao = ModuloConexao.conector();
		PreparedStatement pst = null;
		ResultSet rs = null;

		String sql = "select * from clientes where nome_cliente like '%" + c.getPesquisa() + "%'";

		List<Cliente> listaCliente = new ArrayList<Cliente>();

		try {
			pst = conexao.prepareStatement(sql);
			rs = pst.executeQuery();

			// enquanto existir um valor ele vai guardar no objeto
			while (rs.next()) {
				c = new Cliente();

				c.setId(rs.getShort("codigo_cliente"));
				c.setNome(rs.getString("nome_cliente"));
				c.setDataNasc(rs.getString("dataNasc_cliente"));
				c.setCpf(rs.getString("cpf_cliente"));
				c.setEndereco(rs.getString("endereco_cliente"));
				c.setBairro(rs.getString("bairro_cliente"));
				c.setCep(rs.getString("cep_cliente"));
				c.setCidade(rs.getString("cidade_cliente"));
				c.setEstado(rs.getString("estado_cliente"));
				c.setEmail(rs.getString("email_cliente"));
				c.setTelefone(rs.getString("telefone_cliente"));
				c.setCelular(rs.getString("celular_cliente"));

				listaCliente.add(c);

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			ModuloConexao.closeConnection(conexao, pst, rs);

		}
		return listaCliente;

	}

}
