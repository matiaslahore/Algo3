package fiuba.algo3.tp2.modelo;

import org.junit.Before;
import org.junit.Test;

public class IAProbandoEventosTest {
	EventosIA eventosIA;
	IAProbandoEventos IA;
	
	
	@Before
	public void inicializar(){
		this.eventosIA = new EventosIA();
		this.IA = new IAProbandoEventos();
		this.eventosIA.addListener(this.IA);
	}
	
	@Test
	public void alguienCantaTrucoYJugadorIAImprimePorPantalla(){
		this.eventosIA.seCantoTruco();
	}

}
