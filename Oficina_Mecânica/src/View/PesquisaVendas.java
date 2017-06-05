package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;

import dal.ModuloConexao;
import model.tables.ModeloTabela;

import java.awt.FlowLayout;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.UIManager;
import java.awt.SystemColor;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Calendar;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PesquisaVendas extends JFrame {

	private JPanel contentPane;
	private JTable table;
	Connection conexao = null;
	PreparedStatement pst = null;
	ResultSet rs = null;
	ModeloTabela modelo;
	JTable tablePesquisa;
	JTable tableDetalhesVenda;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PesquisaVendas frame = new PesquisaVendas();
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
	public PesquisaVendas() {
		setTitle("Pesquisa de Vendas");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);// fecha apenas a
															// janela onde estou
															// quando clico no X
		conexao = ModuloConexao.conector();

		setBounds(320, 150, 720, 650);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.scrollbar);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		MaskFormatter fmtData = null;
		try {
			fmtData = new MaskFormatter("##/##/####");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		JFormattedTextField tfPesquisa = new JFormattedTextField(fmtData);
		tfPesquisa.setBounds(10, 33, 278, 23);
		contentPane.add(tfPesquisa);
		tfPesquisa.setColumns(10);

		JLabel lblNomeProduto = new JLabel("Digite uma data:");
		lblNomeProduto.setBounds(10, 11, 103, 14);
		contentPane.add(lblNomeProduto);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 102, 684, 176);
		contentPane.add(scrollPane_1);

		tablePesquisa = new JTable();
		scrollPane_1.setViewportView(tablePesquisa);
		tablePesquisa.setToolTipText("");

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 313, 684, 193);
		contentPane.add(scrollPane);

		tableDetalhesVenda = new JTable();
		scrollPane.setViewportView(tableDetalhesVenda);
		tableDetalhesVenda.setToolTipText("");

		JLabel lblTabelaDeVendas = new JLabel("Detalhes da Venda::");
		lblTabelaDeVendas.setBounds(10, 289, 149, 24);
		contentPane.add(lblTabelaDeVendas);
		Calendar c = Calendar.getInstance();
		java.util.Date data = c.getTime();
		// data no formato dd/mm/aaaa
		DateFormat f = DateFormat.getDateInstance(DateFormat.MEDIUM);

		JLabel lblPesquisa = new JLabel("Vendas Realizada::");
		lblPesquisa.setBounds(10, 79, 103, 24);
		contentPane.add(lblPesquisa);

		JButton btnPesquisarProduto = new JButton("Pesquisar");
		btnPesquisarProduto.setToolTipText("Adicionar um novo produto");
		btnPesquisarProduto.setBackground(SystemColor.controlShadow);
		btnPesquisarProduto.setBounds(308, 21, 127, 35);
		contentPane.add(btnPesquisarProduto);

		JButton button = new JButton("Pesquisar");
		button.setToolTipText("Adicionar um novo produto");
		button.setBackground(SystemColor.controlShadow);
		button.setBounds(10, 517, 127, 35);
		contentPane.add(button);

		/***********************************************************************
		 * 
		 **********************************************************************/
		btnPesquisarProduto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				preencherTabela(
						"select * from venda inner join clientes on venda.fk_cliente = clientes.codigo_cliente where data_venda ='"
								+ tfPesquisa.getText() + "'");

			}
		});

		tablePesquisa.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				short cod = (short) tablePesquisa.getValueAt(tablePesquisa.getSelectedRow(), 0);
				preencherTabelaDetalhes(
						"select * from venda inner join itens_venda_produto on venda.codigo_venda = itens_venda_produto.codigo_venda inner join produto on itens_venda_produto.codigo_produto = produto.codigo where venda.codigo_venda = "
								+ cod);

			}

		});
	}

	private void preencherTabela(String sql) {
		Connection conexao = ModuloConexao.conector();
		PreparedStatement pst = null;
		ResultSet rs = null;

		ArrayList<Object[]> dados = new ArrayList();
		// ArrayList dados = new ArrayList();
		String[] colunas = new String[] { "Código venda", "Data venda", "Valor venda", "Cliente" };

		try {
			pst = conexao.prepareStatement(sql);
			rs = pst.executeQuery();
			rs.first();
			// enquanto o meu result set encontrar dados na tabela
			do {

				dados.add(new Object[] { rs.getShort("codigo_venda"), rs.getString("data_venda"),
						rs.getDouble("valor_venda"), rs.getString("nome_cliente") });

			} while (rs.next());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		modelo = new ModeloTabela(dados, colunas);
		tablePesquisa.setModel(modelo);
		tablePesquisa.getColumnModel().getColumn(0).setPreferredWidth(100);
		tablePesquisa.getColumnModel().getColumn(0).setResizable(false);
		tablePesquisa.getColumnModel().getColumn(1).setPreferredWidth(100);
		tablePesquisa.getColumnModel().getColumn(1).setResizable(false);
		tablePesquisa.getColumnModel().getColumn(2).setPreferredWidth(100);
		tablePesquisa.getColumnModel().getColumn(2).setResizable(false);
		tablePesquisa.getColumnModel().getColumn(3).setPreferredWidth(380);
		tablePesquisa.getColumnModel().getColumn(3).setResizable(false);
		tablePesquisa.getTableHeader().setReorderingAllowed(false);
		tablePesquisa.setAutoResizeMode(tablePesquisa.AUTO_RESIZE_OFF);
		tablePesquisa.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		/* Atualiza a tabela */
		modelo.fireTableDataChanged();

	}

	private void preencherTabelaDetalhes(String sql) {
		Connection conexao = ModuloConexao.conector();
		PreparedStatement pst = null;
		ResultSet rs = null;

		ArrayList<Object[]> dados = new ArrayList();
		// ArrayList dados = new ArrayList();
		String[] colunas = new String[] { "Produto", "Quantidade" };

		try {
			pst = conexao.prepareStatement(sql);
			rs = pst.executeQuery();
			rs.first();
			// enquanto o meu result set encontrar dados na tabela
			do {

				dados.add(new Object[] { rs.getString("nome"), rs.getString("quant_produto") });

			} while (rs.next());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		modelo = new ModeloTabela(dados, colunas);
		tableDetalhesVenda.setModel(modelo);
		tableDetalhesVenda.getColumnModel().getColumn(0).setPreferredWidth(400);
		tableDetalhesVenda.getColumnModel().getColumn(0).setResizable(false);
		tableDetalhesVenda.getColumnModel().getColumn(1).setPreferredWidth(280);
		tableDetalhesVenda.getColumnModel().getColumn(1).setResizable(false);
		tableDetalhesVenda.getTableHeader().setReorderingAllowed(false);
		tableDetalhesVenda.setAutoResizeMode(tableDetalhesVenda.AUTO_RESIZE_OFF);
		tableDetalhesVenda.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		/* Atualiza a tabela */
		modelo.fireTableDataChanged();

	}
}
