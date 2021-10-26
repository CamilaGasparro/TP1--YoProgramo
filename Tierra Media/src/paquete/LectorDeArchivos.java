package paquete;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;

public class LectorDeArchivos {

	public static LinkedList<Usuario> cargarUsuarios(String path) {

		FileReader fr = null;
		BufferedReader br = null;

		LinkedList<Usuario> listaDeUsuarios = new LinkedList<Usuario>();

		try {
			fr = new FileReader(path);
			br = new BufferedReader(fr);
			String linea = br.readLine();
			while (linea != null) {
				String[] datos = linea.split(",");
				String nombre = datos[0];
				String monedasDisponibles = datos[1];
				String tiempoDisponible = datos[2];

				listaDeUsuarios.add(new Usuario(nombre, monedasDisponibles, tiempoDisponible));
				linea = br.readLine();
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (fr != null) {
				try {
					fr.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return listaDeUsuarios;
	}

	public static LinkedList<Promocion> cargarPromociones(String path) {

		FileReader fr = null;
		BufferedReader br = null;

		LinkedList<Atraccion> atracciones = LectorDeArchivos.cargarAtracciones("src/Atracciones.txt");
		LinkedList<Promocion> listaDePromociones = new LinkedList<Promocion>();
		LinkedList<Atraccion> atraccionesIncluidas;
		LinkedList<Atraccion> atraccionesGratis;

		try {
			fr = new FileReader(path);
			br = new BufferedReader(fr);
			String linea = br.readLine();
			while (linea != null) {
				atraccionesIncluidas = new LinkedList<Atraccion>();
				atraccionesGratis = new LinkedList<Atraccion>();

				String[] datos = linea.split(",");
				String nombrePack = datos[0];
				int i = 0;
				int j = 2;
				while (i != Integer.parseInt(datos[1])) {
					for (Atraccion unaAtraccion : atracciones) {
						if (unaAtraccion.nombre.equals(datos[j])) {
							atraccionesIncluidas.add(unaAtraccion);
						}
					}

					i++;
					j++;
				}

				String tipoPromocion = datos[j];
				j++;

				if (tipoPromocion.equals("Absoluta")) {
					double precioDescuento = Double.parseDouble(datos[j]);
					Promocion unaPromocionAbsoluta = new PromocionAbsoluta(nombrePack, atraccionesIncluidas,
							precioDescuento);
					listaDePromociones.add(unaPromocionAbsoluta);

				} else if (tipoPromocion.equals("Porcentual")) {
					double porcentajeDescuento = Double.parseDouble(datos[j]);
					Promocion unaPromocionPorcentual = new PromocionPorcentual(nombrePack, atraccionesIncluidas,
							porcentajeDescuento);
					listaDePromociones.add(unaPromocionPorcentual);

				} else if (tipoPromocion.equals("AxB")) {
					int cantidadGratis = Integer.parseInt(datos[j]);

					j++;
					int n = 0;
					while (n != cantidadGratis) {
						for (Atraccion unaAtraccion : atracciones) {
							if (unaAtraccion.nombre.equals(datos[j])) {
								atraccionesGratis.add(unaAtraccion);
							}
						}
						j++;
						n++;

					}

					Promocion unaPromocionAxB = new PromocionAxB(nombrePack, atraccionesIncluidas, atraccionesGratis);
					listaDePromociones.add(unaPromocionAxB);
				}
				linea = br.readLine();
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (fr != null) {
				try {
					fr.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return listaDePromociones;
	}

	public static LinkedList<Atraccion> cargarAtracciones(String path) {

		FileReader fr = null;
		BufferedReader br = null;

		LinkedList<Atraccion> listaDeAtracciones = new LinkedList<Atraccion>();

		try {
			fr = new FileReader(path);
			br = new BufferedReader(fr);
			String linea = br.readLine();
			while (linea != null) {
				String[] datos = linea.split(",");
				String nombreAtraccion = datos[0];
				Double costoMonedas = Double.parseDouble(datos[1]);
				Double tiempoNecesario = Double.parseDouble(datos[2]);
				Integer cupoMaximo = Integer.parseInt(datos[3]);
				listaDeAtracciones.add(new Atraccion(nombreAtraccion, costoMonedas, tiempoNecesario, cupoMaximo));
				linea = br.readLine();
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (fr != null) {
				try {
					fr.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return listaDeAtracciones;
	}
}
