package logico;

import java.util.Date;

public abstract class Persona {
	

	protected String cedula;
	protected String nombre;
	protected String telefono;
	protected String direccion;
	protected Date fehcaNacimiento;
	
	public Persona(String cedula, String nombre, String telefono, String direccion, Date fehcaNacimiento) {
		super();
		this.cedula = cedula;
		this.nombre = nombre;
		this.telefono = telefono;
		this.direccion = direccion;
		this.fehcaNacimiento = fehcaNacimiento;
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
	public Date getFehcaNacimiento() {
		return fehcaNacimiento;
	}
	public void setFehcaNacimiento(Date fehcaNacimiento) {
		this.fehcaNacimiento = fehcaNacimiento;
	}

}
