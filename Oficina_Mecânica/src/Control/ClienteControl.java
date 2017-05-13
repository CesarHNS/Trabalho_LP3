package control;

import java.util.ArrayList;

import model.Cliente;

public class ClienteControl {

	public static boolean SalvarAluno(long Id, String Nome, String DataNasc, String Cpf, String Endereco, String Bairro,
			String Cep, String Cidade, String Estado, String Email, String Celular, String Telefone) {

		Cliente c = new Cliente(Id, Nome, DataNasc, Cpf, Endereco, Bairro, Cep, Cidade, Estado, Email, Celular,
				Telefone);

		// salvando o aluno na base de dados
		return c.Persistir();

	}
	
	//não posso retornar um arrayList de clientes dentro do control
	//quando utilizo o padrão mvc
	public static ArrayList<String[]> getClientes(){
		ArrayList<String[]>Clientes = new ArrayList<>();
		
		ArrayList<Cliente> C = Cliente.getClientes();
		
		for(int i=0; i<C.size();i++){
			
			Object c[] = new String[12];
			
			c[0] = C.get(i).getId();	
			c[1] = C.get(i).getNome();
			c[2] = C.get(i).getDataNasc();
			c[3] = C.get(i).getCpf();
			c[4] = C.get(i).getEndereco();
			c[5] = C.get(i).getBairro();
			c[6] = C.get(i).getCep();
			c[7] = C.get(i).getCidade();
			c[8] = C.get(i).getEstado();
			c[9] = C.get(i).getEmail();
			c[10] = C.get(i).getCelular();
			c[11] = C.get(i).getTelefone();			
			
			Clientes.add((String[]) c);

		}
		
		return Clientes; 
	}

}
