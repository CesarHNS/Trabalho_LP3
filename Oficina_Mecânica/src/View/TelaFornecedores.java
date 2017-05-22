package view;

import java.awt.EventQueue;
import java.awt.SystemColor;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import dal.ModuloConexao;
import model.Fornecedor;
import model.dao.ClienteDAO;
import model.dao.FornecedorDAO;
import model.tables.FornecedorTableModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class TelaFornecedores extends JFrame {

	private JPanel contentPane;
	private JTextField tfNomeFornecedor;
	private JTextField tfTelefoneFornecedor;
	private JTextField tfDigitePesquisa;
	private JTable jtFornecedor;
	private JTextField tfEmailFornecedor;
	private JTextField tfCodigoFornecedor;
	private JTextField tfCelularFornecedor;
	private JTextField tfCNPJ;
	private JTextField tfEnderecoFornecedor;
	private JTextField tfBairroFornecedor;
	private JTextField tfCidadeFornecedor;
	private JTextField tfCepFornecedor;
	private JComboBox cbEstadoFornecedor;
	FornecedorTableModel modelo;
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
					TelaFornecedores frame = new TelaFornecedores();
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
	public TelaFornecedores() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosed(WindowEvent arg0) {
				TelaFornecedores frame = new TelaFornecedores();
				frame.setVisible(false);
			}
		});
		setTitle("Tela de cadastro de fornecedores");
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

		tfNomeFornecedor = new JTextField();
		tfNomeFornecedor.setBounds(66, 33, 296, 23);
		contentPane.add(tfNomeFornecedor);
		tfNomeFornecedor.setColumns(10);

		tfTelefoneFornecedor = new JTextField();
		tfTelefoneFornecedor.setBounds(440, 72, 114, 23);
		tfTelefoneFornecedor.setColumns(10);
		contentPane.add(tfTelefoneFornecedor);

		JLabel lblNomeFornecedor = new JLabel("Nome do Fornecedor:");
		lblNomeFornecedor.setBounds(66, 17, 127, 14);
		contentPane.add(lblNomeFornecedor);

		JLabel lblTelefoneFornecedor = new JLabel("Telefone:");
		lblTelefoneFornecedor.setBounds(440, 56, 74, 14);
		contentPane.add(lblTelefoneFornecedor);

		JComboBox<?> cbFiltros = new JComboBox<Object>();
		cbFiltros.setToolTipText("Escolha o filtro de sua pesquisa");
		cbFiltros.setBounds(475, 119, 190, 23);
		contentPane.add(cbFiltros);

		JLabel lblFiltrarPor = new JLabel("Filtra por:");
		lblFiltrarPor.setBounds(475, 104, 114, 14);
		contentPane.add(lblFiltrarPor);

		tfDigitePesquisa = new JTextField();
		tfDigitePesquisa.setBounds(675, 119, 238, 23);
		tfDigitePesquisa.setColumns(10);
		contentPane.add(tfDigitePesquisa);

		JLabel lblPesquisar = new JLabel("Digite sua pesquisa aqui:");
		lblPesquisar.setBounds(675, 104, 151, 14);
		contentPane.add(lblPesquisar);

		JButton btnPesquisarFornecedor = new JButton("Pesquisar");
		btnPesquisarFornecedor.setBackground(SystemColor.controlShadow);
		btnPesquisarFornecedor.setBounds(923, 121, 106, 23);
		contentPane.add(btnPesquisarFornecedor);

		JScrollPane scrollPane = new JScrollPane();

		scrollPane.setBounds(10, 153, 1019, 457);
		contentPane.add(scrollPane);

		jtFornecedor = new JTable();

		scrollPane.setViewportView(jtFornecedor);
		jtFornecedor.setToolTipText("");
		modelo = new FornecedorTableModel();
		jtFornecedor.setModel(modelo);
		atualizar();

		JButton btnAdicionarFornecedor = new JButton("Adicionar");

		btnAdicionarFornecedor.setBackground(SystemColor.controlShadow);
		btnAdicionarFornecedor.setToolTipText("Adicionar um novo fornecedor");
		btnAdicionarFornecedor.setBounds(10, 107, 127, 35);
		contentPane.add(btnAdicionarFornecedor);

		JButton btnRemoverFornecedor = new JButton("Remover");

		btnRemoverFornecedor.setBackground(SystemColor.controlShadow);
		btnRemoverFornecedor.setToolTipText("Remover um fornecedor");
		btnRemoverFornecedor.setBounds(158, 107, 127, 35);
		contentPane.add(btnRemoverFornecedor);

		JButton btnModificarFornecedor = new JButton("Modificar");

		btnModificarFornecedor.setBackground(SystemColor.controlShadow);
		btnModificarFornecedor.setToolTipText("Modificar um fornecedor");
		btnModificarFornecedor.setBounds(303, 107, 127, 35);
		contentPane.add(btnModificarFornecedor);

		tfEmailFornecedor = new JTextField();
		tfEmailFornecedor.setColumns(10);
		tfEmailFornecedor.setBounds(134, 72, 296, 23);
		contentPane.add(tfEmailFornecedor);

		JLabel lblEmailFornecedor = new JLabel("Email:");
		lblEmailFornecedor.setBounds(134, 56, 127, 14);
		contentPane.add(lblEmailFornecedor);

		tfCodigoFornecedor = new JTextField();
		tfCodigoFornecedor.setColumns(10);
		tfCodigoFornecedor.setBounds(10, 33, 46, 23);
		contentPane.add(tfCodigoFornecedor);

		JLabel lblCodigoFornecedor = new JLabel("C\u00F3digo:");
		lblCodigoFornecedor.setBounds(10, 17, 57, 14);
		contentPane.add(lblCodigoFornecedor);

		tfCelularFornecedor = new JTextField();
		tfCelularFornecedor.setColumns(10);
		tfCelularFornecedor.setBounds(564, 73, 114, 23);
		contentPane.add(tfCelularFornecedor);

		JLabel lblCelularFornecedor = new JLabel("Celular:");
		lblCelularFornecedor.setBounds(564, 56, 74, 14);
		contentPane.add(lblCelularFornecedor);

		tfCNPJ = new JTextField();
		tfCNPJ.setColumns(10);
		tfCNPJ.setBounds(10, 72, 114, 23);
		contentPane.add(tfCNPJ);

		JLabel lblCNPJ = new JLabel("CNPJ:");
		lblCNPJ.setBounds(10, 56, 74, 14);
		contentPane.add(lblCNPJ);

		tfEnderecoFornecedor = new JTextField();
		tfEnderecoFornecedor.setToolTipText("Ex: Rua: 9 de julho, 1039");
		tfEnderecoFornecedor.setColumns(10);
		tfEnderecoFornecedor.setBounds(368, 33, 225, 23);
		contentPane.add(tfEnderecoFornecedor);

		JLabel lblEndereco = new JLabel("Endere\u00E7o:");
		lblEndereco.setBounds(368, 17, 127, 14);
		contentPane.add(lblEndereco);

		tfBairroFornecedor = new JTextField();
		tfBairroFornecedor.setColumns(10);
		tfBairroFornecedor.setBounds(599, 33, 114, 23);
		contentPane.add(tfBairroFornecedor);

		JLabel lblBairro = new JLabel("Bairro:");
		lblBairro.setBounds(599, 17, 74, 14);
		contentPane.add(lblBairro);

		tfCidadeFornecedor = new JTextField();
		tfCidadeFornecedor.setColumns(10);
		tfCidadeFornecedor.setBounds(719, 33, 114, 23);
		contentPane.add(tfCidadeFornecedor);

		JLabel lblCidade = new JLabel("Cidade:");
		lblCidade.setBounds(719, 17, 74, 14);
		contentPane.add(lblCidade);

		tfCepFornecedor = new JTextField();
		tfCepFornecedor.setColumns(10);
		tfCepFornecedor.setBounds(839, 33, 114, 23);
		contentPane.add(tfCepFornecedor);

		JLabel lblCepFornecedor = new JLabel("CEP:");
		lblCepFornecedor.setBounds(839, 17, 74, 14);
		contentPane.add(lblCepFornecedor);

		cbEstadoFornecedor = new JComboBox();
		cbEstadoFornecedor.setModel(new DefaultComboBoxModel(
				new String[] { "AC \t ", "AL \t ", "AP \t ", "AM \t ", "BA \t ", "CE \t ", "DF \t ", "ES \t ", "GO \t ",
						"MA \t ", "MT \t ", "MS \t ", "MG \t ", "PA \t ", "PB \t ", "PR \t ", "PE \t ", "PI \t ",
						"RJ \t ", "RN \t ", "RS \t ", "RO \t ", "RR \t ", "SC \t ", "SP \t ", "SE \t ", "TO" }));
		cbEstadoFornecedor.setBounds(963, 32, 66, 23);
		contentPane.add(cbEstadoFornecedor);

		JLabel lblEstadoFornecedor = new JLabel("Estado:");
		lblEstadoFornecedor.setBounds(963, 17, 74, 14);
		contentPane.add(lblEstadoFornecedor);

		btnAdicionarFornecedor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Fornecedor f = new Fornecedor();
				FornecedorDAO dao = new FornecedorDAO();

				f.setId(Short.parseShort(tfCodigoFornecedor.getText()));
				f.setNome(tfNomeFornecedor.getText());
				f.setTelefone(tfTelefoneFornecedor.getText());
				f.setEmail(tfEmailFornecedor.getText());
				f.setCelular(tfCelularFornecedor.getText());
				f.setCnpj(tfCNPJ.getText());
				f.setEndereco(tfEnderecoFornecedor.getText());
				f.setBairro(tfBairroFornecedor.getText());
				f.setCep(tfCepFornecedor.getText());
				f.setCidade(tfCidadeFornecedor.getText());
				f.setEstado(cbEstadoFornecedor.getSelectedItem().toString());

				// salvando o fornecedor na classe dao
				dao.create(f);
				LimparTela();
				atualizar();
			}
		});

		btnRemoverFornecedor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FornecedorDAO dao = new FornecedorDAO();

				short id = Short.parseShort(tfCodigoFornecedor.getText());

				dao.delete(id);
				LimparTela();
				atualizar();
			}
		});

		btnModificarFornecedor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Fornecedor f = new Fornecedor();
				FornecedorDAO dao = new FornecedorDAO();

				f.setId(Short.parseShort(tfCodigoFornecedor.getText()));
				f.setNome(tfNomeFornecedor.getText());
				f.setTelefone(tfTelefoneFornecedor.getText());
				f.setEmail(tfEmailFornecedor.getText());
				f.setCelular(tfCelularFornecedor.getText());
				f.setCnpj(tfCNPJ.getText());
				f.setEndereco(tfEnderecoFornecedor.getText());
				f.setBairro(tfBairroFornecedor.getText());
				f.setCep(tfCepFornecedor.getText());
				f.setCidade(tfCidadeFornecedor.getText());
				f.setEstado(cbEstadoFornecedor.getSelectedItem().toString());

				// modificando o fornecedor na classe dao
				dao.alterar(f);
				LimparTela();
				atualizar();
			}
		});

		jtFornecedor.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				PreencheTextField();
			}
		});

	}

	/**********************************************************************
	 * Método para fazer consultas no banco de dados
	 *********************************************************************/
	public void atualizar() {
		try {
			/* Criação do modelo */
			Fornecedor f = new Fornecedor();
			// d.setNome(tfPesquisaCliente.getText());

			/* Criação do DAO */
			FornecedorDAO fdao = new FornecedorDAO();
			List<Fornecedor> lista = fdao.read(f);

			/* Captura o modelo da tabela */
			FornecedorTableModel modelo = (FornecedorTableModel) jtFornecedor.getModel();

			/* Copia os dados da consulta para a tabela */
			modelo.adicionar(lista);

		} catch (Exception ex) {
			ex.printStackTrace();
			JOptionPane.showMessageDialog(null, "Erro ao tentar buscar um fornecedor");
		}
	}

	/***********************************************************************
	 * Método para preencher os TextFields após selecionar uma linha
	 **********************************************************************/
	private void PreencheTextField() {

		LimparTela();

		if (jtFornecedor.getSelectedRow() != -1) {
			tfCodigoFornecedor.setText(jtFornecedor.getValueAt(jtFornecedor.getSelectedRow(), 0).toString());
			tfNomeFornecedor.setText(jtFornecedor.getValueAt(jtFornecedor.getSelectedRow(), 1).toString());
			tfTelefoneFornecedor.setText(jtFornecedor.getValueAt(jtFornecedor.getSelectedRow(), 2).toString());
			tfEmailFornecedor.setText(jtFornecedor.getValueAt(jtFornecedor.getSelectedRow(), 3).toString());
			tfCelularFornecedor.setText(jtFornecedor.getValueAt(jtFornecedor.getSelectedRow(), 4).toString());
			tfCNPJ.setText(jtFornecedor.getValueAt(jtFornecedor.getSelectedRow(), 5).toString());
			tfEnderecoFornecedor.setText(jtFornecedor.getValueAt(jtFornecedor.getSelectedRow(), 6).toString());
			tfBairroFornecedor.setText(jtFornecedor.getValueAt(jtFornecedor.getSelectedRow(), 7).toString());
			tfCepFornecedor.setText((jtFornecedor.getValueAt(jtFornecedor.getSelectedRow(), 8).toString()));
			tfCidadeFornecedor.setText(jtFornecedor.getValueAt(jtFornecedor.getSelectedRow(), 9).toString());
			cbEstadoFornecedor.setSelectedItem(jtFornecedor.getValueAt(jtFornecedor.getSelectedRow(), 10).toString());

		} else {
			JOptionPane.showMessageDialog(null, "Selecione um fornecedor");
		}
	}

	/***********************************************************************
	 * Método para limpar os TextFields após o cadastramento dos fornecedores
	 **********************************************************************/
	private void LimparTela() {
		tfCodigoFornecedor.setText("");
		tfNomeFornecedor.setText("");
		tfTelefoneFornecedor.setText("");
		tfEmailFornecedor.setText("");
		tfCelularFornecedor.setText("");
		tfCNPJ.setText("");
		tfEnderecoFornecedor.setText("");
		tfBairroFornecedor.setText("");
		tfCepFornecedor.setText("");
		tfCidadeFornecedor.setText("");
		cbEstadoFornecedor.setSelectedIndex(0);

	}

	private static class __Tmp {
		private static void __tmp() {
			javax.swing.JPanel __wbp_panel = new javax.swing.JPanel();
		}
	}
}
