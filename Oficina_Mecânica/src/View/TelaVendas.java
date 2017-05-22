package view;

import java.awt.EventQueue;
import java.awt.SystemColor;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class TelaVendas extends JFrame {

	private JPanel contentPane;
	private JTable tablePesquisa;
	private JTextField tfNomeProduto;
	private JTextField tfNomeCliente;
	private JTable tableVendas;
	private JTextField tfQuantProd;
	private JTextField tfDataVenda;
	private JButton btnRealizarCompra;
	private JButton btnCancelarCompra;
	private JTextField tfValorTotal;
	private JLabel lblNewLabel;
	private JLabel lblPesquisa;
	private JButton btnPesquisar;
	private JButton button;
	private JLabel lblData;
	private JLabel lblQuantidade;
	private JTextField tfPrecoProd;
	private JLabel lblPreo;
	private JTextField tfCodigoVenda;
	private JLabel lblCdigo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaVendas frame = new TelaVendas();
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
	public TelaVendas() {
		setResizable(false);
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosed(WindowEvent arg0) {
				TelaProdutos frame = new TelaProdutos();
				frame.setVisible(false);
			}
		});
		setTitle("Tela de Vendas");
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
		tfNomeProduto.setBounds(81, 33, 296, 23);
		contentPane.add(tfNomeProduto);
		tfNomeProduto.setColumns(10);

		JLabel lblNomeProduto = new JLabel("Nome do Produto:");
		lblNomeProduto.setBounds(81, 17, 127, 14);
		contentPane.add(lblNomeProduto);

		tablePesquisa = new JTable();
		tablePesquisa.setToolTipText("");
		tablePesquisa.setBounds(10, 153, 1019, 176);
		contentPane.add(tablePesquisa);

		JButton btnAdicionarProduto = new JButton("Adicionar Item");
		btnAdicionarProduto.setBackground(SystemColor.controlShadow);
		btnAdicionarProduto.setToolTipText("Adicionar um novo produto");
		btnAdicionarProduto.setBounds(397, 73, 127, 35);
		contentPane.add(btnAdicionarProduto);

		tfNomeCliente = new JTextField();
		tfNomeCliente.setColumns(10);
		tfNomeCliente.setBounds(550, 33, 296, 23);
		contentPane.add(tfNomeCliente);

		JLabel lblDescricaoProduto = new JLabel("Nome Cliente");
		lblDescricaoProduto.setBounds(550, 17, 127, 14);
		contentPane.add(lblDescricaoProduto);

		tableVendas = new JTable();
		tableVendas.setToolTipText("");
		tableVendas.setBounds(10, 375, 1019, 193);
		contentPane.add(tableVendas);

		JLabel lblTabelaDeVendas = new JLabel("Itens da Venda:");
		lblTabelaDeVendas.setBounds(10, 351, 103, 24);
		contentPane.add(lblTabelaDeVendas);

		tfQuantProd = new JTextField();
		tfQuantProd.setColumns(10);
		tfQuantProd.setBounds(81, 85, 103, 23);
		contentPane.add(tfQuantProd);

		tfDataVenda = new JTextField();
		tfDataVenda.setColumns(10);
		tfDataVenda.setBounds(550, 85, 103, 23);
		contentPane.add(tfDataVenda);

		btnRealizarCompra = new JButton("Realizar Venda");
		btnRealizarCompra.setToolTipText("Adicionar um novo produto");
		btnRealizarCompra.setBackground(SystemColor.controlShadow);
		btnRealizarCompra.setBounds(326, 579, 127, 35);
		contentPane.add(btnRealizarCompra);

		btnCancelarCompra = new JButton("Cancelar Venda");
		btnCancelarCompra.setToolTipText("Adicionar um novo produto");
		btnCancelarCompra.setBackground(SystemColor.controlShadow);
		btnCancelarCompra.setBounds(506, 579, 127, 35);
		contentPane.add(btnCancelarCompra);

		tfValorTotal = new JTextField();
		tfValorTotal.setColumns(10);
		tfValorTotal.setBounds(764, 591, 103, 23);
		contentPane.add(tfValorTotal);

		lblNewLabel = new JLabel("Valor Total:");
		lblNewLabel.setBounds(686, 591, 68, 23);
		contentPane.add(lblNewLabel);

		lblPesquisa = new JLabel("Pesquisa:");
		lblPesquisa.setBounds(10, 123, 103, 24);
		contentPane.add(lblPesquisa);

		btnPesquisar = new JButton("Pesquisar");
		btnPesquisar.setToolTipText("Adicionar um novo produto");
		btnPesquisar.setBackground(SystemColor.controlShadow);
		btnPesquisar.setBounds(397, 21, 127, 35);
		contentPane.add(btnPesquisar);

		button = new JButton("Pesquisar");
		button.setToolTipText("Adicionar um novo produto");
		button.setBackground(SystemColor.controlShadow);
		button.setBounds(878, 21, 127, 35);
		contentPane.add(button);

		lblData = new JLabel("Data:");
		lblData.setBounds(550, 65, 127, 14);
		contentPane.add(lblData);

		lblQuantidade = new JLabel("Quantidade:");
		lblQuantidade.setBounds(81, 65, 103, 14);
		contentPane.add(lblQuantidade);

		tfPrecoProd = new JTextField();
		tfPrecoProd.setColumns(10);
		tfPrecoProd.setBounds(204, 85, 103, 23);
		contentPane.add(tfPrecoProd);

		lblPreo = new JLabel("Pre\u00E7o");
		lblPreo.setBounds(204, 65, 103, 14);
		contentPane.add(lblPreo);
		
		tfCodigoVenda = new JTextField();
		tfCodigoVenda.setColumns(10);
		tfCodigoVenda.setBounds(10, 33, 55, 23);
		contentPane.add(tfCodigoVenda);
		
		lblCdigo = new JLabel("C\u00F3digo:");
		lblCdigo.setBounds(10, 17, 55, 14);
		contentPane.add(lblCdigo);
	}

	private static class __Tmp {
		private static void __tmp() {
			javax.swing.JPanel __wbp_panel = new javax.swing.JPanel();
		}
	}
}
