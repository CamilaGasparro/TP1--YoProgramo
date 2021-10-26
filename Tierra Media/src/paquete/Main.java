package paquete;

import java.util.LinkedList;

public class Main {

	public static void main(String[] args) {

		// Leer archivos de promociones, atracciones y usuarios
		LinkedList<Atraccion> atracciones = LectorDeArchivos.cargarAtracciones("src/Atracciones.txt");
		LinkedList<Promocion> promociones = LectorDeArchivos.cargarPromociones("src/promociones.txt");
		LinkedList<Usuario> usuarios = LectorDeArchivos.cargarUsuarios("src/Usuarios.txt");

		Ofertador o1 = new Ofertador();

		for (Usuario usuario : usuarios) {
			o1.ofertarPorCosto(promociones, atracciones, usuario);
			usuario.mostrarResumenTotal();
			usuario.crearArchivoDeAtracciones();
		}
	}
}