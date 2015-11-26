package fiuba.algo3.tp2.modeloRondas;

import java.util.ArrayList;

import fiuba.algo3.colecciones.ListaCircular;
import fiuba.algo3.tp2.modelo.Juez;
import fiuba.algo3.tp2.modeloDeCartas.TipoDeCartas;
import fiuba.algo3.tp2.modeloJugador.Jugador;

public class EstadoRondaTresPicaPica extends EstadoRondaPicaPica{

	public EstadoRondaTresPicaPica(EstadoRondas estadoRonda, Juez juez, ArrayList<String> ganadoresRonda,
			ListaCircular<Jugador> jugadoresOriginal, int indexManoAux, int indexMano, ListaCircular<Jugador> jugadores) {
		
		super(estadoRonda, juez, ganadoresRonda, jugadoresOriginal, indexManoAux, indexMano, jugadores);
		
		nuevosJugadores = jugadores;
	}

	public EstadoRondas ganador(){
		TipoDeCartas ganadora = this.juez.obtenerCartaGanadoraDeRonda();
		
		int indexCartaGanadora = this.juez.obtenerListaDeCartasEnJuego().lastIndexOf(ganadora);
		
		if (this.juez.hayParda()){ //es parda
			ganadoresRonda.add(ganadoresRonda.get(1)); //gana el q gano segunda
		}else{
			Jugador ganador = this.nuevosJugadores.get(this.jugadorManoDeLaRondaActual + indexCartaGanadora);
			ganadoresRonda.add(ganador.obtenerNombreEquipo());
		}
		
		this.juez.anotarPuntos(ganadoresRonda.get(2));
		
		System.out.println("RONDA TRES gana: " + this.ganadoresRonda.get(2) + "\n");
				
		this.juez.limpiarCartasEnJuegoDeRondaActual();
		
		this.jugadorMano = this.jugadorMano + 1; //aumento quien empieza la prox mano
		
		if (cantidadJugadas == 4){
			cantidadJugadas = 1;
			return new EstadoRondaUno(refEstadoRonda, juez, ganadoresRonda, jugadores, this.jugadorMano - 2, this.jugadorMano);
		}
		else {
			return new EstadoRondaUnoPicaPica(refEstadoRonda, juez, ganadoresRonda, jugadores, this.jugadorMano, this.jugadorMano, nuevosJugadores);
		}
	}
	
}
