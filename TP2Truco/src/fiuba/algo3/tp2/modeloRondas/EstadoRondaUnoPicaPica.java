package fiuba.algo3.tp2.modeloRondas;

import java.util.ArrayList;

import fiuba.algo3.colecciones.ListaCircular;
import fiuba.algo3.tp2.modelo.Juez;
import fiuba.algo3.tp2.modeloDeCartas.TipoDeCartas;
import fiuba.algo3.tp2.modeloJugador.Jugador;
import fiuba.algo3.tp2.tiposDeCanto.EmpezarTruco;

public class EstadoRondaUnoPicaPica extends EstadoRondaPicaPica{

	public EstadoRondaUnoPicaPica(EstadoRondas estadoRonda, Juez juez, ArrayList<String> ganadoresRonda,
			ListaCircular<Jugador> jugadoresOriginal, int indexManoAux, int indexMano, ListaCircular<Jugador> jugadores) {
		
		super(estadoRonda, juez, ganadoresRonda, jugadoresOriginal, indexManoAux, indexMano, jugadores);
		
		this.cantosTruco = new EmpezarTruco(); //ronda uno empiezo desde cero
		
		nuevosJugadores = new ListaCircular<Jugador>();
		nuevosJugadores.add(listaOriginal().get(indexManoAux));//(this.jugadores.get(indexManoAux));
		nuevosJugadores.add(listaOriginal().get(indexManoAux + 3));//(this.jugadores.get(indexManoAux + 3));
		
		System.out.println(nuevosJugadores.get(0).obtenerNombre());
		System.out.println(nuevosJugadores.get(1).obtenerNombre());
		
		jugadorManoDeLaRondaActual = 0;
	}

	public EstadoRondas ganador(){
		this.ganadoresRonda.clear();
		
		TipoDeCartas ganadora = this.juez.obtenerCartaGanadoraDeRonda();
		int indexCartaGanadora = this.juez.obtenerListaDeCartasEnJuego().lastIndexOf(ganadora);
		
		if (this.juez.hayParda()){ //es parda
			this.juez.limpiarCartasEnJuegoDeRondaActual();
			System.out.println("RONDA UNO PARDA");
			ganadoresRonda.add("Parda"); //esto se podria sacar..pero es para el test
			
			refEstadoRonda = new EstadoRondaDosParda(refEstadoRonda, juez, ganadoresRonda, jugadores, this.jugadorManoDeLaRondaActual, this.jugadorMano);
			refEstadoRonda.modificarCantoTruco(this.cantosTruco);
			return this.refEstadoRonda;
		}
		Jugador ganador = this.nuevosJugadores.get(this.jugadorManoDeLaRondaActual + indexCartaGanadora);
		
		ganadoresRonda.add(ganador.obtenerNombreEquipo());
		
		this.juez.limpiarCartasEnJuegoDeRondaActual();
		
		System.out.println("RONDA UNO la gana: " + this.ganadoresRonda.get(0) + "\n");
		
		refEstadoRonda = new EstadoRondaDosPicaPica(refEstadoRonda, juez, ganadoresRonda, jugadores, this.jugadorManoDeLaRondaActual + indexCartaGanadora, this.jugadorMano, nuevosJugadores);
		refEstadoRonda.modificarCantoTruco(this.cantosTruco);
		return this.refEstadoRonda;
	}
	
}
