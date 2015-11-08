package fiuba.algo3.tp2.modelo;

public class Carta {

	Palo palo;
	int valor;
		
	public Carta(Palo unPalo, int valor){
		this.palo = unPalo;
		this.valor = valor;
	}
	
	public String obtenerPalo(){
		
		return palo.obtenerPalo();
	}
	
	public int obtenerValor(){
		
		return this.valor;
	}

	public Object obtenerCartaComoString() {
		
		return "'" + this.obtenerValor()+ " de " + this.obtenerPalo() + "' ";
	}
}
