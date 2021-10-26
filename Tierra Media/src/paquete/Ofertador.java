package paquete;

import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;

public class Ofertador {
	Scanner scaneador1 = new Scanner(System.in);

	public boolean ofertarPromociones(LinkedList<Promocion> promociones, Usuario usuario) {
		LinkedList<Promocion> auxPromos = new LinkedList<Promocion>();
		LinkedList<String> nombresAgregados = new LinkedList<>();
		boolean bandera = true;
		for (Promocion promocion : promociones) {
			for (Atraccion atraccionIncluidaPromo : promocion.atraccionesIncluidas) {
				for (String nombreAtraccion : nombresAgregados) {
					if (atraccionIncluidaPromo.getNombre().equals(nombreAtraccion)) {
						bandera = false;
					}
				}
			}
			if (promocion.getCosto() <= usuario.monedasDisponibles
					&& promocion.getDuracion() <= usuario.tiempoDisponible && promocion.getCupoDisponible() > 0
					&& bandera == true) {
				System.out.println("Promocion"); 
				System.out.println(promocion.toString());
				System.out.println("Acepta sugerencia? Ingrese S o N");
				String seleccionDelUsuario = scaneador1.nextLine();
				if (seleccionDelUsuario.equals("S")) {
					usuario.aceptarPromocion(promocion);
					/*auxPromos.add(promocion);
					for (Atraccion atr : promocion.atraccionesIncluidas) {
						nombresAgregados.add(atr.getNombre());
					}*/
					System.out.println("�Aceptada!");
					System.out.println("\n");
				}else {
					System.out.println("\n");
				}
			}
			bandera = true;
		}
		/*for (Promocion promocion : auxPromos) {
			usuario.aceptarPromocion(promocion);
		}*/
		return true;
	}

	public boolean ofertarAtraccion(LinkedList<Atraccion> atracciones, Usuario usuario) {
		String seleccionDelUsuario;
		LinkedList<Atraccion> auxAtr = new LinkedList<Atraccion>();
		LinkedList<String> nombresAgregados = new LinkedList<>();
		boolean bandera = true;
		for (Atraccion atraccion : atracciones) {
			for (Atraccion atraccionVisitada : usuario.atraccionesVisitadas) {
				if (atraccionVisitada.getNombre().equals(atraccion.getNombre())) {
					bandera = false;
				}
			}
			
			if (atraccion.getCosto() <= usuario.monedasDisponibles
					&& atraccion.getDuracion() <= usuario.tiempoDisponible && atraccion.getCupoDisponible() > 0
					&& bandera == true) {
				System.out.println("Atraccion"); 
				System.out.println(" - Nombre: "+atraccion.nombre);
				System.out.println(" - Precio: $" + atraccion.costo);
				System.out.println(" - Duracion: " + atraccion.duracionHoras + "hs.");
				System.out.println("Acepta sugerencia? Ingrese S o N");
				seleccionDelUsuario = scaneador1.nextLine();
				if (seleccionDelUsuario.equals("S")) {
					//auxAtr.add(atraccion);
					//nombresAgregados.add(atraccion.getNombre());
					usuario.aceptarAtraccion(atraccion);
					System.out.println("�Aceptada!");
					System.out.println("\n");
				}else {
					System.out.println("\n");
				}
			}
			bandera = true;
		}
		/*for (Atraccion atraccion : auxAtr) {
			usuario.aceptarAtraccion(atraccion);
		}*/

		return true;
	}

	public boolean ofertarPorCosto(LinkedList<Promocion> promociones, LinkedList<Atraccion> atracciones,
			Usuario usuario) {
		System.out.println("�Hola "+usuario.nombre+ ", Bienvenido a la Tierra Media!");
		System.out.println("Empezaremos por ofertarte algunas promociones");
		System.out.println("Te pedimos responder con �S� para aceptar o �N� para rechazar.");
		Collections.sort(promociones, Collections.reverseOrder(new CostoComparator()));
		this.ofertarPromociones(promociones, usuario);
		System.out.println("Ahora seguiremos con algunas Atracciones");
		Collections.sort(atracciones, Collections.reverseOrder(new CostoComparator())); 
		this.ofertarAtraccion(atracciones, usuario);
		System.out.println("�Muchas gracias por visitarnos, te esperamos nuevamente!");
		return true;
	}

	public boolean ofertarPorDuracion(LinkedList<Promocion> promociones, LinkedList<Atraccion> atracciones,
			Usuario usuario) {
		System.out.println("�Hola "+usuario.nombre+ ", Bienvenido a la Tierra Media!");
		System.out.println("Empezaremos por ofertarte algunas promociones");
		System.out.println("Te pedimos responder con �S� para aceptar o �N� para rechazar.");
		Collections.sort(promociones, Collections.reverseOrder());
		this.ofertarPromociones(promociones, usuario);
		System.out.println("Ahora seguiremos con algunas Atracciones");
		Collections.sort(atracciones, Collections.reverseOrder()); 
		this.ofertarAtraccion(atracciones, usuario);
		System.out.println("�Muchas gracias por visitarnos, te esperamos nuevamente!");
		return true;
	}
}
