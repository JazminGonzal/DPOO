package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.table.DefaultTableModel;

import logico.ClinicaMedica;
import logico.Enfermedad;
import logico.Vacuna;

import javax.swing.border.BevelBorder;
import javax.swing.BoxLayout;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.ScrollPaneConstants;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ListarEnfermedades extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private static JTable table;
	private static DefaultTableModel modelo;
	private static Object[] row;
	private int index = -1; 
	private Enfermedad selected = null;
	private JButton btnEliminar;
	private JButton btnModificar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			ListarEnfermedades dialog = new ListarEnfermedades();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public ListarEnfermedades() {
		setTitle("Lista de Enfermedades");
		setBounds(100, 100, 751, 642);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JPanel panel = new JPanel();
			contentPanel.add(panel, BorderLayout.CENTER);
			panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
			{
				JScrollPane scrollPane = new JScrollPane();
				scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
				panel.add(scrollPane);
				{
					table = new JTable();
					table.addMouseListener(new MouseAdapter() {
						@Override
						public void mouseClicked(MouseEvent e) {
							index = table.getSelectedRow();
							if(index >= 0) {
								btnEliminar.setEnabled(true);
								btnModificar.setEnabled(true);
								String codigo = table.getValueAt(index, 0).toString();
								selected = ClinicaMedica.getInstance().buscarEnfermedadByCod(codigo);
							}
						}
					});
					table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
					scrollPane.setViewportView(table);
					modelo = new DefaultTableModel();
					String[] identificadores = {"Código", "Nombre", "Descripción", "Bajo Vigilancia"};
					modelo.setColumnIdentifiers(identificadores);
					table.setModel(modelo);
				}
			}
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				 btnModificar = new JButton("Modificar");
				 btnModificar.addActionListener(new ActionListener() {
				 	public void actionPerformed(ActionEvent e) {
				 		
				 		if(selected!=null) {
							RegistrarEnfermedades reg = new RegistrarEnfermedades(selected);
							reg.setModal(true);
							reg.setVisible(true);
							btnModificar.setEnabled(false);
							btnEliminar.setEnabled(false);
						}
				 	
				 	}
				 });
				btnModificar.setEnabled(false);
				buttonPane.add(btnModificar);
			}
			{
				 btnEliminar = new JButton("Eliminar");
				 btnEliminar.addActionListener(new ActionListener() {
				 	public void actionPerformed(ActionEvent e) {
				 		
				 		if(selected!=null) {
							int option = JOptionPane.showConfirmDialog(null, "Esta seguro que quiere borrar la enfermedad? Código: "+selected.getIdEnfermedad(), "Eliminar", JOptionPane.WARNING_MESSAGE);
							if(option == JOptionPane.OK_OPTION) {
								ClinicaMedica.getInstance().eliminarEnfermedad(selected);
								btnEliminar.setEnabled(false);
								btnModificar.setEnabled(false);
								loadEnfermedades();
							}
						}
				 	}
				 });
				btnEliminar.setEnabled(false);
				btnEliminar.setActionCommand("OK");
				buttonPane.add(btnEliminar);
				getRootPane().setDefaultButton(btnEliminar);
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
	
	
	
	public static void loadEnfermedades(){

		modelo.setRowCount(0);
		ArrayList<Enfermedad> aux = ClinicaMedica.getInstance().getListaEnfermedad();
		row = new Object[table.getColumnCount()];

		for(Enfermedad enfermedades : aux) {
			row[0] = enfermedades.getIdEnfermedad();
			row[1] = enfermedades.getNombre();
			row[2] = enfermedades.getDescripcion();
			row[3] = enfermedades.isBajoVigilancia() ? "Sí" : "No";
			modelo.addRow(row);
		}
	}

}
