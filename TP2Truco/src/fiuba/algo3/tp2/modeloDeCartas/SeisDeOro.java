package fiuba.algo3.tp2.modeloDeCartas;

public class SeisDeOro extends Seis {
	
	public SeisDeOro(){
	}

	//SUMAR ENVIDO
	
	public int sumarTanto(Carta sumar) {
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
	
	@Override
	public String cartaComoString() {
		return "Seis De Oro";
	}
	
}
