package fiuba.algo3.tp2.modelo;

import java.util.ArrayList;
import java.util.Iterator;

import fiuba.algo3.tp2.modeloDeCartas.*;

public class Juez {

	Maso maso;
	Mesa mesa;
	Mano mano;
	
	public Juez(Mesa mesa){
		maso = new Maso();
		this.mesa = mesa;
	}
	
	public TipoDeCartas repartir(){
		//JUGADOR Q ES MANO LANZA EXCEPCION CUANDO TIENE MAS DE 3 CARTAS Y NO SE LA QUEDA LA 4TA
		//ASI EVITO SABER CUANTOS JUGADORES HAY JUGANDO.
		// PartidaDeTruco LE PIDE AL JUEZ Q REPARTA Y VA A IR DANDO CARTAS EN UN CICLO Q CORTA CON LA EXCEPCION
		return this.maso.dameCarta();
	}
       // solo el juez puede anotar puntos. PRIVATE
	private void anotarPuntosEquipoUno (int cantidad){
		this.mesa.anotarPuntosEquipoUno(cantidad);
	}
	
	private void anotarPuntosEquipoDos (int cantidad){
		this.mesa.anotarPuntosEquipoDos(cantidad);
	}

	/*
	 * REIMPLEMENTAAAAAAAAAAAAAAAAAAAAAAR
	 */
	public Jugador quienGana(ArrayList<Carta> cartas) {
		//SIRVE PARA MUCHAS CARTAS!!
		Carta a = cartas.get(0);
		Iterator<Carta> itr = cartas.iterator();
		while(itr.hasNext()) {
			Carta b = (Carta) itr.next();
			if (a.esMenorQue(b)){
				a = b;
			}
		}
		//A cada Carta le pongo de quien es.. es medio flashero pero sino nose quien me la dio
		return a.deQuienSos();
	}
}
