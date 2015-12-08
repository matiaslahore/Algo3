package fiuba.algo3.tp2.modeloCartas;

import fiuba.algo3.tp2.modeloCartas.SieteDeOro;
import fiuba.algo3.tp2.modeloCartas.SieteFalso;
import fiuba.algo3.tp2.modeloCartas.Sota;
import fiuba.algo3.tp2.modeloCartas.Tres;

public class AnchoDeEspada extends Carta{

	public AnchoDeEspada(){
		this.palo = new Espada();
	}
	
	public Carta vs(Carta contra){
		return contra.vs(this);
	}
	
	public Carta vs(AnchoDeEspada contra){
		return this;
	}

	public Carta vs(AnchoDeBasto contra) {
		return this;
	}
	
	public Carta vs(SieteDeEspada contra){
		return this;
	}
	
	public Carta vs(SieteDeOro contra){
		return this;
	}
	
	public Carta vs(Tres contra) {
		return this;
	}

	public Carta vs(Dos contra) {
		return this;
	}

	public Carta vs(AnchoFalso contra) {
		return this;
	}

	public Carta vs(Rey contra) {
		return this;
	}

	public Carta vs(Caballo contra) {
		return this;
	}

	public Carta vs(Sota contra) {
		return this;
	}

	public Carta vs(SieteFalso contra) {
		return this;
	}

	public Carta vs(Seis contra) {
		return this;
	}

	public Carta vs(Cinco contra) {
		return this;
	}

	public Carta vs(Cuatro contra) {
		return this;
	}

	public int obtenerValorParaEnvido() {		
		return 1;
	}
	
	public String cartaComoString() {
		return "Ancho De " + this.obtenerPalo().comoString();
	}
}
