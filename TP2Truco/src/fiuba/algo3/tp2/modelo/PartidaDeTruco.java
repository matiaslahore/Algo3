package fiuba.algo3.tp2.modelo;

import java.util.ArrayList;
import java.util.List;

import fiuba.algo3.tp2.cantosPosibles.CantaronEnvido;
import fiuba.algo3.tp2.cantosPosibles.CantaronFaltaEnvido;
import fiuba.algo3.tp2.cantosPosibles.CantaronReTruco;
import fiuba.algo3.tp2.cantosPosibles.CantaronRealEnvido;
import fiuba.algo3.tp2.cantosPosibles.CantaronTruco;
import fiuba.algo3.tp2.cantosPosibles.CantaronValeCuatro;
import fiuba.algo3.tp2.cantosPosibles.CanteEnvido;
import fiuba.algo3.tp2.cantosPosibles.CanteFaltaEnvido;
import fiuba.algo3.tp2.cantosPosibles.CanteReTruco;
import fiuba.algo3.tp2.cantosPosibles.CanteRealEnvido;
import fiuba.algo3.tp2.cantosPosibles.CanteTruco;
import fiuba.algo3.tp2.cantosPosibles.CanteValeCuatro;
import fiuba.algo3.tp2.cantosPosibles.CantosDisponibles;
import fiuba.algo3.tp2.cantosPosibles.CantosIniciales;
import fiuba.algo3.tp2.cantosPosibles.CantosPosiblesEntreEquipos;
import fiuba.algo3.tp2.cantosPosibles.QuiseEnvido;
import fiuba.algo3.tp2.cantosPosibles.QuiseReTruco;
import fiuba.algo3.tp2.cantosPosibles.QuiseTruco;
import fiuba.algo3.tp2.cantosPosibles.QuiseValeCuatro;
import fiuba.algo3.tp2.cantosPosibles.RondaSinEnvido;
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
		this.cantosDisponibles.modificarCantos(equipoUno, new CantosIniciales());
		this.cantosDisponibles.modificarCantos(equipoDos, new CantosIniciales());
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
		this.cantosDisponibles.modificarCantos(this.jugadorTurnoActual.obtenerEquipo(), new CanteEnvido());
		this.jugadorTurnoActual = this.mesa.siguienteJugadorConTurno();
		this.cantosDisponibles.modificarCantos(this.jugadorTurnoActual.obtenerEquipo(), new CantaronEnvido());
	}

	public void cantarRealEnvido() {
		this.jugadorTurnoActual.cantarRealEnvido();
		this.cantosDisponibles.modificarCantos(this.jugadorTurnoActual.obtenerEquipo(), new CanteRealEnvido());
		this.jugadorTurnoActual = this.mesa.siguienteJugadorConTurno();
		this.cantosDisponibles.modificarCantos(this.jugadorTurnoActual.obtenerEquipo(), new CantaronRealEnvido());
	}

	public void cantarFaltaEnvido() {
		this.jugadorTurnoActual.cantarFaltaEnvido();
		this.cantosDisponibles.modificarCantos(this.jugadorTurnoActual.obtenerEquipo(), new CanteFaltaEnvido());
		this.jugadorTurnoActual = this.mesa.siguienteJugadorConTurno();
		this.cantosDisponibles.modificarCantos(this.jugadorTurnoActual.obtenerEquipo(), new CantaronFaltaEnvido());
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

	//la partida escucha de la rondaEnvido
	//Ya es llamado desde juez
	@Override
	public void jugadorQuisoEnvido(){
		this.cantosDisponibles.modificarCantos(this.jugadorTurnoActual.obtenerEquipo(), new QuiseEnvido());	
	}

	//la partida escucha de RondaUno
	//en este metodo el constructor de RondaUno puede mandar el evento
	//Ya se llama desde juez
	@Override
	public void seComenzoRondaUno(){
		this.cantosDisponibles.modificarCantos(this.jugadorTurnoActual.obtenerEquipo(), new QuiseEnvido());		
	}
	
	//en este metodo, siguienteRonda de RondaUno puede mandar el evento, x ejemplo al principio del metodo siguienteRonda
	@Override
	public void seTerminoRondaUno(){
		if (this.cantosDisponibles.cantosPosibles(equipoUno).getClass().equals(CantosIniciales.class)){
			this.cantosDisponibles.modificarCantos(equipoUno, new RondaSinEnvido());
			this.cantosDisponibles.modificarCantos(equipoDos, new RondaSinEnvido());
		}
		//este if es xq si no se canto nada, tengo q sacarle los envidos..
	}
		
}
