package model.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JOptionPane;

import dal.ModuloConexao;
import model.Cliente;

public class ClienteDAO {

	public void create(Cliente c) {
		Connection conexao = ModuloConexao.conector();
		PreparedStatement pst = null;

		String sql = "insert into clientes (codigo_cliente,nome_cliente,dataNasc_cliente,cpf_cliente,endereco_cliente,bairro_cliente,cep_cliente,cidade_cliente,estado_cliente,email_cliente,telefone_cliente,celular_cliente) values(?,?,?,?,?,?,?,?,?,?,?,?)";

		try {
			pst = conexao.prepareStatement(sql);
			
			pst.setLong(1, c.getId());
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
			JOptionPane.showMessageDialog(null, "Erro ao salvar: "+e);
		}finally{
			ModuloConexao.closeConnection(conexao, pst);
		}

	}
	
	public void delete(Cliente c){
		Connection conexao = ModuloConexao.conector();
		PreparedStatement pst = null;

		String sql = "delete from clientes where codigo_cliente = ?";
		try {
			pst = conexao.prepareStatement(sql);
			
			pst.setLong(1, c.getId());			
			
			pst.executeUpdate();
			
			JOptionPane.showMessageDialog(null, "Deletado com sucesso");
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Erro ao deletar: "+e);
		}finally{
			ModuloConexao.closeConnection(conexao, pst);
		}
	}

	public List<Cliente> read(){
		Connection conexao = ModuloConexao.conector();
		PreparedStatement pst = null;
		ResultSet rs = null;
		
		List<Cliente> clientes = new ArrayList();
		
		String sql = "select * from clientes";
		
		try {
			pst = conexao.prepareStatement(sql);
			rs = pst.executeQuery();
			//enquanto existir um valor ele vai guardar no objeto
			while(rs.next()){
				Cliente c = new Cliente();
				
				c.setId(rs.getShort("codigo_cliente"));
				c.setNome(rs.getString("nome_cliente"));
				c.setEndereco(rs.getString("dataNasc_cliente"));
				c.setCpf(rs.getString("cpf_cliente"));
				c.setEndereco(rs.getString("endereco_cliente"));
				c.setBairro(rs.getString("bairro_cliente"));
				c.setCep(rs.getString("cep_cliente"));
				c.setCidade(rs.getString("cidade_cliente"));
				c.setEstado(rs.getString("estado_cliente"));
				c.setEmail(rs.getString("email_cliente"));
				c.setTelefone(rs.getString("telefone_cliente"));
				c.setCelular(rs.getString("celular_cliente"));				
			
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			ModuloConexao.closeConnection(conexao, pst, rs);
		}
		return clientes;

	}
	
}






















