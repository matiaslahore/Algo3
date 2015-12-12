package fiuba.algo3.tp2.modelo;

import java.util.List;

import fiuba.algo3.tp2.excepciones.EquipoIANoPuedeCargarJugadores;
import fiuba.algo3.tp2.modeloDeCartas.Carta;
import fiuba.algo3.tp2.modeloJugador.EventosJugador;
import fiuba.algo3.tp2.modeloJugador.OyenteJugador;

public abstract class PartidaDeTrucoConIA extends PartidaDeTruco {
	
	public PartidaDeTrucoConIA(String nombreEquipoIA, String nombreEquipo2){
		super(nombreEquipoIA,nombreEquipo2);
		this.equipoUno.cargarJugadorIA();
	}
	
	public void iniciar() {
		//Pone a la ia como oyente de jugador
		this.equipoDos.obtenerJugadores().get(0).cargarOyente((OyenteJugador)this.equipoUno.obtenerJugadores().get(0));
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
		this.jugadorTurnoActual = this.mesa.siguienteJugadorConTurno();
		//verificar una vez que ande todo, siempre va a entrar aca asi que habria que sacar el if
		if(this.jugadorTurnoActual.obtenerEquipo().obtenerNombre().equals(this.equipoUno.obtenerNombre())){
			this.jugadorTurnoActual.hacerJugarIA();
			this.jugadorTurnoActual = this.mesa.siguienteJugadorConTurno();		
		}
	}
	
	public void cantarEnvido() {
		this.jugadorTurnoActual.cantarEnvido();
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
	

}