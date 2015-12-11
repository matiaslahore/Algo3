package fiuba.algo3.tp2.vista;

import fiuba.algo3.tp2.modelo.OyenteDePartida;

public class ControladorDeBotones implements OyenteDePartida {

	public ControladorDeBotones(){

	}

	@Override
	public void seCantoEnvidoEnvido() {
		//Aca vas a crear una neuva visual con todos los botones menos el de envido
	}

	@Override
	public void seCantoRealEnvido() {
		//lo mismo pero aca vas a crear todos menos los de envido y real envido
	}

	@Override
	public void seCantoTruco() {
		System.out.println("se Canto Truco");
	}

	@Override
	public void seQuisoTruco() {
		System.out.println("se Quiso Truco");
	}

	@Override
	public void noSeQuisoTruco() {
		System.out.println("No se Quiso Truco");
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

}
