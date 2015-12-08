package fiuba.algo3.tp2.modeloDeCartas;

import fiuba.algo3.tp2.modeloDeCartas.AnchoDeBasto;
import fiuba.algo3.tp2.modeloDeCartas.AnchoDeEspada;
import fiuba.algo3.tp2.modeloDeCartas.AnchoFalso;
import fiuba.algo3.tp2.modeloDeCartas.Caballo;
import fiuba.algo3.tp2.modeloDeCartas.Cinco;
import fiuba.algo3.tp2.modeloDeCartas.Cuatro;
import fiuba.algo3.tp2.modeloDeCartas.Dos;
import fiuba.algo3.tp2.modeloDeCartas.Rey;
import fiuba.algo3.tp2.modeloDeCartas.Seis;
import fiuba.algo3.tp2.modeloDeCartas.SieteDeEspada;

public class Sota extends Carta{

	public Sota(Palo palo){
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
		return 0;
	}
	
	public String cartaComoString() {
		return "Diez De " + this.obtenerPalo().comoString();
	}
}