package fiuba.algo3.tp2.modeloRondas;

import java.util.ArrayList;

import fiuba.algo3.colecciones.ListaCircular;
import fiuba.algo3.tp2.modelo.Juez;
import fiuba.algo3.tp2.modeloDeCartas.TipoDeCartas;
import fiuba.algo3.tp2.modeloJugador.Jugador;

public class EstadoRondaEnvido extends EstadoRondas{
	private TiposDeCantoEnvido cantosEnvido;
	
	public EstadoRondaEnvido(EstadoRondas estadoRonda, Juez juez, ArrayList<String> ganadoresRonda, ArrayList<TipoDeCartas> cartasEnJuego, ListaCircular<Jugador> jugadores, int indexManoAux, int indexMano, String canto) {
		super(estadoRonda, juez, ganadoresRonda, cartasEnJuego, jugadores, indexManoAux, indexMano);
		//crear una nueva clase por el nombre, get.class .... y el nombre es el "canto"
		//asignar el nuevo objeto, al cantosEnvido
	}
	
	public void cantarEnvido(String equipoQueCanta){
		this.cantosEnvido = this.cantosEnvido.cantarEnvido(equipoQueCanta);
	}
	
	public void cantarRealEnvido(String equipoQueCanta){
		this.cantosEnvido = this.cantosEnvido.cantarRealEnvido(equipoQueCanta);
	}
	
	public void cantarFaltaEnvido(String equipoQueCanta){
		this.cantosEnvido = this.cantosEnvido.cantarFaltaEnvido(equipoQueCanta);
	}
	
	@Override
	public EstadoRondas ganador() {
		return this.refEstadoRonda;
	}
	
	public EstadoRondas acualizarRonda() {
		return this;
	}

	public Jugador turnoDe() {
		Jugador jugador = this.jugadores.get(this.jugadorMano + 2); //2 es manejo de indices //aclarar
		return jugador;
	}
	
	public EstadoRondas quiero(Jugador jugador) {
		for ( int i = jugadorMano ; i <= (this.jugadores.size() - 1 + jugadorMano) ; i=i+1 ){
			Jugador actual = this.jugadores.get(i);
			tantoEnJuego.add(actual.obtenerPuntosEnvido());
		}
		
		int tantoGanador = this.juez.quienGanaElTanto(this.tantoEnJuego);
		int indexTantoGanador = this.tantoEnJuego.indexOf(tantoGanador); //gana el q es mano tmb
		
		Jugador ganador = this.jugadores.get(this.jugadorMano + indexTantoGanador);
		
		this.juez.puntosEnJuego(this.cantosEnvido.quiso());
		this.juez.anotarPuntos(ganador.obtenerNombreEquipo());
		
		this.tantoEnJuego.clear();
		
		return this.refEstadoRonda;
	}
	
	public EstadoRondas noQuiero(Jugador jugador) {
		this.juez.puntosEnJuego(this.cantosEnvido.noQuiso());
		//ESTO ES FEO PERO NO SE ME OCURRE JUSTO AHORA OTRA MANERA
		this.juez.anotarPuntos((this.jugadores.get(this.jugadores.indexOf(jugador) + 1)).obtenerNombreEquipo());
		this.indexMano = this.indexMano + 1; //aumento quien empieza la prox mano
		return new EstadoRondaUno(refEstadoRonda, juez, ganadoresRonda, cartasEnJuego,jugadores, this.indexMano, this.indexMano);
	}
	
}
