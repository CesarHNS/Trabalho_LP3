package model.tables;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.swing.table.AbstractTableModel;

import model.Produtos;

public class ModeloTabela extends AbstractTableModel{
	private ArrayList linhas = null;
	private String[] colunas = null;
	
	public ModeloTabela(ArrayList lin, String[] col){
		setLinhas(lin);
		setColunas(col);
		
	}
	
	public ArrayList getLinhas(){
		return linhas;
	}
	
	public void setLinhas(ArrayList dados){
		linhas = dados;
	}

	public String[] getColunas(){
		return colunas;
	}
	
	public void setColunas(String[] nomes){
		colunas = nomes;
	}
	
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return colunas.length;
	}
	
	public int getRowCount() {
		// TODO Auto-generated method stub
		return linhas.size();
	}
	
	public String getColumnName(int numCol){
		return colunas[numCol];
	}
	
	public Object getValueAt(int numLin, int numCol) {
		// TODO Auto-generated method stub
		Object[] linha = (Object[])getLinhas().get(numLin);
		return linha[numCol];
	}	
	
}
