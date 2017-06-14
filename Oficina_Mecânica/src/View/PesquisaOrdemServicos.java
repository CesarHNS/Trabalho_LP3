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

public class PesquisaOrdemServicos extends JFrame {

	private JPanel contentPane;
	private JTable table;
	Connection conexao = null;
	PreparedStatement pst = null;
	ResultSet rs = null;
	ModeloTabela modelo;
	JTable tablePesquisa;
	JTable tableDetalhesOS;
	private JTextField textField;
	private JTextField tfCodOS;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PesquisaOrdemServicos frame = new PesquisaOrdemServicos();
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
	public PesquisaOrdemServicos() {
		setTitle("Pesquisa de Ordem de Serviços");
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
		JFormattedTextField tfPesquisaData = new JFormattedTextField(fmtData);
		tfPesquisaData.setBounds(10, 23, 140, 23);
		contentPane.add(tfPesquisaData);
		tfPesquisaData.setColumns(10);

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
				"select * from ordem_servico inner join clientes on ordem_servico.cliente = clientes.codigo_cliente where ordem_servico.valor !=0");

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 313, 684, 193);
		contentPane.add(scrollPane);

		tableDetalhesOS = new JTable();
		scrollPane.setViewportView(tableDetalhesOS);
		tableDetalhesOS.setToolTipText("");

		JLabel lblTabelaDeOS = new JLabel("Detalhes da Ordem de Servi\u00E7o:");
		lblTabelaDeOS.setBounds(10, 289, 206, 24);
		contentPane.add(lblTabelaDeOS);
		Calendar c = Calendar.getInstance();
		java.util.Date data = c.getTime();
		// data no formato dd/mm/aaaa
		DateFormat f = DateFormat.getDateInstance(DateFormat.MEDIUM);

		JLabel lblPesquisa = new JLabel("Ordens de Servi\u00E7o Realizadas:");
		lblPesquisa.setBounds(10, 79, 177, 24);
		contentPane.add(lblPesquisa);

		JButton btnPesquisarOS = new JButton("Pesquisar");
		btnPesquisarOS.setToolTipText("Adicionar um novo produto");
		btnPesquisarOS.setBackground(SystemColor.controlShadow);
		btnPesquisarOS.setBounds(160, 11, 127, 35);
		contentPane.add(btnPesquisarOS);

		JButton btnRelatrioOS = new JButton("Relat\u00F3rio");
		btnRelatrioOS.setToolTipText("Gerar relat\u00F3rio da venda");
		btnRelatrioOS.setBackground(SystemColor.controlShadow);
		btnRelatrioOS.setBounds(10, 517, 127, 35);
		contentPane.add(btnRelatrioOS);

		JComboBox cbSituacao = new JComboBox();
		cbSituacao.setModel(
				new DefaultComboBoxModel(new String[] { "Aguardando Pagamento", "Finalizada", "Em processo" }));
		cbSituacao.setBounds(358, 26, 196, 20);
		contentPane.add(cbSituacao);

		JLabel lblSituao = new JLabel("Situa\u00E7\u00E3o:");
		lblSituao.setBounds(358, 11, 103, 14);
		contentPane.add(lblSituao);

		JButton btnAtualSituacao = new JButton("Atualizar");
		btnAtualSituacao.setToolTipText("Gerar relat\u00F3rio da venda");
		btnAtualSituacao.setBackground(SystemColor.controlShadow);
		btnAtualSituacao.setBounds(567, 11, 127, 35);
		contentPane.add(btnAtualSituacao);

		textField = new JTextField();
		textField.setBounds(284, -401, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);

		tfCodOS = new JTextField();
		tfCodOS.setEditable(false);
		tfCodOS.setEnabled(false);
		tfCodOS.setBounds(302, 25, 44, 20);
		contentPane.add(tfCodOS);
		tfCodOS.setColumns(10);

		JLabel lblCdigoDaVenda = new JLabel("C\u00F3digo:");
		lblCdigoDaVenda.setBounds(304, 11, 44, 14);
		contentPane.add(lblCdigoDaVenda);

		/***********************************************************************
		 * 
		 **********************************************************************/
		btnPesquisarOS.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				preencherTabela(
						"select * from venda inner join clientes on venda.fk_cliente = clientes.codigo_cliente where data_venda ='"
								+ tfPesquisaData.getText() + "'");

			}
		});

		tablePesquisa.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				short cod = (short) tablePesquisa.getValueAt(tablePesquisa.getSelectedRow(), 0);
				tfCodOS.setText(tablePesquisa.getValueAt(tablePesquisa.getSelectedRow(), 0).toString());
				preencherTabelaDetalhes(
						" select * from ordem_servico inner join itens_os_servico on ordem_servico.codigo_os = itens_os_servico.codigo_os inner join serv on itens_os_servico.codigo_serv = serv.codigo_serv where ordem_servico.codigo_os="
								+ cod);

			}

		});

		btnAtualSituacao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Venda v = new Venda();
				Connection conexao = ModuloConexao.conector();
				PreparedStatement pst = null;

				String sql = "UPDATE ordem_servico SET situacao=? WHERE codigo_os=?";
				try {
					pst = conexao.prepareStatement(sql);

					pst.setString(1, cbSituacao.getSelectedItem().toString());
					pst.setShort(2, Short.parseShort(tfCodOS.getText()));

					pst.executeUpdate();

					JOptionPane.showMessageDialog(null, "Situação da ordem de serviço modificada!");
				} catch (SQLException e) {
					JOptionPane.showMessageDialog(null, "Erro ao modificar situação da ordem de serviço\nERRO: " + e);
				} finally {
					ModuloConexao.closeConnection(conexao, pst);
				}
				preencherTabela(
						"select * from ordem_servico inner join clientes on ordem_servico.cliente = clientes.codigo_cliente where ordem_servico.valor !=0");
			}
		});
	}

	private void preencherTabela(String sql) {
		Connection conexao = ModuloConexao.conector();
		PreparedStatement pst = null;
		ResultSet rs = null;

		ArrayList<Object[]> dados = new ArrayList();
		// ArrayList dados = new ArrayList();
		String[] colunas = new String[] { "Código OS", "Data OS", "Valor OS", "Cliente", "Situação" };

		try {
			pst = conexao.prepareStatement(sql);
			rs = pst.executeQuery();
			rs.first();
			// enquanto o meu result set encontrar dados na tabela
			do {

				dados.add(new Object[] { rs.getShort("codigo_os"), rs.getString("data_os"), rs.getDouble("valor"),
						rs.getString("nome_cliente"), rs.getString("situacao") });

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
		String[] colunas = new String[] { "Código", "Nome" };

		try {
			pst = conexao.prepareStatement(sql);
			rs = pst.executeQuery();
			rs.first();
			// enquanto o meu result set encontrar dados na tabela
			do {

				dados.add(new Object[] { rs.getString("codigo_serv"), rs.getString("nome_serv") });

			} while (rs.next());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		modelo = new ModeloTabela(dados, colunas);
		tableDetalhesOS.setModel(modelo);
		tableDetalhesOS.getColumnModel().getColumn(0).setPreferredWidth(80);
		tableDetalhesOS.getColumnModel().getColumn(0).setResizable(false);
		tableDetalhesOS.getColumnModel().getColumn(1).setPreferredWidth(380);
		tableDetalhesOS.getColumnModel().getColumn(1).setResizable(false);
		tableDetalhesOS.getTableHeader().setReorderingAllowed(false);
		tableDetalhesOS.setAutoResizeMode(tableDetalhesOS.AUTO_RESIZE_OFF);
		tableDetalhesOS.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		/* Atualiza a tabela */
		modelo.fireTableDataChanged();

	}
}
