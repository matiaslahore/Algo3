package fiuba.algo3.tp2.modeloDeCartas;

import fiuba.algo3.tp2.modelo.Palo;

public class Rey implements TipoDeCartas{

	Palo palo;
	
	public Rey(Palo newPalo){
		this.palo = newPalo;
	}
	
	public TipoDeCartas vs(TipoDeCartas contra){
		return this.vs(contra);
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
		return this;
	}

	public TipoDeCartas vs(Caballo contra){
		return this;
	}

	public TipoDeCartas vs(Sota contra){
		return this;
	}

	public TipoDeCartas vs(SieteFalso contra){
		return this;
	}

	public TipoDeCartas vs(Seis contra){
		return this;
	}

	public TipoDeCartas vs(Cinco contra){
		return this;
	}

	public TipoDeCartas vs(Cuatro contra){
		return this;
	}

}