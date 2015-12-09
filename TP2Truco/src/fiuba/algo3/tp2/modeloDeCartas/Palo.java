package fiuba.algo3.tp2.modeloDeCartas;

public abstract class Palo{

	public abstract boolean esElMismoPalo(Palo obtenerPalo);
	
	public abstract boolean esElMismoPalo(Copa obtenerPalo);
	
	public abstract boolean esElMismoPalo(Basto obtenerPalo);
	
	public abstract boolean esElMismoPalo(Espada obtenerPalo);
	
	public abstract boolean esElMismoPalo(Oro obtenerPalo);
	
	public abstract String comoString();
}

