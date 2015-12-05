package fiuba.algo3.tp2.modelo;

import java.util.List;

import fiuba.algo3.tp2.modeloDeCartas.Carta;
import fiuba.algo3.tp2.modeloJugador.IA;

public class PartidaDeTrucoConIA {

	Equipo equipoIA;
	Equipo equipoDos;
	Mesa mesa;
	
	public PartidaDeTrucoConIA(String nombreEq1, String nombreEq2){
		this.mesa = new Mesa();
		this.equipoIA = new Equipo(nombreEq1, mesa);
		this.equipoDos = new Equipo(nombreEq2, mesa);
		this.equipoIA.cargarJugador(nombreEq1);
		this.equipoIA.cargarJugadorIA();
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
		this.jugadorTurnoActual = this.mesa.siguienteJugadorConTurno();
	}
}