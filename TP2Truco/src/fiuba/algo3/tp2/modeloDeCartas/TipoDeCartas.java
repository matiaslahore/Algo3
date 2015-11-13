package fiuba.algo3.tp2.modeloDeCartas;

public interface TipoDeCartas {

	public abstract TipoDeCartas vs(TipoDeCartas contra);
	
	public abstract TipoDeCartas vs(AnchoDeEspada contra);

	public abstract TipoDeCartas vs(AnchoDeBasto contra);

}
