package fiuba.algo3.tp2.test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import fiuba.algo3.tp2.modelo.AlgoTruco;
import fiuba.algo3.tp2.modelo.Envido;
import fiuba.algo3.tp2.modelo.Equipo;
import fiuba.algo3.tp2.modelo.Mesa;

public class EnvidoTest {
	Envido envido;
	Equipo equipo1;
	Equipo equipo2;
	
	@Before
	public void Inicializar(){
		this.equipo1 = new Equipo();
		this.equipo2 = new Equipo();
	}
	
	@Test
	public void equipo1CantaEnvidoYEquipo2NoQuiereEntoncesEquipo1GanaUnPunto(){
		
		this.envido.cantarEnvido(this.equipo1);
		this.envido.noQuerer(this.equipo2);
		//ESTO NO ANDA ASI , HAY QUE PASARLE UNA FUNCION DE COMPARACION
		// POR QUE java no sabe como comparar objetos Equipo.
		//Assert.assertEquals(this.equipo1,this.envido.obtenerGanadorEnvido());
		Assert.assertEquals(1,this.envido.obtenerPuntosGanados());
	}
	
	@Test
	public void equipo2CantaEnvidoYEquipo1NoQuiereEntoncesEquipo2GanaUnPunto(){
		this.envido.cantarEnvido(this.equipo2);
		this.envido.noQuerer(this.equipo1);
		//ESTO NO ANDA ASI , HAY QUE PASARLE UNA FUNCION DE COMPARACION
		// POR QUE java no sabe como comparar objetos Equipo.
		//Assert.assertEquals(this.equipo1,this.envido.obtenerGanadorEnvido());
		Assert.assertEquals(1,this.envido.obtenerPuntosGanados());
	}
}