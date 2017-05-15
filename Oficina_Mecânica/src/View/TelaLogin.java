package view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import java.sql.*;
import dal.ModuloConexao;
import javax.swing.ImageIcon;

import view.TelaControle;

public class TelaLogin extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtLogin;
	private JPasswordField txtPassword;
	Connection conexao = null;
	PreparedStatement pst = null;
	ResultSet rs = null;

	/************************************************************************
	 * Este método procura o Usuário no banco e faz o login se encotrá-lo
	 ***********************************************************************/
	public void logar() {
		String sql = "select * from funcionarios where login_func=? and senha_func =?";
		try {
			// as linhas abaixo preparam a consulta ao banco em
			// função do que foi digitado nas caixas de texto
			// o ? é substituido pelo conteúdo das variáveis.
			pst = conexao.prepareStatement(sql);
			pst.setString(1, txtLogin.getText());
			pst.setString(2, txtPassword.getText());
			// a linha abaixo executa a query(consulta a banco de dados)
			rs = pst.executeQuery();
			// se existir usuário e senha correspondente
			if (rs.next() && txtLogin.getText() != "admin") {

				TelaControle ObjTelaControle = new TelaControle();
				ObjTelaControle.setVisible(true);
				// fecha a tela de login quando a tela de controle é aberta
				this.dispose();
				conexao.close();
			} else {
				JOptionPane.showMessageDialog(null, "Usuário e/ou senha inválido(s)");
			}

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e);
		}
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaLogin frame = new TelaLogin();
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
	public TelaLogin() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// fecha todas as janelas
														// quando clico no X
		setBounds(100, 100, 1280, 720);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.scrollbar);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.controlShadow);
		panel.setBounds(526, 217, 232, 290);
		contentPane.add(panel);
		panel.setLayout(null);

		JButton btnNewButton = new JButton("Entrar");
		btnNewButton.setBounds(23, 173, 77, 23);
		panel.add(btnNewButton);

		txtPassword = new JPasswordField();
		txtPassword.setToolTipText("Digite sua senha aqui\r\n");
		txtPassword.setBounds(23, 126, 182, 20);
		panel.add(txtPassword);

		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblPassword.setForeground(Color.WHITE);
		lblPassword.setBounds(23, 101, 46, 14);
		panel.add(lblPassword);

		txtLogin = new JTextField();
		txtLogin.setToolTipText("Digite sua Login aqui\r\n");
		txtLogin.setBounds(23, 56, 187, 20);
		panel.add(txtLogin);
		txtLogin.setColumns(10);

		JLabel lblNewLabel = new JLabel("Login");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBounds(23, 31, 46, 14);
		panel.add(lblNewLabel);

		JLabel lblStatus = new JLabel("");
		lblStatus.setIcon(new ImageIcon(TelaLogin.class.getResource("/icones/dbOk.png")));
		lblStatus.setBounds(184, 241, 38, 38);
		panel.add(lblStatus);

		conexao = ModuloConexao.conector();
		if (conexao != null) {
			lblStatus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/dbOk.png")));
		} else {
			lblStatus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/dbError.png")));

		}

		btnNewButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// utilizando o metódo logar ao clicar no botão "Entrar"
				logar();

			}

		});

	}

}
