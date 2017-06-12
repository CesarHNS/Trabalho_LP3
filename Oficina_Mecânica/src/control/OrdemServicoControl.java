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
	short  codServico, codOS;
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
		short codOS = selectCodOs();

		String sql = "insert into itens_os_servico (codigo_os,codigo_serv) values(?,?)";

		try {
			pst = conexao.prepareStatement(sql);
			pst.setShort(1, codOS);
			pst.setShort(2, os.getServico());
			

			pst.executeUpdate();

			JOptionPane.showMessageDialog(null, "Serviço adicionado!");

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Erro ao adicionar serviço\nERRO: " + e);
		}

		finally {
			ModuloConexao.closeConnection(conexao, pst);
			System.out.println("serv: "+os.getServico()+"\nOrdem Servico: "+codOS);

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

	public void deletaOS(short id) {

	}

	public short selectCodOs() {

		Connection conexao = ModuloConexao.conector();
		PreparedStatement pst = null;
		ResultSet rs = null;		

		String sql = " select codigo_os from ordem_servico";

		try {
			pst = conexao.prepareStatement(sql);
			rs = pst.executeQuery();

			while (rs.next()) {
				// colocando a venda sempre como na ultima posição
				rs.last();
				codOS = rs.getShort("codigo_os");
				// enquanto existir um valor ele vai guardar no objeto
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			ModuloConexao.closeConnection(conexao, pst, rs);

		}
		return codOS;
		

	}
	
	public short selectCodServ(String nomeServ){
		Connection conexao = ModuloConexao.conector();
		PreparedStatement pst = null;
		ResultSet rs = null;
		short codServ = 0 ;

		String sql = "select codigo_serv from serv where nome_serv=?";

		try {
			pst = conexao.prepareStatement(sql);
			pst.setString(1, nomeServ);
			rs = pst.executeQuery();

			while (rs.next()) {

				codServ = rs.getShort("codigo_serv");

			}

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Erro ao buscar fornecedor: " + e);
		} finally {
			ModuloConexao.closeConnection(conexao, pst, rs);
		}
		return codServ;
	}

}
