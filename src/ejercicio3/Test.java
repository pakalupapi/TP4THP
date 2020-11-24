package ejercicio3;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Aplicacion aplicacion=new Aplicacion();
		System.out.println(aplicacion);
		
		agregarCancion("La key", "Abel Python", 10, 1999, Genero.ETC, aplicacion);
		System.out.println(aplicacion.escucharCancion("elosvi", "La key", "Abel Python"));
		aplicacion.altaUsuario("elosvi", "Lucero", 22, Categoria.PREMIUM);
		System.out.println(aplicacion.escucharCancion("elosvi", "La key", "Abel Python"));
		
		aplicacion.listarUsuariosPorCategoria(Categoria.PREMIUM);
	}
	public static void agregarCancion(String nombre, String autor, int diasPublicacion, int cantVecesEscuchada, Genero genero, Aplicacion aplicacion) {
		if (aplicacion.altaCancion(nombre, autor, diasPublicacion, cantVecesEscuchada, genero)) {
			System.out.println("Cancion agregada");
		}
		else {
			System.out.println("No se pudo agregar cancion; ya existe");
		}
	}

}
