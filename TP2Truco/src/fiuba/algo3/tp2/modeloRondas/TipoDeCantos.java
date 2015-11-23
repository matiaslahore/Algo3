package fiuba.algo3.tp2.modeloRondas;

public abstract class TipoDeCantos {

	String equipoQueCanta;
	
	public TipoDeCantos(){
		equipoQueCanta = "";
	}
	
	public abstract boolean canto(String equipo);
	
	public abstract void quiero();
	
	public abstract void noQuiero();

	public String equipoQueCanta() {
		return this.equipoQueCanta;
	}
	
}
