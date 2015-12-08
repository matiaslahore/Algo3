package fiuba.algo3.tp2.modeloCartas;


public class Cuatro extends Carta{
	
	public Cuatro(Palo palo){
		this.palo = palo;
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

	public Carta vs(SieteDeOro contra) {
		return contra;
	}

	public Carta vs(Tres contra) {
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

	public Carta vs(Sota contra) {
		return contra;
	}

	public Carta vs(SieteFalso contra) {
		return contra;
	}
	
	public Carta vs(Seis contra){
		return contra;
	}

	public Carta vs(Cinco contra){
		return contra;
	}

	public Carta vs(Cuatro contra){
		return this;
	}

	public int obtenerValorParaEnvido() {
		return 4;
	}
	
	public String cartaComoString() {
		return "Cuatro De " + this.obtenerPalo().comoString();
	}
}