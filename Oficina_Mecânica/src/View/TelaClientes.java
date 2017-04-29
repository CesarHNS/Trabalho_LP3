package View;

import java.awt.BorderLayout;
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
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JTable;
import java.awt.ComponentOrientation;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

import Model.Cliente;

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
	private JTable table;
	private JTextField tfCodigoCliente;
	private JTextField tfCelularCliente;
	private JTextField tfCidadeCliente;
	private JTextField tfEnderecoCliente;
	private JTextField tfEmailCliente;
	private JTextField tfBairroCliente;
	private JTextField tfCepCliente;
	private JTextField tfCpfCliente;

	/**
	 * Launch the application.
	 */
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

	/**
	 * Create the frame.
	 */
	public TelaClientes() {
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

		JLabel lblNomeCliente = new JLabel("Nome do Cliente:");
		lblNomeCliente.setBounds(66, 17, 127, 14);
		contentPane.add(lblNomeCliente);

		JLabel lblTelefoneCliente = new JLabel("Telefone:");
		lblTelefoneCliente.setBounds(443, 56, 74, 14);
		contentPane.add(lblTelefoneCliente);

		JComboBox<String> cbFiltrosCliente = new JComboBox<String>();
		cbFiltrosCliente.setBounds(475, 119, 190, 23);
		contentPane.add(cbFiltrosCliente);

		tfPesquisaCliente = new JTextField();
		tfPesquisaCliente.setBounds(675, 119, 238, 23);
		tfPesquisaCliente.setColumns(10);
		contentPane.add(tfPesquisaCliente);

		/***********************************************************************
		 * Botão para pesquisar os clientes cadastrados
		 **********************************************************************/
		JButton btnPesquisarCliente = new JButton("Pesquisar");
		btnPesquisarCliente.setBackground(SystemColor.controlShadow);
		btnPesquisarCliente.setBounds(923, 121, 106, 23);
		contentPane.add(btnPesquisarCliente);

		table = new JTable();
		table.setBounds(10, 153, 1019, 457);
		contentPane.add(table);

		/***********************************************************************
		 * Botão que adiciona clientes
		 **********************************************************************/

		JButton btnAdicionarCliente = new JButton("Adicionar");
		btnAdicionarCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				Cliente cliente = new Cliente();

				cliente.setCpf((tfCpfCliente.getText()));
				cliente.setNome((tfNomeCliente.getText()));

				ClienteDAO dao = new ClienteDAO();

				// passando o objeto cliente para o metódo adicionar da classe
				// de negócios DAO
				dao.adicionar(cliente);

			}
		});
		btnAdicionarCliente.setBackground(SystemColor.controlShadow);
		btnAdicionarCliente.setToolTipText("Adicionar um novo cliente");
		btnAdicionarCliente.setBounds(10, 107, 127, 35);
		contentPane.add(btnAdicionarCliente);

		/***********************************************************************
		 * Botão para remover clientes
		 **********************************************************************/
		JButton btnRemoverCliente = new JButton("Remover");
		btnRemoverCliente.setBackground(SystemColor.controlShadow);
		btnRemoverCliente.setToolTipText("Remover um cliente");
		btnRemoverCliente.setBounds(158, 107, 127, 35);
		contentPane.add(btnRemoverCliente);

		/***********************************************************************
		 * Botão para modificar clientes
		 **********************************************************************/
		JButton btnModificarCliente = new JButton("Modificar");
		btnModificarCliente.setBackground(SystemColor.controlShadow);
		btnModificarCliente.setToolTipText("Modificar um cliente ");
		btnModificarCliente.setBounds(303, 107, 127, 35);
		contentPane.add(btnModificarCliente);

		tfCodigoCliente = new JTextField();
		tfCodigoCliente.setColumns(10);
		tfCodigoCliente.setBounds(10, 33, 46, 23);
		contentPane.add(tfCodigoCliente);

		JLabel lblCodigoCliente = new JLabel("C\u00F3digo:");
		lblCodigoCliente.setBounds(10, 17, 57, 14);
		contentPane.add(lblCodigoCliente);

		tfCelularCliente = new JTextField();
		tfCelularCliente.setColumns(10);
		tfCelularCliente.setBounds(567, 72, 114, 23);
		contentPane.add(tfCelularCliente);

		tfCidadeCliente = new JTextField();
		tfCidadeCliente.setColumns(10);
		tfCidadeCliente.setBounds(719, 34, 102, 23);
		contentPane.add(tfCidadeCliente);

		JLabel lblCelularCliente = new JLabel("Celular:");
		lblCelularCliente.setBounds(567, 55, 74, 14);
		contentPane.add(lblCelularCliente);

		JLabel lblCidadeCliente = new JLabel("Cidade:");
		lblCidadeCliente.setBounds(719, 17, 102, 14);
		contentPane.add(lblCidadeCliente);

		JLabel lblEnderecoCliente = new JLabel("Endere\u00E7o:");
		lblEnderecoCliente.setToolTipText("Ex: Rua: 9 de julho, 3010");
		lblEnderecoCliente.setBounds(372, 17, 74, 14);
		contentPane.add(lblEnderecoCliente);

		tfEnderecoCliente = new JTextField();
		tfEnderecoCliente.setToolTipText("Ex: Rua: 9 de julho, 1039");
		tfEnderecoCliente.setColumns(10);
		tfEnderecoCliente.setBounds(372, 33, 225, 23);
		contentPane.add(tfEnderecoCliente);

		tfEmailCliente = new JTextField();
		tfEmailCliente.setColumns(10);
		tfEmailCliente.setBounds(134, 72, 296, 23);
		contentPane.add(tfEmailCliente);

		JLabel label = new JLabel("Email:");
		label.setBounds(134, 56, 127, 14);
		contentPane.add(label);

		tfBairroCliente = new JTextField();
		tfBairroCliente.setColumns(10);
		tfBairroCliente.setBounds(607, 33, 102, 23);
		contentPane.add(tfBairroCliente);

		JLabel lblBairroCliente = new JLabel("Bairro:");
		lblBairroCliente.setBounds(607, 16, 102, 14);
		contentPane.add(lblBairroCliente);

		JLabel lblCepCliente = new JLabel("CEP:");
		lblCepCliente.setBounds(827, 17, 74, 14);
		contentPane.add(lblCepCliente);

		tfCepCliente = new JTextField();
		tfCepCliente.setColumns(10);
		tfCepCliente.setBounds(827, 33, 114, 23);
		contentPane.add(tfCepCliente);

		JLabel lblEstadoCliente = new JLabel("Estado:");
		lblEstadoCliente.setBounds(951, 17, 74, 14);
		contentPane.add(lblEstadoCliente);

		tfCpfCliente = new JTextField();
		tfCpfCliente.setColumns(10);
		tfCpfCliente.setBounds(10, 72, 114, 23);
		contentPane.add(tfCpfCliente);

		JLabel lblCpfCliente = new JLabel("CPF:");
		lblCpfCliente.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		lblCpfCliente.setBounds(10, 56, 74, 14);
		contentPane.add(lblCpfCliente);

		JLabel lblFiltraPorCliente = new JLabel("Filtra por:");
		lblFiltraPorCliente.setBounds(475, 101, 114, 14);
		contentPane.add(lblFiltraPorCliente);

		JLabel lblDigitePesquisaAqui = new JLabel("Digite sua pesquisa aqui:");
		lblDigitePesquisaAqui.setBounds(675, 101, 151, 14);
		contentPane.add(lblDigitePesquisaAqui);

		JComboBox<String> cbEstadoCliente = new JComboBox<String>();
		cbEstadoCliente.setModel(new DefaultComboBoxModel<String>(new String[] { "SP" }));
		cbEstadoCliente.setBounds(951, 33, 74, 23);
		contentPane.add(cbEstadoCliente);

	}

	private static class __Tmp {
		private static void __tmp() {
			javax.swing.JPanel __wbp_panel = new javax.swing.JPanel();
		}
	}
}
