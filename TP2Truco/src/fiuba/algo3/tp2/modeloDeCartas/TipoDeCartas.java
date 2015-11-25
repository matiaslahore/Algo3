package fiuba.algo3.tp2.modeloDeCartas;

public interface TipoDeCartas {

	public default boolean hayParda(TipoDeCartas contra){
		
		return (this.vs(contra) != contra.vs(this));
	}
	
	public abstract TipoDeCartas vs(TipoDeCartas contra);
	
	public abstract TipoDeCartas vs(AnchoDeEspada contra);

	public abstract TipoDeCartas vs(AnchoDeBasto contra);
	
	public abstract TipoDeCartas vs(SieteDeEspada contra);
	
	public abstract TipoDeCartas vs(SieteDeOro contra);

	public abstract TipoDeCartas vs(Tres contra);
	
	public abstract TipoDeCartas vs(Dos contra);
	
	public abstract TipoDeCartas vs(AnchoFalso contra);
	
	public abstract TipoDeCartas vs(Rey contra);
	
	public abstract TipoDeCartas vs(Caballo contra);
	
	public abstract TipoDeCartas vs(Sota contra);

	public abstract TipoDeCartas vs(SieteFalso contra);
	
	public abstract TipoDeCartas vs(Seis contra);

	public abstract TipoDeCartas vs(Cinco contra);

	public abstract TipoDeCartas vs(Cuatro contra);
	
	//SUMAR TANTOS
	
	public abstract int valorParaEnvido();

	public default int sumarTantosConFlor(TipoDeCartas cartaUno, TipoDeCartas cartaDos){
		
		
		return this.valorParaEnvido() + cartaUno.sumarTanto(cartaDos);
	}
	
	public abstract int sumarTanto(TipoDeCartas sumar);
	public abstract int sumarTanto(AnchoDeEspada sumar);
	public abstract int sumarTanto(AnchoDeBasto sumar);
	public abstract int sumarTanto(SieteDeEspada sumar);
	public abstract int sumarTanto(SieteDeOro sumar);
	public abstract int sumarTanto(TresDeOro sumar);
	public abstract int sumarTanto(TresDeCopa sumar);
	public abstract int sumarTanto(TresDeEspada sumar);
	public abstract int sumarTanto(TresDeBasto sumar);
	public abstract int sumarTanto(DosDeOro sumar);
	public abstract int sumarTanto(DosDeCopa sumar);
	public abstract int sumarTanto(DosDeEspada sumar);
	public abstract int sumarTanto(DosDeBasto sumar);
	public abstract int sumarTanto(AnchoDeCopa sumar);	
	public abstract int sumarTanto(AnchoDeOro sumar);
	public abstract int sumarTanto(ReyDeOro sumar);
	public abstract int sumarTanto(ReyDeCopa sumar);
	public abstract int sumarTanto(ReyDeEspada sumar);
	public abstract int sumarTanto(ReyDeBasto sumar);
	public abstract int sumarTanto(CaballoDeOro sumar);
	public abstract int sumarTanto(CaballoDeCopa sumar);
	public abstract int sumarTanto(CaballoDeEspada sumar);
	public abstract int sumarTanto(CaballoDeBasto sumar);	
	public abstract int sumarTanto(SotaDeOro sumar);
	public abstract int sumarTanto(SotaDeCopa sumar);
	public abstract int sumarTanto(SotaDeEspada sumar);
	public abstract int sumarTanto(SotaDeBasto sumar);
	public abstract int sumarTanto(SieteDeCopa sumar);
	public abstract int sumarTanto(SieteDeBasto sumar);
	public abstract int sumarTanto(SeisDeOro sumar);
	public abstract int sumarTanto(SeisDeCopa sumar);
	public abstract int sumarTanto(SeisDeEspada sumar);
	public abstract int sumarTanto(SeisDeBasto sumar);
	public abstract int sumarTanto(CincoDeOro sumar);
	public abstract int sumarTanto(CincoDeCopa sumar);
	public abstract int sumarTanto(CincoDeEspada sumar);
	public abstract int sumarTanto(CincoDeBasto sumar);
	public abstract int sumarTanto(CuatroDeEspada sumar);
	public abstract int sumarTanto(CuatroDeOro sumar);
	public abstract int sumarTanto(CuatroDeBasto sumar);
	public abstract int sumarTanto(CuatroDeCopa sumar);
	
	public abstract String cartaComoString();
}

