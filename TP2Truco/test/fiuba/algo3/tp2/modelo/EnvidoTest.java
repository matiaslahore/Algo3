package fiuba.algo3.tp2.modelo;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import fiuba.algo3.tp2.modeloDeCartas.AnchoDeBasto;
import fiuba.algo3.tp2.modeloDeCartas.SeisDeBasto;
import fiuba.algo3.tp2.modeloDeCartas.SieteDeBasto;
import fiuba.algo3.tp2.modeloJugador.Jugador;

public class EnvidoTest {
	Envido envido;
	Equipo equipo1;
	Equipo equipo2;
	Mesa mesa;
	
	@Before
	public void Inicializar(){
		this.mesa = new Mesa("EquipoNico", "EquipoTute");
		this.envido = new Envido();
		this.equipo1 = new Equipo("EquipoNico",mesa);
		this.equipo1.cargarJugadores("Nico");
		this.equipo2 = new Equipo("EquipoTute",mesa);
		this.equipo2.cargarJugadores("Tute");
	}
	
	@Test
	public void equipo1CantaEnvidoYEquipo2NoQuiereEntoncesEquipo1GanaUnPunto(){
		this.envido.cantarEnvido(this.equipo1.obtenerJugadores().get(0));
		this.envido.noQuerer(this.equipo2.obtenerJugadores().get(0));
		Assert.assertEquals(this.equipo1.obtenerNombre(),this.envido.obtenerGanador());
		Assert.assertEquals(1,this.envido.obtenerPuntajeGanador());
	}
	
	@Test
	public void equipo2CantaEnvidoYEquipo1NoQuiereEntoncesEquipo2GanaUnPunto(){
		this.envido.cantarEnvido(this.equipo2.obtenerJugadores().get(0));
		this.envido.noQuerer(this.equipo1.obtenerJugadores().get(0));
		Assert.assertEquals(this.equipo2.obtenerNombre(),this.envido.obtenerGanador());
		Assert.assertEquals(1,this.envido.obtenerPuntajeGanador());
	}
	
	@Test
	public void elEquipoQueCantaNoPuedeQuererElEnvido(){
		this.envido.cantarEnvido(this.equipo2.obtenerJugadores().get(0));
		this.envido.querer(this.equipo2.obtenerJugadores().get(0));
		Assert.assertEquals("",this.envido.obtenerGanador());
		Assert.assertEquals(0,this.envido.obtenerPuntajeGanador());
	}
	
	@Test
	public void elEquipoQueCantaNoPuedeNoQuererElEnvido(){
		this.envido.cantarEnvido(this.equipo2.obtenerJugadores().get(0));
		this.envido.noQuerer(this.equipo2.obtenerJugadores().get(0));
		Assert.assertEquals("",this.envido.obtenerGanador());
		Assert.assertEquals(0,this.envido.obtenerPuntajeGanador());
	}
	
}