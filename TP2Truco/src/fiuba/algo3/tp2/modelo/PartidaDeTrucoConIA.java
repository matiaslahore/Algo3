package fiuba.algo3.tp2.modelo;

import java.util.List;

import fiuba.algo3.tp2.modeloDeCartas.Carta;
import fiuba.algo3.tp2.modeloJugador.Jugador;

public abstract class PartidaDeTrucoConIA {
	private EventosIA eventosIA;
	private Equipo equipoIA;
	private Equipo equipoDos;
	private Mesa mesa;
	
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
	
	//Definimos manualmente que la IA siempre empiece el juego
	public void iniciar() {
		this.mesa.sentarJugadores(equipoIA.obtenerJugadores(), equipoDos.obtenerJugadores());
		this.mesa.iniciarRonda();
		this.equipoIA.obtenerJugadores().get(0).hacerJugarIA();
	}
	
	//jugar carta siempre lo va a hacer el jugador, la IA lo va a hacer a traves de la mesa
	public void jugarCarta(Carta carta) {
		this.equipoDos.obtenerJugadores().get(0).jugarCarta(carta);
		this.equipoIA.obtenerJugadores().get(0).hacerJugarIA();
	}
	
	//Los cantos no cambian de turno, sino que le avisan a la IA para que actue,
	//Y despues continua el juego, tirando cartas por ejemplo
	public void cantarTruco() {
		this.equipoDos.obtenerJugadores().get(0).cantarTruco();
		this.eventosIA.seCantoTruco();
	}
	
	public void cantarQuieroReTruco() {
		this.equipoDos.obtenerJugadores().get(0).cantarQuieroReTruco();
		this.eventosIA.seCantoReTruco();
	}
	
	public void cantarQuieroValeCuatro() {
		this.equipoDos.obtenerJugadores().get(0).cantarQuieroValeCuatro();
		this.eventosIA.seCantoValeCuatro();
	}
	
	public void cantarEnvido() {
		this.equipoDos.obtenerJugadores().get(0).cantarEnvido();
		this.eventosIA.seCantoEnvido();
	}
	
	public void cantarRealEnvido() {
		this.equipoDos.obtenerJugadores().get(0).cantarRealEnvido();
		this.eventosIA.seCantoRealEnvido();
	}
	
	public void cantarFaltaEnvido() {
		this.equipoDos.obtenerJugadores().get(0).cantarFaltaEnvido();
		this.eventosIA.seCantoFaltaEnvido();
	}

	//Metodos Obtener
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
	
	public List<Carta> obtenerCartasDelJugador() {
		return this.equipoDos.obtenerJugadores().get(0).obtenerCartasDelJugador();
	}
	
	//Otros metodos
	public void irseAlMazo(){
		this.equipoDos.obtenerJugadores().get(0).irseAlMazo();
	}
	
	public void quiero(){
		this.equipoDos.obtenerJugadores().get(0).quiero();
	}

	public void noQuiero(){
		this.equipoDos.obtenerJugadores().get(0).noQuiero();
	}
	
	//Cantos de la flor ; Van a ser reimplementados en las clases hijas
	//PartidaDeTrucoConIAConFlor y PartidaDeTrucoConIASinFlor
	public abstract void cantarFlor();
	
	public abstract void cantarContraFlor();
	
	public abstract void cantarContraFlorAJuego();

}