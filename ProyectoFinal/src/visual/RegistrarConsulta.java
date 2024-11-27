package visual;

import javax.swing.*;

import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import logico.ClinicaMedica;
import logico.Enfermedad;
import logico.Paciente;
import logico.Vacuna;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;
import java.util.Calendar;

public class RegistrarConsulta extends JDialog {

    private final JPanel contentPanel = new JPanel();
    private JTable tableEnfermedadesDisponibles;
    private JTable tableEnfermedadesPaciente;
    private JTable tableVacunasDisponibles;
    private JTable tableVacunasPaciente;
    private DefaultTableModel modelEnfermedadesDisponibles;
    private DefaultTableModel modelEnfermedadesPaciente;
    private DefaultTableModel modelVacunasDisponibles;
    private DefaultTableModel modelVacunasPaciente;
    private Paciente pacienteActual; // Cliente seleccionado
    private JButton btnAgregarEnfermedad, btnQuitarEnfermedad, btnAgregarVacuna, btnQuitarVacuna;
    private JTextField txtNombre;
    private JTextField txtCedula;
    private JTextField txtMotivo;
    private JTextField txtCodConsulta;
    private JTextField txtDireccion;
    private JTextField txtDoctor;

    public static void main(String[] args) {
        try {
            RegistrarConsulta dialog = new RegistrarConsulta();
            dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
            dialog.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public RegistrarConsulta() {
        setTitle("Registrar Consulta");
        setBounds(100, 100, 1114, 641);
        getContentPane().setLayout(new BorderLayout());
        contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        getContentPane().add(contentPanel, BorderLayout.CENTER);
        contentPanel.setLayout(null);
        setLocationRelativeTo(null);

        // Panel de enfermedades disponibles
        JPanel panelEnfermedadesDisponibles = new JPanel();
        panelEnfermedadesDisponibles.setBorder(
                new TitledBorder("Enfermedades Disponibles"));
        panelEnfermedadesDisponibles.setBounds(557, 250, 259, 200);
        contentPanel.add(panelEnfermedadesDisponibles);
        panelEnfermedadesDisponibles.setLayout(new BorderLayout(0, 0));

        JScrollPane scrollEnfermedadesDisponibles = new JScrollPane();
        panelEnfermedadesDisponibles.add(scrollEnfermedadesDisponibles, BorderLayout.CENTER);

        tableEnfermedadesDisponibles = new JTable();
        modelEnfermedadesDisponibles = new DefaultTableModel();
        modelEnfermedadesDisponibles.setColumnIdentifiers(new String[]{"ID", "Nombre"});
        tableEnfermedadesDisponibles.setModel(modelEnfermedadesDisponibles);
        scrollEnfermedadesDisponibles.setViewportView(tableEnfermedadesDisponibles);

        // Panel de enfermedades del paciente
        JPanel panelEnfermedadesPaciente = new JPanel();
        panelEnfermedadesPaciente.setBorder(
                new TitledBorder("Enfermedades del Paciente"));
        panelEnfermedadesPaciente.setBounds(819, 250, 259, 200);
        contentPanel.add(panelEnfermedadesPaciente);
        panelEnfermedadesPaciente.setLayout(new BorderLayout(0, 0));

        JScrollPane scrollEnfermedadesPaciente = new JScrollPane();
        panelEnfermedadesPaciente.add(scrollEnfermedadesPaciente, BorderLayout.CENTER);

        tableEnfermedadesPaciente = new JTable();
        modelEnfermedadesPaciente = new DefaultTableModel();
        modelEnfermedadesPaciente.setColumnIdentifiers(new String[]{"ID", "Nombre"});
        tableEnfermedadesPaciente.setModel(modelEnfermedadesPaciente);
        scrollEnfermedadesPaciente.setViewportView(tableEnfermedadesPaciente);

        // Botones para mover enfermedades
        btnAgregarEnfermedad = new JButton("Agregar Enfermedad >>");
        btnAgregarEnfermedad.setBounds(578, 458, 209, 29);
        contentPanel.add(btnAgregarEnfermedad);

        btnQuitarEnfermedad = new JButton("<< Quitar Enfermedad");
        btnQuitarEnfermedad.setBounds(578, 499, 209, 29);
        contentPanel.add(btnQuitarEnfermedad);

        // Panel de vacunas disponibles
        JPanel panelVacunasDisponibles = new JPanel();
        panelVacunasDisponibles.setBorder(
                new TitledBorder("Vacunas Disponibles"));
        panelVacunasDisponibles.setBounds(15, 250, 259, 200);
        contentPanel.add(panelVacunasDisponibles);
        panelVacunasDisponibles.setLayout(new BorderLayout(0, 0));

        JScrollPane scrollVacunasDisponibles = new JScrollPane();
        panelVacunasDisponibles.add(scrollVacunasDisponibles, BorderLayout.CENTER);

        tableVacunasDisponibles = new JTable();
        modelVacunasDisponibles = new DefaultTableModel();
        modelVacunasDisponibles.setColumnIdentifiers(new String[]{"ID", "Nombre"});
        tableVacunasDisponibles.setModel(modelVacunasDisponibles);
        scrollVacunasDisponibles.setViewportView(tableVacunasDisponibles);

        // Panel de vacunas del paciente
        JPanel panelVacunasPaciente = new JPanel();
        panelVacunasPaciente.setBorder(
                new TitledBorder("Vacunas del Paciente"));
        panelVacunasPaciente.setBounds(273, 250, 259, 200);
        contentPanel.add(panelVacunasPaciente);
        panelVacunasPaciente.setLayout(new BorderLayout(0, 0));

        JScrollPane scrollVacunasPaciente = new JScrollPane();
        panelVacunasPaciente.add(scrollVacunasPaciente, BorderLayout.CENTER);

        tableVacunasPaciente = new JTable();
        modelVacunasPaciente = new DefaultTableModel();
        modelVacunasPaciente.setColumnIdentifiers(new String[]{"ID", "Nombre"});
        tableVacunasPaciente.setModel(modelVacunasPaciente);
        scrollVacunasPaciente.setViewportView(tableVacunasPaciente);

        // Botones para mover vacunas
        btnAgregarVacuna = new JButton("Agregar Vacuna >>");
        btnAgregarVacuna.setBounds(25, 458, 181, 29);
        contentPanel.add(btnAgregarVacuna);

        btnQuitarVacuna = new JButton("<< Quitar Vacuna");
        btnQuitarVacuna.setBounds(25, 499, 181, 29);
        contentPanel.add(btnQuitarVacuna);
        
        JPanel panel = new JPanel();
        panel.setBorder(new TitledBorder(null, "Informacion del Paciente", TitledBorder.LEADING, TitledBorder.TOP, null, null));
        panel.setBounds(15, 16, 1063, 218);
        contentPanel.add(panel);
        panel.setLayout(null);
        
        JLabel lblNewLabel = new JLabel("Nombre:");
        lblNewLabel.setBounds(15, 46, 69, 20);
        panel.add(lblNewLabel);
        
        JLabel lblCedula = new JLabel("Cedula:");
        lblCedula.setBounds(15, 100, 69, 20);
        panel.add(lblCedula);
        
        txtNombre = new JTextField();
        txtNombre.setEditable(false);
        txtNombre.setBounds(85, 43, 166, 26);
        panel.add(txtNombre);
        txtNombre.setColumns(10);
        
        txtCedula = new JTextField();
        txtCedula.setEditable(false);
        txtCedula.setColumns(10);
        txtCedula.setBounds(85, 97, 166, 26);
        panel.add(txtCedula);
        
        JLabel lblFecha = new JLabel("Fecha:");
        lblFecha.setBounds(266, 46, 69, 20);
        panel.add(lblFecha);
        
        JLabel lblMotivo = new JLabel("Motivo:");
        lblMotivo.setBounds(15, 167, 69, 20);
        panel.add(lblMotivo);
        
        txtMotivo = new JTextField();
        txtMotivo.setColumns(10);
        txtMotivo.setBounds(85, 152, 866, 50);
        panel.add(txtMotivo);
        
        JLabel lblConsulta = new JLabel("Consulta:");
        lblConsulta.setBounds(522, 46, 69, 20);
        panel.add(lblConsulta);
        
        txtCodConsulta = new JTextField();
        txtCodConsulta.setEditable(false);
        txtCodConsulta.setColumns(10);
        txtCodConsulta.setBounds(599, 43, 166, 26);
        txtCodConsulta.setText("Consulta-" + ClinicaMedica.getInstance().codConsulta);
        panel.add(txtCodConsulta);
        
        JSpinner spinner = new JSpinner();
        spinner.setEnabled(false);
        spinner.setModel(new SpinnerDateModel(new Date(1732680000000L), null, null, Calendar.DAY_OF_YEAR));
        spinner.setBounds(318, 43, 166, 26);
        panel.add(spinner);
        
        JLabel lblDireccion = new JLabel("Direccion:");
        lblDireccion.setBounds(266, 100, 92, 20);
        panel.add(lblDireccion);
        
        txtDireccion = new JTextField();
        txtDireccion.setEditable(false);
        txtDireccion.setColumns(10);
        txtDireccion.setBounds(346, 97, 166, 26);
        panel.add(txtDireccion);
        
        JLabel lblDoctor = new JLabel("Doctor:");
        lblDoctor.setBounds(544, 100, 92, 20);
        panel.add(lblDoctor);
        
        txtDoctor = new JTextField();
        txtDoctor.setEditable(false);
        txtDoctor.setColumns(10);
        txtDoctor.setBounds(599, 97, 166, 26);
        panel.add(txtDoctor);
        
        JRadioButton rdbtnImportante = new JRadioButton("Consulta Importante");
        rdbtnImportante.setBounds(842, 42, 192, 29);
        panel.add(rdbtnImportante);
        
        JRadioButton rdbtnEnfermo = new JRadioButton("Paciente Enfermo");
        rdbtnEnfermo.setBounds(842, 96, 192, 29);
        panel.add(rdbtnEnfermo);

        // Listeners para agregar o quitar elementos
        btnAgregarEnfermedad.addActionListener(e -> agregarEnfermedad());
        btnQuitarEnfermedad.addActionListener(e -> quitarEnfermedad());
        btnAgregarVacuna.addActionListener(e -> agregarVacuna());
        btnQuitarVacuna.addActionListener(e -> quitarVacuna());

        JPanel buttonPane = new JPanel();
		buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
		getContentPane().add(buttonPane, BorderLayout.SOUTH);

		JButton okButton = new JButton("Finalizar Consulta");
		okButton.setActionCommand("OK");
		buttonPane.add(okButton);
		getRootPane().setDefaultButton(okButton);

		JButton cancelButton = new JButton("Cancelar");
		cancelButton.setActionCommand("Cancel");
		buttonPane.add(cancelButton);

		

		btnAgregarEnfermedad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});

		btnQuitarEnfermedad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});

		okButton.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		       
		    }
		});


		cancelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});


		
        // Cargar datos iniciales
        loadEnfermedadesDisponibles();
        loadVacunasDisponibles();
    }

    private void loadEnfermedadesDisponibles() {
        ArrayList<Enfermedad> enfermedades = ClinicaMedica.getInstance().getListaEnfermedad();
        for (Enfermedad enfermedad : enfermedades) {
            // Agregar tanto el ID como el nombre
            modelEnfermedadesDisponibles.addRow(new Object[]{enfermedad.getIdEnfermedad(), enfermedad.getNombre()});
        }
    }

    private void loadVacunasDisponibles() {
        ArrayList<Vacuna> vacunas = ClinicaMedica.getInstance().getListaVacunas();
        for (Vacuna vacuna : vacunas) {
            // Agregar tanto el ID como el nombre
            modelVacunasDisponibles.addRow(new Object[]{vacuna.getCodigoVacuna(), vacuna.getNombre()});
        }
    }

    private void agregarEnfermedad() {
        int selectedRow = tableEnfermedadesDisponibles.getSelectedRow();
        if (selectedRow >= 0) {
            String idEnfermedad = (String) modelEnfermedadesDisponibles.getValueAt(selectedRow, 0);
            String nombreEnfermedad = (String) modelEnfermedadesDisponibles.getValueAt(selectedRow, 1);

            modelEnfermedadesDisponibles.removeRow(selectedRow);
            modelEnfermedadesPaciente.addRow(new Object[]{idEnfermedad, nombreEnfermedad}); 

            Enfermedad enfermedadSeleccionada = ClinicaMedica.getInstance().buscarEnfermedadByCod(idEnfermedad);
            pacienteActual.getMisEnfermedades().add(enfermedadSeleccionada);
        } else {
            JOptionPane.showMessageDialog(this, "Seleccione una enfermedad.");
        }
    }

    private void quitarEnfermedad() {
        int selectedRow = tableEnfermedadesPaciente.getSelectedRow();
        if (selectedRow >= 0) {
            String idEnfermedad = (String) modelEnfermedadesPaciente.getValueAt(selectedRow, 0);
            String nombreEnfermedad = (String) modelEnfermedadesPaciente.getValueAt(selectedRow, 1);

            modelEnfermedadesPaciente.removeRow(selectedRow);
            modelEnfermedadesDisponibles.addRow(new Object[]{idEnfermedad, nombreEnfermedad}); 

            Enfermedad enfermedadSeleccionada = ClinicaMedica.getInstance().buscarEnfermedadByCod(idEnfermedad);
            pacienteActual.getMisEnfermedades().remove(enfermedadSeleccionada);
        } else {
            JOptionPane.showMessageDialog(this, "Seleccione una enfermedad.");
        }
    }

    private void agregarVacuna() {
        int selectedRow = tableVacunasDisponibles.getSelectedRow();
        if (selectedRow >= 0) {
            
            String idVacuna = (String) modelVacunasDisponibles.getValueAt(selectedRow, 0);
            String nombreVacuna = (String) modelVacunasDisponibles.getValueAt(selectedRow, 1);

            modelVacunasDisponibles.removeRow(selectedRow);
            modelVacunasPaciente.addRow(new Object[]{idVacuna, nombreVacuna}); 

            Vacuna vacunaSeleccionada = ClinicaMedica.getInstance().buscarVacunaByCod(idVacuna);
            pacienteActual.getMisVacunas().add(vacunaSeleccionada);
        } else {
            JOptionPane.showMessageDialog(this, "Seleccione una vacuna.");
        }
    }

    private void quitarVacuna() {
        int selectedRow = tableVacunasPaciente.getSelectedRow();
        if (selectedRow >= 0) {
            String idVacuna = (String) modelVacunasPaciente.getValueAt(selectedRow, 0);
            String nombreVacuna = (String) modelVacunasPaciente.getValueAt(selectedRow, 1);

            modelVacunasPaciente.removeRow(selectedRow);
            modelVacunasDisponibles.addRow(new Object[]{idVacuna, nombreVacuna}); 

            Vacuna vacunaSeleccionada = ClinicaMedica.getInstance().buscarVacunaByCod(idVacuna);
            pacienteActual.getMisVacunas().remove(vacunaSeleccionada);
        } else {
            JOptionPane.showMessageDialog(this, "Seleccione una vacuna.");
        }
    }
}