package fiuba.algo3.tp2.modelo;

import java.util.ArrayList;
import java.util.List;

import fiuba.algo3.tp2.cantosPosibles.*;
import fiuba.algo3.tp2.modeloDeCartas.Carta;
import fiuba.algo3.tp2.modeloJugador.Jugador;

public abstract class PartidaDeTruco implements OyenteJuez{
	CantosDisponibles cantosDisponibles;
	Equipo equipoUno;
	Equipo equipoDos;
	Mesa mesa;
	Jugador jugadorTurnoActual;

	public PartidaDeTruco(String nombreEq1, String nombreEq2){
		this.mesa = new Mesa();
		this.equipoUno = new Equipo(nombreEq1, mesa);
		this.equipoDos = new Equipo(nombreEq2, mesa);
		this.mesa.instanciarJuez(equipoUno, equipoDos);
		this.cantosDisponibles = new CantosDisponibles();
		this.mesa.agregarOyentesAlJuez((OyenteJuez)this);
	}

	public void cargarJugadoresEnEquipoUno(List<String> nombreJugadores) {
		this.equipoUno.cargarJugadores(nombreJugadores);
	}

	public void cargarJugadoresEnEquipoDos(List<String> nombreJugadores) {
		this.equipoDos.cargarJugadores(nombreJugadores);
	}

	public void iniciar() {
		ArrayList<Jugador> jugadoresEquipoUno = equipoUno.obtenerJugadores();
		ArrayList<Jugador> jugadoresEquipoDos = equipoDos.obtenerJugadores();
		this.mesa.sentarJugadores(jugadoresEquipoUno, jugadoresEquipoDos);
		this.mesa.iniciarRonda();
		this.jugadorTurnoActual = this.mesa.siguienteJugadorConTurno();
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

	public List<Carta> obtenerCartasDelJugadorConTurno() {
		return this.jugadorTurnoActual.obtenerCartasDelJugador();
	}

	public void jugarCarta(Carta carta) {
		this.jugadorTurnoActual.jugarCarta(carta);
		this.jugadorTurnoActual = this.mesa.siguienteJugadorConTurno();
	}

	public void cantarTruco() {
		this.jugadorTurnoActual.cantarTruco();
		this.cantosDisponibles.modificarCantos(this.jugadorTurnoActual.obtenerEquipo(), new CanteTruco());
		this.jugadorTurnoActual = this.mesa.siguienteJugadorConTurno();
		this.cantosDisponibles.modificarCantos(this.jugadorTurnoActual.obtenerEquipo(), new CantaronTruco());
	}

	public void cantarQuieroReTruco() {
		this.jugadorTurnoActual.cantarQuieroReTruco();
		this.cantosDisponibles.modificarCantos(this.jugadorTurnoActual.obtenerEquipo(), new CanteReTruco());
		this.jugadorTurnoActual = this.mesa.siguienteJugadorConTurno();
		this.cantosDisponibles.modificarCantos(this.jugadorTurnoActual.obtenerEquipo(), new CantaronReTruco());
	}

	public void cantarQuieroValeCuatro() {
		this.jugadorTurnoActual.cantarQuieroValeCuatro();
		this.cantosDisponibles.modificarCantos(this.jugadorTurnoActual.obtenerEquipo(), new CanteValeCuatro());
		this.jugadorTurnoActual = this.mesa.siguienteJugadorConTurno();
		this.cantosDisponibles.modificarCantos(this.jugadorTurnoActual.obtenerEquipo(), new CantaronValeCuatro());
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
		this.cantosDisponibles.modificarCantos(this.jugadorTurnoActual.obtenerEquipo(), new CantosIniciales());
		this.jugadorTurnoActual = this.mesa.siguienteJugadorConTurno();
		this.cantosDisponibles.modificarCantos(this.jugadorTurnoActual.obtenerEquipo(), new CantosIniciales());
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

	public CantosPosiblesEntreEquipos cantosEquipoActual(){
		return this.cantosDisponibles.cantosPosibles(this.jugadorTurnoActual.obtenerEquipo());
	}

	//LA PARTIDA ESCUCHA A JUEZ
	@Override
	public void jugadorCantoEnvido(Equipo equipoQueCanta){
		if (equipoQueCanta.equals(equipoUno)) {
			this.cantosDisponibles.modificarCantos(equipoDos, new CantaronEnvido());		
		}else{
			this.cantosDisponibles.modificarCantos(equipoUno, new CantaronEnvido());		
		}
	}

	@Override
	public void jugadorCantoEnvidoEnvido(Equipo equipoQueCanta){
		if (equipoQueCanta.equals(equipoUno)) {
			this.cantosDisponibles.modificarCantos(equipoDos, new CantaronEnvidoEnvido());		
		}else{
			this.cantosDisponibles.modificarCantos(equipoUno, new CantaronEnvidoEnvido());		
		}
	}

	@Override
	public void jugadorCantoRealEnvido(Equipo equipoQueCanta){
		if (equipoQueCanta.equals(equipoUno)) {
			this.cantosDisponibles.modificarCantos(equipoDos, new CantaronRealEnvido());		
		}else{
			this.cantosDisponibles.modificarCantos(equipoUno, new CantaronRealEnvido());		
		}
	}

	@Override
	public void jugadorCantoFaltaEnvido(Equipo equipoQueCanta){
		if (equipoQueCanta.equals(equipoUno)) {
			this.cantosDisponibles.modificarCantos(equipoDos, new CantaronFaltaEnvido());		
		}else{
			this.cantosDisponibles.modificarCantos(equipoUno, new CantaronFaltaEnvido());		
		}
	}

	@Override
	public void jugadorQuisoTruco(){
		this.cantosDisponibles.modificarCantos(this.jugadorTurnoActual.obtenerEquipo(), new QuiseTruco());
	}

	@Override
	public void jugadorQuisoReTruco(){
		this.cantosDisponibles.modificarCantos(this.jugadorTurnoActual.obtenerEquipo(), new QuiseReTruco());
	}

	@Override
	public void jugadorQuisoValeCuatro(){
		this.cantosDisponibles.modificarCantos(this.jugadorTurnoActual.obtenerEquipo(), new QuiseValeCuatro());
	}

	@Override
	public void jugadorQuisoEnvido(){
		this.cantosDisponibles.modificarCantos(equipoUno, new RondaSinEnvido());
		this.cantosDisponibles.modificarCantos(equipoDos, new RondaSinEnvido());
	}

	@Override
	public void seComenzoRondaUno(){
		this.cantosDisponibles.modificarCantos(equipoUno, new CantosIniciales());
		this.cantosDisponibles.modificarCantos(equipoDos, new CantosIniciales());
	}

	@Override
	public void seTerminoRondaUno(){
		if (this.cantosDisponibles.cantosPosibles(equipoUno).getClass().equals(CantosIniciales.class)){
			this.cantosDisponibles.modificarCantos(equipoUno, new RondaSinEnvido());
			this.cantosDisponibles.modificarCantos(equipoDos, new RondaSinEnvido());
		}
		//este if es xq si no se canto nada, tengo q sacarle los envidos..
	}

	@Override
	public void jugadorCantoFlor(Equipo equipoQueCanta){
		if (equipoQueCanta.equals(equipoUno)) {
			this.cantosDisponibles.modificarCantos(equipoDos, new CantaronFlor());		
		}else{
			this.cantosDisponibles.modificarCantos(equipoUno, new CantaronFlor());		
		}
	}

	@Override
	public void jugadorCantoContraFlor(Equipo equipoQueCanta){
		if (equipoQueCanta.equals(equipoUno)) {
			this.cantosDisponibles.modificarCantos(equipoDos, new CantaronContraFlor());		
		}else{
			this.cantosDisponibles.modificarCantos(equipoUno, new CantaronContraFlor());		
		}
	}

	@Override
	public void jugadorCantoContraFlorAJuego(Equipo equipoQueCanta){
		if (equipoQueCanta.equals(equipoUno)) {
			this.cantosDisponibles.modificarCantos(equipoDos, new CantaronContraFlorxResto());		
		}else{
			this.cantosDisponibles.modificarCantos(equipoUno, new CantaronContraFlorxResto());		
		}
	}

}
