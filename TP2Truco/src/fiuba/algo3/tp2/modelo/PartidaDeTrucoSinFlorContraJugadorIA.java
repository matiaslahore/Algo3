package fiuba.algo3.tp2.modelo;

import java.util.List;

import fiuba.algo3.tp2.excepciones.SeEstaJugandoSinFlorException;
import fiuba.algo3.tp2.excepciones.YaEstaCargadoElEquipoUnoConJugadorIA;

public class PartidaDeTrucoSinFlorContraJugadorIA extends PartidaDeTruco{
	EventosIA eventosIA;
	
	public PartidaDeTrucoSinFlorContraJugadorIA(String nombreEq1, String nombreEq2) {
		super(nombreEq1, nombreEq2);
		
		this.mesa.instanciarJuez(equipoUno,equipoDos);
		this.equipoUno.cargarJugadorIA("JugadorIA");
		this.eventosIA = new EventosIA();
		this.eventosIA.addListener((Oyente) equipoUno.obtenerJugadores().get(0));
	}
	
	public void cargarJugadoresEnEquipoUno(List<String> nombreJugadores) {
		throw new YaEstaCargadoElEquipoUnoConJugadorIA();
	}
	
	public void cargarJugadoresEnEquipoDos(List<String> nombreJugadores) {
		this.equipoDos.cargarJugadores(nombreJugadores);
	}
	
	@Override
	public void cantarTruco() {
		this.jugadorTurnoActual.cantarTruco();
		this.jugadorTurnoActual = this.mesa.siguienteJugadorConTurno();
		this.eventosIA.seCantoTruco();
		this.mesa.siguienteJugadorConTurno();
	}
/*
	@Override
	public void cantarQuieroReTruco() {
		this.jugadorTurnoActual.cantarQuieroReTruco();
		this.jugadorTurnoActual = this.mesa.siguienteJugadorConTurno();
	}

	@Override
	public void cantarQuieroValeCuatro() {
		this.jugadorTurnoActual.cantarQuieroValeCuatro();
		this.jugadorTurnoActual = this.mesa.siguienteJugadorConTurno();
	}

	@Override
	public void cantarEnvido() {
		this.jugadorTurnoActual.cantarEnvido();
		this.jugadorTurnoActual = this.mesa.siguienteJugadorConTurno();
	}

	@Override
	public void cantarRealEnvido() {
		this.jugadorTurnoActual.cantarRealEnvido();
		this.jugadorTurnoActual = this.mesa.siguienteJugadorConTurno();
	}

	@Override
	public void cantarFaltaEnvido() {
		this.jugadorTurnoActual.cantarFaltaEnvido();
		this.jugadorTurnoActual = this.mesa.siguienteJugadorConTurno();
	}
	*/
	
	@Override
	public void cantarFlor() {
		throw new SeEstaJugandoSinFlorException();
	}

	@Override
	public void cantarContraFlor() {
		throw new SeEstaJugandoSinFlorException();		
	}

	@Override
	public void cantarContraFlorAJuego() {
		throw new SeEstaJugandoSinFlorException();
	}
	
}
