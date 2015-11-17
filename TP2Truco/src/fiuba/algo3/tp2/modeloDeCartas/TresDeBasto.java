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
	
	@Override
	public String cartaComoString() {
		return "Tres De Basto";
	}
	
}
