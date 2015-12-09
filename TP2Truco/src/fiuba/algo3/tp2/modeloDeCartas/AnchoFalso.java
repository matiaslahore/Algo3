package fiuba.algo3.tp2.modeloDeCartas;

public class AnchoFalso extends Carta{

	public AnchoFalso(Palo palo){
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

	public int obtenerValorParaEnvido() {
		return 1;
	}
	
	public String cartaComoString() {
		return "Ancho De " + this.obtenerPalo().comoString();
	}
}