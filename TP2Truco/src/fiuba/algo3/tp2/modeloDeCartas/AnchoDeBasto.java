package fiuba.algo3.tp2.modeloDeCartas;

import fiuba.algo3.tp2.modelo.Basto;
import fiuba.algo3.tp2.modelo.Palo;

public class AnchoDeBasto implements TipoDeCartas{
	
	Palo palo;
	
	public AnchoDeBasto(){
		this.palo = new Basto();
	}
	
	public TipoDeCartas vs(TipoDeCartas contra){
		//return this.vs(contra); te lo dejo comentado para que veas lo unico que toqu
		return contra.vs(this);
	}
	
	public TipoDeCartas vs(AnchoDeEspada contra){
		return contra;
	}

	public TipoDeCartas vs(AnchoDeBasto contra) {
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
	
	//SUMAR ENVIDO
	
	public int sumarTanto(TipoDeCartas sumar) {
		return sumar.sumarTanto(this);
	}
	
	public int sumarTanto(AnchoDeBasto sumar){
		return 0;
	}
	public int sumarTanto(DosDeBasto sumar){
		return 23;
	}
	public int sumarTanto(TresDeBasto sumar){
		return 24;
	}
	public int sumarTanto(CuatroDeBasto sumar){
		return 25;
	}
	public int sumarTanto(CincoDeBasto sumar){
		return 26;
	}
	public int sumarTanto(SeisDeBasto sumar){
		return 27;
	}
	public int sumarTanto(SieteDeBasto sumar){
		return 28;
	}
	public int sumarTanto(SotaDeBasto sumar){
		return 21;
	}
	public int sumarTanto(CaballoDeBasto sumar){
		return 21;
	}
	public int sumarTanto(ReyDeBasto sumar){
		return 21;
	}
	public int sumarTanto(Dos sumar){
		return 2;
	}
	public int sumarTanto(Tres sumar){
		return 3;
	}
	public int sumarTanto(Cuatro sumar){
		return 4;
	}
	public int sumarTanto(Cinco sumar){
		return 5;
	}
	public int sumarTanto(Seis sumar){
		return 6;
	}
	public int sumarTanto(SieteFalso sumar){
		return 7;
	}
	public int sumarTanto(SieteDeOro sumar){
		return 7;
	}
	public int sumarTanto(Sota sumar){
		return 1;
	}
	public int sumarTanto(Caballo sumar){
		return 1;
	}
	public int sumarTanto(Rey sumar){
		return 1;
	}

	@Override
	public int sumarTanto(AnchoDeEspada sumar) {
		return 1;
	}

	@Override
	public int sumarTanto(SieteDeEspada sumar) {
		return 7;
	}

	@Override
	public int sumarTanto(AnchoFalso sumar) {
		return 1;
	}
	
}
