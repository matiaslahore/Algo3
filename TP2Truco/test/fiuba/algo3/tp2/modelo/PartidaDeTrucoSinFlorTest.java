package fiuba.algo3.tp2.modelo;

import java.util.Arrays;

import org.junit.Test;

import fiuba.algo3.tp2.modeloDeCartas.AnchoDeBasto;
import fiuba.algo3.tp2.modeloDeCartas.AnchoDeCopa;
import fiuba.algo3.tp2.modeloDeCartas.AnchoDeOro;
import fiuba.algo3.tp2.modeloDeCartas.CuatroDeBasto;
import fiuba.algo3.tp2.modeloDeCartas.SieteDeCopa;
import fiuba.algo3.tp2.modeloDeCartas.SieteDeEspada;
import fiuba.algo3.tp2.modeloDeCartas.TipoDeCartas;
import fiuba.algo3.tp2.modeloJugador.Jugador;
import junit.framework.Assert;

public class PartidaDeTrucoSinFlorTest {

	public PartidaDeTrucoSinFlor partidaDeTruco;

	@Test
	public void partidaDeTrucoSinFlor(){
		
		partidaDeTruco = new PartidaDeTrucoSinFlor("equipoUno", "equipoDos");
		
		partidaDeTruco.cargarJugadoresEnEquipoUno("Nicolas");
		partidaDeTruco.cargarJugadoresEnEquipoDos("Matias");
		
		
		Jugador nicolas = partidaDeTruco.obtenerEquipo("equipoUno").obtenerJugador("Nicolas");
		Jugador matias = partidaDeTruco.obtenerEquipo("EquipoDos").obtenerJugador("Matias");
		
		nicolas.recibirCartas(new AnchoDeBasto(), new CuatroDeBasto(), new SieteDeEspada());
		matias.recibirCartas(new AnchoDeCopa(), new AnchoDeOro(), new SieteDeCopa());
		
		partidaDeTruco.iniciarRonda();
		
		nicolas.cantarEnvido();
		
		matias.quiero();
		
		Assert.assertEquals(2, partidaDeTruco.obtenerPuntajeDeEquipo("equipoUno"));
		Assert.assertEquals(0, partidaDeTruco.obtenerPuntajeDeEquipo("equipoDos"));
	}
	
	@Test
	public void partidaDeTrucoSinFlorDos(){
		
		partidaDeTruco = new PartidaDeTrucoSinFlor("equipoUno", "equipoDos");
		
		partidaDeTruco.cargarJugadoresEnEquipoUno("Nicolas");
		partidaDeTruco.cargarJugadoresEnEquipoDos("Matias");
		
		
		Jugador nicolas = partidaDeTruco.obtenerEquipo("equipoUno").obtenerJugador("Nicolas");
		Jugador matias = partidaDeTruco.obtenerEquipo("EquipoDos").obtenerJugador("Matias");
		
		nicolas.recibirCartas(new AnchoDeBasto(), new CuatroDeBasto(), new SieteDeEspada());
		matias.recibirCartas(new AnchoDeCopa(), new AnchoDeOro(), new SieteDeCopa());
		
		partidaDeTruco.iniciarRonda();
		
		nicolas.cantarTruco();
		
		matias.quiero();
		
		nicolas.jugarPrimera();
		
		matias.jugarTercera();
		
		nicolas.jugarSegunda();
		
		matias.jugarSegunda();
		
		Assert.assertEquals(2, partidaDeTruco.obtenerPuntajeDeEquipo("equipoUno"));
		Assert.assertEquals(0, partidaDeTruco.obtenerPuntajeDeEquipo("equipoDos"));
	}
	
	
}
