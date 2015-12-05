package fiuba.algo3.tp2.modelo;

import java.util.List;

import fiuba.algo3.tp2.excepciones.EquipoIANoPuedeCargarJugadores;
import fiuba.algo3.tp2.modeloDeCartas.Carta;
import fiuba.algo3.tp2.modeloJugador.IA;
import fiuba.algo3.tp2.modeloJugador.Jugador;

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
		this.jugadorTurnoActual = this.mesa.siguienteJugadorConTurno();
		if(this.jugadorTurnoActual.obtenerEquipo().obtenerNombre() != this.equipoUno.obtenerNombre()){
			this.eventosIA.seCantoTruco();
		}
		this.jugadorTurnoActual.hacerJugarIA();
		this.jugadorTurnoActual = this.mesa.siguienteJugadorConTurno();
	}
	
	@Override
	public void cantarQuieroReTruco() {
		this.jugadorTurnoActual.cantarQuieroReTruco();
		this.jugadorTurnoActual = this.mesa.siguienteJugadorConTurno();
		if(this.jugadorTurnoActual.obtenerEquipo().obtenerNombre() != this.equipoUno.obtenerNombre()){
			this.eventosIA.seCantoReTruco();
		}
		this.jugadorTurnoActual.hacerJugarIA();
		this.jugadorTurnoActual = this.mesa.siguienteJugadorConTurno();
	}
	
	@Override
	public void cantarQuieroValeCuatro() {
		this.jugadorTurnoActual.cantarQuieroValeCuatro();
		this.jugadorTurnoActual = this.mesa.siguienteJugadorConTurno();
		if(this.jugadorTurnoActual.obtenerEquipo().obtenerNombre() != this.equipoUno.obtenerNombre()){
			this.eventosIA.seCantoValeCuatro();
		}
		this.jugadorTurnoActual.hacerJugarIA();
		this.jugadorTurnoActual = this.mesa.siguienteJugadorConTurno();
	}
	
	public void cantarEnvido() {
		this.jugadorTurnoActual.cantarEnvido();
		this.jugadorTurnoActual = this.mesa.siguienteJugadorConTurno();
		if(this.jugadorTurnoActual.obtenerEquipo().obtenerNombre() != this.equipoUno.obtenerNombre()){
			this.eventosIA.seCantoEnvido();
		}
		this.jugadorTurnoActual.hacerJugarIA();
		this.jugadorTurnoActual = this.mesa.siguienteJugadorConTurno();
	}
	
	public void cantarRealEnvido() {
		this.jugadorTurnoActual.cantarRealEnvido();
		this.jugadorTurnoActual = this.mesa.siguienteJugadorConTurno();
		if(this.jugadorTurnoActual.obtenerEquipo().obtenerNombre() != this.equipoUno.obtenerNombre()){
			this.eventosIA.seCantoRealEnvido();
		}
		this.jugadorTurnoActual.hacerJugarIA();
		this.jugadorTurnoActual = this.mesa.siguienteJugadorConTurno();
	}
	
	public void cantarFaltaEnvido() {
		this.jugadorTurnoActual.cantarFaltaEnvido();
		this.jugadorTurnoActual = this.mesa.siguienteJugadorConTurno();
		if(this.jugadorTurnoActual.obtenerEquipo().obtenerNombre() != this.equipoUno.obtenerNombre()){
			this.eventosIA.seCantoFaltaEnvido();
		}
		this.jugadorTurnoActual.hacerJugarIA();
		this.jugadorTurnoActual = this.mesa.siguienteJugadorConTurno();
	}
	
	public void jugarCarta(Carta carta) {
		this.jugadorTurnoActual.jugarCarta(carta);
		this.jugadorTurnoActual = this.mesa.siguienteJugadorConTurno();
		
		//manera fea para zafarla!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
		//habria que hacer un evento para esto tmb pero nose como andan los eventos
		if (this.jugadorTurnoActual.getClass() == IA.class){
			this.jugadorTurnoActual.hacerJugarIA();
			this.jugadorTurnoActual = this.mesa.siguienteJugadorConTurno();
		}
		if (this.jugadorTurnoActual.getClass() == IA.class){
			this.jugadorTurnoActual.hacerJugarIA();
			this.jugadorTurnoActual = this.mesa.siguienteJugadorConTurno();
		} //dos veces a proposito..
		//explicacion: humano juega carta.. dsps va la maquina si llega a ganar la
		//maquina esa mano, tiraria de nuevo la maquina.. x esos esos dos ifs
	}
	
	public void irseAlMazo(){
		this.jugadorTurnoActual.irseAlMazo();
		this.jugadorTurnoActual = this.mesa.siguienteJugadorConTurno();
		
		//manera fea para zafarla!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
		//habria que hacer un evento para esto tmb pero nose como andan los eventos
		if (this.jugadorTurnoActual.getClass() == IA.class){
			this.jugadorTurnoActual.hacerJugarIA();
			this.jugadorTurnoActual = this.mesa.siguienteJugadorConTurno();
		}
	}
	
	public void quiero(){
		this.jugadorTurnoActual.quiero();
		this.jugadorTurnoActual = this.mesa.siguienteJugadorConTurno();
	
		//manera fea para zafarla!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
		//habria que hacer un evento para esto tmb pero nose como andan los eventos
		if (this.jugadorTurnoActual.getClass() == IA.class){
			this.jugadorTurnoActual.hacerJugarIA();
			this.jugadorTurnoActual = this.mesa.siguienteJugadorConTurno();
		}
		
	}

	public void noQuiero(){
		this.jugadorTurnoActual.noQuiero();
		this.jugadorTurnoActual = this.mesa.siguienteJugadorConTurno();
	
		//manera fea para zafarla!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
		//habria que hacer un evento para esto tmb pero nose como andan los eventos
		if (this.jugadorTurnoActual.getClass() == IA.class){
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