package ejercicio3;
import java.util.ArrayList;
public class Aplicacion {
	private ArrayList<Cancion> canciones;
	private ArrayList<Usuario> usuarios;
	
	public Aplicacion() {
		this.canciones=new ArrayList<Cancion>();
		this.usuarios=new ArrayList<Usuario>();
	}
	private Cancion dameCancion(int num) {
		return this.canciones.get(num);
	}
	private Usuario dameUsuario(int num) {
		return this.usuarios.get(num);
	}
	private void agregarCancion(Cancion cancion) {
		this.canciones.add(cancion);
	}
	private void agregarUsuario(Usuario usuario) {
		this.usuarios.add(usuario);
	}
	private Cancion buscarCancion(String titulo, String autor) {
		Cancion cancionBuscada = null;
		int i = 0;
		
		while (i < canciones.size() && cancionBuscada == null) {
			Cancion cancionEncontrada = this.dameCancion(i);
			if (cancionEncontrada.getNombre().equalsIgnoreCase(titulo) && cancionEncontrada.getAutor().equalsIgnoreCase(autor)){
				cancionBuscada = cancionEncontrada;
			}
			i++;
		}
		return cancionBuscada;
	}
	private Usuario buscarUsuario(String email) {
		Usuario usuarioBuscado = null;
		int i = 0;
		while (i < this.usuarios.size() && usuarioBuscado == null) {
			Usuario usuarioEncontrado = this.dameUsuario(i);
			if (usuarioEncontrado.getEmail().equalsIgnoreCase(email)) {
				usuarioBuscado = usuarioEncontrado;
			}
			i++;
		}
		return usuarioBuscado;
	}
	public boolean altaCancion(String nombre, String autor, int diasPublicacion,  int cantVecesEscuchada, Genero genero) {
		boolean resul = false;
		if (this.buscarCancion(nombre, autor) == null) {
			this.agregarCancion(new Cancion(nombre, autor, diasPublicacion, cantVecesEscuchada, genero));
			resul = true;
		}
		return resul;
	}
	public boolean altaUsuario(String mail, String apellido, int edad, Categoria categoria) {
		boolean resul = false;
		if (this.buscarUsuario(mail) == null) {
			this.agregarUsuario(new Usuario(mail, apellido, edad, categoria));
		}
		return resul;
	}
	public ResulOperacion escucharCancion(String email, String nombre, String autor) {
		ResulOperacion resul;
		Usuario usuarioBuscado = this.buscarUsuario(email);
		Cancion cancionBuscada;
		
		if (usuarioBuscado == null){
			resul = ResulOperacion.USUARIO_INEXISTENTE;
		}
		else {
			cancionBuscada = this.buscarCancion(nombre, autor);
			if (cancionBuscada == null) {
				resul = ResulOperacion.CANCION_INEXISTENTE;
			}
			else {//existe cancion y usuario
				if (usuarioBuscado.getCategoria() == Categoria.GRATUITO && usuarioBuscado.esRestringido(cancionBuscada)) {
					resul = ResulOperacion.LIMITE_ALCANZADO;
				}
				else {
					if (usuarioBuscado.getCategoria() != Categoria.PREMIUM && this.restringida(cancionBuscada)) {
						// cancionBuscada.esRestringida() no es usada ya que el que tiene los parametros a aplicar deberia ser la aplicacion.
						resul = ResulOperacion.CANCION_NO_DISPONIBLE;
					}
					else {
						resul = ResulOperacion.CANCION_ESCUCHADA;
						cancionBuscada.sumarEscucha();
						usuarioBuscado.sumaCancionEscuchada(cancionBuscada);
					}
				}
			}
		}
		return resul;
	}
	private boolean restringida(Cancion cancion) {
		return cancion.getDiasPublicacion() < 7 || cancion.getCantVecesEscuchada() < 1000;
	}
	public void listarUsuarios() {
		for (Usuario usuario: this.usuarios) {
			System.out.println("Usuario: "+ usuario.getEmail()+ " escuchó "+ usuario.cantCancionesEscuchadas()+ "canciones.");
		}
	}
	public void listarCancionesPorUsuario(String email) {
		Usuario usuarioBuscado = this.buscarUsuario(email);
		if (usuarioBuscado != null) {
			usuarioBuscado.listarCancionesEscuchadas();
			System.out.println("Operacion exitosa");
		}
		else {
			System.out.println("El usuario es inexistente");
		}
	}
	public void listarUsuariosPorCategoria(Categoria categoria) {
		System.out.println("Lista de usuarios de categoria: "+ categoria);
		for (Usuario usuario: this.usuarios) {
			if (usuario.getCategoria() == categoria) {
				System.out.println(usuario);
			}
		}
	}
}
