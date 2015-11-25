package fiuba.algo3.tp2.modeloRondas;

import java.util.ArrayList;

import fiuba.algo3.colecciones.ListaCircular;
import fiuba.algo3.tp2.excepciones.CantoInvalidoException;
import fiuba.algo3.tp2.modelo.Juez;
import fiuba.algo3.tp2.modeloDeCartas.TipoDeCartas;
import fiuba.algo3.tp2.modeloJugador.Jugador;
import fiuba.algo3.tp2.tiposDeCanto.TiposDeCantoEnvido;

public class EstadoRondaEnvido extends EstadoRondas{
	
	private TiposDeCantoEnvido cantosEnvido;
	
	//Constructores <van a depender de lo que el jugador canto <Envido,Real,Falta>>
	/*
	public EstadoRondaEnvido(EstadoRondas estadoRonda, Juez juez, ArrayList<String> ganadoresRonda, ArrayList<TipoDeCartas> cartasEnJuego, ListaCircular<Jugador> jugadores, int indexManoAux, int indexMano, Envido envido) {
		super(estadoRonda, juez, ganadoresRonda, cartasEnJuego, jugadores, indexManoAux, indexMano);
		this.cantosEnvido = envido;
	}
	
	public EstadoRondaEnvido(EstadoRondas estadoRonda, Juez juez, ArrayList<String> ganadoresRonda, ArrayList<TipoDeCartas> cartasEnJuego, ListaCircular<Jugador> jugadores, int indexManoAux, int indexMano, RealEnvido realEnvido) {
		super(estadoRonda, juez, ganadoresRonda, cartasEnJuego, jugadores, indexManoAux, indexMano);
		this.cantosEnvido = realEnvido;
	}
	
	public EstadoRondaEnvido(EstadoRondas estadoRonda, Juez juez, ArrayList<String> ganadoresRonda, ArrayList<TipoDeCartas> cartasEnJuego, ListaCircular<Jugador> jugadores, int indexManoAux, int indexMano,FaltaEnvido faltaEnvido) {
		super(estadoRonda, juez, ganadoresRonda, cartasEnJuego, jugadores, indexManoAux, indexMano);
		this.cantosEnvido = faltaEnvido;
	}
	
	public EstadoRondaEnvido(EstadoRondas estadoRonda, Juez juez, ArrayList<String> ganadoresRonda, ArrayList<TipoDeCartas> cartasEnJuego, ListaCircular<Jugador> jugadores, int indexManoAux, int indexMano, EnvidoEnvido envidoEnvido) {
		super(estadoRonda, juez, ganadoresRonda, cartasEnJuego, jugadores, indexManoAux, indexMano);
		this.cantosEnvido = envidoEnvido;
	}
	*/
	public EstadoRondaEnvido(EstadoRondas estadoRonda, Juez juez, ArrayList<String> ganadoresRonda, ArrayList<TipoDeCartas> cartasEnJuego, ListaCircular<Jugador> jugadores, int indexManoAux, int indexMano, TiposDeCantoEnvido tipoDeCanto) {
		super(estadoRonda, juez, ganadoresRonda, cartasEnJuego, jugadores, indexManoAux, indexMano);
		this.cantosEnvido = tipoDeCanto;
	}
	
	//Funciones	
	/*public void cantarEnvido(String equipoQueCanta){
		try{
			this.cantosEnvido = this.cantosEnvido.cantarEnvido(equipoQueCanta);
		}catch(CantoInvalidoException e){
		}
	}
	
	public void cantarRealEnvido(String equipoQueCanta){
		try {
			this.cantosEnvido = this.cantosEnvido.cantarRealEnvido(equipoQueCanta);
		} catch (CantoInvalidoException e) {
		}
	}
	
	public void cantarFaltaEnvido(String equipoQueCanta){
		try {
			this.cantosEnvido = this.cantosEnvido.cantarFaltaEnvido(equipoQueCanta);
		} catch (CantoInvalidoException e) {
		}
	}*/
	
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
		
		if(this.cantosEnvido.quiso() == -1){
			this.juez.obtenerPuntosFaltaEnvido(jugador.obtenerEquipoQuePertenece());
		}
		else{
			this.juez.puntosEnJuego(this.cantosEnvido.quiso());
		}
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
	
	public EstadoRondas cantarEnvido(Jugador jugador)throws CantoInvalidoException{
		TiposDeCantoEnvido unTipoDeEnvido = null;
		try{
			unTipoDeEnvido = this.cantosEnvido.cantarEnvido(jugador.obtenerEquipoQuePertenece());
		}catch(CantoInvalidoException e){
			throw e;
		}
		this.jugadorMano = this.jugadorMano + 1;
		return new EstadoRondaEnvido(refEstadoRonda, juez, ganadoresRonda, cartasEnJuego, jugadores, jugadorMano, indexMano,unTipoDeEnvido);
	}
	
	public EstadoRondas cantarRealEnvido(Jugador jugador) throws CantoInvalidoException {
		TiposDeCantoEnvido unTipoDeRealEnvido = null;
		try{
			unTipoDeRealEnvido = this.cantosEnvido.cantarRealEnvido(jugador.obtenerEquipoQuePertenece());
		}catch(CantoInvalidoException e){
			throw e;
		}
		this.jugadorMano = this.jugadorMano + 1;
		return new EstadoRondaEnvido(refEstadoRonda, juez, ganadoresRonda, cartasEnJuego, jugadores, jugadorMano, indexMano,unTipoDeRealEnvido);
	}
	
	public EstadoRondas cantarFaltaEnvido(Jugador jugador) throws CantoInvalidoException {
		TiposDeCantoEnvido unTipoDeFaltaEnvido = null;
		try{
			unTipoDeFaltaEnvido = this.cantosEnvido.cantarFaltaEnvido(jugador.obtenerEquipoQuePertenece());
		}catch(CantoInvalidoException e){
			throw e;
		}
		this.jugadorMano = this.jugadorMano + 1;
		return new EstadoRondaEnvido(refEstadoRonda, juez, ganadoresRonda, cartasEnJuego, jugadores, jugadorMano, indexMano,unTipoDeFaltaEnvido);
	}
	
}
