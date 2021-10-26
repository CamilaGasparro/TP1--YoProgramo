package test;

import static org.junit.Assert.*;

import java.util.LinkedList;

import org.junit.Test;


import paquete.Atraccion;
import paquete.Promocion;
import paquete.PromocionAbsoluta;
import paquete.Usuario;

public class UsuarioTest {

	@Test
	public void aceptarAtraccion() {
		Atraccion a1 = new Atraccion("depto1", 10, 30, 200);
		Usuario u1 = new Usuario("Pepe", "1000", "500");
		u1.aceptarAtraccion(a1);
		Double monedasRestantesEsperadas =  (double) 990;
		Double monedasRestantesReal=u1.getMonedasDisponibles();
		assertEquals(monedasRestantesReal,monedasRestantesEsperadas);	
		Double tiempoRestanteEsperado =  (double) 470;
		Double tiempoRestanteReal=u1.getTiempoDisponible();
		assertEquals(tiempoRestanteReal,tiempoRestanteEsperado);
	}

	@Test
	public void aceptarPromocion() {
		Atraccion a1 = new Atraccion("depto1", 10, 3, 200);
		Atraccion a2 = new Atraccion("depto2", 20, 6, 400);
		LinkedList<Atraccion> atraccionesInc = new LinkedList<Atraccion>();
		atraccionesInc.add(a1);
		atraccionesInc.add(a2);
		Promocion p1 = new PromocionAbsoluta("Pack1", atraccionesInc, 10);
		Usuario u1 = new Usuario("Pepe", "1000", "50");
		u1.aceptarPromocion(p1);
		Double monedasRestantesEsperadas =  (double) 990;
		Double monedasRestantesReal=u1.getMonedasDisponibles();
		assertEquals(monedasRestantesReal,monedasRestantesEsperadas);	
		Double tiempoRestanteEsperado =  (double) 41;
		Double tiempoRestanteReal=u1.getTiempoDisponible();
		assertEquals(tiempoRestanteReal,tiempoRestanteEsperado);
		assertEquals (atraccionesInc,u1.getAtraccionesVisitadas());
	}
}
