package Dao;

import java.awt.List;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import Model.Cliente;

//bussiness logic layer bll = 
public class ClienteDAO {

	public boolean adicionar(Cliente cliente) {
		try {

			// Criando um ArrayList para salvar os clientes informados pelo
			// usuário
			ArrayList<String> ListaClientes = new ArrayList<String>();

			ListaClientes.add(cliente.toString());

		} catch (Exception e) {

			JOptionPane.showMessageDialog(null, e);

			return false;
		} finally {
			for (int i = 0; i < 1; i++) {

				JOptionPane.showMessageDialog(null, cliente);
			}
		}
		return true;

	}

}
