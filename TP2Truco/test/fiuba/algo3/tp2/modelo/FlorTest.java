package fiuba.algo3.tp2.modelo;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class FlorTest {
	Flor flor;
	Equipo equipo1;
	Equipo equipo2;
	Mesa mesa;
	
	@Before
	public void Inicializar(){
		this.mesa = new Mesa("Pablo","Tute");
		this.flor = new Flor();
		this.equipo1 = new Equipo("Pablo",mesa);
		this.equipo2 = new Equipo("Tute",mesa);
	}
	
	@Test
	public void equipo1CantaFlorYEquipo2NoQuiereEntoncesEquipo1GanaTresPuntos(){
		this.flor.cantarFlor(this.equipo1);
		this.flor.noQuerer(this.equipo2);
		Assert.assertEquals(this.equipo1.obtenerNombre(),this.flor.obtenerGanador().obtenerNombre());
		Assert.assertEquals(3,this.flor.obtenerPuntajeGanador());
	}
	
	@Test
	public void equipo2CantaFlorYEquipo1NoQuiereEntoncesEquipo2GanaTresPuntos(){
		this.flor.cantarFlor(this.equipo2);
		this.flor.noQuerer(this.equipo1);
		Assert.assertEquals(this.equipo2.obtenerNombre(),this.flor.obtenerGanador().obtenerNombre());
		Assert.assertEquals(3,this.flor.obtenerPuntajeGanador());
	}
	
	@Test
	public void elEquipo1CantaFlorElEquipo2CantaContraFlorElEquipo1NoQuiereEntoncesElEquipo2Obitene4Puntos(){
		this.flor.cantarFlor(this.equipo1);
		this.flor.cantarFlor(this.equipo2);
		this.flor.noQuerer(this.equipo1);
		Assert.assertEquals(this.equipo2.obtenerNombre(),this.flor.obtenerGanador().obtenerNombre());
		Assert.assertEquals(4,this.flor.obtenerPuntajeGanador());
	}
	
	@Test
	public void elEquipoQueCantaNoPuedeNoQuererLaFlor(){
		this.flor.cantarFlor(this.equipo2);
		this.flor.noQuerer(this.equipo2);
		Assert.assertEquals(null,this.flor.obtenerGanador());
		Assert.assertEquals(0,this.flor.obtenerPuntajeGanador());
	}
	
	@Test
	public void elEquipoQueCantaNoPuedeQuererLaFlor(){
		this.flor.cantarFlor(this.equipo2);
		this.flor.querer(this.equipo2);
		Assert.assertEquals(null,this.flor.obtenerGanador());
		Assert.assertEquals(0,this.flor.obtenerPuntajeGanador());
	}
	
}
