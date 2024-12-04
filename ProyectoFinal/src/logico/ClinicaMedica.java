package logico;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ClinicaMedica implements Serializable{

	private ArrayList<Medico> listaMedicos;
	private ArrayList<Paciente> listaPacientes;
	private ArrayList<Consulta> listaConsultas;
	private ArrayList<HistoriaClinica> listaHistorial;
	private ArrayList<Enfermedad> listaEnfermedad;
	private ArrayList<Vacuna> listaVacunas;
	private ArrayList<Diagnostico> listaDiagnostico;
	private ArrayList<Cita> listaCita;
	private ArrayList<Usuario> misUsuarios;
	private static ClinicaMedica miclinica = null;

	public static int codMedico = 1;
	public static int codPaciente = 1;
	public static int codConsulta = 1;
	public static int codHistorial = 1;
	public static int codEnfermedad = 1;
	public static int codVacuna = 1;
	public static int codCita = 1;
	public static int codDiagnostico = 1;

	public static ClinicaMedica getInstance() {
	    if (miclinica == null) {
	        miclinica = new ClinicaMedica();
	        miclinica.cargarDatos();
	    }
	    return miclinica;
	}


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
		this.setMisUsuarios(new ArrayList<>());
	}
	
	
	
	
	public void insertarMedico(Medico medico) {
		listaMedicos.add(medico);
		codMedico++;
		 guardarDatos();
	}


	public void insertarPaciente(Paciente paciente) {
		listaPacientes.add(paciente);
		codPaciente++;
		 guardarDatos();

	}

	public void insertarConsulta(Consulta consulta) {
		listaConsultas.add(consulta);
		codConsulta++;
		 guardarDatos();

	}

	public void insertarHistorial(HistoriaClinica historial) {
		listaHistorial.add(historial);
		codHistorial++;
		 guardarDatos();

	}

	public void insertarEnfermedad(Enfermedad enfermedad) {
		listaEnfermedad.add(enfermedad);
		codEnfermedad++;
		 guardarDatos();

	}

	public void insertarVacunas(Vacuna vacuna) {
		listaVacunas.add(vacuna);
		codVacuna++;
		 guardarDatos();

	}

	public void insertarDiagnostico(Diagnostico diagnostico) {
		listaDiagnostico.add(diagnostico);
		codEnfermedad++;
		 guardarDatos();

	}

	public void insertarCita(Cita cita) {
		listaCita.add(cita);
		codCita++;
		 guardarDatos();

	}

	public void insertarUsuario(Usuario usuario) {
		boolean existe = misUsuarios.stream().anyMatch(u -> u.getUsuario().equals(usuario.getUsuario()));

		if (!existe) {
			misUsuarios.add(usuario);
			guardarUsuarios();
		} else {
			System.out.println("El usuario con el nombre '" + usuario.getUsuario() + "' ya existe.");
		}
	}

	private void guardarUsuarios() {
		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("usuarios.dat"))) {
			oos.writeObject(misUsuarios);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	
	
	
	
	
	
	

	public int getTotalPacientes() {
		return listaPacientes.size();
	}

	public int getTotalMedicos() {
		return listaMedicos.size();
	}

	public int getTotalEnfermedades() {
		return listaEnfermedad.size();
	}

	public int getCantPacientesMenoresDe18() {
		int i = 0;
		for (Paciente paciente : listaPacientes) {
			if (paciente.calcularEdad() >= 0 && paciente.calcularEdad() <= 17) {
				i++;
			}
		}
		return i;
	}

	public int getCantPacientesAdultos() {
		int i = 0;
		for (Paciente paciente : listaPacientes) {
			if (paciente.calcularEdad() >= 18 && paciente.calcularEdad() <= 50) {
				i++;
			}
		}
		return i;
	}

	public int getCantPacientesMayores() {
		int i = 0;
		for (Paciente paciente : listaPacientes) {
			if (paciente.calcularEdad() >= 51) {
				i++;
			}
		}
		return i;
	}

	public int getCantPacientesCitasPendientes() {
		int i = 0;

		ArrayList<Paciente> pacientesContados = new ArrayList<>();
		for (Cita cita : listaCita) {
			if (!cita.isRealizada()) {
				Paciente paciente = cita.getPaciente();

				if (!pacientesContados.contains(paciente)) {
					pacientesContados.add(paciente);
					i++;
				}
			}
		}
		return i;
	}

	public int getCantMedicosCitasPendientes() {
		int i = 0;

		ArrayList<Medico> medicosContados = new ArrayList<>();
		for (Cita cita : listaCita) {
			if (!cita.isRealizada()) {
				Medico medicos = cita.getMedico();

				if (!medicosContados.contains(medicos)) {
					medicosContados.add(medicos);
					i++;
				}
			}
		}
		return i;
	}

	public double PromedioConsultasPorMedico() {
		if (listaMedicos.isEmpty()) {
			return 0.0;
		}
		int totalConsultas = listaConsultas.size();
		int totalMedicos = listaMedicos.size();

		return (double) totalConsultas / totalMedicos;
	}

	public double PromedioConsultasPorPaciente() {
		if (listaPacientes.isEmpty()) {
			return 0.0;
		}
		int totalConsultas = listaConsultas.size();
		int totalPacientes = listaPacientes.size();

		return (double) totalConsultas / totalPacientes;
	}

	public int getCantPacientesEnfermedadesBajoVigilancia() {
		int i = 0;
		ArrayList<Paciente> pacientesContados = new ArrayList<>();

		for (Cita cita : listaCita) {
			Paciente paciente = cita.getPaciente();

			if (!pacientesContados.contains(paciente)) {
				for (Enfermedad enfermedad : paciente.getMisEnfermedades()) {
					if (enfermedad.isBajoVigilancia()) {
						pacientesContados.add(paciente);
						i++;
						break;
					}
				}
			}
		}
		return i;
	}

	public Paciente getPacienteConMasConsultas() {
		Paciente pacienteMasConsultas = null;
		int maxConsultas = 0;

		for (Paciente paciente : listaPacientes) {
			int i = 0;

			for (Consulta consulta : listaConsultas) {
				if (consulta.getPaciente().equals(paciente)) {
					i++;
				}
			}
			if (i > maxConsultas) {
				maxConsultas = i;
				pacienteMasConsultas = paciente;
			}
		}
		return pacienteMasConsultas;
	}

	public Medico getMedicoConMasConsultas() {
		Medico medicoMasConsultas = null;
		int maxConsultas = 0;

		for (Medico medico : listaMedicos) {
			int i = 0;

			for (Consulta consulta : listaConsultas) {
				if (consulta.getDoctor().equals(medico)) {
					i++;
				}
			}
			if (i > maxConsultas) {
				maxConsultas = i;
				medicoMasConsultas = medico;
			}
		}
		return medicoMasConsultas;
	}

	public int contarInternos() {
		int i = 0;
		for (Medico medico : listaMedicos) {
			if (medico.getPuesto().equals("Interno")) {
				i++;
			}
		}
		return i;
	}

	public int contarEspecialistas() {
		int i = 0;
		for (Medico medico : listaMedicos) {
			if (medico.getPuesto().equals("Especialista")) {
				i++;
			}
		}
		return i;
	}

	public int contarResidentes() {
		int i = 0;
		for (Medico medico : listaMedicos) {
			if (medico.getPuesto().equals("Residente")) {
				i++;
			}
		}
		return i;
	}

	public Enfermedad getEnfermedadMasComun() {
		Enfermedad enfermedadMasComun = null;
		int maxPacientes = 0;

		for (Paciente paciente : listaPacientes) {
			for (Enfermedad enfermedad : paciente.getMisEnfermedades()) {
				int cantPacientes = contarPacientesConEnfermedad(enfermedad);

				if (cantPacientes > maxPacientes) {
					maxPacientes = cantPacientes;
					enfermedadMasComun = enfermedad;
				}
			}
		}

		return enfermedadMasComun;
	}

	public int contarEnfermedadesBajoVigilancia() {
		int i = 0;
		for (Enfermedad enfermedad : listaEnfermedad) {
			if (enfermedad.isBajoVigilancia()) {
				i++;
			}
		}
		return i;
	}

	public double porcentajePacienteConEnfermedad(Enfermedad enfermedadSeleccionada) {
		int pacientes = 0;
		int totalPacientes = listaPacientes.size();

		for (Paciente paciente : listaPacientes) {
			for (Enfermedad enfermedad : paciente.getMisEnfermedades()) {
				if (enfermedad.equals(enfermedadSeleccionada)) {
					pacientes++;
					break;
				}
			}
		}
		return (pacientes / (double) totalPacientes) * 100;
	}

	private int contarPacientesConEnfermedad(Enfermedad enfermedadBuscada) {
		int i = 0;

		for (Paciente paciente : listaPacientes) {
			for (Enfermedad enfermedad : paciente.getMisEnfermedades()) {
				if (enfermedad.equals(enfermedadBuscada)) {
					i++;
					break;
				}
			}
		}
		return i;
	}

	public int getCantPacientesConVariasEnfermedad() {
		int i = 0;

		for (Paciente paciente : listaPacientes) {
			if (paciente.getMisEnfermedades().size() > 1) {
				i++;
			}
		}

		return i;
	}

	public boolean verificarCedulaUnica(String cedula) {
		for (Paciente paciente : listaPacientes) {
			if (paciente.getCedula().equals(cedula)) {
				return false;
			}
		}
		for (Medico medico : listaMedicos) {
			if (medico.getCedula().equals(cedula)) {
				return false;
			}
		}
		return true;
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

	public Paciente buscarPacienteByCod(String codigo) {
		boolean encontrado = false;
		Paciente aux = null;
		int i = 0;
		while (!encontrado && i < listaPacientes.size()) {
			if (listaPacientes.get(i).getCodPaciente().equalsIgnoreCase(codigo)) {
				aux = listaPacientes.get(i);
				encontrado = true;
			}
			i++;
		}

		return aux;
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
		while (!encontrado && i < listaMedicos.size()) {
			if (listaMedicos.get(i).getCodMedico().equalsIgnoreCase(codMedico)) {
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
		while (!encontrado && i < listaVacunas.size()) {
			if (listaVacunas.get(i).getCodigoVacuna().equalsIgnoreCase(codVacuna)) {
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
		while (!encontrado && i < listaEnfermedad.size()) {
			if (listaEnfermedad.get(i).getIdEnfermedad().equalsIgnoreCase(codigo)) {
				enfermedad = i;
				encontrado = true;
			}
			i++;
		}
		return enfermedad;
	}

	public int buscarPacienteByCodIndex(String codigo) {
		int paciente = -1;
		boolean encontrado = false;
		int i = 0;
		while (!encontrado && i < listaPacientes.size()) {
			if (listaPacientes.get(i).getCodPaciente().equalsIgnoreCase(codigo)) {
				paciente = i;
				encontrado = true;
			}
			i++;
		}
		return paciente;
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

	public HistoriaClinica buscarHistorialByPaciente(Paciente paciente) {
		for (HistoriaClinica historial : listaHistorial) {
			if (historial.getPaciente().getCedula().equals(paciente.getCedula())) {
				return historial;
			}
		}
		return null;
	}

	public ArrayList<Consulta> buscarConsultasByPaciente(Paciente paciente) {
		ArrayList<Consulta> consultasPaciente = new ArrayList<>();

		for (Consulta consulta : listaConsultas) {
			if (consulta.getPaciente() != null && consulta.getPaciente().equals(paciente)) {
				consultasPaciente.add(consulta);
			}
		}

		return consultasPaciente;
	}
	
	public ArrayList<Paciente> pacientesPorMedico(String codMedico) {
	    ArrayList<Paciente> pacientesPorMedico = new ArrayList<>();

	    for (Consulta consulta : listaConsultas) {
	        if (consulta.getDoctor().getCodMedico().equalsIgnoreCase(codMedico)) {
	            Paciente paciente = consulta.getPaciente();
	            if (!pacientesPorMedico.contains(paciente)) {
	                pacientesPorMedico.add(paciente);
	            }
	        }
	    }
	    
	    return pacientesPorMedico;
	}

	
	
	
	public void guardarDatos() {
	    try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("clinica.dat"))) {
	        oos.writeObject(listaMedicos);
	        oos.writeObject(listaPacientes);
	        oos.writeObject(listaConsultas);
	        oos.writeObject(listaHistorial);
	        oos.writeObject(listaEnfermedad);
	        oos.writeObject(listaVacunas);
	        oos.writeObject(listaDiagnostico);
	        oos.writeObject(listaCita);
	        //oos.writeObject(misUsuarios);

	        // Guardar los códigos estáticos
	        oos.writeInt(codMedico);
	        oos.writeInt(codPaciente);
	        oos.writeInt(codConsulta);
	        oos.writeInt(codHistorial);
	        oos.writeInt(codEnfermedad);
	        oos.writeInt(codVacuna);
	        oos.writeInt(codCita);
	        oos.writeInt(codDiagnostico);
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	}

	public void cargarDatos() {
	    File file = new File("clinica.dat");
	    if (file.exists()) {
	        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
	            listaMedicos = (ArrayList<Medico>) ois.readObject();
	            listaPacientes = (ArrayList<Paciente>) ois.readObject();
	            listaConsultas = (ArrayList<Consulta>) ois.readObject();
	            listaHistorial = (ArrayList<HistoriaClinica>) ois.readObject();
	            listaEnfermedad = (ArrayList<Enfermedad>) ois.readObject();
	            listaVacunas = (ArrayList<Vacuna>) ois.readObject();
	            listaDiagnostico = (ArrayList<Diagnostico>) ois.readObject();
	            listaCita = (ArrayList<Cita>) ois.readObject();
	           // misUsuarios = (ArrayList<Usuario>) ois.readObject();

	            // Cargar los códigos estáticos
	            codMedico = ois.readInt();
	            codPaciente = ois.readInt();
	            codConsulta = ois.readInt();
	            codHistorial = ois.readInt();
	            codEnfermedad = ois.readInt();
	            codVacuna = ois.readInt();
	            codCita = ois.readInt();
	            codDiagnostico = ois.readInt();
	        } catch (IOException | ClassNotFoundException e) {
	            e.printStackTrace();
	        }
	    }
	}

	
	
	
	public boolean verificarUsuarioUnico(String usuario) {
		return misUsuarios.stream().noneMatch(u -> u.getUsuario().equals(usuario));
	}

	public void eliminarMedico(Medico aux) {
		listaMedicos.remove(aux);
		 guardarDatos();
	}

	public void eliminarVacuna(Vacuna aux) {
		listaVacunas.remove(aux);
		 guardarDatos();
	}

	public void eliminarEnfermedad(Enfermedad aux) {
		listaEnfermedad.remove(aux);
		 guardarDatos();
	}

	public void eliminarPaciente(Paciente aux) {
		listaPacientes.remove(aux);
		 guardarDatos();
	}


	public void modificarMedico(Medico updated) {
		int index = buscarMedicoByCodgetIndex(updated.getCodMedico());
		if (index != -1) {
			listaMedicos.set(index, updated);
		}
		 guardarDatos();
	}

	public void modificarVacuna(Vacuna updated) {
		int index = buscarVacunaByCodIndex(updated.getCodigoVacuna());
		if (index != -1) {
			listaVacunas.set(index, updated);
		}
		 guardarDatos();
	}

	public void modificarEnfermedad(Enfermedad updated) {
		int index = buscarEnfermedadByCodIndex(updated.getIdEnfermedad());
		if (index != -1) {
			listaEnfermedad.set(index, updated);
		}
		 guardarDatos();
	}

	public void modificarPaciente(Paciente updated) {
		int index = buscarPacienteByCodIndex(updated.getCodPaciente());
		if (index != -1) {
			listaPacientes.set(index, updated);
		}
		 guardarDatos();
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
		 guardarDatos();
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

	public ArrayList<Usuario> getMisUsuarios() {
		return misUsuarios;
	}

	public void setMisUsuarios(ArrayList<Usuario> misUsuarios) {
		this.misUsuarios = misUsuarios;
	}


}
