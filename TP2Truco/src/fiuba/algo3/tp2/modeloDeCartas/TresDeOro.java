package fiuba.algo3.tp2.modeloDeCartas;

import fiuba.algo3.tp2.modelo.Oro;
import fiuba.algo3.tp2.modelo.Palo;

public class TresDeOro extends Tres {
	
	Palo palo;
	
	public TresDeOro(){
		
		palo = new Oro();
	}

	//SUMAR ENVIDO
	
	public int sumarTanto(TipoDeCartas sumar) {
		return sumar.sumarTanto(this);
	}
	
	public int sumarTanto(AnchoDeOro sumar){
		return 24;
	}
	public int sumarTanto(DosDeOro sumar){
		return 25;
	}
	public int sumarTanto(TresDeOro sumar){
		return 0;
	}
	public int sumarTanto(CuatroDeOro sumar){
		return 27;
	}
	public int sumarTanto(CincoDeOro sumar){
		return 28;
	}
	public int sumarTanto(SeisDeOro sumar){
		return 29;
	}
	public int sumarTanto(SieteDeOro sumar){
		return 30;
	}
	public int sumarTanto(SotaDeOro sumar){
		return 23;
	}
	public int sumarTanto(CaballoDeOro sumar){
		return 23;
	}
	public int sumarTanto(ReyDeOro sumar){
		return 23;
	}
}
