package logico;

import java.util.Date;

public class Cita {

	private String idCita;
    private Paciente paciente;
    private Medico medico;
    private Date fechaCita;
    private String motivo;
    private boolean realizada;
    
    
    
    public Cita(String idCita, Paciente paciente, Medico medico, Date fechaCita, String motivo) {
		super();
		this.idCita = idCita;
		this.paciente = paciente;
		this.medico = medico;
		this.fechaCita = fechaCita;
		this.motivo = motivo;
		this.realizada = false;
	}
    
    
	public String getIdCita() {
		return idCita;
	}
	public void setIdCita(String idCita) {
		this.idCita = idCita;
	}
	public Paciente getPaciente() {
		return paciente;
	}
	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}
	public Medico getMedico() {
		return medico;
	}
	public void setMedico(Medico medico) {
		this.medico = medico;
	}
	public Date getFechaCita() {
		return fechaCita;
	}
	public void setFechaCita(Date fechaCita) {
		this.fechaCita = fechaCita;
	}
	public String getMotivo() {
		return motivo;
	}
	public void setMotivo(String motivo) {
		this.motivo = motivo;
	}
	public boolean isRealizada() {
		return realizada;
	}
	public void setRealizada(boolean realizada) {
		this.realizada = realizada;
	}


	
}
