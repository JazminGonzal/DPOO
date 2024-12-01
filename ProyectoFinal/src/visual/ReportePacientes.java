package visual;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import logico.ClinicaMedica;
import logico.Paciente;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JSeparator;
import java.awt.SystemColor;

public class ReportePacientes extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ReportePacientes frame = new ReportePacientes();
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
	public ReportePacientes() {
		setTitle("Reporte de Pacientes");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 844, 739);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.menu);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblReporteDePacientes = new JLabel("Reporte de Pacientes");
		lblReporteDePacientes.setForeground(new Color(47, 79, 79));
		lblReporteDePacientes.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblReporteDePacientes.setBounds(282, 42, 263, 37);
		panel.add(lblReporteDePacientes);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(55, 111, 699, 2);
		panel.add(separator);
		
		JLabel lblNewLabel = new JLabel("Total de Pacientes Registrados:");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel.setBounds(55, 177, 283, 20);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Pacientes por Grupo Etario");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_1.setBounds(55, 229, 252, 20);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("0-17 a\u00F1os:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_2.setBounds(55, 280, 107, 20);
		panel.add(lblNewLabel_2);
		
		JLabel lblAgnos = new JLabel("18-50 a\u00F1os:");
		lblAgnos.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblAgnos.setBounds(55, 321, 116, 20);
		panel.add(lblAgnos);
		
		JLabel lblAgnos_1 = new JLabel("51+ a\u00F1os:");
		lblAgnos_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblAgnos_1.setBounds(55, 366, 107, 20);
		panel.add(lblAgnos_1);
		
		JLabel lblNewLabel_3 = new JLabel("Promedio de Consultas por Paciente:");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_3.setBounds(55, 472, 339, 20);
		panel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Paciente M\u00E1s Consultado:");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_4.setBounds(55, 520, 243, 20);
		panel.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Pacientes con Citas Pendientes:");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_5.setBounds(55, 418, 302, 20);
		panel.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Pacientes con Enfermedades Bajo Vigilancia:");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_6.setBounds(55, 568, 415, 20);
		panel.add(lblNewLabel_6);
		
		JLabel lblTotalPacientes = new JLabel("");
		lblTotalPacientes.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblTotalPacientes.setBounds(363, 178, 162, 20);
		lblTotalPacientes.setText(String.valueOf(ClinicaMedica.getInstance().getTotalPacientes()));
		panel.add(lblTotalPacientes);
		
		JLabel lblPacientesMenores = new JLabel("");
		lblPacientesMenores.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblPacientesMenores.setBounds(173, 280, 69, 20);
		lblPacientesMenores.setText(String.valueOf(ClinicaMedica.getInstance().getCantPacientesMenoresDe18()));
		panel.add(lblPacientesMenores);
		
		JLabel lblPacientesAdultos = new JLabel("");
		lblPacientesAdultos.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblPacientesAdultos.setBounds(173, 322, 69, 20);
		lblPacientesAdultos.setText(String.valueOf(ClinicaMedica.getInstance().getCantPacientesAdultos()));
		panel.add(lblPacientesAdultos);
		
		JLabel lblPacientesMayores = new JLabel("");
		lblPacientesMayores.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblPacientesMayores.setBounds(173, 366, 69, 20);
		lblPacientesMayores.setText(String.valueOf(ClinicaMedica.getInstance().getCantPacientesMayores()));
		panel.add(lblPacientesMayores);
		
		JLabel lblCitasPendientes = new JLabel("0");
		lblCitasPendientes.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblCitasPendientes.setBounds(356, 419, 69, 20);
		lblCitasPendientes.setText(String.valueOf(ClinicaMedica.getInstance().getCantPacientesCitasPendientes()));
		panel.add(lblCitasPendientes);
		
		JLabel lblEnfermedadVigilancia = new JLabel("");
		lblEnfermedadVigilancia.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblEnfermedadVigilancia.setBounds(476, 569, 69, 20);
		lblEnfermedadVigilancia.setText(String.valueOf(ClinicaMedica.getInstance().getCantPacientesEnfermedadesBajoVigilancia()));
		panel.add(lblEnfermedadVigilancia);
		
		JLabel lblPacienteMasConsultado = new JLabel("");
		lblPacienteMasConsultado.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblPacienteMasConsultado.setBounds(304, 521, 450, 20);
	    Paciente paciente = ClinicaMedica.getInstance().getPacienteConMasConsultas();
		
		if (paciente != null) {
			lblPacienteMasConsultado.setText(" ID: "+paciente.getCodPaciente()+" Nombre: "+paciente.getNombre());
		} else {
			lblPacienteMasConsultado.setText("No hay pacientes con consultas realizadas.");
		}
		panel.add(lblPacienteMasConsultado);
		
		JLabel lblPromedioConsulta = new JLabel("");
		lblPromedioConsulta.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblPromedioConsulta.setBounds(401, 473, 69, 20);
		panel.add(lblPromedioConsulta);
	}
}
