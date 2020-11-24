package ejercicio3;

public class Cancion {
	private String nombre;
	private String autor;
	private int diasPublicacion;
	private int cantVecesEscuchada;
	private Genero genero;
	private CategoriaCancion categoria;
	
	public Cancion(String nombre, String autor, int diasPublicacion,  int cantVecesEscuchada, Genero genero) {
		setNombre(nombre);
		setAutor(autor);
		setCantVecesEscuchada(cantVecesEscuchada);
		setGenero(genero);
		setDiasPublicacion(diasPublicacion);
		setCategoria(CategoriaCancion.NORMAL);
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getAutor() {
		return autor;
	}
	public void setAutor(String autor) {
		this.autor = autor;
	}
	public int getDiasPublicacion() {
		return diasPublicacion;
	}
	public void setDiasPublicacion(int diasPublicacion) {
		this.diasPublicacion = diasPublicacion;
	}
	public int getCantVecesEscuchada() {
		return cantVecesEscuchada;
	}
	public void setCantVecesEscuchada(int cantVecesEscuchada) {
		this.cantVecesEscuchada = cantVecesEscuchada;
	}
	public Genero getGenero() {
		return genero;
	}
	public void setGenero(Genero genero) {
		this.genero = genero;
	}
	public CategoriaCancion getCategoria() {
		return categoria;
	}
	public void setCategoria(CategoriaCancion categoria) {
		this.categoria = categoria;
	}
	public boolean esRestringida() {
		boolean resul = false;
		if (this.getDiasPublicacion() < 7 && this.getCantVecesEscuchada() < 1000) {
			resul = true;
		}
		return resul;
	}
	public void sumarEscucha() {
		this.setCantVecesEscuchada(this.getCantVecesEscuchada() + 1);
	}
}
