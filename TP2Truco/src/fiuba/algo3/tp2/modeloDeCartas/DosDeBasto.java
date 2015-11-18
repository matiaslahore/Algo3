package fiuba.algo3.tp2.modeloDeCartas;

public class DosDeBasto extends Dos{
	
	public DosDeBasto(){
	}

	//SUMAR ENVIDO
	
	public int sumarTanto(TipoDeCartas sumar) {
		return sumar.sumarTanto(this);
	}
	
	public int sumarTanto(AnchoDeBasto sumar){
		return 23;
	}
	public int sumarTanto(DosDeBasto sumar){
		return 0;
	}
	public int sumarTanto(TresDeBasto sumar){
		return 25;
	}
	public int sumarTanto(CuatroDeBasto sumar){
		return 26;
	}
	public int sumarTanto(CincoDeBasto sumar){
		return 27;
	}
	public int sumarTanto(SeisDeBasto sumar){
		return 28;
	}
	public int sumarTanto(SieteDeBasto sumar){
		return 29;
	}
	public int sumarTanto(SotaDeBasto sumar){
		return 22;
	}
	public int sumarTanto(CaballoDeBasto sumar){
		return 22;
	}
	public int sumarTanto(ReyDeBasto sumar){
		return 22;
	}
	
	@Override
	public String cartaComoString() {
		return "Dos De Basto";
	}
	
}