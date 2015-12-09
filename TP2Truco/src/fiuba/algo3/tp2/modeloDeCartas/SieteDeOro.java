package fiuba.algo3.tp2.modeloDeCartas;

import fiuba.algo3.tp2.modeloDeCartas.AnchoDeBasto;
import fiuba.algo3.tp2.modeloDeCartas.AnchoDeEspada;
import fiuba.algo3.tp2.modeloDeCartas.SieteFalso;
import fiuba.algo3.tp2.modeloDeCartas.Sota;
import fiuba.algo3.tp2.modeloDeCartas.Tres;


public class SieteDeOro extends Carta{

	public SieteDeOro(){
		this.palo = new Oro();
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

	public int obtenerValorParaEnvido() {
		return 7;
	}
	
	public String cartaComoString() {
		return "Siete De " + this.obtenerPalo().comoString();
	}
}
