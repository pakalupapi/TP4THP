package ejercicio4;

public class Turno {
	private Paciente paciente;
	private boolean presente = false;
	
	public Turno() {
		
	}
	public Turno(String dni, String nombre, String apellido, String telefono) {
		paciente=new Paciente(dni, nombre, apellido, telefono);
	}
	public String dameDniPaciente() {
		return paciente.getDni();
	}
	public void darPresente() {
		this.presente = true;
	}
	public boolean isPresente() {
		return presente;
	}
	public Paciente getPaciente() {
		return paciente;
	}
}
