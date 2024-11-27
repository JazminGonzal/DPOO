package visual;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import logico.Cita;
import logico.ClinicaMedica;

import java.awt.*;
import java.awt.event.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class ConsultasPorMedico extends JDialog {

    private final JPanel contentPanel = new JPanel();
    private static JTable table;
    private static DefaultTableModel modelo;
    private static Object[] row;
    private int index = -1;
    private JButton btnEliminar;
    private JButton btnModificar;
    private JSpinner spinnerFecha;
    private JLabel lblNoCitas;

    public static void main(String[] args) {
        try {
            ConsultasPorMedico dialog = new ConsultasPorMedico("MED001");
            dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
            dialog.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ConsultasPorMedico(String codMedico) {
        setTitle("Consultas del Médico");
        setBounds(100, 100, 927, 688);
        setLocationRelativeTo(null);
        getContentPane().setLayout(new BorderLayout());
        contentPanel.setBackground(Color.LIGHT_GRAY);
        contentPanel.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
        getContentPane().add(contentPanel, BorderLayout.CENTER);

        // Panel superior con el logo y el nombre de la clínica
        JPanel panelEncabezado = new JPanel();
        panelEncabezado.setBackground(Color.LIGHT_GRAY);
        panelEncabezado.setLayout(new FlowLayout(FlowLayout.LEFT));
        panelEncabezado.setBorder(new EmptyBorder(10, 10, 10, 10));

        ImageIcon originalIcon = new ImageIcon(ConsultasPorMedico.class.getResource("/visual/logoClinica.png"));
        Image scaledImage = originalIcon.getImage().getScaledInstance(70, 70, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(scaledImage);
        JLabel lblImagen = new JLabel(scaledIcon);
        panelEncabezado.add(lblImagen);

        JLabel lblTituloClinica = new JLabel("CLÍNICA PRIVADA ALONSO");
        lblTituloClinica.setFont(new Font("Verdana", Font.BOLD, 24));
        lblTituloClinica.setForeground(new Color(47, 79, 79));
        panelEncabezado.add(lblTituloClinica);

        getContentPane().add(panelEncabezado, BorderLayout.NORTH);

        // Panel para seleccionar la fecha
        JPanel panelSuperior = new JPanel();
        panelSuperior.setBounds(2, -14, 901, 52);
        panelSuperior.setBackground(Color.LIGHT_GRAY);
        panelSuperior.setLayout(null);
        JLabel lblFecha = new JLabel("Fecha:");
        lblFecha.setBounds(322, 19, 46, 20);
        panelSuperior.add(lblFecha);

        spinnerFecha = new JSpinner(new SpinnerDateModel(new Date(), null, null, java.util.Calendar.DAY_OF_MONTH));
        spinnerFecha.setBounds(383, 16, 107, 26);
        JSpinner.DateEditor dateEditor = new JSpinner.DateEditor(spinnerFecha, "yyyy-MM-dd");
        spinnerFecha.setEditor(dateEditor);
        spinnerFecha.addChangeListener(e -> loadCitasDelMedico(codMedico));
        contentPanel.setLayout(null);
        panelSuperior.add(spinnerFecha);

        contentPanel.add(panelSuperior);

        // Panel principal con la tabla
        JPanel panel = new JPanel();
        panel.setBounds(2, 38, 901, 435);
        contentPanel.add(panel);
        panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBackground(Color.LIGHT_GRAY);
        scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        panel.add(scrollPane);

        table = new JTable();
        modelo = new DefaultTableModel();
        String[] identificadores = {"ID Cita", "Paciente", "Fecha", "Motivo"};
        modelo.setColumnIdentifiers(identificadores);
        table.setModel(modelo);
        scrollPane.setViewportView(table);
        table.getSelectionModel().addListSelectionListener(e -> {
            boolean isRowSelected = table.getSelectedRow() >= 0;
            btnModificar.setEnabled(isRowSelected);
            btnEliminar.setEnabled(isRowSelected);
        });

        lblNoCitas = new JLabel("No hay citas para este día.");
        lblNoCitas.setBounds(2, 456, 901, 52);
        lblNoCitas.setBackground(Color.LIGHT_GRAY);
        lblNoCitas.setHorizontalAlignment(SwingConstants.CENTER);
        lblNoCitas.setFont(new Font("Arial", Font.ITALIC, 14));
        lblNoCitas.setForeground(Color.RED);
        contentPanel.add(lblNoCitas);

        // Panel inferior con botones
        JPanel buttonPane = new JPanel();
        buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
        getContentPane().add(buttonPane, BorderLayout.SOUTH);

        btnModificar = new JButton("Consultar");
        btnModificar.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		RegistrarConsulta regConsulta = new RegistrarConsulta();
        		regConsulta.setModal(true);
        		regConsulta.setVisible(true);
        	}
        });
        btnModificar.setEnabled(false);
        buttonPane.add(btnModificar);

        btnEliminar = new JButton("Eliminar");
        btnEliminar.setEnabled(false);
        buttonPane.add(btnEliminar);

        JButton cancelButton = new JButton("Cancelar");
        cancelButton.addActionListener(e -> dispose());
        buttonPane.add(cancelButton);

        loadCitasDelMedico(codMedico);
    }

    public void loadCitasDelMedico(String codMedico) {
        modelo.setRowCount(0);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String fechaSeleccionada = sdf.format((Date) spinnerFecha.getValue());
        ArrayList<Cita> citas = ClinicaMedica.getInstance().getCitasPorMedico(codMedico);

        boolean hayCitas = false;

        for (Cita cita : citas) {
            if (sdf.format(cita.getFechaCita()).equals(fechaSeleccionada)) {
                row = new Object[4];
                row[0] = cita.getIdCita();
                row[1] = cita.getPaciente().getNombre();
                row[2] = cita.getFechaCita();
                row[3] = cita.getMotivo();
                modelo.addRow(row);
                hayCitas = true;
            }
        }

        lblNoCitas.setVisible(!hayCitas);
    }
}