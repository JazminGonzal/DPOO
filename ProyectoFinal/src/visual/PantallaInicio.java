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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;

import javax.swing.JButton;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.awt.event.ActionEvent;

public class PantallaInicio extends JFrame {

    private JPanel contentPane;
    private Dimension dim;
    private JTextField textField;
	private JPasswordField passwordField;
    private static final String FILE_NAME = "usuarios.txt";
	
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
						btnNewButton.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								validarCredenciales();
							}
						});
						btnNewButton.setBounds(930, 558, 115, 29);
						contentPane.add(btnNewButton);
						
						
						verificarArchivoYUsuario();
    }
    
    
    
    private void verificarArchivoYUsuario() {
        try {
            File archivo = new File(FILE_NAME);
            if (!archivo.exists()) {
                archivo.createNewFile();
                try (FileWriter writer = new FileWriter(archivo, true)) {
                    writer.write("admin,password,admin\n"); // Usuario predeterminado
                }
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Error al crear el archivo: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void validarCredenciales() {
        String usuario = textField.getText();
        String contrasena = new String(passwordField.getPassword());
        boolean credencialesValidas = false;
        String rol = "";

        try (Scanner scanner = new Scanner(new File(FILE_NAME))) {
            while (scanner.hasNextLine()) {
                String linea = scanner.nextLine();
                String[] datos = linea.split(",");
                if (datos.length == 3 && datos[0].equals(usuario) && datos[1].equals(contrasena)) {
                    credencialesValidas = true;
                    rol = datos[2];
                    break;
                }
            }
        } catch (FileNotFoundException e) {
            JOptionPane.showMessageDialog(this, "Archivo no encontrado: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }

        if (credencialesValidas) {
            if ("admin".equals(rol)) {
                JOptionPane.showMessageDialog(this, "Bienvenido, Administrador");
                new MenuAdmin().setVisible(true);
                dispose();
            } else if("regular".equals(rol)) {
                JOptionPane.showMessageDialog(this, "Bienvenido, Trabajador Regular");
                new MenuRegular().setVisible(true);
                dispose();
            }
        	 else if("medico".equals(rol)) {
            JOptionPane.showMessageDialog(this, "Bienvenido, Doctor");
            new ConsultasPorMedico(textField.getText()).setVisible(true);
            dispose();
        }
        } else {
            JOptionPane.showMessageDialog(this, "Credenciales incorrectas", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
