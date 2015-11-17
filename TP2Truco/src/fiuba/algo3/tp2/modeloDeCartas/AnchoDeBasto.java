package fiuba.algo3.tp2.modeloDeCartas;

import fiuba.algo3.tp2.modelo.Basto;
import fiuba.algo3.tp2.modelo.Palo;

public class AnchoDeBasto implements TipoDeCartas{
	
	Palo palo;
	
	public AnchoDeBasto(){
		this.palo = new Basto();
	}
	
	public int valorParaEnvido(){
		return 1;
	}
	
	public TipoDeCartas vs(TipoDeCartas contra){
		return contra.vs(this);
	}
	
	public TipoDeCartas vs(AnchoDeEspada contra){
		return contra;
	}

	public TipoDeCartas vs(AnchoDeBasto contra) {
		return this;
	}
	
	public TipoDeCartas vs(SieteDeEspada contra){
		return this;
	}
	
	public TipoDeCartas vs(SieteDeOro contra){
		return this;
	}
	
	@Override
	public TipoDeCartas vs(Tres contra) {
		// TODO Auto-generated method stub
		return this;
	}

	@Override
	public TipoDeCartas vs(Dos contra) {
		// TODO Auto-generated method stub
		return this;
	}

	@Override
	public TipoDeCartas vs(AnchoFalso contra) {
		// TODO Auto-generated method stub
		return this;
	}

	@Override
	public TipoDeCartas vs(Rey contra) {
		// TODO Auto-generated method stub
		return this;
	}

	@Override
	public TipoDeCartas vs(Caballo contra) {
		// TODO Auto-generated method stub
		return this;
	}

	@Override
	public TipoDeCartas vs(Sota contra) {
		// TODO Auto-generated method stub
		return this;
	}

	@Override
	public TipoDeCartas vs(SieteFalso contra) {
		// TODO Auto-generated method stub
		return this;
	}

	@Override
	public TipoDeCartas vs(Seis contra) {
		// TODO Auto-generated method stub
		return this;
	}

	@Override
	public TipoDeCartas vs(Cinco contra) {
		// TODO Auto-generated method stub
		return this;
	}

	@Override
	public TipoDeCartas vs(Cuatro contra) {
		// TODO Auto-generated method stub
		return this;
	}
	
	//SUMAR ENVIDO
	
	public int sumarTanto(TipoDeCartas sumar) {
		return sumar.sumarTanto(this);
	}
	
	public int sumarTanto(AnchoDeBasto sumar){
		//Podriamos hacer que tire un exception ya que no puede haber dos cartas iguales
		return 0;
	}
	public int sumarTanto(DosDeBasto sumar){
		return 23;
	}
	public int sumarTanto(TresDeBasto sumar){
		return 24;
	}
	public int sumarTanto(CuatroDeBasto sumar){
		return 25;
	}
	public int sumarTanto(CincoDeBasto sumar){
		return 26;
	}
	public int sumarTanto(SeisDeBasto sumar){
		return 27;
	}
	public int sumarTanto(SieteDeBasto sumar){
		return 28;
	}
	public int sumarTanto(SotaDeBasto sumar){
		return 21;
	}
	public int sumarTanto(CaballoDeBasto sumar){
		return 21;
	}
	public int sumarTanto(ReyDeBasto sumar){
		return 21;
	}
	public int sumarTanto(SieteDeOro sumar){
		return 7;
	}

	@Override
	public int sumarTanto(AnchoDeEspada sumar) {
		return 1;
	}

	@Override
	public int sumarTanto(SieteDeEspada sumar) {
		return 7;
	}

	@Override
	public int sumarTanto(TresDeOro sumar) {
		// TODO Auto-generated method stub
		return 3;
	}

	@Override
	public int sumarTanto(TresDeCopa sumar) {
		// TODO Auto-generated method stub
		return 3;
	}

	@Override
	public int sumarTanto(TresDeEspada sumar) {
		// TODO Auto-generated method stub
		return 3;
	}

	@Override
	public int sumarTanto(DosDeOro sumar) {
		// TODO Auto-generated method stub
		return 3;
	}

	@Override
	public int sumarTanto(DosDeCopa sumar) {
		// TODO Auto-generated method stub
		return 2;
	}

	@Override
	public int sumarTanto(DosDeEspada sumar) {
		// TODO Auto-generated method stub
		return 2;
	}

	@Override
	public int sumarTanto(AnchoDeCopa sumar) {
		// TODO Auto-generated method stub
		return 1;
	}

	@Override
	public int sumarTanto(AnchoDeOro sumar) {
		// TODO Auto-generated method stub
		return 1;
	}

	@Override
	public int sumarTanto(ReyDeOro sumar) {
		// TODO Auto-generated method stub
		return 1;
	}

	@Override
	public int sumarTanto(ReyDeCopa sumar) {
		// TODO Auto-generated method stub
		return 1;
	}

	@Override
	public int sumarTanto(ReyDeEspada sumar) {
		// TODO Auto-generated method stub
		return 1;
	}

	@Override
	public int sumarTanto(CaballoDeOro sumar) {
		// TODO Auto-generated method stub
		return 1;
	}

	@Override
	public int sumarTanto(CaballoDeCopa sumar) {
		// TODO Auto-generated method stub
		return 1;
	}

	@Override
	public int sumarTanto(CaballoDeEspada sumar) {
		// TODO Auto-generated method stub
		return 1;
	}

	@Override
	public int sumarTanto(SotaDeOro sumar) {
		// TODO Auto-generated method stub
		return 1;
	}

	@Override
	public int sumarTanto(SotaDeCopa sumar) {
		// TODO Auto-generated method stub
		return 1;
	}

	@Override
	public int sumarTanto(SotaDeEspada sumar) {
		// TODO Auto-generated method stub
		return 1;
	}

	@Override
	public int sumarTanto(SieteDeCopa sumar) {
		// TODO Auto-generated method stub
		return 7;
	}

	@Override
	public int sumarTanto(SeisDeOro sumar) {
		// TODO Auto-generated method stub
		return 6;
	}

	@Override
	public int sumarTanto(SeisDeCopa sumar) {
		// TODO Auto-generated method stub
		return 6;
	}

	@Override
	public int sumarTanto(SeisDeEspada sumar) {
		// TODO Auto-generated method stub
		return 6;
	}

	@Override
	public int sumarTanto(CincoDeOro sumar) {
		// TODO Auto-generated method stub
		return 5;
	}

	@Override
	public int sumarTanto(CincoDeCopa sumar) {
		// TODO Auto-generated method stub
		return 5;
	}

	@Override
	public int sumarTanto(CincoDeEspada sumar) {
		// TODO Auto-generated method stub
		return 5;
	}

	@Override
	public int sumarTanto(CuatroDeEspada sumar) {
		// TODO Auto-generated method stub
		return 4;
	}

	@Override
	public int sumarTanto(CuatroDeOro sumar) {
		// TODO Auto-generated method stub
		return 4;
	}

	@Override
	public int sumarTanto(CuatroDeCopa sumar) {
		// TODO Auto-generated method stub
		return 4;
	}

	@Override
	public String cartaComoString() {
		return "Ancho De Basto";
	}
}
