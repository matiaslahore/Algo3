package fiuba.algo3.tp2.test;

import org.junit.Test;

import fiuba.algo3.tp2.modelo.AlgoTruco;

public class CrearEquipos {
	AlgoTruco truco;
	
	
	public void Inicializar(){
		this.truco = new AlgoTruco();
	}
	
	@Test
	public void crearEquiposYValidarLosNombres(){
		this.truco = new AlgoTruco(2,"Nico","Matias");
		this.truco.envido.cantar("Nico");
		this.truco.envido.querer("Matias");
		println(this.truco.envido.obtenerGanador());
	}
}
