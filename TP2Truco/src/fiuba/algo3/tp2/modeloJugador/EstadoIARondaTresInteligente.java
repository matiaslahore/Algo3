package fiuba.algo3.tp2.modeloJugador;

public class EstadoIARondaTresInteligente extends EstadoIA {

	@Override
	public void manejador(IA jugadorIA) {
		
		if(jugadorIA.terminoLaMano()){
			System.out.println("Termino la MANO en ronda TRES, se setea EstadoIARondaUno\n");
			jugadorIA.setearEstado(new EstadoIARondaUnoInteligente());
			jugadorIA.hacerJugarIA();
			return;
		}
		if(jugadorIA.esMano()){
			jugadorIA.jugarCartaAleatoria();
			jugadorIA.setearEstado(new EstadoIARondaUnoInteligente());
			return;
		}
		jugadorIA.jugarMejorCarta();
		jugadorIA.setearEstado(new EstadoIARondaUnoInteligente());
	}
}
