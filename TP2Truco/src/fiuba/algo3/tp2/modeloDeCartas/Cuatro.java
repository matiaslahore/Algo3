package fiuba.algo3.tp2.modeloDeCartas;

public abstract class Cuatro implements TipoDeCartas{
	
	public TipoDeCartas vs(TipoDeCartas contra){
		return contra.vs(this);
	}

	public TipoDeCartas vs(AnchoDeEspada contra){
		return contra;
	}

	public TipoDeCartas vs(AnchoDeBasto contra){
		return contra;
	}

	public TipoDeCartas vs(SieteDeEspada contra){
		return contra;
	}

	public TipoDeCartas vs(SieteDeOro contra){
		return contra;
	}

	public TipoDeCartas vs(Tres contra){
		return contra;
	}

	public TipoDeCartas vs(Dos contra){
		return contra;
	}

	public TipoDeCartas vs(AnchoFalso contra){
		return contra;
	}

	public TipoDeCartas vs(Rey contra){
		return contra;
	}

	public TipoDeCartas vs(Caballo contra){
		return contra;
	}

	public TipoDeCartas vs(Sota contra){
		return contra;
	}

	public TipoDeCartas vs(SieteFalso contra){
		return contra;
	}

	public TipoDeCartas vs(Seis contra){
		return contra;
	}

	public TipoDeCartas vs(Cinco contra){
		return contra;
	}

	public TipoDeCartas vs(Cuatro contra){
		return this;
	}

}