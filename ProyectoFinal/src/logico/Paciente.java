package logico;

import java.util.ArrayList;
import java.util.Date;

public class Paciente extends Persona{

	private String codPaciente;
	private ArrayList<Vacuna> misVacunas;
	private ArrayList<Enfermedad> misEnfermedades;
	
	public Paciente(String cedula, String nombre, String telefono, String direccion, Date fechaNacimiento, String codPaciente) {
		super(cedula, nombre, telefono, direccion, fechaNacimiento);
		
		this.codPaciente=codPaciente;
		this.misVacunas = new ArrayList<>();
		this.misEnfermedades = new ArrayList<>();
	}
	
	
	
	
	
	
	
	public String getCodPaciente() {
		return codPaciente;
	}
	public void setCodPaciente(String codPaciente) {
		this.codPaciente = codPaciente;
	}
	public ArrayList<Vacuna> getMisVacunas() {
		return misVacunas;
	}
	public void setMisVacunas(ArrayList<Vacuna> misVacunas) {
		this.misVacunas = misVacunas;
	}
	public ArrayList<Enfermedad> getMisEnfermedades() {
		return misEnfermedades;
	}
	public void setMisEnfermedades(ArrayList<Enfermedad> misEnfermedades) {
		this.misEnfermedades = misEnfermedades;
	}


	
}
