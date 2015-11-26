package fiuba.algo3.tp2.modeloRondas;

import java.util.ArrayList;

import fiuba.algo3.colecciones.ListaCircular;
import fiuba.algo3.tp2.modelo.Juez;
import fiuba.algo3.tp2.modeloDeCartas.TipoDeCartas;
import fiuba.algo3.tp2.modeloJugador.Jugador;
import fiuba.algo3.tp2.tiposDeCanto.EmpezarTruco;

public class EstadoRondaUnoPicaPica extends EstadoRondaPicaPica{

	public EstadoRondaUnoPicaPica(EstadoRondas estadoRonda, Juez juez, ArrayList<String> ganadoresRonda,
			ListaCircular<Jugador> jugadores, int indexManoAux, int indexMano) {
		
		super(estadoRonda, juez, ganadoresRonda, jugadores, indexManoAux, indexMano);
		this.cantosTruco = new EmpezarTruco(); //ronda uno empiezo desde cero
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
		
		refEstadoRonda = new EstadoRondaDosPicaPica(refEstadoRonda, juez, ganadoresRonda, nuevosJugadores, this.jugadorManoDeLaRondaActual + indexCartaGanadora, this.jugadorMano);
		refEstadoRonda.modificarCantoTruco(this.cantosTruco);
		return this.refEstadoRonda;
	}
	
}
