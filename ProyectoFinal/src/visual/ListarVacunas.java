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
import logico.Medico;
import logico.Vacuna;

import javax.swing.border.BevelBorder;
import javax.swing.BoxLayout;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.ScrollPaneConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ListarVacunas extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private static JTable table;
	private static DefaultTableModel modelo;
	private static Object[] row;
	private int index = -1; 
	private Vacuna selected = null;
	private JButton btnEliminar;
	private JButton btnModificar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			ListarVacunas dialog = new ListarVacunas();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public ListarVacunas() {
		setTitle("Lista de Vacunas");
		setBounds(100, 100, 788, 647);
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
								selected = ClinicaMedica.getInstance().buscarVacunaByCod(codigo);
							}
						}
					});
					table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
					scrollPane.setViewportView(table);
					modelo = new DefaultTableModel();
					String[] identificadores = {"Código", "Nombre", "Fabricante", "Dosis"};
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
							RegistrarVacunas reg = new RegistrarVacunas(selected);
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
							int option = JOptionPane.showConfirmDialog(null, "Esta seguro que quiere borrar la vacuna? Código: "+selected.getCodigoVacuna(), "Eliminar", JOptionPane.WARNING_MESSAGE);
							if(option == JOptionPane.OK_OPTION) {
								ClinicaMedica.getInstance().eliminarVacuna(selected);
								btnEliminar.setEnabled(false);
								btnModificar.setEnabled(false);
								loadVacunas();
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
		loadVacunas();
	}
	
	public static void loadVacunas(){

		modelo.setRowCount(0);
		ArrayList<Vacuna> aux = ClinicaMedica.getInstance().getListaVacunas();
		row = new Object[table.getColumnCount()];

		for(Vacuna vacunas : aux) {
			row[0] = vacunas.getCodigoVacuna();
			row[1] = vacunas.getNombre();
			row[2] = vacunas.getFabricante();
			row[3] = vacunas.getDosis();
			modelo.addRow(row);
		}
	}

}
