package paquete;

public class Atraccion extends Producto implements Comparable<Producto> {

	protected double costo;
	protected double duracionHoras; // horas
	protected int cupoDisponible;
	protected int cupoMaximo;

	public Atraccion(String nombre, double costo, double duracionHoras, int cupoMaximo) {
		super(nombre);
		this.costo = costo;
		this.duracionHoras = duracionHoras;
		this.cupoMaximo = cupoMaximo;
		this.cupoDisponible=cupoMaximo;
	}

	
	public int getCupoDisponible() {
		return this.cupoDisponible;
	}
	
	public double getCosto() {
		return this.costo;
	}
	public double getDuracion() {
		return this.duracionHoras;
	}

	public void setCupoDisponible() {
		this.cupoDisponible = this.cupoMaximo;
	}


	public void reservar() {
		this.cupoDisponible--;
	}


	@Override
	public String toString() {
		return this.getNombre();
	}
	public String mostrarComoAtraccion() {
		return " - Nombre: "  + nombre + "\n - Precio: $" + costo + "\n - Duracion: " + duracionHoras + "hs.";
	}
	
	
	@Override
	protected double setCosto() {
		return costo;	
	}


	@Override
	public int compareTo(Producto atraccion) {
		Double duracion1 = this.getDuracion();
		return duracion1.compareTo(atraccion.getDuracion());
	}

}
