package paquete;

import java.util.LinkedList;

public class PromocionAxB extends Promocion {
	LinkedList<Atraccion> atraccionesGratuitas = new LinkedList<Atraccion>();
	LinkedList<Atraccion> atraccionesTotales = new LinkedList<Atraccion>();

	public PromocionAxB(String nombre, LinkedList<Atraccion> atraccionesIncluidas,
			LinkedList<Atraccion> atraccionesGratis) {
		super(nombre, atraccionesIncluidas); // atracciones pagas
		atraccionesGratuitas = atraccionesGratis;
		this.costo = setCosto();
	}

	@Override
	public String toString() {
		return " - Tipo: AxB \n - Atracciones Incluidas: " + this.getAtraccionesTotales() + "\n - Precio Descuento: $"
				+ this.costo + "\n - Precio Original: $" + this.obtenerCostoSinDescuento()+ "\n - Duracion: " + this.getDuracion() + "hs.";
	}

	protected double setCosto() {
		double costoAtracciones = 0;
		for (Atraccion atraccion : atraccionesIncluidas) {
			costoAtracciones += atraccion.getCosto();
		}
		return this.costo = costoAtracciones;
	}

	public LinkedList<Atraccion> getAtraccionesTotales() {
		for (Atraccion atraccion : atraccionesIncluidas) {
			atraccionesTotales.add(atraccion);
		}
		for (Atraccion atraccion : atraccionesGratuitas) {
			atraccionesTotales.add(atraccion);
		}
		return atraccionesTotales;
	}

	public double obtenerCostoSinDescuento() {
		double costoSinDescuento = 0;
		for (Atraccion atraccion : atraccionesGratuitas) {
			costoSinDescuento += atraccion.getCosto();
		}
		return this.costo + costoSinDescuento;
	}
}
