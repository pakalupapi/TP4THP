package ejercicio2;
import java.util.ArrayList;
public class EdificioAlvear {
	private String direccion;
	private int totalDepartamentos;
	private ArrayList<Departamento> departamentos;
	private ArrayList<Departamento> morosos;
	
	public EdificioAlvear(int cantDeptos) {
		setDireccion("Puerto Madero, Bs As, Argentina");
		setTotalDepartamentos(cantDeptos);
		setDepartamentos(cantDeptos);
		this.morosos=new ArrayList<Departamento>();
	}
		
	public String getDireccion() {
		return direccion;
	}
	private void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public int getTotalDepartamentos() {
		return totalDepartamentos;
	}
	private void setTotalDepartamentos(int totalDepartamentos) {
		this.totalDepartamentos = totalDepartamentos;
	}
	private void setDepartamentos(int cantDeptos) {
		this.departamentos=new ArrayList<>();
		for (int i=1; i<=cantDeptos; i++) {
			departamentos.add(new Departamento(i));
		}
	}
	@Override
	public String toString() {
		return "EdificioAlvear [direccion=" + direccion + ", totalDepartamentos=" + totalDepartamentos + ", morosos="
				+ morosos + "]";
	}
	private Departamento dameUnidad(int numeroUnidad) {
		return this.departamentos.get(numeroUnidad - 1);
	}
	private void aMorosos(int numeroUnidad) {
		this.morosos.add(numeroUnidad);
	}
	private void bajaMoroso(int numeroUnidad) {
		this.morosos.remove(numeroUnidad);
	}
	public boolean ocuparUnidad(int numeroUnidad, String dniProp, String nombreProp) {
		Departamento unidad = dameUnidad(numeroUnidad);
		return unidad.habilitarUnidad(dniProp, nombreProp);
	}
	public void agregarDeuda(int numeroUnidad, double monto) {
		Departamento unidad = dameUnidad(numeroUnidad);
		
		if (numeroUnidad >=1 && numeroUnidad <= this.getTotalDepartamentos() && monto > 0) {
			unidad.actualizarDeuda(monto);
			this.aMorosos(numeroUnidad);
		}
	}
	public void cancelarDeuda(int numeroUnidad, double monto) {
		Departamento unidad = dameUnidad(numeroUnidad);
		
		if (numeroUnidad >= 1 && numeroUnidad <= getTotalDepartamentos() && monto > 0) {
			unidad.actualizarDeuda(-(monto));
		}
		if (unidad.getDeuda() == 0) {
			this.bajaMoroso(numeroUnidad);
		}
	}
	public void listarMorosos() {
		for (Departamento departamento: this.morosos) {
			System.out.println(departamento);
		}
	}
	public void listarUnidades() {
		for (Departamento departamento: departamentos) {
			System.out.println(departamento);
		}
	}
}
