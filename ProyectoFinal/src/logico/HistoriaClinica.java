package logico;

import java.util.ArrayList;

public class HistoriaClinica {

	private String idHistorial;
	private Paciente paciente;
	private ArrayList<Vacuna> misVacunas;
	private ArrayList<Diagnostico>misDiagnosticos;
	
	public HistoriaClinica(String idHistorial, Paciente paciente, ArrayList<Vacuna> misVacunas,
			ArrayList<Diagnostico> misDiagnosticos) {
		super();
		this.idHistorial = idHistorial;
		this.paciente = paciente;
		this.misVacunas = new ArrayList<>();
		this.misDiagnosticos = new ArrayList<>();
	}
	public String getIdHistorial() {
		return idHistorial;
	}
	public void setIdHistorial(String idHistorial) {
		this.idHistorial = idHistorial;
	}
	public Paciente getPaciente() {
		return paciente;
	}
	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}
	public ArrayList<Vacuna> getMisVacunas() {
		return misVacunas;
	}
	public void setMisVacunas(ArrayList<Vacuna> misVacunas) {
		this.misVacunas = misVacunas;
	}
	public ArrayList<Diagnostico> getMisDiagnosticos() {
		return misDiagnosticos;
	}
	public void setMisDiagnosticos(ArrayList<Diagnostico> misDiagnosticos) {
		this.misDiagnosticos = misDiagnosticos;
	}
	
}
