package control;

import java.util.List;

import javax.swing.JOptionPane;

import model.Fornecedor;
import model.dao.FornecedorDAO;
import model.tables.FornecedorTableModel;

public class FornecedorControl {

	public void SalvarFornecedor(short id, String nome, String telefone, String email, String celular, String cnpj,
			String endereco, String bairro, String cep,String cidade,String estado) {

		Fornecedor f = new Fornecedor();

		f.setId(id);
		f.setNome(nome);
		f.setTelefone(telefone);
		f.setEmail(email);
		f.setCelular(celular);
		f.setCnpj(cnpj);
		f.setEndereco(endereco);
		f.setBairro(bairro);
		f.setCep(cep);
		f.setCidade(cidade);
		f.setEstado(estado);
		
		new FornecedorDAO().create(f);
	}
	
	public void RemoverFornecedor(short id){
		
		Fornecedor f = new Fornecedor();
		f.setId(id);
		new FornecedorDAO().delete(id);
		
	}
	
	public void ModificarFornecedor(short id, String nome, String telefone, String email, String celular, String cnpj,
			String endereco, String bairro, String cep,String cidade,String estado) {

		Fornecedor f = new Fornecedor();

		f.setId(id);
		f.setNome(nome);
		f.setTelefone(telefone);
		f.setEmail(email);
		f.setCelular(celular);
		f.setCnpj(cnpj);
		f.setEndereco(endereco);
		f.setBairro(bairro);
		f.setCep(cep);
		f.setCidade(cidade);
		f.setEstado(estado);
		
		new FornecedorDAO().update(f);
	}
	
	/**********************************************************************
	 * Método para fazer consultas no banco de dados
	 *********************************************************************/
	public void atualizar(FornecedorTableModel modelo) {
		try {
			/* Criação do modelo */
			Fornecedor f = new Fornecedor();
			// d.setNome(tfPesquisaCliente.getText());

			/* Criação do DAO */
			FornecedorDAO fdao = new FornecedorDAO();
			List<Fornecedor> lista = fdao.read(f);					

			/* Copia os dados da consulta para a tabela */
			modelo.adicionar(lista);

		} catch (Exception ex) {
			ex.printStackTrace();
			JOptionPane.showMessageDialog(null, "Erro ao tentar buscar um fornecedor");
		}
	}

	
	

}
