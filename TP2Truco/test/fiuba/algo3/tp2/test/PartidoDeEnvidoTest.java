package fiuba.algo3.tp2.test;

import org.junit.Test;

import fiuba.algo3.tp2.modelo.AlgoTruco;

public class PartidoDeEnvidoTest {
	AlgoTruco algoTruco;
	
	
	@Test
	public void crearEquiposYJugarEnvido(){
		this.algoTruco = new AlgoTruco(2,"Nico","Matias");
		this.algoTruco.cantarEnvido("Nico");
		this.algoTruco.quererEnvido("Matias");
		System.out.println(this.algoTruco.obtenerGanadorEnvido());
	}
}
