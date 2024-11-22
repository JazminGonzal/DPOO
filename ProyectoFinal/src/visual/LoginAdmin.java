package visual;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JSeparator;
import javax.swing.JButton;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LoginAdmin extends JFrame {

	private JPanel contentPane;
	private JTextField txtUsuario;
	private JPasswordField pfContrasena;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginAdmin frame = new LoginAdmin();
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
	public LoginAdmin() {
		setBackground(SystemColor.menu);
		setTitle("Login Administrador");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 680, 601);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.menu);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.menu);
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("LOGIN ADMINISTRADOR");
		lblNewLabel.setForeground(new Color(47, 79, 79));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 28));
		lblNewLabel.setBounds(140, 51, 379, 59);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Usuario:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_1.setBounds(114, 200, 85, 20);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Contrase\u00F1a:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_2.setBounds(84, 295, 115, 20);
		panel.add(lblNewLabel_2);
		
		txtUsuario = new JTextField();
		txtUsuario.setBounds(214, 198, 264, 26);
		panel.add(txtUsuario);
		txtUsuario.setColumns(10);
		
		pfContrasena = new JPasswordField();
		pfContrasena.setBounds(214, 293, 264, 26);
		panel.add(pfContrasena);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(56, 126, 527, 2);
		panel.add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(56, 391, 515, 2);
		panel.add(separator_1);
		
		JButton btnLogin = new JButton("Ingresar");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String contrasenaIngresada = new String(pfContrasena.getPassword());
				String usuarioIngresado = new String(txtUsuario.getText());
				
				if( usuarioIngresado.equals("admin") && contrasenaIngresada.equals("1234")) {
					//JOptionPane.showMessageDialog(null, "Login Exitoso", "Éxito", JOptionPane.INFORMATION_MESSAGE);
					
				} else {
					JOptionPane.showMessageDialog(null, "Usuario o Contraseña Incorrectos", "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnLogin.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnLogin.setBounds(264, 430, 126, 36);
		panel.add(btnLogin);
	}
}
