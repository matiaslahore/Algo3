package fiuba.algo3.tp2.modelo;

import java.util.List;

import fiuba.algo3.tp2.cantosPosibles.*;
import fiuba.algo3.tp2.excepciones.EquipoIANoPuedeCargarJugadores;
import fiuba.algo3.tp2.modeloDeCartas.Carta;
import fiuba.algo3.tp2.modeloJugador.Oyente;

public abstract class PartidaDeTrucoConIA extends PartidaDeTruco {
	EventosIA eventosIA;
	
	public PartidaDeTrucoConIA(String nombreEquipoIA, String nombreEquipo2){
		super(nombreEquipoIA,nombreEquipo2);
		this.equipoUno.cargarJugadorIA();
		this.eventosIA = new EventosIA();
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

	
	/////////////////////////////////////////////
	public void meCantaronEnvido(){
		this.cantosDisponibles.modificarCantos(equipoDos, new CantaronEnvido());
	}
	
	public void meCantaronRealEnvido(){
		this.cantosDisponibles.modificarCantos(equipoDos, new CantaronRealEnvido());
	}
	
	public void meCantaronFaltaEnvido(){
		this.cantosDisponibles.modificarCantos(equipoDos, new CantaronFaltaEnvido());
	}
	
	public void meCantaronTruco(){
		this.cantosDisponibles.modificarCantos(equipoDos, new CantaronTruco());
	}
	
	public void meCantaronReTruco(){
		this.cantosDisponibles.modificarCantos(equipoDos, new CantaronReTruco());
	}

	public void meCantaronValeCuatro(){
		this.cantosDisponibles.modificarCantos(equipoDos, new CantaronValeCuatro());
	}
	
}