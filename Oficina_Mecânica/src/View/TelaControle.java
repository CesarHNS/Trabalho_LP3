package view;

import java.awt.EventQueue;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

public class TelaControle extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaControle frame = new TelaControle();
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
	public TelaControle() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);// quando clico no X
															// fecha apenas a
															// janela onde estou
		setBounds(100, 100, 1280, 720);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.scrollbar);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.scrollbar);
		panel.setBorder(new LineBorder(SystemColor.controlShadow));
		panel.setBounds(10, 11, 195, 659);
		contentPane.add(panel);
		panel.setLayout(null);

		JButton btnClientes = new JButton("Clientes");
		btnClientes.setToolTipText("Cadastrar Clientes");
		btnClientes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaClientes ObjTelaClientes = null;
				try {
					ObjTelaClientes = new TelaClientes();
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				ObjTelaClientes.setVisible(true);
			}
		});
		btnClientes.setBounds(25, 11, 144, 44);
		panel.add(btnClientes);
		btnClientes.setBackground(SystemColor.controlShadow);

		JButton btnFuncionrios = new JButton("Funcionários");
		btnFuncionrios.setToolTipText("Cadastrar Fornecedores");
		btnFuncionrios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaFuncionarios ObjTelaFuncionarios = new TelaFuncionarios();
				ObjTelaFuncionarios.setVisible(true);

			}
		});
		btnFuncionrios.setBounds(25, 66, 144, 44);
		panel.add(btnFuncionrios);
		btnFuncionrios.setBackground(SystemColor.controlShadow);

		JButton btnFornecedores = new JButton("Fornecedores");
		btnFornecedores.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaFornecedores ObjTelaFornecedores = new TelaFornecedores();
				ObjTelaFornecedores.setVisible(true);
			}
		});
		btnFornecedores.setToolTipText("Cadastrar Fornecedores");
		btnFornecedores.setBounds(25, 121, 144, 44);
		panel.add(btnFornecedores);
		btnFornecedores.setBackground(SystemColor.controlShadow);

		JButton btnProdutos = new JButton("Produtos ");
		btnProdutos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaProdutos ObjTelaProdutos = new TelaProdutos();
				ObjTelaProdutos.setVisible(true);
			}
		});
		btnProdutos.setToolTipText("Cadastrar Produtos");
		btnProdutos.setBounds(25, 176, 144, 44);
		panel.add(btnProdutos);
		btnProdutos.setBackground(SystemColor.controlShadow);

		JButton btnServios = new JButton("Servi\u00E7os");
		btnServios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaServico ObjTelaServicos = new TelaServico();
				ObjTelaServicos.setVisible(true);
			}
		});
		btnServios.setToolTipText("Cadastrar Servi\u00E7os");
		btnServios.setBackground(SystemColor.controlShadow);
		btnServios.setBounds(25, 231, 144, 44);
		panel.add(btnServios);

		JButton btnOrdensDeServico = new JButton("OS");
		btnOrdensDeServico.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaOrdemServico ObjOrdemServico = new TelaOrdemServico();
				ObjOrdemServico.setVisible(true);
			}
		});
		btnOrdensDeServico.setToolTipText("Gerar ordem de servi\u00E7o");
		btnOrdensDeServico.setBounds(25, 286, 144, 44);
		panel.add(btnOrdensDeServico);
		btnOrdensDeServico.setBackground(SystemColor.controlShadow);

		JButton btnVendas = new JButton("Vendas");
		btnVendas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaVendas ObjTelaVendas = new TelaVendas();
				ObjTelaVendas.setVisible(true);
			}
		});
		btnVendas.setToolTipText("Realizar Vendas de Produtos");
		btnVendas.setBackground(SystemColor.controlShadow);
		btnVendas.setBounds(25, 340, 144, 44);
		panel.add(btnVendas);

		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBorder(new LineBorder(SystemColor.controlShadow));
		panel_1.setBackground(SystemColor.scrollbar);
		panel_1.setBounds(215, 11, 1039, 659);
		contentPane.add(panel_1);
	}
}
