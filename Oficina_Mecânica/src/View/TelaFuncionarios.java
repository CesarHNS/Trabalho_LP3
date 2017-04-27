package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.SystemColor;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JTable;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.DefaultComboBoxModel;

public class TelaFuncionarios extends JFrame {

	private JPanel contentPane;
	private JTextField tfNomeFuncionario;
	private JTextField tfTelefone;
	private JTextField textField_2;
	private JTable table;
	private JTextField tfEmail;
	private JTextField tfCodigoFuncionario;
	private JTextField tfCelular;
	private JTextField tfCPF;
	private JTextField tfSenha;
	private JTextField tfCargo;
	private JTextField tfEndereco;
	private JTextField tfBairro;
	private JTextField tfCidade;
	private JTextField textField_6;

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
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);//fecha apenas a janela onde estou quando clico no X
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
		
		JComboBox<?> cbFiltros = new JComboBox<Object>();
		cbFiltros.setBounds(475, 119, 190, 23);
		contentPane.add(cbFiltros);
		
		JLabel lblFiltrarPor = new JLabel("Filtra por:");
		lblFiltrarPor.setBounds(475, 104, 114, 14);
		contentPane.add(lblFiltrarPor);
		
		textField_2 = new JTextField();
		textField_2.setBounds(675, 119, 238, 23);
		textField_2.setColumns(10);
		contentPane.add(textField_2);
		
		JLabel lblFiltros = new JLabel("Filtros:");
		lblFiltros.setBounds(675, 104, 151, 14);
		contentPane.add(lblFiltros);
		
		JButton btnNewButton = new JButton("Pesquisar");
		btnNewButton.setBackground(SystemColor.controlShadow);
		btnNewButton.setBounds(923, 121, 106, 23);
		contentPane.add(btnNewButton);
		
		table = new JTable();
		table.setBounds(10, 153, 1019, 457);
		contentPane.add(table);
		
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
		tfEmail.setBounds(485, 72, 296, 23);
		contentPane.add(tfEmail);
		
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setBounds(485, 56, 127, 14);
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
		
		tfSenha = new JTextField();
		tfSenha.setColumns(10);
		tfSenha.setBounds(130, 72, 114, 23);
		contentPane.add(tfSenha);
		
		JLabel lblSenha = new JLabel("Senha");
		lblSenha.setBounds(130, 56, 74, 14);
		contentPane.add(lblSenha);
		
		tfCargo = new JTextField();
		tfCargo.setColumns(10);
		tfCargo.setBounds(250, 72, 225, 23);
		contentPane.add(tfCargo);
		
		JLabel lblCargo = new JLabel("Cargo:");
		lblCargo.setBounds(250, 56, 74, 14);
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
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(839, 33, 114, 23);
		contentPane.add(textField_6);
		
		JLabel lblCep = new JLabel("CEP:");
		lblCep.setBounds(839, 17, 74, 14);
		contentPane.add(lblCep);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"AC \t ", "AL \t ", "AP \t ", "AM \t ", "BA \t ", "CE \t ", "DF \t ", "ES \t ", "GO \t ", "MA \t ", "MT \t ", "MS \t ", "MG \t ", "PA \t ", "PB \t ", "PR \t ", "PE \t ", "PI \t ", "RJ \t ", "RN \t ", "RS \t ", "RO \t ", "RR \t ", "SC \t ", "SP \t ", "SE \t ", "TO"}));
		comboBox_1.setBounds(963, 32, 66, 23);
		contentPane.add(comboBox_1);
	}
	private static class __Tmp {
		private static void __tmp() {
			  javax.swing.JPanel __wbp_panel = new javax.swing.JPanel();
		}
	}
}
