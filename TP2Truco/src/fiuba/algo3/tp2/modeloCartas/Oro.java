package fiuba.algo3.tp2.modeloCartas;

public class Oro extends Palo{

	public boolean esElMismoPalo(Palo palo) {
		return palo.esElMismoPalo(this);
	}
	
	public boolean esElMismoPalo(Basto palo){
		return false;
	}

	public boolean esElMismoPalo(Copa palo){
		return false;
	}
	
	public boolean esElMismoPalo(Oro palo){
		return true;
	}
	
	public boolean esElMismoPalo(Espada palo){
		return false;
	}

	public String comoString() {
		return "Oro";
	}

}
