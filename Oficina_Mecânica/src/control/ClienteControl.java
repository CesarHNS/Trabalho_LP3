package control;

import java.util.List;

import javax.swing.JOptionPane;

import model.Cliente;
import model.Fornecedor;
import model.dao.ClienteDAO;
import model.dao.FornecedorDAO;
import model.tables.ClienteTableModel;
import model.tables.FornecedorTableModel;

public class ClienteControl {

	public void SalvarCliente(Short id, String nome, String dataNasc, String CPF, String endereco, String bairro,
			String cep, String cidade, String estado, String email, String telefone, String celular) {

		Cliente c = new Cliente();

		c.setId(id);
		c.setNome(nome);
		c.setDataNasc(dataNasc);
		c.setCpf(CPF);
		c.setEndereco(endereco);
		c.setBairro(bairro);
		c.setCep(cep);
		c.setCidade(cidade);
		c.setEstado(estado);
		c.setEmail(email);
		c.setTelefone(telefone);
		c.setCelular(celular);

		new ClienteDAO().create(c);

	}
	
	public void RemoverCliente(Short id){
		
		Cliente c = new Cliente();		
		c.setId(id);		
		new ClienteDAO().delete(id);
		
	}
	
	public void ModificarCliente(Short id, String nome, String dataNasc, String CPF, String endereco, String bairro,
			String cep, String cidade, String estado, String email, String telefone, String celular) {

		Cliente c = new Cliente();

		c.setId(id);
		c.setNome(nome);
		c.setDataNasc(dataNasc);
		c.setCpf(CPF);
		c.setEndereco(endereco);
		c.setBairro(bairro);
		c.setCep(cep);
		c.setCidade(cidade);
		c.setEstado(estado);
		c.setEmail(email);
		c.setTelefone(telefone);
		c.setCelular(celular);

		new ClienteDAO().update(c);

	}
	
	/**********************************************************************
	 * Método para fazer consultas no banco de dados
	 *********************************************************************/
	public void atualizar(ClienteTableModel modelo) {
		try {
			/* Criação do modelo */
			Cliente c = new Cliente();
			// d.setNome(tfPesquisaCliente.getText());

			/* Criação do DAO */
			ClienteDAO cdao = new ClienteDAO();
			List<Cliente> lista = cdao.read(c);					

			/* Copia os dados da consulta para a tabela */
			modelo.adicionar(lista);

		} catch (Exception ex) {
			ex.printStackTrace();
			JOptionPane.showMessageDialog(null, "Erro ao tentar buscar um cliente");
		}
	}


}
