package fiuba.algo3.tp2.visualizador;

import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import fiuba.algo3.tp2.cantosPosibles.CanteFlor;
import fiuba.algo3.tp2.modelo.PartidaDeTrucoConFlor;
import fiuba.algo3.tp2.modelo.PartidaDeTrucoSinFlor;
import fiuba.algo3.tp2.modeloDeCartas.Carta;

public class CantosFlorTest {

	public PartidaDeTrucoConFlor partidaDeTruco;

	@Test
	public void partidaDeTrucoSinFlor2x2SeRepartoYLaCantidadDeCartasDeCadaJugadorSonCorrectas(){
		
		partidaDeTruco = new PartidaDeTrucoConFlor("equipoUno", "equipoDos");
		
		partidaDeTruco.cargarJugadoresEnEquipoUno(Arrays.asList("Nicolas"));
		partidaDeTruco.cargarJugadoresEnEquipoDos(Arrays.asList("Matias"));
		
		partidaDeTruco.iniciar();
		while((partidaDeTruco.obtenerPuntajeDeEquipoUno() < 29) && (partidaDeTruco.obtenerPuntajeDeEquipoDos() < 29)){
			//RONDA 1
			//Canto flor Nicolas
			try{
				partidaDeTruco.cantarFlor();
			}catch(RuntimeException e){
				List<Carta> listaCartas = partidaDeTruco.obtenerCartasDelJugadorConTurno();
				Assert.assertEquals(3, listaCartas.size());
				partidaDeTruco.jugarCarta(listaCartas.get(0));
			}
			//Canto flor Matias
			try{
				partidaDeTruco.cantarFlor();
			}
			catch(RuntimeException e){
				partidaDeTruco.irseAlMazo();
			}
		}
	}
}

