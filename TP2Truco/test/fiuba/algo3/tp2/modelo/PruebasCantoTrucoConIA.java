package fiuba.algo3.tp2.modelo;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import fiuba.algo3.tp2.modeloDeCartas.Carta;
import fiuba.algo3.tp2.modeloDeCartas.CincoDeBasto;
import fiuba.algo3.tp2.modeloDeCartas.CincoDeCopa;
import fiuba.algo3.tp2.modeloDeCartas.CincoDeOro;
import fiuba.algo3.tp2.modeloDeCartas.CuatroDeBasto;
import fiuba.algo3.tp2.modeloDeCartas.CuatroDeCopa;
import fiuba.algo3.tp2.modeloDeCartas.CuatroDeOro;
import fiuba.algo3.tp2.modeloDeCartas.SeisDeBasto;
import fiuba.algo3.tp2.modeloDeCartas.SeisDeCopa;
import fiuba.algo3.tp2.modeloDeCartas.SeisDeOro;
import fiuba.algo3.tp2.modeloDeCartas.SieteDeBasto;
import fiuba.algo3.tp2.modeloJugador.IA;

public class PruebasCantoTrucoConIA {
	private Equipo equipoIA;
	private IA IA;
	private Mesa mesa;
	
	@Before
	public void inicializadorPruebasIA(){
		this.mesa = new Mesa();
		this.equipoIA = new Equipo("equipoIA",this.mesa);
		this.IA = new IA("jugadorIA",this.mesa,this.equipoIA);
	}
	
	@Test
	public void jugadorIAConCartasBajasNoPuedeCantarTruco(){
		List<Carta> cartas = new ArrayList<Carta>();
		cartas.add(new CuatroDeBasto());
		cartas.add(new CuatroDeOro());
		cartas.add(new CuatroDeCopa());
		this.IA.recibirCartas(cartas);
		Assert.assertFalse(this.IA.cantarTrucoIA());
	}
	
	@Test
	public void jugadorIAConCartasBajasNoPuedeCantarTruco2(){
		List<Carta> cartas = new ArrayList<Carta>();
		cartas.add(new CincoDeBasto());
		cartas.add(new CincoDeOro());
		cartas.add(new CincoDeCopa());
		this.IA.recibirCartas(cartas);
		Assert.assertFalse(this.IA.cantarTrucoIA());
	}
	
	@Test
	public void jugadorIAConCartasBajasNoPuedeCantarTruco3(){
		List<Carta> cartas = new ArrayList<Carta>();
		cartas.add(new SeisDeBasto());
		cartas.add(new SeisDeOro());
		cartas.add(new SeisDeCopa());
		this.IA.recibirCartas(cartas);
		Assert.assertFalse(this.IA.cantarTrucoIA());
	}
	
	@Test
	public void jugadorIAConCartasMayoresA2SesisYUnCincoAceptaElTruco(){
		List<Carta> cartas = new ArrayList<Carta>();
		cartas.add(new CincoDeBasto());
		cartas.add(new SeisDeOro());
		cartas.add(new SeisDeCopa());
		this.IA.recibirCartas(cartas);
		Assert.assertTrue(this.IA.quererTrucoIA());
	}
	
	@Test
	public void jugadorIAConCartasMayoresA2SesisYUnSieteFalsoCantaElTruco(){
		List<Carta> cartas = new ArrayList<Carta>();
		cartas.add(new SieteDeBasto());
		cartas.add(new SeisDeOro());
		cartas.add(new SeisDeCopa());
		this.IA.recibirCartas(cartas);
		Assert.assertTrue(this.IA.cantarTrucoIA());
	}

}
