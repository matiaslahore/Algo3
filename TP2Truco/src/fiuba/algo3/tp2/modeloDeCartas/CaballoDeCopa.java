package fiuba.algo3.tp2.modeloDeCartas;

public class CaballoDeCopa extends Caballo{
	
	public CaballoDeCopa(){
	}
	
	//SUMAR ENVIDO
	
	public int sumarTanto(Carta sumar) {
		return sumar.sumarTanto(this);
	}

	public int sumarTanto(CaballoDeCopa sumar){
		return 0;
	}
	
	public int sumarTanto(AnchoDeCopa sumar){
		return 21;
	}
	
	public int sumarTanto(DosDeCopa sumar){
		return 22;
	}
	
	public int sumarTanto(TresDeCopa sumar){
		return 23;
	}
	
	public int sumarTanto(CuatroDeCopa sumar){
		return 24;
	}
	
	public int sumarTanto(CincoDeCopa sumar){
		return 25;
	}
	
	public int sumarTanto(SeisDeCopa sumar){
		return 26;
	}
	
	public int sumarTanto(SieteDeCopa sumar){
		return 27;
	}
	
	public int sumarTanto(SotaDeCopa sumar){
		return 20;
	}
	
	public int sumarTanto(ReyDeCopa sumar){
		return 20;
	}
	
	@Override
	public String cartaComoString() {
		return "Once De Copa";
	}
	
}
