package control;

import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

import model.Cliente;
import model.Fornecedor;
import model.Produtos;
import model.dao.ClienteDAO;
import model.dao.FornecedorDAO;
import model.dao.ProdutoDAO;
import model.tables.ProdutoTableModel;

public class ProdutoControl {

	public void SalvarProduto(short codigo, String nome, String descricao, double preco_compra, double preco_venda,
			int quantidade, short fk_codigo_forn) {

		Produtos p = new Produtos();

		p.setCodigo(codigo);
		p.setNome(nome);
		p.setDescricao(descricao);
		p.setPrecoCompra(preco_compra);
		p.setPrecoVenda(preco_venda);
		p.setQuantidade(quantidade);
		p.setFornecedor(fk_codigo_forn);

		new ProdutoDAO().create(p);

	}

	public void RemoverProduto(short codigo) {
		Produtos p = new Produtos();
		p.setCodigo(codigo);
		new ProdutoDAO().delete(codigo);
	}

	public void ModificarProduto(short codigo, String nome, String descricao, double preco_compra, double preco_venda,
			int quantidade, short fk_codigo_forn) {

		Produtos p = new Produtos();

		p.setCodigo(codigo);
		p.setNome(nome);
		p.setDescricao(descricao);
		p.setPrecoCompra(preco_compra);
		p.setPrecoVenda(preco_venda);
		p.setQuantidade(quantidade);
		p.setFornecedor(fk_codigo_forn);

		new ProdutoDAO().update(p);
	}

	public void PreencherComboFornecedor() {
		
		
	}

	public void atualizar(ProdutoTableModel modelo) {
		// TODO Auto-generated method stub
		try {
			/* Criação do modelo */
			Produtos p = new Produtos();
			// d.setNome(tfPesquisaCliente.getText());

			/* Criação do DAO */
			ProdutoDAO Pdao = new ProdutoDAO();
			List<Produtos> lista = Pdao.read(p);

			/* Copia os dados da consulta para a tabela */
			modelo.adicionar(lista);

		} catch (Exception ex) {
			ex.printStackTrace();
			JOptionPane.showMessageDialog(null, "Erro ao tentar buscar um produto");
		}
	}

}
