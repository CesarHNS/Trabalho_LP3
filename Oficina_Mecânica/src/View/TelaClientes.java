package view;

import java.awt.ComponentOrientation;
import java.awt.EventQueue;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.ParseException;
import java.util.List;
import java.util.Vector;

import javax.swing.AbstractButton;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import javax.swing.text.MaskFormatter;

import control.ClienteControl;
import control.FornecedorControl;
import control.ProdutoControl;

import java.sql.*;
import dal.ModuloConexao;

import model.Cliente;
import model.Produtos;
import model.tables.ClienteTableModel;
import model.tables.ProdutoTableModel;

//User Interface UI = view

public class TelaClientes extends JFrame {
	
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField tfNomeCliente;
	private JTextField tfTelefoneCliente;
	private JTextField tfPesquisaCliente;
	private JTable jtClientes;
	private JTextField tfCodigoCliente;
	private JTextField tfCelularCliente;
	private JTextField tfCidadeCliente;
	private JTextField tfEnderecoCliente;
	private JTextField tfEmailCliente;
	private JTextField tfBairroCliente;
	private JTextField tfCepCliente;
	private JTextField tfCpfCliente;
	private JTextField tfDataNascimento;
	private JComboBox<String> cbEstado;
	ClienteTableModel modelo;
	Connection conexao = null;
	PreparedStatement pst = null;
	ResultSet rs = null;

	/***************************************************************
	 * Launch the application.
	 **************************************************************/
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {

			public void run() {
				try {
					TelaClientes frame = new TelaClientes();
					frame.setVisible(true);

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/***********************************************************
	 * Create the frame.
	 * 
	 * @throws ParseException
	 ***********************************************************/

	public TelaClientes() throws ParseException {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosed(WindowEvent arg0) {
				TelaClientes frame = null;
				try {
					frame = new TelaClientes();

				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				frame.setVisible(false);
			}
		});

		setTitle("Tela de cadastro de clientes\r\n");
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

		tfNomeCliente = new JTextField();
		tfNomeCliente.setBounds(66, 33, 296, 23);
		contentPane.add(tfNomeCliente);
		tfNomeCliente.setColumns(10);

		MaskFormatter fmtTelefone = new MaskFormatter("(##)####-####");
		tfTelefoneCliente = new JFormattedTextField(fmtTelefone);
		tfTelefoneCliente.setBounds(443, 72, 114, 23);
		tfTelefoneCliente.setColumns(10);
		contentPane.add(tfTelefoneCliente);

		tfCodigoCliente = new JTextField();
		tfCodigoCliente.setBounds(10, 33, 46, 23);
		tfCodigoCliente.setColumns(10);
		contentPane.add(tfCodigoCliente);
		tfCodigoCliente.setEnabled(true);

		MaskFormatter fmtCelular = new MaskFormatter("(##)9####-####");
		tfCelularCliente = new JFormattedTextField(fmtCelular);
		tfCelularCliente.setBounds(567, 72, 114, 23);
		tfCelularCliente.setColumns(10);
		contentPane.add(tfCelularCliente);

		tfCidadeCliente = new JTextField();
		tfCidadeCliente.setBounds(719, 34, 102, 23);
		tfCidadeCliente.setColumns(10);
		contentPane.add(tfCidadeCliente);

		tfEnderecoCliente = new JTextField();
		tfEnderecoCliente.setBounds(372, 33, 225, 23);
		tfEnderecoCliente.setToolTipText("Ex: Rua: 9 de julho, 1039");
		tfEnderecoCliente.setColumns(10);
		contentPane.add(tfEnderecoCliente);

		tfEmailCliente = new JTextField();
		tfEmailCliente.setBounds(134, 72, 296, 23);
		tfEmailCliente.setColumns(10);
		contentPane.add(tfEmailCliente);

		tfBairroCliente = new JTextField();
		tfBairroCliente.setBounds(607, 33, 102, 23);
		tfBairroCliente.setColumns(10);
		contentPane.add(tfBairroCliente);

		MaskFormatter fmtCep = new MaskFormatter("##.###-###");
		tfCepCliente = new JFormattedTextField(fmtCep);
		tfCepCliente.setBounds(827, 33, 114, 23);
		tfCepCliente.setColumns(10);
		contentPane.add(tfCepCliente);

		MaskFormatter fmtDataNasc = new MaskFormatter("##/##/####");
		tfDataNascimento = new JFormattedTextField(fmtDataNasc);
		tfDataNascimento.setBounds(687, 72, 114, 23);
		tfDataNascimento.setColumns(10);
		contentPane.add(tfDataNascimento);

		MaskFormatter fmtCpf = new MaskFormatter("###.###.###-##");
		tfCpfCliente = new JFormattedTextField(fmtCpf);
		tfCpfCliente.setBounds(10, 72, 114, 23);
		tfCpfCliente.setColumns(10);
		contentPane.add(tfCpfCliente);

		tfPesquisaCliente = new JTextField();
		tfPesquisaCliente.setBounds(675, 119, 238, 23);
		tfPesquisaCliente.setColumns(10);
		contentPane.add(tfPesquisaCliente);

		JLabel lblCodigoCliente = new JLabel("C\u00F3digo:");
		lblCodigoCliente.setBounds(10, 17, 57, 14);
		contentPane.add(lblCodigoCliente);

		JLabel lblCelularCliente = new JLabel("Celular:");
		lblCelularCliente.setBounds(567, 55, 74, 14);
		contentPane.add(lblCelularCliente);

		JLabel lblCidadeCliente = new JLabel("Cidade:");
		lblCidadeCliente.setBounds(719, 17, 102, 14);
		contentPane.add(lblCidadeCliente);

		JLabel lblEnderecoCliente = new JLabel("Endere\u00E7o:");
		lblEnderecoCliente.setBounds(372, 17, 74, 14);
		lblEnderecoCliente.setToolTipText("Ex: Rua: 9 de julho, 3010");
		contentPane.add(lblEnderecoCliente);

		JLabel label = new JLabel("Email:");
		label.setBounds(134, 56, 127, 14);
		contentPane.add(label);

		JLabel lblBairroCliente = new JLabel("Bairro:");
		lblBairroCliente.setBounds(607, 16, 102, 14);
		contentPane.add(lblBairroCliente);

		JLabel lblCepCliente = new JLabel("CEP:");
		lblCepCliente.setBounds(827, 17, 74, 14);
		contentPane.add(lblCepCliente);

		JLabel lblEstadoCliente = new JLabel("Estado:");
		lblEstadoCliente.setBounds(951, 17, 74, 14);
		contentPane.add(lblEstadoCliente);

		JLabel lblCpfCliente = new JLabel("CPF:");
		lblCpfCliente.setBounds(10, 56, 74, 14);
		lblCpfCliente.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		contentPane.add(lblCpfCliente);

		JLabel lblDigitePesquisaAqui = new JLabel("Digite sua pesquisa aqui:");
		lblDigitePesquisaAqui.setBounds(675, 101, 151, 14);
		contentPane.add(lblDigitePesquisaAqui);

		JLabel lblDataNascimento = new JLabel("Data de Nascimento:");
		lblDataNascimento.setBounds(687, 55, 114, 14);
		contentPane.add(lblDataNascimento);

		JLabel lblNomeCliente = new JLabel("Nome do Cliente:");
		lblNomeCliente.setBounds(66, 17, 127, 14);
		contentPane.add(lblNomeCliente);

		JButton btnPesquisarCliente = new JButton("Pesquisar");
		btnPesquisarCliente.setBounds(923, 121, 106, 23);
		btnPesquisarCliente.setBackground(SystemColor.controlShadow);
		contentPane.add(btnPesquisarCliente);

		// Utilizando o ScrollPane para que os nomes das colunas apareçam no
		// JTable
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 153, 1019, 457);
		contentPane.add(scrollPane);

		JLabel lblTelefoneCliente = new JLabel("Telefone:");
		lblTelefoneCliente.setBounds(443, 56, 74, 14);
		contentPane.add(lblTelefoneCliente);

		JButton btnAdicionarCliente = new JButton("Adicionar");
		btnAdicionarCliente.setBounds(10, 107, 127, 35);
		btnAdicionarCliente.setBackground(SystemColor.controlShadow);
		btnAdicionarCliente.setToolTipText("Adicionar um novo cliente");
		contentPane.add(btnAdicionarCliente);

		JButton btnRemoverCliente = new JButton("Remover");
		btnRemoverCliente.setBounds(158, 107, 127, 35);
		btnRemoverCliente.setBackground(SystemColor.controlShadow);
		btnRemoverCliente.setToolTipText("Remover um cliente");
		contentPane.add(btnRemoverCliente);

		JButton btnModificarCliente = new JButton("Modificar");
		btnModificarCliente.setBounds(303, 107, 127, 35);
		btnModificarCliente.setBackground(SystemColor.controlShadow);
		btnModificarCliente.setToolTipText("Modificar um cliente ");
		contentPane.add(btnModificarCliente);

		jtClientes = new JTable();		
		scrollPane.setViewportView(jtClientes);
		jtClientes.setToolTipText("");
		modelo = new ClienteTableModel();
		jtClientes.setModel(modelo);
		// usando o ClienteControl para atualizar a tabela ao abrir a
		// TelaClientes
		atualizarTabela();

		cbEstado = new JComboBox<String>();
		cbEstado.setBounds(951, 33, 63, 23);
		cbEstado.setModel(new DefaultComboBoxModel<String>(
				new String[] { "AC \t", "AL \t", "AP \t", "AM \t", "BA \t", "CE \t", "DF \t", "ES \t", "GO\t ",
						"MA \t ", "MT \t ", "MS\t ", "MG \t ", "PA \t ", "PB \t ", "PN \t ", "PE \t ", "PI\t ",
						"RJ \t ", "RN \t ", "RS \t ", "RO \t ", "RO \t ", "SC \t", "SP \t ", "SE \t ", "TO \t" }));
		contentPane.add(cbEstado);

		/***********************************************************************
		 * Botão que adiciona os clientes
		 **********************************************************************/
		btnAdicionarCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ClienteTableModel modelo = (ClienteTableModel) jtClientes.getModel();
				Cliente c = new Cliente();
				
				c.setId(Short.parseShort(tfCodigoCliente.getText()));
				c.setNome(tfNomeCliente.getText());
				c.setDataNasc(tfDataNascimento.getText());
				c.setCpf(tfCpfCliente.getText());
				c.setEndereco(tfEnderecoCliente.getText());
				c.setBairro(tfBairroCliente.getText());
				c.setCep(tfCepCliente.getText());
				c.setCidade( tfCidadeCliente.getText());
				c.setEstado(cbEstado.getSelectedItem().toString());
				c.setEmail(tfEmailCliente.getText());
				c.setTelefone(tfTelefoneCliente.getText());
				c.setCelular(tfCelularCliente.getText());
				
				try {
					new ClienteControl().create(c);
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, "Erro: " + e);
				}				
			
				LimparTela();
				atualizarTabela();

			}

		});

		/***********************************************************************
		 * Botão para remover clientes
		 **********************************************************************/
		btnRemoverCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ClienteTableModel modelo = (ClienteTableModel) jtClientes.getModel();
				Cliente c = new Cliente();
				
				if (jtClientes.getSelectedRow() != -1) {					
					new ClienteControl().delete(Short.parseShort(tfCodigoCliente.getText()));
				} else {
					JOptionPane.showMessageDialog(null, "Selecione um cliente");
				}

				LimparTela();
				atualizarTabela();
			}
		});

		/***********************************************************************
		 * selecionar uma linha da tabela de clientes
		 **********************************************************************/
		jtClientes.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				PreencheTextField();
			}
		});

		/***********************************************************************
		 * Botão para modificar clientes
		 **********************************************************************/
		btnModificarCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ClienteTableModel modelo = (ClienteTableModel) jtClientes.getModel();
				Cliente c = new Cliente();
				
				c.setId(Short.parseShort(tfCodigoCliente.getText()));
				c.setNome(tfNomeCliente.getText());
				c.setDataNasc(tfDataNascimento.getText());
				c.setCpf(tfCpfCliente.getText());
				c.setEndereco(tfEnderecoCliente.getText());
				c.setBairro(tfBairroCliente.getText());
				c.setCep(tfCepCliente.getText());
				c.setCidade( tfCidadeCliente.getText());
				c.setEstado(cbEstado.getSelectedItem().toString());
				c.setEmail(tfEmailCliente.getText());
				c.setTelefone(tfTelefoneCliente.getText());
				c.setCelular(tfCelularCliente.getText());
				
				try {
					new ClienteControl().update(c);
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, "Erro: " + ex);
				}				
			
				LimparTela();
				atualizarTabela();

			}
		});
		
		btnPesquisarCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				atualizarTabelaPorBusca();
			}
		});

	}

	/***********************************************************************
	 * Método para preencher os TextFields após selecionar uma linha
	 **********************************************************************/
	private void PreencheTextField() {

		LimparTela();

		tfCodigoCliente.setText(jtClientes.getValueAt(jtClientes.getSelectedRow(), 0).toString());
		tfNomeCliente.setText(jtClientes.getValueAt(jtClientes.getSelectedRow(), 1).toString());
		tfDataNascimento.setText(jtClientes.getValueAt(jtClientes.getSelectedRow(), 2).toString());
		tfCpfCliente.setText(jtClientes.getValueAt(jtClientes.getSelectedRow(), 3).toString());
		tfEnderecoCliente.setText(jtClientes.getValueAt(jtClientes.getSelectedRow(), 4).toString());
		tfBairroCliente.setText(jtClientes.getValueAt(jtClientes.getSelectedRow(), 5).toString());
		tfCepCliente.setText(jtClientes.getValueAt(jtClientes.getSelectedRow(), 6).toString());
		tfCidadeCliente.setText(jtClientes.getValueAt(jtClientes.getSelectedRow(), 7).toString());
		cbEstado.setSelectedItem((jtClientes.getValueAt(jtClientes.getSelectedRow(), 8).toString()));
		tfEmailCliente.setText(jtClientes.getValueAt(jtClientes.getSelectedRow(), 9).toString());
		tfTelefoneCliente.setText(jtClientes.getValueAt(jtClientes.getSelectedRow(), 10).toString());
		tfCelularCliente.setText(jtClientes.getValueAt(jtClientes.getSelectedRow(), 11).toString());

	}

	/***********************************************************************
	 * Método para limpar os TextFields após o cadastramento dos clientes
	 **********************************************************************/
	private void LimparTela() {
		tfCodigoCliente.setText("");
		tfNomeCliente.setText("");
		tfDataNascimento.setText("");
		tfCpfCliente.setText("");
		tfEnderecoCliente.setText("");
		tfBairroCliente.setText("");
		tfCepCliente.setText("");
		tfCidadeCliente.setText("");
		tfEmailCliente.setText("");
		cbEstado.setSelectedIndex(0);
		tfCelularCliente.setText("");
		tfTelefoneCliente.setText("");

	}
	
	public void atualizarTabela() {
		// TODO Auto-generated method stub
		try {
			/* Criação do modelo */
			Cliente c = new Cliente();
			// d.setNome(tfPesquisaCliente.getText());

			/* Criação do Control */
			ClienteControl CControl = new ClienteControl();

			// inserindo produtos na lista usando o método read
			List<Cliente> lista = CControl.read(c);
			ClienteTableModel modelo = (ClienteTableModel) jtClientes.getModel();

			/* Copia os dados da consulta para a tabela */
			modelo.adicionar(lista);

		} catch (Exception ex) {
			ex.printStackTrace();
			JOptionPane.showMessageDialog(null, "Erro ao tentar buscar um produto");
		}
	}
	
	public void atualizarTabelaPorBusca() {
		// TODO Auto-generated method stub
		try {
			/* Criação do modelo */
			Cliente c = new Cliente();
			// d.setNome(tfPesquisaCliente.getText());
			c.setPesquisa(tfPesquisaCliente.getText());

			/* Criação do DAO */
			ClienteControl CControl = new ClienteControl();

			// inserindo produtos na lista usando o método read
			List<Cliente> lista = CControl.buscaCliente(c);
			ClienteTableModel modelo = (ClienteTableModel) jtClientes.getModel();

			/* Copia os dados da consulta para a tabela */
			modelo.adicionar(lista);

		} catch (Exception ex) {
			ex.printStackTrace();
			JOptionPane.showMessageDialog(null, "Erro ao tentar buscar um cliente");
		}
	}
	
	

	@SuppressWarnings("unused")
	private static class __Tmp {
		private static void __tmp() {
			javax.swing.JPanel __wbp_panel = new javax.swing.JPanel();
		}
	}
}
