package fiuba.algo3.tp2.modelo;

import java.util.Arrays;
import java.util.List;

import fiuba.algo3.tp2.excepciones.SeEstaJugandoSinFlorException;
import fiuba.algo3.tp2.excepciones.YaEstaCargadoElEquipoUnoConJugadorIA;

public class PartidaDeTrucoSinFlorContraJugadorIA extends PartidaDeTruco {

	public PartidaDeTrucoSinFlorContraJugadorIA(String nombreEq1, String nombreEq2) {
		super(nombreEq1, nombreEq2);
		
		this.mesa.instanciarJuez(equipoUno,equipoDos);
		this.equipoUno.cargarJugadorIA("JugadorIA");
	}
	
	public void cargarJugadoresEnEquipoUno(List<String> nombreJugadores) {
		throw new YaEstaCargadoElEquipoUnoConJugadorIA();
	}
	
	public void cargarJugadoresEnEquipoDos(List<String> nombreJugadores) {
		this.equipoDos.cargarJugadores(nombreJugadores);
	}
	
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
