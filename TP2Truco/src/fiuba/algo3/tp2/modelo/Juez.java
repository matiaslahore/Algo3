package fiuba.algo3.tp2.modelo;

import java.util.ArrayList;
import java.util.Iterator;

import fiuba.algo3.tp2.modeloDeCartas.*;

public class Juez {

	Maso maso;
	Mesa mesa;
	Rondas mano;
	Puntos puntos;
	
	public Juez(Mesa mesa){
		maso = new Maso();
		this.mesa = mesa;
	}
	
	public TipoDeCartas repartir(){
		return this.maso.dameCarta();
	}
	// solo el juez puede anotar puntos. PRIVATE
	public void anotarPuntos (String equipo, int cantidad){
		this.mesa.anotarPuntos(equipo, cantidad);
	}

	public TipoDeCartas quienGana(ArrayList<TipoDeCartas> cartasEnJuego) {
		TipoDeCartas ganadora = cartasEnJuego.get(0); //me obliga a inicializar
		Iterator<TipoDeCartas> itr = cartasEnJuego.iterator();
		//Siempre van a ser cantidad de cartas pares (2,4,6)
		while(itr.hasNext()) {
			TipoDeCartas a = (TipoDeCartas) itr.next();
			TipoDeCartas b = (TipoDeCartas) itr.next();
			ganadora = ganador(a,b);
		}
		return ganadora;
	}
	
	private TipoDeCartas ganador(TipoDeCartas a, TipoDeCartas b){
		return a.vs(b);
	}
}
