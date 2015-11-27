package fiuba.algo3.tp2.modeloDeCartas;

public class CincoDeBasto extends Cinco{
	
	public CincoDeBasto(){
	}

	//SUMAR ENVIDO
	
	public int sumarTanto(Carta sumar) {
		return sumar.sumarTanto(this);
	}
	
	public int sumarTanto(AnchoDeBasto sumar){
		return 26;
	}
	
	public int sumarTanto(DosDeBasto sumar){
		return 27;
	}
	
	public int sumarTanto(TresDeBasto sumar){
		return 28;
	}
	
	public int sumarTanto(CuatroDeBasto sumar){
		return 29;
	}
	
	public int sumarTanto(CincoDeBasto sumar){
		return 0;
	}
	
	public int sumarTanto(SeisDeBasto sumar){
		return 31;
	}
	
	public int sumarTanto(SieteDeBasto sumar){
		return 32;
	}
	
	public int sumarTanto(SotaDeBasto sumar){
		return 25;
	}
	
	public int sumarTanto(CaballoDeBasto sumar){
		return 25;
	}
	
	public int sumarTanto(ReyDeBasto sumar){
		return 25;
	}
	
	@Override
	public String cartaComoString() {
		return "Cinco De Basto";
	}
	
}
