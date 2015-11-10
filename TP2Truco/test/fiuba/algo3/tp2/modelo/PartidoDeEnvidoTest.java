package fiuba.algo3.tp2.modelo;

import org.junit.Test;

import fiuba.algo3.tp2.modelo.AlgoTruco;

public class PartidoDeEnvidoTest {
	
	AlgoTruco algoTruco;
	 //prueba yoooooo haber esta mierda
	@Test
	public void crearEquiposYJugarEnvido(){
		
		this.algoTruco = new AlgoTruco();
		
		algoTruco.nuevaPartidaDeTrucoUnoContraUno("Nico", "Matias");
		
		this.algoTruco.cantarEnvido("Nico");
		this.algoTruco.quererEnvido("Matias");
		
		System.out.println(this.algoTruco.obtenerGanadorEnvido());
	}
}
