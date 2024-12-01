package visual;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.SystemColor;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;

import javax.swing.JButton;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PantallaInicio extends JFrame {

    private JPanel contentPane;
    private Dimension dim;
    private JTextField textField;
	private JPasswordField passwordField;
	
    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    PantallaInicio frame = new PantallaInicio();
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
    public PantallaInicio() {
		setTitle("Sistema Clinica Privada Alonso");
		setBackground(new Color(240, 255, 255));
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 734, 420);
		dim = getToolkit().getScreenSize();
		setSize(dim.width, dim.height - 10);
		setLocationRelativeTo(null);
		
		
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.menu);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		// Cargar la imagen original
		ImageIcon originalIcon = new ImageIcon(PantallaInicio.class.getResource("logoClinica.png"));

		// Escalar la imagen al tamaño deseado
		Image scaledImage = originalIcon.getImage().getScaledInstance(154, 148, Image.SCALE_SMOOTH);
		ImageIcon scaledIcon = new ImageIcon(scaledImage);
		
		JLabel lblBienvenidosAlSistema = new JLabel("Bienvenido al Sistema de CPA");
		lblBienvenidosAlSistema.setForeground(new Color(47, 79, 79));
		lblBienvenidosAlSistema.setFont(new Font("Verdana", Font.BOLD, 30));
		lblBienvenidosAlSistema.setBounds(743, 214, 515, 48);
		contentPane.add(lblBienvenidosAlSistema);
		
		JLabel lblSeleccionaQuienEres = new JLabel("Login");
		lblSeleccionaQuienEres.setForeground(new Color(47, 79, 79));
		lblSeleccionaQuienEres.setFont(new Font("Verdana", Font.BOLD, 26));
		lblSeleccionaQuienEres.setBounds(930, 337, 90, 48);
		contentPane.add(lblSeleccionaQuienEres);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(47, 79, 79));
		panel.setBounds(0, 0, 468, 1334);
		contentPane.add(panel);
				panel.setLayout(null);
		
				// Agregar la imagen redimensionada a un JLabel
				JLabel lblImagen = new JLabel(scaledIcon);
				lblImagen.setBounds(133, 490, 154, 148);
				panel.add(lblImagen);
				
						JLabel lblNewLabel = new JLabel(" CL\u00CDNICA");
						lblNewLabel.setBounds(141, 318, 154, 48);
						panel.add(lblNewLabel);
						lblNewLabel.setForeground(new Color(255, 255, 255));
						lblNewLabel.setFont(new Font("Verdana", Font.BOLD, 30));
						
						JLabel lblPrivada = new JLabel("PRIVADA");
						lblPrivada.setForeground(Color.WHITE);
						lblPrivada.setFont(new Font("Verdana", Font.BOLD, 30));
						lblPrivada.setBounds(141, 367, 168, 48);
						panel.add(lblPrivada);
						
						JLabel lblAlonso = new JLabel(" ALONSO");
						lblAlonso.setForeground(Color.WHITE);
						lblAlonso.setFont(new Font("Verdana", Font.BOLD, 30));
						lblAlonso.setBounds(141, 415, 154, 48);
						panel.add(lblAlonso);
						
						JLabel lblNewLabel_1 = new JLabel("Usuario:");
						lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 18));
						lblNewLabel_1.setBounds(789, 409, 76, 20);
						contentPane.add(lblNewLabel_1);
						
						textField = new JTextField();
						textField.setBounds(880, 407, 214, 26);
						contentPane.add(textField);
						textField.setColumns(10);
						
						passwordField = new JPasswordField();
						passwordField.setBounds(880, 488, 214, 26);
						contentPane.add(passwordField);
						
						JLabel lblNewLabel_2 = new JLabel("Contrasena:");
						lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 18));
						lblNewLabel_2.setBounds(754, 490, 111, 20);
						contentPane.add(lblNewLabel_2);
						
						JButton btnNewButton = new JButton("Ingresar");
						btnNewButton.setBounds(930, 558, 115, 29);
						contentPane.add(btnNewButton);
    }
}
