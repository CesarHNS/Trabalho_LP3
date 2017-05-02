package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.JTextComponent;

import Dao.ClienteDAO;

import java.awt.Rectangle;
import java.awt.SystemColor;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JTable;
import java.awt.ComponentOrientation;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import java.awt.event.ActionEvent;

import Model.Cliente;
import Model.ClienteTableModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

//User Interface UI = view

public class TelaClientes extends JFrame {

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
	 ***********************************************************/

	public TelaClientes() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosed(WindowEvent arg0) {
				TelaClientes frame = new TelaClientes();
				frame.setVisible(false);
			}
		});

		setTitle("Tela de cadastro de clientes\r\n");
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

		tfNomeCliente = new JTextField();
		tfNomeCliente.setBounds(66, 33, 296, 23);
		contentPane.add(tfNomeCliente);
		tfNomeCliente.setColumns(10);

		tfTelefoneCliente = new JTextField();
		tfTelefoneCliente.setBounds(443, 72, 114, 23);
		tfTelefoneCliente.setColumns(10);
		contentPane.add(tfTelefoneCliente);

		tfCodigoCliente = new JTextField();
		tfCodigoCliente.setBounds(10, 33, 46, 23);
		tfCodigoCliente.setColumns(10);
		contentPane.add(tfCodigoCliente);

		tfCelularCliente = new JTextField();
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

		tfCepCliente = new JTextField();
		tfCepCliente.setBounds(827, 33, 114, 23);
		tfCepCliente.setColumns(10);
		contentPane.add(tfCepCliente);

		tfDataNascimento = new JTextField();
		tfDataNascimento.setBounds(687, 72, 114, 23);
		tfDataNascimento.setColumns(10);
		contentPane.add(tfDataNascimento);

		tfCpfCliente = new JTextField();
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

		JComboBox<String> cbFiltrosCliente = new JComboBox<String>();
		cbFiltrosCliente.setBounds(475, 119, 190, 23);
		contentPane.add(cbFiltrosCliente);
		
		JButton btnModificarCliente = new JButton("Modificar");
		btnModificarCliente.setBounds(303, 107, 127, 35);
		btnModificarCliente.setBackground(SystemColor.controlShadow);
		btnModificarCliente.setToolTipText("Modificar um cliente ");
		contentPane.add(btnModificarCliente);
		
		scrollPane.setViewportView(jtClientes);
		jtClientes.setToolTipText("");
		jtClientes.setModel(
				new DefaultTableModel(new Object[][] {}, new String[] { "C\u00F3digo", "Nome", "Data de Nascimento",
						"CPF", "Endereco", "Bairro","CEP", "Cidade", "Estado", "Email", "Telefone", "Celular" }) {
					boolean[] columnEditables = new boolean[] { false, false, false, false, false, false, false, false,
							false, false, false };

					public boolean isCellEditable(int row, int column) {
						return columnEditables[column];
					}
				});

		JComboBox<String> cbEstado = new JComboBox<String>();
		cbEstado.setBounds(951, 33, 63, 23);
		cbEstado.setModel(new DefaultComboBoxModel<String>(new String[] { "Acre \t", "Alagoas \t", "Amap\u00E1 \t",
				"Amazonas \t", "Bahia \t", "Cear\u00E1 \t", "Distrito Federal \t", "Esp\u00EDrito Santo \t",
				"Goi\u00E1s \t\t ", "Maranh\u00E3o \t ", "Mato Grosso \t\t ", "Mato Grosso do Sul \t\t ",
				"Minas Gerais \t\t ", "Par\u00E1 \t\t ", "Para\u00EDba \t ", "Paran\u00E1 \t\t ", "Pernambuco \t \t ",
				"Piau\u00ED \t\t ", "Rio de Janeiro \t ", "Rio Grande do Norte \t\t ", "Rio Grande do Sul \t ",
				"Rond\u00F4nia \t\t ", "Roraima \t ", "Santa Catarina \t", "S\u00E3o Paulo \t\t ", "Sergipe \t\t ",
				"Tocantins \t" }));
		contentPane.add(cbEstado);

		/***********************************************************************
		 * Botão que adiciona os clientes
		 **********************************************************************/

		btnAdicionarCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {								
				DefaultTableModel tableModel = (DefaultTableModel)jtClientes.getModel();
				Object[] clientes = {Long.parseLong(tfCodigoCliente.getText()),
					tfNomeCliente.getText(),
					 tfDataNascimento.getText(),
					tfCpfCliente.getText(),
					tfEnderecoCliente.getText(),
					tfBairroCliente.getText(),
					tfCepCliente.getText(),
					tfCidadeCliente.getText(),
					(String) cbEstado.getSelectedItem(),
					tfEmailCliente.getText(),
					tfCelularCliente.getText(),
					tfTelefoneCliente.getText()};				

					tableModel.addRow(clientes);
					LimparTela();
					JOptionPane.showMessageDialog(null, "Cliente adicionado com sucesso");

				} catch (NumberFormatException e) {

					JOptionPane.showMessageDialog(null, "Preencha todos os campos corretamente!");

				}

			}

		});

		/***********************************************************************
		 * Botão para remover clientes
		 **********************************************************************/
		JButton btnRemoverCliente = new JButton("Remover");
		btnRemoverCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				DefaultTableModel tableModel = (DefaultTableModel)jtClientes.getModel();

			//verificando se existe linha selecionada
				if (jtClientes.getSelectedRow() != -1) {
					tableModel.removeRow(jtClientes.getSelectedRow());
					JOptionPane.showMessageDialog(null, "Cliente removido com sucesso");
				}
			}
		});
		btnRemoverCliente.setBounds(158, 107, 127, 35);
		btnRemoverCliente.setBackground(SystemColor.controlShadow);
		btnRemoverCliente.setToolTipText("Remover um cliente");
		contentPane.add(btnRemoverCliente);
		
		/***********************************************************************
		 * selecionar uma linha da tabela de clientes
		 **********************************************************************/		
		jtClientes.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				if (jtClientes.getSelectedRow() != -1) {

					tfCodigoCliente.setText(jtClientes.getValueAt(jtClientes.getSelectedRow(), 0).toString());
					tfNomeCliente.setText(jtClientes.getValueAt(jtClientes.getSelectedRow(), 1).toString());
					tfDataNascimento.setText(jtClientes.getValueAt(jtClientes.getSelectedRow(), 2).toString());
					tfCpfCliente.setText(jtClientes.getValueAt(jtClientes.getSelectedRow(), 3).toString());
					tfEnderecoCliente.setText(jtClientes.getValueAt(jtClientes.getSelectedRow(), 4).toString());
					tfBairroCliente.setText(jtClientes.getValueAt(jtClientes.getSelectedRow(), 5).toString());
					tfCepCliente.setText(jtClientes.getValueAt(jtClientes.getSelectedRow(), 6).toString());
					tfCidadeCliente.setText(jtClientes.getValueAt(jtClientes.getSelectedRow(), 7).toString());
					cbEstado.setSelectedItem(jtClientes.getValueAt(jtClientes.getSelectedRow(), 8).toString());
					tfEmailCliente.setText(jtClientes.getValueAt(jtClientes.getSelectedRow(), 9).toString());
					tfCelularCliente.setText(jtClientes.getValueAt(jtClientes.getSelectedRow(), 10).toString());
					tfTelefoneCliente.setText(jtClientes.getValueAt(jtClientes.getSelectedRow(), 11).toString());

				}
			}
		});

		/***********************************************************************
		 * Botão para modificar clientes
		 **********************************************************************/
		btnModificarCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//verificando se existe linha selecionada
				if (jtClientes.getSelectedRow() != -1) {
			
					jtClientes.setValueAt(tfCodigoCliente.getText(), jtClientes.getSelectedRow(), 0);
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
					
				}
			}
		});
	
	}

	/***********************************************************************
	 * Método para limpar a tela após o cadastramento dos clientes
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
