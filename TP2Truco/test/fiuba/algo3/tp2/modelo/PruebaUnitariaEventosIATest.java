package fiuba.algo3.tp2.modelo;

import org.junit.Before;
import org.junit.Test;

public class PruebaUnitariaEventosIATest {
	EventosIA eventosIA;
	IAProbandoEventos IA;
	public class IAProbandoEventos implements Oyente {

		//Seria una simulacion de la IA
		
		@Override
		public void seCantoTruco() {
			 System.out.println("TRUCO");		
		}

		@Override
		public void seCantoReTruco() {
			 System.out.println("RETRUCO");	
			
		}

		@Override
		public void seCantoValeCuatro() {
			 System.out.println("VALECUATRO");	
			
		}

		@Override
		public void seCantoEnvido() {
			 System.out.println("ENVIDO");	
			
		}

		@Override
		public void seCantoRealEnvido() {
			System.out.println("REALENVIDO");	
			
		}

		@Override
		public void seCantoFaltaEnvido() {
			System.out.println("FALTAENVIDO");
			
		}

		@Override
		public void seCantoFlor() {
			System.out.println("FLOR");
			
		}

		@Override
		public void seCantoContraFlor() {
			System.out.println("CONTRAFLOR");
			
		}

		@Override
		public void seCantoContraFlorAJuego() {
			System.out.println("CONTRAFLORAJUEGO");
			
		}
	}

	@Before
	public void inicializar(){
		this.eventosIA = new EventosIA();
		this.IA = new IAProbandoEventos();
		this.eventosIA.addListener(this.IA);
	}
	
	@Test
	public void alguienCantaTrucoYJugadorIAImprimePorPantallaTruco(){
		this.eventosIA.seCantoTruco();
	}
	
	@Test
	public void alguienCantaReTrucoYJugadorIAImprimePorPantallaReTruco(){
		this.eventosIA.seCantoReTruco();
	}
	
	@Test
	public void alguienCantaValeCuatroYJugadorIAImprimePorPantallaValeCuatro(){
		this.eventosIA.seCantoValeCuatro();
	}
	
	@Test
	public void alguienCantaEnvidoYJugadorIAImprimePorPantallaEnvido(){
		this.eventosIA.seCantoEnvido();
	}
	
	@Test
	public void alguienCantaRealEnvidoYJugadorIAImprimePorPantallaRealEnvido(){
		this.eventosIA.seCantoRealEnvido();
	}
	
	@Test
	public void alguienCantaFaltaEnvidoYJugadorIAImprimePorPantallaFaltaEnvido(){
		this.eventosIA.seCantoFaltaEnvido();
	}
	
	@Test
	public void alguienCantaFlorYJugadorIAImprimePorPantallaFlor(){
		this.eventosIA.seCantoFlor();
	}
	
	@Test
	public void alguienCantaContraFlorYJugadorIAImprimePorPantallaContrFlor(){
		this.eventosIA.seCantoContraFlor();
	}
	
	@Test
	public void alguienCantaContraFlorAJuegoYJugadorIAImprimePorPantallaContrFlorAJuego(){
		this.eventosIA.seCantoContraFlorAJuego();
	}
}
