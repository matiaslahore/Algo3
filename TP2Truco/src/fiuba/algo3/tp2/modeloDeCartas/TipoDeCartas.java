package fiuba.algo3.tp2.modeloDeCartas;

public interface TipoDeCartas {

	public abstract TipoDeCartas vs(TipoDeCartas contra);
	
	public abstract TipoDeCartas vs(AnchoDeEspada contra);

	public abstract TipoDeCartas vs(AnchoDeBasto contra);
	
	public abstract TipoDeCartas vs(SieteDeEspada contra);
	
	public abstract TipoDeCartas vs(SieteDeOro contra);

	public abstract TipoDeCartas vs(Tres contra);
	
	public abstract TipoDeCartas vs(Dos contra);
	
	public abstract TipoDeCartas vs(AnchoFalso contra);
	
	public abstract TipoDeCartas vs(Rey contra);
	
	public abstract TipoDeCartas vs(Caballo contra);
	
	public abstract TipoDeCartas vs(Sota contra);

	public abstract TipoDeCartas vs(SieteFalso contra);
	
	public abstract TipoDeCartas vs(Seis contra);

	public abstract TipoDeCartas vs(Cinco contra);

	public abstract TipoDeCartas vs(Cuatro contra);
}
