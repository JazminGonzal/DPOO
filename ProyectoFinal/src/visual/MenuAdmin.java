package visual;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import java.awt.Color;
import javax.swing.JMenu;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.border.LineBorder;

import logico.ClinicaMedica;


import javax.swing.JButton;
import java.awt.Insets;
import java.awt.SystemColor;

public class MenuAdmin extends JFrame {

	private JPanel contentPane;
	private Dimension dim;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuAdmin frame = new MenuAdmin();
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
	public MenuAdmin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		dim = getToolkit().getScreenSize();
		setSize(dim.width, dim.height - 10);
		setLocationRelativeTo(null);
		
		JLabel lblClinica = new JLabel("        CL\u00CDNICA PRIVADA ALONSO ");
		lblClinica.setForeground(SystemColor.menu);
		lblClinica.setFont(new Font("Verdana", Font.BOLD, 22));
		lblClinica.setBounds(969, 70, 407, 48);
		//contentPane.add(lblClinica);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setMaximumSize(new Dimension(0, 10));
		menuBar.setBackground(new Color(47, 79, 79));
		menuBar.setBounds(0, 0, 1898, 85);
		contentPane.add(menuBar);
		
		JMenu menu = new JMenu("   Citas   ");
		menu.setSize(new Dimension(0, 10));
		menu.setMinimumSize(new Dimension(0, 10));
		menu.setForeground(new Color(240, 248, 255));
		menu.setFont(new Font("Segoe UI", Font.PLAIN, 21));
		menu.setBackground(new Color(47, 79, 79));
		menuBar.add(menu);
		
		JMenuItem menuItem = new JMenuItem("   Realizar Cita");
		menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				if(ClinicaMedica.getInstance().getListaMedicos().isEmpty()) {
					JOptionPane.showMessageDialog(null, "No hay médicos registrados. Por favor, registre uno primero antes de crear una cita.", "Advertencia", JOptionPane.WARNING_MESSAGE);
				}
				else {
					RegistrarCita regCita = new RegistrarCita();
					regCita.setModal(true);
					regCita.setVisible(true);
				}
			}
		});
		menuItem.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		menu.add(menuItem);
		
		JMenu menu_1 = new JMenu("   Pacientes   ");
		menu_1.setForeground(new Color(240, 248, 255));
		menu_1.setFont(new Font("Segoe UI", Font.PLAIN, 21));
		menu_1.setBackground(new Color(47, 79, 79));
		menuBar.add(menu_1);
		
		JMenuItem mntmRegistrarPacientes = new JMenuItem("   Registrar Pacientes");
		mntmRegistrarPacientes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RegistrarPaciente regPaciente = new RegistrarPaciente(null);
				regPaciente.setModal(true);
				regPaciente.setVisible(true);
				
			}
		});
		mntmRegistrarPacientes.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		menu_1.add(mntmRegistrarPacientes);
		
		JMenuItem menuItem_2 = new JMenuItem("   Listar Pacientes");
		menuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(ClinicaMedica.getInstance().getListaPacientes().isEmpty()) {
					JOptionPane.showMessageDialog(null, "No hay pacientes registrados. Por favor, registre uno primero.", "Advertencia", JOptionPane.WARNING_MESSAGE);
				}
				else {
				ListarPaciente listaPacientes = new ListarPaciente();
				listaPacientes.setModal(true);
				listaPacientes.setVisible(true);
				}
				
			}
		});
		menuItem_2.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		menu_1.add(menuItem_2);
		
		JMenu menu_2 = new JMenu("   M\u00E9dicos   ");
		menu_2.setForeground(new Color(240, 248, 255));
		menu_2.setFont(new Font("Segoe UI", Font.PLAIN, 21));
		menu_2.setBackground(new Color(47, 79, 79));
		menuBar.add(menu_2);
		
		JMenuItem mntmRegistrarPacientes_1 = new JMenuItem("   Registrar M\u00E9dicos");
		mntmRegistrarPacientes_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RegistrarMedico regMed = new RegistrarMedico(null);
				regMed.setModal(true);
				regMed.setVisible(true);
			}
		});
		mntmRegistrarPacientes_1.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		menu_2.add(mntmRegistrarPacientes_1);
		
		JMenuItem menuItem_3 = new JMenuItem("   Listar M\u00E9dicos");
		menuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(ClinicaMedica.getInstance().getListaMedicos().isEmpty()) {
					JOptionPane.showMessageDialog(null, "No hay médicos registrados. Por favor, registre uno primero.", "Advertencia", JOptionPane.WARNING_MESSAGE);
				}
				else {
				ListarMedico listaMedicos = new ListarMedico();
				listaMedicos.setModal(true);
				listaMedicos.setVisible(true);
				}
			}
		});
		menuItem_3.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		menu_2.add(menuItem_3);
		
		JMenu mnVacunas = new JMenu("   Vacunas   ");
		mnVacunas.setForeground(new Color(240, 248, 255));
		mnVacunas.setFont(new Font("Segoe UI", Font.PLAIN, 21));
		mnVacunas.setBackground(new Color(47, 79, 79));
		menuBar.add(mnVacunas);
		
		JMenuItem mntmRegistrarVacunas = new JMenuItem("   Registrar Vacunas");
		mntmRegistrarVacunas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RegistrarVacunas regVacuna = new RegistrarVacunas(null);
				regVacuna.setModal(true);
				regVacuna.setVisible(true);
			}
		});
		mntmRegistrarVacunas.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		mnVacunas.add(mntmRegistrarVacunas);
		
		JMenuItem mntmListarVacunas = new JMenuItem("   Listar Vacunas");
		mntmListarVacunas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(ClinicaMedica.getInstance().getListaVacunas().isEmpty()) {
					JOptionPane.showMessageDialog(null, "No hay vacunas registradas. Por favor, registre una primero.", "Advertencia", JOptionPane.WARNING_MESSAGE);
				}
				else {
				ListarVacunas listaVacuna = new ListarVacunas();
				listaVacuna.setModal(true);
				listaVacuna.setVisible(true);
				}
			}
		});
		mntmListarVacunas.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		mnVacunas.add(mntmListarVacunas);
		
		JMenu mnEnfermedades = new JMenu("   Enfermedades   ");
		mnEnfermedades.setForeground(new Color(240, 248, 255));
		mnEnfermedades.setFont(new Font("Segoe UI", Font.PLAIN, 21));
		mnEnfermedades.setBackground(new Color(47, 79, 79));
		menuBar.add(mnEnfermedades);
		
		JMenuItem mntmRegistrarVacs = new JMenuItem("   Registrar Enfermedades");
		mntmRegistrarVacs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RegistrarEnfermedades regEnfermedad = new RegistrarEnfermedades(null);
				regEnfermedad.setModal(true);
				regEnfermedad.setVisible(true);
				
			}
		});
		mntmRegistrarVacs.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		mnEnfermedades.add(mntmRegistrarVacs);
		
		JMenuItem mntmListarEnfermedades = new JMenuItem("   Listar Enfermedades");
		mntmListarEnfermedades.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(ClinicaMedica.getInstance().getListaEnfermedad().isEmpty()) {
					JOptionPane.showMessageDialog(null, "No hay enfermedades registradas. Por favor, registre una primero.", "Advertencia", JOptionPane.WARNING_MESSAGE);
				}
				else {
				ListarEnfermedades listaEnfermedad = new ListarEnfermedades();
				listaEnfermedad.setModal(true);
				listaEnfermedad.setVisible(true);
				}
			}
		});
		mntmListarEnfermedades.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		mnEnfermedades.add(mntmListarEnfermedades);
		

        ImageIcon originalIcon = new ImageIcon(PantallaInicio.class.getResource("/visual/logoClinica.png"));
        Image scaledImage = originalIcon.getImage().getScaledInstance(70, 70, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(scaledImage);
        JLabel lblImagen = new JLabel(scaledIcon);
		lblImagen.setBounds(1366, 50, 79, 83);
		//contentPane.add(lblImagen);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(47, 79, 79));
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBounds(0, dim.height-150, 1898, 96);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton btnNewButton = new JButton("Volver a pantalla de Inicio");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				PantallaInicio pantInicio = new PantallaInicio();
				pantInicio.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setBounds(15, 31, 282, 29);
		panel.add(btnNewButton);
		
		JMenu mnNewMenu = new JMenu("Reportes");
		mnNewMenu.setFont(new Font("Segoe UI", Font.PLAIN, 21));
		mnNewMenu.setForeground(new Color(240, 248, 255));
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Pacientes");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(ClinicaMedica.getInstance().getListaPacientes().isEmpty() || ClinicaMedica.getInstance().getListaConsultas().isEmpty()) {
					JOptionPane.showMessageDialog(null, "No hay suficientes datos para generar el reporte.", "Advertencia", JOptionPane.WARNING_MESSAGE);
				}
				else {
				ReportePacientes reportPaciente = new ReportePacientes();
				reportPaciente.setVisible(true);
				}
				
			}
		});
		mntmNewMenuItem.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		mnNewMenu.add(mntmNewMenuItem);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Medicos");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(ClinicaMedica.getInstance().getListaMedicos().isEmpty() || ClinicaMedica.getInstance().getListaConsultas().isEmpty()) {
					JOptionPane.showMessageDialog(null, "No hay suficientes datos para generar el reporte.", "Advertencia", JOptionPane.WARNING_MESSAGE);
				}
				else {
				ReporteMedicos reportMedico = new ReporteMedicos();
				reportMedico.setVisible(true);
				}
			}
		});
		mntmNewMenuItem_1.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		mnNewMenu.add(mntmNewMenuItem_1);
		
		JMenuItem mntmNewMenuItem_3 = new JMenuItem("Enfermedades");
		mntmNewMenuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(ClinicaMedica.getInstance().getListaEnfermedad().isEmpty()) {
					JOptionPane.showMessageDialog(null, "No hay suficientes datos para generar el reporte.", "Advertencia", JOptionPane.WARNING_MESSAGE);
				}
				else {
				ReporteEnfermedad reportEnfermedad = new ReporteEnfermedad();
				reportEnfermedad.setVisible(true);
				}
			}
		});
		mntmNewMenuItem_3.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		mnNewMenu.add(mntmNewMenuItem_3);
		
		menuBar.add(lblClinica);
		menuBar.add(lblImagen);

	}
}
