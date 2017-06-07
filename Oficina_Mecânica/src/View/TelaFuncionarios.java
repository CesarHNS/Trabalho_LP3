package view;

import java.awt.EventQueue;
import java.awt.SystemColor;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
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
import javax.swing.table.TableModel;

import control.ClienteControl;
import control.FuncionarioControl;
import model.Cliente;
import model.Funcionario;
import model.tables.ClienteTableModel;
import model.tables.FuncionarioTableModel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class TelaFuncionarios extends JFrame {

	private JPanel contentPane;
	private JTextField tfNomeFuncionario;
	private JTextField tfTelefone;
	private JTextField tfPesquisa;
	private JTable table;
	private JTextField tfEmail;
	private JTextField tfCodigoFuncionario;
	private JTextField tfCelular;
	private JTextField tfCPF;
	private JTextField tfLogin;
	private JTextField tfCargo;
	private JTextField tfEndereco;
	private JTextField tfBairro;
	private JTextField tfCidade;
	private JTextField tfCep;
	private JTextField tfSenha;
	JComboBox comboBox_1;
	FuncionarioTableModel modelo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaFuncionarios frame = new TelaFuncionarios();
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
	public TelaFuncionarios() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosed(WindowEvent arg0) {
				TelaFuncionarios frame = new TelaFuncionarios();
				frame.setVisible(false);
			}
		});
		setTitle("Tela de cadastro de funcion\u00E1rios");
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

		tfNomeFuncionario = new JTextField();
		tfNomeFuncionario.setBounds(66, 33, 296, 23);
		contentPane.add(tfNomeFuncionario);
		tfNomeFuncionario.setColumns(10);

		tfTelefone = new JTextField();
		tfTelefone.setBounds(791, 72, 114, 23);
		tfTelefone.setColumns(10);
		contentPane.add(tfTelefone);

		JLabel lblNewLabel = new JLabel("Nome do Funcion\u00E1rio:");
		lblNewLabel.setBounds(66, 17, 127, 14);
		contentPane.add(lblNewLabel);

		JLabel lblTelefone = new JLabel("Telefone:");
		lblTelefone.setBounds(791, 56, 74, 14);
		contentPane.add(lblTelefone);

		tfPesquisa = new JTextField();
		tfPesquisa.setBounds(675, 119, 238, 23);
		tfPesquisa.setColumns(10);
		contentPane.add(tfPesquisa);

		JLabel lblFiltros = new JLabel("Digite sua pesquisa aqui:");
		lblFiltros.setBounds(675, 104, 151, 14);
		contentPane.add(lblFiltros);

		JButton btnNewButton = new JButton("Pesquisar");
		btnNewButton.setBackground(SystemColor.controlShadow);
		btnNewButton.setBounds(923, 121, 106, 23);
		contentPane.add(btnNewButton);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 153, 1019, 457);
		contentPane.add(scrollPane);

		table = new JTable();
		scrollPane.setViewportView(table);
		modelo = new FuncionarioTableModel();
		table.setModel(modelo);
		atualizarTabela();

		JButton btnAdicionar = new JButton("Adicionar");
		btnAdicionar.setBackground(SystemColor.controlShadow);
		btnAdicionar.setToolTipText("Adicionar um novo cliente");
		btnAdicionar.setBounds(10, 107, 127, 35);
		contentPane.add(btnAdicionar);

		JButton btnRemover = new JButton("Remover");
		btnRemover.setBackground(SystemColor.controlShadow);
		btnRemover.setToolTipText("Remover um cliente");
		btnRemover.setBounds(158, 107, 127, 35);
		contentPane.add(btnRemover);

		JButton btnModificar = new JButton("Modificar");
		btnModificar.setBackground(SystemColor.controlShadow);
		btnModificar.setToolTipText("Modificar um cliente ");
		btnModificar.setBounds(303, 107, 127, 35);
		contentPane.add(btnModificar);

		tfEmail = new JTextField();
		tfEmail.setColumns(10);
		tfEmail.setBounds(527, 72, 254, 23);
		contentPane.add(tfEmail);

		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setBounds(527, 56, 127, 14);
		contentPane.add(lblEmail);

		tfCodigoFuncionario = new JTextField();
		tfCodigoFuncionario.setColumns(10);
		tfCodigoFuncionario.setBounds(10, 33, 46, 23);
		contentPane.add(tfCodigoFuncionario);

		JLabel lblCdigo = new JLabel("C\u00F3digo:");
		lblCdigo.setBounds(10, 17, 57, 14);
		contentPane.add(lblCdigo);

		tfCelular = new JTextField();
		tfCelular.setColumns(10);
		tfCelular.setBounds(915, 73, 114, 23);
		contentPane.add(tfCelular);

		JLabel lblCelular = new JLabel("Celular:");
		lblCelular.setBounds(915, 56, 74, 14);
		contentPane.add(lblCelular);

		tfCPF = new JTextField();
		tfCPF.setColumns(10);
		tfCPF.setBounds(10, 72, 114, 23);
		contentPane.add(tfCPF);

		JLabel lblCPF = new JLabel("CPF:");
		lblCPF.setBounds(10, 56, 74, 14);
		contentPane.add(lblCPF);

		tfLogin = new JTextField();
		tfLogin.setColumns(10);
		tfLogin.setBounds(130, 72, 74, 23);
		contentPane.add(tfLogin);

		JLabel lblLogin = new JLabel("Login:");
		lblLogin.setBounds(130, 56, 74, 14);
		contentPane.add(lblLogin);

		tfCargo = new JTextField();
		tfCargo.setColumns(10);
		tfCargo.setBounds(292, 72, 225, 23);
		contentPane.add(tfCargo);

		JLabel lblCargo = new JLabel("Cargo:");
		lblCargo.setBounds(292, 56, 74, 14);
		contentPane.add(lblCargo);

		tfEndereco = new JTextField();
		tfEndereco.setToolTipText("Ex: Rua: 9 de julho, 1039");
		tfEndereco.setColumns(10);
		tfEndereco.setBounds(368, 33, 225, 23);
		contentPane.add(tfEndereco);

		JLabel lblEndereco = new JLabel("Endere\u00E7o:");
		lblEndereco.setBounds(368, 17, 127, 14);
		contentPane.add(lblEndereco);

		tfBairro = new JTextField();
		tfBairro.setColumns(10);
		tfBairro.setBounds(599, 33, 114, 23);
		contentPane.add(tfBairro);

		JLabel lblBairro = new JLabel("Bairro:");
		lblBairro.setBounds(599, 17, 74, 14);
		contentPane.add(lblBairro);

		tfCidade = new JTextField();
		tfCidade.setColumns(10);
		tfCidade.setBounds(719, 33, 114, 23);
		contentPane.add(tfCidade);

		JLabel lblCidade = new JLabel("Cidade:");
		lblCidade.setBounds(719, 17, 74, 14);
		contentPane.add(lblCidade);

		tfCep = new JTextField();
		tfCep.setColumns(10);
		tfCep.setBounds(839, 33, 114, 23);
		contentPane.add(tfCep);

		JLabel lblCep = new JLabel("CEP:");
		lblCep.setBounds(839, 17, 74, 14);
		contentPane.add(lblCep);

		comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(
				new String[] { "AC \t ", "AL \t ", "AP \t ", "AM \t ", "BA \t ", "CE \t ", "DF \t ", "ES \t ", "GO \t ",
						"MA \t ", "MT \t ", "MS \t ", "MG \t ", "PA \t ", "PB \t ", "PR \t ", "PE \t ", "PI \t ",
						"RJ \t ", "RN \t ", "RS \t ", "RO \t ", "RR \t ", "SC \t ", "SP \t ", "SE \t ", "TO" }));
		comboBox_1.setBounds(963, 32, 66, 23);
		contentPane.add(comboBox_1);

		JLabel lblSenha = new JLabel("Senha");
		lblSenha.setBounds(214, 56, 74, 14);
		contentPane.add(lblSenha);

		tfSenha = new JTextField();
		tfSenha.setColumns(10);
		tfSenha.setBounds(211, 72, 74, 23);
		contentPane.add(tfSenha);

		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				atualizarTabelaPorBusca(table);
			}
		});

		btnAdicionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FuncionarioTableModel modelo = (FuncionarioTableModel) table.getModel();
				Funcionario c = new Funcionario();

				try {
					c.setCodigo(Short.parseShort(tfCodigoFuncionario.getText()));
					c.setNome(tfNomeFuncionario.getText());
					c.setCpf(tfCPF.getText());
					c.setSenha(tfSenha.getText());
					c.setLogin(tfLogin.getText());
					c.setCargo(tfCargo.getText());
					c.setEndereco(tfEndereco.getText());
					c.setBairro(tfBairro.getText());
					c.setCep(tfCep.getText());
					c.setCidade(tfCidade.getText());
					c.setEstado(comboBox_1.getSelectedItem().toString());
					c.setEmail(tfEmail.getText());
					c.setTelefone(tfTelefone.getText());
					c.setCelular(tfCelular.getText());

					new FuncionarioControl().create(c);
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, "Erro: " + ex);
				}

				LimparTela();
				atualizarTabela();
			}
		});

		btnRemover.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FuncionarioTableModel modelo = (FuncionarioTableModel) table.getModel();
				Cliente c = new Cliente();

				if (table.getSelectedRow() != -1) {
					new ClienteControl().delete(Short.parseShort(tfNomeFuncionario.getText()));
				} else {
					JOptionPane.showMessageDialog(null, "Selecione um cliente");
				}

				LimparTela();
				atualizarTabela();
			}
		});

		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FuncionarioTableModel modelo = (FuncionarioTableModel) table.getModel();
				Funcionario c = new Funcionario();

				try {
					c.setCodigo(Short.parseShort(tfCodigoFuncionario.getText()));
					c.setNome(tfNomeFuncionario.getText());
					c.setCpf(tfCPF.getText());
					c.setSenha(tfSenha.getText());
					c.setLogin(tfLogin.getText());
					c.setCargo(tfCargo.getText());
					c.setEndereco(tfEndereco.getText());
					c.setBairro(tfBairro.getText());
					c.setCep(tfCep.getText());
					c.setCidade(tfCidade.getText());
					c.setEstado(comboBox_1.getSelectedItem().toString());
					c.setEmail(tfEmail.getText());
					c.setTelefone(tfTelefone.getText());
					c.setCelular(tfCelular.getText());

					new FuncionarioControl().update(c);
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, "Erro: " + ex);
				}

				LimparTela();

				atualizarTabela();
			}
		});

		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				PreencheTextField();
			}
		});

	}

	private void PreencheTextField() {

		LimparTela();

		tfCodigoFuncionario.setText(table.getValueAt(table.getSelectedRow(), 0).toString());
		tfNomeFuncionario.setText(table.getValueAt(table.getSelectedRow(), 1).toString());
		tfCPF.setText(table.getValueAt(table.getSelectedRow(), 2).toString());
		tfSenha.setText(table.getValueAt(table.getSelectedRow(), 3).toString());
		tfLogin.setText(table.getValueAt(table.getSelectedRow(), 4).toString());
		tfCargo.setText(table.getValueAt(table.getSelectedRow(), 5).toString());
		tfEndereco.setText(table.getValueAt(table.getSelectedRow(), 6).toString());
		tfBairro.setText(table.getValueAt(table.getSelectedRow(), 7).toString());
		tfCep.setText(table.getValueAt(table.getSelectedRow(), 8).toString());
		tfCidade.setText(table.getValueAt(table.getSelectedRow(), 9).toString());
		comboBox_1.setSelectedItem(table.getValueAt(table.getSelectedRow(), 10).toString());
		tfEmail.setText(table.getValueAt(table.getSelectedRow(), 11).toString());
		tfTelefone.setText(table.getValueAt(table.getSelectedRow(), 12).toString());
		tfCelular.setText(table.getValueAt(table.getSelectedRow(), 13).toString());

	}

	private void LimparTela() {
		tfCodigoFuncionario.setText("");
		tfNomeFuncionario.setText("");
		tfCPF.setText("");
		tfSenha.setText("");
		tfLogin.setText("");
		tfCargo.setText("");
		tfEndereco.setText("");
		tfBairro.setText("");
		tfCep.setText("");
		tfCidade.setText("");
		comboBox_1.setSelectedItem("");
		tfEmail.setText("");
		tfTelefone.setText("");
		tfCelular.setText("");

	}

	public void atualizarTabelaPorBusca(JTable table) {
		// TODO Auto-generated method stub
		try {
			/* Criação do modelo */
			Funcionario f = new Funcionario();
			// d.setNome(tfPesquisaCliente.getText());
			f.setPesquisa(tfPesquisa.getText());

			/* Criação do DAO */
			FuncionarioControl FControl = new FuncionarioControl();

			// inserindo produtos na lista usando o método read
			List<Funcionario> lista = FControl.buscaFuncionario(f);
			FuncionarioTableModel modelo = (FuncionarioTableModel) table.getModel();

			/* Copia os dados da consulta para a tabela */
			modelo.adicionar(lista);

		} catch (Exception ex) {
			ex.printStackTrace();
			JOptionPane.showMessageDialog(null, "Erro ao tentar buscar um cliente");
		}
	}

	public void atualizarTabela() {
		// TODO Auto-generated method stub
		try {
			/* Criação do modelo */
			Funcionario c = new Funcionario();
			// d.setNome(tfPesquisaCliente.getText());

			/* Criação do Control */
			FuncionarioControl CControl = new FuncionarioControl();

			// inserindo produtos na lista usando o método read
			List<Funcionario> lista = CControl.read(c);
			FuncionarioTableModel modelo = (FuncionarioTableModel) table.getModel();

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
