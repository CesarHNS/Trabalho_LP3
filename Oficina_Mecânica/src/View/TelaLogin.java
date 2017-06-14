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
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import java.sql.*;
import dal.ModuloConexao;
import model.Login;
import control.LoginControl;

import javax.swing.ImageIcon;
import java.awt.Frame;

public class TelaLogin extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public JTextField txtLogin;
	public JPasswordField txtPassword;
	Connection conexao = null;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaLogin frame = new TelaLogin();
					frame.setVisible(true);
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
	public TelaLogin() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// fecha todas as janelas
														// quando clico no X
		setBounds(100, 100, 350, 450);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.scrollbar);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.controlShadow);
		panel.setBounds(0, 0, 344, 421);
		contentPane.add(panel);
		panel.setLayout(null);

		JButton btnNewButton = new JButton("Entrar");
		btnNewButton.setBounds(75, 231, 77, 23);
		panel.add(btnNewButton);

		txtPassword = new JPasswordField();
		txtPassword.setToolTipText("Digite sua senha aqui\r\n");
		txtPassword.setBounds(75, 184, 182, 20);
		panel.add(txtPassword);

		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblPassword.setForeground(Color.WHITE);
		lblPassword.setBounds(75, 159, 46, 14);
		panel.add(lblPassword);

		txtLogin = new JTextField();
		txtLogin.setToolTipText("Digite sua Login aqui\r\n");
		txtLogin.setBounds(75, 114, 187, 20);
		panel.add(txtLogin);
		txtLogin.setColumns(10);

		JLabel lblNewLabel = new JLabel("Login");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBounds(75, 89, 46, 14);
		panel.add(lblNewLabel);

		JLabel lblStatus = new JLabel("");
		lblStatus.setIcon(new ImageIcon(TelaLogin.class.getResource("/icones/dbOk.png")));
		lblStatus.setBounds(286, 348, 38, 38);
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
				LoginControl LoginControl = new LoginControl();
				Login l = new Login();

				l.setLogin(txtLogin.getText());
				l.setPassword(txtPassword.getText());

				// chamando o método da classe logar da classe LoginControl
				LoginControl.logar(l);
				setLocationRelativeTo(null);
				dispose();
			}

		});

	}

}
