package fiuba.algo3.tp2.modelo;

import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import fiuba.algo3.tp2.excepciones.CantoInvalidoException;
import fiuba.algo3.tp2.excepciones.EquipoQueCantaNoPuedeVolverACantarException;
import fiuba.algo3.tp2.excepciones.SeEstaJugandoSinFlorException;
import fiuba.algo3.tp2.modeloDeCartas.Carta;

public class PruebasPartidaDeTrucoSinFlorTest {

	public PartidaDeTrucoSinFlor partidaDeTruco;

	@Test
	public void partidaDeTrucoSinFlor2x2SeRepartioBienYJuegaBien(){
		
		partidaDeTruco = new PartidaDeTrucoSinFlor("equipoUno", "equipoDos");
		
		partidaDeTruco.cargarJugadoresEnEquipoUno(Arrays.asList("Nicolas"));
		partidaDeTruco.cargarJugadoresEnEquipoDos(Arrays.asList("Matias"));
		
		partidaDeTruco.iniciar();
		
		//RONDA 1
		List<Carta> listaCartas = partidaDeTruco.obtenerCartasDelJugadorConTurno();
		Assert.assertEquals(3, listaCartas.size());
		partidaDeTruco.jugarCarta(listaCartas.get(0));
		
		listaCartas = partidaDeTruco.obtenerCartasDelJugadorConTurno();
		Assert.assertEquals(3, listaCartas.size());
		partidaDeTruco.jugarCarta(listaCartas.get(0));
		
		//RONDA 2
		listaCartas = partidaDeTruco.obtenerCartasDelJugadorConTurno();
		Assert.assertEquals(2, listaCartas.size());
		partidaDeTruco.jugarCarta(listaCartas.get(0));
		
		listaCartas = partidaDeTruco.obtenerCartasDelJugadorConTurno();
		Assert.assertEquals(2, listaCartas.size());
		partidaDeTruco.jugarCarta(listaCartas.get(0));
	}
	
	@Test
	public void partidaDeTrucoSinFlor2x2CantaEnvido(){
		
		partidaDeTruco = new PartidaDeTrucoSinFlor("equipoUno", "equipoDos");
		
		partidaDeTruco.cargarJugadoresEnEquipoUno(Arrays.asList("Nicolas"));
		partidaDeTruco.cargarJugadoresEnEquipoDos(Arrays.asList("Matias"));
		
		partidaDeTruco.iniciar();
		
		//RONDA 1
		partidaDeTruco.cantarEnvido();
		partidaDeTruco.cantarEnvido();
		partidaDeTruco.cantarRealEnvido();
		partidaDeTruco.noQuiero();
		
		Assert.assertEquals(5, partidaDeTruco.obtenerPuntajeDeEquipoUno());
	}
	
	@Test
	public void partidaDeTrucoSinFlorTrucoNoQuiereSeEmpiezaDeNuevo(){
		
		partidaDeTruco = new PartidaDeTrucoSinFlor("equipoUno", "equipoDos");
		
		partidaDeTruco.cargarJugadoresEnEquipoUno(Arrays.asList("Nicolas"));
		partidaDeTruco.cargarJugadoresEnEquipoDos(Arrays.asList("Matias"));
		
		partidaDeTruco.iniciar();
		
		//RONDA 1
		List<Carta> listaCartas = partidaDeTruco.obtenerCartasDelJugadorConTurno();
		Assert.assertEquals(3, listaCartas.size());
		partidaDeTruco.jugarCarta(listaCartas.get(0));
		
		partidaDeTruco.cantarTruco();//2
		partidaDeTruco.cantarQuieroReTruco();//1
		partidaDeTruco.cantarQuieroValeCuatro();//2
		partidaDeTruco.noQuiero();//1
		Assert.assertEquals(3, partidaDeTruco.obtenerPuntajeDeEquipoDos());
		
		listaCartas = partidaDeTruco.obtenerCartasDelJugadorConTurno();
		Assert.assertEquals(3, listaCartas.size());
		//tiene 3 cartas xq se repartio de nuevo
	}
	
	@Test
	public void partidaDeTrucoSinFlorSeVaAlMazoj1(){
		
		partidaDeTruco = new PartidaDeTrucoSinFlor("equipoUno", "equipoDos");
		
		partidaDeTruco.cargarJugadoresEnEquipoUno(Arrays.asList("Nicolas"));
		partidaDeTruco.cargarJugadoresEnEquipoDos(Arrays.asList("Matias"));
		
		partidaDeTruco.iniciar();
		
		//RONDA 1
		partidaDeTruco.irseAlMazo();
		
		Assert.assertEquals(1, partidaDeTruco.obtenerPuntajeDeEquipoDos());
		
	}
	
	@Test(expected = SeEstaJugandoSinFlorException.class)
	public void partidaDeTrucoSinFlorSeCantaFlorProduceException(){
		
		partidaDeTruco = new PartidaDeTrucoSinFlor("equipoUno", "equipoDos");
		
		partidaDeTruco.cargarJugadoresEnEquipoUno(Arrays.asList("Nicolas"));
		partidaDeTruco.cargarJugadoresEnEquipoDos(Arrays.asList("Matias"));
		
		partidaDeTruco.iniciar();
		
		partidaDeTruco.cantarFlor();
	}
	
	@Test(expected = CantoInvalidoException.class)
	public void seCantaTrucoTrucoProduceException(){
		partidaDeTruco = new PartidaDeTrucoSinFlor("equipoUno", "equipoDos");
		partidaDeTruco.cargarJugadoresEnEquipoUno(Arrays.asList("Nicolas"));
		partidaDeTruco.cargarJugadoresEnEquipoDos(Arrays.asList("Matias"));
		
		partidaDeTruco.iniciar();
		
		partidaDeTruco.cantarTruco();
		partidaDeTruco.cantarTruco();
	}

	@Test(expected = EquipoQueCantaNoPuedeVolverACantarException.class)
	public void seCantaTrucoSeQuiereSeCantaTrucoNuevamenteProduceException(){
		partidaDeTruco = new PartidaDeTrucoSinFlor("equipoUno", "equipoDos");
		partidaDeTruco.cargarJugadoresEnEquipoUno(Arrays.asList("Nicolas"));
		partidaDeTruco.cargarJugadoresEnEquipoDos(Arrays.asList("Matias"));
		
		partidaDeTruco.iniciar();
		
		partidaDeTruco.cantarTruco();
		partidaDeTruco.quiero();
		partidaDeTruco.cantarTruco();
	}
	
	@Test(expected = EquipoQueCantaNoPuedeVolverACantarException.class)
	public void seCantaTrucoSeQuiereSeCantaQRTelMismoQueCantoTrucoProduceException(){
		partidaDeTruco = new PartidaDeTrucoSinFlor("equipoUno", "equipoDos");
		partidaDeTruco.cargarJugadoresEnEquipoUno(Arrays.asList("Nicolas"));
		partidaDeTruco.cargarJugadoresEnEquipoDos(Arrays.asList("Matias"));
		
		partidaDeTruco.iniciar();
		
		partidaDeTruco.cantarTruco();
		partidaDeTruco.quiero();
		partidaDeTruco.cantarQuieroReTruco();
	}
	
}
