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
		//es dificil probar esto xq nose como reacciona la ia.. aveces canta envido
		//aveces truco, aveces tira una carta.. hay que hacerlo desde abajo
		//pero pierdo la posibilidad de escuchar los eventos
		
		//DE ACA NO SE PUEDE TESTEAR NADA..
	
	}
}
