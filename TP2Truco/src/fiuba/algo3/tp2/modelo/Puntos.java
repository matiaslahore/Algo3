package fiuba.algo3.tp2.modelo;

public class Puntos {
    
	private int puntajeUno;
	private int puntajeDos;
	
	public Puntos(){
		this.puntajeUno=0;
		this.puntajeDos=0;
	}
	
	public void anotarPuntajeUno (int cantidad){
		this.puntajeUno+=cantidad;
	}
	
	public void anotarPuntajeDos (int cantidad){
		this.puntajeDos+=cantidad;
	}
	
	public int getPuntajeUno(){
		return this.puntajeUno;
	}
	
	public int getPuntajeDos(){
		return this.puntajeDos;
	}
}
