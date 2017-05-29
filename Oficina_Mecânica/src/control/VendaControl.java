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
import model.Venda;

public class VendaControl {
	
	public void createVenda(Venda v) {
		Connection conexao = ModuloConexao.conector();
		PreparedStatement pst = null;

		String sql = "insert into venda (codigo_venda,valor_venda,data_venda,fk_codigo_venda) values(?,?,?,?)";

		try {
			pst = conexao.prepareStatement(sql);			
			
			pst.setShort(1, v.getCodigoCliente());
			pst.setDouble(2, v.getValorVenda());
			pst.setString(3, v.getDataVenda());
			pst.setShort(4, v.getCodigoCliente());
	

			pst.executeUpdate();

			JOptionPane.showMessageDialog(null, "Salvo com sucesso");
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Erro ao salvar: " + e);
		} finally {
			ModuloConexao.closeConnection(conexao, pst);
		}

	}

	public void updateVenda(Venda v) {
		Connection conexao = ModuloConexao.conector();
		PreparedStatement pst = null;

		String sql = "update venda set codigo_venda=?,valor_venda=?,data_venda=?,fk_codigo_venda=? where codigo_venda=?";

		try {
			pst = conexao.prepareStatement(sql);			
			
			pst.setShort(1, v.getCodigoCliente());
			pst.setDouble(2, v.getValorVenda());
			pst.setString(3, v.getDataVenda());
			pst.setShort(4, v.getCodigoCliente());
			pst.setShort(5, v.getCodigoCliente());

			pst.executeUpdate();

			JOptionPane.showMessageDialog(null, "Salvo com sucesso");
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Erro ao salvar: " + e);
		} finally {
			ModuloConexao.closeConnection(conexao, pst);
		}

	}

	public void deleteVenda(short id) {
		Connection conexao = ModuloConexao.conector();
		PreparedStatement pst = null;

		String sql = "delete from venda where codigo_venda = ?";
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

	public void select(Cliente c) {

	}

	// seleciona todos os clientes da classe clientes
	public List<Venda> read(Venda v) {
		Connection conexao = ModuloConexao.conector();
		PreparedStatement pst = null;
		ResultSet rs = null;

		List<Venda> listaVendas = new ArrayList<Venda>();

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
				v.setCodigoCliente(rs.getShort("fk_codigo_cliente"));
				
				listaVendas.add(v);

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			ModuloConexao.closeConnection(conexao, pst, rs);
		}
		return listaVendas;

	}


}
