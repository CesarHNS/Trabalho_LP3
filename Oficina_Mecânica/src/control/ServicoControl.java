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
import model.Servico;

public class ServicoControl {
	public void create(Servico s) {
		Connection conexao = ModuloConexao.conector();
		PreparedStatement pst = null;

		String sql = "insert into servico (codigo,descricao,preco,quantidade) values(?,?,?,?,?)";

		try {
			pst = conexao.prepareStatement(sql);

			pst.setShort(1, s.getCodigo());
			pst.setString(2, s.getDescricao());
			pst.setDouble(3, s.getPreco());
			pst.setInt(4, s.getQuantidade());

			pst.executeUpdate();

			JOptionPane.showMessageDialog(null, "Salvo com sucesso");
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Erro ao salvar: " + e);
		} finally {
			ModuloConexao.closeConnection(conexao, pst);
		}

	}

	public void update(Servico s) {

		Connection conexao = ModuloConexao.conector();
		PreparedStatement pst = null;

		String sql = "UPDATE clientes SET codigo=?,descricao=?,preco=?,quantidade=? WHERE codigo=?";
		try {
			pst = conexao.prepareStatement(sql);

			pst.setShort(1, s.getCodigo());
			pst.setString(2, s.getDescricao());
			pst.setDouble(3, s.getPreco());
			pst.setInt(4, s.getQuantidade());

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

		String sql = "delete from servico where codigo = ?";
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
	public List<Servico> read(Servico s) {
		Connection conexao = ModuloConexao.conector();
		PreparedStatement pst = null;
		ResultSet rs = null;

		List<Servico> listaServico = new ArrayList<Servico>();

		String sql = "select * from servico";

		try {
			pst = conexao.prepareStatement(sql);
			rs = pst.executeQuery();
			// enquanto existir um valor ele vai guardar no objeto
			while (rs.next()) {
				s = new Servico();

				s.setCodigo(rs.getShort("codigo"));
				s.setDescricao(rs.getString("descricao"));
				s.setPreco(rs.getDouble("preco"));
				s.setQuantidade(rs.getInt("quantidade"));

				listaServico.add(s);

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			ModuloConexao.closeConnection(conexao, pst, rs);
		}
		return listaServico;

	}

}
