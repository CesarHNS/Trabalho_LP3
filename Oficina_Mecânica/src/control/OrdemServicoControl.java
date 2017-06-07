package control;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.util.Calendar;

import javax.swing.JOptionPane;

import dal.ModuloConexao;
import model.Item;
import model.OrdemServico;
import model.Servico;
import model.Venda;

public class OrdemServicoControl {
	// variável global para receber o valor do método buscaCodigoFornecedor
	short codCliente, codServico, codFornecedor;
	String nomeProduto;
	Calendar c = Calendar.getInstance();
	java.util.Date data = c.getTime();

	// data no formato dd/mm/aaaa
	DateFormat f = DateFormat.getDateInstance(DateFormat.MEDIUM);

	// método usado somente para abrir a venda
	public void criaOS() {

		Connection conexao = ModuloConexao.conector();
		PreparedStatement pst = null;
		ResultSet rs = null;
		short codClienteTemp = 0;

		String sql = "insert into ordem_servico  (veiculo,defeito) values(?,?)";

		try {
			pst = conexao.prepareStatement(sql);

			pst.setString(1, "");
			pst.setString(2, "");

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
	public void adicionaServico(OrdemServico os) {

		Connection conexao = ModuloConexao.conector();
		PreparedStatement pst = null;
		ResultSet rs = null;

		String sql = "insert into itens_os_servico (codigo_os,codigo_serv) values(?,?)";

		try {
			pst = conexao.prepareStatement(sql);

			pst.setShort(1, os.getCodigo_os());
			pst.setShort(2, os.getServico());

			pst.executeUpdate();

			JOptionPane.showMessageDialog(null, "Serviço adicionado!");

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Erro ao adicionar serviço\nERRO: " + e);
		}

		finally {
			ModuloConexao.closeConnection(conexao, pst);
		}

	}

	// método que faz
	public void FinalizaOS(OrdemServico os) {
		Connection conexao = ModuloConexao.conector();
		PreparedStatement pst = null;

		String sql = "UPDATE ordem_servico SET veiculo=?,defeito=?,servico=?,funcionario=?,valor=?,cliente=?,data_os=? WHERE codigo_os=?";
		try {
			pst = conexao.prepareStatement(sql);

			pst.setString(1, os.getVeiculo());
			pst.setString(2, os.getDefeito());
			pst.setShort(3, os.getServico());
			pst.setShort(4, os.getFuncionario());
			pst.setDouble(5, os.getValor());
			pst.setShort(6, os.getCliente());
			pst.setString(7, os.getData_os());

			pst.executeUpdate();

			JOptionPane.showMessageDialog(null, "Ordem de serviço finalizada!");
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Erro ao finalizar a ordem de serviço\nERRO: " + e);
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

}
