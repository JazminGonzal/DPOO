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
import logico.Vacuna;

import javax.swing.border.BevelBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.util.Date;
import java.awt.Color;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class RegistrarVacunas extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtCodigo;
	private JTextField txtNombre;
	private JTextField txtFabricante;
	private JSpinner spnDosis;
	private Vacuna updated = null;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			RegistrarVacunas dialog = new RegistrarVacunas(null);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public RegistrarVacunas(Vacuna aux) {
		updated = aux;
		if(updated != null) {
			setTitle("Modificar Vacunas");
		} else {
		setTitle("Registro de Vacunas");
		}
		setBounds(100, 100, 893, 448);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JPanel panel = new JPanel();
			contentPanel.add(panel, BorderLayout.CENTER);
			panel.setLayout(null);
			
			JLabel lblRegistroDeVacunas = new JLabel("Registro de Vacunas");
			if(updated != null) {
				lblRegistroDeVacunas = new JLabel("Modificación de Vacunas");
			}
			lblRegistroDeVacunas.setForeground(new Color(47, 79, 79));
			lblRegistroDeVacunas.setFont(new Font("Tahoma", Font.BOLD, 23));
			lblRegistroDeVacunas.setBounds(308, 40, 314, 37);
			panel.add(lblRegistroDeVacunas);
			
			JSeparator separator = new JSeparator();
			separator.setBounds(35, 93, 786, 2);
			panel.add(separator);
			{
				JLabel lblNewLabel = new JLabel("C\u00F3digo:");
				lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
				lblNewLabel.setBounds(94, 143, 68, 20);
				panel.add(lblNewLabel);
			}
			
			txtCodigo = new JTextField();
			txtCodigo.setEnabled(false);
			txtCodigo.setText("V-"+ClinicaMedica.getInstance().codVacuna);
			txtCodigo.setBounds(177, 141, 185, 26);
			panel.add(txtCodigo);
			txtCodigo.setColumns(10);
			
			JLabel lblNewLabel_1 = new JLabel("Dosis:");
			lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 18));
			lblNewLabel_1.setBounds(506, 225, 61, 20);
			panel.add(lblNewLabel_1);
			
			JLabel lblNewLabel_2 = new JLabel("Nombre:");
			lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 18));
			lblNewLabel_2.setBounds(83, 225, 79, 20);
			panel.add(lblNewLabel_2);
			
			txtNombre = new JTextField();
			txtNombre.setBounds(177, 223, 185, 26);
			panel.add(txtNombre);
			txtNombre.setColumns(10);
			
			JLabel lblNewLabel_3 = new JLabel("Fabricante:");
			lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 18));
			lblNewLabel_3.setToolTipText("Fabricante:");
			lblNewLabel_3.setBounds(464, 143, 103, 20);
			panel.add(lblNewLabel_3);
			
			txtFabricante = new JTextField();
			txtFabricante.setBounds(578, 141, 185, 26);
			panel.add(txtFabricante);
			txtFabricante.setColumns(10);
			
			spnDosis = new JSpinner();
			spnDosis.setModel(new SpinnerNumberModel(new Float(0), new Float(0), null, new Float(1)));
			spnDosis.setBounds(578, 223, 185, 26);
			panel.add(spnDosis);
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
						
						if(updated == null) {
							Vacuna vacuna = null;
							Float dosis = new Float(spnDosis.getValue().toString());
							vacuna = new Vacuna(txtCodigo.getText(), txtNombre.getText(), txtFabricante.getText(), dosis );
							
							ClinicaMedica.getInstance().insertarVacunas(vacuna);
							JOptionPane.showMessageDialog(null,"Registro Satisfactorio","Información",JOptionPane.INFORMATION_MESSAGE);					
							clean();
							}
							else {
								updated.setNombre(txtNombre.getText());
								updated.setFabricante(txtFabricante.getText());
								updated.setDosis((Float)spnDosis.getValue());
								ClinicaMedica.getInstance().modificarVacuna(updated);
								ListarVacunas.loadVacunas();
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
		loadVacunas();
	}
	
	
	
	private void loadVacunas() {
		if(updated != null) {
			txtCodigo.setText(updated.getCodigoVacuna());
			txtNombre.setText(updated.getNombre());
			txtFabricante.setText(updated.getFabricante());
			spnDosis.setValue(new Float(updated.getDosis()));
			
		}
	}
	
	
	private boolean camposVacios() {

		if(txtCodigo.getText().isEmpty() ||  (float) spnDosis.getValue() == 0 || txtFabricante.getText().isEmpty() || txtNombre.getText().isEmpty()) {
				return true;
			}

		return false;
	}
	
	
	private void clean() {

		 txtCodigo.setText("V-"+ClinicaMedica.getInstance().codVacuna);
         txtNombre.setText("");
         spnDosis.setValue( new Float(0));
         txtFabricante.setText("");

	}
}
