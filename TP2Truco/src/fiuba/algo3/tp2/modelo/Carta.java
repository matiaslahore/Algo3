package fiuba.algo3.tp2.modelo;

public class Carta {

	Palo palo;
	int valor;
		
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
}
