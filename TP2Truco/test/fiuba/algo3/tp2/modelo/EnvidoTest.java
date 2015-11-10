package fiuba.algo3.tp2.modelo;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class EnvidoTest {
	Envido envido;
	Equipo equipo1;
	Equipo equipo2;
	
	@Before
	public void Inicializar(){
		this.envido = new Envido();
		this.equipo1 = new Equipo();
		this.equipo2 = new Equipo();
	}
	
	@Test
	public void equipo1CantaEnvidoYEquipo2NoQuiereEntoncesEquipo1GanaUnPunto(){
		this.envido.cantarEnvido(this.equipo1);
		this.envido.noQuerer(this.equipo2);
		Assert.assertEquals(this.equipo1,this.envido.obtenerGanador());
		Assert.assertEquals(1,this.envido.obtenerPuntajeGanador());
	}
	
	@Test
	public void equipo2CantaEnvidoYEquipo1NoQuiereEntoncesEquipo2GanaUnPunto(){
		this.envido.cantarEnvido(this.equipo2);
		this.envido.noQuerer(this.equipo1);
		Assert.assertEquals(this.equipo2,this.envido.obtenerGanador());
		Assert.assertEquals(1,this.envido.obtenerPuntajeGanador());
	}
	
	@Test
	public void elEquipoQueCantaNoPuedeQuererElEnvido(){
		this.envido.cantarEnvido(this.equipo2);
		this.envido.querer(this.equipo2);
		Assert.assertNotEquals(this.equipo1,this.envido.obtenerGanador());
		Assert.assertEquals(0,this.envido.obtenerPuntajeGanador());
	}
	
	@Test
	public void elEquipoQueCantaNoPuedeNoQuererElEnvido(){
		this.envido.cantarEnvido(this.equipo2);
		this.envido.noQuerer(this.equipo2);
		Assert.assertNotEquals(this.equipo1,this.envido.obtenerGanador());
		Assert.assertEquals(0,this.envido.obtenerPuntajeGanador());
	}
	
}