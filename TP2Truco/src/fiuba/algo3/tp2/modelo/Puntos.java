package fiuba.algo3.tp2.modelo;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

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

}
