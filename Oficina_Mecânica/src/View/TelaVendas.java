package view;

import java.awt.EventQueue;
import java.awt.SystemColor;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import control.ClienteControl;
import control.ProdutoControl;
import control.VendaControl;
import dal.ModuloConexao;
import model.Cliente;
import model.Produtos;
import model.Venda;
import model.tables.ClienteTableModel;
import model.tables.ProdutoTableModel;
import model.tables.VendaTableModel;

import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class TelaVendas extends JFrame {

	private JPanel contentPane;
	private JTable tablePesquisa;
	private JTextField tfNomeProduto;
	private JTextField tfNomeCliente;
	private JTable tableVendas;
	private JTextField tfQuantProd;
	private JTextField tfDataVenda;
	private JButton btnRealizarCompra;
	private JButton btnCancelarCompra;
	private JTextField tfValorTotal;
	private JLabel lblNewLabel;
	private JLabel lblPesquisa;
	private JButton btnPesquisarProduto;
	private JButton btnPesquisarCliente;
	private JLabel lblData;
	private JLabel lblQuantidade;
	private JTextField tfValorItem;
	private JLabel lblValorItem;
	private JTextField tfCodigoVenda;
	private JLabel lblCdigo;
	private JScrollPane scrollPane;
	private JScrollPane scrollPane_1;
	VendaTableModel modelo;
	ClienteTableModel modeloCliente;
	ProdutoTableModel modeloProduto;
	Connection conexao = null;
	PreparedStatement pst = null;
	ResultSet rs = null;
	int flag = 1;
	double precoProduto;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaVendas frame = new TelaVendas();
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
	public TelaVendas() {
		setResizable(false);
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosed(WindowEvent arg0) {
				TelaProdutos frame = new TelaProdutos();
				frame.setVisible(false);
			}
		});
		setTitle("Tela de Vendas");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);// fecha apenas a
															// janela onde estou
															// quando clico no X
		// Venda v = new Venda();
		conexao = ModuloConexao.conector();
		// new VendaControl().create(v);

		setBounds(320, 150, 1045, 650);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.scrollbar);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		tfNomeProduto = new JTextField();
		tfNomeProduto.setBounds(75, 33, 302, 23);
		contentPane.add(tfNomeProduto);
		tfNomeProduto.setColumns(10);

		JLabel lblNomeProduto = new JLabel("Nome do Produto:");
		lblNomeProduto.setBounds(75, 17, 127, 14);
		contentPane.add(lblNomeProduto);

		scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 153, 1019, 176);
		contentPane.add(scrollPane_1);

		tablePesquisa = new JTable();
		scrollPane_1.setViewportView(tablePesquisa);
		tablePesquisa.setToolTipText("");
		// modelo = new VendaTableModel();
		// tableVenda.setModel(modelo);
		// atualizarTabela();

		JButton btnAdicionarProduto = new JButton("Adicionar Item");
		btnAdicionarProduto.setBackground(SystemColor.controlShadow);
		btnAdicionarProduto.setToolTipText("Adicionar um novo produto");
		btnAdicionarProduto.setBounds(397, 73, 127, 35);
		contentPane.add(btnAdicionarProduto);

		tfNomeCliente = new JTextField();
		tfNomeCliente.setColumns(10);
		tfNomeCliente.setBounds(550, 33, 296, 23);
		contentPane.add(tfNomeCliente);

		JLabel lblDescricaoProduto = new JLabel("Nome Cliente");
		lblDescricaoProduto.setBounds(550, 17, 127, 14);
		contentPane.add(lblDescricaoProduto);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 375, 1019, 193);
		contentPane.add(scrollPane);

		tableVendas = new JTable();
		scrollPane.setViewportView(tableVendas);
		tableVendas.setToolTipText("");
		modelo = new VendaTableModel();
		tableVendas.setModel(modelo);
		
		JLabel lblTabelaDeVendas = new JLabel("Itens da Venda:");
		lblTabelaDeVendas.setBounds(10, 351, 103, 24);
		contentPane.add(lblTabelaDeVendas);

		tfQuantProd = new JTextField();
		tfQuantProd.setColumns(10);
		tfQuantProd.setBounds(10, 85, 103, 23);
		contentPane.add(tfQuantProd);

		tfDataVenda = new JTextField();
		tfDataVenda.setColumns(10);
		tfDataVenda.setBounds(236, 85, 103, 23);
		contentPane.add(tfDataVenda);

		btnRealizarCompra = new JButton("Realizar Venda");
		btnRealizarCompra.setToolTipText("Adicionar um novo produto");
		btnRealizarCompra.setBackground(SystemColor.controlShadow);
		btnRealizarCompra.setBounds(326, 579, 127, 35);
		contentPane.add(btnRealizarCompra);

		btnCancelarCompra = new JButton("Cancelar Venda");
		btnCancelarCompra.setToolTipText("Adicionar um novo produto");
		btnCancelarCompra.setBackground(SystemColor.controlShadow);
		btnCancelarCompra.setBounds(506, 579, 127, 35);
		contentPane.add(btnCancelarCompra);

		tfValorTotal = new JTextField();
		tfValorTotal.setColumns(10);
		tfValorTotal.setBounds(764, 591, 103, 23);
		contentPane.add(tfValorTotal);

		lblNewLabel = new JLabel("Valor Total:");
		lblNewLabel.setBounds(686, 591, 68, 23);
		contentPane.add(lblNewLabel);

		lblPesquisa = new JLabel("Pesquisa:");
		lblPesquisa.setBounds(10, 123, 103, 24);
		contentPane.add(lblPesquisa);

		btnPesquisarProduto = new JButton("Pesquisar");
		btnPesquisarProduto.setToolTipText("Adicionar um novo produto");
		btnPesquisarProduto.setBackground(SystemColor.controlShadow);
		btnPesquisarProduto.setBounds(397, 21, 127, 35);
		contentPane.add(btnPesquisarProduto);

		btnPesquisarCliente = new JButton("Pesquisar");
		btnPesquisarCliente.setToolTipText("Adicionar um novo produto");
		btnPesquisarCliente.setBackground(SystemColor.controlShadow);
		btnPesquisarCliente.setBounds(878, 21, 127, 35);
		contentPane.add(btnPesquisarCliente);

		lblData = new JLabel("Data:");
		lblData.setBounds(236, 65, 127, 14);
		contentPane.add(lblData);

		lblQuantidade = new JLabel("Quantidade:");
		lblQuantidade.setBounds(10, 65, 103, 14);
		contentPane.add(lblQuantidade);

		tfValorItem = new JTextField();
		tfValorItem.setColumns(10);
		tfValorItem.setBounds(123, 85, 103, 23);
		contentPane.add(tfValorItem);

		lblValorItem = new JLabel("Valor por item:");
		lblValorItem.setBounds(123, 65, 103, 14);
		contentPane.add(lblValorItem);

		tfCodigoVenda = new JTextField();
		tfCodigoVenda.setColumns(10);
		tfCodigoVenda.setBounds(10, 33, 55, 23);
		contentPane.add(tfCodigoVenda);

		lblCdigo = new JLabel("C\u00F3digo:");
		lblCdigo.setBounds(10, 17, 55, 14);
		contentPane.add(lblCdigo);

		// BOTÕES
		btnPesquisarProduto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				flag = 1;
				modeloProduto = new ProdutoTableModel();
				tablePesquisa.setModel(modeloProduto);
				atualizarTabelaPorBuscaProduto();
			}
		});

		btnPesquisarCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				flag = 2;
				modeloCliente = new ClienteTableModel();
				tablePesquisa.setModel(modeloCliente);
				atualizarTabelaPorBuscaCliente();
			}
		});

		tablePesquisa.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if (flag == 1) {
					tfNomeProduto.setText(tablePesquisa.getValueAt(tablePesquisa.getSelectedRow(), 1).toString());
					tfValorItem.setText(tablePesquisa.getValueAt(tablePesquisa.getSelectedRow(), 4).toString());
					tfQuantProd.setText("1");

				} else {
					tfNomeCliente.setText(tablePesquisa.getValueAt(tablePesquisa.getSelectedRow(), 1).toString());
				}

			}
		});

		tfQuantProd.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent arg0) {
				double valorTotal;
				valorTotal = Double.parseDouble(tfValorItem.getText()) * Integer.parseInt(tfQuantProd.getText());
				tfValorTotal.setText(String.valueOf("R$" + valorTotal));
			}
		});

		tfDataVenda.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent arg0) {
				double valorTotal;
				valorTotal = Double.parseDouble(tfValorItem.getText()) * Integer.parseInt(tfQuantProd.getText());
				tfValorTotal.setText(String.valueOf("R$" + valorTotal));
			}
		});

		tfValorItem.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				double valorTotal;
				valorTotal = Double.parseDouble(tfValorItem.getText()) * Integer.parseInt(tfQuantProd.getText());
				tfValorTotal.setText(String.valueOf("R$" + valorTotal));
			}
		});

		btnAdicionarProduto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				VendaTableModel modelo = (VendaTableModel) tableVendas.getModel();
				Venda v = new Venda();

				v.setCodigoVenda(Short.parseShort(tfCodigoVenda.getText()));
				v.setDataVenda(tfDataVenda.getText());
				v.setQuantidadeItem(Integer.parseInt(tfQuantProd.getText()));
				v.setNomeProduto(tfNomeProduto.getText());
				//v.setQuantidadeItem(tfQuantProd.getText());

				try {
					new VendaControl().create(v);
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, "Erro: " + e);
				}				
			
				LimparTela();
				atualizarTabela();
			}
		});
	}

	/***********************************************************************
	 * Método para preencher os TextFields
	 **********************************************************************/
	private void PreencheTextField() {

		LimparTela();

		tfCodigoVenda.setText(tablePesquisa.getValueAt(tablePesquisa.getSelectedRow(), 0).toString());
		tfDataVenda.setText(tablePesquisa.getValueAt(tablePesquisa.getSelectedRow(), 3).toString());
		tfValorItem.setText(tablePesquisa.getValueAt(tablePesquisa.getSelectedRow(), 4).toString());
		tfQuantProd.setText(tablePesquisa.getValueAt(tablePesquisa.getSelectedRow(), 5).toString());
		tfNomeProduto.setText(tablePesquisa.getValueAt(tablePesquisa.getSelectedRow(), 1).toString());
		tfNomeCliente.setText(tablePesquisa.getValueAt(tablePesquisa.getSelectedRow(), 2).toString());
	}

	/***********************************************************************
	 * Método para limpar os TextFields após o cadastramento dos fornecedores
	 **********************************************************************/
	private void LimparTela() {
		tfCodigoVenda.setText("");
		tfNomeCliente.setText("");
		tfNomeProduto.setText("");
		tfDataVenda.setText("");
		tfValorItem.setText("");
		tfQuantProd.setText("");

	}

	public void atualizarTabela() {
		// TODO Auto-generated method stub
		try {
			/* Criação do modelo */
			Venda v = new Venda();
			// d.setNome(tfPesquisaCliente.getText());

			/* Criação do DAO */
			VendaControl VControl = new VendaControl();

			// inserindo produtos na lista usando o método read
			List<Venda> lista = VControl.read(v);
			VendaTableModel modelo = (VendaTableModel) tableVendas.getModel();

			/* Copia os dados da consulta para a tabela */
			modelo.adicionar(lista);

		} catch (Exception ex) {
			ex.printStackTrace();
			JOptionPane.showMessageDialog(null, "Erro ao tentar buscar um produto");
		}
	}

	public void atualizarTabelaPorBuscaProduto() {
		// TODO Auto-generated method stub
		try {
			/* Criação do modelo */
			Produtos p = new Produtos();
			// d.setNome(tfPesquisaCliente.getText());
			p.setPesquisa(tfNomeProduto.getText());

			/* Criação do DAO */
			ProdutoControl PControl = new ProdutoControl();

			// inserindo produtos na lista usando o método read
			List<Produtos> lista = PControl.buscaProduto(p);
			// criando um modelo do tipo produto para a tabela

			ProdutoTableModel modeloProduto = (ProdutoTableModel) tablePesquisa.getModel();

			/* Copia os dados da consulta para a tabela */
			modeloProduto.adicionar(lista);

		} catch (Exception ex) {
			ex.printStackTrace();
			JOptionPane.showMessageDialog(null, "Erro ao tentar buscar um produto: " + ex);
		}
	}

	public void atualizarTabelaPorBuscaCliente() {
		// TODO Auto-generated method stub
		try {
			/* Criação do modelo */
			Cliente c = new Cliente();
			// d.setNome(tfPesquisaCliente.getText());
			c.setPesquisa(tfNomeCliente.getText());

			/* Criação do DAO */
			ClienteControl CControl = new ClienteControl();

			// inserindo produtos na lista usando o método read
			List<Cliente> lista = CControl.buscaCliente(c);
			// criando um modelo do tipo produto para a tabela

			ClienteTableModel modeloCliente = (ClienteTableModel) tablePesquisa.getModel();

			/* Copia os dados da consulta para a tabela */
			modeloCliente.adicionar(lista);

		} catch (Exception ex) {
			ex.printStackTrace();
			JOptionPane.showMessageDialog(null, "Erro ao tentar buscar um produto: " + ex);
		}
	}

	private static class __Tmp {
		private static void __tmp() {
			javax.swing.JPanel __wbp_panel = new javax.swing.JPanel();
		}
	}
}
