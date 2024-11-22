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
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

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
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setMaximumSize(new Dimension(0, 10));
		menuBar.setBackground(new Color(47, 79, 79));
		menuBar.setBounds(0, 0, 1898, 31);
		contentPane.add(menuBar);
		
		JMenu menu = new JMenu("   Citas   ");
		menu.setSize(new Dimension(0, 10));
		menu.setMinimumSize(new Dimension(0, 10));
		menu.setForeground(new Color(240, 248, 255));
		menu.setFont(new Font("Segoe UI", Font.PLAIN, 25));
		menu.setBackground(new Color(47, 79, 79));
		menuBar.add(menu);
		
		JMenuItem menuItem = new JMenuItem("   Realizar Cita");
		menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RegistrarCita regCita = new RegistrarCita();
				regCita.setModal(true);
				regCita.setVisible(true);
			}
		});
		menuItem.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		menu.add(menuItem);
		
		JMenuItem menuItem_1 = new JMenuItem("   Listar Citas");
		menuItem_1.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		menu.add(menuItem_1);
		
		JMenu menu_1 = new JMenu("   Pacientes   ");
		menu_1.setForeground(new Color(240, 248, 255));
		menu_1.setFont(new Font("Segoe UI", Font.PLAIN, 25));
		menu_1.setBackground(new Color(47, 79, 79));
		menuBar.add(menu_1);
		
		JMenuItem mntmRegistrarPacientes = new JMenuItem("   Registrar Pacientes");
		mntmRegistrarPacientes.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		menu_1.add(mntmRegistrarPacientes);
		
		JMenuItem menuItem_2 = new JMenuItem("   Listar Pacientes");
		menuItem_2.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		menu_1.add(menuItem_2);
		
		JMenu menu_2 = new JMenu("   M\u00E9dicos   ");
		menu_2.setForeground(new Color(240, 248, 255));
		menu_2.setFont(new Font("Segoe UI", Font.PLAIN, 25));
		menu_2.setBackground(new Color(47, 79, 79));
		menuBar.add(menu_2);
		
		JMenuItem mntmRegistrarPacientes_1 = new JMenuItem("   Registrar M\u00E9dicos");
		mntmRegistrarPacientes_1.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		menu_2.add(mntmRegistrarPacientes_1);
		
		JMenuItem menuItem_3 = new JMenuItem("   Listar M\u00E9dicos");
		menuItem_3.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		menu_2.add(menuItem_3);
		
		JMenu mnVacunas = new JMenu("   Vacunas   ");
		mnVacunas.setForeground(new Color(240, 248, 255));
		mnVacunas.setFont(new Font("Segoe UI", Font.PLAIN, 25));
		mnVacunas.setBackground(new Color(47, 79, 79));
		menuBar.add(mnVacunas);
		
		JMenuItem mntmRegistrarVacunas = new JMenuItem("   Registrar Vacunas");
		mntmRegistrarVacunas.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		mnVacunas.add(mntmRegistrarVacunas);
		
		JMenuItem mntmListarVacunas = new JMenuItem("   Listar Vacunas");
		mntmListarVacunas.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		mnVacunas.add(mntmListarVacunas);
		
		JMenu mnEnfermedades = new JMenu("   Enfermedades   ");
		mnEnfermedades.setForeground(new Color(240, 248, 255));
		mnEnfermedades.setFont(new Font("Segoe UI", Font.PLAIN, 25));
		mnEnfermedades.setBackground(new Color(47, 79, 79));
		menuBar.add(mnEnfermedades);
		
		JMenuItem mntmRegistrarVacs = new JMenuItem("   Registrar Enfermedades");
		mntmRegistrarVacs.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		mnEnfermedades.add(mntmRegistrarVacs);
		
		JMenuItem mntmListarEnfermedades = new JMenuItem("   Listar Enfermedades");
		mntmListarEnfermedades.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		mnEnfermedades.add(mntmListarEnfermedades);
		dim = getToolkit().getScreenSize();
		setSize(dim.width, dim.height - 10);
		setLocationRelativeTo(null);
	}
}
