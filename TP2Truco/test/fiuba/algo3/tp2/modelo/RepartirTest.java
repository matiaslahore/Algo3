package fiuba.algo3.tp2.modelo;

import java.util.LinkedList;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import fiuba.algo3.tp2.modeloDeCartas.*;
import fiuba.algo3.tp2.modeloJugador.Jugador;

public class RepartirTest {
	
	Mesa mesa;
	Jugador jugador;
	
	@Before
	public void Inicializar(){
		this.mesa = new Mesa("EquipoUno","EquipoDos");
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
