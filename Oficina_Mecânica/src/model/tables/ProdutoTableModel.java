package model.tables;

import java.util.List;
import java.util.Vector;

import javax.swing.table.AbstractTableModel;

import model.Cliente;
import model.Produtos;

public class ProdutoTableModel extends AbstractTableModel{
    /* Lista para armazenar os cabeçalhos da tabela */

    private Vector colunas;

    /* Lista para armazenar os dados da tabela */
    private Vector linhas;

    public ProdutoTableModel() {
        /* Definição das colunas da tabela */
        colunas = new Vector();
        colunas.add("Código");
        colunas.add("Nome");
        colunas.add("Descrição");
        colunas.add("Preço de Compra");
        colunas.add("Preço de Venda");
        colunas.add("Quantidade");
        colunas.add("Fornecedor");

        
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

    public void adicionar(List<Produtos> lista) {
        /* Reinicializa os dados da tabela */
        linhas = new Vector();

        /* Percorre a lista copiando os dados para a tabela */
        for (Produtos p : lista) {

            /* Cria uma linha da tabela */
            Vector<Object> linha = new Vector();
            linha.add(p.getCodigo());
            linha.add(p.getNome());
            linha.add(p.getDescricao());
            linha.add(p.getPrecoCompra());
            linha.add(p.getPrecoVenda());
            linha.add(p.getQuantidade());
            linha.add(p.getFornecedor());
          
            
            /* Adiciona a linha a tabela */
            linhas.add(linha);
        }

        /* Atualiza a tabela */
        fireTableDataChanged();
    }
    
}
