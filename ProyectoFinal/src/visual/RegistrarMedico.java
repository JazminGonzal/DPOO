package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import logico.ClinicaMedica;
import logico.Medico;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JSpinner;
import javax.swing.SpinnerDateModel;
import java.util.Date;
import java.util.Calendar;
import javax.swing.JComboBox;
import javax.swing.SpinnerNumberModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;

public class RegistrarMedico extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtCodMedico;
	private JTextField txtCedula;
	private JTextField txtNombre;
	private JTextField txtTelefono;
	private JTextField txtDireccion;
	private JTextField txtEspecialidad;
	private JSpinner spnSueldo;
	private JComboBox cbPuesto;
	private JSpinner spnFechNac;
	private Medico updated = null;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			RegistrarMedico dialog = new RegistrarMedico(null);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public RegistrarMedico(Medico aux) {
		updated = aux;
		if(updated != null) {
			setTitle("Modificar Médico");
		} else {
		setTitle("Registro de M\u00E9dico");
		}
		setBounds(100, 100, 914, 663);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JPanel panel = new JPanel();
			contentPanel.add(panel, BorderLayout.CENTER);
			panel.setLayout(null);
			{
				
				JLabel lblNewLabel = new JLabel("Registro de M\u00E9dico");
				if(updated != null) {
					lblNewLabel = new JLabel("Modificación de M\u00E9dico");
				} 
				lblNewLabel.setForeground(new Color(47, 79, 79));
				lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 23));
				lblNewLabel.setBounds(351, 43, 403, 37);
				panel.add(lblNewLabel);
			}
			
			JSeparator separator = new JSeparator();
			separator.setForeground(new Color(47, 79, 79));
			separator.setBackground(new Color(255, 255, 255));
			separator.setBounds(45, 107, 789, 2);
			panel.add(separator);
			
			JLabel lblNewLabel_1 = new JLabel("C\u00F3digo:");
			lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 18));
			lblNewLabel_1.setBounds(521, 152, 84, 20);
			panel.add(lblNewLabel_1);
			
			txtCodMedico = new JTextField();
			txtCodMedico.setText("M-"+ClinicaMedica.getInstance().codMedico);
			txtCodMedico.setEnabled(false);
			txtCodMedico.setBounds(603, 150, 208, 26);
			panel.add(txtCodMedico);
			txtCodMedico.setColumns(10);
			
			JLabel lblNewLabel_2 = new JLabel("C\u00E9dula:");
			lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 18));
			lblNewLabel_2.setBounds(68, 152, 75, 20);
			panel.add(lblNewLabel_2);
			
			txtCedula = new JTextField();
			txtCedula.setBounds(154, 150, 208, 26);
			panel.add(txtCedula);
			txtCedula.setColumns(10);
			
			txtNombre = new JTextField();
			txtNombre.setBounds(154, 224, 208, 26);
			panel.add(txtNombre);
			txtNombre.setColumns(10);
			
			JLabel lblNewLabel_3 = new JLabel("Nombre:");
			lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 18));
			lblNewLabel_3.setBounds(59, 226, 84, 20);
			panel.add(lblNewLabel_3);
			
			JLabel lblNewLabel_4 = new JLabel("Tel\u00E9fono:");
			lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 18));
			lblNewLabel_4.setBounds(59, 300, 86, 20);
			panel.add(lblNewLabel_4);
			
			txtTelefono = new JTextField();
			txtTelefono.setBounds(154, 298, 208, 26);
			panel.add(txtTelefono);
			txtTelefono.setColumns(10);
			
			JLabel lblNewLabel_5 = new JLabel("Direcci\u00F3n:");
			lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 18));
			lblNewLabel_5.setBounds(45, 378, 98, 20);
			panel.add(lblNewLabel_5);
			
			txtDireccion = new JTextField();
			txtDireccion.setBounds(154, 376, 208, 28);
			panel.add(txtDireccion);
			txtDireccion.setColumns(10);
			
			JLabel lblNewLabel_6 = new JLabel("Fecha de ");
			lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 18));
			lblNewLabel_6.setBounds(33, 431, 92, 26);
			panel.add(lblNewLabel_6);
			
			JLabel lblNewLabel_7 = new JLabel("Nacimiento:");
			lblNewLabel_7.setFont(new Font("Tahoma", Font.BOLD, 18));
			lblNewLabel_7.setBounds(33, 455, 110, 20);
			panel.add(lblNewLabel_7);
			
			spnFechNac = new JSpinner();
			spnFechNac.setModel(new SpinnerDateModel(new Date(1732334400000L), null, new Date(1732334400000L), Calendar.YEAR));
			spnFechNac.setBounds(154, 453, 208, 26);
	        JSpinner.DateEditor de_spnNacimiento = new JSpinner.DateEditor(spnFechNac, "yyyy-MM-dd"); // Formato de fecha
	        spnFechNac.setEditor(de_spnNacimiento);
			panel.add(spnFechNac);
			
			JLabel lblNewLabel_8 = new JLabel("Puesto:");
			lblNewLabel_8.setFont(new Font("Tahoma", Font.BOLD, 18));
			lblNewLabel_8.setBounds(521, 226, 84, 20);
			panel.add(lblNewLabel_8);
			
			cbPuesto = new JComboBox();
			cbPuesto.setModel(new DefaultComboBoxModel(new String[] {" <Seleccionar>", "Interno", "Especialista", "Residente"}));
			cbPuesto.setBounds(603, 224, 208, 26);
			panel.add(cbPuesto);
			
			JLabel lblNewLabel_9 = new JLabel("Especialidad:");
			lblNewLabel_9.setFont(new Font("Tahoma", Font.BOLD, 18));
			lblNewLabel_9.setBounds(480, 300, 118, 20);
			panel.add(lblNewLabel_9);
			
			txtEspecialidad = new JTextField();
			txtEspecialidad.setBounds(603, 298, 208, 26);
			panel.add(txtEspecialidad);
			txtEspecialidad.setColumns(10);
			
			JLabel lblNewLabel_10 = new JLabel("Sueldo:");
			lblNewLabel_10.setFont(new Font("Tahoma", Font.BOLD, 18));
			lblNewLabel_10.setBounds(524, 378, 69, 20);
			panel.add(lblNewLabel_10);
			
			spnSueldo = new JSpinner();
			spnSueldo.setModel(new SpinnerNumberModel(new Float(0), new Float(0), null, new Float(1)));
			spnSueldo.setBounds(603, 376, 203, 26);
			panel.add(spnSueldo);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton btnRegistrar = new JButton("Registrar");
				if(updated != null) {
					btnRegistrar.setText("Modificar");
				}
				btnRegistrar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
						if(camposVacios()) {
							JOptionPane.showMessageDialog(null, "Debe completar todos los campos", "Advertencia", JOptionPane.WARNING_MESSAGE);
							return;
						}
						
						if(!ClinicaMedica.getInstance().verificarCedulaUnica(txtCedula.getText())){
							JOptionPane.showMessageDialog(null, "La cédula ya está registrada. Ingrese una cédula única.", "Advertencia", JOptionPane.WARNING_MESSAGE);
						return;
						}
						
						
						if(updated == null) {
						Medico medico = null;
						Date fecha = (Date) spnFechNac.getValue();
						Float sueldo = new Float(spnSueldo.getValue().toString());
						medico = new Medico(txtCedula.getText(), txtNombre.getText(), txtTelefono.getText(), txtDireccion.getText(), fecha,
								txtCodMedico.getText(), cbPuesto.getSelectedItem().toString(), txtEspecialidad.getText(), sueldo );
						
						ClinicaMedica.getInstance().insertarMedico(medico);
						JOptionPane.showMessageDialog(null,"Registro Satisfactorio","Información",JOptionPane.INFORMATION_MESSAGE);					
						clean();
						}
						else {
							updated.setNombre(txtNombre.getText());
							updated.setTelefono(txtTelefono.getText());
							updated.setDireccion(txtDireccion.getText());
							updated.setEspecialidad(txtEspecialidad.getText());
							updated.setCedula(txtCedula.getText());
							updated.setfechaNacimiento((Date)spnFechNac.getValue());
							updated.setPuesto(cbPuesto.getSelectedItem().toString());
							updated.setSueldo((Float)spnSueldo.getValue());
							ClinicaMedica.getInstance().modificarMedico(updated);
							ListarMedico.loadMedicos();
							JOptionPane.showMessageDialog(null,"Modificación Satisfactorio","Información",JOptionPane.INFORMATION_MESSAGE);
							dispose();
						}
					}
				});
				btnRegistrar.setActionCommand("OK");
				buttonPane.add(btnRegistrar);
				getRootPane().setDefaultButton(btnRegistrar);
			}
			{
				JButton btnCancelar = new JButton("Cancelar");
				btnCancelar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				btnCancelar.setActionCommand("Cancel");
				buttonPane.add(btnCancelar);
			}
		}
		loadMedicos();
	}
	
	
	private boolean camposVacios() {

		if( (float) spnSueldo.getValue() == 0 || (Date) spnFechNac.getValue() == null) {
			return true;
		}

		else if(cbPuesto.getSelectedIndex() == 0) {
			return true;
			}
		
		 else if(txtCedula.getText().isEmpty() || txtNombre.getText().isEmpty() || txtTelefono.getText().isEmpty() || txtDireccion.getText().isEmpty() || txtEspecialidad.getText().isEmpty()) {
				return true;
			}

		return false;
	}
	
	
	private void loadMedicos() {
		if(updated != null) {
			txtCodMedico.setText(updated.getCodMedico());
			txtCedula.setText(updated.getCedula());
			txtNombre.setText(updated.getNombre());
			txtTelefono.setText(updated.getTelefono());
			txtDireccion.setText(updated.getDireccion());
			cbPuesto.setSelectedItem(updated.getPuesto());
			txtEspecialidad.setText(updated.getEspecialidad());
			spnFechNac.setValue(updated.getfechaNacimiento());
			spnSueldo.setValue(new Float(updated.getSueldo()));
		}
	}
	
	
	private void clean() {

		txtCodMedico.setText("M-"+ClinicaMedica.getInstance().codMedico);
		spnSueldo.setValue(new Float(0));
		spnFechNac.setValue(new Date());
         txtNombre.setText("");
         txtCedula.setText("");
         txtTelefono.setText("");
         txtDireccion.setText("");
         txtEspecialidad.setText("");
         cbPuesto.setSelectedIndex(0);

	}
	
	

}
