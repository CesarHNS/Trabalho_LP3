package pacote.View;

import java.awt.BorderLayout;
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
import javax.swing.border.EmptyBorder;

public class TelaVeiculos extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField tfDescricaoVeiculo;
	private JTextField tfDigitePesquisaVeiculo;
	private JTextField tfCodigoVeiculo;
	private JTextField tfMontadoraVeiculo;
	private JTextField tfPlacaVeiculo;

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

		JComboBox<?> cbFiltrosVeiculos = new JComboBox<Object>();
		cbFiltrosVeiculos.setToolTipText("Escolha o filtro de sua pesquisa");
		cbFiltrosVeiculos.setBounds(475, 119, 190, 23);
		contentPane.add(cbFiltrosVeiculos);

		JLabel lblFiltrarPor = new JLabel("Filtra por:");
		lblFiltrarPor.setBounds(475, 104, 114, 14);
		contentPane.add(lblFiltrarPor);

		tfDigitePesquisaVeiculo = new JTextField();
		tfDigitePesquisaVeiculo.setBounds(675, 119, 238, 23);
		tfDigitePesquisaVeiculo.setColumns(10);
		contentPane.add(tfDigitePesquisaVeiculo);

		JLabel lblDigitePesquisaVeiculo = new JLabel("Digite sua pesquisa aqui:");
		lblDigitePesquisaVeiculo.setBounds(675, 104, 151, 14);
		contentPane.add(lblDigitePesquisaVeiculo);

		JButton btnPesquisarVeiculo = new JButton("Pesquisar");
		btnPesquisarVeiculo.setBackground(SystemColor.controlShadow);
		btnPesquisarVeiculo.setBounds(923, 121, 106, 23);
		contentPane.add(btnPesquisarVeiculo);

		table = new JTable();
		table.setToolTipText("");
		table.setBounds(10, 153, 1019, 457);
		contentPane.add(table);

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

		JLabel lblCodigoVeiculo = new JLabel("C\u00F3digo:");
		lblCodigoVeiculo.setBounds(10, 17, 57, 14);
		contentPane.add(lblCodigoVeiculo);

		tfCodigoVeiculo = new JTextField();
		tfCodigoVeiculo.setBounds(10, 33, 49, 23);
		contentPane.add(tfCodigoVeiculo);
		tfCodigoVeiculo.setColumns(10);

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
	}

	private static class __Tmp {
		private static void __tmp() {
			javax.swing.JPanel __wbp_panel = new javax.swing.JPanel();
		}
	}

}
