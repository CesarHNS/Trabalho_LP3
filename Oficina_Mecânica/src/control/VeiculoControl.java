package control;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.swing.JOptionPane;

import dal.ModuloConexao;
import model.Cliente;
import model.Fornecedor;
import model.Item;
import model.Veiculo;
import model.Venda;

public class VeiculoControl {
	

	public void createVeiculo(Veiculo v) {
		Connection conexao = ModuloConexao.conector();
		PreparedStatement pst = null;
		short codCliente = new VendaControl().buscaCodCliente(v.getNomeCliente());

		String sql = "insert into veiculo (nome_veiculo,montadora,placa,codigo_cliente) values(?,?,?,?)";

		try {
			pst = conexao.prepareStatement(sql);

			
			pst.setString(1, v.getDescricao());
			pst.setString(2, v.getMontadora());
			pst.setString(3, v.getPlaca());
			pst.setShort(4, codCliente);

			pst.executeUpdate();

			JOptionPane.showMessageDialog(null, "Salvo com sucesso");
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Erro ao salvar: " + e);
		} finally {
			ModuloConexao.closeConnection(conexao, pst);
		}

	}

	public void updateVeiculo(Veiculo v) {

		Connection conexao = ModuloConexao.conector();
		PreparedStatement pst = null;

		String sql = "UPDATE veiculo SET nome_veiculo=?,montadora=?,placa=? WHERE nome_veiculo=?";
		try {
			pst = conexao.prepareStatement(sql);

			pst.setString(1, v.getDescricao());
			pst.setString(2, v.getMontadora());
			pst.setString(3, v.getPlaca());
			pst.setString(4, v.getDescricao());

			pst.executeUpdate();

			JOptionPane.showMessageDialog(null, "Modificado com sucesso");
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Erro ao salvar: " + e);
		} finally {
			ModuloConexao.closeConnection(conexao, pst);
		}
	}

	public void deleteVeiculo(short id) {
		Connection conexao = ModuloConexao.conector();
		PreparedStatement pst = null;

		String sql = "delete from veiculo where codigo_cliente= ?";
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
	public List<Veiculo> read(Veiculo f) {
		Connection conexao = ModuloConexao.conector();
		PreparedStatement pst = null;
		ResultSet rs = null;

		List<Veiculo> fornecedores = new ArrayList<Veiculo>();

		String sql = "select * from fornecedores";

		try {
			pst = conexao.prepareStatement(sql);
			rs = pst.executeQuery();
			// enquanto existir um valor ele vai guardar no objeto
			while (rs.next()) {
				f = new Veiculo();

				f.setCodigo(rs.getShort("codigo_veiculo"));
				f.setDescricao(rs.getString("nome_veiculo"));
				f.setMontadora(rs.getString("montadora"));
				f.setPlaca(rs.getString("placa"));
				f.setNomeCliente(rs.getString("codigo_cliente"));

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
