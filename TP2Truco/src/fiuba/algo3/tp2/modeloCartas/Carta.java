package fiuba.algo3.tp2.modeloCartas;

import fiuba.algo3.tp2.modeloCartas.SieteDeOro;
import fiuba.algo3.tp2.modeloCartas.SieteFalso;
import fiuba.algo3.tp2.modeloCartas.Sota;
import fiuba.algo3.tp2.modeloCartas.Tres;

public abstract class Carta {
	
	public Palo palo;
	
	public boolean hayParda(Carta contra){
		return (this.vs(contra) != contra.vs(this));
	}
	
	public abstract Carta vs(Carta contra);
	
	public abstract Carta vs(AnchoDeEspada contra);

	public abstract Carta vs(AnchoDeBasto contra);
	
	public abstract Carta vs(SieteDeEspada contra);
	
	public abstract Carta vs(SieteDeOro contra);

	public abstract Carta vs(Tres contra);
	
	public abstract Carta vs(Dos contra);
	
	public abstract Carta vs(AnchoFalso contra);
	
	public abstract Carta vs(Rey contra);
	
	public abstract Carta vs(Caballo contra);
	
	public abstract Carta vs(Sota contra);

	public abstract Carta vs(SieteFalso contra);
	
	public abstract Carta vs(Seis contra);

	public abstract Carta vs(Cinco contra);

	public abstract Carta vs(Cuatro contra);
	
	public abstract String cartaComoString();
	
	public int sumarEnvido(Carta unaCarta){
		if(this.sonDelMismoPalo(unaCarta)){
			return 20 + this.obtenerValorParaEnvido() + unaCarta.obtenerValorParaEnvido();
		}
		return Math.max(this.obtenerValorParaEnvido(), unaCarta.obtenerValorParaEnvido());
	}
	
	private boolean sonDelMismoPalo(Carta unaCarta) {
		return this.obtenerPalo().esElMismoPalo(unaCarta.obtenerPalo());
	}
	
	public int sumarFlor(Carta cartaDos, Carta cartaTres){
		
		return this.obtenerValorParaEnvido() + cartaDos.obtenerValorParaEnvido()
				+ cartaTres.obtenerValorParaEnvido() + 20;
	}	
	
	public abstract int obtenerValorParaEnvido();
	
	public Palo obtenerPalo(){
		return this.palo;
	}
}
