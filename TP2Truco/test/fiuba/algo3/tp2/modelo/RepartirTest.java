package fiuba.algo3.tp2.modelo;

import java.util.LinkedList;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import fiuba.algo3.tp2.modeloDeCartas.*;
import modeloJugador.Jugador;

public class RepartirTest {
	
	Mesa mesa;
	Jugador jugador;
	
	@Before
	public void Inicializar(){
		this.mesa = new Mesa("EquipoUno","EquipoDos");
		this.jugador = new Jugador("pepito", this.mesa);
	}
	
	@Test
	public void jugadorRecibeCartas(){
		jugador.recibirCartas(new SeisDeCopa(), new AnchoDeCopa(), new CincoDeEspada());
		Assert.assertEquals("'6 de Copa' '1 de Copa' '5 de Espada' ",jugador.verCartasEnManoComoString());
	}
	
	@Test
	public void repartoAlEquipo(){
		Equipo eq = new Equipo("Futbol",mesa);
		eq.cargarJugadores("pipi");
		eq.cargarJugadores("Milito");
		
		eq.cargarJugadores("Tevez");
		eq.recibirCartas();
		
		Jugador player = eq.obtenerJugador("pipi");
		Assert.assertEquals(3,player.cantidadDeCartas());
		player = eq.obtenerJugador("Milito");
		Assert.assertEquals(3,player.cantidadDeCartas());
		player = eq.obtenerJugador("Tevez");
		Assert.assertEquals(3,player.cantidadDeCartas());
	}
	
}
