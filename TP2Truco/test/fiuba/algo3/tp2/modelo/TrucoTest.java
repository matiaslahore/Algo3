package fiuba.algo3.tp2.modelo;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TrucoTest {
	Truco truco;
	Equipo equipo1;
	Equipo equipo2;
	Mesa mesa;
	
	@Before
	public void Inicializar(){
		this.mesa = new Mesa();
		this.truco = new Truco();
		this.equipo1 = new Equipo("Nico",mesa);
		this.equipo2 = new Equipo("Tute",mesa);
	}
	
	@Test
	public void equipo1CantaTrucoYEquipo2NoQuiereEntoncesEquipo1GanaUnPunto(){
		this.truco.cantarTruco(this.equipo1);
		this.truco.noQuerer(this.equipo2);
		Assert.assertEquals(this.equipo1.obtenerNombre(),this.truco.obtenerGanador().obtenerNombre());
		Assert.assertEquals(1,this.truco.obtenerPuntajeGanador());
	}
	/*
	@Test
	public void equipo2CantaEnvidoYEquipo1NoQuiereEntoncesEquipo2GanaUnPunto(){
		this.truco.cantarTruco(this.equipo2);
		this.truco.noQuerer(this.equipo1);
		Assert.assertEquals(this.equipo2.obtenerNombre(),this.truco.obtenerGanador().obtenerNombre());
		Assert.assertEquals(1,this.truco.obtenerPuntajeGanador());
	}
	
	@Test
	public void elEquipoQueCantaNoPuedeQuererElEnvido(){
		this.truco.cantarTruco(this.equipo2);
		this.truco.querer(this.equipo2);
		Assert.assertEquals(null,this.truco.obtenerGanador());
		Assert.assertEquals(0,this.truco.obtenerPuntajeGanador());
	}
	
	@Test
	public void elEquipoQueCantaNoPuedeNoQuererElEnvido(){
		this.truco.cantarTruco(this.equipo2);
		this.truco.noQuerer(this.equipo2);
		Assert.assertEquals(null,this.truco.obtenerGanador());
		Assert.assertEquals(0,this.truco.obtenerPuntajeGanador());
	}
	*/
}
