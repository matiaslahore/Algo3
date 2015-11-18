package fiuba.algo3.tp2.modeloDeCartas;

public class DosDeEspada extends Dos{
	
	public DosDeEspada(){
	}

	//SUMAR TANTOS

	public int sumarTanto(TipoDeCartas sumar) {
		return sumar.sumarTanto(this);
	}

	public int sumarTanto(AnchoDeEspada sumar){
		return 23;
	}
	public int sumarTanto(DosDeEspada sumar){
		return 0;
	}
	public int sumarTanto(TresDeEspada sumar){
		return 25;
	}
	public int sumarTanto(CuatroDeEspada sumar){
		return 26;
	}
	public int sumarTanto(CincoDeEspada sumar){
		return 27;
	}
	public int sumarTanto(SeisDeEspada sumar){
		return 28;
	}
	public int sumarTanto(SieteDeEspada sumar){
		return 29;
	}
	public int sumarTanto(SotaDeEspada sumar){
		return 22;
	}
	public int sumarTanto(CaballoDeEspada sumar){
		return 22;
	}
	public int sumarTanto(ReyDeEspada sumar){
		return 22;
	}
	
	@Override
	public String cartaComoString() {
		return "Dos De Espada";
	}
	
}