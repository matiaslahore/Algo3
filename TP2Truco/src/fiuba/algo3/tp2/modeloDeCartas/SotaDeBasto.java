package fiuba.algo3.tp2.modeloDeCartas;

import fiuba.algo3.tp2.modelo.Basto;
import fiuba.algo3.tp2.modelo.Palo;

public class SotaDeBasto extends Sota{
	
	Palo palo;
	
	public SotaDeBasto(){
		
		palo = new Basto();
	}

	//SUMAR ENVIDO
	
	public int sumarTanto(TipoDeCartas sumar) {
		return sumar.sumarTanto(this);
	}
	
	public int sumarTanto(AnchoDeBasto sumar){
		return 21;
	}
	public int sumarTanto(DosDeBasto sumar){
		return 22;
	}
	public int sumarTanto(TresDeBasto sumar){
		return 23;
	}
	public int sumarTanto(CuatroDeBasto sumar){
		return 24;
	}
	public int sumarTanto(CincoDeBasto sumar){
		return 25;
	}
	public int sumarTanto(SeisDeBasto sumar){
		return 26;
	}
	public int sumarTanto(SieteDeBasto sumar){
		return 27;
	}
	public int sumarTanto(SotaDeBasto sumar){
		return 0;
	}
	public int sumarTanto(CaballoDeBasto sumar){
		return 20;
	}
	public int sumarTanto(ReyDeBasto sumar){
		return 20;
	}
}