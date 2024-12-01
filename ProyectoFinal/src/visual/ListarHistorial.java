package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import logico.HistoriaClinica;
import logico.Paciente;
import logico.ClinicaMedica;
import logico.Consulta;
import logico.Enfermedad;

public class ListarHistorial extends JDialog {

    private final JPanel contentPanel = new JPanel();
    private static JTable table;
    private static DefaultTableModel modelo;
    private JButton btnEliminar;
    private JButton btnModificar;
    private Paciente paciente;

    public static void main(String[] args) {
        try {
            ListarHistorial dialog = new ListarHistorial(null);
            dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
            dialog.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ListarHistorial(Paciente paciente) {
        this.paciente = paciente;

        setTitle("Historial del Paciente");
        setBounds(100, 100, 927, 688);
        setLocationRelativeTo(null);
        getContentPane().setLayout(new BorderLayout());
        contentPanel.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
        getContentPane().add(contentPanel, BorderLayout.CENTER);
        contentPanel.setLayout(new BorderLayout(0, 0));

       
        JPanel panel = new JPanel();
        contentPanel.add(panel, BorderLayout.CENTER);
        panel.setLayout(new BorderLayout(0, 0));

        
        modelo = new DefaultTableModel();
        modelo.setColumnIdentifiers(new Object[]{"Fecha", "Motivo", "Doctor", "Enfermedades"});

       
        table = new JTable(modelo);
        JScrollPane scrollPane = new JScrollPane(table);
        panel.add(scrollPane, BorderLayout.CENTER);

       
        loadHistorial();

        
        JPanel buttonPanel = new JPanel();
        contentPanel.add(buttonPanel, BorderLayout.SOUTH);
        buttonPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));

        btnModificar = new JButton("Modificar Consulta");
        btnEliminar = new JButton("Eliminar Consulta");
        buttonPanel.add(btnModificar);
        buttonPanel.add(btnEliminar);
    }

   
    private void loadHistorial() {
    	SimpleDateFormat dateFormat = new SimpleDateFormat("EEEE, dd MMMM yyyy HH:mm:ss");
    	
        HistoriaClinica historial = ClinicaMedica.getInstance().buscarHistorialByPaciente(paciente);
        if (historial != null) {
          
            ArrayList<Consulta> consultas = ClinicaMedica.getInstance().buscarConsultasByPaciente(paciente);
            
            for (Consulta consulta : consultas) {
            	String fecha = dateFormat.format(consulta.getFechaConsulta());
                String motivo = consulta.getMotivo();
                String doctor = consulta.getDoctor() != null ? consulta.getDoctor().getNombre() : "No asignado";
                String enfermedades = getEnfermedades(consulta);

                
                modelo.addRow(new Object[]{fecha, motivo, doctor, enfermedades});
            }
        }
    }


    private String getEnfermedades(Consulta consulta) {
        StringBuilder sb = new StringBuilder();
        for (Enfermedad enfermedad : consulta.getEnfermedades()) {
            sb.append(enfermedad.getNombre()).append(", ");
        }
        return sb.length() > 0 ? sb.substring(0, sb.length() - 2) : "No hay enfermedades registradas";
    }
}
