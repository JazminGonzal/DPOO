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

import logico.ClinicaMedica;
import logico.Medico;
import logico.Usuario;

import javax.swing.JButton;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.awt.event.ActionEvent;

public class PantallaInicio extends JFrame {

    private JPanel contentPane;
    private Dimension dim;
    private JTextField textField;
	private JPasswordField passwordField;
    private static final String FILE_NAME = "usuarios.dat";
	
    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    ClinicaMedica.getInstance().cargarDatos(); // Cargar datos antes de mostrar la pantalla
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
		setTitle("Sistema Clínica Privada Alonso");
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
		lblBienvenidosAlSistema.setBounds(676, 89, 515, 48);
		contentPane.add(lblBienvenidosAlSistema);
		
		JLabel lblSeleccionaQuienEres = new JLabel("Login");
		lblSeleccionaQuienEres.setForeground(new Color(47, 79, 79));
		lblSeleccionaQuienEres.setFont(new Font("Verdana", Font.BOLD, 26));
		lblSeleccionaQuienEres.setBounds(930, 241, 90, 48);
		contentPane.add(lblSeleccionaQuienEres);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(47, 79, 79));
		panel.setBounds(0, 0, 468, 1334);
		contentPane.add(panel);
				panel.setLayout(null);
		
				// Agregar la imagen redimensionada a un JLabel
				JLabel lblImagen = new JLabel(scaledIcon);
				lblImagen.setBounds(141, 370, 154, 148);
				panel.add(lblImagen);
				
						JLabel lblNewLabel = new JLabel(" CL\u00CDNICA");
						lblNewLabel.setBounds(141, 198, 154, 48);
						panel.add(lblNewLabel);
						lblNewLabel.setForeground(new Color(255, 255, 255));
						lblNewLabel.setFont(new Font("Verdana", Font.BOLD, 30));
						
						JLabel lblPrivada = new JLabel("PRIVADA");
						lblPrivada.setForeground(Color.WHITE);
						lblPrivada.setFont(new Font("Verdana", Font.BOLD, 30));
						lblPrivada.setBounds(149, 247, 168, 48);
						panel.add(lblPrivada);
						
						JLabel lblAlonso = new JLabel(" ALONSO");
						lblAlonso.setForeground(Color.WHITE);
						lblAlonso.setFont(new Font("Verdana", Font.BOLD, 30));
						lblAlonso.setBounds(141, 296, 154, 48);
						panel.add(lblAlonso);
						
						JLabel lblNewLabel_1 = new JLabel("Usuario:");
						lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 18));
						lblNewLabel_1.setBounds(789, 313, 76, 20);
						contentPane.add(lblNewLabel_1);
						
						textField = new JTextField();
						textField.setBounds(880, 311, 214, 26);
						contentPane.add(textField);
						textField.setColumns(10);
						
						passwordField = new JPasswordField();
						passwordField.setBounds(880, 392, 214, 26);
						contentPane.add(passwordField);
						
						JLabel lblNewLabel_2 = new JLabel("Contrasena:");
						lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 18));
						lblNewLabel_2.setBounds(754, 394, 111, 20);
						contentPane.add(lblNewLabel_2);
						
						JButton btnNewButton = new JButton("Ingresar");
						btnNewButton.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								validarCredenciales();
							}
						});
						btnNewButton.setBounds(930, 462, 115, 29);
						contentPane.add(btnNewButton);
						
						
						verificarArchivoYUsuario();
    }
    
    
    
    private void verificarArchivoYUsuario() {
        try {
            File archivo = new File(FILE_NAME);
            List<Usuario> usuarios = new ArrayList<>();

            // Verificar si el archivo existe y leer los usuarios
            if (archivo.exists()) {
                try (ObjectInputStream ois = new ObjectInputStream(new java.io.FileInputStream(archivo))) {
                    usuarios = (List<Usuario>) ois.readObject();
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(this, "Error al leer el archivo de usuarios: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            }

            // Verificar si el usuario admin existe
            boolean adminExiste = false;
            for (Usuario usuario : usuarios) {
                if ("admin".equals(usuario.getUsuario())) {
                    adminExiste = true;
                    break;
                }
            }

            // Si no existe, agregar el usuario admin
            if (!adminExiste) {
                Usuario admin = new Usuario("admin", "password", "admin");
                usuarios.add(admin);
                try (ObjectOutputStream oos = new ObjectOutputStream(new java.io.FileOutputStream(archivo))) {
                    oos.writeObject(usuarios);
                }
                JOptionPane.showMessageDialog(this, "Usuario admin creado con éxito.");
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Error al manejar el archivo de usuarios: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }



    private void validarCredenciales() {
        String usuario = textField.getText().trim();
        String contrasena = new String(passwordField.getPassword()).trim();
        
        if (usuario.isEmpty() || contrasena.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Por favor, complete todos los campos.", "Advertencia", JOptionPane.WARNING_MESSAGE);
            return;
        }

        boolean usuarioExiste = false;
        boolean contrasenaCorrecta = false;
        String rol = "";

        try (ObjectInputStream ois = new ObjectInputStream(new java.io.FileInputStream(FILE_NAME))) {
            // Leer los usuarios del archivo
            List<Usuario> usuarios = (List<Usuario>) ois.readObject();
            
            // Buscar el usuario
            for (Usuario u : usuarios) {
                if (u.getUsuario().equals(usuario)) {
                    usuarioExiste = true;
                    if (u.getPassword().equals(contrasena)) {
                        contrasenaCorrecta = true;
                        rol = u.getRango();
                    }
                    break;
                }
            }
        } catch (FileNotFoundException e) {
            JOptionPane.showMessageDialog(this, "Archivo no encontrado: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            return;
        } catch (IOException | ClassNotFoundException e) {
            JOptionPane.showMessageDialog(this, "Error al leer el archivo de usuarios: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (!usuarioExiste) {
            JOptionPane.showMessageDialog(this, "El nombre de usuario no existe.", "Error", JOptionPane.ERROR_MESSAGE);
        } else if (!contrasenaCorrecta) {
            JOptionPane.showMessageDialog(this, "Contraseña incorrecta.", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            
            switch (rol) {
                case "admin":
                    JOptionPane.showMessageDialog(this, "Bienvenido, Administrador", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
                    new MenuAdmin().setVisible(true);
                    dispose();
                    break;
                case "regular":
                    JOptionPane.showMessageDialog(this, "Bienvenido, Trabajador Regular", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
                    new MenuRegular().setVisible(true);
                    dispose();
                    break;
                case "medico":
                	Medico medico = ClinicaMedica.getInstance().buscarMedicoByCod(usuario);
                    JOptionPane.showMessageDialog(this, "Bienvenido, Doctor "+medico.getNombre(), "Mensaje", JOptionPane.INFORMATION_MESSAGE);
                    new MenuDoctor(usuario).setVisible(true);
                    dispose();
                    break;
                default:
                    JOptionPane.showMessageDialog(this, "Rol desconocido.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
            }
            dispose(); // Cierra la pantalla de inicio
        }
    }


}
