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
import model.Produtos;

public class ProdutoDAO {

	public void create(Produtos p) {
		Connection conexao = ModuloConexao.conector();
		PreparedStatement pst = null;

		String sql = "insert into produto (codigo,nome,descricao,preco_compra,preco_venda,quantidade,fk_codigo_forn) values(?,?,?,?,?,?,?)";

		try {
			pst = conexao.prepareStatement(sql);

			pst.setShort(1, p.getCodigo());
			pst.setString(2, p.getNome());
			pst.setString(3, p.getDescricao());
			pst.setDouble(4, p.getPrecoCompra());
			pst.setDouble(5, p.getPrecoVenda());
			pst.setLong(6, p.getQuantidade());
			pst.setShort(7, p.getFornecedor());

			pst.executeUpdate();

			JOptionPane.showMessageDialog(null, "Salvo com sucesso");
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Erro ao salvar: " + e);
		} finally {
			ModuloConexao.closeConnection(conexao, pst);
		}

	}

	public void update(Produtos p) {

		Connection conexao = ModuloConexao.conector();
		PreparedStatement pst = null;

		String sql = "UPDATE produto SET codigo=?,nome=?,descricao=?,preco_compra=?,preco_venda=?,quantidade=? WHERE codigo=?";
		try {
			pst = conexao.prepareStatement(sql);

			pst.setShort(1, p.getCodigo());
			pst.setString(2, p.getNome());
			pst.setString(3, p.getDescricao());
			pst.setDouble(4, p.getPrecoCompra());
			pst.setDouble(5, p.getPrecoVenda());
			pst.setLong(6, p.getQuantidade());
			pst.setShort(7, p.getFornecedor());

			pst.executeUpdate();

			JOptionPane.showMessageDialog(null, "Salvo com sucesso");
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Erro ao salvar: " + e);
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
	public List<Produtos> read(Produtos p) {
		Connection conexao = ModuloConexao.conector();
		PreparedStatement pst = null;
		ResultSet rs = null;

		List<Produtos> listaProd = new ArrayList<Produtos>();

		String sql = "select * from produto";

		try {
			pst = conexao.prepareStatement(sql);
			rs = pst.executeQuery();
			// enquanto existir um valor ele vai guardar no objeto
			while (rs.next()) {
				p = new Produtos();

				p.setCodigo(rs.getShort("codigo"));
				p.setNome(rs.getString("nome"));
				p.setDescricao(rs.getString("descricao"));
				p.setPrecoCompra(rs.getDouble("preco_compra"));
				p.setPrecoVenda(rs.getDouble("preco_venda"));
				p.setQuantidade(rs.getInt("quantidade"));
				p.setFornecedor(rs.getShort("fk_codigo_forn"));

				listaProd.add(p);

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			ModuloConexao.closeConnection(conexao, pst, rs);
		}
		return listaProd;

	}

}
