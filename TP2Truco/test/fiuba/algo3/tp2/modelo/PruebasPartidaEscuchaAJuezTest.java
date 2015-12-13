package fiuba.algo3.tp2.modelo;

import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import fiuba.algo3.tp2.modeloDeCartas.Carta;

public class PruebasPartidaEscuchaAJuezTest {

	
	public PartidaDeTrucoSinFlor partidaDeTruco;

	@Test
	public void partidaDeTrucoSinFlor2x2SeRepartoYLaCantidadDeCartasDeCadaJugadorSonCorrectas(){
		
		partidaDeTruco = new PartidaDeTrucoSinFlor("equipoUno", "equipoDos");
		
		partidaDeTruco.cargarJugadoresEnEquipoUno(Arrays.asList("Nicolas"));
		partidaDeTruco.cargarJugadoresEnEquipoDos(Arrays.asList("Matias"));
		
		partidaDeTruco.iniciar();
		
		//RONDA 1
		List<Carta> listaCartas = partidaDeTruco.obtenerCartasDelJugadorConTurno();
		Assert.assertEquals(3, listaCartas.size());
		partidaDeTruco.jugarCarta(listaCartas.get(0));
		
		listaCartas = partidaDeTruco.obtenerCartasDelJugadorConTurno();
		Assert.assertEquals(3, listaCartas.size());
		partidaDeTruco.jugarCarta(listaCartas.get(0));
		
		//RONDA 2
		listaCartas = partidaDeTruco.obtenerCartasDelJugadorConTurno();
		Assert.assertEquals(2, listaCartas.size());
		partidaDeTruco.jugarCarta(listaCartas.get(0));
		
		listaCartas = partidaDeTruco.obtenerCartasDelJugadorConTurno();
		Assert.assertEquals(2, listaCartas.size());
		partidaDeTruco.jugarCarta(listaCartas.get(0));
	}
}
