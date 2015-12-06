package fiuba.algo3.tp2.modelo;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import fiuba.algo3.tp2.modeloDeCartas.AnchoDeEspada;
import fiuba.algo3.tp2.modeloDeCartas.CaballoDeBasto;
import fiuba.algo3.tp2.modeloDeCartas.CaballoDeCopa;
import fiuba.algo3.tp2.modeloDeCartas.CaballoDeOro;
import fiuba.algo3.tp2.modeloDeCartas.Carta;
import fiuba.algo3.tp2.modeloDeCartas.CincoDeBasto;
import fiuba.algo3.tp2.modeloDeCartas.CincoDeCopa;
import fiuba.algo3.tp2.modeloDeCartas.CincoDeOro;
import fiuba.algo3.tp2.modeloDeCartas.CuatroDeBasto;
import fiuba.algo3.tp2.modeloDeCartas.CuatroDeCopa;
import fiuba.algo3.tp2.modeloDeCartas.CuatroDeOro;
import fiuba.algo3.tp2.modeloDeCartas.DosDeBasto;
import fiuba.algo3.tp2.modeloDeCartas.ReyDeBasto;
import fiuba.algo3.tp2.modeloDeCartas.ReyDeCopa;
import fiuba.algo3.tp2.modeloDeCartas.ReyDeOro;
import fiuba.algo3.tp2.modeloDeCartas.SeisDeBasto;
import fiuba.algo3.tp2.modeloDeCartas.SeisDeCopa;
import fiuba.algo3.tp2.modeloDeCartas.SeisDeOro;
import fiuba.algo3.tp2.modeloDeCartas.SieteDeBasto;
import fiuba.algo3.tp2.modeloDeCartas.SieteDeOro;
import fiuba.algo3.tp2.modeloDeCartas.TresDeBasto;
import fiuba.algo3.tp2.modeloDeCartas.TresDeCopa;
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
	public void jugadorIAConCartasMayoresOIgualesA2SesisYUnCincoAceptaElTruco(){
		List<Carta> cartas = new ArrayList<Carta>();
		cartas.add(new CincoDeBasto());
		cartas.add(new SeisDeOro());
		cartas.add(new SeisDeCopa());
		this.IA.recibirCartas(cartas);
		Assert.assertTrue(this.IA.quererTrucoIA());
	}
	
	@Test
	public void jugadorIAConCartasMayoresOIgualesA2SesisYUnSieteFalsoCantaElTruco(){
		List<Carta> cartas = new ArrayList<Carta>();
		cartas.add(new SieteDeBasto());
		cartas.add(new SeisDeOro());
		cartas.add(new SeisDeCopa());
		this.IA.recibirCartas(cartas);
		Assert.assertTrue(this.IA.cantarTrucoIA());
	}
	
	@Test
	public void jugadorIAConCartasMayoresOIgualesATresCaballosAceptaElReTruco(){
		List<Carta> cartas = new ArrayList<Carta>();
		cartas.add(new CaballoDeBasto());
		cartas.add(new CaballoDeOro());
		cartas.add(new CaballoDeCopa());
		this.IA.recibirCartas(cartas);
		Assert.assertTrue(this.IA.quererReTrucoIA());
	}
	
	@Test
	public void jugadorIAConCartasMayoresOIgualesATresReyesCantaElReTruco(){
		List<Carta> cartas = new ArrayList<Carta>();
		cartas.add(new ReyDeBasto());
		cartas.add(new ReyDeOro());
		cartas.add(new ReyDeCopa());
		this.IA.recibirCartas(cartas);
		Assert.assertTrue(this.IA.cantarReTrucoIA());
	}
	
	@Test
	public void jugadorIAConCartasMayoresOIgualesA2TresYUnSieteDeOroAceptaElValeCuatro(){
		List<Carta> cartas = new ArrayList<Carta>();
		cartas.add(new TresDeBasto());
		cartas.add(new SieteDeOro());
		cartas.add(new TresDeCopa());
		this.IA.recibirCartas(cartas);
		Assert.assertTrue(this.IA.quererValeCuatroIA());
	}
	
	@Test
	public void jugadorIAConCartasMayoresOIgualesAUnDosMasEl7DeOroMasElAnchoDeEspadaCantaElValeCuatro(){
		List<Carta> cartas = new ArrayList<Carta>();
		cartas.add(new DosDeBasto());
		cartas.add(new SieteDeOro());
		cartas.add(new AnchoDeEspada());
		this.IA.recibirCartas(cartas);
		Assert.assertTrue(this.IA.cantarValeCuatroIA());
	}

}
