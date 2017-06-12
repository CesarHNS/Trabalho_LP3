package view;

import java.awt.EventQueue;
import java.awt.SystemColor;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;

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

import control.ClienteControl;
import control.VeiculoControl;
import control.VendaControl;
import dal.ModuloConexao;
import model.Cliente;
import model.Veiculo;
import model.tables.ClienteTableModel;
import model.tables.ModeloTabela;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;

public class TelaVeiculos extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField tfDescricaoVeiculo;
	private JTextField tfDigitePesquisaVeiculo;
	private JTextField tfMontadoraVeiculo;
	private JTextField tfPlacaVeiculo;
	private JTextField tfNomeCliente;
	ModeloTabela modelo;
	ClienteTableModel modeloCliente;
	Connection conexao = null;
	PreparedStatement pst = null;
	ResultSet rs = null;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaVeiculos frame = new TelaVeiculos();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public TelaVeiculos() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosed(WindowEvent arg0) {
				TelaVeiculos frame = new TelaVeiculos();
				frame.setVisible(false);
			}
		});
		setTitle("Tela de cadastro de ve\u00EDculos");
		setResizable(false);
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

		tfDescricaoVeiculo = new JTextField();
		tfDescricaoVeiculo.setBounds(64, 33, 286, 23);
		contentPane.add(tfDescricaoVeiculo);
		tfDescricaoVeiculo.setColumns(10);

		JLabel lblDescricaoVeiculo = new JLabel("Descri\u00E7\u00E3o do Ve\u00EDculo:");
		lblDescricaoVeiculo.setBounds(64, 17, 127, 14);
		contentPane.add(lblDescricaoVeiculo);

		tfDigitePesquisaVeiculo = new JTextField();
		tfDigitePesquisaVeiculo.setBounds(675, 119, 238, 23);
		tfDigitePesquisaVeiculo.setColumns(10);
		contentPane.add(tfDigitePesquisaVeiculo);

		JLabel lblDigitePesquisaVeiculo = new JLabel("Pesquisar ve\u00EDculos cadastrados:");
		lblDigitePesquisaVeiculo.setBounds(675, 104, 170, 14);
		contentPane.add(lblDigitePesquisaVeiculo);

		JButton btnPesquisarVeiculo = new JButton("Pesquisar");
		btnPesquisarVeiculo.setBackground(SystemColor.controlShadow);
		btnPesquisarVeiculo.setBounds(923, 121, 106, 23);
		contentPane.add(btnPesquisarVeiculo);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 153, 1019, 457);
		contentPane.add(scrollPane);

		table = new JTable();
		scrollPane.setViewportView(table);
		table.setToolTipText("");

		JButton btnAdicionarVeiculo = new JButton("Adicionar");
		btnAdicionarVeiculo.setBackground(SystemColor.controlShadow);
		btnAdicionarVeiculo.setToolTipText("Adicionar um novo ve\u00EDculo");
		btnAdicionarVeiculo.setBounds(10, 107, 127, 35);
		contentPane.add(btnAdicionarVeiculo);

		JButton btnRemoverVeiculo = new JButton("Remover");
		btnRemoverVeiculo.setBackground(SystemColor.controlShadow);
		btnRemoverVeiculo.setToolTipText("Remover um ve\u00EDculo");
		btnRemoverVeiculo.setBounds(158, 107, 127, 35);
		contentPane.add(btnRemoverVeiculo);

		JButton btnModificarVeiculo = new JButton("Modificar");
		btnModificarVeiculo.setBackground(SystemColor.controlShadow);
		btnModificarVeiculo.setToolTipText("Modificar um ve\u00EDculo");
		btnModificarVeiculo.setBounds(303, 107, 127, 35);
		contentPane.add(btnModificarVeiculo);

		tfMontadoraVeiculo = new JTextField();
		tfMontadoraVeiculo.setColumns(10);
		tfMontadoraVeiculo.setBounds(356, 33, 151, 23);
		contentPane.add(tfMontadoraVeiculo);

		JLabel lblMontadoraVeiculo = new JLabel("Montadora:");
		lblMontadoraVeiculo.setBounds(356, 17, 127, 14);
		contentPane.add(lblMontadoraVeiculo);

		tfPlacaVeiculo = new JTextField();
		tfPlacaVeiculo.setColumns(10);
		tfPlacaVeiculo.setBounds(517, 33, 86, 23);
		contentPane.add(tfPlacaVeiculo);

		JLabel lblPlacaVeiculo = new JLabel("Placa:");
		lblPlacaVeiculo.setBounds(517, 17, 57, 14);
		contentPane.add(lblPlacaVeiculo);

		tfNomeCliente = new JTextField();
		tfNomeCliente.setColumns(10);
		tfNomeCliente.setBounds(609, 33, 286, 23);
		contentPane.add(tfNomeCliente);

		JLabel lblNomeCliente = new JLabel("Nome Cliente:");
		lblNomeCliente.setBounds(609, 17, 127, 14);
		contentPane.add(lblNomeCliente);

		JButton btnPesquisaCliente = new JButton("Pesquisar");
		btnPesquisaCliente.setBackground(SystemColor.controlShadow);
		btnPesquisaCliente.setBounds(905, 33, 106, 23);
		contentPane.add(btnPesquisaCliente);

		atualizarTabela();

		btnPesquisaCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int flag = 1;
				modeloCliente = new ClienteTableModel();

				table.setModel(modeloCliente);
				try {
					new TelaClientes().atualizarTabelaPorBusca();
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});

		btnAdicionarVeiculo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// ModeloTabela modelo = (ModeloTabela) table.getModel();
				Veiculo v = new Veiculo();

				try {
					v.setDescricao(tfDescricaoVeiculo.getText());
					v.setMontadora(tfMontadoraVeiculo.getText());
					v.setPlaca(tfPlacaVeiculo.getText());
					v.setNomeCliente(tfNomeCliente.getText());

					new VeiculoControl().createVeiculo(v);
				} catch (NumberFormatException e) {
					JOptionPane.showMessageDialog(null, "Erro preencha os campos corretamente: " + e);
				}

				// LimparTela();
				atualizarTabela();

			}
		});

		btnModificarVeiculo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// ModeloTabela modelo = (ModeloTabela) table.getModel();
				Veiculo v = new Veiculo();

				try {
					v.setDescricao(tfDescricaoVeiculo.getText());
					v.setMontadora(tfMontadoraVeiculo.getText());
					v.setPlaca(tfPlacaVeiculo.getText());
					v.setNomeCliente(tfNomeCliente.getText());

					new VeiculoControl().updateVeiculo(v);
				} catch (NumberFormatException ex) {
					JOptionPane.showMessageDialog(null, "Erro preencha os campos corretamente: " + ex);
				}

				// LimparTela();
				atualizarTabela();

			}

		});

		btnRemoverVeiculo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Veiculo v = new Veiculo();

				try {
					v.setNomeCliente(tfNomeCliente.getText());

					new VeiculoControl().updateVeiculo(v);
				} catch (NumberFormatException ex) {
					JOptionPane.showMessageDialog(null, "Erro preencha os campos corretamente: " + ex);
				}
				atualizarTabela();
			}
		});
	}

	public void atualizarTabela() {
		Veiculo v = new Veiculo();

		ArrayList<Object[]> dados = new ArrayList();
		// ArrayList dados = new ArrayList();
		String[] colunas = new String[] { "Nome Veículo", "Montadora", "Placa Veículo", "Nome Cliente" };

		try {
			pst = conexao.prepareStatement(
					" select * from veiculo inner join clientes on veiculo.codigo_cliente = clientes.codigo_cliente where clientes.codigo_cliente = veiculo.codigo_cliente");

			rs = pst.executeQuery();
			rs.first();
			// enquanto o meu result set encontrar dados na tabela
			do {

				dados.add(new Object[] { rs.getString("nome_veiculo"), rs.getString("montadora"), rs.getString("placa"),
						rs.getString("nome_cliente") });

			} while (rs.next());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		modelo = new ModeloTabela(dados, colunas);
		table.setModel(modelo);
		table.getColumnModel().getColumn(0).setPreferredWidth(300);
		table.getColumnModel().getColumn(0).setResizable(false);
		table.getColumnModel().getColumn(1).setPreferredWidth(100);
		table.getColumnModel().getColumn(1).setResizable(false);
		table.getColumnModel().getColumn(2).setPreferredWidth(100);
		table.getColumnModel().getColumn(2).setResizable(false);
		table.getColumnModel().getColumn(3).setPreferredWidth(300);
		table.getColumnModel().getColumn(3).setResizable(false);

		table.getTableHeader().setReorderingAllowed(false);
		table.setAutoResizeMode(table.AUTO_RESIZE_OFF);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		/* Atualiza a tabela */
		modelo.fireTableDataChanged();
	}

	private static class __Tmp {
		private static void __tmp() {
			javax.swing.JPanel __wbp_panel = new javax.swing.JPanel();
		}
	}
}
