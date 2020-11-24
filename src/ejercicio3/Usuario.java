package ejercicio3;
import java.util.ArrayList;
public class Usuario {
	private String email;
	private String apellido;
	private int edad;
	private Categoria categoria;
	private ArrayList<Cancion> cancionesEscuchadas;
	private int cancionesEscuchadasHoy;
	
	public Usuario(String mail, String apellido, int edad, Categoria categoria) {
		setEmail(mail);
		setApellido(apellido);
		setEdad(edad);
		setCategoria(categoria);
		setCancionesEscuchadasHoy(0);
		this.cancionesEscuchadas=new ArrayList<Cancion>();
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}
	public Categoria getCategoria() {
		return categoria;
	}
	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	public int getCancionesEscuchadasHoy() {
		return cancionesEscuchadasHoy;
	}
	private void setCancionesEscuchadasHoy(int cancionesEscuchadasHoy) {
		this.cancionesEscuchadasHoy = cancionesEscuchadasHoy;
	}
	@Override
	public String toString() {
		return "Usuario [email=" + email + ", apellido=" + apellido + ", edad=" + edad + "]";
	}
	public boolean esRestringido(Cancion cancion) {
		boolean resul = false;
		if (this.getCancionesEscuchadasHoy() > 50){
			resul = true;
		}
		else {
			if (cancion.getCategoria() != CategoriaCancion.NORMAL) {
					resul = true;
			}
		}
		return resul;
	}
	private void agregarAListaDeEscuchadas(Cancion cancion) {
		this.cancionesEscuchadas.add(cancion);
	}
	public void sumaCancionEscuchada(Cancion cancion) {
		this.setCancionesEscuchadasHoy(this.getCancionesEscuchadasHoy() + 1);
		this.agregarAListaDeEscuchadas(cancion);
	}
	private int dameSize() {
		return this.cancionesEscuchadas.size();
	}
	public int cantCancionesEscuchadas() {
		return this.dameSize();
	}
	private Cancion dameCancion(int num) {
		return this.cancionesEscuchadas.get(num);
	}
	public void listarCancionesEscuchadas() {
		for (int i=0; i <= dameSize(); i++) {
			System.out.println(this.dameCancion(i).getNombre());
		}
	}
}
