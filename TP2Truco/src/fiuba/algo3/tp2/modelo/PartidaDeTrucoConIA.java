package fiuba.algo3.tp2.modelo;

import java.util.List;

import fiuba.algo3.tp2.excepciones.EquipoIANoPuedeCargarJugadores;
import fiuba.algo3.tp2.modeloDeCartas.Carta;
import fiuba.algo3.tp2.modeloJugador.Jugador;

public abstract class PartidaDeTrucoConIA extends PartidaDeTruco {
	EventosIA eventosIA;
	
	public PartidaDeTrucoConIA(String nombreEquipoIA, String nombreEquipo2){
		super(nombreEquipoIA,nombreEquipo2);
		this.equipoUno.cargarJugadorIA();
		this.eventosIA = new EventosIA();
		this.eventosIA.addListener((Oyente) equipoUno.obtenerJugadores().get(0));
	}
	
	@Override
	public void cargarJugadoresEnEquipoUno(List<String> nombreJugadores) {
		throw new EquipoIANoPuedeCargarJugadores();
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