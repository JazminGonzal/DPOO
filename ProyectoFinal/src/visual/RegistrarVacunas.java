package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.SoftBevelBorder;

import logico.ClinicaMedica;

import javax.swing.border.BevelBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JSeparator;
import javax.swing.JTextField;

public class RegistrarVacunas extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtCodigo;
	private JTextField txtNombre;
	private JTextField txtFabricante;
	private JTextField txtDosis;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			RegistrarVacunas dialog = new RegistrarVacunas();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public RegistrarVacunas() {
		setTitle("Registro de Vacunas");
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
			txtCodigo.setText("V-"+ClinicaMedica.getInstance().codVacuna);
			txtCodigo.setBounds(177, 141, 185, 26);
			panel.add(txtCodigo);
			txtCodigo.setColumns(10);
			
			JLabel lblNewLabel_1 = new JLabel("Dosis:");
			lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 18));
			lblNewLabel_1.setBounds(502, 225, 61, 20);
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
			
			txtDosis = new JTextField();
			txtDosis.setBounds(578, 223, 185, 26);
			panel.add(txtDosis);
			txtDosis.setColumns(10);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton btnRegistrar = new JButton("Registrar");
				btnRegistrar.setActionCommand("OK");
				buttonPane.add(btnRegistrar);
				getRootPane().setDefaultButton(btnRegistrar);
			}
			{
				JButton btnCancelar = new JButton("Cancelar");
				btnCancelar.setActionCommand("Cancel");
				buttonPane.add(btnCancelar);
			}
		}
	}
}
