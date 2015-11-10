package fiuba.algo3.tp2.modelo;

public class Juez {

	Maso maso;
	Jugada jugada;
	Mesa mesa;
	Mano mano;
	
	public Juez(Mesa mesa){
		maso = new Maso();
		this.mesa= mesa;
	}
	
	public Carta repartir(){
		//JUGADOR Q ES MANO LANZA EXCEPCION CUANDO TIENE MAS DE 3 CARTAS Y NO SE LA QUEDA LA 4TA
		//ASI EVITO SABER CUANTOS JUGADORES HAY JUGANDO.
		// PartidaDeTruco LE PIDE AL JUEZ Q REPARTA Y VA A IR DANDO CARTAS EN UN CICLO Q CORTA CON LA EXCEPCION
		this.mano= new Mano();
		return this.maso.dameCarta();
	}
       // solo el juez puede anotar puntos. PRIVATE
	private void anotarPuntosEquipoUno (int cantidad){
		this.mesa.anotarPuntosEquipoUno(cantidad);
	}
	
	private void anotarPuntosEquipoDos (int cantidad){
		this.mesa.anotarPuntosEquipoDos(cantidad);
	}
}
