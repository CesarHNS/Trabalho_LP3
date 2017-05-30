package view;

import java.awt.EventQueue;
import java.awt.SystemColor;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import control.FornecedorControl;
import dal.ModuloConexao;
import model.Funcionario;
import model.Produtos;
import control.ProdutoControl;
import model.tables.ClienteTableModel;
import model.tables.FornecedorTableModel;
import model.tables.ProdutoTableModel;

import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class TelaProdutos extends JFrame {

	private JPanel contentPane;
	private JTable jtCadProduto;
	private JTextField tfNomeProduto;
	private JTextField tfDigitePesquisa;
	private JTextField tfCodigoProduto;
	private JTextField tfDescricaoProduto;
	private JTextField tfPrecoCompra;
	private JTextField tfQuantidadeProduto;
	private JTextField tfPrecoVenda;
	private JComboBox cbFornecedor;
	ProdutoTableModel modelo;
	Connection conexao = null;
	PreparedStatement pst = null;
	ResultSet rs = null;
	private JTextField tfCodFornecedor;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaProdutos frame = new TelaProdutos();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TelaProdutos() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosed(WindowEvent arg0) {
				TelaProdutos frame = new TelaProdutos();
				frame.setVisible(false);
			}
		});
		setTitle("Tela de cadastro de produtos");
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);// fecha apenas a
															// janela onde estou
															// quando clico no X
		conexao = ModuloConexao.conector();

		setBounds(320, 150, 1045, 650);
		contentPane = new JPanel();
		contentPane.setToolTipText("Adicionar Fornecedor");
		contentPane.setBackground(SystemColor.scrollbar);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		tfNomeProduto = new JTextField();
		tfNomeProduto.setBounds(54, 33, 296, 23);
		contentPane.add(tfNomeProduto);
		tfNomeProduto.setColumns(10);

		JLabel lblNomeProduto = new JLabel("Nome do Produto:");
		lblNomeProduto.setBounds(54, 17, 127, 14);
		contentPane.add(lblNomeProduto);

		tfDigitePesquisa = new JTextField();
		tfDigitePesquisa.setBounds(675, 119, 238, 23);
		tfDigitePesquisa.setColumns(10);
		contentPane.add(tfDigitePesquisa);

		JLabel lblPesquisar = new JLabel("Digite sua pesquisa aqui:");
		lblPesquisar.setBounds(675, 104, 151, 14);
		contentPane.add(lblPesquisar);

		JButton btnPesquisarProduto = new JButton("Pesquisar");
		btnPesquisarProduto.setBackground(SystemColor.controlShadow);
		btnPesquisarProduto.setBounds(923, 121, 106, 23);
		contentPane.add(btnPesquisarProduto);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 153, 1019, 457);
		contentPane.add(scrollPane);

		JButton btnAdicionarProduto = new JButton("Adicionar");
		btnAdicionarProduto.setBackground(SystemColor.controlShadow);
		btnAdicionarProduto.setToolTipText("Adicionar um novo produto");
		btnAdicionarProduto.setBounds(10, 107, 127, 35);
		contentPane.add(btnAdicionarProduto);

		JButton btnRemoverProduto = new JButton("Remover");
		btnRemoverProduto.setBackground(SystemColor.controlShadow);
		btnRemoverProduto.setToolTipText("Remover um produto");
		btnRemoverProduto.setBounds(158, 107, 127, 35);
		contentPane.add(btnRemoverProduto);

		JButton btnModificarProduto = new JButton("Modificar");
		btnModificarProduto.setBackground(SystemColor.controlShadow);
		btnModificarProduto.setToolTipText("Modificar um produto");
		btnModificarProduto.setBounds(303, 107, 127, 35);
		contentPane.add(btnModificarProduto);

		JLabel lblCodigoProduto = new JLabel("C\u00F3digo:");
		lblCodigoProduto.setBounds(10, 17, 57, 14);
		contentPane.add(lblCodigoProduto);

		tfCodigoProduto = new JTextField();
		tfCodigoProduto.setBounds(10, 33, 38, 23);
		contentPane.add(tfCodigoProduto);
		tfCodigoProduto.setColumns(10);

		tfDescricaoProduto = new JTextField();
		tfDescricaoProduto.setColumns(10);
		tfDescricaoProduto.setBounds(356, 33, 296, 23);
		contentPane.add(tfDescricaoProduto);

		JLabel lblDescricaoProduto = new JLabel("Descri\u00E7\u00E3o do Produto:");
		lblDescricaoProduto.setBounds(356, 17, 127, 14);
		contentPane.add(lblDescricaoProduto);

		tfPrecoCompra = new JTextField();
		tfPrecoCompra.setColumns(10);
		tfPrecoCompra.setBounds(662, 33, 86, 23);
		contentPane.add(tfPrecoCompra);

		JLabel lblPrecoProduto = new JLabel("Pre\u00E7o de Compra:");
		lblPrecoProduto.setBounds(662, 17, 98, 14);
		contentPane.add(lblPrecoProduto);

		tfQuantidadeProduto = new JTextField();
		tfQuantidadeProduto.setColumns(10);
		tfQuantidadeProduto.setBounds(854, 33, 57, 23);
		contentPane.add(tfQuantidadeProduto);

		JLabel lblQuantidadeProduto = new JLabel("Quantidade");
		lblQuantidadeProduto.setBounds(854, 17, 76, 14);
		contentPane.add(lblQuantidadeProduto);

		JLabel lblPreoDeVenda = new JLabel("Pre\u00E7o de Venda:");
		lblPreoDeVenda.setBounds(762, 17, 98, 14);
		contentPane.add(lblPreoDeVenda);

		tfPrecoVenda = new JTextField();
		tfPrecoVenda.setColumns(10);
		tfPrecoVenda.setBounds(758, 33, 86, 23);
		contentPane.add(tfPrecoVenda);

		JLabel label = new JLabel("Fornecedor:");
		label.setBounds(10, 56, 106, 14);
		contentPane.add(label);

		JButton btnAddFornecedor = new JButton("+");

		btnAddFornecedor.setBounds(360, 69, 41, 23);
		contentPane.add(btnAddFornecedor);

		cbFornecedor = new JComboBox();
		cbFornecedor.setModel(new DefaultComboBoxModel(new String[] { "Teste" }));
		cbFornecedor.setBounds(10, 69, 340, 23);
		contentPane.add(cbFornecedor);
		preecherCombo();

		jtCadProduto = new JTable();
		scrollPane.setViewportView(jtCadProduto);
		jtCadProduto.setToolTipText("");
		modelo = new ProdutoTableModel();
		jtCadProduto.setModel(modelo);

		tfCodFornecedor = new JTextField();
		tfCodFornecedor.setColumns(10);
		tfCodFornecedor.setBounds(410, 69, 38, 23);
		contentPane.add(tfCodFornecedor);

		JLabel label_1 = new JLabel("C\u00F3digo:");
		label_1.setBounds(410, 53, 57, 14);
		contentPane.add(label_1);
		// atualizando a JTable ao abrir a tela de cadastro de produtos
		atualizarTabela();

		// BOTÃO PARA ADICIONAR PRODUTOS
		btnAdicionarProduto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ProdutoTableModel modelo = (ProdutoTableModel) jtCadProduto.getModel();
				Produtos p = new Produtos();

				p.setCodigo(Short.parseShort(tfCodigoProduto.getText()));
				p.setNome(tfNomeProduto.getText());
				p.setDescricao(tfDescricaoProduto.getText());
				p.setPrecoCompra(Double.parseDouble(tfPrecoCompra.getText()));
				p.setPrecoVenda(Double.parseDouble(tfPrecoVenda.getText()));
				p.setQuantidade(Integer.parseInt(tfQuantidadeProduto.getText()));
				p.setFornecedor(cbFornecedor.getSelectedItem().toString());

				try {
					new ProdutoControl().create(p);
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, "Erro: " + e);
				}
				LimparTela();
				atualizarTabela();
			}
		});

		btnRemoverProduto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ProdutoTableModel modelo = (ProdutoTableModel) jtCadProduto.getModel();

				if (jtCadProduto.getSelectedRow() != -1) {
					new ProdutoControl().delete(Short.parseShort(tfCodigoProduto.getText()));
				} else {
					JOptionPane.showMessageDialog(null, "Selecione um produto");
				}

				LimparTela();
				atualizarTabela();
			}
		});

		btnModificarProduto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Produtos p = new Produtos();

				if (jtCadProduto.getSelectedRow() != -1) {

					p.setCodigo(Short.parseShort(tfCodigoProduto.getText()));
					p.setNome(tfNomeProduto.getText());
					p.setDescricao(tfDescricaoProduto.getText());
					p.setPrecoCompra(Double.parseDouble(tfPrecoCompra.getText()));
					p.setPrecoVenda(Double.parseDouble(tfPrecoVenda.getText()));
					p.setQuantidade(Integer.parseInt(tfQuantidadeProduto.getText()));
					p.setFornecedor(cbFornecedor.getSelectedItem().toString());

					new ProdutoControl().updateProduto(p);

				} else {
					JOptionPane.showMessageDialog(null, "Selecione um produto");
				}

				LimparTela();
				atualizarTabela();
			}
		});

		btnAddFornecedor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaFornecedores telaForn = new TelaFornecedores();
				// ProdutoControl PControl = new ProdutoControl();

				// mostra a tela de fornecedores
				telaForn.setVisible(true);
				// fecha a tela de produtos
				dispose();
				preecherCombo();
			}
		});

		jtCadProduto.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				PreencheTextField();
				new ProdutoControl().buscaNomeFornecedor(Short.parseShort(tfCodFornecedor.getText()));
			}
		});

		btnPesquisarProduto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				atualizarTabelaPorBusca();
			}
		});
	}

	public void preecherCombo() {
		Connection conexao = ModuloConexao.conector();
		PreparedStatement pst = null;
		ResultSet rs = null;

		String sql = "select * from fornecedores order by nome_forn";

		try {
			pst = conexao.prepareStatement(sql);
			rs = pst.executeQuery();
			cbFornecedor.removeAllItems();
			while (rs.next()) {
				cbFornecedor.addItem(rs.getString("nome_forn"));
			}
			new ModuloConexao().closeConnection(conexao);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Erro ao preecher combobox\nERRO:" + e);
		}

	}

	/***********************************************************************
	 * Método para preencher os TextFields
	 **********************************************************************/
	private void PreencheTextField() {

		LimparTela();

		tfCodigoProduto.setText(jtCadProduto.getValueAt(jtCadProduto.getSelectedRow(), 0).toString());
		tfNomeProduto.setText(jtCadProduto.getValueAt(jtCadProduto.getSelectedRow(), 1).toString());
		tfDescricaoProduto.setText(jtCadProduto.getValueAt(jtCadProduto.getSelectedRow(), 2).toString());
		tfPrecoCompra.setText(jtCadProduto.getValueAt(jtCadProduto.getSelectedRow(), 3).toString());
		tfPrecoVenda.setText(jtCadProduto.getValueAt(jtCadProduto.getSelectedRow(), 4).toString());
		tfQuantidadeProduto.setText(jtCadProduto.getValueAt(jtCadProduto.getSelectedRow(), 5).toString());
		cbFornecedor.setSelectedItem(jtCadProduto.getValueAt(jtCadProduto.getSelectedRow(), 6).toString());
		tfCodFornecedor.setText(jtCadProduto.getValueAt(jtCadProduto.getSelectedRow(), 7).toString());

	}

	/***********************************************************************
	 * Método para limpar os TextFields após o cadastramento dos fornecedores
	 **********************************************************************/
	private void LimparTela() {
		tfCodigoProduto.setText("");
		tfNomeProduto.setText("");
		tfDescricaoProduto.setText("");
		tfPrecoCompra.setText("");
		tfPrecoVenda.setText("");
		tfQuantidadeProduto.setText("");
		// cbFornecedor.setSelectedIndex(0);

	}

	public void atualizarTabela() {
		// TODO Auto-generated method stub
		try {
			/* Criação do modelo */
			Produtos p = new Produtos();
			// d.setNome(tfPesquisaCliente.getText());

			/* Criação do DAO */
			ProdutoControl Pdao = new ProdutoControl();

			// inserindo produtos na lista usando o método read
			List<Produtos> lista = Pdao.read(p);
			ProdutoTableModel modelo = (ProdutoTableModel) jtCadProduto.getModel();

			/* Copia os dados da consulta para a tabela */
			modelo.adicionar(lista);

		} catch (Exception ex) {
			ex.printStackTrace();
			JOptionPane.showMessageDialog(null, "Erro ao tentar buscar um produto");
		}
	}

	public void atualizarTabelaPorBusca() {
		// TODO Auto-generated method stub
		try {
			/* Criação do modelo */
			Produtos p = new Produtos();
			// d.setNome(tfPesquisaCliente.getText());
			p.setPesquisa(tfDigitePesquisa.getText());

			/* Criação do DAO */
			ProdutoControl Pdao = new ProdutoControl();

			// inserindo produtos na lista usando o método read
			List<Produtos> lista = Pdao.buscaProduto(p);
			ProdutoTableModel modelo = (ProdutoTableModel) jtCadProduto.getModel();

			/* Copia os dados da consulta para a tabela */
			modelo.adicionar(lista);

		} catch (Exception ex) {
			ex.printStackTrace();
			JOptionPane.showMessageDialog(null, "Erro ao tentar buscar um produto");
		}
	}

	private static class __Tmp {
		private static void __tmp() {
			javax.swing.JPanel __wbp_panel = new javax.swing.JPanel();
		}
	}
}
