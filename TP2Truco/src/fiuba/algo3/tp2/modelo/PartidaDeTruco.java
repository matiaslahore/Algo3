package fiuba.algo3.tp2.modelo;

import java.util.List;

import fiuba.algo3.tp2.modeloDeCartas.Carta;
import fiuba.algo3.tp2.modeloJugador.Jugador;

public abstract class PartidaDeTruco {
	
	Equipo equipoUno;
	Equipo equipoDos;
	Mesa mesa;
	Jugador jugadorTurnoActual;
	
	public PartidaDeTruco(String nombreEq1, String nombreEq2){
		this.mesa = new Mesa();
		this.equipoUno = new Equipo(nombreEq1, mesa);
		this.equipoDos = new Equipo(nombreEq2, mesa);
	}
	
	public void cargarJugadoresEnEquipoUno(List<String> nombreJugadores) {
		this.equipoUno.cargarJugadores(nombreJugadores);
	}
	
	public void cargarJugadoresEnEquipoDos(List<String> nombreJugadores) {
		this.equipoDos.cargarJugadores(nombreJugadores);
	}
	
	public Equipo obtenerEquipo(String nombreDelEquipo){
		
		if (equipoUno.tieneEsteNombre(nombreDelEquipo)){
			return equipoUno;
		}
		return equipoDos;
	}

	public void iniciar() {
		this.mesa.sentarJugadores(equipoUno.obtenerJugadores(), equipoDos.obtenerJugadores());
		this.mesa.iniciarRonda();
		this.jugadorTurnoActual = this.mesa.siguienteJugadorConTurno();
	}

	public String ultimoGanador() {
		return this.mesa.ganadorDeLaRonda().obtenerNombre();
	}
	
	public int obtenerPuntajeDeEquipoUno() {
		return this.mesa.puntosEquipo(equipoUno);
	}
	
	public int obtenerPuntajeDeEquipoDos() {
		return this.mesa.puntosEquipo(equipoDos);
	}
	
	public String obtenerNombreDeEquipoUno() {
		return this.equipoUno.obtenerNombre();
	}
	
	public String obtenerNombreDeEquipoDos() {
		return this.equipoDos.obtenerNombre();
	}
	
	public void verCartasDelJugadorConTurno() {
		this.jugadorTurnoActual.mostrarCartas();
	}
	
	public List<Carta> cartasDelJugadorConTurno() {
		return this.jugadorTurnoActual.obtenerCartasDelJugador();
	}
	
	public void jugarCarta(Carta carta) {
		this.jugadorTurnoActual.jugarCarta(carta);
		this.jugadorTurnoActual = this.mesa.siguienteJugadorConTurno();
	}
	
	public void cantarTruco() {
		this.jugadorTurnoActual.cantarTruco();
		this.jugadorTurnoActual = this.mesa.siguienteJugadorConTurno();
	}
	
	public void cantarQuieroReTruco() {
		this.jugadorTurnoActual.cantarQuieroReTruco();
		this.jugadorTurnoActual = this.mesa.siguienteJugadorConTurno();
	}
	
	public void cantarQuieroValeCuatro() {
		this.jugadorTurnoActual.cantarQuieroValeCuatro();
		this.jugadorTurnoActual = this.mesa.siguienteJugadorConTurno();
	}
	
	public void cantarEnvido() {
		this.jugadorTurnoActual.cantarEnvido();
		this.jugadorTurnoActual = this.mesa.siguienteJugadorConTurno();
	}
	
	public void cantarRealEnvido() {
		this.jugadorTurnoActual.cantarRealEnvido();
		this.jugadorTurnoActual = this.mesa.siguienteJugadorConTurno();
	}
	
	public void cantarFaltaEnvido() {
		this.jugadorTurnoActual.cantarFaltaEnvido();
		this.jugadorTurnoActual = this.mesa.siguienteJugadorConTurno();
	}
	
	public void irseAlMazo(){
		this.jugadorTurnoActual.irseAlMazo();
		this.jugadorTurnoActual = this.mesa.siguienteJugadorConTurno();
	}
	
	public void quiero(){
		this.jugadorTurnoActual.quiero();
		this.jugadorTurnoActual = this.mesa.siguienteJugadorConTurno();
	}

	public void noQuiero(){
		this.jugadorTurnoActual.noQuiero();
		this.jugadorTurnoActual = this.mesa.siguienteJugadorConTurno();
	}
	
	public abstract void cantarFlor();
	
	public abstract void cantarContraFlor();
	
	public abstract void cantarContraFlorAJuego();

	public List<Carta> cartasEnJuego() {
		return this.mesa.obtenerListaDeCartasJugadas();
	}

	public String obtenerNombreDelJugadorConTurno() {
		return this.jugadorTurnoActual.obtenerNombre();
	}
	
	public void cartearseParaHacerLosTest(Jugador unJugador, List<Carta> cartasParaJugador){
		unJugador.recibirCartas(cartasParaJugador);
	}
	
}
