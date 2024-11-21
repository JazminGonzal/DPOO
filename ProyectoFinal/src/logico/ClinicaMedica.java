package logico;

import java.util.ArrayList;

public class ClinicaMedica {

	private ArrayList<Medico>listaMedicos;
	private ArrayList<Paciente>listaPacientes;
	private ArrayList<Consulta>listaConsultas;
	private ArrayList<HistoriaClinica>listaHistorial;
	private ArrayList<Enfermedad>listaEnfermedad;
	private ArrayList<Vacuna>listaVacunas;
	private ArrayList<Diagnostico>listaDiagnostico;
	private ArrayList<Cita>listaCita;
	
	public ClinicaMedica(ArrayList<Medico> listaMedicos, ArrayList<Paciente> listaPacientes,
			ArrayList<Consulta> listaConsultas, ArrayList<HistoriaClinica> listaHistorial,
			ArrayList<Enfermedad> listaEnfermedad, ArrayList<Vacuna> listaVacunas,
			ArrayList<Diagnostico> listaDiagnostico, ArrayList<Cita> listaCita) {
		super();
		this.listaMedicos = new ArrayList<>();
		this.listaPacientes = new ArrayList<>();
		this.listaConsultas = new ArrayList<>();
		this.listaHistorial = new ArrayList<>();
		this.listaEnfermedad = new ArrayList<>();
		this.listaVacunas = new ArrayList<>();
		this.listaDiagnostico = new ArrayList<>();
		this.listaCita = new ArrayList<>();
	}

	public ArrayList<Medico> getListaMedicos() {
		return listaMedicos;
	}

	public void setListaMedicos(ArrayList<Medico> listaMedicos) {
		this.listaMedicos = listaMedicos;
	}

	public ArrayList<Paciente> getListaPacientes() {
		return listaPacientes;
	}

	public void setListaPacientes(ArrayList<Paciente> listaPacientes) {
		this.listaPacientes = listaPacientes;
	}

	public ArrayList<Consulta> getListaConsultas() {
		return listaConsultas;
	}

	public void setListaConsultas(ArrayList<Consulta> listaConsultas) {
		this.listaConsultas = listaConsultas;
	}

	public ArrayList<HistoriaClinica> getListaHistorial() {
		return listaHistorial;
	}

	public void setListaHistorial(ArrayList<HistoriaClinica> listaHistorial) {
		this.listaHistorial = listaHistorial;
	}

	public ArrayList<Enfermedad> getListaEnfermedad() {
		return listaEnfermedad;
	}

	public void setListaEnfermedad(ArrayList<Enfermedad> listaEnfermedad) {
		this.listaEnfermedad = listaEnfermedad;
	}

	public ArrayList<Vacuna> getListaVacunas() {
		return listaVacunas;
	}

	public void setListaVacunas(ArrayList<Vacuna> listaVacunas) {
		this.listaVacunas = listaVacunas;
	}

	public ArrayList<Diagnostico> getListaDiagnostico() {
		return listaDiagnostico;
	}

	public void setListaDiagnostico(ArrayList<Diagnostico> listaDiagnostico) {
		this.listaDiagnostico = listaDiagnostico;
	}

	public ArrayList<Cita> getListaCita() {
		return listaCita;
	}

	public void setListaCita(ArrayList<Cita> listaCita) {
		this.listaCita = listaCita;
	}
	
	
	
}