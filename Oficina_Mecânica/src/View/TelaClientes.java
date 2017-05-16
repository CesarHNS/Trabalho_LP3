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
import java.util.Vector;

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
import java.sql.*;
import dal.ModuloConexao;

import model.Cliente;
import model.ClienteTableModel;
import model.dao.ClienteDAO;

//User Interface UI = view

public class TelaClientes extends JFrame {
	ClienteTableModel modelo;
	Connection conexao = null;
	PreparedStatement pst = null;
	ResultSet rs = null;

	/**
	 *  
	 */

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

		JLabel lblFiltraPorCliente = new JLabel("Filtra por:");
		lblFiltraPorCliente.setBounds(475, 101, 114, 14);
		contentPane.add(lblFiltraPorCliente);

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

		jtClientes = new JTable();

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

		scrollPane.setViewportView(jtClientes);
		jtClientes.setToolTipText("");
		//modelo = new ClienteTableModel();
		//jtClientes.setModel(modelo);
		DefaultTableModel modelo = (DefaultTableModel) jtClientes.getModel();
		jtClientes.setRowSorter(new TableRowSorter(modelo));
		

		JComboBox<String> cbFiltrosCliente = new JComboBox<String>();
		cbFiltrosCliente.setBounds(475, 119, 190, 23);
		contentPane.add(cbFiltrosCliente);

		JComboBox<String> cbEstado = new JComboBox<String>();
		cbEstado.setBounds(951, 33, 63, 23);
		cbEstado.setModel(new DefaultComboBoxModel<String>(
				new String[] { "AC \t", "AL \t", "AP \t", "AM \t", "BA \t", "CE \t", "DF \t", "ES \t", "GO\t ",
						"MA \t ", "MT \t ", "MS\t ", "MG \t ", "PA \t ", "PB \t ", "PN \t ", "PE \t ", "PI\t ",
						"RJ \t ", "RN \t ", "RS \t ", "RO \t ", "RO \t ", "SC \t", "SP \t ", "SE \t ", "TO \t" }));
		contentPane.add(cbEstado);

		/********************************************************************
		 * Método responsável por ler a tabela de clientes
		 * *****************************************************************
		 * 
		 * public void LoadTable(){ modelo = new ClienteTableModel();
		 * jtClientes.setModel(modelo);
		 * 
		 * 
		 * }
		 */

		/***********************************************************************
		 * Botão que adiciona os clientes
		 **********************************************************************/

		btnAdicionarCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				tfCodigoCliente.setEnabled(true);
				Cliente c = new Cliente();
				ClienteDAO dao = new ClienteDAO();

				c.setId(Short.parseShort(tfCodigoCliente.getText()));
				c.setNome(tfNomeCliente.getText());
				c.setDataNasc(tfDataNascimento.getText());
				c.setCpf(tfCpfCliente.getText());
				c.setEndereco(tfEnderecoCliente.getText());
				c.setBairro(tfBairroCliente.getText());
				c.setCep(tfCepCliente.getText());
				c.setCidade(tfCidadeCliente.getText());
				c.setEstado(cbEstado.getSelectedItem().toString());
				c.setEmail(tfEmailCliente.getText());
				c.setTelefone(tfTelefoneCliente.getText());
				c.setCelular(tfCelularCliente.getText());
				
				//salvando o cliente na classe dao
				dao.create(c);

			}

		});

		/***********************************************************************
		 * Botão para remover clientes
		 **********************************************************************/

		btnRemoverCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				tfCodigoCliente.setEnabled(true);
				Cliente c = new Cliente();
				ClienteDAO dao = new ClienteDAO();
				
				c.setId(Short.parseShort(tfCodigoCliente.getText()));
				
				dao.delete(c);
			}
		});

		/***********************************************************************
		 * selecionar uma linha da tabela de clientes
		 **********************************************************************/
		jtClientes.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// desabilitando o textField do codigo do cliente
				// para que o usuário não modifique o código
				tfCodigoCliente.setEnabled(false);
				// verificando se existe linha selecionada
/*
				int index = jtClientes.getSelectedRow();
				if (index >= 0 && index < modelo.getRowCount()) {
					String temp[] = modelo.getCliente(index);

					tfCodigoCliente.setText(temp[0]);
					tfNomeCliente.setText(temp[0]);
					tfDataNascimento.setText(temp[0]);
					tfCpfCliente.setText(temp[0]);
					tfEnderecoCliente.setText(temp[0]);
					tfBairroCliente.setText(temp[0]);
					tfCepCliente.setText(temp[0]);
					tfCidadeCliente.setText(temp[0]);
					cbEstado.setSelectedItem(temp[0]);
					tfEmailCliente.setText(temp[0]);
					tfCelularCliente.setText(temp[0]);
					tfTelefoneCliente.setText(temp[0]);

				}
*/
			}
		});

		/***********************************************************************
		 * Botão para modificar clientes
		 **********************************************************************/
		btnModificarCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				tfCodigoCliente.setEnabled(true);

				// verificando se existe linha selecionada
				if (jtClientes.getSelectedRow() != -1) {

					jtClientes.setValueAt(tfNomeCliente.getText(), jtClientes.getSelectedRow(), 1);
					jtClientes.setValueAt(tfDataNascimento.getText(), jtClientes.getSelectedRow(), 2);
					jtClientes.setValueAt(tfCpfCliente.getText(), jtClientes.getSelectedRow(), 3);
					jtClientes.setValueAt(tfEnderecoCliente.getText(), jtClientes.getSelectedRow(), 4);
					jtClientes.setValueAt(tfBairroCliente.getText(), jtClientes.getSelectedRow(), 5);
					jtClientes.setValueAt(tfCepCliente.getText(), jtClientes.getSelectedRow(), 6);
					jtClientes.setValueAt(tfCidadeCliente.getText(), jtClientes.getSelectedRow(), 7);
					jtClientes.setValueAt(cbEstado.getSelectedItem(), jtClientes.getSelectedRow(), 8);
					jtClientes.setValueAt(tfEmailCliente.getText(), jtClientes.getSelectedRow(), 9);
					jtClientes.setValueAt(tfCelularCliente.getText(), jtClientes.getSelectedRow(), 10);
					jtClientes.setValueAt(tfTelefoneCliente.getText(), jtClientes.getSelectedRow(), 11);

					LimparTela();
					JOptionPane.showMessageDialog(null, "Cliente modificado com sucesso");

				} else {
					JOptionPane.showMessageDialog(null, "Selecione um cliente");
				}
			}
		});

	}

	/**********************************************************************
	 * Método para fazer consultas no banco de dados
	 *********************************************************************/
	private void readJTable() {
		DefaultTableModel modelo = (DefaultTableModel) jtClientes.getModel();
		modelo.setNumRows(0);
		ClienteDAO cdao = new ClienteDAO();
		
		
		for(Cliente c: cdao.read())
		{
			modelo.addRow((Vector) new Object());
			c.getId();
			c.getNome();
			c.getDataNasc();
			c.getCpf();
			c.getEndereco();
			c.getBairro();
			c.getCep();
			c.getCidade();
			c.getEstado();
			c.getEmail();
			c.getTelefone();
			c.getCelular();
		}
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
		tfCelularCliente.setText("");
		tfTelefoneCliente.setText("");

	}

	@SuppressWarnings("unused")
	private static class __Tmp {
		private static void __tmp() {
			javax.swing.JPanel __wbp_panel = new javax.swing.JPanel();
		}
	}
}
