package fiuba.algo3.tp2.modelo;

public class Carta {

	int palo;
	int valor;
	
	public Carta(int p, int v){
		this.palo = p;
		this.valor = v;
	}
	
	public String obtenerPalo(){
		
		switch (this.palo){
			
		case 1:
			return "Basto";
		case 2: 
			return "Copa";
		case 3:
			return "Espada";
		case 4:
			return "Oro";
		}
		//lanzar excepcion
		return "ERROR";
	}
	
	public int obtenerValor(){
		
		return this.valor;
	}

	public Object obtenerCartaComoString() {
		
		return "'" + this.obtenerValor()+ " de " + this.obtenerPalo() + "' ";
	}
}
