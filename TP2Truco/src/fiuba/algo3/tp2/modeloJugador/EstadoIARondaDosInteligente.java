package fiuba.algo3.tp2.modeloJugador;

public class EstadoIARondaDosInteligente extends EstadoIA {

	@Override
	public void manejador(IA jugadorIA) {
		
		if(jugadorIA.terminoLaMano()){
			System.out.println("Termino la MANO en ronda dos, se setea EstadoIARondaUno\n");
			jugadorIA.setearEstado(new EstadoIARondaUnoInteligente());
			jugadorIA.hacerJugarIA();
			return;
		}
		if(jugadorIA.esMano()){
			jugadorIA.jugarCartaAleatoria();
			jugadorIA.setearEstado(new EstadoIARondaTresInteligente());
			return;
		}
		jugadorIA.jugarMejorCarta();
		jugadorIA.setearEstado(new EstadoIARondaTresInteligente());

	}

}
