package visual;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.Icon;
import javax.swing.ImageIcon;

public class MenuRegular extends JFrame {

	private JPanel contentPane;
	private Dimension dim;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuRegular frame = new MenuRegular();
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
	public MenuRegular() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 846, 463);
		dim = getToolkit().getScreenSize();
		setSize(dim.width, dim.height - 10);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		ImageIcon originalIcon = new ImageIcon(PantallaInicio.class.getResource("/visual/logoClinica.png"));
		Image scaledImage = originalIcon.getImage().getScaledInstance(70, 70, Image.SCALE_SMOOTH);
		ImageIcon scaledIcon = new ImageIcon(scaledImage);
		contentPane.setLayout(null);
		JLabel lblImagen = new JLabel(scaledIcon);
		lblImagen.setBounds(dim.width-100, 16, 85, 70);
		contentPane.add(lblImagen);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setMaximumSize(new Dimension(0, 10));
		menuBar.setBounds(0, 0, 1898, 31);
		contentPane.add(menuBar);
		menuBar.setBackground(new Color(47, 79, 79));
		
		JMenu mnCitas = new JMenu("   Citas   ");
		mnCitas.setSize(new Dimension(0, 10));
		mnCitas.setMinimumSize(new Dimension(0, 10));
		mnCitas.setForeground(new Color(240, 248, 255));
		mnCitas.setBackground(new Color(47, 79, 79));
		mnCitas.setFont(new Font("Segoe UI", Font.PLAIN, 25));
		menuBar.add(mnCitas);
		
		JMenuItem mntmRealizarCita = new JMenuItem("   Realizar Cita");
		mntmRealizarCita.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RegistrarCita regCita = new RegistrarCita();
				regCita.setModal(true);
				regCita.setVisible(true);
			}
		});
		mntmRealizarCita.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		mnCitas.add(mntmRealizarCita);
		
		JMenuItem mntmListarCitas = new JMenuItem("   Listar Citas");
		mntmListarCitas.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		mnCitas.add(mntmListarCitas);
		
		JMenu mnPacientes = new JMenu("   Pacientes   ");
		mnPacientes.setForeground(new Color(240, 248, 255));
		mnPacientes.setBackground(new Color(47, 79, 79));
		mnPacientes.setFont(new Font("Segoe UI", Font.PLAIN, 25));
		menuBar.add(mnPacientes);
		
		JMenuItem mntmListarPacientes = new JMenuItem("   Listar Pacientes");
		mntmListarPacientes.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		mnPacientes.add(mntmListarPacientes);
		
		JMenu mnMdicos = new JMenu("   M\u00E9dicos   ");
		mnMdicos.setBackground(new Color(47, 79, 79));
		mnMdicos.setForeground(new Color(240, 248, 255));
		mnMdicos.setFont(new Font("Segoe UI", Font.PLAIN, 25));
		menuBar.add(mnMdicos);
		
		JMenuItem mntmListarMdicos = new JMenuItem("   Listar M\u00E9dicos");
		mntmListarMdicos.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		mnMdicos.add(mntmListarMdicos);
	}

}