package fiuba.algo3.tp2.modelo;

public class Carta {

	Palo palo;
	int valor;
	Jugador jugador;
	int jerarquia;
		
	public Carta(Palo unPalo, int unValor){
		palo = unPalo;
		valor = unValor;
		
		if (this.valor == 4) this.jerarquia = 1;
		if (this.valor == 5) this.jerarquia = 2;
		if (this.valor == 6) this.jerarquia = 3;
		if (this.valor == 10) this.jerarquia = 5;
		if (this.valor == 11) this.jerarquia = 6;
		if (this.valor == 12) this.jerarquia = 7;
		if (this.valor == 2) this.jerarquia = 9;
		if (this.valor == 3) this.jerarquia = 10;
		
		if ((this.valor == 7) && (this.palo.getClass()==Espada.class)){
			this.jerarquia = 12;
		}else if (this.palo.getClass()==Oro.class) {
			this.jerarquia = 11;
			}else this.jerarquia = 4;//7 de basto o copa
		
		if ((this.valor == 1) && (this.palo.getClass()==Espada.class)){
			this.jerarquia = 14;
		}else if (this.palo.getClass()==Basto.class) {
			this.jerarquia = 13;
			}else this.jerarquia = 8;//1 de oro o copa
		//ESTO ESTA HECHO A MODO GROSERO PARA CHEQUEAR UNAS COSAS
		//HAY QUE PONERLO LINDO
	}
	
	public String obtenerPaloComoString(){
		return palo.obtenerPaloComoString();
	}
	
	public int obtenerValor(){
		return valor;
	}

	public Object obtenerCartaComoString() {
		return "'" + this.obtenerValor()+ " de " + this.obtenerPaloComoString() + "' ";
	}

	public Palo obtenerPalo(){
		return this.palo;
	}
	
	public int valor(){
		return this.valor;
	}

	public boolean esMenorQue(Carta b) {
		if (this.jerarquia < b.jerarquia()) return true;
		else return false;
		//Hay q contemplar el caso parda..
	}

	private int jerarquia() {
		return this.jerarquia;
	}

	public Jugador deQuienSos() {
		return this.jugador;
	}
	
	public void cargarJugador(Jugador jug){
		this.jugador = jug;
	}	
}
