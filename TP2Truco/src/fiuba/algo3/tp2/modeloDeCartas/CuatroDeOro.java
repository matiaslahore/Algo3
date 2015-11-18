package fiuba.algo3.tp2.modeloDeCartas;

public class CuatroDeOro extends Cuatro{
	
	public CuatroDeOro(){
	}

	//SUMAR ENVIDO
	
	public int sumarTanto(TipoDeCartas sumar) {
		return sumar.sumarTanto(this);
	}
	
	public int sumarTanto(AnchoDeOro sumar){
		return 25;
	}
	public int sumarTanto(DosDeOro sumar){
		return 26;
	}
	public int sumarTanto(TresDeOro sumar){
		return 27;
	}
	public int sumarTanto(CuatroDeOro sumar){
		return 0;
	}
	public int sumarTanto(CincoDeOro sumar){
		return 29;
	}
	public int sumarTanto(SeisDeOro sumar){
		return 30;
	}
	public int sumarTanto(SieteDeOro sumar){
		return 31;
	}
	public int sumarTanto(SotaDeOro sumar){
		return 24;
	}
	public int sumarTanto(CaballoDeOro sumar){
		return 24;
	}
	public int sumarTanto(ReyDeOro sumar){
		return 24;
	}
	
	@Override
	public String cartaComoString() {
		return "Cuatro De Oro";
	}
	
}