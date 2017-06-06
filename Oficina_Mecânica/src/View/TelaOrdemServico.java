package view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.SystemColor;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import dal.ModuloConexao;
import model.Cliente;
import model.tables.ClienteTableModel;
import model.tables.ModeloTabela;
import model.tables.ProdutoTableModel;

import java.sql.*;
//import net.proteanit.sql.DbUtils;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import control.ClienteControl;

import javax.swing.JRadioButton;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaOrdemServico extends JFrame {

	private JPanel contentPane;
	private JTable jtPesquisaClientes;
	private JTextField tfPesquisaCliente;
	private JLabel lblNome;
	private JPanel panel;
	private JTextField textField_2;
	private JLabel lblNOs;
	private JLabel lblData;
	private JTextField textField_3;
	private JPanel panel_1;
	private JLabel lblVeculo;
	private JTextField textField_9;
	private JLabel lblValor;
	private JTextField txtVeiculo;
	private JTable jtOrdemServico;
	private JButton btnRelatrio;
	private JPanel panel_2;
	private JButton btnPesquisar;
	private JButton btnAdicionar;
	private JRadioButton rdbtnNewRadioButton;
	private JRadioButton rdbtnOrdemDeServio;
	private JPanel panel_4;
	private JComboBox comboBox;
	private JPanel panel_5;
	private JLabel lblCliente;
	private JTextField txtDefeito;
	private JLabel lblFuncionrio;
	private JTextField txtServico;
	private JLabel lblServico;
	private JTextField textField_6;
	private JScrollPane scrollPane;
	private JTextField txtFuncionario;
	private JLabel lblFuncionrio_1;
	private JButton btnPesquisarFuncServ;
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
					TelaOrdemServico frame = new TelaOrdemServico();
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
	public TelaOrdemServico() {
		setResizable(false);
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosed(WindowEvent arg0) {
				TelaProdutos frame = new TelaProdutos();
				frame.setVisible(false);
			}
		});
		setTitle("Tela de Ordem de Serviços");
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

		panel = new JPanel();
		panel.setBackground(SystemColor.scrollbar);
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "", TitledBorder.LEADING,
				TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBounds(430, 34, 599, 275);
		contentPane.add(panel);
		panel.setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 67, 579, 197);
		panel.add(scrollPane);

		jtPesquisaClientes = new JTable();
		scrollPane.setViewportView(jtPesquisaClientes);

		tfPesquisaCliente = new JTextField();
		tfPesquisaCliente.setBounds(10, 33, 392, 23);
		panel.add(tfPesquisaCliente);
		tfPesquisaCliente.setColumns(10);

		lblNome = new JLabel("Digite sua pesquisa aqui:");
		lblNome.setBounds(10, 11, 133, 19);
		panel.add(lblNome);

		btnPesquisar = new JButton("Pesquisar");		
		btnPesquisar.setToolTipText("Gerar relat\u00F3rio de ordem de servi\u00E7o");
		btnPesquisar.setBackground(SystemColor.controlShadow);
		btnPesquisar.setBounds(487, 27, 102, 29);
		panel.add(btnPesquisar);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(410, 33, 67, 23);
		panel.add(textField_6);

		panel_1 = new JPanel();
		panel_1.setBackground(SystemColor.scrollbar);
		panel_1.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "", TitledBorder.LEADING,
				TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_1.setBounds(16, 34, 404, 114);
		contentPane.add(panel_1);
		panel_1.setLayout(null);

		textField_2 = new JTextField();
		textField_2.setBounds(6, 34, 86, 23);
		panel_1.add(textField_2);
		textField_2.setColumns(10);

		lblNOs = new JLabel("N\u00BA OS");
		lblNOs.setBounds(6, 16, 86, 19);
		panel_1.add(lblNOs);

		lblData = new JLabel("Data:");
		lblData.setBounds(105, 16, 86, 19);
		panel_1.add(lblData);

		textField_3 = new JTextField();
		textField_3.setBounds(102, 34, 102, 23);
		panel_1.add(textField_3);
		textField_3.setColumns(10);
		
		panel_4 = new JPanel();
		panel_4.setBounds(10, 84, 115, 19);
		panel_1.add(panel_4);
		panel_4.setLayout(null);
		
		rdbtnNewRadioButton = new JRadioButton("Or\u00E7amento");
		rdbtnNewRadioButton.setBackground(SystemColor.scrollbar);
		rdbtnNewRadioButton.setBounds(0, 0, 115, 19);
		panel_4.add(rdbtnNewRadioButton);
		
		panel_5 = new JPanel();
		panel_5.setBounds(161, 84, 139, 19);
		panel_1.add(panel_5);
		panel_5.setLayout(null);
		
		rdbtnOrdemDeServio = new JRadioButton("Ordem de Servi\u00E7o");
		rdbtnOrdemDeServio.setBounds(0, 0, 139, 19);
		panel_5.add(rdbtnOrdemDeServio);
		rdbtnOrdemDeServio.setBackground(SystemColor.scrollbar);

		lblVeculo = new JLabel("Situa\u00E7\u00E3o:");
		lblVeculo.setBounds(16, 161, 63, 19);
		contentPane.add(lblVeculo);

		textField_9 = new JTextField();
		textField_9.setColumns(10);
		textField_9.setBounds(52, 321, 86, 23);
		contentPane.add(textField_9);

		lblValor = new JLabel("Valor:");
		lblValor.setBounds(16, 323, 39, 19);
		contentPane.add(lblValor);

		txtVeiculo = new JTextField();
		txtVeiculo.setColumns(10);
		txtVeiculo.setBounds(83, 186, 324, 23);
		contentPane.add(txtVeiculo);

		panel_2 = new JPanel();
		panel_2.setBackground(SystemColor.scrollbar);
		panel_2.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "", TitledBorder.LEADING,
				TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_2.setBounds(17, 351, 1012, 259);
		contentPane.add(panel_2);
		panel_2.setLayout(null);

		jtOrdemServico = new JTable();
		jtOrdemServico.setBounds(10, 11, 992, 237);
		panel_2.add(jtOrdemServico);

		btnAdicionar = new JButton("Adicionar");
		btnAdicionar.setToolTipText("Adicionar nova ordem de servi\u00E7o");
		btnAdicionar.setBackground(SystemColor.controlShadow);
		btnAdicionar.setBounds(166, 315, 102, 29);
		contentPane.add(btnAdicionar);

		btnRelatrio = new JButton("Editar");
		btnRelatrio.setBounds(278, 315, 102, 29);
		contentPane.add(btnRelatrio);
		btnRelatrio.setToolTipText("Gerar relat\u00F3rio de ordem de servi\u00E7o");
		btnRelatrio.setBackground(SystemColor.controlShadow);
		
		comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Aguardando aprova\u00E7\u00E3o", "Aguardadando pe\u00E7as", "Entrega Feita", "Or\u00E7amento reprovado"}));
		comboBox.setBounds(85, 157, 200, 23);
		contentPane.add(comboBox);
		
		lblCliente = new JLabel("Ve\u00EDculo");
		lblCliente.setBounds(16, 191, 53, 19);
		contentPane.add(lblCliente);
		
		txtDefeito = new JTextField();
		txtDefeito.setColumns(10);
		txtDefeito.setBounds(83, 215, 324, 23);
		contentPane.add(txtDefeito);
		
		lblFuncionrio = new JLabel("Defeito");
		lblFuncionrio.setBounds(16, 220, 53, 19);
		contentPane.add(lblFuncionrio);
		
		txtServico = new JTextField();
		txtServico.setColumns(10);
		txtServico.setBounds(83, 244, 324, 23);
		contentPane.add(txtServico);
		
		lblServico = new JLabel("Servico:");
		lblServico.setBounds(16, 249, 53, 19);
		contentPane.add(lblServico);
		
		txtFuncionario = new JTextField();
		txtFuncionario.setColumns(10);
		txtFuncionario.setBounds(83, 273, 324, 23);
		contentPane.add(txtFuncionario);
		
		lblFuncionrio_1 = new JLabel("Funcion\u00E1rio");
		lblFuncionrio_1.setBounds(16, 278, 63, 19);
		contentPane.add(lblFuncionrio_1);
		
		btnPesquisarFuncServ = new JButton("Cancelar");
		btnPesquisarFuncServ.setToolTipText("Gerar relat\u00F3rio de ordem de servi\u00E7o");
		btnPesquisarFuncServ.setBackground(SystemColor.controlShadow);
		btnPesquisarFuncServ.setBounds(395, 315, 102, 29);
		contentPane.add(btnPesquisarFuncServ);
		
		btnPesquisar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				modeloCliente = new ClienteTableModel();
				jtPesquisaClientes.setModel(modeloCliente);
				atualizarTabelaPorBusca();
			}
		});
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
			ClienteTableModel modelo = (ClienteTableModel) jtPesquisaClientes.getModel();

			/* Copia os dados da consulta para a tabela */
			modelo.adicionar(lista);

		} catch (Exception ex) {
			ex.printStackTrace();
			JOptionPane.showMessageDialog(null, "Erro ao tentar buscar um cliente");
		}
	}
	
	
	private static class __Tmp {
		private static void __tmp() {
			javax.swing.JPanel __wbp_panel = new javax.swing.JPanel();
		}
	}
}
