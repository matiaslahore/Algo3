package fiuba.algo3.tp2.modelo;

import java.util.List;

import fiuba.algo3.tp2.cantosPosibles.CantaronContraFlor;
import fiuba.algo3.tp2.cantosPosibles.CantaronContraFlorxResto;
import fiuba.algo3.tp2.cantosPosibles.CantaronEnvido;
import fiuba.algo3.tp2.cantosPosibles.CantaronFaltaEnvido;
import fiuba.algo3.tp2.cantosPosibles.CantaronFlor;
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
import fiuba.algo3.tp2.cantosPosibles.CantosIniciales;
import fiuba.algo3.tp2.excepciones.EquipoIANoPuedeCargarJugadores;
import fiuba.algo3.tp2.modeloDeCartas.Carta;
import fiuba.algo3.tp2.modeloJugador.IA;
import fiuba.algo3.tp2.modeloJugador.Oyente;
import fiuba.algo3.tp2.modeloJugador.OyenteIA;

public abstract class PartidaDeTrucoConIA extends PartidaDeTruco implements OyenteIA{
	EventosJugador eventosIA;
	
	public PartidaDeTrucoConIA(String nombreEquipoIA, String nombreEquipo2){
		super(nombreEquipoIA,nombreEquipo2);
		this.equipoUno.cargarJugadorIA();
		IA ia = (IA)this.equipoUno.obtenerJugadores().get(0);
		ia.agregarOyentesAEventosIA((OyenteIA)this);
		this.eventosIA = new EventosJugador();
		this.eventosIA.addListener((Oyente) equipoUno.obtenerJugadores().get(0));
	}
	
	public void iniciar() {
		this.mesa.sentarJugadores(equipoUno.obtenerJugadores(), equipoDos.obtenerJugadores());
		this.mesa.iniciarRonda();
		this.jugadorTurnoActual = this.mesa.siguienteJugadorConTurno();
		this.jugadorTurnoActual.hacerJugarIA();
		this.jugadorTurnoActual = this.mesa.siguienteJugadorConTurno();
	}
	
	@Override
	public void cargarJugadoresEnEquipoUno(List<String> nombreJugadores) {
		throw new EquipoIANoPuedeCargarJugadores();
	}
	
	@Override
	public List<Carta> obtenerCartasDelJugadorConTurno() {
		return this.equipoDos.obtenerJugadores().get(0).obtenerCartasDelJugador();
	}
	
	@Override
	public void cantarTruco() {
		this.jugadorTurnoActual.cantarTruco();
		this.cantosDisponibles.modificarCantos(this.jugadorTurnoActual.obtenerEquipo(), new CanteTruco());
		this.eventosIA.seCantoTruco();	
		this.jugadorTurnoActual = this.mesa.siguienteJugadorConTurno();
		this.jugadorTurnoActual.hacerJugarIA();
		this.jugadorTurnoActual = this.mesa.siguienteJugadorConTurno();
		if(this.jugadorTurnoActual.obtenerEquipo().obtenerNombre().equals(this.equipoUno.obtenerNombre())){
			this.jugadorTurnoActual.hacerJugarIA();
			this.jugadorTurnoActual = mesa.siguienteJugadorConTurno();
		}
	}
	
	@Override
	public void cantarQuieroReTruco() {
		this.jugadorTurnoActual.cantarQuieroReTruco();
		this.cantosDisponibles.modificarCantos(this.jugadorTurnoActual.obtenerEquipo(), new CanteReTruco());
		this.eventosIA.seCantoReTruco();
		this.jugadorTurnoActual = this.mesa.siguienteJugadorConTurno();
		//verificar una vez que ande todo, siempre va a entrar aca asi que habria que sacar el if
		if(this.jugadorTurnoActual.obtenerEquipo().obtenerNombre().equals(this.equipoUno.obtenerNombre())){
			this.jugadorTurnoActual.hacerJugarIA();
			this.jugadorTurnoActual = this.mesa.siguienteJugadorConTurno();		
		}
	}
	
	@Override
	public void cantarQuieroValeCuatro() {
		this.jugadorTurnoActual.cantarQuieroValeCuatro();
		this.cantosDisponibles.modificarCantos(this.jugadorTurnoActual.obtenerEquipo(), new CanteValeCuatro());
		this.eventosIA.seCantoValeCuatro();
		this.jugadorTurnoActual = this.mesa.siguienteJugadorConTurno();
		//verificar una vez que ande todo, siempre va a entrar aca asi que habria que sacar el if
		if(this.jugadorTurnoActual.obtenerEquipo().obtenerNombre().equals(this.equipoUno.obtenerNombre())){
			this.jugadorTurnoActual.hacerJugarIA();
			this.jugadorTurnoActual = this.mesa.siguienteJugadorConTurno();		
		}
	}
	
	public void cantarEnvido() {
		this.jugadorTurnoActual.cantarEnvido();
		this.cantosDisponibles.modificarCantos(this.jugadorTurnoActual.obtenerEquipo(), new CanteEnvido());
		this.eventosIA.seCantoEnvido();	
		this.jugadorTurnoActual = this.mesa.siguienteJugadorConTurno();
		this.jugadorTurnoActual.hacerJugarIA();
		this.jugadorTurnoActual = this.mesa.siguienteJugadorConTurno();
		//verificar una vez que ande todo, siempre va a entrar aca asi que habria que sacar el if
		if(this.jugadorTurnoActual.obtenerEquipo().obtenerNombre().equals(this.equipoUno.obtenerNombre())){
			this.jugadorTurnoActual.hacerJugarIA();
			this.jugadorTurnoActual = mesa.siguienteJugadorConTurno();
		}
	}
	
	public void cantarRealEnvido() {
		this.jugadorTurnoActual.cantarRealEnvido();
		this.cantosDisponibles.modificarCantos(this.jugadorTurnoActual.obtenerEquipo(), new CanteRealEnvido());
		this.eventosIA.seCantoRealEnvido();	
		this.jugadorTurnoActual = this.mesa.siguienteJugadorConTurno();
		this.jugadorTurnoActual.hacerJugarIA();
		this.jugadorTurnoActual = this.mesa.siguienteJugadorConTurno();
		if(this.jugadorTurnoActual.obtenerEquipo().obtenerNombre().equals(this.equipoUno.obtenerNombre())){
			this.jugadorTurnoActual.hacerJugarIA();
			this.jugadorTurnoActual = mesa.siguienteJugadorConTurno();
		}
	}
	
	public void cantarFaltaEnvido() {
		this.jugadorTurnoActual.cantarFaltaEnvido();
		this.cantosDisponibles.modificarCantos(this.jugadorTurnoActual.obtenerEquipo(), new CanteFaltaEnvido());
		this.eventosIA.seCantoFaltaEnvido();	
		this.jugadorTurnoActual = this.mesa.siguienteJugadorConTurno();
		this.jugadorTurnoActual.hacerJugarIA();
		this.jugadorTurnoActual = this.mesa.siguienteJugadorConTurno();
		if(this.jugadorTurnoActual.obtenerEquipo().obtenerNombre().equals(this.equipoUno.obtenerNombre())){
			this.jugadorTurnoActual.hacerJugarIA();
			this.jugadorTurnoActual = mesa.siguienteJugadorConTurno();
		}
	}
	
	public void jugarCarta(Carta carta) {
		this.jugadorTurnoActual.jugarCarta(carta);
		this.jugadorTurnoActual = this.mesa.siguienteJugadorConTurno();
		
		if(this.jugadorTurnoActual.obtenerEquipo().obtenerNombre().equals(this.equipoUno.obtenerNombre())){
			this.jugadorTurnoActual.hacerJugarIA();
			this.jugadorTurnoActual = this.mesa.siguienteJugadorConTurno();
		}
		if(this.jugadorTurnoActual.obtenerEquipo().obtenerNombre().equals(this.equipoUno.obtenerNombre())){
			this.jugadorTurnoActual.hacerJugarIA();
			this.jugadorTurnoActual = this.mesa.siguienteJugadorConTurno();
		} 
		//Hace dos veces lo mismo ya que humano juega carta, despues va la maquina, si gana la
		//maquina esa ronda, tiraria de nuevo la maquina, entonces hacemos que vuelva a jugar
	}
	
	public void irseAlMazo(){
		this.jugadorTurnoActual.irseAlMazo();
		this.cantosDisponibles.modificarCantos(this.jugadorTurnoActual.obtenerEquipo(), new CantosIniciales());
		this.eventosIA.seFueAlMazo();
		this.jugadorTurnoActual = this.mesa.siguienteJugadorConTurno();
		if(this.jugadorTurnoActual.obtenerEquipo().obtenerNombre().equals(this.equipoUno.obtenerNombre())){
			this.jugadorTurnoActual.hacerJugarIA();
			this.jugadorTurnoActual = this.mesa.siguienteJugadorConTurno();
		}
	}
	
	public void quiero(){
		this.jugadorTurnoActual.quiero();
		this.jugadorTurnoActual = this.mesa.siguienteJugadorConTurno();
		//verificar una vez que ande todo, siempre va a entrar aca asi que habria que sacar el if
		if(this.jugadorTurnoActual.obtenerEquipo().obtenerNombre() == this.equipoUno.obtenerNombre()){
			this.jugadorTurnoActual.hacerJugarIA();
			this.jugadorTurnoActual = this.mesa.siguienteJugadorConTurno();
		}
		
	}

	public void noQuiero(){
		this.jugadorTurnoActual.noQuiero();
		this.jugadorTurnoActual = this.mesa.siguienteJugadorConTurno();
		//verificar una vez que ande todo, siempre va a entrar aca asi que habria que sacar el if
		if(this.jugadorTurnoActual.obtenerEquipo().obtenerNombre().equals(this.equipoUno.obtenerNombre())){
			this.jugadorTurnoActual.hacerJugarIA();
			this.jugadorTurnoActual = this.mesa.siguienteJugadorConTurno();
		}
	}
	
	@Override
	public abstract void cantarFlor();
	
	@Override
	public abstract void cantarContraFlor();
	
	@Override
	public abstract void cantarContraFlorAJuego();

	//Mensajes de la IA a la partidadeTrucoCOnIA
	@Override
	public void meCantaronEnvido(){
		this.cantosDisponibles.modificarCantos(equipoDos, new CantaronEnvido());
	}
	
	@Override
	public void meCantaronRealEnvido(){
		this.cantosDisponibles.modificarCantos(equipoDos, new CantaronRealEnvido());
	}
	
	@Override
	public void meCantaronFaltaEnvido(){
		this.cantosDisponibles.modificarCantos(equipoDos, new CantaronFaltaEnvido());
	}
	
	@Override
	public void meCantaronTruco(){
		this.cantosDisponibles.modificarCantos(equipoDos, new CantaronTruco());
	}
	
	@Override
	public void meCantaronReTruco(){
		this.cantosDisponibles.modificarCantos(equipoDos, new CantaronReTruco());
	}

	@Override
	public void meCantaronValeCuatro(){
		this.cantosDisponibles.modificarCantos(equipoDos, new CantaronValeCuatro());
	}
	
	@Override
	public void meCantaronFlor(){
		this.cantosDisponibles.modificarCantos(equipoDos, new CantaronFlor());
	}
	
	@Override
	public void meCantaronContraFlor(){
		this.cantosDisponibles.modificarCantos(equipoDos, new CantaronContraFlor());
	}

	@Override
	public void meCantaronContraFlorAJuego(){
		this.cantosDisponibles.modificarCantos(equipoDos, new CantaronContraFlorxResto());
	}
	
}