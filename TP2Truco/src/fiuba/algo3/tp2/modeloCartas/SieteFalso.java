package fiuba.algo3.tp2.modeloCartas;

import fiuba.algo3.tp2.modeloCartas.AnchoDeBasto;
import fiuba.algo3.tp2.modeloCartas.AnchoDeEspada;
import fiuba.algo3.tp2.modeloCartas.AnchoFalso;
import fiuba.algo3.tp2.modeloCartas.Caballo;
import fiuba.algo3.tp2.modeloCartas.Cinco;
import fiuba.algo3.tp2.modeloCartas.Cuatro;
import fiuba.algo3.tp2.modeloCartas.Dos;
import fiuba.algo3.tp2.modeloCartas.Rey;
import fiuba.algo3.tp2.modeloCartas.Seis;
import fiuba.algo3.tp2.modeloCartas.SieteDeEspada;

public class SieteFalso extends Carta{
	
	public SieteFalso(Palo palo){
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
		return contra;
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