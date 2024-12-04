package logico;

import java.io.Serializable;

public class Vacuna implements Serializable{

	private String codigoVacuna;
	private String nombre;
	private String fabricante;
	private float dosis;
	
	public Vacuna(String codigoVacuna, String nombre, String fabricante, float dosis) {
		super();
		this.codigoVacuna = codigoVacuna;
		this.nombre = nombre;
		this.fabricante = fabricante;
		this.dosis = dosis;
	}
	
	
	
	
	
	
	public String getCodigoVacuna() {
		return codigoVacuna;
	}
	public void setCodigoVacuna(String codigoVacuna) {
		this.codigoVacuna = codigoVacuna;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getFabricante() {
		return fabricante;
	}
	public void setFabricante(String fabricante) {
		this.fabricante = fabricante;
	}
	public float getDosis() {
		return dosis;
	}
	public void setDosis(float dosis) {
		this.dosis = dosis;
	}
}
