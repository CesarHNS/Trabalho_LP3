package view;

import java.awt.EventQueue;
import java.awt.SystemColor;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;

import control.ClienteControl;
import control.ProdutoControl;
import control.VendaControl;
import dal.ModuloConexao;
import model.Cliente;
import model.Item;
import model.Produtos;
import model.Venda;
import model.tables.ClienteTableModel;
import model.tables.ItemVendaTableModel;
import model.tables.ModeloTabela;
import model.tables.ProdutoTableModel;
import model.tables.VendaTableModel;

import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import javax.swing.JComboBox;

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
	private JScrollPane scrollPane;
	private JScrollPane scrollPane_1;
	ModeloTabela modelo;
	ClienteTableModel modeloCliente;
	ProdutoTableModel modeloProduto;
	Connection conexao = null;
	PreparedStatement pst = null;
	ResultSet rs = null;
	int flag = 1;
	double precoProduto, total = 0;
	VendaControl vcontrol = new VendaControl();
	Item itenVenda = new Item();
	private JButton btnPesqVenda;

	/***********************************************************************
	 * Launch the application.
	 ***********************************************************************/
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaVendas frame = new TelaVendas();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/***********************************************************************
	 * Create the frame.
	 ***********************************************************************/
	public TelaVendas() {
		setResizable(false);
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosed(WindowEvent arg0) {
				TelaProdutos frame = new TelaProdutos();
				frame.setVisible(false);
				frame.setLocationRelativeTo(null);

			}
		});
		setTitle("Tela de Vendas");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);// fecha apenas a
															// janela onde estou
															// quando clico no X
		conexao = ModuloConexao.conector();

		setBounds(320, 150, 1045, 650);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.scrollbar);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		tfNomeProduto = new JTextField();
		tfNomeProduto.setBounds(10, 33, 367, 23);
		contentPane.add(tfNomeProduto);
		tfNomeProduto.setColumns(10);

		JLabel lblNomeProduto = new JLabel("Nome do Produto:");
		lblNomeProduto.setBounds(10, 17, 127, 14);
		contentPane.add(lblNomeProduto);

		scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 153, 1019, 176);
		contentPane.add(scrollPane_1);

		tablePesquisa = new JTable();
		scrollPane_1.setViewportView(tablePesquisa);
		tablePesquisa.setToolTipText("");

		JButton btnAdicionarItem = new JButton("Adicionar Item");
		btnAdicionarItem.setBackground(SystemColor.controlShadow);
		btnAdicionarItem.setToolTipText("Adicionar um novo produto");
		btnAdicionarItem.setBounds(397, 73, 127, 35);
		contentPane.add(btnAdicionarItem);

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
		Calendar c = Calendar.getInstance();
		java.util.Date data = c.getTime();
		// data no formato dd/mm/aaaa
		DateFormat f = DateFormat.getDateInstance(DateFormat.MEDIUM);
		tfDataVenda.setText(f.format(data));

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

		btnPesqVenda = new JButton("Pesquisar Vendas");
		btnPesqVenda.setToolTipText("Adicionar um novo produto");
		btnPesqVenda.setBackground(SystemColor.controlShadow);
		btnPesqVenda.setBounds(855, 107, 150, 35);
		contentPane.add(btnPesqVenda);

		/******************************************************************
		 * EVENTOS DOS BOTÕES
		 ******************************************************************/
		btnPesquisarProduto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				flag = 1;
				// ao clicar em pesquisar o código da venda é gerado
				// automaticamente
				new VendaControl().criandoVenda();

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

		// Botão que realiza a adição de produtos na tabela de vendas
		btnAdicionarItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Connection conexao = ModuloConexao.conector();
				PreparedStatement pst = null;
				ResultSet rs = null;
				// usando o método que busca o código da venda
				short codVenda = vcontrol.buscaCodVenda();
				int quant = 0;

				String sql = "select * from produto where nome='" + tfNomeProduto.getText() + "'";

				try {
					pst = conexao.prepareStatement(sql);
					rs = pst.executeQuery();
					rs.first();
					quant = rs.getInt("quantidade");

					// verificando a quantidade de produtos no banco
					if (quant >= Integer.parseInt(tfQuantProd.getText())) {
						try {
							itenVenda.setCodVenda(codVenda);
							itenVenda.setNomeProduto(tfNomeProduto.getText());
							itenVenda.setQuantidade(Integer.parseInt(tfQuantProd.getText()));
							// adiciona um item na tabela de vendas
							vcontrol.adicionaItem(itenVenda);
						} catch (Exception e) {
							JOptionPane.showMessageDialog(null, "Preencha os campos corretamente: " + e);
						}
						atualizarTabelaItensVenda(
								"SELECT * FROM produto INNER JOIN itens_venda_produto ON produto.codigo = itens_venda_produto.codigo_produto INNER JOIN venda ON venda.codigo_venda=itens_venda_produto.codigo_venda WHERE venda.codigo_venda="
										+ codVenda);
					} else {
						JOptionPane.showMessageDialog(rootPane,
								"A quantidade desejada não está disponível no estoque!");
					}

				} catch (SQLException ex) {
					JOptionPane.showMessageDialog(rootPane, "Erro ao pesquisar a quantidade:\nERRO:" + ex);
				}
			}
		});

		// Botão que finaliza a venda
		btnRealizarCompra.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Venda v = new Venda();
				short codVenda = vcontrol.buscaCodVenda();
				try {
					v.setCodigoVenda(codVenda);
					v.setNomeCliente(tfNomeCliente.getText());
					v.setDataVenda(tfDataVenda.getText());
					v.setValorVenda(Double.parseDouble(tfValorTotal.getText()));
					
					//new FormaPagamento().setVisible(true);
					//setLocationRelativeTo(null);

					new VendaControl().FechaVenda(v);
					LimparTela();
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, "Preencha os campos corretamente: " + e);
				}
			}
		});

		btnCancelarCompra.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				VendaControl VControl = new VendaControl();
				short codVenda = VControl.buscaCodVenda();
				VControl.deletaVenda(codVenda);

				dispose();
			}
		});

		btnPesqVenda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				new PesquisaVendas().setVisible(true);
				setLocationRelativeTo(null);

			}
		});

	}

	// Método para limpar os TextFields após o cadastramento dos fornecedores
	private void LimparTela() {
		tfNomeCliente.setText("");
		tfNomeProduto.setText("");
		tfValorItem.setText("");
		tfQuantProd.setText("");

	}

	public void atualizarTabelaItensVenda(String sql) {

		ArrayList<Object[]> dados = new ArrayList();
		// ArrayList dados = new ArrayList();
		String[] colunas = new String[] { "Descrição", "Quantidade", "Valor Total" };

		try {
			pst = conexao.prepareStatement(sql);
			rs = pst.executeQuery();
			rs.first();
			// enquanto o meu result set encontrar dados na tabela
			do {

				// variaveis para calcular o valor total da venda
				float valorProduto = rs.getFloat("preco_venda");
				int quantVend = rs.getInt("quant_produto");

				dados.add(new Object[] { rs.getString("nome"), rs.getInt("quant_produto"), valorProduto * quantVend });

			} while (rs.next());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		modelo = new ModeloTabela(dados, colunas);
		tableVendas.setModel(modelo);
		tableVendas.getColumnModel().getColumn(0).setPreferredWidth(500);
		tableVendas.getColumnModel().getColumn(0).setResizable(false);
		tableVendas.getColumnModel().getColumn(1).setPreferredWidth(250);
		tableVendas.getColumnModel().getColumn(1).setResizable(false);
		tableVendas.getColumnModel().getColumn(2).setPreferredWidth(250);
		tableVendas.getColumnModel().getColumn(2).setResizable(false);
		tableVendas.getTableHeader().setReorderingAllowed(false);
		tableVendas.setAutoResizeMode(tableVendas.AUTO_RESIZE_OFF);
		tableVendas.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		/* Atualiza a tabela */
		modelo.fireTableDataChanged();
		SomaProduto();
	}

	public void atualizarTabelaPorBuscaProduto() {
		// TODO Auto-generated method stub
		try {
			/* Criação do modelo */
			Produtos p = new Produtos();
			// seta o campo de prequisa do produto
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

	public void SomaProduto() {
		Connection conexao = ModuloConexao.conector();
		PreparedStatement pst = null;
		ResultSet rs = null;
		total = 0;
		int qtd = 0;
		double valor = 0;
		// usando o método que busca o código da venda
		short codVenda = vcontrol.buscaCodVenda();
		String sql = "select * from itens_venda_produto inner join produto on itens_venda_produto.codigo_produto = produto.codigo where codigo_venda="
				+ codVenda;

		try {
			pst = conexao.prepareStatement(sql);
			rs = pst.executeQuery();
			// rs.first();
			while (rs.next()) {
				qtd = rs.getInt("quant_produto");
				valor = rs.getDouble("preco_venda");
				// calculando o valor total da venda
				total += (valor * qtd);

			}
			tfValorTotal.setText(String.valueOf(total));
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Erro na soma do total da venda: " + e);

		}

	}

	private static class __Tmp {
		private static void __tmp() {
			javax.swing.JPanel __wbp_panel = new javax.swing.JPanel();
		}
	}
}
