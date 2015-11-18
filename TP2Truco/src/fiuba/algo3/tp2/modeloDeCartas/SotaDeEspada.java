package fiuba.algo3.tp2.modeloDeCartas;

public class SotaDeEspada extends Sota{
	
	public SotaDeEspada(){
	}
	
	//SUMAR TANTOS

	public int sumarTanto(TipoDeCartas sumar) {
		return sumar.sumarTanto(this);
	}

	public int sumarTanto(AnchoDeEspada sumar){
		return 21;
	}
	public int sumarTanto(DosDeEspada sumar){
		return 22;
	}
	public int sumarTanto(TresDeEspada sumar){
		return 23;
	}
	public int sumarTanto(CuatroDeEspada sumar){
		return 24;
	}
	public int sumarTanto(CincoDeEspada sumar){
		return 25;
	}
	public int sumarTanto(SeisDeEspada sumar){
		return 26;
	}
	public int sumarTanto(SieteDeEspada sumar){
		return 27;
	}
	public int sumarTanto(SotaDeEspada sumar){
		return 0;
	}
	public int sumarTanto(CaballoDeEspada sumar){
		return 20;
	}
	public int sumarTanto(ReyDeEspada sumar){
		return 20;
	}
	
	@Override
	public String cartaComoString() {
		return "Diez De Espada";
	}
	
}