package fiuba.algo3.tp2.modeloJugador;

import fiuba.algo3.tp2.modelo.Equipo;
import fiuba.algo3.tp2.modelo.Mesa;

public class IA extends Jugador{

	public IA(String name, Mesa mesa, Equipo team) {
		super(name, mesa, team);
	}
	
	public void juga(){
			
		if (this.refMesa.soyMano()){
			this.jugarCartaAleatoria();
		}
		this.jugarCarta(this.manoDelJugador.obtenerMejorCartaParaJugarContra(this.refMesa.obtenerUltimaCartaJugada()));
	}

	public void jugarCartaAleatoria() {
		this.jugarCarta(this.manoDelJugador.obtenerCartaAleatoria());
	}
}
