package test;

import static org.junit.Assert.*;

import java.util.LinkedList;

import org.junit.Test;

import paquete.Atraccion;
import paquete.Ofertador;
import paquete.Promocion;
import paquete.PromocionAbsoluta;
import paquete.Usuario;

public class OfertadorTest {

	@Test
	public void testOfertarAtraccion() {
		// preparar pureba, crear elementos y contexto
		boolean valorObtenido;
		Usuario u1 = new Usuario("Pepe", "1000", "500");
		Atraccion a1 = new Atraccion("depto1", 10, 30, 200);
		Atraccion a2 = new Atraccion("depto2", 20, 2, 200);
		Atraccion a3 = new Atraccion("depto3", 30, 3, 200);
		LinkedList<Atraccion> atraccionesInc2 = new LinkedList<Atraccion>();
		atraccionesInc2.add(a1);
		atraccionesInc2.add(a2);
		atraccionesInc2.add(a3);
		Ofertador o1 = new Ofertador();
		
		//ejecutar
		valorObtenido=o1.ofertarAtraccion(atraccionesInc2,u1);
		
		// verificar respuestas
		assertEquals(valorObtenido,true);
	
	}
	
	@Test
	public void testOfertarPromocion() {
		// preparar pureba, crear elementos y contexto
		boolean valorObtenido;
		Atraccion a1 = new Atraccion("depto1", 10, 30, 200);
		Atraccion a2 = new Atraccion("depto2", 20, 2, 200);
		Atraccion a3 = new Atraccion("depto3", 30, 3, 200);
		Atraccion a4 = new Atraccion("depto4", 40, 4, 200);
		Atraccion a5 = new Atraccion("depto5", 50, 50, 200);
		
		LinkedList<Atraccion> atraccionesInc = new LinkedList<Atraccion>();
		atraccionesInc.add(a1);
		atraccionesInc.add(a2);
		atraccionesInc.add(a3);
		atraccionesInc.add(a4);
		atraccionesInc.add(a5);
		
		LinkedList<Atraccion> atraccionesInc2 = new LinkedList<Atraccion>();
		atraccionesInc2.add(a1);
		atraccionesInc2.add(a2);
		atraccionesInc2.add(a3);
		
		LinkedList<Atraccion> atraccionesInc3 = new LinkedList<Atraccion>();
		//atraccionesInc3.add(a1);
		atraccionesInc3.add(a4);
		atraccionesInc3.add(a5);
		
		Promocion p1 = new PromocionAbsoluta("Probando promos", atraccionesInc, 10);
		Promocion p2 = new PromocionAbsoluta("Probando promosA", atraccionesInc2, 47);
		Promocion p3 = new PromocionAbsoluta("Probando promosB", atraccionesInc3, 20);
		
		LinkedList<Promocion> promos = new LinkedList<Promocion>();
		promos.add(p1);
		promos.add(p2);
		promos.add(p3);
		Usuario u1 = new Usuario("Pepe", "1000", "500");
		Ofertador o1 = new Ofertador();
		
		//ejecutar
		valorObtenido=o1.ofertarPromociones(promos,u1);
		
		// verificar respuestas
		assertEquals(valorObtenido,true);
	
	}
}
