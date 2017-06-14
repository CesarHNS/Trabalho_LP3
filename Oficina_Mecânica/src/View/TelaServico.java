package view;

import java.awt.EventQueue;
import java.awt.SystemColor;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;

import control.ProdutoControl;
import control.ServicoControl;
import control.VendaControl;
import dal.ModuloConexao;
import model.Produtos;
import model.Servico;
import model.Venda;
import model.tables.ModeloTabela;
import model.tables.ProdutoTableModel;
import model.tables.ServicoTableModel;
import model.tables.VendaTableModel;

import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaServico extends JFrame {

	private JPanel contentPane;
	private JTable tableServico;
	private JTextField tfNomeServico;
	private JTextField tfPesquisaServico;
	private JTextField tfCodigoServico;
	private JTextField tfPrecoServico;
	ServicoTableModel modelo;
	ModeloTabela modeloTab;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaServico frame = new TelaServico();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public TelaServico() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosed(WindowEvent arg0) {
				TelaServico frame = new TelaServico();
				frame.setVisible(false);
			}
		});
		setTitle("Tela de cadastro de servi\u00E7os");
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);// fecha apenas a
															// janela onde estou
															// quando clico no X
		setBounds(320, 150, 1045, 650);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.scrollbar);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		tfNomeServico = new JTextField();
		tfNomeServico.setBounds(64, 33, 286, 23);
		contentPane.add(tfNomeServico);
		tfNomeServico.setColumns(10);

		JLabel lblNomeServico = new JLabel("Nome do Servi\u00E7o:");
		lblNomeServico.setBounds(64, 17, 127, 14);
		contentPane.add(lblNomeServico);

		tfPesquisaServico = new JTextField();
		tfPesquisaServico.setBounds(675, 119, 238, 23);
		tfPesquisaServico.setColumns(10);
		contentPane.add(tfPesquisaServico);

		JLabel lblDigitePesquisaServico = new JLabel("Digite sua pesquisa aqui:");
		lblDigitePesquisaServico.setBounds(675, 104, 151, 14);
		contentPane.add(lblDigitePesquisaServico);

		JButton btnPesquisarServico = new JButton("Pesquisar");
		btnPesquisarServico.setBackground(SystemColor.controlShadow);
		btnPesquisarServico.setBounds(923, 121, 106, 23);
		contentPane.add(btnPesquisarServico);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 153, 1019, 457);
		contentPane.add(scrollPane);

		JButton btnAdicionarServico = new JButton("Adicionar");
		btnAdicionarServico.setBackground(SystemColor.controlShadow);
		btnAdicionarServico.setToolTipText("Adicionar um novo produto");
		btnAdicionarServico.setBounds(10, 107, 127, 35);
		contentPane.add(btnAdicionarServico);

		JButton btnRemoverServico = new JButton("Remover");
		btnRemoverServico.setBackground(SystemColor.controlShadow);
		btnRemoverServico.setToolTipText("Remover um produto");
		btnRemoverServico.setBounds(158, 107, 127, 35);
		contentPane.add(btnRemoverServico);

		JButton btnModificarServico = new JButton("Modificar");
		btnModificarServico.setBackground(SystemColor.controlShadow);
		btnModificarServico.setToolTipText("Modificar um produto");
		btnModificarServico.setBounds(303, 107, 127, 35);
		contentPane.add(btnModificarServico);

		JLabel lblCodigoServico = new JLabel("C\u00F3digo:");
		lblCodigoServico.setBounds(10, 17, 57, 14);
		contentPane.add(lblCodigoServico);

		tfCodigoServico = new JTextField();
		tfCodigoServico.setBounds(10, 33, 49, 23);
		contentPane.add(tfCodigoServico);
		tfCodigoServico.setColumns(10);

		tfPrecoServico = new JTextField();
		tfPrecoServico.setColumns(10);
		tfPrecoServico.setBounds(360, 33, 38, 23);
		contentPane.add(tfPrecoServico);

		JLabel lblPrecoServico = new JLabel("Pre\u00E7o:");
		lblPrecoServico.setBounds(360, 17, 57, 14);
		contentPane.add(lblPrecoServico);

		tableServico = new JTable();
		scrollPane.setViewportView(tableServico);
		tableServico.setToolTipText("");
		modelo = new ServicoTableModel();
		tableServico.setModel(modelo);
		// atualizarTabela();
		preencherTabela();

		btnPesquisarServico.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//atualizarTabelaPorBusca(tableServico);
				preencherTabelaPorBusca();
			}
		});

		btnAdicionarServico.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// ServicoTableModel modelo = (ServicoTableModel)
				// tableServico.getModel();
				Servico s = new Servico();
				try {
					s.setCodigo(Short.parseShort(tfCodigoServico.getText()));
					s.setDescricao(tfNomeServico.getText());
					s.setPreco(Double.parseDouble(tfPrecoServico.getText()));

				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, "Preencha os campos corretamente: " + e);
				}

				LimparTela();
				preencherTabela();

			}
		});

	}

	private void LimparTela() {
		tfCodigoServico.setText("");
		tfNomeServico.setText("");
		tfPrecoServico.setText("");

	}

	

	private static class __Tmp {
		private static void __tmp() {
			javax.swing.JPanel __wbp_panel = new javax.swing.JPanel();
		}
	}

	private void preencherTabela() {
		Connection conexao = ModuloConexao.conector();
		PreparedStatement pst = null;
		ResultSet rs = null;

		ArrayList<Object[]> dados = new ArrayList();
		// ArrayList dados = new ArrayList();
		String[] colunas = new String[] { "Código", "Nome", "Valor" };

		try {
			pst = conexao.prepareStatement("select * from serv");
			rs = pst.executeQuery();
			rs.first();
			// enquanto o meu result set encontrar dados na tabela
			do {

				dados.add(new Object[] { rs.getShort("codigo_serv"), rs.getString("nome_serv"),
						rs.getDouble("preco_serv") });

			} while (rs.next());
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Erro ao preencher a tabela de serviços:" + e);
		}

		modeloTab = new ModeloTabela(dados, colunas);
		tableServico.setModel(modeloTab);
		tableServico.getColumnModel().getColumn(0).setPreferredWidth(80);
		tableServico.getColumnModel().getColumn(0).setResizable(false);
		tableServico.getColumnModel().getColumn(1).setPreferredWidth(400);
		tableServico.getColumnModel().getColumn(1).setResizable(false);
		tableServico.getColumnModel().getColumn(2).setPreferredWidth(80);
		tableServico.getColumnModel().getColumn(2).setResizable(false);
		tableServico.getTableHeader().setReorderingAllowed(false);
		tableServico.setAutoResizeMode(tableServico.AUTO_RESIZE_OFF);
		tableServico.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		/* Atualiza a tabela */
		modelo.fireTableDataChanged();

	}

	private void preencherTabelaPorBusca() {
		Connection conexao = ModuloConexao.conector();
		PreparedStatement pst = null;
		ResultSet rs = null;

		ArrayList<Object[]> dados = new ArrayList();
		// ArrayList dados = new ArrayList();
		String[] colunas = new String[] { "Código", "Nome", "Valor" };

		short codServ = new ServicoControl().buscaCodServico();

		try {
			pst = conexao.prepareStatement("select * from serv where nome_serv like '%" + tfPesquisaServico.getText() + "%'" );
			rs = pst.executeQuery();
			rs.first();
			// enquanto o meu result set encontrar dados na tabela
			do {

				dados.add(new Object[] { rs.getShort("codigo_serv"), rs.getString("nome_serv"),
						rs.getDouble("preco_serv") });

			} while (rs.next());
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Erro ao preencher a tabela de serviços:" + e);
		}

		modeloTab = new ModeloTabela(dados, colunas);
		tableServico.setModel(modeloTab);
		tableServico.getColumnModel().getColumn(0).setPreferredWidth(80);
		tableServico.getColumnModel().getColumn(0).setResizable(false);
		tableServico.getColumnModel().getColumn(1).setPreferredWidth(400);
		tableServico.getColumnModel().getColumn(1).setResizable(false);
		tableServico.getColumnModel().getColumn(2).setPreferredWidth(80);
		tableServico.getColumnModel().getColumn(2).setResizable(false);
		tableServico.getTableHeader().setReorderingAllowed(false);
		tableServico.setAutoResizeMode(tableServico.AUTO_RESIZE_OFF);
		tableServico.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		/* Atualiza a tabela */
		modelo.fireTableDataChanged();

	}

}
