package fiuba.algo3.tp2.modelo;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class Puntos {
    
	private Map<Equipo, Integer> puntosDelJuego;
	
	public Puntos(Equipo equipoUno, Equipo equipoDos){
		puntosDelJuego = new HashMap<Equipo, Integer>();
		puntosDelJuego.put(equipoUno, 0);
		puntosDelJuego.put(equipoDos, 0);
	}
	
	public void anotarPuntos(Equipo equipo, int cantidad){
		int puntos = puntosDelJuego.get(equipo);
		puntos = puntos + cantidad;
		puntosDelJuego.put(equipo,puntos);
	}
	
	public int getPuntaje(Equipo equipo){
		return this.puntosDelJuego.get(equipo);
	}
	
	public int getPuntaje(String equipo){
		Set<Equipo> set = puntosDelJuego.keySet();
	
		Iterator<Equipo> itrK = set.iterator();
		
		while (itrK.hasNext()){
			Equipo actual = itrK.next();
			if (equipo == actual.obtenerNombre()) return this.puntosDelJuego.get(actual);
		}
		return 0;
	}

	public int puntosDeLaFalta(Equipo equipo) {
		int puntaje = puntosDelJuego.get(equipo);
		
		if (puntaje>15) return (30-puntaje);
		else return (15-puntaje);
	}

	public int getPuntajeMaximo() {
		Collection<Integer> coleccion = puntosDelJuego.values();
		return Collections.max(coleccion);
	}

	public boolean rangoEstaEnPicaPica() {
		Collection<Integer> coleccion = puntosDelJuego.values();
		int max = Collections.max(coleccion);
		if (max>5 && max<25){
			return true;
		}else return false;
	}

	public void imprimirResultados() {
		Collection<Integer> coleccion = puntosDelJuego.values();
		Set<Equipo> set = puntosDelJuego.keySet();
	
		Iterator<Equipo> itrK = set.iterator();
		Iterator<Integer> itrV = coleccion.iterator();
		
		while (itrK.hasNext()){
			System.out.println("Equipo: " + itrK.next().obtenerNombre() + ", puntos: " + itrV.next());
		}
		System.out.println("\n");
	}

}
