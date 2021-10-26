package paquete;

import java.util.LinkedList;

public class PromocionAbsoluta extends Promocion {

	public PromocionAbsoluta(String nombre, LinkedList<Atraccion> atraccionesIncluidas, double precioDescuento) {
		super(nombre, atraccionesIncluidas);
		this.costo = precioDescuento;
	}

	@Override
	public String toString() {
		return " - Tipo: Absoluta \n - Atracciones Incluidas: " + atraccionesIncluidas + "\n - Precio Descuento: $"
				+ this.costo + "\n - Precio Original: $" + this.getCostoSinDescuento() + "\n - Duracion: " + this.getDuracion() + "hs.";
	}

	@Override
	protected double setCosto() {
		return 0;
	}

}
