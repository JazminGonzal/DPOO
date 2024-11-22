package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;
import java.awt.Color;
import javax.swing.border.TitledBorder;


import logico.ClinicaMedica;
import logico.Medico;
import logico.Paciente;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JSpinner;
import javax.swing.UIManager;
import javax.swing.SpinnerDateModel;
import java.util.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;

public class RegistrarCita extends JDialog {

    private final JPanel contentPanel = new JPanel();
    private JTextField txtCedula;
    private JTextField txtTelefono;
    private JTextField txtIdPaciente;
    private JTextField txtNombre;
    private JTextField txtDireccion;
    private JSpinner spnNacimiento;
    private JTextField txtIdCita;
    private JTextField txtMotivo;
    private JComboBox cbxMedico;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        try {
            RegistrarCita dialog = new RegistrarCita();
            dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
            dialog.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Create the dialog.
     */
    public RegistrarCita() {
        setBounds(100, 100, 1043, 512);
        getContentPane().setLayout(new BorderLayout());
        contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        getContentPane().add(contentPanel, BorderLayout.CENTER);
        contentPanel.setLayout(null);

        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Datos del Paciente", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
        panel.setBounds(15, 16, 989, 178);
        contentPanel.add(panel);

        JLabel label = new JLabel("Cedula:");
        label.setBounds(15, 42, 69, 20);
        panel.add(label);

        txtCedula = new JTextField();
        txtCedula.setColumns(10);
        txtCedula.setBounds(77, 39, 201, 26);
        panel.add(txtCedula);

        JButton btnBuscar = new JButton("Buscar");
        btnBuscar.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		habilitarPaciente();
        	}
        });
        btnBuscar.setBounds(293, 38, 115, 29);
        panel.add(btnBuscar);

        JLabel lblNacimiento = new JLabel("Nacimiento:");
        lblNacimiento.setBounds(432, 42, 99, 20);
        panel.add(lblNacimiento);

        // Configuración del JSpinner para mostrar solo la fecha
        JSpinner spnNacimiento = new JSpinner();
        spnNacimiento.setEnabled(false);
        spnNacimiento.setModel(new SpinnerDateModel(new Date(), null, null, Calendar.DAY_OF_MONTH));
        spnNacimiento.setBounds(519, 39, 162, 26);
        JSpinner.DateEditor de_spnNacimiento = new JSpinner.DateEditor(spnNacimiento, "yyyy-MM-dd"); // Formato de fecha
        spnNacimiento.setEditor(de_spnNacimiento);
        panel.add(spnNacimiento);

        JLabel label_2 = new JLabel("Teléfono:");
        label_2.setBounds(722, 42, 69, 20);
        panel.add(label_2);

        txtTelefono = new JTextField();
        txtTelefono.setEditable(false);
        txtTelefono.setColumns(10);
        txtTelefono.setBounds(794, 39, 146, 26);
        panel.add(txtTelefono);

        JLabel label_3 = new JLabel("Id:");
        label_3.setBounds(15, 105, 69, 20);
        panel.add(label_3);

        txtIdPaciente = new JTextField();
        txtIdPaciente.setText("Pac-" + ClinicaMedica.getInstance().codPaciente);
        txtIdPaciente.setEditable(false);
        txtIdPaciente.setColumns(10);
        txtIdPaciente.setBounds(53, 102, 201, 26);
        panel.add(txtIdPaciente);

        JLabel label_4 = new JLabel("Nombre:");
        label_4.setBounds(293, 105, 69, 20);
        panel.add(label_4);

        txtNombre = new JTextField();
        txtNombre.setEditable(false);
        txtNombre.setColumns(10);
        txtNombre.setBounds(364, 102, 201, 26);
        panel.add(txtNombre);

        JLabel label_5 = new JLabel("Dirección:");
        label_5.setBounds(599, 105, 92, 20);
        panel.add(label_5);

        txtDireccion = new JTextField();
        txtDireccion.setEditable(false);
        txtDireccion.setColumns(10);
        txtDireccion.setBounds(680, 81, 258, 66);
        panel.add(txtDireccion);
        
        JPanel panel_1 = new JPanel();
        panel_1.setLayout(null);
        panel_1.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Datos de la Cita", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
        panel_1.setBounds(15, 214, 989, 178);
        contentPanel.add(panel_1);
        
        JLabel lblMedico = new JLabel("Medico:");
        lblMedico.setBounds(15, 42, 69, 20);
        panel_1.add(lblMedico);
        
        JLabel lblFechaDeCita = new JLabel("Fecha de Cita:");
        lblFechaDeCita.setBounds(296, 105, 115, 20);
        panel_1.add(lblFechaDeCita);
        
        JSpinner spnFechaCita = new JSpinner();
        spnFechaCita.setModel(new SpinnerDateModel(new Date(1708574400000L), null, null, Calendar.DAY_OF_WEEK));
        spnFechaCita.setBounds(406, 102, 162, 26);
        panel_1.add(spnFechaCita);
        
        JLabel label_8 = new JLabel("Id:");
        label_8.setBounds(15, 105, 69, 20);
        panel_1.add(label_8);
        
        txtIdCita = new JTextField();
        txtIdCita.setText("Cita-" + ClinicaMedica.getInstance().codCita);
        txtIdCita.setEditable(false);
        txtIdCita.setColumns(10);
        txtIdCita.setBounds(53, 102, 201, 26);
        panel_1.add(txtIdCita);
        
        JLabel lblMotivo = new JLabel("Motivo:");
        lblMotivo.setBounds(591, 42, 92, 20);
        panel_1.add(lblMotivo);
        
        txtMotivo = new JTextField();
        txtMotivo.setColumns(10);
        txtMotivo.setBounds(651, 39, 287, 108);
        panel_1.add(txtMotivo);
        
        JComboBox cbxMedico = new JComboBox();
        cbxMedico.setBounds(80, 39, 421, 26);
        panel_1.add(cbxMedico);
        cbxMedico.setModel(new DefaultComboBoxModel(new String[] { "<Seleccionar>" }));
      
		llenarComboBoxSuplidores();
		if (cbxMedico.getItemCount() == 1) {
			JOptionPane.showMessageDialog(null, "Debe agregar medicos antes de registrar una cita.",
					"Advertencia", JOptionPane.WARNING_MESSAGE);
			
		}

		
		
        JPanel buttonPane = new JPanel();
        buttonPane.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
        buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
        getContentPane().add(buttonPane, BorderLayout.SOUTH);

        JButton okButton = new JButton("Registrar");
        okButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		
        	}
        });
        okButton.setActionCommand("OK");
        buttonPane.add(okButton);
        getRootPane().setDefaultButton(okButton);

        JButton cancelButton = new JButton("Cancelar");
        cancelButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		dispose();
        	}
        });
        cancelButton.setActionCommand("Cancel");
        buttonPane.add(cancelButton);
    }
    
    
    
    
	private void habilitarPaciente() {
	    String cedula = txtCedula.getText().trim();
	    Paciente paciente = ClinicaMedica.getInstance().buscarPacienteByCedula(cedula);

	    if (paciente != null) {
	        
	        
	        txtNombre.setText(paciente.getNombre());
	        txtIdPaciente.setText(paciente.getCodPaciente());
	        txtDireccion.setText(paciente.getDireccion());
	        txtTelefono.setText(paciente.getTelefono());
	        spnNacimiento.setValue(paciente.getFehcaNacimiento());
	        txtCedula.setEditable(true); 
	        JButton btnBuscar = (JButton) contentPanel.getComponent(2);
	        btnBuscar.setEnabled(false);  
	    } else {
	        
	        JOptionPane.showMessageDialog(null, "Paciente no encontrado. Ingrese los datos manualmente.", "Advertencia",
	                JOptionPane.WARNING_MESSAGE);

	        txtNombre.setEditable(true);
	        txtDireccion.setEditable(true);
	        txtTelefono.setEditable(true);
	        spnNacimiento.setEnabled(true);

	       
	        txtCedula.setEditable(true);
	        txtNombre.setText("");
	        txtDireccion.setText("");
	        txtTelefono.setText("");
	    }
	}
	
	private void llenarComboBoxSuplidores() {
		ArrayList<Medico> medicos = ClinicaMedica.getInstance().getListaMedicos();
		for (Medico med : medicos) {
			cbxMedico.addItem(med.getCodMedico() + "   Nombre: " + med.getNombre() + "   Especialidad:" + med.getEspecialidad());
		}
	}


}
