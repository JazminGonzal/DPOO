package visual;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import logico.ClinicaMedica;

public class MenuDoctor extends JFrame {

	private JPanel contentPane;
	private JLabel lblClinico;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuDoctor frame = new MenuDoctor(null);
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
	public MenuDoctor(String codMedico) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 846, 463);
		Dimension dim = getToolkit().getScreenSize();
		setSize(dim.width, dim.height - 10);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		ImageIcon originalIcon = new ImageIcon(PantallaInicio.class.getResource("/visual/logoClinica.png"));
		Image scaledImage = originalIcon.getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH);
		ImageIcon scaledIcon = new ImageIcon(scaledImage);
		contentPane.setLayout(null);
		//contentPane.add(lblImagen);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setMaximumSize(new Dimension(0, 10));
		menuBar.setBounds(0, 0, 1898, 85);
		contentPane.add(menuBar);
		menuBar.setBackground(new Color(47, 79, 79));
		
		JMenu mnCitas = new JMenu("   Citas   ");
		mnCitas.setSize(new Dimension(0, 10));
		mnCitas.setMinimumSize(new Dimension(0, 10));
		mnCitas.setForeground(new Color(240, 248, 255));
		mnCitas.setBackground(new Color(47, 79, 79));
		mnCitas.setFont(new Font("Segoe UI", Font.PLAIN, 25));
		menuBar.add(mnCitas);
		
		JMenuItem mntmListarCitas = new JMenuItem("   Listar Mis Citas");
		mntmListarCitas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ConsultasPorMedico conMed = new ConsultasPorMedico(codMedico);
				conMed.setModal(true);
				conMed.setVisible(true);
			}
		});
		mntmListarCitas.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		mnCitas.add(mntmListarCitas);
		
		JMenu mnPacientes = new JMenu("   Pacientes   ");
		mnPacientes.setForeground(new Color(240, 248, 255));
		mnPacientes.setBackground(new Color(47, 79, 79));
		mnPacientes.setFont(new Font("Segoe UI", Font.PLAIN, 25));
		menuBar.add(mnPacientes);
		
		JMenuItem mntmListarPacientes = new JMenuItem("   Listar Mis Pacientes");
		mntmListarPacientes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(ClinicaMedica.getInstance().getListaPacientes().isEmpty()) {
					JOptionPane.showMessageDialog(null, "No hay pacientes registrados. Por favor, registre uno primero.", "Advertencia", JOptionPane.WARNING_MESSAGE);
				}
				else {
				PacientePorMedico listaPacientes = new PacientePorMedico(codMedico);
				listaPacientes.setModal(true);
				listaPacientes.setVisible(true);
				}
			}
		});
		mntmListarPacientes.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		mnPacientes.add(mntmListarPacientes);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBackground(new Color(47, 79, 79));
		panel.setBounds(0, dim.height-150, 1898, 96);
		contentPane.add(panel);
		
		JButton button = new JButton("Volver a pantalla de Inicio");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PantallaInicio pantInicio = new PantallaInicio();
				pantInicio.setVisible(true);
				dispose();
			}
		});
		button.setBounds(15, 31, 282, 29);
		panel.add(button);
		
		lblClinico = new JLabel("                                                                CL\u00CDNICA PRIVADA ALONSO   ");
		lblClinico.setForeground(Color.WHITE);
		lblClinico.setFont(new Font("Verdana", Font.BOLD, 22));
		lblClinico.setBounds(726, 260, 460, 48);
		//contentPane.add(label);
		
		menuBar.add(lblClinico);
		JLabel lblImagen = new JLabel(scaledIcon);
		menuBar.add(lblImagen);
	}
}
