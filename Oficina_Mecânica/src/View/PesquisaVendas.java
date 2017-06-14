package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFormattedTextField.AbstractFormatter;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;

import dal.ModuloConexao;
import model.Venda;
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
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class PesquisaVendas extends JFrame {

	private JPanel contentPane;
	private JTable table;
	Connection conexao = null;
	PreparedStatement pst = null;
	ResultSet rs = null;
	ModeloTabela modelo;
	JTable tablePesquisa;
	JTable tableDetalhesVenda;
	private JTextField textField;
	private JTextField tfCodVenda;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PesquisaVendas frame = new PesquisaVendas();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);

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

		setBounds(320, 150, 720, 600);
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
		tfPesquisa.setBounds(10, 23, 140, 23);
		contentPane.add(tfPesquisa);
		tfPesquisa.setColumns(10);

		JLabel lblNomeProduto = new JLabel("Pesquisa por data:");
		lblNomeProduto.setBounds(10, 11, 127, 14);
		contentPane.add(lblNomeProduto);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 102, 684, 176);
		contentPane.add(scrollPane_1);

		tablePesquisa = new JTable();
		scrollPane_1.setViewportView(tablePesquisa);
		tablePesquisa.setToolTipText("");
		preencherTabela(
				"select * from venda inner join clientes on venda.fk_cliente = clientes.codigo_cliente where venda.valor_venda !=0");

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

		JLabel lblPesquisa = new JLabel("Vendas Realizadas::");
		lblPesquisa.setBounds(10, 79, 127, 24);
		contentPane.add(lblPesquisa);

		JButton btnPesquisarProduto = new JButton("Pesquisar");
		btnPesquisarProduto.setToolTipText("Adicionar um novo produto");
		btnPesquisarProduto.setBackground(SystemColor.controlShadow);
		btnPesquisarProduto.setBounds(160, 11, 127, 35);
		contentPane.add(btnPesquisarProduto);

		JButton btnRelatrio = new JButton("Relat\u00F3rio");
		btnRelatrio.setToolTipText("Gerar relat\u00F3rio da venda");
		btnRelatrio.setBackground(SystemColor.controlShadow);
		btnRelatrio.setBounds(10, 517, 127, 35);
		contentPane.add(btnRelatrio);

		JComboBox cbSituacao = new JComboBox();
		cbSituacao.setModel(new DefaultComboBoxModel(new String[] { "Aguardando Pagamento", "Pagamento Realizado" }));
		cbSituacao.setBounds(358, 26, 196, 20);
		contentPane.add(cbSituacao);

		JLabel lblSituao = new JLabel("Situa\u00E7\u00E3o:");
		lblSituao.setBounds(358, 11, 103, 14);
		contentPane.add(lblSituao);

		JButton btnEditar = new JButton("Atualizar");
		btnEditar.setToolTipText("Gerar relat\u00F3rio da venda");
		btnEditar.setBackground(SystemColor.controlShadow);
		btnEditar.setBounds(567, 11, 127, 35);
		contentPane.add(btnEditar);

		textField = new JTextField();
		textField.setBounds(284, -401, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);

		tfCodVenda = new JTextField();
		tfCodVenda.setEditable(false);
		tfCodVenda.setEnabled(false);
		tfCodVenda.setBounds(302, 25, 44, 20);
		contentPane.add(tfCodVenda);
		tfCodVenda.setColumns(10);

		JLabel lblCdigoDaVenda = new JLabel("C\u00F3digo:");
		lblCdigoDaVenda.setBounds(304, 11, 44, 14);
		contentPane.add(lblCdigoDaVenda);

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
				tfCodVenda.setText(tablePesquisa.getValueAt(tablePesquisa.getSelectedRow(), 0).toString());
				preencherTabelaDetalhes(
						"select * from venda inner join itens_venda_produto on venda.codigo_venda = itens_venda_produto.codigo_venda inner join produto on itens_venda_produto.codigo_produto = produto.codigo where venda.codigo_venda = "
								+ cod);

			}

		});

		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Venda v = new Venda();
				Connection conexao = ModuloConexao.conector();
				PreparedStatement pst = null;

				String sql = "UPDATE venda SET situacao=? WHERE codigo_venda=?";
				try {
					pst = conexao.prepareStatement(sql);

					pst.setString(1, cbSituacao.getSelectedItem().toString());
					pst.setShort(2, Short.parseShort(tfCodVenda.getText()));

					pst.executeUpdate();

					JOptionPane.showMessageDialog(null, "Situação da venda modificada!");
				} catch (SQLException e) {
					JOptionPane.showMessageDialog(null, "Erro ao modificar situação da venda\nERRO: " + e);
				} finally {
					ModuloConexao.closeConnection(conexao, pst);
				}
				preencherTabela(
						"select * from venda inner join clientes on venda.fk_cliente = clientes.codigo_cliente where venda.valor_venda !=0");
			}
		});
	}

	private void preencherTabela(String sql) {
		Connection conexao = ModuloConexao.conector();
		PreparedStatement pst = null;
		ResultSet rs = null;

		ArrayList<Object[]> dados = new ArrayList();
		// ArrayList dados = new ArrayList();
		String[] colunas = new String[] { "Código venda", "Data venda", "Valor venda", "Cliente", "Situação" };

		try {
			pst = conexao.prepareStatement(sql);
			rs = pst.executeQuery();
			rs.first();
			// enquanto o meu result set encontrar dados na tabela
			do {

				dados.add(new Object[] { rs.getShort("codigo_venda"), rs.getString("data_venda"),
						rs.getDouble("valor_venda"), rs.getString("nome_cliente"), rs.getString("situacao") });

			} while (rs.next());
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Erro ao preencher a tabela de vendas:" + e);
		}

		modelo = new ModeloTabela(dados, colunas);
		tablePesquisa.setModel(modelo);
		tablePesquisa.getColumnModel().getColumn(0).setPreferredWidth(100);
		tablePesquisa.getColumnModel().getColumn(0).setResizable(false);
		tablePesquisa.getColumnModel().getColumn(1).setPreferredWidth(100);
		tablePesquisa.getColumnModel().getColumn(1).setResizable(false);
		tablePesquisa.getColumnModel().getColumn(2).setPreferredWidth(100);
		tablePesquisa.getColumnModel().getColumn(2).setResizable(false);
		tablePesquisa.getColumnModel().getColumn(3).setPreferredWidth(180);
		tablePesquisa.getColumnModel().getColumn(3).setResizable(false);
		tablePesquisa.getColumnModel().getColumn(4).setPreferredWidth(200);
		tablePesquisa.getColumnModel().getColumn(4).setResizable(false);
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
