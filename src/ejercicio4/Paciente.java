package ejercicio4;

public class Paciente {
	private String dni;
	private String nombre;
	private String apellido;
	private String telefono;
	
	public Paciente(String dni, String nombre, String apellido, String telefono) {
		setDni(dni);
		setNombre(nombre);
		setApellido(apellido);
		setTelefono(telefono);
	}
	public String getDni() {
		return dni;
	}
	private void setDni(String dni) {
		this.dni = dni;
	}
	public String getNombre() {
		return nombre;
	}
	private void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	private void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getTelefono() {
		return telefono;
	}
	private void setTelefono(String telefono) {
		this.telefono = telefono;
	}
}
