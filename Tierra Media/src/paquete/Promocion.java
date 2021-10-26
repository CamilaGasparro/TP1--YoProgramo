package paquete;

import java.util.LinkedList;

public abstract class Promocion extends Producto {

	public LinkedList<Atraccion> atraccionesIncluidas;
	protected double costoSinDescuento;

	double sumadorDuracion;

	public Promocion(String nombre, LinkedList<Atraccion> atraccionesIncluidas) {
		super(nombre);
		this.atraccionesIncluidas = atraccionesIncluidas;
		this.costoSinDescuento = getCostoSinDescuento();
	}

	public boolean agregarAtraccion(Atraccion atraccion) {
		return atraccionesIncluidas.add(atraccion);
	}

	public boolean sacarAtraccion(Atraccion atraccion) {
		return atraccionesIncluidas.remove(atraccion);
	}

	public boolean agregarTodasLasAtracciones(LinkedList<Atraccion> atraccionesIncluidas) {
		return atraccionesIncluidas.addAll(atraccionesIncluidas);
	}

	public double getCostoSinDescuento() {
		double costoSinDescuento = 0;
		for (Atraccion atraccion : atraccionesIncluidas) {
			costoSinDescuento += atraccion.getCosto();
		}
		return costoSinDescuento;
	}

	@Override
	public double getDuracion() {
		double duracionHorasPromocion = 0;
		for (Atraccion atraccion : atraccionesIncluidas) {
			duracionHorasPromocion += atraccion.getDuracion();
		}
		return duracionHorasPromocion;
	}

	@Override
	public int getCupoDisponible() {
		int menorCupoDiponible = 10000;
		for (Atraccion atraccion : atraccionesIncluidas) {
			if (atraccion.getCupoDisponible() < menorCupoDiponible) {
				menorCupoDiponible = atraccion.getCupoDisponible();
			}
		}
		return menorCupoDiponible;
	}

	public String listarNombreAtracciones() {
		LinkedList<String> nombresAtracciones = new LinkedList<>();
		for (Atraccion atraccion : atraccionesIncluidas) {
			nombresAtracciones.add(atraccion.getNombre());
		}
		return nombresAtracciones.toString();
	}

	@Override
	public String toString() {
		return "Promocion: " + nombre + " \natraccionesIncluidas=" + atraccionesIncluidas + "\ntipoPromocion=";
	}

	@Override
	public double getCosto() {
		return this.costo;
	}

}
