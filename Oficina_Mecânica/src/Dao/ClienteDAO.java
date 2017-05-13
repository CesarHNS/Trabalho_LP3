package dao;

import java.util.ArrayList;

import model.Cliente;

//bussiness logic layer bll = 
public class ClienteDAO {

	public boolean adicionar(Cliente cliente) {

		// Criando um ArrayList para salvar os clientes informados pelo
		// usuário
		ArrayList<String> ListaClientes = new ArrayList<String>();

		ListaClientes.add(cliente.toString());

		System.out.println(ListaClientes);

		return true;

	}

}
