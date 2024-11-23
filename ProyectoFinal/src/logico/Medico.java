package logico;

import java.util.ArrayList;
import java.util.Date;

public class Medico extends Persona {

	private String codMedico;
	private String puesto;
	private String especialidad;
	private float sueldo;
	private ArrayList<Cita> citasDelDia;
	
	public Medico(String cedula, String nombre, String telefono, String direccion, Date fechaNacimiento,
			String codMedico, String puesto, String especialidad, float sueldo) {
		super(cedula, nombre, telefono, direccion, fechaNacimiento);
		
		this.codMedico=codMedico;
		this.puesto = puesto;
		this.especialidad=especialidad;
		this.sueldo=sueldo;
		this.citasDelDia = new ArrayList<>();
	}
	
	
	public String getCodMedico() {
		return codMedico;
	}
	public void setCodMedico(String codMedico) {
		this.codMedico = codMedico;
	}
	public String getPuesto() {
		return puesto;
	}
	public void setPuesto(String puesto) {
		this.puesto = puesto;
	}
	public String getEspecialidad() {
		return especialidad;
	}
	public void setEspecialidad(String especialidad) {
		this.especialidad = especialidad;
	}
	public float getSueldo() {
		return sueldo;
	}
	public void setSueldo(float sueldo) {
		this.sueldo = sueldo;
	}
	public ArrayList<Cita> getCitasDelDia() {
		return citasDelDia;
	}
	public void setCitasDelDia(ArrayList<Cita> citasDelDia) {
		this.citasDelDia = citasDelDia;
	}
	
	
	
}
