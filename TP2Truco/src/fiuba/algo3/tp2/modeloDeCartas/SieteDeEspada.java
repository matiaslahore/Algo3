package fiuba.algo3.tp2.modeloDeCartas;

import fiuba.algo3.tp2.modelo.Espada;
import fiuba.algo3.tp2.modelo.Palo;

public class SieteDeEspada implements TipoDeCartas{

	Palo palo;
	
	public SieteDeEspada(){
		this.palo = new Espada();
	}
	
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
	
	//SUMAR TANTO
	
	public int sumarTanto(TipoDeCartas sumar) {
		return sumar.sumarTanto(this);
	}
	
	public int sumarTanto(AnchoDeEspada sumar){
		return 28;
	}
	public int sumarTanto(DosDeEspada sumar){
		return 29;
	}
	public int sumarTanto(TresDeEspada sumar){
		return 30;
	}
	public int sumarTanto(CuatroDeEspada sumar){
		return 31;
	}
	public int sumarTanto(CincoDeEspada sumar){
		return 32;
	}
	public int sumarTanto(SeisDeEspada sumar){
		return 33;
	}
	public int sumarTanto(SieteDeEspada sumar){
		return 0;
	}
	public int sumarTanto(SotaDeEspada sumar){
		return 27;
	}
	public int sumarTanto(CaballoDeEspada sumar){
		return 27;
	}
	public int sumarTanto(ReyDeEspada sumar){
		return 27;
	}
	public int sumarTanto(Dos sumar){
		return 7;
	}
	public int sumarTanto(Tres sumar){
		return 7;
	}
	public int sumarTanto(Cuatro sumar){
		return 7;
	}
	public int sumarTanto(Cinco sumar){
		return 7;
	}
	public int sumarTanto(Seis sumar){
		return 7;
	}
	public int sumarTanto(SieteFalso sumar){
		return 7;
	}
	public int sumarTanto(SieteDeOro sumar){
		return 7;
	}
	public int sumarTanto(Sota sumar){
		return 7;
	}
	public int sumarTanto(Caballo sumar){
		return 7;
	}
	public int sumarTanto(Rey sumar){
		return 7;
	}
	
	@Override
	public int sumarTanto(AnchoDeBasto sumar) {
		return 7;
	}

	@Override
	public int sumarTanto(AnchoFalso sumar) {
		return 7;
	}

}