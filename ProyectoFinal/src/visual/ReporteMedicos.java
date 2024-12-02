package visual;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import logico.ClinicaMedica;
import logico.Medico;
import logico.Paciente;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JSeparator;

public class ReporteMedicos extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ReporteMedicos frame = new ReporteMedicos();
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
	public ReporteMedicos() {
		setTitle("Reporte de M\u00E9dicos");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 801, 735);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblReporteDeMdicos = new JLabel("Reporte de M\u00E9dicos");
		lblReporteDeMdicos.setForeground(new Color(47, 79, 79));
		lblReporteDeMdicos.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblReporteDeMdicos.setBounds(254, 47, 263, 37);
		panel.add(lblReporteDeMdicos);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(56, 114, 661, 9);
		panel.add(separator);
		
		JLabel lblNewLabel = new JLabel("Total de M\u00E9dicos Registrados:");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel.setBounds(56, 169, 278, 20);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Promedio de Consultas por M\u00E9dico:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_1.setBounds(56, 226, 317, 20);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("M\u00E9dico con mas Consultas:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_2.setBounds(56, 287, 256, 20);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Distribuci\u00F3n de M\u00E9dicos por Puesto");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_3.setBounds(56, 350, 333, 20);
		panel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Doctor:");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_4.setBounds(56, 404, 89, 20);
		panel.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("New label");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_5.setBounds(56, 460, 89, 20);
		panel.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("New label");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_6.setBounds(375, 405, 106, 20);
		panel.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("New label");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_7.setBounds(375, 461, 106, 20);
		panel.add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("M\u00E9dicos con Citas Pendientes:");
		lblNewLabel_8.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_8.setBounds(56, 527, 278, 20);
		panel.add(lblNewLabel_8);
		
		JLabel lblTotalMedicos = new JLabel("");
		lblTotalMedicos.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblTotalMedicos.setBounds(345, 169, 194, 20);
		lblTotalMedicos.setText(String.valueOf(ClinicaMedica.getInstance().getTotalMedicos()));
		panel.add(lblTotalMedicos);
		
		JLabel lblPromConsultas = new JLabel("");
		lblPromConsultas.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblPromConsultas.setBounds(388, 226, 137, 20);
		lblPromConsultas.setText(String.valueOf(ClinicaMedica.getInstance().PromedioConsultasPorMedico()));
		panel.add(lblPromConsultas);
		
		JLabel lblMedicoMaxConsulta = new JLabel("");
		lblMedicoMaxConsulta.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblMedicoMaxConsulta.setBounds(313, 288, 368, 20);
        Medico medico = ClinicaMedica.getInstance().getMedicoConMasConsultas();
		
		if (medico != null) {
			lblMedicoMaxConsulta.setText(" ID: "+medico.getCodMedico()+" Nombre: "+medico.getNombre());
		} else {
			lblMedicoMaxConsulta.setText("No hay médicos con consultas realizadas.");
		}
		panel.add(lblMedicoMaxConsulta);
		
		JLabel lblDoctor = new JLabel("");
		lblDoctor.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblDoctor.setBounds(136, 405, 143, 20);
		panel.add(lblDoctor);
		
		JLabel lblCitasPendientes = new JLabel("");
		lblCitasPendientes.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblCitasPendientes.setBounds(349, 528, 121, 20);
		lblCitasPendientes.setText(String.valueOf(ClinicaMedica.getInstance().getCantMedicosCitasPendientes()));
		panel.add(lblCitasPendientes);
	}
}
