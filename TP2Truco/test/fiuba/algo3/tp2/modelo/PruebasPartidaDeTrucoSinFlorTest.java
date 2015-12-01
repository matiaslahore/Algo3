package fiuba.algo3.tp2.modelo;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

import fiuba.algo3.tp2.modeloDeCartas.AnchoDeBasto;
import fiuba.algo3.tp2.modeloDeCartas.AnchoDeCopa;
import fiuba.algo3.tp2.modeloDeCartas.AnchoDeOro;
import fiuba.algo3.tp2.modeloDeCartas.Carta;
import fiuba.algo3.tp2.modeloDeCartas.CuatroDeBasto;
import fiuba.algo3.tp2.modeloDeCartas.SieteDeCopa;
import fiuba.algo3.tp2.modeloDeCartas.SieteDeEspada;
import fiuba.algo3.tp2.modeloJugador.Jugador;

public class PruebasPartidaDeTrucoSinFlorTest {

	public PartidaDeTrucoSinFlor partidaDeTruco;

	@Test
	public void partidaDeTrucoSinFlor(){
		
		partidaDeTruco = new PartidaDeTrucoSinFlor("equipoUno", "equipoDos");
		
		partidaDeTruco.cargarJugadoresEnEquipoUno("Nicolas");
		partidaDeTruco.cargarJugadoresEnEquipoDos("Matias");
		
		partidaDeTruco.iniciarRonda();
		
		Jugador nicolas = partidaDeTruco.siguiente();
		nicolas.recibirCartas(new ArrayList<Carta>(Arrays.asList(new AnchoDeBasto(), new CuatroDeBasto(), new SieteDeEspada())));
		Jugador matias = partidaDeTruco.siguiente();
		matias.recibirCartas(new ArrayList<Carta>(Arrays.asList(new AnchoDeCopa(), new AnchoDeOro(), new SieteDeCopa())));
		
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
		
		Carta anchoDeBasto = new AnchoDeBasto();
		Carta cuatroDeBasto = new CuatroDeBasto();
		Carta sieteDeEspada = new SieteDeEspada();
		
		nicolas.recibirCartas(new ArrayList<Carta>(Arrays.asList(anchoDeBasto, cuatroDeBasto, sieteDeEspada)));
		Jugador matias = partidaDeTruco.siguiente();
		
		Carta anchoDeCopa = new AnchoDeCopa();
		Carta anchoDeOro = new AnchoDeOro();
		Carta sieteDeCopa = new SieteDeCopa();
		
		matias.recibirCartas(new ArrayList<Carta>(Arrays.asList(anchoDeCopa, anchoDeOro, sieteDeCopa)));
		
		nicolas = partidaDeTruco.siguiente();
		nicolas.cantarTruco();
		matias = partidaDeTruco.siguiente();
		matias.quiero();
		//r1
		nicolas = partidaDeTruco.siguiente();
		nicolas.jugarCarta(anchoDeBasto);
		matias = partidaDeTruco.siguiente();
		matias.jugarCarta(sieteDeCopa);
		//r2
		nicolas = partidaDeTruco.siguiente();
		nicolas.jugarCarta(cuatroDeBasto);
		matias = partidaDeTruco.siguiente();
		matias.jugarCarta(anchoDeCopa);
		//r3
		matias = partidaDeTruco.siguiente();
		matias.jugarCarta(anchoDeOro);
		nicolas = partidaDeTruco.siguiente();
		nicolas.jugarCarta(sieteDeEspada);
		
		matias = partidaDeTruco.siguiente();
		
		Assert.assertEquals(2, partidaDeTruco.obtenerPuntajeDeEquipo("equipoUno"));
		Assert.assertEquals(0, partidaDeTruco.obtenerPuntajeDeEquipo("equipoDos"));
	}

}
