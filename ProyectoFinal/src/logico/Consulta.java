package logico;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

public class Consulta implements Serializable{

	private String idConsulta;
	private Paciente paciente;
	private Medico doctor;
	private Date fechaConsulta;
	private String motivo;
	private ArrayList<Enfermedad> enfermedades;
	private boolean esImportante;
	private boolean esEnfermo;
	
	
	public Consulta(String idConsulta, Paciente paciente, Medico doctor, Date fechaConsulta, String motivo,
			ArrayList<Enfermedad> enfermedadesSeleccionadas, boolean esImportante, boolean esEnfermo) {
		super();
		this.idConsulta = idConsulta;
		this.paciente = paciente;
		this.doctor = doctor;
		this.fechaConsulta = fechaConsulta;
		this.motivo = motivo;
		this.enfermedades = new ArrayList<>();
		this.esImportante = esImportante;
		this.esEnfermo = esEnfermo;
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

	public ArrayList<Enfermedad> getEnfermedades() {
	return enfermedades;
}

public void setEnfermedades(ArrayList<Enfermedad> enfermedades) {
	this.enfermedades = enfermedades;
}

public boolean isEsEnfermo() {
	return esEnfermo;
}

public void setEsEnfermo(boolean esEnfermo) {
	this.esEnfermo = esEnfermo;
}

	public boolean isEsImportante() {
		return esImportante;
	}
	public void setEsImportante(boolean esImportante) {
		this.esImportante = esImportante;
	}
}
