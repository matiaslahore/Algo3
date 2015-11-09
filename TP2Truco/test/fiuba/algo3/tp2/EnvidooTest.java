package fiuba.algo3.tp2;

import java.util.LinkedList;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import fiuba.algo3.tp2.modelo.Envido;
import fiuba.algo3.tp2.modelo.Equipo;

public class EnvidooTest {
	Envido envido;
	Equipo equipo1;
	Equipo equipo2;
	
	@Before
	public void Inicializar(){
		this.equipo1 = new Equipo();
		LinkedList<String> nombreJugadores1 = new LinkedList<String>();
		nombreJugadores1.add("Nico");
		this.equipo1.cargarJugadores(nombreJugadores1);
		this.equipo2 = new Equipo();
		LinkedList<String> nombreJugadores2 = new LinkedList<String>();
		nombreJugadores2.add("Matias");
		this.equipo1.cargarJugadores(nombreJugadores2);
	}
	
	@Test
	public void equipo1CantaEnvidoYEquipo2NoQuiereEntoncesEquipo1GanaUnPunto(){
		this.envido.cantarEnvido(this.equipo1);
		this.envido.noQuerer();
		Assert.assertEquals("Nico", this.envido.obtenerGanador().obtenerJugadores().get(0).obtenerNombre());
		Assert.assertEquals(1,this.envido.obtenerPuntajeGanador());
	}
	
	@Test
	public void equipo2CantaEnvidoYEquipo1NoQuiereEntoncesEquipo2GanaUnPunto(){
		this.envido.cantarEnvido(this.equipo2);
		this.envido.noQuerer();
		Assert.assertEquals("Matias", this.envido.obtenerGanador().obtenerJugadores().get(0).obtenerNombre());
		Assert.assertEquals(1,this.envido.obtenerPuntajeGanador());
	}
}
