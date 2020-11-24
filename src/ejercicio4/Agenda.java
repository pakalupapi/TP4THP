package ejercicio4;
import java.util.ArrayList;
public class Agenda {
	private ArrayList<Turno> turnos;
	private int cantMaxTurnos;
	
	public Agenda(int maxTurnosHoy) {
		setCantMaxTurnos(maxTurnosHoy);
		this.turnos=new ArrayList<Turno>();
	}
	private void setCantMaxTurnos(int num) {
		this.cantMaxTurnos = num;
	}
	public int getCantMaxTurnos() {
		return cantMaxTurnos;
	}
	private Turno buscarTurno(String dni) {
		Turno turnoBuscado = null;
		int i = 0;
		
		while (turnoBuscado == null && i < this.turnos.size()) {
			Turno turnoEncontrado =  this.turnos.get(i);
			if (turnoEncontrado.dameDniPaciente().equalsIgnoreCase(dni)) {
				turnoBuscado = turnoEncontrado;
			}
		}
		return turnoBuscado;
	}
	private void agregarTurno(Turno turno) {
		this.turnos.add(turno);
	}
	private void quitarTurno(Turno turno) {
		this.turnos.remove(turno);
	}
	private boolean quedanTurnos() {
		return getCantMaxTurnos() < this.turnos.size();
	}
	public ResulRegistro registrarTurno(String dni, String nombre, String apellido, String telefono) {
		Turno turno;
		ResulRegistro resul;
		
		if (this.quedanTurnos()) {
			resul = ResulRegistro.NO_MAS_TURNOS;
		}
		else {
			turno = this.buscarTurno(dni);
			if (turno != null) {
				resul = ResulRegistro.YA_TIENE_TURNO;
			}
			else {
				turno=new Turno(dni, nombre, apellido, telefono);
				this.agregarTurno(turno);
				resul = ResulRegistro.TURNO_CONFIRMADO;
			}
		}
		return resul;
	}
	public void listarTurnos() {
		for (Turno turno: this.turnos) {
			System.out.println(turno);
		}
	}
	public boolean darPresente(String dni) {
		Turno turnoBuscado = buscarTurno(dni);
		boolean resul = false;
		if (turnoBuscado != null) {
			turnoBuscado.darPresente();
			resul = true;
		}
		return resul;
	}
	public boolean anularTurno(String dni) {
		boolean resul = false;
		Turno turnoBuscado = buscarTurno(dni);
		if (turnoBuscado != null) {
			this.quitarTurno(turnoBuscado);
			resul = true;
		}
		return resul;
	}
	public ArrayList<Paciente> obtenerAusentes() {
		ArrayList<Paciente> ausentes=new ArrayList<Paciente>();
		Turno turnoBuscado;
		for (int i=0; i < this.turnos.size(); i++) {
			turnoBuscado = this.turnos.get(i);
			if (!turnoBuscado.isPresente()) {
				ausentes.add(turnoBuscado.getPaciente());
			}
		}
		return ausentes;
	}
}
