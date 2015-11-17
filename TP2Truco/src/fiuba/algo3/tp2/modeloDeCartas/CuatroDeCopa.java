package fiuba.algo3.tp2.modeloDeCartas;

import fiuba.algo3.tp2.modelo.Copa;
import fiuba.algo3.tp2.modelo.Palo;

public class CuatroDeCopa extends Cuatro{
	
	Palo palo;
	
	public CuatroDeCopa(){
		
		palo = new Copa();
	}

	//SUMAR ENVIDO
	
	public int sumarTanto(TipoDeCartas sumar) {
		return sumar.sumarTanto(this);
	}
	
	public int sumarTanto(AnchoDeCopa sumar){
		return 25;
	}
	public int sumarTanto(DosDeCopa sumar){
		return 26;
	}
	public int sumarTanto(TresDeCopa sumar){
		return 27;
	}
	public int sumarTanto(CuatroDeCopa sumar){
		return 0;
	}
	public int sumarTanto(CincoDeCopa sumar){
		return 29;
	}
	public int sumarTanto(SeisDeCopa sumar){
		return 30;
	}
	public int sumarTanto(SieteDeCopa sumar){
		return 31;
	}
	public int sumarTanto(SotaDeCopa sumar){
		return 24;
	}
	public int sumarTanto(CaballoDeCopa sumar){
		return 24;
	}
	public int sumarTanto(ReyDeCopa sumar){
		return 24;
	}
	
	@Override
	public String cartaComoString() {
		return "Cuatro De Copa";
	}
	
}
