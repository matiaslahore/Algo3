package fiuba.algo3.tp2.modeloDeCartas;

import fiuba.algo3.tp2.modelo.Oro;
import fiuba.algo3.tp2.modelo.Palo;

public class SieteDeOro implements TipoDeCartas{

	Palo palo;
	
	public SieteDeOro(){
		this.palo = new Oro();
	}
	
	public int valorParaEnvido(){
		return 7;
	}
	
	public TipoDeCartas vs(TipoDeCartas contra){
		return contra.vs(this);
	}

	public TipoDeCartas vs(AnchoDeEspada contra){
		return contra;
	}

	public TipoDeCartas vs(AnchoDeBasto contra){
		return contra;
	}

	public TipoDeCartas vs(SieteDeEspada contra){
		return contra;
	}

	public TipoDeCartas vs(SieteDeOro contra){
		return this;
	}

	public TipoDeCartas vs(Tres contra){
		return this;
	}

	public TipoDeCartas vs(Dos contra){
		return this;
	}

	public TipoDeCartas vs(AnchoFalso contra){
		return this;
	}

	public TipoDeCartas vs(Rey contra){
		return this;
	}

	public TipoDeCartas vs(Caballo contra){
		return this;
	}

	public TipoDeCartas vs(Sota contra){
		return this;
	}

	public TipoDeCartas vs(SieteFalso contra){
		return this;
	}

	public TipoDeCartas vs(Seis contra){
		return this;
	}

	public TipoDeCartas vs(Cinco contra){
		return this;
	}

	public TipoDeCartas vs(Cuatro contra){
		return this;
	}

	//SUMAR ENVIDO
	
	public int sumarTanto(TipoDeCartas sumar) {
		return sumar.sumarTanto(this);
	}
	
	public int sumarTanto(AnchoDeOro sumar){
		return 28;
	}
	public int sumarTanto(DosDeOro sumar){
		return 29;
	}
	public int sumarTanto(TresDeOro sumar){
		return 30;
	}
	public int sumarTanto(CuatroDeOro sumar){
		return 31;
	}
	public int sumarTanto(CincoDeOro sumar){
		return 32;
	}
	public int sumarTanto(SeisDeOro sumar){
		return 33;
	}
	public int sumarTanto(SieteDeOro sumar){
		return 0;
	}
	public int sumarTanto(SotaDeOro sumar){
		return 27;
	}
	public int sumarTanto(CaballoDeOro sumar){
		return 27;
	}
	public int sumarTanto(ReyDeOro sumar){
		return 27;
	}
	
	public int sumarTanto(AnchoDeEspada sumar) {
		return 7;
	}
	
	public int sumarTanto(AnchoDeBasto sumar) {
		return 7;
	}
	
	public int sumarTanto(AnchoDeCopa sumar) {
		return 7;
	}
	
	@Override
	public int sumarTanto(TresDeCopa sumar) {
		// TODO Auto-generated method stub
		return 7;
	}

	@Override
	public int sumarTanto(TresDeEspada sumar) {
		// TODO Auto-generated method stub
		return 7;
	}

	@Override
	public int sumarTanto(TresDeBasto sumar) {
		// TODO Auto-generated method stub
		return 7;
	}
	
	@Override
	public int sumarTanto(DosDeCopa sumar) {
		// TODO Auto-generated method stub
		return 7;
	}

	@Override
	public int sumarTanto(DosDeEspada sumar) {
		// TODO Auto-generated method stub
		return 7;
	}

	@Override
	public int sumarTanto(DosDeBasto sumar) {
		// TODO Auto-generated method stub
		return 7;
	}

	@Override
	public int sumarTanto(ReyDeCopa sumar) {
		// TODO Auto-generated method stub
		return 7;
	}

	@Override
	public int sumarTanto(ReyDeEspada sumar) {
		// TODO Auto-generated method stub
		return 7;
	}

	@Override
	public int sumarTanto(ReyDeBasto sumar) {
		// TODO Auto-generated method stub
		return 7;
	}
	
	@Override
	public int sumarTanto(CaballoDeCopa sumar) {
		// TODO Auto-generated method stub
		return 7;
	}

	@Override
	public int sumarTanto(CaballoDeEspada sumar) {
		// TODO Auto-generated method stub
		return 7;
	}

	@Override
	public int sumarTanto(CaballoDeBasto sumar) {
		// TODO Auto-generated method stub
		return 7;
	}

	@Override
	public int sumarTanto(SotaDeCopa sumar) {
		// TODO Auto-generated method stub
		return 7;
	}

	@Override
	public int sumarTanto(SotaDeEspada sumar) {
		// TODO Auto-generated method stub
		return 7;
	}

	@Override
	public int sumarTanto(SotaDeBasto sumar) {
		// TODO Auto-generated method stub
		return 7;
	}

	@Override
	public int sumarTanto(SieteDeCopa sumar) {
		// TODO Auto-generated method stub
		return 7;
	}
	
	public int sumarTanto(SieteDeEspada sumar) {
		return 7;
	}
	
	@Override
	public int sumarTanto(SieteDeBasto sumar) {
		// TODO Auto-generated method stub
		return 7;
	}	

	@Override
	public int sumarTanto(SeisDeCopa sumar) {
		// TODO Auto-generated method stub
		return 7;
	}

	@Override
	public int sumarTanto(SeisDeEspada sumar) {
		// TODO Auto-generated method stub
		return 7;
	}

	@Override
	public int sumarTanto(SeisDeBasto sumar) {
		// TODO Auto-generated method stub
		return 7;
	}
	
	@Override
	public int sumarTanto(CincoDeCopa sumar) {
		// TODO Auto-generated method stub
		return 7;
	}

	@Override
	public int sumarTanto(CincoDeEspada sumar) {
		// TODO Auto-generated method stub
		return 7;
	}

	@Override
	public int sumarTanto(CincoDeBasto sumar) {
		// TODO Auto-generated method stub
		return 7;
	}
	

	@Override
	public int sumarTanto(CuatroDeEspada sumar) {
		// TODO Auto-generated method stub
		return 7;
	}

	@Override
	public int sumarTanto(CuatroDeBasto sumar) {
		// TODO Auto-generated method stub
		return 7;
	}
	
	@Override
	public int sumarTanto(CuatroDeCopa sumar) {
		// TODO Auto-generated method stub
		return 7;
	}
}