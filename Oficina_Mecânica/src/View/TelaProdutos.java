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

public class TelaProdutos extends JFrame {

	private JPanel contentPane;
	private JTable jtCadProduto;
	private JTextField tfNomeProduto;
	private JTextField tfDigitePesquisa;
	private JTextField tfCodigoProduto;
	private JTextField tfDescricaoProduto;
	private JTextField tfPrecoProduto;
	private JTextField tfQuantidadeProduto;
	private JTextField tfPrecoVenda;
	private JComboBox cbFornecedor;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaProdutos frame = new TelaProdutos();
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
	public TelaProdutos() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosed(WindowEvent arg0) {
				TelaProdutos frame = new TelaProdutos();
				frame.setVisible(false);
			}
		});
		setTitle("Tela de cadastro de produtos");
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

		tfNomeProduto = new JTextField();
		tfNomeProduto.setBounds(54, 33, 296, 23);
		contentPane.add(tfNomeProduto);
		tfNomeProduto.setColumns(10);

		JLabel lblNomeProduto = new JLabel("Nome do Produto:");
		lblNomeProduto.setBounds(54, 17, 127, 14);
		contentPane.add(lblNomeProduto);

		tfDigitePesquisa = new JTextField();
		tfDigitePesquisa.setBounds(675, 119, 238, 23);
		tfDigitePesquisa.setColumns(10);
		contentPane.add(tfDigitePesquisa);

		JLabel lblPesquisar = new JLabel("Digite sua pesquisa aqui:");
		lblPesquisar.setBounds(675, 104, 151, 14);
		contentPane.add(lblPesquisar);

		JButton btnPesquisarProduto = new JButton("Pesquisar");
		btnPesquisarProduto.setBackground(SystemColor.controlShadow);
		btnPesquisarProduto.setBounds(923, 121, 106, 23);
		contentPane.add(btnPesquisarProduto);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 153, 1019, 457);
		contentPane.add(scrollPane);

		jtCadProduto = new JTable();
		scrollPane.setViewportView(jtCadProduto);
		jtCadProduto.setToolTipText("");

		JButton btnAdicionarProduto = new JButton("Adicionar");
		btnAdicionarProduto.setBackground(SystemColor.controlShadow);
		btnAdicionarProduto.setToolTipText("Adicionar um novo produto");
		btnAdicionarProduto.setBounds(10, 107, 127, 35);
		contentPane.add(btnAdicionarProduto);

		JButton btnRemoverProduto = new JButton("Remover");
		btnRemoverProduto.setBackground(SystemColor.controlShadow);
		btnRemoverProduto.setToolTipText("Remover um produto");
		btnRemoverProduto.setBounds(158, 107, 127, 35);
		contentPane.add(btnRemoverProduto);

		JButton btnModificarProduto = new JButton("Modificar");
		btnModificarProduto.setBackground(SystemColor.controlShadow);
		btnModificarProduto.setToolTipText("Modificar um produto");
		btnModificarProduto.setBounds(303, 107, 127, 35);
		contentPane.add(btnModificarProduto);

		JLabel lblCodigoProduto = new JLabel("C\u00F3digo:");
		lblCodigoProduto.setBounds(10, 17, 57, 14);
		contentPane.add(lblCodigoProduto);

		tfCodigoProduto = new JTextField();
		tfCodigoProduto.setBounds(10, 33, 38, 23);
		contentPane.add(tfCodigoProduto);
		tfCodigoProduto.setColumns(10);

		tfDescricaoProduto = new JTextField();
		tfDescricaoProduto.setColumns(10);
		tfDescricaoProduto.setBounds(356, 33, 296, 23);
		contentPane.add(tfDescricaoProduto);

		JLabel lblDescricaoProduto = new JLabel("Descri\u00E7\u00E3o do Produto:");
		lblDescricaoProduto.setBounds(356, 17, 127, 14);
		contentPane.add(lblDescricaoProduto);

		tfPrecoProduto = new JTextField();
		tfPrecoProduto.setColumns(10);
		tfPrecoProduto.setBounds(662, 33, 86, 23);
		contentPane.add(tfPrecoProduto);

		JLabel lblPrecoProduto = new JLabel("Pre\u00E7o de Compra:");
		lblPrecoProduto.setBounds(662, 17, 98, 14);
		contentPane.add(lblPrecoProduto);

		tfQuantidadeProduto = new JTextField();
		tfQuantidadeProduto.setColumns(10);
		tfQuantidadeProduto.setBounds(854, 33, 57, 23);
		contentPane.add(tfQuantidadeProduto);

		JLabel lblQuantidadeProduto = new JLabel("Quantidade");
		lblQuantidadeProduto.setBounds(854, 17, 76, 14);
		contentPane.add(lblQuantidadeProduto);
		
		JLabel lblPreoDeVenda = new JLabel("Pre\u00E7o de Venda:");
		lblPreoDeVenda.setBounds(762, 17, 98, 14);
		contentPane.add(lblPreoDeVenda);
		
		tfPrecoVenda = new JTextField();
		tfPrecoVenda.setColumns(10);
		tfPrecoVenda.setBounds(758, 33, 86, 23);
		contentPane.add(tfPrecoVenda);
		
		cbFornecedor = new JComboBox();
		cbFornecedor.setBounds(10, 73, 340, 23);
		contentPane.add(cbFornecedor);
		
		JLabel label = new JLabel("Fornecedor:");
		label.setBounds(10, 60, 106, 14);
		contentPane.add(label);
	}

	private static class __Tmp {
		private static void __tmp() {
			javax.swing.JPanel __wbp_panel = new javax.swing.JPanel();
		}
	}
}
