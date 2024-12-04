package logico;

import java.io.Serializable;

public class Diagnostico implements Serializable{

	private String idDiagnostico;
	private Paciente paciente;
	private Enfermedad enfermedad;
	private boolean vigilancia;
	
	
	public Diagnostico(String idDiagnostico, Paciente paciente, Enfermedad enfermedad, boolean vigilancia) {
		super();
		this.idDiagnostico = idDiagnostico;
		this.paciente = paciente;
		this.enfermedad = enfermedad;
		this.vigilancia = vigilancia;
	}
	
	
	public String getIdDiagnostico() {
		return idDiagnostico;
	}
	public void setIdDiagnostico(String idDiagnostico) {
		this.idDiagnostico = idDiagnostico;
	}
	public Paciente getPaciente() {
		return paciente;
	}
	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}
	public Enfermedad getEnfermedad() {
		return enfermedad;
	}
	public void setEnfermedad(Enfermedad enfermedad) {
		this.enfermedad = enfermedad;
	}
	public boolean isVigilancia() {
		return vigilancia;
	}
	public void setVigilancia(boolean vigilancia) {
		this.vigilancia = vigilancia;
	}
	
}
