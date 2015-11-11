package fiuba.algo3.tp2.modelo;

import org.junit.Assert;
import org.junit.Test;

public class SituacionesDeJuegoTest {

	/*@Test
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
		
		//Assert.assertEquals(1,partida.puntosEquipoDos());
	}
	
	@Test
	public void testGanaJugadorConAncho() {
		Jugador j1 = new Jugador("Diegote");
		Jugador j2 = new Jugador("pepe");
		
		j1.recibirCartas(new Carta(new Espada(),1), new Carta(new Espada(),3), new Carta(new Espada(),2));
		j2.recibirCartas(new Carta(new Basto(),1), new Carta(new Basto(),4), new Carta(new Basto(),5));
		
		Carta cJ1 = j1.jugarPrimera();
		Carta cJ2 = j2.jugarPrimera();
		
		Assert.assertFalse(cJ1.esMenorQue(cJ2));
		Assert.assertEquals(2,j1.cantidadDeCartas());
		Assert.assertEquals(2,j2.cantidadDeCartas());
	}*/
	
	@Test
	public void testPartida1() {
		PartidaDeTrucoSimple partida = new PartidaDeTrucoSimple("Equipo1","Equipo2");
		
		partida.cargarJugadoresEnEquipoUno("J1");
		partida.cargarJugadoresEnEquipoDos("J2");
		
		partida.repartir();
		
		partida.jugarCartas();
		partida.jugarCartas();
		partida.jugarCartas();
		
		
	}
	
	public void pruebaSimulacionDePartidaDeTrucoSimpleUnoPorUno(){
		
		PartidaDeTruco partidaDeTruco = new PartidaDeTrucoSimple("EquipoUno", "EquipoDos");
		
		partidaDeTruco.cargarJugadoresEnEquipoUno("pipi");
		partidaDeTruco.cargarJugadoresEnEquipoDos("elDiegote");

		partidaDeTruco.asignarQuienReparte();
		
		
	}

}
