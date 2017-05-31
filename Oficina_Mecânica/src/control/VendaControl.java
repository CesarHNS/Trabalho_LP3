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
import model.Produtos;
import control.ProdutoControl;
import model.Venda;

public class VendaControl {

	// variável global para receber o valor do método buscaCodigoFornecedor
	short codCliente, codProduto, codFornecedor;

	public void create(Venda v) {
		buscaCodCliente(v.getNomeCliente());
		// buscaCodProduto(v.getNomeProduto());
		Connection conexao = ModuloConexao.conector();
		PreparedStatement pst = null;

		String sql = "insert into venda (codigo_venda,valor_venda,data_venda,fk_codigo_cliente values(?,?,?,?)";
		try {
			pst = conexao.prepareStatement(sql);

			pst.setShort(1, v.getCodigoVenda());
			pst.setDouble(2, v.getValorVenda());
			pst.setString(3, v.getDataVenda());
			pst.setShort(4, codCliente);

			// pst.setShort(1, v.getCodigoVenda());
			// pst.setShort(2, codProduto);
			// pst.setLong(3, v.getQuantidadeItem());

			pst.executeUpdate();

			JOptionPane.showMessageDialog(null, "Salvo com sucesso");
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Erro ao salvar o produto\nERRO: " + e);
		} finally {
			ModuloConexao.closeConnection(conexao, pst);
		}

	}

	private void buscaCodCliente(String nomeCliente) {
		Connection conexao = ModuloConexao.conector();
		PreparedStatement pst = null;
		ResultSet rs = null;

		String sql = "select codigo_cliente from clientes where nome_cliente=?";

		try {
			pst = conexao.prepareStatement(sql);
			pst.setString(1, nomeCliente);
			rs = pst.executeQuery();

			while (rs.next()) {

				codCliente = rs.getShort("codigo_cliente");

			}

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Erro ao buscar cliente: " + e);
		} finally {
			ModuloConexao.closeConnection(conexao, pst, rs);
		}

	}

	private void buscaCodProduto(String nomeProduto) {
		Connection conexao = ModuloConexao.conector();
		PreparedStatement pst = null;
		ResultSet rs = null;

		String sql = "select codigo from produto where nome=?";

		try {
			pst = conexao.prepareStatement(sql);
			pst.setString(1, nomeProduto);
			rs = pst.executeQuery();

			while (rs.next()) {

				codCliente = rs.getShort("codigo");

			}

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Erro ao buscar produto: " + e);
		} finally {
			ModuloConexao.closeConnection(conexao, pst, rs);
		}

	}

	public void updateProduto(Venda v) {
		buscaCodCliente(v.getNomeCliente());
		buscaCodProduto(v.getNomeProduto());
		Connection conexao = ModuloConexao.conector();
		PreparedStatement pst = null;

		String sql = "UPDATE venda SET codigo_venda=?,valor_venda=?,data_venda=?,fk_codigo_venda=?,codigo_produto=? WHERE codigo_venda=?";
		try {
			pst = conexao.prepareStatement(sql);

			pst.setShort(1, v.getCodigoVenda());
			pst.setDouble(2, v.getValorVenda());
			pst.setString(3, v.getDataVenda());
			pst.setShort(4, codCliente);
			pst.setShort(5, codProduto);
			pst.setLong(6, v.getQuantidadeItem());
			pst.setShort(7, v.getCodigoVenda());

			pst.executeUpdate();

			JOptionPane.showMessageDialog(null, "Salvo com sucesso");
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Erro ao salvar o produto\nERRO: " + e);
		} finally {
			ModuloConexao.closeConnection(conexao, pst);
		}

	}

	public void delete(short id) {
		Connection conexao = ModuloConexao.conector();
		PreparedStatement pst = null;

		String sql = "delete from produto where codigo=?";
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
	public List<Venda> read(Venda v) {
		Connection conexao = ModuloConexao.conector(), conexao2 = ModuloConexao.conector();
		PreparedStatement pst = null, pst2 = null;
		ResultSet rs = null, rs2 = null;

		List<Venda> listaVenda = new ArrayList<Venda>();

		String sql = "select * from venda";

		try {
			pst = conexao.prepareStatement(sql);
			rs = pst.executeQuery();

			// enquanto existir um valor ele vai guardar no objeto
			while (rs.next()) {
				v = new Venda();

				v.setCodigoVenda(rs.getShort("codigo_venda"));
				v.setValorVenda(rs.getDouble("valor_venda"));
				v.setDataVenda(rs.getString("data_venda"));
				v.setNomeCliente(rs.getString("fk_codigo_cliente"));
				v.setNomeProduto(rs.getString("codigo_produto"));
				v.setQuantidadeItem(rs.getInt("quantidade"));
				// adiciona os objetos na lista de produtos
				listaVenda.add(v);

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			ModuloConexao.closeConnection(conexao, pst, rs);
		}
		return listaVenda;

	}

	

}
