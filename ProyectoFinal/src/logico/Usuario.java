package logico;

import java.io.Serializable;

public class Usuario implements Serializable {
	
	private String usuario;
	private String rango;
	private String password;
	
	
	
	public Usuario(String usuario, String password, String rango) {
		super();
		this.usuario = usuario;
		this.password = password;
		this.rango = rango;
	}
	
	
	
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRango() {
		return rango;
	}
	public void setRango(String rango) {
		this.rango = rango;
	}

}
