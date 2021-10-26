package paquete;

import java.util.LinkedList;

public class PromocionPorcentual extends Promocion {
	protected double porcentajeDescuento;

	public PromocionPorcentual(String nombre, LinkedList<Atraccion> atraccionesIncluidas, double porcentajeDescuento) {
		super(nombre, atraccionesIncluidas);
		this.costo = Math.round(this.getCostoSinDescuento() * (1 - porcentajeDescuento));

	}

	@Override
	public String toString() {
		return " - Tipo: Porcentual \n - Atracciones Incluidas: " + atraccionesIncluidas + "\n - Precio Descuento: $"
				+ this.costo + "\n - Precio Original: $" + this.getCostoSinDescuento()+ "\n - Duracion: " + this.getDuracion() + "hs.";
	}

	@Override
	protected double setCosto() {
		return 0;
	}
}
