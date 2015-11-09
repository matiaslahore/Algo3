package fiuba.algo3.tp2.test;

import org.junit.Test;

import fiuba.algo3.tp2.modelo.AlgoTruco;
import fiuba.algo3.tp2.modelo.Mesa;

public class EnvidoTest {
	Envido envido;
	Equipo equipo1;
	Equipo equipo2;
	
	@Before
	public void Inicializar(){
		this.equipo1 = new Equipo(null,1);
		this.equipo2 = new Equipo(null,1);
	}
	
	@Test
	public void equipo1CantaEnvidoYEquipo2NoQuiereEntoncesEquipo1GanaUnPunto(){
		this.envido.cantarEnvido(this.equipo1);
		this.envido.noQuerer(this.equipo2);
		Assert.assertEquals(this.equipo1,System.out.println(this.envido.obtenerGanadorEnvido()));
		Assert.assertEquals(1,this.envido.obtenerPuntosGanados()));
	}
	
	@Test
	public void equipo2CantaEnvidoYEquipo1NoQuiereEntoncesEquipo2GanaUnPunto()
		this.envido.cantarEnvido(this.equipo2);
		this.envido.noQuerer(this.equipo1);
		Assert.assertEquals(this.equipo2,System.out.println(this.envido.obtenerGanadorEnvido()));
		Assert.assertEquals(1,this.envido.obtenerPuntosGanados()));
}
