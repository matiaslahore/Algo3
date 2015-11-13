package fiuba.algo3.tp2.modeloDeCartas;

import fiuba.algo3.tp2.modelo.Copa;
import fiuba.algo3.tp2.modelo.Palo;

public class SieteDeCopa extends SieteFalso{

	Palo palo;
	
	public SieteDeCopa(){
		
		palo = new Copa();
	}

	//SUMAR ENVIDO
	
	public int sumarTanto(TipoDeCartas sumar) {
		return sumar.sumarTanto(this);
	}
	
	public int sumarTanto(AnchoDeCopa sumar){
		return 28;
	}
	public int sumarTanto(DosDeCopa sumar){
		return 29;
	}
	public int sumarTanto(TresDeCopa sumar){
		return 30;
	}
	public int sumarTanto(CuatroDeCopa sumar){
		return 31;
	}
	public int sumarTanto(CincoDeCopa sumar){
		return 32;
	}
	public int sumarTanto(SeisDeCopa sumar){
		return 33;
	}
	public int sumarTanto(SieteDeCopa sumar){
		return 0;
	}
	public int sumarTanto(SotaDeCopa sumar){
		return 27;
	}
	public int sumarTanto(CaballoDeCopa sumar){
		return 27;
	}
	public int sumarTanto(ReyDeCopa sumar){
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

	@Override
	public int sumarTanto(AnchoDeBasto sumar) {
		return 7;
	}

}
