package visual;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PantallaInicio extends JFrame {

    private JPanel contentPane;
    private Dimension dim;

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
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 734, 420);
        dim = getToolkit().getScreenSize();
        setSize(dim.width, dim.height - 10);
        setLocationRelativeTo(null);

        contentPane = new JPanel();
        contentPane.setBackground(Color.LIGHT_GRAY);
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblNewLabel = new JLabel("CLÍNICA PRIVADA ALONSO");
        lblNewLabel.setForeground(new Color(47, 79, 79));
        lblNewLabel.setFont(new Font("Verdana", Font.BOLD, 25));
        lblNewLabel.setBounds(116, 42, 632, 48);
        contentPane.add(lblNewLabel);

        ImageIcon originalIcon = new ImageIcon(PantallaInicio.class.getResource("/visual/logoClinica.png"));
        Image scaledImage = originalIcon.getImage().getScaledInstance(70, 70, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(scaledImage);
        JLabel lblImagen = new JLabel(scaledIcon);
        lblImagen.setBounds(31, 32, 70, 70);
        contentPane.add(lblImagen);

        JLabel lblBienvenidosAlSistema = new JLabel("Bienvenidos al Sistema de CPA");
        lblBienvenidosAlSistema.setForeground(new Color(47, 79, 79));
        lblBienvenidosAlSistema.setFont(new Font("Verdana", Font.BOLD, 30));
        lblBienvenidosAlSistema.setBounds(303, 145, 632, 48);
        contentPane.add(lblBienvenidosAlSistema);

        JRadioButton rdbtnRegular = new JRadioButton("Trabajador regular");
        rdbtnRegular.setFont(new Font("Verdana", Font.BOLD, 16));
        rdbtnRegular.setBackground(new Color(192, 192, 192));
        rdbtnRegular.setBounds(126, 429, 211, 29);
        contentPane.add(rdbtnRegular);

        JRadioButton rdbtnMedico = new JRadioButton("Medicos Consultantes");
        rdbtnMedico.setFont(new Font("Verdana", Font.BOLD, 16));
        rdbtnMedico.setBackground(new Color(192, 192, 192));
        rdbtnMedico.setBounds(388, 429, 230, 29);
        contentPane.add(rdbtnMedico);

        JRadioButton rdbtnAdmin = new JRadioButton("Administradores");
        rdbtnAdmin.setFont(new Font("Verdana", Font.BOLD, 16));
        rdbtnAdmin.setBackground(new Color(192, 192, 192));
        rdbtnAdmin.setBounds(673, 429, 190, 29);
        contentPane.add(rdbtnAdmin);

        // Agrupar los botones de radio para que solo uno esté seleccionado a la vez
        ButtonGroup group = new ButtonGroup();
        group.add(rdbtnRegular);
        group.add(rdbtnMedico);
        group.add(rdbtnAdmin);

        JLabel lblSeleccionaQuienEres = new JLabel("Selecciona quien eres:");
        lblSeleccionaQuienEres.setForeground(new Color(47, 79, 79));
        lblSeleccionaQuienEres.setFont(new Font("Verdana", Font.BOLD, 18));
        lblSeleccionaQuienEres.setBounds(116, 358, 632, 48);
        contentPane.add(lblSeleccionaQuienEres);

        JButton btnSiguiente = new JButton("Siguiente");
        btnSiguiente.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		if(rdbtnAdmin.isSelected()) {
        			LoginAdmin logadm = new LoginAdmin();
        			logadm.setVisible(true);
        		} else if(rdbtnMedico.isSelected()) {
        			LoginMedico logmed = new LoginMedico();
        			logmed.setVisible(true);
        		}else {
        			LoginTrabajador logregular = new LoginTrabajador();
        			logregular.setVisible(true);
        		}
        	}
        });
        btnSiguiente.setForeground(new Color(230, 230, 250));
        btnSiguiente.setFont(new Font("Verdana", Font.BOLD, 17));
        btnSiguiente.setBackground(new Color(47, 79, 79));
        btnSiguiente.setBounds(959, 430, 159, 29);
        contentPane.add(btnSiguiente);
    }
}
