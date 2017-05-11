package Model;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter.DEFAULT;

/*********************************************************************
 * 
 * @author César
 *
 *         Essa classe é utilizada para adicionar os clientes na JTable
 ********************************************************************/
public class ClienteTableModel extends AbstractTableModel {

	private List<Cliente> linhas;
	private String[] NomesColunas = { "Código", "Nome", "Data de Nascimento", "CPF", "Endereco", "Bairro", "CEP",
			"Cidade", "Estado", "Email", "Celular", "Telefone" };

	public ClienteTableModel() {
		linhas = new ArrayList<Cliente>();
	}

	public ClienteTableModel(List<Funcionario> lista) {
		linhas = new ArrayList<Cliente>();
	}

	@Override
	public int getColumnCount() {
		return NomesColunas.length;
	}

	@Override
	public int getRowCount() {
		return linhas.size();
	}

	@Override
	public String getColumnName(int columnIndex) {
		return this.NomesColunas[columnIndex];
	}

	public Class<?> getColumnClass(int columnIndex) {
		switch (columnIndex) {
		case 8:
			return Item.class;
		default:
			return String.class;
		}

	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Cliente cliente = linhas.get(rowIndex);

		switch (columnIndex) {
		case 0:
			return cliente.getId();
		case 1:
			return cliente.getNome();
		case 2:
			return cliente.getDataNasc();
		case 3:
			return cliente.getCpf();
		case 4:
			return cliente.getEndereco();
		case 5:
			return cliente.getBairro();
		case 6:
			return cliente.getCep();
		case 7:
			return cliente.getCidade();
		case 8:
			return cliente.getEstado();
		case 9:
			return cliente.getEmail();
		case 10:
			return cliente.getCelular();
		case 11:
			return cliente.getTelefone();
		default:
			throw new IndexOutOfBoundsException("columnIndex out of bounds");

		}

	}

	// modifica linha especificada
	@Override
	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
		Cliente cliente = linhas.get(rowIndex);// carrega o item da linha que
												// deve ser modificado

		switch (columnIndex) {// seta o valor do campo respectivo
		case 0:
			cliente.setId(Long.parseLong(aValue.toString()));
		case 1:
			cliente.setNome(aValue.toString());
		case 2:
			cliente.setDataNasc(aValue.toString());
		case 3:
			cliente.setCpf(aValue.toString());
		case 4:
			cliente.setEndereco(aValue.toString());
		case 5:
			cliente.setBairro(aValue.toString());
		case 6:
			cliente.setCep(aValue.toString());
		case 7:
			cliente.setCidade(aValue.toString());
		case 8:
			cliente.setEstado(aValue.toString());
		case 9:
			cliente.setEmail(aValue.toString());
		case 10:
			cliente.setCelular(aValue.toString());
		case 11:
			cliente.setTelefone(aValue.toString());
		default:

		}
		fireTableCellUpdated(rowIndex, columnIndex);

	}

	// modifica linha especificada
	public void setValueAt(Cliente aValue, int rowIndex) {
		Cliente cliente = linhas.get(rowIndex);

		cliente.setId(Long.parseLong(aValue.toString()));
		cliente.setNome(aValue.toString());
		cliente.setDataNasc(aValue.toString());
		cliente.setCpf(aValue.toString());
		cliente.setEndereco(aValue.toString());
		cliente.setBairro(aValue.toString());
		cliente.setCep(aValue.toString());
		cliente.setCidade(aValue.toString());
		cliente.setEstado(aValue.toString());
		cliente.setEmail(aValue.toString());
		cliente.setCelular(aValue.toString());
		cliente.setTelefone(aValue.toString());

		fireTableCellUpdated(rowIndex, 0);
		fireTableCellUpdated(rowIndex, 1);
		fireTableCellUpdated(rowIndex, 2);
		fireTableCellUpdated(rowIndex, 3);
		fireTableCellUpdated(rowIndex, 4);
		fireTableCellUpdated(rowIndex, 5);
		fireTableCellUpdated(rowIndex, 6);
		fireTableCellUpdated(rowIndex, 7);
		fireTableCellUpdated(rowIndex, 8);
		fireTableCellUpdated(rowIndex, 9);
		fireTableCellUpdated(rowIndex, 10);
		fireTableCellUpdated(rowIndex, 11);

	}

	public Cliente getCliente(int rowIndex) {
		return linhas.get(rowIndex);
	}

	public void addCliente(Cliente cliente) {
		// adiciona o registro
		this.linhas.add(cliente);
		this.fireTableDataChanged();
	}

	/* remove uma linha especificada */
	public void removeCliente(int linha) {
		this.linhas.remove(linha);
		this.fireTableRowsDeleted(linha, linha);

	}

	/* adiciona uma lista de cliente ao final dos registros */
	public void addLista(List<Cliente> cliente) {
		// pega o tamanho antigo da tabela
		int tamanhoAntigo = getRowCount();

		// adiciona os registros
		linhas.addAll(cliente);
		fireTableRowsInserted(tamanhoAntigo, getRowCount() - 1);

	}

	/* remove todos os registros */
	public void limpar() {
		linhas.clear();
		fireTableDataChanged();
	}

	/* verifica se este table model esta vazio */
	public boolean isEmpty() {
		return linhas.isEmpty();
	}

}
