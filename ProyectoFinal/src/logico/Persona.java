package logico;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.Date;

public abstract class Persona implements Serializable{
	

	protected String cedula;
	protected String nombre;
	protected String telefono;
	protected String direccion;
	protected Date fechaNacimiento;
	
	public Persona(String cedula, String nombre, String telefono, String direccion, Date fechaNacimiento) {
		super();
		this.cedula = cedula;
		this.nombre = nombre;
		this.telefono = telefono;
		this.direccion = direccion;
		this.fechaNacimiento = fechaNacimiento;
	}
	
	
	
	public String getCedula() {
		return cedula;
	}
	public void setCedula(String cedula) {
		this.cedula = cedula;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public Date getfechaNacimiento() {
		return fechaNacimiento;
	}
	public void setfechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	
	
	public int calcularEdad() {
        LocalDate birthDate = fechaNacimiento.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        LocalDate today = LocalDate.now();
        Period edad = Period.between(birthDate, today);
        return edad.getYears();
	}
    

}
