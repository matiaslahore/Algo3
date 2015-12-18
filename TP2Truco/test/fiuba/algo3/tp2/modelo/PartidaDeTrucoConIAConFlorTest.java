package fiuba.algo3.tp2.modelo;

import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import fiuba.algo3.tp2.modeloDeCartas.Carta;

public class PartidaDeTrucoConIAConFlorTest {

	public PartidaDeTrucoConIAConFlor partidaDeTruco;

	@Test
	public void probandoQueElJugadorCanteFlorYLaIAResponda(){
		
		partidaDeTruco = new PartidaDeTrucoConIAConFlor("equipoUno", "equipoDos");
		
		partidaDeTruco.cargarJugadoresEnEquipoDos(Arrays.asList("Matias"));
		
		partidaDeTruco.iniciar();
		
		while(partidaDeTruco.mesa.puntosEquipo(partidaDeTruco.jugadorTurnoActual.obtenerEquipo()) < 25){
			
			//RONDA 1
			try{
				partidaDeTruco.cantarFlor();
			}catch(RuntimeException e){
				partidaDeTruco.irseAlMazo();
			}
		}
	}
	
	
}
