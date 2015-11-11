package fiuba.algo3.tp2.modelo;

public class Carta {

	Palo palo;
	int valor;
	Jugador jugador;
		
	public Carta(Palo unPalo, int unValor){
		palo = unPalo;
		valor = unValor;
	}
	
	public String obtenerPalo(){
		return palo.obtenerPalo();
	}
	
	public int obtenerValor(){
		return valor;
	}

	public Object obtenerCartaComoString() {
		return "'" + this.obtenerValor()+ " de " + this.obtenerPalo() + "' ";
	}

	public Palo palo(){
		return this.palo;
	}
	
	public int valor(){
		return this.valor;
	}

	public boolean esMenorQue(Carta b) {
		//LO DEJO PARA TERMINAR BIEN
		if (this.palo.getClass() == b.palo().getClass()) {
			if (this.valor < b.valor()) return true;
			else return false;
		}
		else { // comprar cartas
			return false;
		}
	}

	public Jugador deQuienSos() {
		return this.jugador;
	}
	
	public void cargarJugador(Jugador jug){
		this.jugador = jug;
	}
	
}
