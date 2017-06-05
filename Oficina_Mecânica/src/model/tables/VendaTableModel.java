package model.tables;

import java.util.List;
import java.util.Vector;

import javax.swing.table.AbstractTableModel;

import model.Cliente;
import model.Venda;

public class VendaTableModel extends AbstractTableModel {

	/* Lista para armazenar os cabeçalhos da tabela */

	private Vector colunas;

	/* Lista para armazenar os dados da tabela */
	private Vector linhas;

	public VendaTableModel() {
        /* Definição das colunas da tabela */
        colunas = new Vector();
        //colunas.add("Código");
        colunas.add("Valor");
        colunas.add("Data");
        colunas.add("Cliente");
      

        /* Definição dos dados da tabela */
        linhas = new Vector();
    }

	public int getRowCount() {
		/* Captura o total de linhas da tabela */
		int totalLinhas = linhas.size();

		/* Retorna o total de linhas */
		return totalLinhas;
	}

	public int getColumnCount() {
		/* Captura o total de colunas da tabela */
		int totalColunas = colunas.size();

		/* Retorna o total de colunas */
		return totalColunas;
	}

	public String getColumnName(int coluna) {
		/* Captura o nome da coluna */
		String nomeColuna = (String) colunas.get(coluna);

		/* Retorna o nome da coluna */
		return nomeColuna;
	}

	public Object getValueAt(int linha, int coluna) {
		/* Captura o registro informado */
		Vector registro = (Vector) linhas.get(linha);

		/* Dentro do registro captura a coluna selecionada */
		Object dado = registro.get(coluna);

		/* Retorna o valor capturado */
		return dado;
	}

	public void adicionar(List<Venda> listaVendas) {
		/* Reinicializa os dados da tabela */
		linhas = new Vector();

		/* Percorre a lista copiando os dados para a tabela */
		for (Venda v : listaVendas) {

			/* Cria uma linha da tabela */
			Vector<Object> linha = new Vector();
			//linha.add(v.getCodigoVenda());
			linha.add(v.getNomeProduto());
			linha.add(v.getQuantidadeItem());
			linha.add(v.getValorVenda());
			
			/* Adiciona a linha a tabela */
			linhas.add(linha);
		}

		/* Atualiza a tabela */
		fireTableDataChanged();
	}

}
