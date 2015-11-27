package fiuba.algo3.tp2.modeloDeCartas;

public abstract class Cinco implements Carta{
	
	public int valorParaEnvido(){
		return 5;
	}
	
	public Carta vs(Carta contra){
		return contra.vs(this);
	}

	public Carta vs(AnchoDeEspada contra){
		return contra;
	}

	public Carta vs(AnchoDeBasto contra){
		return contra;
	}

	public Carta vs(SieteDeEspada contra){
		return contra;
	}

	public Carta vs(SieteDeOro contra){
		return contra;
	}

	public Carta vs(Tres contra){
		return contra;
	}

	public Carta vs(Dos contra){
		return contra;
	}

	public Carta vs(AnchoFalso contra){
		return contra;
	}

	public Carta vs(Rey contra){
		return contra;
	}

	public Carta vs(Caballo contra){
		return contra;
	}

	public Carta vs(Sota contra){
		return contra;
	}

	public Carta vs(SieteFalso contra){
		return contra;
	}

	public Carta vs(Seis contra){
		return contra;
	}

	public Carta vs(Cinco contra){
		return this;
	}

	public Carta vs(Cuatro contra){
		return this;
	}
	
	//Sumar Tantos
	
	@Override
	public int sumarTanto(TresDeOro sumar) {
		// TODO Auto-generated method stub
		return 5;
	}

	@Override
	public int sumarTanto(TresDeCopa sumar) {
		// TODO Auto-generated method stub
		return 5;
	}

	@Override
	public int sumarTanto(TresDeEspada sumar) {
		// TODO Auto-generated method stub
		return 5;
	}
	
	@Override
	public int sumarTanto(TresDeBasto sumar) {
		// TODO Auto-generated method stub
		return 5;
	}

	@Override
	public int sumarTanto(DosDeOro sumar) {
		// TODO Auto-generated method stub
		return 5;
	}

	@Override
	public int sumarTanto(DosDeCopa sumar) {
		// TODO Auto-generated method stub
		return 5;
	}

	@Override
	public int sumarTanto(DosDeEspada sumar) {
		// TODO Auto-generated method stub
		return 5;
	}

	@Override
	public int sumarTanto(DosDeBasto sumar) {
		// TODO Auto-generated method stub
		return 5;
	}
	
	public int sumarTanto(AnchoDeEspada sumar) {
		return 5;
	}
	
	
	@Override
	public int sumarTanto(AnchoDeCopa sumar) {
		// TODO Auto-generated method stub
		return 5;
	}

	@Override
	public int sumarTanto(AnchoDeOro sumar) {
		// TODO Auto-generated method stub
		return 5;
	}
	
	@Override
	public int sumarTanto(AnchoDeBasto sumar) {
		// TODO Auto-generated method stub
		return 5;
	}

	@Override
	public int sumarTanto(ReyDeOro sumar) {
		// TODO Auto-generated method stub
		return 5;
	}

	@Override
	public int sumarTanto(ReyDeCopa sumar) {
		// TODO Auto-generated method stub
		return 5;
	}

	@Override
	public int sumarTanto(ReyDeEspada sumar) {
		// TODO Auto-generated method stub
		return 5;
	}
	
	@Override
	public int sumarTanto(ReyDeBasto sumar) {
		// TODO Auto-generated method stub
		return 5;
	}

	@Override
	public int sumarTanto(CaballoDeOro sumar) {
		// TODO Auto-generated method stub
		return 5;
	}

	@Override
	public int sumarTanto(CaballoDeCopa sumar) {
		// TODO Auto-generated method stub
		return 5;
	}

	@Override
	public int sumarTanto(CaballoDeEspada sumar) {
		// TODO Auto-generated method stub
		return 5;
	}

	@Override
	public int sumarTanto(CaballoDeBasto sumar) {
		// TODO Auto-generated method stub
		return 5;
	}
	
	@Override
	public int sumarTanto(SotaDeOro sumar) {
		// TODO Auto-generated method stub
		return 5;
	}

	@Override
	public int sumarTanto(SotaDeCopa sumar) {
		// TODO Auto-generated method stub
		return 5;
	}

	@Override
	public int sumarTanto(SotaDeEspada sumar) {
		// TODO Auto-generated method stub
		return 5;
	}

	public int sumarTanto(SotaDeBasto sumar) {
		// TODO Auto-generated method stub
		return 5;
	}
	
	public int sumarTanto(SieteDeBasto sumar){
		return 7;
	}

	public int sumarTanto(SieteDeOro sumar){
		return 7;
	}

	public int sumarTanto(SieteDeEspada sumar) {
		return 7;
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

	
	public int sumarTanto(CincoDeEspada sumar) {
		
		return 5;
	}
	
	public int sumarTanto(CincoDeBasto sumar) {
		
		return 5;
	}

	public int sumarTanto(CuatroDeEspada sumar) {
		
		return 5;
	}

	public int sumarTanto(CuatroDeOro sumar) {
		return 5;
	}
	
	public int sumarTanto(CuatroDeBasto sumar) {
		return 5;
	}
	
	public int sumarTanto(CuatroDeCopa sumar) {
		return 5;
	}
}