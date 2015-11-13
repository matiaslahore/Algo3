package fiuba.algo3.tp2.modeloDeCartas;

import fiuba.algo3.tp2.modelo.Palo;

public class AnchoDeBasto implements TipoDeCartas{
	
	Palo palo;
	
	public AnchoDeBasto(Palo newPalo){
		this.palo = newPalo;
	}
	
	public TipoDeCartas vs(TipoDeCartas contra){
		//return this.vs(contra); te lo dejo comentado para que veas lo unico que toqu
		return contra.vs(this);
	}
	
	public TipoDeCartas vs(AnchoDeEspada contra){
		return contra;
	}
	
	public TipoDeCartas vs(AnchoDeBasto contra){
		return this;
	}
	
	public TipoDeCartas vs(SieteDeEspada contra){
		return this;
	}
	
	public TipoDeCartas vs(SieteDeOro contra){
		return this;
	}
	
	public TipoDeCartas vs(Tres contra){
		return this;
	}
	
	public TipoDeCartas vs(Dos contra){
		return this;
	}
	
	public TipoDeCartas vs(AnchoFalso contra){
		return this;
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
