package fiuba.algo3.tp2.modeloRondas;

import java.util.ArrayList;

import fiuba.algo3.colecciones.ListaCircular;
import fiuba.algo3.tp2.modelo.Equipo;
import fiuba.algo3.tp2.modelo.Juez;
import fiuba.algo3.tp2.modeloDeCartas.Carta;
import fiuba.algo3.tp2.modeloJugador.Jugador;

public class EstadoRondaDos extends EstadoRondas{
	//SE CANTA EL TRUCO
	//SE JUEGAN CARTAS
	//SE EMPARDA
	//IRSE AL MAZO
	//SE GANA
	
	public EstadoRondaDos(EstadoRondas estadoRonda, Juez juez, ArrayList<Equipo> ganadoresRonda,
			ListaCircular<Jugador> jugadores, int indexManoAux, int indexMano) {

		super(estadoRonda, juez, ganadoresRonda, jugadores, indexManoAux, indexMano);
	}

	public EstadoRondas siguienteRonda(){
		
		Carta ganadora = this.juez.obtenerCartaGanadoraDeRonda();
		
		int indexCartaGanadora = this.juez.obtenerListaDeCartasEnJuego().lastIndexOf(ganadora);
		
		if (this.juez.hayParda()){
			ganadoresRonda.add(ganadoresRonda.get(0)); //gana el q gano primera
		}else{
			Jugador ganador = this.jugadores.get(this.jugadorManoDeLaRondaActual + indexCartaGanadora);
			ganadoresRonda.add(ganador.obtenerEquipo());
		}
				
		System.out.println("RONDA DOS gana " + this.ganadoresRonda.get(1).obtenerNombre() + "\n");
		
		this.juez.limpiarCartasEnJuegoDeRondaActual();
		
		if (this.ganadoresRonda.get(0) == this.ganadoresRonda.get(1)){ //gano 1ra y 2da el mismo
			this.juez.anotarPuntos(this.ganadoresRonda.get(1));
			this.ganadoresRonda.clear();
			
			this.jugadorMano = this.jugadorMano + 1;
			
			this.juez.mezclar(); //renuevo el mazo
			repartir();
			
			if (esPicaPica()){
				return new EstadoRondaUnoPicaPica(refEstadoRonda, juez, ganadoresRonda, jugadores, this.jugadorMano, this.jugadorMano, jugadores);
			}
			
			return new EstadoRondaUno(refEstadoRonda, juez, ganadoresRonda, jugadores, this.jugadorMano, this.jugadorMano);
		}
		refEstadoRonda = new EstadoRondaTres(refEstadoRonda, juez, ganadoresRonda, jugadores, this.jugadorManoDeLaRondaActual + indexCartaGanadora, this.jugadorMano);
		refEstadoRonda.modificarCantoTruco(this.cantosTruco);
		return this.refEstadoRonda;
	}
}
