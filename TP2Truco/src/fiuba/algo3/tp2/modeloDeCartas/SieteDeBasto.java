package fiuba.algo3.tp2.modeloDeCartas;

import fiuba.algo3.tp2.modelo.Basto;
import fiuba.algo3.tp2.modelo.Palo;

public class SieteDeBasto extends SieteFalso{

	Palo palo;
	
	public SieteDeBasto(){
		
		palo = new Basto();
	}

	//SUMAR ENVIDO
	
	public int sumarTanto(TipoDeCartas sumar) {
		return sumar.sumarTanto(this);
	}
	
	public int sumarTanto(AnchoDeBasto sumar){
		return 28;
	}
	public int sumarTanto(DosDeBasto sumar){
		return 29;
	}
	public int sumarTanto(TresDeBasto sumar){
		return 30;
	}
	public int sumarTanto(CuatroDeBasto sumar){
		return 31;
	}
	public int sumarTanto(CincoDeBasto sumar){
		return 32;
	}
	public int sumarTanto(SeisDeBasto sumar){
		return 33;
	}
	public int sumarTanto(SieteDeBasto sumar){
		return 0;
	}
	public int sumarTanto(SotaDeBasto sumar){
		return 27;
	}
	public int sumarTanto(CaballoDeBasto sumar){
		return 27;
	}
	public int sumarTanto(ReyDeBasto sumar){
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
	public int sumarTanto(AnchoDeEspada sumar) {
		return 7;
	}

	@Override
	public int sumarTanto(SieteDeEspada sumar) {
		return 7;
	}

	@Override
	public int sumarTanto(AnchoFalso sumar) {
		return 7;
	}

}
