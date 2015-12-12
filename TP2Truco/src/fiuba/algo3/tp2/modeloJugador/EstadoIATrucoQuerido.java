package fiuba.algo3.tp2.modeloJugador;

public class EstadoIATrucoQuerido extends EstadoIA {

	@Override
	public void manejador(IA jugadorIA) {		
		if(jugadorIA.terminoLaMano()){
			System.out.println("Termino la MANO en Truco, se setea EstadoIARondaUno\n");
			jugadorIA.setearEstado(new EstadoIARondaUnoInteligente());
			jugadorIA.hacerJugarIA();
			return;
		}
		if(jugadorIA.esMano()){			
			jugadorIA.jugarCartaAleatoria();
			return;
		}
		jugadorIA.jugarMejorCarta();
		return;
	}
}
