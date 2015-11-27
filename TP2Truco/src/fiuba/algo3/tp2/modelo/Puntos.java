package fiuba.algo3.tp2.modelo;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class Puntos {
    
	private Map<Equipo, Integer> mapa;
	
	public Puntos(Equipo equipoUno, Equipo equipoDos){
		mapa = new HashMap<Equipo, Integer>();
		mapa.put(equipoUno, 0);
		mapa.put(equipoDos, 0);
	}
	
	public void anotarPuntos(Equipo equipo, int cantidad){
		int puntos = mapa.get(equipo);
		puntos = puntos + cantidad;
		mapa.put(equipo,puntos);
	}
	
	public int getPuntaje(Equipo equipo){
		return this.mapa.get(equipo);
	}
	
	public int getPuntaje(String equipo){
		Set<Equipo> set = mapa.keySet();
	
		Iterator<Equipo> itrK = set.iterator();
		
		while (itrK.hasNext()){
			Equipo actual = itrK.next();
			if (equipo == actual.obtenerNombre()) return this.mapa.get(actual);
		}
		return 0;
	}

	public int puntosDeLaFalta(String equipo) {
		Collection<Integer> coleccion = mapa.values();
		int max = Collections.max(coleccion);
		return (30-max);
	}

	public int getPuntajeMaximo() {
		Collection<Integer> coleccion = mapa.values();
		return Collections.max(coleccion);
	}

	public boolean rangoPicaPica() {
		Collection<Integer> coleccion = mapa.values();
		int max = Collections.max(coleccion);
		if (max>5 && max<25){
			return true;
		}else return false;
	}

	public void imprimirResultados() {
		Collection<Integer> coleccion = mapa.values();
		Set<Equipo> set = mapa.keySet();
	
		Iterator<Equipo> itrK = set.iterator();
		Iterator<Integer> itrV = coleccion.iterator();
		
		while (itrK.hasNext()){
			System.out.println("Equipo: " + itrK.next().obtenerNombre() + ", puntos: " + itrV.next());
		}
		System.out.println("\n");
	}

}
