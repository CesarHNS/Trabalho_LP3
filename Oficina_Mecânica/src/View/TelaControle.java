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
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.UIManager;
import javax.swing.JScrollBar;
import javax.swing.JToolBar;

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
					frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
					frame.setLocationRelativeTo(null);
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
		setBounds(100, 100, 1280, 782);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.scrollbar);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton btnClientes = new JButton("Clientes");
		btnClientes.setBounds(10, 11, 144, 44);
		contentPane.add(btnClientes);
		btnClientes.setIcon(null);
		btnClientes.setToolTipText("Cadastrar Clientes");
		btnClientes.setBackground(SystemColor.controlShadow);

		JButton btnFuncionrios = new JButton("Funcionários");
		btnFuncionrios.setBounds(10, 66, 144, 44);
		contentPane.add(btnFuncionrios);
		btnFuncionrios.setToolTipText("Cadastrar Fornecedores");
		btnFuncionrios.setBackground(SystemColor.controlShadow);

		JButton btnFornecedores = new JButton("Fornecedores");
		btnFornecedores.setBounds(10, 121, 144, 44);
		contentPane.add(btnFornecedores);
		btnFornecedores.setToolTipText("Cadastrar Fornecedores");
		btnFornecedores.setBackground(SystemColor.controlShadow);

		JButton btnProdutos = new JButton("Produtos ");
		btnProdutos.setBounds(10, 176, 144, 44);
		contentPane.add(btnProdutos);
		btnProdutos.setToolTipText("Cadastrar Produtos");
		btnProdutos.setBackground(SystemColor.controlShadow);

		JButton btnServios = new JButton("Servi\u00E7os");
		btnServios.setBounds(10, 286, 144, 44);
		contentPane.add(btnServios);
		btnServios.setToolTipText("Cadastrar Servi\u00E7os");
		btnServios.setBackground(SystemColor.controlShadow);

		JButton btnOrdensDeServico = new JButton("OS");
		btnOrdensDeServico.setBounds(10, 341, 144, 44);
		contentPane.add(btnOrdensDeServico);
		btnOrdensDeServico.setToolTipText("Gerar ordem de servi\u00E7o");
		btnOrdensDeServico.setBackground(SystemColor.controlShadow);

		JButton btnVendas = new JButton("Vendas");
		btnVendas.setBounds(10, 396, 144, 44);
		contentPane.add(btnVendas);
		btnVendas.setToolTipText("Realizar Vendas de Produtos");
		btnVendas.setBackground(SystemColor.controlShadow);

		JButton btnVeiculos = new JButton("Ve\u00EDculos");
		btnVeiculos.setToolTipText("Cadastrar Ve\u00EDculos");
		btnVeiculos.setBackground(SystemColor.controlShadow);
		btnVeiculos.setBounds(10, 231, 144, 44);
		contentPane.add(btnVeiculos);

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
				ObjTelaClientes.setLocationRelativeTo(null);

			}
		});

		btnFuncionrios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaFuncionarios ObjTelaFuncionarios = new TelaFuncionarios();
				ObjTelaFuncionarios.setVisible(true);
				ObjTelaFuncionarios.setLocationRelativeTo(null);

			}
		});

		btnFornecedores.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaFornecedores ObjTelaFornecedores = new TelaFornecedores();
				ObjTelaFornecedores.setVisible(true);
				ObjTelaFornecedores.setLocationRelativeTo(null);
			}
		});

		btnProdutos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaProdutos ObjTelaProdutos = new TelaProdutos();
				ObjTelaProdutos.setVisible(true);
				ObjTelaProdutos.setLocationRelativeTo(null);

			}
		});

		btnServios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaServico ObjTelaServicos = new TelaServico();
				ObjTelaServicos.setVisible(true);
				ObjTelaServicos.setLocationRelativeTo(null);

			}
		});

		btnOrdensDeServico.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaOrdemServico ObjOrdemServico = new TelaOrdemServico();
				ObjOrdemServico.setVisible(true);
				ObjOrdemServico.setLocationRelativeTo(null);

			}
		});

		btnVendas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaVendas ObjTelaVendas = new TelaVendas();
				ObjTelaVendas.setVisible(true);
				ObjTelaVendas.setLocationRelativeTo(null);

			}
		});

		btnVeiculos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaVeiculos ObjTelaVeiculos = new TelaVeiculos();
				ObjTelaVeiculos.setVisible(true);
				ObjTelaVeiculos.setLocationRelativeTo(null);

			}
		});
	}
}
