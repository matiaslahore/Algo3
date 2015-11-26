package fiuba.algo3.tp2.modelo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import fiuba.algo3.tp2.modeloDeCartas.TipoDeCartas;

public class Puntos {
    
	private Map<String, Integer> mapa;
	
	public Puntos(String equipoUno, String equipoDos){
		mapa = new HashMap<String, Integer>();
		mapa.put(equipoUno, 0);
		mapa.put(equipoDos, 0);
	}
	
	public void anotarPuntos(String equipo, int cantidad){
		int puntos = mapa.get(equipo);
		puntos = puntos + cantidad;
		mapa.put(equipo,puntos);
	}
	
	public int getPuntaje(String equipo){
		return this.mapa.get(equipo);
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
		Set<String> set = mapa.keySet();
	
		Iterator<String> itrK = set.iterator();
		Iterator<Integer> itrV = coleccion.iterator();
		
		while (itrK.hasNext()){
			System.out.println("Equipo: " + itrK.next() + ", puntos: " + itrV.next());
		}
		System.out.println("\n");
	}

}
