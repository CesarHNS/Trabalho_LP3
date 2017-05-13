package tableModel;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import model.Cliente;
import model.Funcionario;
import model.Item;

/*********************************************************************
 * 
 * @author César
 *
 *         Essa classe é utilizada para adicionar os clientes na JTable
 ********************************************************************/
public class ClienteTableModel extends AbstractTableModel {

	private List<String[]> linhas;
	private String[] NomesColunas = { "Código", "Nome", "Data de Nascimento", "CPF", "Endereco", "Bairro", "CEP",
			"Cidade", "Estado", "Email", "Celular", "Telefone" };

	public ClienteTableModel() {
		linhas = new ArrayList<String[]>();
	}

	public ClienteTableModel(List<Funcionario> lista) {
		linhas = new ArrayList<String[]>();
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
		String[] temporaria = linhas.get(rowIndex);

		switch (columnIndex) {
		case 0:
			return temporaria[0];
		case 1:
			return temporaria[1];
		case 2:
			return temporaria[2];
		case 3:
			return temporaria[3];
		case 4:
			return temporaria[4];
		case 5:
			return temporaria[5];
		case 6:
			return temporaria[6];
		case 7:
			return temporaria[7];
		case 8:
			return temporaria[8];
		case 9:
			return temporaria[9];
		case 10:
			return temporaria[10];
		case 11:
			return temporaria[11];
		default:
			throw new IndexOutOfBoundsException("columnIndex out of bounds");

		}

	}

	// modifica linha especificada
	@Override
	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
		String temporaria[] = linhas.get(rowIndex);// carrega o item da linha
													// que
													// deve ser modificado

		switch (columnIndex) {// seta o valor do campo respectivo
		case 0:
			temporaria[0] = aValue.toString();
		case 1:
			temporaria[1] = aValue.toString();
		case 2:
			temporaria[2] = aValue.toString();
		case 3:
			temporaria[3] = aValue.toString();
		case 4:
			temporaria[4] = aValue.toString();
		case 5:
			temporaria[5] = aValue.toString();
		case 6:
			temporaria[6] = aValue.toString();
		case 7:
			temporaria[7] = aValue.toString();
		case 8:
			temporaria[8] = aValue.toString();
		case 9:
			temporaria[9] = aValue.toString();
		case 10:
			temporaria[10] = aValue.toString();
		case 11:
			temporaria[11] = aValue.toString();
		default:

		}
		fireTableCellUpdated(rowIndex, columnIndex);

	}

	// modifica linha especificada
	public void setValueAt(String[] aValue, int rowIndex) {
		String temporaria[] = linhas.get(rowIndex);
		
		temporaria[0] = aValue[0];
		temporaria[1] = aValue[1];
		temporaria[2] = aValue[2];
		temporaria[3] = aValue[3];
		temporaria[4] = aValue[4];
		temporaria[5] = aValue[5];
		temporaria[6] = aValue[6];
		temporaria[7] = aValue[7];
		temporaria[8] = aValue[8];
		temporaria[9] = aValue[9];
		temporaria[10] = aValue[10];
		temporaria[11] = aValue[11];
	


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

	public String[] getCliente(int rowIndex) {
		return linhas.get(rowIndex);
	}

	public void addCliente(String[] cliente) {
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
	public void addLista(List<String[]> cliente) {
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
