package control;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.text.DateFormat;
import java.sql.Date;

import javax.swing.JOptionPane;

import dal.ModuloConexao;
import model.Cliente;
import model.Item;
import model.Produtos;
import control.ProdutoControl;
import model.Venda;

public class VendaControl {

	// vari�vel global para receber o valor do m�todo buscaCodigoFornecedor
	short codCliente, codProduto, codFornecedor;
	String nomeProduto;
	Calendar c = Calendar.getInstance();
	java.util.Date data = c.getTime();

	// data no formato dd/mm/aaaa
	DateFormat f = DateFormat.getDateInstance(DateFormat.MEDIUM);

	// m�todo usado somente para abrir a venda
	public void criandoVenda() {

		Connection conexao = ModuloConexao.conector();
		PreparedStatement pst = null;
		ResultSet rs = null;

		String sql = "insert into venda (valor_venda,data_venda) values(?,?)";

		try {
			pst = conexao.prepareStatement(sql);

			pst.setDouble(1, 0);
			pst.setString(2, f.format(data));

			pst.executeUpdate();

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "ERRO: " + e);
		} finally {
			ModuloConexao.closeConnection(conexao, pst);
		}
		return;

	}

	/**********************************************************
	 * CRUD
	 ***********************************************************/
	public void adicionaItem(Item itemVenda) {

		buscaCodProduto(itemVenda.getNomeProduto());

		Connection conexao = ModuloConexao.conector();
		PreparedStatement pst = null;
		ResultSet rs = null;

		String sql = "insert into itens_venda_produto (codigo_venda,codigo_produto,quant_produto) values(?,?,?)";

		try {
			pst = conexao.prepareStatement(sql);

			pst.setShort(1, itemVenda.getCodVenda());
			pst.setShort(2, codProduto);
			pst.setInt(3, itemVenda.getQuantidade());

			pst.executeUpdate();

			// baixa no estoque
			int quant = 0, resul = 0;

			pst = conexao.prepareStatement("select * from produto where codigo=?");
			pst.setShort(1, codProduto);
			rs = pst.executeQuery();
			rs.first();

			quant = rs.getInt("quantidade");
			resul = quant - itemVenda.getQuantidade();

			pst = conexao.prepareStatement("update produto set quantidade=? where nome=?");
			pst.setInt(1, resul);
			pst.setString(2, itemVenda.getNomeProduto());
			pst.executeUpdate();

			JOptionPane.showMessageDialog(null, "Produto adicionado!");

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Erro ao salvar o produto\nERRO: " + e);
		}

		finally {
			ModuloConexao.closeConnection(conexao, pst);
		}

	}

	// m�todo que faz
	public void FechaVenda(Venda v) {
		buscaCodCliente(v.getNomeCliente());
		buscaCodProduto(v.getNomeProduto());
		Connection conexao = ModuloConexao.conector();
		PreparedStatement pst = null;

		String sql = "UPDATE venda SET valor_venda=?,data_venda=?,fk_cliente=?,situacao='Aguardando Pagamento' WHERE codigo_venda=?";
		try {
			pst = conexao.prepareStatement(sql);

			pst.setDouble(1, v.getValorVenda());
			pst.setString(2, v.getDataVenda());
			pst.setShort(3, codCliente);
			pst.setShort(4, v.getCodigoVenda());

			pst.executeUpdate();

			JOptionPane.showMessageDialog(null, "Venda finalizada!");
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Erro ao finalizar a venda\nERRO: " + e);
		} finally {
			ModuloConexao.closeConnection(conexao, pst);
		}

	}

	public void deletaVenda(short id) {
		Connection conexao = ModuloConexao.conector();
		PreparedStatement pst = null;
		ResultSet rs = null;
		short cod = 0;
		
		try {
			pst = conexao.prepareStatement(
					"select * from venda inner join itens_venda_produto on venda.codigo_venda = itens_venda_produto.codigo_venda inner join produto on itens_venda_produto.codigo_produto = produto.codigo where valor_venda = ?");
			pst.setShort(1, cod);
			rs = pst.executeQuery();
			rs.first();

			do {
				int qtdProd = rs.getInt("quantidade"), qtdVenda = rs.getInt("quant_produto");
				int soma = qtdProd + qtdVenda;

				pst = conexao.prepareStatement("update produto set quantidade=? where codigo=?");
				pst.setInt(1, soma);
				pst.setInt(2, rs.getInt("codigo_produto"));
				pst.executeUpdate();
				
				pst = conexao.prepareStatement("delete from itens_venda_produto where codigo_venda=?");
				pst.setShort(1, id);
				pst.executeUpdate();

			} while (rs.next());

			pst = conexao.prepareStatement("delete from venda where codigo_venda=?");
			pst.setShort(1, id);
			pst.executeUpdate();

			JOptionPane.showMessageDialog(null, "Venda deletada!");
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Erro ao deletar: " + e);
		} finally {
			ModuloConexao.closeConnection(conexao, pst);
		}
	}

	/***********************************************************
	 * M�TODOS PARA REALIZAR CONSULTAS NO BANCO
	 ***********************************************************/
	public void buscaCodProduto(String nomeProduto) {
		Connection conexao = ModuloConexao.conector();
		PreparedStatement pst = null;
		ResultSet rs = null;

		String sql = "select codigo from produto where nome=?";

		try {
			pst = conexao.prepareStatement(sql);
			pst.setString(1, nomeProduto);
			rs = pst.executeQuery();

			while (rs.next()) {

				codProduto = rs.getShort("codigo");

			}

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Erro ao buscar produto: " + e);
		} finally {
			ModuloConexao.closeConnection(conexao, pst, rs);
		}
	}

	public short buscaCodCliente(String nomeCliente) {
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
		
		return codCliente;
	}

	public void buscaNomeProduto(short codProduto) {
		Connection conexao = ModuloConexao.conector();
		PreparedStatement pst = null;
		ResultSet rs = null;

		String sql = "select nome from produto where codigo=?";

		try {
			pst = conexao.prepareStatement(sql);
			pst.setShort(1, codProduto);
			rs = pst.executeQuery();

			while (rs.next()) {

				nomeProduto = rs.getString("nome");

			}

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Erro ao buscar cliente: " + e);
		} finally {
			ModuloConexao.closeConnection(conexao, pst, rs);
		}
	}

	// seleciona todos os clientes da classe clientes
	public List<Item> readItem(Item i) {
		buscaNomeProduto(i.getCodProduto());
		short codVenda = buscaCodVenda();

		Connection conexao = ModuloConexao.conector();
		PreparedStatement pst = null;
		ResultSet rs = null;

		List<Item> listaItens = new ArrayList<Item>();

		String sql = "SELECT * FROM produto INNER JOIN itens_venda_produto ON produto.codigo = ? INNER JOIN venda ON venda.codigo_venda=? WHERE venda.codigo_venda=?";

		try {
			pst = conexao.prepareStatement(sql);
			rs = pst.executeQuery();

			// enquanto existir um valor ele vai guardar no objeto
			// while (rs.first()) {

			rs.first();
			i = new Item();

			i.setNomeProduto(rs.getString("nome"));
			i.setCodVenda(rs.getShort("codigo"));
			i.setQuantidade(rs.getInt("quantidade"));

			listaItens.add(i);

			// }

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			ModuloConexao.closeConnection(conexao, pst, rs);
		}
		return listaItens;

	}

	public short buscaCodVenda() {
		Connection conexao = ModuloConexao.conector();
		PreparedStatement pst = null;
		ResultSet rs = null;
		short codVenda = 0;

		String sql = "select * from venda";

		try {
			pst = conexao.prepareStatement(sql);
			rs = pst.executeQuery();

			while (rs.next()) {
				// colocando a venda sempre como na ultima posi��o
				rs.last();
				codVenda = rs.getShort("codigo_venda");
				// enquanto existir um valor ele vai guardar no objeto
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			ModuloConexao.closeConnection(conexao, pst, rs);

		}
		return codVenda;
	}

}
