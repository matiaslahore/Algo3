package fiuba.algo3.tp2.modeloDeCartas;

public interface Carta {
	
	public default boolean hayParda(Carta contra){
		
		return (this.vs(contra) != contra.vs(this));
	}
	
	public abstract Carta vs(Carta contra);
	
	public abstract Carta vs(AnchoDeEspada contra);

	public abstract Carta vs(AnchoDeBasto contra);
	
	public abstract Carta vs(SieteDeEspada contra);
	
	public abstract Carta vs(SieteDeOro contra);

	public abstract Carta vs(Tres contra);
	
	public abstract Carta vs(Dos contra);
	
	public abstract Carta vs(AnchoFalso contra);
	
	public abstract Carta vs(Rey contra);
	
	public abstract Carta vs(Caballo contra);
	
	public abstract Carta vs(Sota contra);

	public abstract Carta vs(SieteFalso contra);
	
	public abstract Carta vs(Seis contra);

	public abstract Carta vs(Cinco contra);

	public abstract Carta vs(Cuatro contra);
	
	//SUMAR TANTOS
	
	public abstract int valorParaEnvido();

	public default int sumarTantosConFlor(Carta cartaUno, Carta cartaDos){
		
		return this.valorParaEnvido() + cartaUno.sumarTanto(cartaDos);
	}
	
	public abstract int sumarTanto(Carta sumar);
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

