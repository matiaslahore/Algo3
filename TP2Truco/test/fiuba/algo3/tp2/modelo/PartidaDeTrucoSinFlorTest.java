package fiuba.algo3.tp2.modelo;

import org.junit.Assert;
import org.junit.Test;

import fiuba.algo3.tp2.modeloDeCartas.AnchoDeBasto;
import fiuba.algo3.tp2.modeloDeCartas.AnchoDeCopa;
import fiuba.algo3.tp2.modeloDeCartas.AnchoDeOro;
import fiuba.algo3.tp2.modeloDeCartas.CuatroDeBasto;
import fiuba.algo3.tp2.modeloDeCartas.SieteDeCopa;
import fiuba.algo3.tp2.modeloDeCartas.SieteDeEspada;
import fiuba.algo3.tp2.modeloJugador.Jugador;

public class PartidaDeTrucoSinFlorTest {

	public PartidaDeTrucoSinFlor partidaDeTruco;

	@Test
	public void partidaDeTrucoSinFlor(){
		
		partidaDeTruco = new PartidaDeTrucoSinFlor("equipoUno", "equipoDos");
		
		partidaDeTruco.cargarJugadoresEnEquipoUno("Nicolas");
		partidaDeTruco.cargarJugadoresEnEquipoDos("Matias");
		
		partidaDeTruco.iniciarRonda();
		
		Jugador nicolas = partidaDeTruco.siguiente();
		nicolas.recibirCartas(new AnchoDeBasto(), new CuatroDeBasto(), new SieteDeEspada());
		Jugador matias = partidaDeTruco.siguiente();
		matias.recibirCartas(new AnchoDeCopa(), new AnchoDeOro(), new SieteDeCopa());
		
		nicolas = partidaDeTruco.siguiente();
		nicolas.cantarEnvido();
		matias = partidaDeTruco.siguiente();
		matias.quiero();
		
		Assert.assertEquals(0, partidaDeTruco.obtenerPuntajeDeEquipo("equipoUno"));
		Assert.assertEquals(2, partidaDeTruco.obtenerPuntajeDeEquipo("equipoDos"));
	}
	
	@Test
	public void partidaDeTrucoSinFlorDos(){
		
partidaDeTruco = new PartidaDeTrucoSinFlor("equipoUno", "equipoDos");
		
		partidaDeTruco.cargarJugadoresEnEquipoUno("Nicolas");
		partidaDeTruco.cargarJugadoresEnEquipoDos("Matias");
		
		partidaDeTruco.iniciarRonda();
		
		Jugador nicolas = partidaDeTruco.siguiente();
		nicolas.recibirCartas(new AnchoDeBasto(), new CuatroDeBasto(), new SieteDeEspada());
		Jugador matias = partidaDeTruco.siguiente();
		matias.recibirCartas(new AnchoDeCopa(), new AnchoDeOro(), new SieteDeCopa());
		
		nicolas = partidaDeTruco.siguiente();
		nicolas.cantarTruco();
		matias = partidaDeTruco.siguiente();
		matias.quiero();
		//r1
		nicolas = partidaDeTruco.siguiente();
		nicolas.jugarPrimera();
		matias = partidaDeTruco.siguiente();
		matias.jugarTercera();
		//r2
		nicolas = partidaDeTruco.siguiente();
		nicolas.jugarPrimera();
		matias = partidaDeTruco.siguiente();
		matias.jugarPrimera();
		//r3
		matias = partidaDeTruco.siguiente();
		matias.jugarPrimera();
		nicolas = partidaDeTruco.siguiente();
		nicolas.jugarPrimera();
		
		matias = partidaDeTruco.siguiente();
		
		Assert.assertEquals(2, partidaDeTruco.obtenerPuntajeDeEquipo("equipoUno"));
		Assert.assertEquals(0, partidaDeTruco.obtenerPuntajeDeEquipo("equipoDos"));
	}
	
	
}
