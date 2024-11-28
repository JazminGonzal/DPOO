package visual;

import java.awt.BorderLayout;
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
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import logico.ClinicaMedica;
import logico.Medico;

public class LoginMedico extends JFrame {

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
                    LoginMedico frame = new LoginMedico();
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
    public LoginMedico() {
        setBackground(SystemColor.menu);
        setTitle("Login Medico");
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

        JLabel lblNewLabel = new JLabel("LOGIN MEDICO");
        lblNewLabel.setForeground(new Color(47, 79, 79));
        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 28));
        lblNewLabel.setBounds(227, 51, 239, 59);
        panel.add(lblNewLabel);

        JLabel lblNewLabel_1 = new JLabel("Código Médico:");
        lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 18));
        lblNewLabel_1.setBounds(114, 200, 185, 20);
        panel.add(lblNewLabel_1);

        JLabel lblNewLabel_2 = new JLabel("Contraseña:");
        lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 18));
        lblNewLabel_2.setBounds(114, 295, 115, 20);
        panel.add(lblNewLabel_2);

        txtUsuario = new JTextField();
        txtUsuario.setBounds(253, 198, 225, 26);
        panel.add(txtUsuario);
        txtUsuario.setColumns(10);

        pfContrasena = new JPasswordField();
        pfContrasena.setBounds(220, 293, 258, 26);
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
                String codigo = txtUsuario.getText();
                String contrasena = new String(pfContrasena.getPassword());

                Medico medico = ClinicaMedica.getInstance().buscarMedicoByCod(codigo);

                if (medico != null && contrasena.equals("1234")) {
                	dispose();
                    ConsultasPorMedico consultas = new ConsultasPorMedico(codigo);   
                    consultas.setModal(true);
                    consultas.setVisible(true);
                    dispose();
                } else {
                    JOptionPane.showMessageDialog(null, "Código o contraseña incorrectos.", "Error", JOptionPane.ERROR_MESSAGE);
                }
                
                dispose();
            }
        });

        btnLogin.setFont(new Font("Tahoma", Font.BOLD, 16));
        btnLogin.setBounds(264, 430, 126, 36);
        panel.add(btnLogin);
        
        JButton button = new JButton("Cancelar");
        button.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		dispose();
        	}
        });
        button.setFont(new Font("Tahoma", Font.BOLD, 16));
        button.setBounds(507, 483, 126, 36);
        panel.add(button);
    }
}
