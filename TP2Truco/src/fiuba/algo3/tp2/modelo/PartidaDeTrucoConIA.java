package fiuba.algo3.tp2.modelo;

import java.util.List;

import fiuba.algo3.tp2.modeloDeCartas.Carta;
import fiuba.algo3.tp2.modeloJugador.Jugador;

public class PartidaDeTrucoConIA {
	private EventosIA eventosIA;
	private Equipo equipoIA;
	private Equipo equipoDos;
	private Mesa mesa;
	private Jugador jugadorTurnoActual;
	
	public PartidaDeTrucoConIA(String nombreEq1, String nombreEq2){
		this.mesa = new Mesa();
		this.equipoIA = new Equipo(nombreEq1, mesa);
		this.equipoDos = new Equipo(nombreEq2, mesa);
		this.equipoIA.cargarJugador(nombreEq1);
		this.equipoIA.cargarJugadorIA();
		this.eventosIA = new EventosIA();
		this.eventosIA.addListener((Oyente) equipoIA.obtenerJugadores().get(0));
	}
	
	public void cargarJugador(String jugador){
		this.equipoDos.cargarJugador(jugador);
	}
	
	public void iniciar() {
		this.mesa.sentarJugadores(equipoIA.obtenerJugadores(), equipoDos.obtenerJugadores());
		this.mesa.iniciarRonda();
		this.jugadorTurnoActual = this.mesa.siguienteJugadorConTurno();
	}
	
	public int obtenerPuntajeDeEquipoIA() {
		return this.mesa.puntosEquipo(equipoIA);
	}
	
	public int obtenerPuntajeDeEquipoDos() {
		return this.mesa.puntosEquipo(equipoDos);
	}
	
	public String obtenerNombreDeEquipoUno() {
		return this.equipoIA.obtenerNombre();
	}
	
	public String obtenerNombreDeEquipoDos() {
		return this.equipoDos.obtenerNombre();
	}
	
	public List<Carta> cartasDelJugador() {
		return this.equipoDos.obtenerJugadores().get(0).obtenerCartasDelJugador();
	}
	
	public void jugarCarta(Carta carta) {
		this.equipoDos.obtenerJugadores().get(0).jugarCarta(carta);
		this.equipoIA.obtenerJugadores().get(0).hacerJugarIA();
	}
	
	//Los cantos no cambian de turno, sino que le avisan a la IA para que actue,
	//Y despues continua el juego, tirando cartas..
	public void cantarTruco() {
		this.jugadorTurnoActual.cantarTruco();
		this.eventosIA.seCantoTruco();
	}
	
	public void cantarQuieroReTruco() {
		this.jugadorTurnoActual.cantarQuieroReTruco();
		this.eventosIA.seCantoReTruco();
	}
	
	public void cantarQuieroValeCuatro() {
		this.jugadorTurnoActual.cantarQuieroValeCuatro();
		this.eventosIA.seCantoValeCuatro();
	}
	
	public void cantarEnvido() {
		this.jugadorTurnoActual.cantarEnvido();
		this.eventosIA.seCantoEnvido();
	}
	
	public void cantarRealEnvido() {
		this.jugadorTurnoActual.cantarRealEnvido();
		this.eventosIA.seCantoRealEnvido();
	}
	
	public void cantarFaltaEnvido() {
		this.jugadorTurnoActual.cantarFaltaEnvido();
		this.eventosIA.seCantoFaltaEnvido();
	}
	
}