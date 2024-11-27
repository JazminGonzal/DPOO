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
	private static ClinicaMedica miclinica = null;
	
	public static int codMedico = 1;
	public static int codPaciente = 1;
	public static int codConsulta = 1;
	public static int codHistorial = 1;
	public static int codEnfermedad = 1;
	public static int codVacuna = 1;
	public static int codCita = 1;

	
	public static ClinicaMedica getInstance() {
		if (miclinica == null) {
			miclinica = new ClinicaMedica();
		}
		return miclinica;
	};
	
	
	
	public ClinicaMedica() {
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
	

	
	
	
	
	
	public Paciente buscarPacienteByCedula(String id) {
		boolean encontrado = false;
		Paciente aux = null;
		int i = 0;
		while (!encontrado && i < listaPacientes.size()) {
			if (listaPacientes.get(i).getCedula().equalsIgnoreCase(id)) {
				aux = listaPacientes.get(i);
				encontrado = true;
			}
			i++;
		}

		return aux;
	}
	
	
	public Medico buscarMedicoByCod(String codMedico) {
		boolean encontrado = false;
		Medico aux = null;
		int i = 0;
		while (!encontrado && i < listaMedicos.size()) {
			if (listaMedicos.get(i).getCodMedico().equalsIgnoreCase(codMedico)) {
				aux = listaMedicos.get(i);
				encontrado = true;
			}
			i++;
		}

		return aux;
	}
	
	
	public Vacuna buscarVacunaByCod(String codVacuna) {
		boolean encontrado = false;
		Vacuna aux = null;
		int i = 0;
		while (!encontrado && i < listaVacunas.size()) {
			if (listaVacunas.get(i).getCodigoVacuna().equalsIgnoreCase(codVacuna)) {
				aux = listaVacunas.get(i);
				encontrado = true;
			}
			i++;
		}

		return aux;
	}
	
	
	
	public Enfermedad buscarEnfermedadByCod(String codigo) {
		boolean encontrado = false;
		Enfermedad aux = null;
		int i = 0;
		while (!encontrado && i < listaEnfermedad.size()) {
			if (listaEnfermedad.get(i).getIdEnfermedad().equalsIgnoreCase(codigo)) {
				aux = listaEnfermedad.get(i);
				encontrado = true;
			}
			i++;
		}

		return aux;
	}
	
	
	
	public void insertarMedico(Medico medico) {
		listaMedicos.add(medico);
		codMedico++;
	}
	
	public void insertarPaciente(Paciente paciente) {
		listaPacientes.add(paciente);
		codPaciente++;
		
	}
	
	public void insertarConsulta(Consulta consulta) {
		listaConsultas.add(consulta);
		codConsulta++;
		
	}
	
	public void insertarHistorial(HistoriaClinica historial) {
		listaHistorial.add(historial);
		codHistorial++;
		
	}
	
	public void insertarEnfermedad(Enfermedad enfermedad) {
		listaEnfermedad.add(enfermedad);
		codEnfermedad++;
		
	}
	
	public void insertarVacunas(Vacuna vacuna) {
		listaVacunas.add(vacuna);
		codVacuna++;
		
	}
	
	public void insertarDiagnostico(Diagnostico diagnostico) {
		listaDiagnostico.add(diagnostico);
		codEnfermedad++;
		
	}
	
	public void insertarCita(Cita cita) {
		listaCita.add(cita);
		codCita++;
		
	}
	
	
	public void eliminarMedico(Medico aux) {
		listaMedicos.remove(aux);	
	}
	
	public void eliminarVacuna(Vacuna aux) {
		listaVacunas.remove(aux);	
	}
	
	public void eliminarEnfermedad(Enfermedad aux) {
		listaEnfermedad.remove(aux);	
	}
	
	public ArrayList<Cita> getCitasPorMedico(String codMedico) {
	    ArrayList<Cita> citasPorMedico = new ArrayList<>();
	    for (Cita cita : listaCita) {
	        if (cita.getMedico().getCodMedico().equals(codMedico)) {
	            citasPorMedico.add(cita);
	        }
	    }
	    return citasPorMedico;
	}

	

	
	public int buscarMedicoByCodgetIndex(String codMedico) {
		int medico = -1;
		boolean encontrado = false;
		int i = 0;
		while(!encontrado && i < listaMedicos.size()) {
			if(listaMedicos.get(i).getCodMedico().equalsIgnoreCase(codMedico)) {
				medico = i;
				encontrado = true;
			}
			i++;
		}
		return medico;
	}
	
	
	public int buscarVacunaByCodIndex(String codVacuna) {
		int vacuna = -1;
		boolean encontrado = false;
		int i = 0;
		while(!encontrado && i < listaVacunas.size()) {
			if(listaVacunas.get(i).getCodigoVacuna().equalsIgnoreCase(codVacuna)) {
				vacuna = i;
				encontrado = true;
			}
			i++;
		}
		return vacuna;
	}
	
	
	public int buscarEnfermedadByCodIndex(String codigo) {
		int enfermedad = -1;
		boolean encontrado = false;
		int i = 0;
		while(!encontrado && i < listaEnfermedad.size()) {
			if(listaEnfermedad.get(i).getIdEnfermedad().equalsIgnoreCase(codigo)) {
				enfermedad = i;
				encontrado = true;
			}
			i++;
		}
		return enfermedad;
	}




	public void modificarMedico(Medico updated) {
	int index = buscarMedicoByCodgetIndex(updated.getCodMedico());
		if(index!= -1) {
		listaMedicos.set(index, updated);
		}
	}
	
	public void modificarVacuna(Vacuna updated) {
		int index = buscarVacunaByCodIndex(updated.getCodigoVacuna());
			if(index!= -1) {
			listaVacunas.set(index, updated);
			}
		}
	
	public void modificarEnfermedad(Enfermedad updated) {
		int index = buscarEnfermedadByCodIndex(updated.getIdEnfermedad());
			if(index!= -1) {
			listaEnfermedad.set(index, updated);
			}
		}


	public void eliminarCita(String idCita) {
		boolean encontrado = false;
		Cita aux = null;
		int i = 0;
		while (!encontrado && i < listaCita.size()) {
			if (listaCita.get(i).getIdCita().equalsIgnoreCase(idCita)) {
				aux = listaCita.get(i);
				encontrado = true;
			}
			i++;
		}
		
		listaCita.remove(aux);
	}
	


	public Cita buscarCitaById(String idCita) {
		boolean encontrado = false;
		Cita aux = null;
		int i = 0;
		while (!encontrado && i < listaCita.size()) {
			if (listaCita.get(i).getIdCita().equalsIgnoreCase(idCita)) {
				aux = listaCita.get(i);
				encontrado = true;
			}
			i++;
		}

		return aux;
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
