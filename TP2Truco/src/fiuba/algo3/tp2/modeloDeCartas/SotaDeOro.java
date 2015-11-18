package fiuba.algo3.tp2.modeloDeCartas;

public class SotaDeOro extends Sota{
	
	public SotaDeOro(){
	}

	//SUMAR ENVIDO
	
	public int sumarTanto(TipoDeCartas sumar) {
		return sumar.sumarTanto(this);
	}
	
	public int sumarTanto(AnchoDeOro sumar){
		return 21;
	}
	public int sumarTanto(DosDeOro sumar){
		return 22;
	}
	public int sumarTanto(TresDeOro sumar){
		return 23;
	}
	public int sumarTanto(CuatroDeOro sumar){
		return 24;
	}
	public int sumarTanto(CincoDeOro sumar){
		return 25;
	}
	public int sumarTanto(SeisDeOro sumar){
		return 26;
	}
	public int sumarTanto(SieteDeOro sumar){
		return 27;
	}
	public int sumarTanto(SotaDeOro sumar){
		return 0;
	}
	public int sumarTanto(CaballoDeOro sumar){
		return 20;
	}
	public int sumarTanto(ReyDeOro sumar){
		return 20;
	}
	
	@Override
	public String cartaComoString() {
		return "Diez De Oro";
	}
	
}