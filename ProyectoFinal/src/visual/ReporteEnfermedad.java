package visual;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import logico.ClinicaMedica;
import logico.Enfermedad;
import logico.Medico;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JSeparator;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ReporteEnfermedad extends JFrame {

	private JPanel contentPane;
	private JComboBox cbEnfermedad;
	private double porcentaje;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ReporteEnfermedad frame = new ReporteEnfermedad();
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
	public ReporteEnfermedad() {
		setTitle("Reporte de Enfermedades");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 781, 729);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblReporteDeEnfermedades = new JLabel("Reporte de Enfermedades");
		lblReporteDeEnfermedades.setForeground(new Color(47, 79, 79));
		lblReporteDeEnfermedades.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblReporteDeEnfermedades.setBounds(211, 36, 321, 37);
		panel.add(lblReporteDeEnfermedades);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(69, 101, 611, 2);
		panel.add(separator);
		
		JLabel lblNewLabel = new JLabel("Total de Enfermedades Registradas:");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel.setBounds(69, 166, 336, 20);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Enfermedad M\u00E1s Com\u00FAn:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_1.setBounds(69, 243, 234, 20);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Pacientes con M\u00FAltiples Enfermedades:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_2.setBounds(69, 321, 362, 20);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Enfermedades Bajo Vigilancia:");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_3.setBounds(70, 389, 285, 20);
		panel.add(lblNewLabel_3);
		
		JLabel lblTotalEnfermedad = new JLabel("");
		lblTotalEnfermedad.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblTotalEnfermedad.setBounds(408, 166, 136, 20);
		lblTotalEnfermedad.setText(String.valueOf(ClinicaMedica.getInstance().getTotalEnfermedades()));
		panel.add(lblTotalEnfermedad);
		
		JLabel lblEnfermedadComun = new JLabel("");
		lblEnfermedadComun.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblEnfermedadComun.setBounds(306, 243, 290, 20);
		
		 Enfermedad enfermedad = ClinicaMedica.getInstance().getEnfermedadMasComun();
			
			if (enfermedad != null) {
				lblEnfermedadComun.setText(enfermedad.getNombre());
			} else {
				lblEnfermedadComun.setText("No hay suficientes datos.");
			}
			
		panel.add(lblEnfermedadComun);
		
		JLabel lblPacientesVariasEnfermedad = new JLabel("");
		lblPacientesVariasEnfermedad.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblPacientesVariasEnfermedad.setBounds(437, 322, 215, 20);
		lblPacientesVariasEnfermedad.setText(String.valueOf(ClinicaMedica.getInstance().getCantPacientesConVariasEnfermedad()));
		panel.add(lblPacientesVariasEnfermedad);
		
		JLabel lblBajoVigilancia = new JLabel("");
		lblBajoVigilancia.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblBajoVigilancia.setBounds(359, 389, 162, 20);
		lblBajoVigilancia.setText(String.valueOf(ClinicaMedica.getInstance().contarEnfermedadesBajoVigilancia()));
		panel.add(lblBajoVigilancia);
		
		JLabel label = new JLabel("Porcentaje de Pacientes Afectados por una Enfermedad Específica");
		label.setFont(new Font("Tahoma", Font.BOLD, 18));
		label.setBounds(69, 465, 616, 20);
		panel.add(label);
		cbEnfermedad = new JComboBox();
		
		cbEnfermedad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 int indice = cbEnfermedad.getSelectedIndex();
			        if (indice >= 0) {
			            Enfermedad enfermedadSeleccionada = ClinicaMedica.getInstance().getListaEnfermedad().get(indice); 
			             porcentaje = ClinicaMedica.getInstance().porcentajePacienteConEnfermedad(enfermedadSeleccionada);
			            
			        }
			}
		});
		cbEnfermedad.setModel(new DefaultComboBoxModel(new String[] {"<Seleccionar>"}));
		cbEnfermedad.setBounds(69, 522, 207, 26);
		llenarCbEnfermedad();
		panel.add(cbEnfermedad);
		
		JLabel lblPorcentaje = new JLabel("");
		lblPorcentaje.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblPorcentaje.setBounds(317, 525, 215, 20);
		lblPorcentaje.setText("Porcentaje: "+String.valueOf(porcentaje)+"%");
		panel.add(lblPorcentaje);
	}
	
	
	
	
	private void llenarCbEnfermedad() {
	    for (Enfermedad enfermedad : ClinicaMedica.getInstance().getListaEnfermedad()) {
	        cbEnfermedad.addItem(enfermedad.getNombre());
	    }
	}
	
	
	
	

}
