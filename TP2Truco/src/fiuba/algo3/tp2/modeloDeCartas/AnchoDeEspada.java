package fiuba.algo3.tp2.modeloDeCartas;

public class AnchoDeEspada implements Carta {
	
	public AnchoDeEspada(){
	}
	
	public int valorParaEnvido(){
		return 1;
	}
	
	public Carta vs(Carta contra) {
		return contra.vs(this);
	}
	
	public Carta vs(AnchoDeEspada contra){
		return this;
	}
	
	public Carta vs(AnchoDeBasto contra){
		return this;
	}

	public Carta vs(SieteDeEspada contra){
		return this;
	}

	public Carta vs(SieteDeOro contra){
		return this;
	}

	public Carta vs(Tres contra){
		return this;
	}

	public Carta vs(Dos contra){
		return this;
	}

	public Carta vs(AnchoFalso contra){
		return this;
	}

	public Carta vs(Rey contra){
		return this;
	}

	public Carta vs(Caballo contra){
		return this;
	}

	public Carta vs(Sota contra){
		return this;
	}

	public Carta vs(SieteFalso contra){
		return this;
	}

	public Carta vs(Seis contra){
		return this;
	}

	public Carta vs(Cinco contra){
		return this;
	}

	public Carta vs(Cuatro contra){
		return this;
	}
	
	//SUMAR ENVIDO
	
	public int sumarTanto(Carta sumar) {
		return sumar.sumarTanto(this);
	}
	
	public int sumarTanto(AnchoDeEspada sumar){
		return 0;
	}
	public int sumarTanto(DosDeEspada sumar){
		return 23;
	}
	public int sumarTanto(TresDeEspada sumar){
		return 24;
	}
	public int sumarTanto(CuatroDeEspada sumar){
		return 25;
	}
	public int sumarTanto(CincoDeEspada sumar){
		return 26;
	}
	public int sumarTanto(SeisDeEspada sumar){
		return 27;
	}
	public int sumarTanto(SieteDeEspada sumar){
		return 28;
	}
	public int sumarTanto(SotaDeEspada sumar){
		return 21;
	}
	public int sumarTanto(CaballoDeEspada sumar){
		return 21;
	}
	public int sumarTanto(ReyDeEspada sumar){
		return 21;
	}
	
	public int sumarTanto(SieteDeOro sumar){
		return 7;
	}
	
	@Override
	public int sumarTanto(AnchoDeBasto sumar) {
		return 1;
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
	public int sumarTanto(TresDeBasto sumar) {
		// TODO Auto-generated method stub
		return 3;
	}

	@Override
	public int sumarTanto(DosDeOro sumar) {
		// TODO Auto-generated method stub
		return 2;
	}

	@Override
	public int sumarTanto(DosDeCopa sumar) {
		// TODO Auto-generated method stub
		return 2;
	}

	@Override
	public int sumarTanto(DosDeBasto sumar) {
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
	public int sumarTanto(ReyDeBasto sumar) {
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
	public int sumarTanto(CaballoDeBasto sumar) {
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
	public int sumarTanto(SotaDeBasto sumar) {
		// TODO Auto-generated method stub
		return 1;
	}

	@Override
	public int sumarTanto(SieteDeCopa sumar) {
		// TODO Auto-generated method stub
		return 7;
	}

	@Override
	public int sumarTanto(SieteDeBasto sumar) {
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
	public int sumarTanto(SeisDeBasto sumar) {
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
	public int sumarTanto(CincoDeBasto sumar) {
		// TODO Auto-generated method stub
		return 5;
	}

	@Override
	public int sumarTanto(CuatroDeOro sumar) {
		// TODO Auto-generated method stub
		return 4;
	}

	@Override
	public int sumarTanto(CuatroDeBasto sumar) {
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
		return "Ancho De Espada";
	}	
}