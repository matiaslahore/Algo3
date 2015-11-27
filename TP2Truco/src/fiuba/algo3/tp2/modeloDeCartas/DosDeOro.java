package fiuba.algo3.tp2.modeloDeCartas;

public class DosDeOro extends Dos{
	
	public DosDeOro(){
	}

	//SUMAR ENVIDO
	
	public int sumarTanto(Carta sumar) {
		return sumar.sumarTanto(this);
	}
	
	public int sumarTanto(AnchoDeOro sumar){
		return 23;
	}
	public int sumarTanto(DosDeOro sumar){
		return 0;
	}
	public int sumarTanto(TresDeOro sumar){
		return 25;
	}
	public int sumarTanto(CuatroDeOro sumar){
		return 26;
	}
	public int sumarTanto(CincoDeOro sumar){
		return 27;
	}
	public int sumarTanto(SeisDeOro sumar){
		return 28;
	}
	public int sumarTanto(SieteDeOro sumar){
		return 29;
	}
	public int sumarTanto(SotaDeOro sumar){
		return 22;
	}
	public int sumarTanto(CaballoDeOro sumar){
		return 22;
	}
	public int sumarTanto(ReyDeOro sumar){
		return 22;
	}
	
	@Override
	public String cartaComoString() {
		return "Dos De Oro";
	}
	
}
