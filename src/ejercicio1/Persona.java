package ejercicio1;

public class Persona {
	//Atributos privadoss
	private String nombre;
	private String apellido;
	private String direccion;
	private String dni;
	//Metodos publicos
	public Persona(String nombre, String apellido, String direccion, String dni) {
		setNombre(nombre);
		setApellido(apellido);
		setDireccion(direccion);
		setDni(dni);
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
	public String getDireccion() {
		return direccion;
	}
	protected void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	@Override
	public String toString() {
		return "Persona [nombre=" + nombre + ", apellido=" + apellido + ", direccion=" + direccion + "]";
	}
	public void mostrarPersona() {
		System.out.println("Nombre: "+ this.nombre);
		System.out.println("Apellido: "+ this.apellido);
		System.out.println("Direccion: "+ this.direccion );
	}
	
}
