package control;

import model.Cliente;
import model.dao.ClienteDAO;

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
	

}
