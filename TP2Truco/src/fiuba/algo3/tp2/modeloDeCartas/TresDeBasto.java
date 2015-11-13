package fiuba.algo3.tp2.modeloDeCartas;

import fiuba.algo3.tp2.modelo.Basto;
import fiuba.algo3.tp2.modelo.Palo;

public class TresDeBasto extends Tres {
	
	Palo palo;
	
	public TresDeBasto(){
		
		palo = new Basto();
	}

	//SUMAR ENVIDO
	
	public int sumarTanto(TipoDeCartas sumar) {
		return sumar.sumarTanto(this);
	}
	
	public int sumarTanto(AnchoDeBasto sumar){
		return 24;
	}
	public int sumarTanto(DosDeBasto sumar){
		return 25;
	}
	public int sumarTanto(TresDeBasto sumar){
		return 0;
	}
	public int sumarTanto(CuatroDeBasto sumar){
		return 27;
	}
	public int sumarTanto(CincoDeBasto sumar){
		return 28;
	}
	public int sumarTanto(SeisDeBasto sumar){
		return 29;
	}
	public int sumarTanto(SieteDeBasto sumar){
		return 30;
	}
	public int sumarTanto(SotaDeBasto sumar){
		return 23;
	}
	public int sumarTanto(CaballoDeBasto sumar){
		return 23;
	}
	public int sumarTanto(ReyDeBasto sumar){
		return 23;
	}
	public int sumarTanto(Dos sumar){
		return 3;
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
		return 3;
	}
	public int sumarTanto(Caballo sumar){
		return 3;
	}
	public int sumarTanto(Rey sumar){
		return 3;
	}

	@Override
	public int sumarTanto(AnchoDeEspada sumar) {
		return 3;
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
