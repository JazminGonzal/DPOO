package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.SoftBevelBorder;

import logico.ClinicaMedica;
import logico.Usuario;

import javax.swing.border.BevelBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.util.Date;
import java.awt.Color;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class RegistrarUsuario extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtUsuario;
	private JTextField txtContrasena;
	private JPasswordField pfConfirmarPassword;
	private JComboBox cbRol;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			RegistrarUsuario dialog = new RegistrarUsuario();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public RegistrarUsuario() {
		setTitle("Registro de Usuario");
		setBounds(100, 100, 616, 626);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JPanel panel = new JPanel();
			contentPanel.add(panel, BorderLayout.CENTER);
			panel.setLayout(null);
			{
				JLabel lblRegistroDeUsuarios = new JLabel("Registro de Usuarios");
				lblRegistroDeUsuarios.setBounds(161, 40, 253, 28);
				lblRegistroDeUsuarios.setForeground(new Color(47, 79, 79));
				lblRegistroDeUsuarios.setFont(new Font("Tahoma", Font.BOLD, 23));
				panel.add(lblRegistroDeUsuarios);
			}
			
			JSeparator separator = new JSeparator();
			separator.setBounds(46, 94, 479, 2);
			panel.add(separator);
			
			JLabel lblNewLabel = new JLabel("Usuario:");
			lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
			lblNewLabel.setBounds(173, 166, 82, 20);
			panel.add(lblNewLabel);
			
			txtUsuario = new JTextField();
			txtUsuario.setBounds(261, 164, 220, 26);
			panel.add(txtUsuario);
			txtUsuario.setColumns(10);
			
			JLabel lblNewLabel_1 = new JLabel("Rol:");
			lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 18));
			lblNewLabel_1.setBounds(212, 242, 43, 20);
			panel.add(lblNewLabel_1);
			
			cbRol = new JComboBox();
			cbRol.setModel(new DefaultComboBoxModel(new String[] {"<Seleccionar>", "Trabajador Regular", "Administrador"}));
			cbRol.setBounds(261, 240, 220, 26);
			panel.add(cbRol);
			
			JLabel lblNewLabel_2 = new JLabel("Contrase\u00F1a:");
			lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 18));
			lblNewLabel_2.setBounds(144, 317, 111, 20);
			panel.add(lblNewLabel_2);
			
			txtContrasena = new JTextField();
			txtContrasena.setBounds(261, 315, 220, 26);
			panel.add(txtContrasena);
			txtContrasena.setColumns(10);
			
			JLabel lblNewLabel_3 = new JLabel("Confimar Contrase\u00F1a:");
			lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 18));
			lblNewLabel_3.setBounds(48, 396, 207, 20);
			panel.add(lblNewLabel_3);
			
			pfConfirmarPassword = new JPasswordField();
			pfConfirmarPassword.setBounds(261, 394, 220, 26);
			panel.add(pfConfirmarPassword);
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
							clean();
							return;
						}
						
						
						String rol = cbRol.getSelectedItem().toString();
						if(rol.equalsIgnoreCase("Trabajador Regular")) {
							rol = "regular";
						}else {
							rol = "admin";
						}
						String password = new String(txtContrasena.getText());
						String confirmPassword = new String(pfConfirmarPassword.getPassword());

						if (password.isEmpty() || confirmPassword.isEmpty()) {
							JOptionPane.showMessageDialog(null, "Debe ingresar y confirmar la contraseña",
									"Advertencia", JOptionPane.WARNING_MESSAGE);
							return;
						}

						if (!password.equals(confirmPassword)) {
							JOptionPane.showMessageDialog(null, "Las contraseñas no coinciden", "Error",
									JOptionPane.ERROR_MESSAGE);
							return;
						}
						Usuario nuevoUsuario = new Usuario(txtUsuario.getText(), txtContrasena.getText().toString(), rol);
						ClinicaMedica.getInstance().insertarUsuario(nuevoUsuario);
						JOptionPane.showMessageDialog(null, "Registro Satisfactorio", "Información",
								JOptionPane.INFORMATION_MESSAGE);
						clean();
						
						
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
	}
	
	
	private boolean camposVacios() {

		if( txtUsuario.getText().isEmpty() || cbRol.getSelectedIndex() == 0  || txtContrasena.getText().isEmpty() || pfConfirmarPassword.getPassword().length == 0) {
			return true;
		}
		return false;
	}
	
	
	
	private void clean() {

         txtUsuario.setText("");
         txtContrasena.setText("");
         cbRol.setSelectedIndex(0);
         pfConfirmarPassword.setText("");

	}
}
