package fiuba.algo3.tp2.modeloDeCartas;

import fiuba.algo3.tp2.modelo.Copa;
import fiuba.algo3.tp2.modelo.Palo;

public class CincoDeCopa extends Cinco{
	
	Palo palo;
	
	public CincoDeCopa(){
		
		palo = new Copa();
	}

	//SUMAR ENVIDO
	
	public int sumarTanto(TipoDeCartas sumar) {
		return sumar.sumarTanto(this);
	}
	
	public int sumarTanto(AnchoDeCopa sumar){
		return 26;
	}
	public int sumarTanto(DosDeCopa sumar){
		return 27;
	}
	public int sumarTanto(TresDeCopa sumar){
		return 28;
	}
	public int sumarTanto(CuatroDeCopa sumar){
		return 29;
	}
	public int sumarTanto(CincoDeCopa sumar){
		return 0;
	}
	public int sumarTanto(SeisDeCopa sumar){
		return 31;
	}
	public int sumarTanto(SieteDeCopa sumar){
		return 32;
	}
	public int sumarTanto(SotaDeCopa sumar){
		return 25;
	}
	public int sumarTanto(CaballoDeCopa sumar){
		return 25;
	}
	public int sumarTanto(ReyDeCopa sumar){
		return 25;
	}
	
	@Override
	public String cartaComoString() {
		return "Cinco De Copa";
	}
	
}
