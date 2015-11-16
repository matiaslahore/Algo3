package fiuba.algo3.tp2.modeloDeCartas;

import fiuba.algo3.tp2.modelo.Oro;
import fiuba.algo3.tp2.modelo.Palo;

public class SeisDeOro extends Seis {
	
	Palo palo;
	
	public SeisDeOro(){
		
		palo = new Oro();
	}

	//SUMAR ENVIDO
	
	public int sumarTanto(TipoDeCartas sumar) {
		return sumar.sumarTanto(this);
	}
	
	public int sumarTanto(AnchoDeOro sumar){
		return 27;
	}
	public int sumarTanto(DosDeOro sumar){
		return 28;
	}
	public int sumarTanto(TresDeOro sumar){
		return 29;
	}
	public int sumarTanto(CuatroDeOro sumar){
		return 30;
	}
	public int sumarTanto(CincoDeOro sumar){
		return 31;
	}
	public int sumarTanto(SeisDeOro sumar){
		return 0;
	}
	public int sumarTanto(SieteDeOro sumar){
		return 33;
	}
	public int sumarTanto(SotaDeOro sumar){
		return 26;
	}
	public int sumarTanto(CaballoDeOro sumar){
		return 26;
	}
	public int sumarTanto(ReyDeOro sumar){
		return 26;
	}
}
