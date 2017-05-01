package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.SystemColor;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
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
	private JTextField tfDescricaoProduto;
	private JTextField tfPrecoProduto;
	private JTextField tfQuantidadeProduto;
	private JTable tableVendas;

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
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);//fecha apenas a janela onde estou quando clico no X
		setBounds(320, 150, 1045, 650);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.scrollbar);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		tfNomeProduto = new JTextField();
		tfNomeProduto.setBounds(10, 33, 296, 23);
		contentPane.add(tfNomeProduto);
		tfNomeProduto.setColumns(10);
			
		JLabel lblNomeProduto = new JLabel("Nome do Produto:");
		lblNomeProduto.setBounds(10, 17, 127, 14);
		contentPane.add(lblNomeProduto);
		
		tablePesquisa = new JTable();
		tablePesquisa.setToolTipText("");
		tablePesquisa.setBounds(10, 153, 1019, 176);
		contentPane.add(tablePesquisa);
		
		JButton btnAdicionarProduto = new JButton("Adicionar");
		btnAdicionarProduto.setBackground(SystemColor.controlShadow);
		btnAdicionarProduto.setToolTipText("Adicionar um novo produto");
		btnAdicionarProduto.setBounds(764, 21, 127, 35);
		contentPane.add(btnAdicionarProduto);
		
		tfDescricaoProduto = new JTextField();
		tfDescricaoProduto.setColumns(10);
		tfDescricaoProduto.setBounds(356, 33, 296, 23);
		contentPane.add(tfDescricaoProduto);
		
		JLabel lblDescricaoProduto = new JLabel("Descri\u00E7\u00E3o do Produto:");
		lblDescricaoProduto.setBounds(356, 17, 127, 14);
		contentPane.add(lblDescricaoProduto);
		
		tfPrecoProduto = new JTextField();
		tfPrecoProduto.setColumns(10);
		tfPrecoProduto.setBounds(658, 33, 38, 23);
		contentPane.add(tfPrecoProduto);
		
		JLabel lblPrecoProduto = new JLabel("Pre\u00E7o:");
		lblPrecoProduto.setBounds(658, 17, 57, 14);
		contentPane.add(lblPrecoProduto);
		
		tfQuantidadeProduto = new JTextField();
		tfQuantidadeProduto.setColumns(10);
		tfQuantidadeProduto.setBounds(702, 33, 57, 23);
		contentPane.add(tfQuantidadeProduto);
		
		JLabel lblQuantidadeProduto = new JLabel("Quantidade");
		lblQuantidadeProduto.setBounds(702, 17, 76, 14);
		contentPane.add(lblQuantidadeProduto);
		
		tableVendas = new JTable();
		tableVendas.setToolTipText("");
		tableVendas.setBounds(10, 375, 1019, 235);
		contentPane.add(tableVendas);
		
		JLabel lblTabelaDeVendas = new JLabel("Tabela de Vendas:");
		lblTabelaDeVendas.setBounds(10, 351, 103, 24);
		contentPane.add(lblTabelaDeVendas);
	}

	private static class __Tmp {
		private static void __tmp() {
			javax.swing.JPanel __wbp_panel = new javax.swing.JPanel();
		}
	}
}
