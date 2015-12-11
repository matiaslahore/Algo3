package fiuba.algo3.tp2.vista;

import fiuba.algo3.tp2.modelo.OyenteDePartida;
import fiuba.algo3.tp2.modelo.PartidaDeTruco;

public class ControladorDeBotones implements OyenteDePartida {

	public ControladorDeBotones(PartidaDeTruco partida){
		partida.agregarOyentesALaPartida(this);
	}

	@Override
	public void seCantoTruco() {
		System.out.println("se Canto Truco");
	}

	@Override
	public void seQuiso() {
		System.out.println("se Quiso ");
	}

	@Override
	public void noSeQuiso() {
		System.out.println("No se Quiso ");
	}

	@Override
	public void seCantoFlor() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void seCantoContraFlorAJuego() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void seCantoContraFlor() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void seCantoFaltaEnvido() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void seCantoEnvido() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void seCantoValeCuatro() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void seCantoReTruco() {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void seCantoEnvidoEnvido() {
		//Aca vas a crear una neuva visual con todos los botones menos el de envido
	}

	@Override
	public void seCantoRealEnvido() {
		//lo mismo pero aca vas a crear todos menos los de envido y real envido
	}

}
