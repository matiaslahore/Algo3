package fiuba.algo3.tp2.modelo;

import java.util.LinkedList;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class RepartirTest {
	
	Mesa mesa;
	Jugador jugador;
	
	@Before
	public void Inicializar(){
		this.mesa = new Mesa(new Equipo());
		this.jugador = new Jugador("pepito", this.mesa);
	}
	
	@Test
	public void jugadorRecibeCartas(){
		jugador.recibirCartas(new Carta(new Copa(),6), new Carta(new Copa(),1) , new Carta(new Espada(),5));
		Assert.assertEquals("'6 de Copa' '1 de Copa' '5 de Espada' ",jugador.verCartasEnManoComoString());
	}
	
	@Test
	public void jugadorRecibe3CartasAleatorias(){
		jugador.recibirCartas(mesa.repartirCarta(),mesa.repartirCarta(),mesa.repartirCarta());
		Assert.assertEquals(3,jugador.cantidadDeCartas());
	}
	
	@Test
	public void repartoAlEquipo(){
		Equipo eq = new Equipo("SL",mesa);
		LinkedList<String> lista = new LinkedList<String>();
		lista.add("pipi");
		lista.add("bufa");
		lista.add("torri");
		
		eq.cargarJugadores(lista);
		eq.recibirCartas();
		
		Jugador player = eq.obtenerJugador("pipi");
		Assert.assertEquals(3,player.cantidadDeCartas());
		player = eq.obtenerJugador("bufa");
		Assert.assertEquals(3,player.cantidadDeCartas());
		player = eq.obtenerJugador("torri");
		Assert.assertEquals(3,player.cantidadDeCartas());
	}
	
}
