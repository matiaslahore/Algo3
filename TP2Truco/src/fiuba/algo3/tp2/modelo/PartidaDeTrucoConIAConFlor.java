package fiuba.algo3.tp2.modelo;

import fiuba.algo3.tp2.cantosPosibles.CantaronContraFlor;
import fiuba.algo3.tp2.cantosPosibles.CantaronContraFlorxResto;
import fiuba.algo3.tp2.cantosPosibles.CantaronFlor;

public class PartidaDeTrucoConIAConFlor extends PartidaDeTrucoConIA {

	public PartidaDeTrucoConIAConFlor(String nombreEq1, String nombreEq2) {
		super(nombreEq1, nombreEq2);
	}

	@Override
	public void cantarFlor() {		
		this.jugadorTurnoActual.cantarFlor();
		this.eventosIA.seCantoFlor();	
		this.jugadorTurnoActual = this.mesa.siguienteJugadorConTurno();
		this.jugadorTurnoActual.hacerJugarIA();
		this.jugadorTurnoActual = this.mesa.siguienteJugadorConTurno();
		//verificar una vez que ande todo, siempre va a entrar aca asi que habria que sacar el if
		if(this.jugadorTurnoActual.obtenerEquipo().obtenerNombre().equals(this.equipoUno.obtenerNombre())){
			this.jugadorTurnoActual.hacerJugarIA();
			this.jugadorTurnoActual = mesa.siguienteJugadorConTurno();
		}
	}

	@Override
	public void cantarContraFlor() {
		this.jugadorTurnoActual.cantarContraFlor();
		this.eventosIA.seCantoContraFlor();	
		this.jugadorTurnoActual = this.mesa.siguienteJugadorConTurno();
		this.jugadorTurnoActual.hacerJugarIA();
		this.jugadorTurnoActual = this.mesa.siguienteJugadorConTurno();
		//verificar una vez que ande todo, siempre va a entrar aca asi que habria que sacar el if
		if(this.jugadorTurnoActual.obtenerEquipo().obtenerNombre().equals(this.equipoUno.obtenerNombre())){
			this.jugadorTurnoActual.hacerJugarIA();
			this.jugadorTurnoActual = mesa.siguienteJugadorConTurno();
		}
	}

	@Override
	public void cantarContraFlorAJuego() {
		this.jugadorTurnoActual.cantarContraFlorAJuego();
		this.eventosIA.seCantoContraFlorAJuego();	
		this.jugadorTurnoActual = this.mesa.siguienteJugadorConTurno();
		this.jugadorTurnoActual.hacerJugarIA();
		this.jugadorTurnoActual = this.mesa.siguienteJugadorConTurno();
		//verificar una vez que ande todo, siempre va a entrar aca asi que habria que sacar el if
		if(this.jugadorTurnoActual.obtenerEquipo().obtenerNombre().equals(this.equipoUno.obtenerNombre())){
			this.jugadorTurnoActual.hacerJugarIA();
			this.jugadorTurnoActual = mesa.siguienteJugadorConTurno();
		}
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
