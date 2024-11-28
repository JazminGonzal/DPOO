package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.SoftBevelBorder;

import logico.ClinicaMedica;
import logico.Medico;
import logico.Paciente;

import javax.swing.border.BevelBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JSpinner;
import java.awt.event.ActionListener;
import java.util.Date;
import java.awt.event.ActionEvent;
import javax.swing.SpinnerDateModel;
import java.util.Calendar;

public class RegistrarPaciente extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtCodigo;
	private JTextField txtCedula;
	private JTextField txtNombre;
	private JTextField txtTelefono;
	private JTextField txtDireccion;
	private JSpinner spnFechNac;
	private Paciente updated = null;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			RegistrarPaciente dialog = new RegistrarPaciente(null);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public RegistrarPaciente(Paciente aux) {
		updated = aux;
		if(updated != null) {
			setTitle("Modificar Paciente");
		} else {
		setTitle("Registro de Paciente");
		}
		setBounds(100, 100, 915, 500);
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
				JLabel lblRegistroDePacientes = new JLabel("Registro de Pacientes");
				if(updated != null) {
					lblRegistroDePacientes = new JLabel("Modificación de Pacientes");
				} 
				lblRegistroDePacientes.setForeground(new Color(47, 79, 79));
				lblRegistroDePacientes.setFont(new Font("Tahoma", Font.BOLD, 23));
				lblRegistroDePacientes.setBounds(314, 48, 422, 37);
				panel.add(lblRegistroDePacientes);
			}
			{
				JLabel lblNewLabel = new JLabel("C\u00F3digo:");
				lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
				lblNewLabel.setBounds(67, 131, 79, 20);
				panel.add(lblNewLabel);
			}
			{
				JLabel lblNewLabel_1 = new JLabel("C\u00E9dula:");
				lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 18));
				lblNewLabel_1.setBounds(67, 199, 69, 20);
				panel.add(lblNewLabel_1);
			}
			{
				JLabel lblNewLabel_2 = new JLabel("Nombre:");
				lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 18));
				lblNewLabel_2.setBounds(56, 269, 79, 20);
				panel.add(lblNewLabel_2);
			}
			{
				JLabel lblNewLabel_3 = new JLabel("Tel\u00E9fono:");
				lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 18));
				lblNewLabel_3.setBounds(480, 199, 86, 20);
				panel.add(lblNewLabel_3);
			}
			{
				JLabel lblNewLabel_4 = new JLabel("Direcci\u00F3n:");
				lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 18));
				lblNewLabel_4.setBounds(473, 131, 93, 20);
				panel.add(lblNewLabel_4);
			}
			{
				JLabel lblNewLabel_5 = new JLabel("Fecha de");
				lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 18));
				lblNewLabel_5.setBounds(457, 249, 86, 20);
				panel.add(lblNewLabel_5);
			}
			{
				txtCodigo = new JTextField();
				txtCodigo.setEnabled(false);
				txtCodigo.setText("P-"+ClinicaMedica.getInstance().codPaciente);
				txtCodigo.setBounds(150, 129, 211, 26);
				panel.add(txtCodigo);
				txtCodigo.setColumns(10);
			}
			{
				txtCedula = new JTextField();
				txtCedula.setBounds(150, 197, 211, 26);
				panel.add(txtCedula);
				txtCedula.setColumns(10);
			}
			{
				txtNombre = new JTextField();
				txtNombre.setBounds(150, 267, 211, 26);
				panel.add(txtNombre);
				txtNombre.setColumns(10);
			}
			{
				txtTelefono = new JTextField();
				txtTelefono.setBounds(581, 197, 233, 26);
				panel.add(txtTelefono);
				txtTelefono.setColumns(10);
			}
			{
				txtDireccion = new JTextField();
				txtDireccion.setBounds(581, 129, 233, 26);
				panel.add(txtDireccion);
				txtDireccion.setColumns(10);
			}
			
			spnFechNac = new JSpinner();
			spnFechNac.setModel(new SpinnerDateModel(new Date(1732766400000L), null, null, Calendar.WEEK_OF_MONTH));
			spnFechNac.setBounds(581, 267, 233, 26);
			panel.add(spnFechNac);
			
			JLabel lblNewLabel_6 = new JLabel("Nacimiento:");
			lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 18));
			lblNewLabel_6.setBounds(456, 269, 110, 20);
			panel.add(lblNewLabel_6);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton btnRegistrar = new JButton("Registrar");
				btnRegistrar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
						
						if(camposVacios()) {
							JOptionPane.showMessageDialog(null, "Debe completar todos los campos", "Advertencia", JOptionPane.WARNING_MESSAGE);
							return;
						}
						
						
						if(updated == null) {
						Paciente paciente = null;
						Date fecha = (Date) spnFechNac.getValue();
						paciente = new Paciente(txtCedula.getText(), txtNombre.getText(), txtTelefono.getText(), txtDireccion.getText(), fecha,txtCodigo.getText());
						ClinicaMedica.getInstance().insertarPaciente(paciente);
						JOptionPane.showMessageDialog(null,"Registro Satisfactorio","Información",JOptionPane.INFORMATION_MESSAGE);					
						clean();
						}
						else {
							updated.setNombre(txtNombre.getText());
							updated.setTelefono(txtTelefono.getText());
							updated.setDireccion(txtDireccion.getText());
							updated.setCedula(txtCedula.getText());
							updated.setfechaNacimiento((Date)spnFechNac.getValue());
							ClinicaMedica.getInstance().modificarPaciente(updated);
							ListarPaciente.loadPacientes();
							JOptionPane.showMessageDialog(null,"Modificación Satisfactorio","Información",JOptionPane.INFORMATION_MESSAGE);
							dispose();
						}
						
					}
				});
				if(updated != null) {
					btnRegistrar.setText("Modificar");
				}
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
		loadPacientes();
	}
	
	
	private boolean camposVacios() {

		if( (Date) spnFechNac.getValue() == null || txtNombre.getText().isEmpty() || txtTelefono.getText().isEmpty() || txtCedula.getText().isEmpty() || txtDireccion.getText().isEmpty()) {
			return true;
		}
		return false;
	}
	
	
	
	private void loadPacientes() {
		if(updated != null) {
			txtCodigo.setText(updated.getCodPaciente());
			txtCedula.setText(updated.getCedula());
			txtNombre.setText(updated.getNombre());
			txtTelefono.setText(updated.getTelefono());
			txtDireccion.setText(updated.getDireccion());
			spnFechNac.setValue(updated.getfechaNacimiento());
		}
	}
	
	
	private void clean() {

		txtCodigo.setText("P-"+ClinicaMedica.getInstance().codPaciente);
		spnFechNac.setValue(new Date());
         txtNombre.setText("");
         txtCedula.setText("");
         txtTelefono.setText("");
         txtDireccion.setText("");

	}
}
