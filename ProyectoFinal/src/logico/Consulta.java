package logico;

import java.util.Date;

public class Consulta {

	private String idConsulta;
	private Paciente paciente;
	private Medico doctor;
	private Date fechaConsulta;
	private String motivo;
	private String enfermededades;
	boolean esImportante;
	
	public Consulta(String idConsulta, Paciente paciente, Medico doctor, Date fechaConsulta, String motivo,
			String enfermededades, boolean esImportante) {
		super();
		this.idConsulta = idConsulta;
		this.paciente = paciente;
		this.doctor = doctor;
		this.fechaConsulta = fechaConsulta;
		this.motivo = motivo;
		this.enfermededades = enfermededades;
		this.esImportante = esImportante;
	}
	
	public String getIdConsulta() {
		return idConsulta;
	}
	public void setIdConsulta(String idConsulta) {
		this.idConsulta = idConsulta;
	}
	public Paciente getPaciente() {
		return paciente;
	}
	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}
	public Medico getDoctor() {
		return doctor;
	}
	public void setDoctor(Medico doctor) {
		this.doctor = doctor;
	}
	public Date getFechaConsulta() {
		return fechaConsulta;
	}
	public void setFechaConsulta(Date fechaConsulta) {
		this.fechaConsulta = fechaConsulta;
	}
	public String getMotivo() {
		return motivo;
	}
	public void setMotivo(String motivo) {
		this.motivo = motivo;
	}
	public String getEnfermededades() {
		return enfermededades;
	}
	public void setEnfermededades(String enfermededades) {
		this.enfermededades = enfermededades;
	}
	public boolean isEsImportante() {
		return esImportante;
	}
	public void setEsImportante(boolean esImportante) {
		this.esImportante = esImportante;
	}
}
