package fiuba.algo3.tp2.modeloJugador;

import fiuba.algo3.tp2.excepciones.CantoInvalidoException;
import fiuba.algo3.tp2.modelo.Equipo;
import fiuba.algo3.tp2.modelo.Mesa;

public class IA extends Jugador{

	boolean yaCantoEnvido;
	
	public IA(String name, Mesa mesa, Equipo team) {
		super(name, mesa, team);
		
		yaCantoEnvido = false;
	}
	
	public void juga(){
		
		System.out.println("Juga");
		
		if(this.envido >= 27 && !yaCantoEnvido){
			this.cantarEnvido();
			yaCantoEnvido = true;
			System.out.println("CantoEnvido");
			return;
		}
		
		if (this.refMesa.soyMano()){
			System.out.println("JugoPrimera");
			this.jugarCartaAleatoria();
			return;
		}
		this.jugarCarta(this.manoDelJugador.obtenerMejorCartaParaJugarContra(this.refMesa.obtenerUltimaCartaJugada()));
	}

	public void jugarCartaAleatoria() {
		this.jugarCarta(this.manoDelJugador.obtenerCartaAleatoria());
	}
}
