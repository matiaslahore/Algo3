package fiuba.algo3.tp2.modeloDeCartas;

import fiuba.algo3.tp2.modelo.Oro;
import fiuba.algo3.tp2.modelo.Palo;

public class CincoDeOro extends Cinco{
	
	Palo palo;
	
	public CincoDeOro(){
		
		palo = new Oro();
	}

	//SUMAR ENVIDO
	
	public int sumarTanto(TipoDeCartas sumar) {
		return sumar.sumarTanto(this);
	}
	
	public int sumarTanto(AnchoDeOro sumar){
		return 26;
	}
	public int sumarTanto(DosDeOro sumar){
		return 27;
	}
	public int sumarTanto(TresDeOro sumar){
		return 28;
	}
	public int sumarTanto(CuatroDeOro sumar){
		return 29;
	}
	public int sumarTanto(CincoDeOro sumar){
		return 0;
	}
	public int sumarTanto(SeisDeOro sumar){
		return 31;
	}
	public int sumarTanto(SieteDeOro sumar){
		return 32;
	}
	public int sumarTanto(SotaDeOro sumar){
		return 25;
	}
	public int sumarTanto(CaballoDeOro sumar){
		return 25;
	}
	public int sumarTanto(ReyDeOro sumar){
		return 25;
	}
	public int sumarTanto(Dos sumar){
		return 5;
	}
	public int sumarTanto(Tres sumar){
		return 5;
	}
	public int sumarTanto(Cuatro sumar){
		return 5;
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
	public int sumarTanto(SieteDeEspada sumar) {
		return 7;
	}
	public int sumarTanto(Sota sumar){
		return 5;
	}
	public int sumarTanto(Caballo sumar){
		return 5;
	}
	public int sumarTanto(Rey sumar){
		return 5;
	}

	@Override
	public int sumarTanto(AnchoDeEspada sumar) {
		return 5;
	}
	public int sumarTanto(AnchoDeBasto sumar) {
		return 5;
	}
	public int sumarTanto(AnchoFalso sumar) {
		return 5;
	}

}
