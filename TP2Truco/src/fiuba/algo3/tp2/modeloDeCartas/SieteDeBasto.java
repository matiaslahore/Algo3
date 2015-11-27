package fiuba.algo3.tp2.modeloDeCartas;

public class SieteDeBasto extends SieteFalso{

	public SieteDeBasto(){
	}

	//SUMAR ENVIDO
	
	public int sumarTanto(Carta sumar) {
		return sumar.sumarTanto(this);
	}
	
	public int sumarTanto(AnchoDeBasto sumar){
		return 28;
	}
	public int sumarTanto(DosDeBasto sumar){
		return 29;
	}
	public int sumarTanto(TresDeBasto sumar){
		return 30;
	}
	public int sumarTanto(CuatroDeBasto sumar){
		return 31;
	}
	public int sumarTanto(CincoDeBasto sumar){
		return 32;
	}
	public int sumarTanto(SeisDeBasto sumar){
		return 33;
	}
	public int sumarTanto(SieteDeBasto sumar){
		return 0;
	}
	public int sumarTanto(SotaDeBasto sumar){
		return 27;
	}
	public int sumarTanto(CaballoDeBasto sumar){
		return 27;
	}
	public int sumarTanto(ReyDeBasto sumar){
		return 27;
	}
	
	@Override
	public String cartaComoString() {
		return "Siete De Basto";
	}
	
}
