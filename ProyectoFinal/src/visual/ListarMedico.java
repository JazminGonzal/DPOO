package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import logico.ClinicaMedica;
import logico.Medico;

import javax.swing.BoxLayout;
import java.awt.GridLayout;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.ListSelectionModel;
import javax.swing.ScrollPaneConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ListarMedico extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private static JTable table;
	private static DefaultTableModel modelo;
	private static Object[] row;
	private int index = -1; 
	private JButton btnEliminar;
	private JButton btnModificar;
	private Medico selected = null;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
	    ClinicaMedica.getInstance().cargarDatos(); // Carga los datos desde el archivo
	    try {
	        ListarMedico dialog = new ListarMedico();
	        dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
	        dialog.setVisible(true);
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}


	/**
	 * Create the dialog.
	 */
	public ListarMedico() {
		setTitle("Lista de M\u00E9dicos");
		setBounds(100, 100, 927, 688);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
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
					table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
					table.addMouseListener(new MouseAdapter() {
						@Override
						public void mouseClicked(MouseEvent e) {
							index = table.getSelectedRow();
							if(index >= 0) {
								btnEliminar.setEnabled(true);
								btnModificar.setEnabled(true);
								String codigo = table.getValueAt(index, 0).toString();
								selected = ClinicaMedica.getInstance().buscarMedicoByCod(codigo);
							}
						}
					});
					modelo = new DefaultTableModel();
					String[] identificadores = {"Código", "Nombre", "Teléfono", "Puesto", "Especialidad"};
					modelo.setColumnIdentifiers(identificadores);
					table.setModel(modelo);
					scrollPane.setViewportView(table);
				}
			}
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
			 btnModificar = new JButton("Modificar");
			 btnModificar.addActionListener(new ActionListener() {
			 	public void actionPerformed(ActionEvent e) {
			 		if(selected!=null) {
						RegistrarMedico reg = new RegistrarMedico(selected);
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
							int option = JOptionPane.showConfirmDialog(null, "Esta seguro que quiere borrar el médico? Código: "+selected.getCodMedico(), "Eliminar", JOptionPane.WARNING_MESSAGE);
							if(option == JOptionPane.OK_OPTION) {
								ClinicaMedica.getInstance().eliminarMedico(selected);
								btnEliminar.setEnabled(false);
								btnModificar.setEnabled(false);
								loadMedicos();
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
				JButton cancelButton = new JButton("Cancelar");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancelar");
				buttonPane.add(cancelButton);
			}
		}
		loadMedicos();
	}
	
	
	public static void loadMedicos() {
	    modelo.setRowCount(0); // Limpia la tabla
	    ArrayList<Medico> aux = ClinicaMedica.getInstance().getListaMedicos();
	    if (aux.isEmpty()) {
	        System.out.println("No hay médicos en la lista."); // Mensaje para depuración
	    }
	    row = new Object[table.getColumnCount()];
	    for (Medico medicos : aux) {
	        row[0] = medicos.getCodMedico();
	        row[1] = medicos.getNombre();
	        row[2] = medicos.getTelefono();
	        row[3] = medicos.getPuesto();
	        row[4] = medicos.getEspecialidad();
	        modelo.addRow(row);
	    }
	}


}