package fiuba.algo3.tp2.modeloDeCartas;

import fiuba.algo3.tp2.modelo.Espada;
import fiuba.algo3.tp2.modelo.Palo;

public class CuatroDeEspada extends Cuatro{
	
	Palo palo;
	
	public CuatroDeEspada(){
		
		palo = new Espada();
	}
	
	//SUMAR TANTOS
	
	public int sumarTanto(TipoDeCartas sumar) {
		return sumar.sumarTanto(this);
	}

	public int sumarTanto(AnchoDeEspada sumar){
		return 25;
	}
	public int sumarTanto(DosDeEspada sumar){
		return 26;
	}
	public int sumarTanto(TresDeEspada sumar){
		return 27;
	}
	public int sumarTanto(CuatroDeEspada sumar){
		return 0;
	}
	public int sumarTanto(CincoDeEspada sumar){
		return 29;
	}
	public int sumarTanto(SeisDeEspada sumar){
		return 30;
	}
	public int sumarTanto(SieteDeEspada sumar){
		return 31;
	}
	public int sumarTanto(SotaDeEspada sumar){
		return 24;
	}
	public int sumarTanto(CaballoDeEspada sumar){
		return 24;
	}
	public int sumarTanto(ReyDeEspada sumar){
		return 24;
	}
	public int sumarTanto(Dos sumar){
		return 4;
	}
	public int sumarTanto(Tres sumar){
		return 4;
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
		return 4;
	}
	public int sumarTanto(Caballo sumar){
		return 4;
	}
	public int sumarTanto(Rey sumar){
		return 4;
	}
	
	@Override
	public int sumarTanto(AnchoDeBasto sumar) {
		return 4;
	}

	@Override
	public int sumarTanto(AnchoFalso sumar) {
		return 4;
	}
	
}