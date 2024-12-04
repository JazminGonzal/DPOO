package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.table.DefaultTableModel;

import logico.Cita;
import logico.ClinicaMedica;
import logico.Paciente;

public class PacientePorMedico extends JDialog {

    private final JPanel contentPanel = new JPanel();
    private static JTable table;
    private static DefaultTableModel modelo;
    private static Object[] row;
    private int index = -1;
    private JButton btnEliminar;
    private JButton btnModificar;
    private JButton btnVerHistorial;
    private Paciente selected = null;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			PacientePorMedico dialog = new PacientePorMedico(null);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public PacientePorMedico( String codMedico) {
		setTitle("Lista de Pacientes");
        setBounds(100, 100, 730, 668);
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
                            if (index >= 0) {
                                btnEliminar.setEnabled(true);
                                btnModificar.setEnabled(true);
                                btnVerHistorial.setEnabled(true);
                                String codigo = table.getValueAt(index, 0).toString();
                                selected = ClinicaMedica.getInstance().buscarPacienteByCod(codigo);
                            }
                        }
                    });
                    table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
                    scrollPane.setViewportView(table);
                    modelo = new DefaultTableModel();
                    String[] identificadores = { "Código", "Cédula", "Nombre", "Teléfono" };
                    modelo.setColumnIdentifiers(identificadores);
                    table.setModel(modelo);
                    scrollPane.setViewportView(table);
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
                btnModificar.setEnabled(false);
                btnModificar.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        if (selected != null) {
                            RegistrarPaciente reg = new RegistrarPaciente(selected);
                            reg.setModal(true);
                            reg.setVisible(true);
                            btnModificar.setEnabled(false);
                            btnEliminar.setEnabled(false);
                        }
                    }
                });
                buttonPane.add(btnModificar);
            }
            {
                btnEliminar = new JButton("Eliminar");
                btnEliminar.setEnabled(false);
                btnEliminar.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        if (selected != null) {
                            int option = JOptionPane.showConfirmDialog(null, "Esta seguro que quiere borrar el paciente? Código: " + selected.getCodPaciente(), "Eliminar", JOptionPane.WARNING_MESSAGE);
                            if (option == JOptionPane.OK_OPTION) {
                                ClinicaMedica.getInstance().eliminarPaciente(selected);
                                btnEliminar.setEnabled(false);
                                btnModificar.setEnabled(false);
                                btnVerHistorial.setEnabled(false);
                                loadPacientes(codMedico);
                            }
                        }
                    }
                });
                buttonPane.add(btnEliminar);
                getRootPane().setDefaultButton(btnEliminar);
            }
            {
                btnVerHistorial = new JButton("Ver Historial");
                btnVerHistorial.setEnabled(false);
                btnVerHistorial.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        if (selected != null) {
                            ListarHistorial listarHistorial = new ListarHistorial(selected);
                            listarHistorial.setModal(true);
                            listarHistorial.setVisible(true);
                        }
                    }
                });
                buttonPane.add(btnVerHistorial);
            }
            {
                JButton btnCancelar = new JButton("Cancelar");
                btnCancelar.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        dispose();
                    }
                });
                buttonPane.add(btnCancelar);
            }
        }
        loadPacientes(codMedico);
    }

    public static void loadPacientes(String codMedico) {
        modelo.setRowCount(0);
        ArrayList<Paciente> aux = ClinicaMedica.getInstance().pacientesPorMedico(codMedico);
        row = new Object[table.getColumnCount()];

        for (Paciente pacientes : aux) {
            row[0] = pacientes.getCodPaciente();
            row[1] = pacientes.getCedula();
            row[2] = pacientes.getNombre();
            row[3] = pacientes.getTelefono();
            modelo.addRow(row);
        }
    }
}
