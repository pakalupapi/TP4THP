package ejercicio2;

public class Departamento {
	private int numeroUnidad;
	private String dniProp;
	private String nombreProp;
	private boolean disponible;
	private double deuda;
	
	public Departamento(int numeroUnidad) {
		setNumeroUnidad(numeroUnidad);
		setDisponible(true);
		setDeuda(0);
	}
	public Departamento(int numeroUnidad, String dniProp, String nombreProp) {
		setNumeroUnidad(numeroUnidad);
		setDniProp(dniProp);
		setNombreProp(nombreProp);
		setDisponible(true);
		setDeuda(0);
	}
	public double getDeuda() {
		return deuda;
	}
	private void setDeuda(double deuda) {
		this.deuda = deuda;
	}
	public boolean isDisponible() {
		return disponible;
	}
	public void setDisponible(boolean disponible) {
		this.disponible = disponible;
	}
	public int getNumeroUnidad() {
		return numeroUnidad;
	}
	public void setNumeroUnidad(int numeroUnidad) {
		this.numeroUnidad = numeroUnidad;	
	}
	public String getDniProp() {
		return dniProp;
	}
	public void setDniProp(String dniProp) {
		this.dniProp = dniProp;
	}
	public String getNombreProp() {
		return nombreProp;
	}
	public void setNombreProp(String nombreProp) {
		this.nombreProp = nombreProp;
	}
	@Override
	public String toString() {
		return "Departamento [numeroUnidad=" + numeroUnidad + ", dniProp=" + dniProp + ", nombreProp=" + nombreProp
				+ ", disponible=" + disponible + ", deuda=" + deuda + "]";
	}
	public boolean habilitarUnidad(String dniProp, String nombreProp) {
		boolean resul = false;
		if (disponible) {
			this.setDniProp(dniProp);
			this.setNombreProp(nombreProp);
			resul = true;
		}
		return resul;
	}
	public void actualizarDeuda(double monto) {
		this.setDeuda(this.getDeuda() + monto);
	}
}
