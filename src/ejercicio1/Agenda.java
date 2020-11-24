package ejercicio1;
import java.util.ArrayList;
public class Agenda {
	private ArrayList<Persona> personas;
	
	public Agenda() {
		this.personas=new ArrayList<Persona>();
	}
	@Override
	public String toString() {
		return "Agenda [personas=" + personas + "]";
	}
	public Persona buscarPersona(String dni) {
		Persona personaBuscada = null;
		int i = 0;
		while (i < this.personas.size() && personaBuscada == null) {
			if (this.personas.get(i).getDni() == dni) {
				personaBuscada = this.personas.get(i);
			}
			i++;
		}
		return personaBuscada;
	}
	public boolean agregarPersona(String nombre, String apellido, String direccion, String dni) {
		boolean resul = false;
		Persona persona;
		if (buscarPersona(dni) == null) {
			persona=new Persona(nombre, apellido, direccion, dni); // preguntar el nombre con el cual inicializar la variable. Persona? nombre?
			personas.add(persona);
			resul=true;
		}
		return resul;
	}
	public boolean agregarPersonaV2(String nombre, String apellido, String direccion, String dni) {
		boolean resul = false;
		if (buscarPersona(dni) == null) {
			personas.add(new Persona(nombre, apellido, direccion, dni)); // preguntar el nombre con el cual inicializar la variable. Persona? nombre?
			resul=true;
		}
		return resul;
	}
	public boolean removerPersona(String dni) {
		boolean resul = false;
		Persona persona;
		persona = buscarPersona(dni);
		if (persona != null) {
			personas.remove(persona);
			resul = true;
		}
		return resul;
	}
	public boolean modificarDomicilio(String dni, String direccion) {
		boolean resul = false;
		Persona persona;
		persona = buscarPersona(dni);
		if (persona != null) {
			persona.setDireccion(direccion);
			resul = true;
		}
		return resul;
	}
	public void listarPersonas() {
		for (Persona persona: personas) {
			System.out.println(persona);
		}
	}
}
