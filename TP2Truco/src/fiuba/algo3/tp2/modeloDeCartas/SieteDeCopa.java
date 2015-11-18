package fiuba.algo3.tp2.modeloDeCartas;

public class SieteDeCopa extends SieteFalso{

	public SieteDeCopa(){
	}

	//SUMAR ENVIDO
	
	public int sumarTanto(TipoDeCartas sumar) {
		return sumar.sumarTanto(this);
	}
	
	public int sumarTanto(AnchoDeCopa sumar){
		return 28;
	}
	public int sumarTanto(DosDeCopa sumar){
		return 29;
	}
	public int sumarTanto(TresDeCopa sumar){
		return 30;
	}
	public int sumarTanto(CuatroDeCopa sumar){
		return 31;
	}
	public int sumarTanto(CincoDeCopa sumar){
		return 32;
	}
	public int sumarTanto(SeisDeCopa sumar){
		return 33;
	}
	public int sumarTanto(SieteDeCopa sumar){
		return 0;
	}
	public int sumarTanto(SotaDeCopa sumar){
		return 27;
	}
	public int sumarTanto(CaballoDeCopa sumar){
		return 27;
	}
	public int sumarTanto(ReyDeCopa sumar){
		return 27;
	}
	
	@Override
	public String cartaComoString() {
		return "Siete De Copa";
	}
	
}
