package view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.SystemColor;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import dal.ModuloConexao;
import model.Cliente;
import model.Item;
import model.OrdemServico;
import model.Produtos;
import model.Venda;
import model.tables.ClienteTableModel;
import model.tables.FuncionarioTableModel;
import model.tables.ModeloTabela;
import model.tables.ProdutoTableModel;
import model.tables.ServicoTableModel;

import java.sql.*;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Calendar;
//import net.proteanit.sql.DbUtils;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import control.ClienteControl;
import control.OrdemServicoControl;
import control.ProdutoControl;
import control.ServicoControl;
import control.VendaControl;

import javax.swing.JRadioButton;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;

public class TelaOrdemServico extends JFrame {

	private JPanel contentPane;
	private JTable tablePesquisa;
	private JTextField tfCliente;
	private JTable tableServicos;
	private JTextField tfDataVenda;
	private JButton btnRealizarCompra;
	private JButton btnCancelarCompra;
	private JTextField tfValorTotal;
	private JLabel lblNewLabel;
	private JLabel lblPesquisa;
	private JButton btnPesqCliente;
	private JLabel lblData;
	private JTextField tfValorServico;
	private JLabel lblValorItem;
	private JScrollPane scrollPane;
	private JScrollPane scrollPane_1;
	ModeloTabela modelo;
	ClienteTableModel modeloCliente;
	FuncionarioTableModel modeloFuncionario;
	ServicoTableModel modeloServico;
	ProdutoTableModel modeloProduto;
	Connection conexao = null;
	PreparedStatement pst = null;
	ResultSet rs = null;
	int flag = 1;
	double precoProduto, total = 0;
	ServicoControl scontrol = new ServicoControl();
	Item itenVenda = new Item();
	private JTextField tfServico;
	private JLabel lblNomeDoServio;
	private JButton btnPesqServico;
	private JTextField tfFuncionario;
	private JLabel lblFuncionrio;
	private JButton btnPesqFuncionario;
	private JComboBox cbVeiculo;

	/***********************************************************************
	 * Launch the application.
	 ***********************************************************************/
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaOrdemServico frame = new TelaOrdemServico();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/***********************************************************************
	 * Create the frame.
	 ***********************************************************************/
	public TelaOrdemServico() {
		setResizable(false);
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosed(WindowEvent arg0) {
				TelaOrdemServico frame = new TelaOrdemServico();
				frame.setVisible(false);
			}
		});
		setTitle("Ordens de Servi\u00E7o");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);// fecha apenas a
															// janela onde estou
															// quando clico no X
		conexao = ModuloConexao.conector();

		new OrdemServicoControl().criaOS();
		
		setBounds(320, 150, 1045, 650);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.scrollbar);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		tfCliente = new JTextField();
		tfCliente.setBounds(10, 27, 367, 23);
		contentPane.add(tfCliente);
		tfCliente.setColumns(10);

		JLabel lblNomeProduto = new JLabel("Nome do Cliente:");
		lblNomeProduto.setBounds(10, 11, 127, 14);
		contentPane.add(lblNomeProduto);

		scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 174, 1019, 176);
		contentPane.add(scrollPane_1);

		tablePesquisa = new JTable();
		scrollPane_1.setViewportView(tablePesquisa);
		tablePesquisa.setToolTipText("");

		JButton btnAdicionaServico = new JButton("Adicionar");
		btnAdicionaServico.setBackground(SystemColor.controlShadow);
		btnAdicionaServico.setToolTipText("Adicionar um novo produto");
		btnAdicionaServico.setBounds(123, 107, 127, 35);
		contentPane.add(btnAdicionaServico);

		JLabel lblDescricaoProduto = new JLabel("Ve\u00EDculo");
		lblDescricaoProduto.setBounds(550, 11, 127, 14);
		contentPane.add(lblDescricaoProduto);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 375, 1019, 193);
		contentPane.add(scrollPane);

		tableServicos = new JTable();
		scrollPane.setViewportView(tableServicos);
		tableServicos.setToolTipText("");

		JLabel lblTabelaDeVendas = new JLabel("Servi\u00E7os:");
		lblTabelaDeVendas.setBounds(10, 351, 103, 24);
		contentPane.add(lblTabelaDeVendas);

		tfDataVenda = new JTextField();
		tfDataVenda.setColumns(10);
		tfDataVenda.setBounds(20, 591, 103, 23);
		contentPane.add(tfDataVenda);
		Calendar c = Calendar.getInstance();
		java.util.Date data = c.getTime();
		// data no formato dd/mm/aaaa
		DateFormat f = DateFormat.getDateInstance(DateFormat.MEDIUM);
		tfDataVenda.setText(f.format(data));

		btnRealizarCompra = new JButton("Finalizar");
		btnRealizarCompra.setToolTipText("Adicionar um novo produto");
		btnRealizarCompra.setBackground(SystemColor.controlShadow);
		btnRealizarCompra.setBounds(326, 579, 127, 35);
		contentPane.add(btnRealizarCompra);

		btnCancelarCompra = new JButton("Cancelar ");
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
		lblPesquisa.setBounds(10, 144, 103, 24);
		contentPane.add(lblPesquisa);

		btnPesqCliente = new JButton("Pesquisar");
		btnPesqCliente.setToolTipText("Adicionar um novo produto");
		btnPesqCliente.setBackground(SystemColor.controlShadow);
		btnPesqCliente.setBounds(397, 15, 127, 35);
		contentPane.add(btnPesqCliente);

		lblData = new JLabel("Data:");
		lblData.setBounds(20, 571, 127, 14);
		contentPane.add(lblData);

		tfValorServico = new JTextField();
		tfValorServico.setColumns(10);
		tfValorServico.setBounds(10, 119, 103, 23);
		contentPane.add(tfValorServico);

		lblValorItem = new JLabel("Valor do Servi\u00E7o:");
		lblValorItem.setBounds(10, 99, 103, 14);
		contentPane.add(lblValorItem);

		tfServico = new JTextField();
		tfServico.setColumns(10);
		tfServico.setBounds(10, 70, 367, 23);
		contentPane.add(tfServico);

		lblNomeDoServio = new JLabel("Nome do Servi\u00E7o:");
		lblNomeDoServio.setBounds(10, 54, 127, 14);
		contentPane.add(lblNomeDoServio);

		btnPesqServico = new JButton("Pesquisar");
		btnPesqServico.setToolTipText("Adicionar um novo produto");
		btnPesqServico.setBackground(SystemColor.controlShadow);
		btnPesqServico.setBounds(397, 58, 127, 35);
		contentPane.add(btnPesqServico);

		tfFuncionario = new JTextField();
		tfFuncionario.setColumns(10);
		tfFuncionario.setBounds(550, 70, 296, 23);
		contentPane.add(tfFuncionario);

		lblFuncionrio = new JLabel("Funcion\u00E1rio:");
		lblFuncionrio.setBounds(550, 54, 127, 14);
		contentPane.add(lblFuncionrio);

		btnPesqFuncionario = new JButton("Pesquisar");
		btnPesqFuncionario.setToolTipText("Adicionar um novo produto");
		btnPesqFuncionario.setBackground(SystemColor.controlShadow);
		btnPesqFuncionario.setBounds(878, 58, 127, 35);
		contentPane.add(btnPesqFuncionario);

		cbVeiculo = new JComboBox();
		cbVeiculo.setBounds(550, 27, 296, 23);
		contentPane.add(cbVeiculo);

		/******************************************************************
		 * EVENTOS DOS BOTÕES
		 ******************************************************************/
		btnPesqCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//a flag é utilizada para informar a tabela qual pesquisa que irá preenche-la
				flag = 1;
				modeloCliente = new ClienteTableModel();
				tablePesquisa.setModel(modeloCliente);
				atualizarTabelaPorBuscaCliente(tablePesquisa);
				preecherCombo();
			}
		});

		btnPesqFuncionario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				flag = 2;
				modeloFuncionario = new FuncionarioTableModel();
				tablePesquisa.setModel(modeloFuncionario);
				new TelaFuncionarios().atualizarTabelaPorBusca(tablePesquisa);
			}
		});

		btnPesqServico.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				flag = 3;
				modeloServico = new ServicoTableModel();
				tablePesquisa.setModel(modeloServico);
				new TelaServico().atualizarTabelaPorBusca(tablePesquisa);
			}
		});

		tablePesquisa.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if (flag == 1) {
					tfCliente.setText(tablePesquisa.getValueAt(tablePesquisa.getSelectedRow(), 1).toString());
					preecherCombo();

				} else if (flag == 2) {
					tfFuncionario.setText(tablePesquisa.getValueAt(tablePesquisa.getSelectedRow(), 1).toString());

				} else if (flag == 3) {
					tfServico.setText(tablePesquisa.getValueAt(tablePesquisa.getSelectedRow(), 1).toString());
					tfValorServico.setText(tablePesquisa.getValueAt(tablePesquisa.getSelectedRow(), 2).toString());

				}
			}
		});

	}

	public void preecherCombo() {
		Connection conexao = ModuloConexao.conector();
		PreparedStatement pst = null;
		ResultSet rs = null;
		short codCliente = new ServicoControl().buscaCodigoCliente(tfCliente.getText());

		String sql = "select nome_veiculo from clientes inner join  veiculo on clientes.codigo_cliente = veiculo.codigo_cliente where clientes.codigo_cliente="
				+ codCliente;

		try {
			pst = conexao.prepareStatement(sql);
			rs = pst.executeQuery();
			cbVeiculo.removeAllItems();
			while (rs.next()) {
				cbVeiculo.addItem(rs.getString("nome_veiculo"));
			}
			new ModuloConexao().closeConnection(conexao);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Erro ao preecher combobox\nERRO:" + e);
		}

	}

	public void atualizarTabelaPorBuscaCliente(JTable tablePesquisa) {
		// TODO Auto-generated method stub
		try {
			/* Criação do modelo */
			Cliente c = new Cliente();
			// d.setNome(tfPesquisaCliente.getText());
			c.setPesquisa(tfCliente.getText());

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
