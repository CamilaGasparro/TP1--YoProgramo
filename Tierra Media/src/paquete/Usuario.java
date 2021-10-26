package paquete;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;

public class Usuario {
	protected String nombre;
	protected double monedasDisponibles;
	protected double tiempoDisponible; // horas
	protected LinkedList<Atraccion> atraccionesVisitadas;
	private double monedasInicial;
	private double tiempoInicial;
	

	public Usuario(String nombre, String monedasDisponibles, String tiempoDisponible) {
		this.nombre = nombre;
		this.monedasDisponibles = Double.parseDouble(monedasDisponibles);
		this.monedasInicial = Double.parseDouble(monedasDisponibles);
		this.tiempoDisponible = Double.parseDouble(tiempoDisponible);
		this.tiempoInicial = Double.parseDouble(tiempoDisponible);
		atraccionesVisitadas = new LinkedList<>();
	}

	public boolean aceptarPromocion(Promocion promocion) {
		this.tiempoDisponible -= promocion.getDuracion();
		this.monedasDisponibles -= promocion.getCosto();
		for (Atraccion atraccion : promocion.atraccionesIncluidas) {
			this.atraccionesVisitadas.add(atraccion);
			atraccion.reservar();

		}
		System.out.println("Promocion '" + promocion.getNombre() + "' reservada correctamente.");

		return true;
	}

	public boolean aceptarAtraccion(Atraccion atraccion) {
			this.tiempoDisponible -= atraccion.duracionHoras;
			this.monedasDisponibles -= atraccion.costo;
			this.atraccionesVisitadas.add(atraccion);
			atraccion.reservar();
			System.out.println("Atraccion '" + atraccion.getNombre() + "' reservada correctamente.");
		
		return true;
	}

	public void mostrarResumenTotal() {
		System.out.println("\n");
		System.out.println("ESTE ES EL REGISTRO DE " + this.nombre.toUpperCase() + ":");
		System.out.println(" - Tiempo invertido en Tierra Media: " + this.tiempoGastado() + " hs.");
		System.out.println(" - Monedas gastadas en Tierra Media: " + this.monedasGastadas() + ".");
		System.out.println(" - Atracciones visitadas: "+this.atraccionesVisitadas);
		System.out.println(" - Monedas remanentes: "+this.monedasDisponibles);
		System.out.println(" - Tiempo restante: "+this.tiempoDisponible);
		System.out.println("\n");
	}
	
	
	public void crearArchivoDeAtracciones() {
		PrintWriter registroDeAtracciones = null;
		try {
			registroDeAtracciones = new PrintWriter(
					new FileWriter("Registro de Atracciones de " + this.getNombre() + ".txt"));
			registroDeAtracciones.print("REGISTRO DE " + this.nombre.toUpperCase() + ":");
			registroDeAtracciones.print("\n - Tiempo invertido en Tierra Media: " + this.tiempoGastado() + " hs.");
			registroDeAtracciones.print("\n - Monedas gastadas en Tierra Media: " + this.monedasGastadas() + ".");
			registroDeAtracciones.print("\n - Atracciones visitadas: "+this.atraccionesVisitadas);
			registroDeAtracciones.print("\n - Monedas remanentes: "+this.monedasDisponibles);
			registroDeAtracciones.print("\n - Tiempo restante: "+this.tiempoDisponible);
			
		
		} catch (IOException e) {
			e.printStackTrace();
		}
		registroDeAtracciones.close();
		System.out.println("Archivo creado correctamente.\n");
	}

	public double getMonedasDisponibles() {
		return this.monedasDisponibles;
	}

	public double getTiempoDisponible() {
		return this.tiempoDisponible;
	}

	public String getNombre() {
		return this.nombre;
	}

	@Override
	public String toString() {
		return "\n---Usuario: " + nombre + "---" + "\nMonedas= " + monedasDisponibles + "\nTiempo=" + tiempoDisponible
				+ "\nAtracciones Visitadas=" + atraccionesVisitadas + "\n-------";
	}
	public double monedasGastadas() {
		return monedasInicial - monedasDisponibles;
	}
	
	public double tiempoGastado() {
		return tiempoInicial - tiempoDisponible;
	}

	public LinkedList<Atraccion> getAtraccionesVisitadas() {
		return atraccionesVisitadas;
	}

}
