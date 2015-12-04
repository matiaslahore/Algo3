package fiuba.algo3.tp2.modelo;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

public class PruebasPartidaDeTrucoSinFlorContraJugadorIATest {
	
	public PartidaDeTrucoSinFlorContraJugadorIA partidaDeTruco;
	
	@Test
	public void PruebaPartidaDeTrucoContraIA(){
		
		partidaDeTruco = new PartidaDeTrucoSinFlorContraJugadorIA("equipoUno", "equipoDos");
		
		partidaDeTruco.cargarJugadoresEnEquipoDos(Arrays.asList("Nicolas"));
		
		partidaDeTruco.iniciar();
		
		partidaDeTruco.cantarEnvido();
		
		
	}
}
