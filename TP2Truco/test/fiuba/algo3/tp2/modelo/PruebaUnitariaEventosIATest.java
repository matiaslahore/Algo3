package fiuba.algo3.tp2.modelo;

import org.junit.Before;
import org.junit.Test;

import fiuba.algo3.tp2.modeloJugador.IA;

public class PruebaUnitariaEventosIATest {
	EventosIA eventosIA;
	IA IA;
	
	@Before
	public void inicializar(){
		this.eventosIA = new EventosIA();
		Mesa mesa = new Mesa();
		this.IA = new IA("soy inteligente", mesa, new Equipo("equipo inteligente",mesa));
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
