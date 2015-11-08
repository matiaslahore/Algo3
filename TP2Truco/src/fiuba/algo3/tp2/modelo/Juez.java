package fiuba.algo3.tp2.modelo;

public class Juez {

	Maso maso = new Maso();
	Estado estado = new Estado();
	
	public Juez(){
		maso = new Maso();
	}
	
	public Carta repartir(){
		//JUGADOR Q ES MANO LANZA EXCEPCION CUANDO TIENE MAS DE 3 CARTAS Y NO SE LA QUEDA LA 4TA
		//ASI EVITO SABER CUANTOS JUGADORES HAY JUGANDO.
		// PartidaDeTruco LE PIDE AL JUEZ Q REPARTA Y VA A IR DANDO CARTAS EN UN CICLO Q CORTA CON LA EXCEPCION
		return this.maso.dameCarta();
	}
	
}
