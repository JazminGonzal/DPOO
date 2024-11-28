package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.SoftBevelBorder;

import logico.ClinicaMedica;
import logico.Enfermedad;
import logico.Vacuna;

import javax.swing.border.BevelBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class RegistrarEnfermedades extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtCodigo;
	private JTextField txtNombre;
	private JTextField txtDescripcion;
	private Enfermedad updated = null;
	private JCheckBox chbxVigilancia;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			RegistrarEnfermedades dialog = new RegistrarEnfermedades(null);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public RegistrarEnfermedades(Enfermedad aux) {
		updated = aux;
		if(updated != null) {
			setTitle("Modificar Enfermedades");
		} else {
		setTitle("Registro de Enfermedades");
		}
		setBounds(100, 100, 756, 492);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JPanel panel = new JPanel();
			contentPanel.add(panel, BorderLayout.CENTER);
			panel.setLayout(null);
			
			JLabel lblRegistroDeEnfermedades = new JLabel("Registro de Enfermedades");
			if(updated != null) {
				lblRegistroDeEnfermedades = new JLabel("Modificación de Enfermedades");
			}
			lblRegistroDeEnfermedades.setForeground(new Color(47, 79, 79));
			lblRegistroDeEnfermedades.setFont(new Font("Tahoma", Font.BOLD, 23));
			lblRegistroDeEnfermedades.setBounds(208, 52, 444, 37);
			panel.add(lblRegistroDeEnfermedades);
			
			JSeparator separator = new JSeparator();
			separator.setBounds(69, 108, 583, 2);
			panel.add(separator);
			
			JLabel lblNewLabel = new JLabel("C\u00F3digo:");
			lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
			lblNewLabel.setBounds(67, 182, 69, 20);
			panel.add(lblNewLabel);
			
			JLabel lblNewLabel_1 = new JLabel("Nombre:");
			lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 18));
			lblNewLabel_1.setBounds(51, 274, 84, 20);
			panel.add(lblNewLabel_1);
			
			JLabel lblNewLabel_2 = new JLabel("Descripci\u00F3n:");
			lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 18));
			lblNewLabel_2.setBounds(368, 182, 113, 20);
			panel.add(lblNewLabel_2);
			
			JLabel lblNewLabel_3 = new JLabel("Bajo Vigilancia:");
			lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 18));
			lblNewLabel_3.setBounds(367, 274, 140, 20);
			panel.add(lblNewLabel_3);
			
			txtCodigo = new JTextField();
			txtCodigo.setEnabled(false);
			txtCodigo.setText("E-"+ClinicaMedica.getInstance().codEnfermedad);
			txtCodigo.setBounds(144, 180, 174, 26);
			panel.add(txtCodigo);
			txtCodigo.setColumns(10);
			
			txtNombre = new JTextField();
			txtNombre.setBounds(143, 272, 174, 26);
			panel.add(txtNombre);
			txtNombre.setColumns(10);
			
			txtDescripcion = new JTextField();
			txtDescripcion.setBounds(487, 180, 165, 64);
			panel.add(txtDescripcion);
			txtDescripcion.setColumns(10);
			
			chbxVigilancia = new JCheckBox("");
			chbxVigilancia.setFont(new Font("Tahoma", Font.BOLD, 18));
			chbxVigilancia.setBounds(518, 272, 29, 29);
			panel.add(chbxVigilancia);
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
							Enfermedad enfermedad = null;
							
							enfermedad = new Enfermedad(txtCodigo.getText(), txtNombre.getText(), txtDescripcion.getText(), chbxVigilancia.isSelected());
							
							ClinicaMedica.getInstance().insertarEnfermedad(enfermedad);
							JOptionPane.showMessageDialog(null,"Registro Satisfactorio","Información",JOptionPane.INFORMATION_MESSAGE);					
							clean();
							}
							else {
								updated.setNombre(txtNombre.getText());
								updated.setDescripcion(txtDescripcion.getText());
								updated.setBajoVigilancia(chbxVigilancia.isSelected());
								ClinicaMedica.getInstance().modificarEnfermedad(updated);
								ListarEnfermedades.loadEnfermedades();
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
		loadEnfermedades();
		
	}
	
	
	
	private void loadEnfermedades() {
		if(updated != null) {
			txtCodigo.setText(updated.getIdEnfermedad());
			txtNombre.setText(updated.getNombre());
			txtDescripcion.setText(updated.getDescripcion());
			chbxVigilancia.setSelected(updated.isBajoVigilancia());
			
		}
	}
	
	
	private boolean camposVacios() {

		if(txtCodigo.getText().isEmpty()  || txtDescripcion.getText().isEmpty() || txtNombre.getText().isEmpty()) {
				return true;
			}

		return false;
	}
	
	
	private void clean() {

		 txtCodigo.setText("E-"+ClinicaMedica.getInstance().codEnfermedad);
         txtNombre.setText("");
         txtDescripcion.setText("");
         chbxVigilancia.setSelected(false);

	}
}
