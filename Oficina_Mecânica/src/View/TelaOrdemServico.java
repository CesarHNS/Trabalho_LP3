package view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.SystemColor;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

public class TelaOrdemServico extends JFrame {

	private JPanel contentPane;
	private JTable jtPesquisaClientes;
	private JTextField textField;
	private JTextField textField_1;
	private JLabel lblCodigo;
	private JLabel lblNome;
	private JPanel panel;
	private JLabel lblCliente;
	private JTextField textField_2;
	private JLabel lblNOs;
	private JLabel lblData;
	private JTextField textField_3;
	private JLabel lblNomeFuncionrio;
	private JPanel panel_1;
	private JLabel lblVeculo;
	private JLabel lblServio;
	private JLabel lblV;
	private JLabel lblMecnico;
	private JTextField textField_9;
	private JLabel lblValor;
	private JComboBox comboBox;
	private JComboBox comboBox_1;
	private JComboBox comboBox_3;
	private JTextField textField_5;
	private JTable jtOrdemServico;
	private JButton btnRelatrio;
	private JComboBox comboBox_2;
	private JPanel panel_2;
	private JButton btnPesquisar;
	private JButton btnAdicionar;

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

		jtPesquisaClientes = new JTable();
		jtPesquisaClientes.setBounds(10, 67, 579, 197);
		panel.add(jtPesquisaClientes);

		textField = new JTextField();
		textField.setEditable(false);
		textField.setBounds(10, 33, 86, 23);
		panel.add(textField);
		textField.setColumns(10);

		textField_1 = new JTextField();
		textField_1.setBounds(106, 33, 296, 23);
		panel.add(textField_1);
		textField_1.setColumns(10);

		lblCodigo = new JLabel("C\u00F3digo:");
		lblCodigo.setBounds(10, 15, 86, 19);
		panel.add(lblCodigo);

		lblNome = new JLabel("Nome:");
		lblNome.setBounds(109, 15, 86, 19);
		panel.add(lblNome);

		btnPesquisar = new JButton("Pesquisar");
		btnPesquisar.setToolTipText("Gerar relat\u00F3rio de ordem de servi\u00E7o");
		btnPesquisar.setBackground(SystemColor.controlShadow);
		btnPesquisar.setBounds(408, 27, 102, 29);
		panel.add(btnPesquisar);

		lblCliente = new JLabel("CLIENTE:");
		lblCliente.setBounds(430, 11, 86, 19);
		contentPane.add(lblCliente);

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

		lblNomeFuncionrio = new JLabel("Nome Funcion\u00E1rio:");
		lblNomeFuncionrio.setBounds(9, 63, 129, 19);
		panel_1.add(lblNomeFuncionrio);

		comboBox_2 = new JComboBox();
		comboBox_2.setBounds(6, 81, 295, 23);
		panel_1.add(comboBox_2);

		lblVeculo = new JLabel("Ve\u00EDculo:");
		lblVeculo.setBounds(16, 161, 63, 19);
		contentPane.add(lblVeculo);

		lblServio = new JLabel("Defeito:");
		lblServio.setBounds(16, 200, 63, 19);
		contentPane.add(lblServio);

		lblV = new JLabel("Servi\u00E7o:");
		lblV.setBounds(16, 240, 63, 19);
		contentPane.add(lblV);

		lblMecnico = new JLabel("Mec\u00E2nico:");
		lblMecnico.setBounds(16, 281, 63, 19);
		contentPane.add(lblMecnico);

		textField_9 = new JTextField();
		textField_9.setColumns(10);
		textField_9.setBounds(89, 321, 86, 23);
		contentPane.add(textField_9);

		lblValor = new JLabel("Valor:");
		lblValor.setBounds(16, 323, 39, 19);
		contentPane.add(lblValor);

		comboBox = new JComboBox();
		comboBox.setBounds(89, 279, 324, 23);
		contentPane.add(comboBox);

		comboBox_1 = new JComboBox();
		comboBox_1.setBounds(89, 238, 324, 23);
		contentPane.add(comboBox_1);

		comboBox_3 = new JComboBox();
		comboBox_3.setBounds(89, 159, 324, 23);
		contentPane.add(comboBox_3);

		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(89, 198, 324, 23);
		contentPane.add(textField_5);

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
		btnAdicionar.setBounds(190, 315, 102, 29);
		contentPane.add(btnAdicionar);

		btnRelatrio = new JButton("Relat\u00F3rio");
		btnRelatrio.setBounds(302, 315, 102, 29);
		contentPane.add(btnRelatrio);
		btnRelatrio.setToolTipText("Gerar relat\u00F3rio de ordem de servi\u00E7o");
		btnRelatrio.setBackground(SystemColor.controlShadow);
	}

	private static class __Tmp {
		private static void __tmp() {
			javax.swing.JPanel __wbp_panel = new javax.swing.JPanel();
		}
	}
}
