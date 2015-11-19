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
		this.mesa = new Mesa("EquipoNico", "EquipoTute");
		this.truco = new Truco();
		this.equipo1 = new Equipo("EquipoNico",mesa);
		this.equipo1.cargarJugadores("Nico");
		this.equipo2 = new Equipo("EquipoTute",mesa);
		this.equipo2.cargarJugadores("Tute");
	}
	
	@Test
	public void equipo1CantaTrucoYEquipo2NoQuiereEntoncesEquipo1GanaUnPunto(){
		this.truco.cantarTruco(this.equipo1.obtenerJugadores().get(0));
		this.truco.noQuerer(this.equipo2.obtenerJugadores().get(0));
		Assert.assertEquals(this.equipo1.obtenerNombre(),this.truco.obtenerGanador());
		Assert.assertEquals(1,this.truco.obtenerPuntajeGanador());
	}
	
	@Test
	public void equipo2CantaTrucoYEquipo1NoQuiereEntoncesEquipo2GanaUnPunto(){
		this.truco.cantarTruco(this.equipo2.obtenerJugadores().get(0));
		this.truco.noQuerer(this.equipo1.obtenerJugadores().get(0));
		Assert.assertEquals(this.equipo2.obtenerNombre(),this.truco.obtenerGanador());
		Assert.assertEquals(1,this.truco.obtenerPuntajeGanador());
	}
	
	@Test
	public void elEquipoQueCantaNoPuedeQuererElTruco(){
		this.truco.cantarTruco(this.equipo2.obtenerJugadores().get(0));
		this.truco.querer(this.equipo2.obtenerJugadores().get(0));
		Assert.assertEquals("",this.truco.obtenerGanador());
		Assert.assertEquals(1,this.truco.obtenerPuntajeGanador());
	}
	
	@Test
	public void elEquipoQueCantaNoPuedeNoQuererElTruco(){
		this.truco.cantarTruco(this.equipo2.obtenerJugadores().get(0));
		this.truco.noQuerer(this.equipo2.obtenerJugadores().get(0));
		Assert.assertEquals("",this.truco.obtenerGanador());
		Assert.assertEquals(1,this.truco.obtenerPuntajeGanador());
	}
	
}
