package Model;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

/*********************************************************************
 * 
 * @author César
 *
 * Essa classe é utilizada para adicionar os clientes na JTable
 ********************************************************************/
public class ClienteTableModel extends AbstractTableModel {

	private ArrayList<Cliente> ListaCliente;
	private String[] NomesColunas = { "Código", "Nome", "Data de Nascimento", "CPF", "Endereco", "Bairro","CEP", "Cidade",
			"Estado", "Email", "Telefone", "Celular" };
	
	
	public ClienteTableModel(){
		this.ListaCliente = new ArrayList<>();
	}

	public void adicionaCliente(Cliente cliente) {
		this.ListaCliente.add(cliente);
		fireTableDataChanged();

	}

	public void removeCliente(int rowIndex) {
		this.ListaCliente.remove(rowIndex);
		fireTableDataChanged();

	}

	public Cliente getCliente(int rowIndex) {
		return this.ListaCliente.get(rowIndex);
	}

	@Override
	public String getColumnName(int columnIndex) {
		return this.NomesColunas[columnIndex];
	}

	@Override
	public int getColumnCount() {
		return NomesColunas.length;
	}

	@Override
	public int getRowCount() {
		return ListaCliente.size();
	}

	@Override
	public Object getValueAt(int linha, int coluna) {
		switch (coluna) {
		case 0:
			return ListaCliente.get(linha).getId();
		case 1:
			return ListaCliente.get(linha).getNome();
		case 2:
			return ListaCliente.get(linha).getDataNasc();
		case 3:
			return ListaCliente.get(linha).getCpf();
		case 4:
			return ListaCliente.get(linha).getEndereco();
		case 5:
			return ListaCliente.get(linha).getBairro();
		case 6:
			return ListaCliente.get(linha).getCep();
		case 7:
			return ListaCliente.get(linha).getCidade();
		case 8:
			return ListaCliente.get(linha).getEstado();
		case 9:
			return ListaCliente.get(linha).getEmail();
		case 10:
			return ListaCliente.get(linha).getTelefone();
		case 11:
			return ListaCliente.get(linha).getCelular();
		default:
			return ListaCliente.get(linha);

		}

	}

	public void addRow(Cliente cliente) {
		this.ListaCliente.add(cliente);
		this.fireTableDataChanged();
	}
	
	public void removeRow(int linha){
		this.ListaCliente.remove(linha);
		this.fireTableRowsDeleted(linha, linha);
				
	}

}
