package view;

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
import javax.swing.JScrollPane;

public class TelaServico extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField tfNomeServico;
	private JTextField tfPesquisaServico;
	private JTextField tfCodigoServico;
	private JTextField tfPrecoServico;
	private JTextField tfQuantidadeServico;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaServico frame = new TelaServico();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public TelaServico() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosed(WindowEvent arg0) {
				TelaServico frame = new TelaServico();
				frame.setVisible(false);
			}
		});
		setTitle("Tela de cadastro de servi\u00E7os");
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

		tfNomeServico = new JTextField();
		tfNomeServico.setBounds(64, 33, 286, 23);
		contentPane.add(tfNomeServico);
		tfNomeServico.setColumns(10);

		JLabel lblNomeServico = new JLabel("Nome do Servi\u00E7o:");
		lblNomeServico.setBounds(64, 17, 127, 14);
		contentPane.add(lblNomeServico);

		tfPesquisaServico = new JTextField();
		tfPesquisaServico.setBounds(675, 119, 238, 23);
		tfPesquisaServico.setColumns(10);
		contentPane.add(tfPesquisaServico);

		JLabel lblDigitePesquisaServico = new JLabel("Digite sua pesquisa aqui:");
		lblDigitePesquisaServico.setBounds(675, 104, 151, 14);
		contentPane.add(lblDigitePesquisaServico);

		JButton btnPesquisarServico = new JButton("Pesquisar");
		btnPesquisarServico.setBackground(SystemColor.controlShadow);
		btnPesquisarServico.setBounds(923, 121, 106, 23);
		contentPane.add(btnPesquisarServico);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 153, 1019, 457);
		contentPane.add(scrollPane);

		table = new JTable();
		scrollPane.setViewportView(table);
		table.setToolTipText("");

		JButton btnAdicionarServico = new JButton("Adicionar");
		btnAdicionarServico.setBackground(SystemColor.controlShadow);
		btnAdicionarServico.setToolTipText("Adicionar um novo produto");
		btnAdicionarServico.setBounds(10, 107, 127, 35);
		contentPane.add(btnAdicionarServico);

		JButton btnRemoverServico = new JButton("Remover");
		btnRemoverServico.setBackground(SystemColor.controlShadow);
		btnRemoverServico.setToolTipText("Remover um produto");
		btnRemoverServico.setBounds(158, 107, 127, 35);
		contentPane.add(btnRemoverServico);

		JButton btnModificarServico = new JButton("Modificar");
		btnModificarServico.setBackground(SystemColor.controlShadow);
		btnModificarServico.setToolTipText("Modificar um produto");
		btnModificarServico.setBounds(303, 107, 127, 35);
		contentPane.add(btnModificarServico);

		JLabel lblCodigoServico = new JLabel("C\u00F3digo:");
		lblCodigoServico.setBounds(10, 17, 57, 14);
		contentPane.add(lblCodigoServico);

		tfCodigoServico = new JTextField();
		tfCodigoServico.setBounds(10, 33, 49, 23);
		contentPane.add(tfCodigoServico);
		tfCodigoServico.setColumns(10);

		tfPrecoServico = new JTextField();
		tfPrecoServico.setColumns(10);
		tfPrecoServico.setBounds(360, 33, 38, 23);
		contentPane.add(tfPrecoServico);

		JLabel lblPrecoServico = new JLabel("Pre\u00E7o:");
		lblPrecoServico.setBounds(360, 17, 57, 14);
		contentPane.add(lblPrecoServico);

		tfQuantidadeServico = new JTextField();
		tfQuantidadeServico.setColumns(10);
		tfQuantidadeServico.setBounds(404, 33, 38, 23);
		contentPane.add(tfQuantidadeServico);

		JLabel lblQuantidadeServico = new JLabel("Quantidade");
		lblQuantidadeServico.setBounds(404, 17, 76, 14);
		contentPane.add(lblQuantidadeServico);
	}

	private static class __Tmp {
		private static void __tmp() {
			javax.swing.JPanel __wbp_panel = new javax.swing.JPanel();
		}
	}

}
