package fiuba.algo3.tp2.test;

import org.junit.Test;

import fiuba.algo3.tp2.modelo.AlgoTruco;

public class CrearEquipos {
	AlgoTruco algoTruco;
	
	
	public void Inicializar(){
		this.algoTruco = new AlgoTruco();
	}
	
	@Test
	public void crearEquiposYValidarLosNombres(){
		this.algoTruco = new AlgoTruco(2,"Nico","Matias");
		this.algoTruco.envido.cantar("Nico");
		this.algoTruco.envido.querer("Matias");
		println(this.algoTruco.envido.obtenerGanador());
	}
}
