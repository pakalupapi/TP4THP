package ejercicio1;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Agenda miAgenda=new Agenda();
		
		miAgenda.agregarPersona("Osvaldo", "Lucero", "Calle Falsa", "41265239");
		miAgenda.agregarPersona("Guadalupe", "Rotolo", "Quilmes", "2204134");
		miAgenda.agregarPersonaV2("Lorenzo", "Lucero", "Calle Falsa", "2134526343");
		miAgenda.listarPersonas();
		
		modificarDomicilio(miAgenda, "41265239", "Calle C");
		
		miAgenda.removerPersona("2204134");
		miAgenda.removerPersona("21434235");
		
		miAgenda.modificarDomicilio("41265239", "Calle verdadera");
		miAgenda.modificarDomicilio("12335342", "calle incierta");
		miAgenda.listarPersonas();
	}
	public static void modificarDomicilio(Agenda agenda, String dni, String domicilio) {
		if (agenda.modificarDomicilio(dni, domicilio)) {
			System.out.println("El domicilio ha sido modificado correctamente");
		}
		else {
			System.out.println("No se ha podido completar la solicitud");
		}
	}
}
