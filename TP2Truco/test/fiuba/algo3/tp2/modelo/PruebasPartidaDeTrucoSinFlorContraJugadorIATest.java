package fiuba.algo3.tp2.modelo;

import java.util.Arrays;

import org.junit.Test;

public class PruebasPartidaDeTrucoSinFlorContraJugadorIATest {
	
	public PartidaDeTrucoConIA partidaDeTruco;
	
	@Test
	public void PruebaPartidaDeTrucoContraIA(){
		
		partidaDeTruco = new PartidaDeTrucoConIASinFlor("equipoUno", "equipoDos");
		
		partidaDeTruco.cargarJugadoresEnEquipoDos(Arrays.asList("Nicolas"));
		
		partidaDeTruco.iniciar();
		try{
			partidaDeTruco.quiero();
		}catch(RuntimeException e){}
		try{
			partidaDeTruco.cantarTruco();
		}catch(RuntimeException e){
			partidaDeTruco.quiero();
		}
	
	}
}
