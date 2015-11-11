package fiuba.algo3.tp2.modelo;

import org.junit.Assert;
import org.junit.Test;

public class SituacionesDeJuegoTest {

	@Test
	public void testInicializacionDeJuego() {
		//Implemento de esta manera xq no definimos bien todavia como la vamos a hacer..
		// Yo personalmente sacaria PartidaDeTrucoSimple y dejaria solo PartidaDeTruco
		// Igual que algoTruco.. podemos usar PartidaDeTruco de una xq cumple esa funcion de
		// encapsular todo. Podriamos cambiarle el nombre tmb..
		
		PartidaDeTrucoSimple partida = new PartidaDeTrucoSimple("eqA","eqB");
		
		partida.cargarJugadoresEnEquipoUno("pipi");
		partida.cargarJugadoresEnEquipoDos("elDiegote");
		
		partida.repartir();
		
		partida.jugarCartas();
		
		partida.anotarPuntos(); //es una flashada pero es para probar..
		
		Assert.assertEquals(1,partida.puntosEquipoDos());
	}

}
