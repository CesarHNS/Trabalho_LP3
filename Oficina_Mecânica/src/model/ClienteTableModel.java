package model;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.swing.table.AbstractTableModel;

/*********************************************************************
 * 
 * @author César
 *
 *         Essa classe é utilizada para adicionar os clientes na JTable
 ********************************************************************/
public class ClienteTableModel extends AbstractTableModel {

    /* Lista para armazenar os cabeçalhos da tabela */

    private Vector colunas;

    /* Lista para armazenar os dados da tabela */
    private Vector linhas;

    public ClienteTableModel() {
        /* Definição das colunas da tabela */
        colunas = new Vector();
        colunas.add("Código");
        colunas.add("Nome");
        colunas.add("Data de Nascimento");
        colunas.add("CPF");
        colunas.add("Endereço");
        colunas.add("Bairro");
        colunas.add("CEP");
        colunas.add("Cidade");
        colunas.add("Estado");
        colunas.add("Email");
        colunas.add("Telefone");
        colunas.add("Celular");

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

    public void adicionar(List<Cliente> lista) {
        /* Reinicializa os dados da tabela */
        linhas = new Vector();

        /* Percorre a lista copiando os dados para a tabela */
        for (Cliente d : lista) {

            /* Cria uma linha da tabela */
            Vector<Object> linha = new Vector();
            linha.add(d.getId());
            linha.add(d.getNome());
            linha.add(d.getDataNasc());
            linha.add(d.getCpf());
            linha.add(d.getEndereco());
            linha.add(d.getBairro());
            linha.add(d.getCep());
            linha.add(d.getCidade());
            linha.add(d.getEstado());
            linha.add(d.getEmail());
            linha.add(d.getTelefone());
            linha.add(d.getCelular());
            
            /* Adiciona a linha a tabela */
            linhas.add(linha);
        }

        /* Atualiza a tabela */
        fireTableDataChanged();
    }
    


}
