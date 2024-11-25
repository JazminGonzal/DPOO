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
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import logico.Cita;
import logico.ClinicaMedica;

public class ConsultasPorMedico extends JDialog {

    private final JPanel contentPanel = new JPanel();
    private static JTable table;
    private static DefaultTableModel modelo;
    private static Object[] row;
    private int index = -1; 
    private JButton btnEliminar;
    private JButton btnModificar;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        try {
            ConsultasPorMedico dialog = new ConsultasPorMedico("MED001"); // Ejemplo de código de médico
            dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
            dialog.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Create the dialog.
     * @param codMedico Código del médico cuyas citas se van a consultar
     */
    public ConsultasPorMedico(String codMedico) {
        setTitle("Consultas del Médico");
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
                            if (index >= 0) {
                                btnEliminar.setEnabled(true);
                                btnModificar.setEnabled(true);
                            }
                        }
                    });
                    modelo = new DefaultTableModel();
                    String[] identificadores = {"ID Cita", "Paciente", "Fecha", "Motivo"};
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
                btnModificar = new JButton("Consultar");
                btnModificar.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                     	//Codigo para auto crear la consulta y decir si fue importante
                    }
                });
                btnModificar.setEnabled(false);
                buttonPane.add(btnModificar);
            }
            {
                btnEliminar = new JButton("Eliminar");
                btnEliminar.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        if (index >= 0) {
                            String idCita = table.getValueAt(index, 0).toString();
                            int option = JOptionPane.showConfirmDialog(null,
                                    "¿Está seguro de que desea eliminar la cita con ID: " + idCita + "?",
                                    "Eliminar", JOptionPane.WARNING_MESSAGE);
                            if (option == JOptionPane.OK_OPTION) {
                                ClinicaMedica.getInstance().eliminarCita(idCita);
                                btnEliminar.setEnabled(false);
                                btnModificar.setEnabled(false);
                                loadCitasDelMedico(codMedico);
                            }
                        }
                    }
                });
                btnEliminar.setEnabled(false);
                buttonPane.add(btnEliminar);
            }
            {
                JButton cancelButton = new JButton("Cancelar");
                cancelButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        dispose();
                    }
                });
                buttonPane.add(cancelButton);
            }
        }
        loadCitasDelMedico(codMedico);
    }

    /**
     * Carga las citas del médico en la tabla.
     * @param codMedico Código del médico cuyas citas se van a cargar.
     */
    public static void loadCitasDelMedico(String codMedico) {
        modelo.setRowCount(0);
        ArrayList<Cita> citas = ClinicaMedica.getInstance().getCitasPorMedico(codMedico);
        row = new Object[table.getColumnCount()];

        for (Cita cita : citas) {
            row[0] = cita.getIdCita();
            row[1] = cita.getPaciente().getNombre();
            row[2] = cita.getFechaCita();
            row[3] = cita.getMotivo();
            modelo.addRow(row);
        }
    }
}
