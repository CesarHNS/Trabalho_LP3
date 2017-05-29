package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.swing.JOptionPane;
import javax.swing.Spring;

import dal.ModuloConexao;
import model.Cliente;
import model.Fornecedor;
import model.Funcionario;
import model.Produtos;
import model.tables.ProdutoTableModel;

public class ProdutoDAO {
	// variável global para receber o valor do método buscaCodigoFornecedor
	short codFornecedor;
	String nomeFornecedor;

	public void create(Produtos p) {
		buscaCodigoFornecedor(p.getFornecedor());
		Connection conexao = ModuloConexao.conector();
		PreparedStatement pst = null;

		String sql = "insert into produto (codigo,nome,descricao,preco_compra,preco_venda,quantidade,codigo_fornecedor) values(?,?,?,?,?,?,?)";
		try {
			pst = conexao.prepareStatement(sql);

			pst.setShort(1, p.getCodigo());
			pst.setString(2, p.getNome());
			pst.setString(3, p.getDescricao());
			pst.setDouble(4, p.getPrecoCompra());
			pst.setDouble(5, p.getPrecoVenda());
			pst.setLong(6, p.getQuantidade());
			pst.setShort(7, codFornecedor);

			pst.executeUpdate();

			JOptionPane.showMessageDialog(null, "Salvo com sucesso");
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Erro ao salvar o produto\nERRO: " + e);
		} finally {
			ModuloConexao.closeConnection(conexao, pst);
		}

	}

	public void updateProduto(Produtos p) {
		buscaCodigoFornecedor(p.getFornecedor());
		Connection conexao = ModuloConexao.conector();
		PreparedStatement pst = null;

		String sql = "UPDATE produto SET nome=?,descricao=?,preco_compra=?,preco_venda=?,quantidade=? WHERE codigo=?";
		try {
			pst = conexao.prepareStatement(sql);

			pst.setString(1, p.getNome());
			pst.setString(2, p.getDescricao());
			pst.setDouble(3, p.getPrecoCompra());
			pst.setDouble(4, p.getPrecoVenda());
			pst.setLong(5, p.getQuantidade());
			pst.setShort(6, p.getCodigo());
			
			pst.executeUpdate();

			JOptionPane.showMessageDialog(null, "Produto modificado com sucesso");
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Erro ao modificar: " + e);
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
		Connection conexao = ModuloConexao.conector(),conexao2 = ModuloConexao.conector();
		PreparedStatement pst = null, pst2 = null;
		ResultSet rs = null, rs2 = null;


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
				p.setFornecedor(rs.getString("codigo_fornecedor"));
				// adiciona os objetos na lista de produtos
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

	public List<Produtos> buscaProduto(Produtos p) {
		Connection conexao = ModuloConexao.conector();
		PreparedStatement pst = null;
		ResultSet rs = null;

		String sql = "select * from produto where nome like '%" + p.getPesquisa() + "%'";
		
		List<Produtos> listaProd = new ArrayList<Produtos>();
		
		try {
			pst = conexao.prepareStatement(sql);
			rs = pst.executeQuery();
			
			// enquanto existir um valor ele vai guardar no objeto
			while (rs.next()) {
				p = new Produtos();

				buscaCodigoFornecedor(rs.getString("codigo_fornecedor"));
				p.setCodigo(rs.getShort("codigo"));
				p.setNome(rs.getString("nome"));
				p.setDescricao(rs.getString("descricao"));
				p.setPrecoCompra(rs.getDouble("preco_compra"));
				p.setPrecoVenda(rs.getDouble("preco_venda"));
				p.setQuantidade(rs.getInt("quantidade"));
				p.setFornecedor(rs.getString("nome_forn"));

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

	public void buscaCodigoFornecedor(String nome) {
		Connection conexao = ModuloConexao.conector();
		PreparedStatement pst = null;
		ResultSet rs = null;

		String sql = "select codigo_forn from fornecedores where nome_forn=?";

		try {
			pst = conexao.prepareStatement(sql);
			pst.setString(1, nome);
			rs = pst.executeQuery();

			while (rs.next()) {

				codFornecedor = rs.getShort("codigo_forn");

			}

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Erro ao buscar fornecedor: " + e);
		} finally {
			ModuloConexao.closeConnection(conexao, pst, rs);
		}

	}

	public void buscaNomeFornecedor(short cod) {

		Connection conexaoForn = ModuloConexao.conector();
		PreparedStatement pst = null;
		ResultSet rs = null;

		String sql = "select nome_forn from fornecedores where codigo_forn=?";

		try {
			pst = conexaoForn.prepareStatement(sql);
			pst.setShort(1, cod);
			rs = pst.executeQuery();

			while (rs.next()) {

				nomeFornecedor = rs.getString("nome_forn");

			}

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Erro ao buscar fornecedor: " + e);
		} finally {
			ModuloConexao.closeConnection(conexaoForn, pst, rs);
		}
		System.out.println(nomeFornecedor);
	}

}
