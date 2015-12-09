package fiuba.algo3.tp2.modelo;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import fiuba.algo3.tp2.modeloDeCartas.AnchoDeEspada;
import fiuba.algo3.tp2.modeloDeCartas.Basto;
import fiuba.algo3.tp2.modeloDeCartas.Caballo;
import fiuba.algo3.tp2.modeloDeCartas.Carta;
import fiuba.algo3.tp2.modeloDeCartas.Cinco;
import fiuba.algo3.tp2.modeloDeCartas.Copa;
import fiuba.algo3.tp2.modeloDeCartas.Cuatro;
import fiuba.algo3.tp2.modeloDeCartas.Dos;
import fiuba.algo3.tp2.modeloDeCartas.Oro;
import fiuba.algo3.tp2.modeloDeCartas.Rey;
import fiuba.algo3.tp2.modeloDeCartas.Seis;
import fiuba.algo3.tp2.modeloDeCartas.SieteDeOro;
import fiuba.algo3.tp2.modeloDeCartas.SieteFalso;
import fiuba.algo3.tp2.modeloDeCartas.Tres;
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
		cartas.add(new Cuatro(new Basto()));
		cartas.add(new Cuatro(new Oro()));
		cartas.add(new Cuatro(new Copa()));
		this.IA.recibirCartas(cartas);
		Assert.assertFalse(this.IA.cantarTrucoIA());
	}
	
	@Test
	public void jugadorIAConCartasBajasNoPuedeCantarTruco2(){
		List<Carta> cartas = new ArrayList<Carta>();
		cartas.add(new Cinco(new Basto()));
		cartas.add(new Cinco(new Oro()));
		cartas.add(new Cinco(new Copa()));
		this.IA.recibirCartas(cartas);
		Assert.assertFalse(this.IA.cantarTrucoIA());
	}
	
	@Test
	public void jugadorIAConCartasBajasNoPuedeCantarTruco3(){
		List<Carta> cartas = new ArrayList<Carta>();
		cartas.add(new Seis(new Basto()));
		cartas.add(new Seis(new Oro()));
		cartas.add(new Seis(new Copa()));
		this.IA.recibirCartas(cartas);
		Assert.assertFalse(this.IA.cantarTrucoIA());
	}
	
	@Test
	public void jugadorIAConCartasMayoresOIgualesA2SesisYUnCincoNoAceptaElTruco(){
		List<Carta> cartas = new ArrayList<Carta>();
		cartas.add(new Cinco(new Basto()));
		cartas.add(new Seis(new Oro()));
		cartas.add(new Seis(new Copa()));
		this.IA.recibirCartas(cartas);
		Assert.assertFalse(this.IA.quererTrucoIA());
	}
	
	@Test
	public void jugadorIAConCartasMayoresOIgualesA2SesisYUnSieteFalsoCantaElTruco(){
		List<Carta> cartas = new ArrayList<Carta>();
		cartas.add(new SieteFalso(new Basto()));
		cartas.add(new Seis(new Oro()));
		cartas.add(new Seis(new Copa()));
		this.IA.recibirCartas(cartas);
		Assert.assertTrue(this.IA.cantarTrucoIA());
	}
	
	@Test
	public void jugadorIAConCartasMayoresOIgualesATresCaballosAceptaElReTruco(){
		List<Carta> cartas = new ArrayList<Carta>();
		cartas.add(new Caballo(new Basto()));
		cartas.add(new Caballo(new Oro()));
		cartas.add(new Caballo(new Copa()));
		this.IA.recibirCartas(cartas);
		Assert.assertTrue(this.IA.quererReTrucoIA());
	}
	
	@Test
	public void jugadorIAConCartasMayoresOIgualesATresReyesCantaElReTruco(){
		List<Carta> cartas = new ArrayList<Carta>();
		cartas.add(new Rey(new Basto()));
		cartas.add(new Rey(new Oro()));
		cartas.add(new Rey(new Copa()));
		this.IA.recibirCartas(cartas);
		Assert.assertTrue(this.IA.cantarReTrucoIA());
	}
	
	@Test
	public void jugadorIAConCartasMayoresOIgualesA2TresYUnSieteDeOroAceptaElValeCuatro(){
		List<Carta> cartas = new ArrayList<Carta>();
		cartas.add(new Tres(new Basto()));
		cartas.add(new SieteDeOro());
		cartas.add(new Tres(new Copa()));
		this.IA.recibirCartas(cartas);
		Assert.assertTrue(this.IA.quererValeCuatroIA());
	}
	
	@Test
	public void jugadorIAConCartasMayoresOIgualesAUnDosMasEl7DeOroMasElAnchoDeEspadaCantaElValeCuatro(){
		List<Carta> cartas = new ArrayList<Carta>();
		cartas.add(new Dos(new Basto()));
		cartas.add(new SieteDeOro());
		cartas.add(new AnchoDeEspada());
		this.IA.recibirCartas(cartas);
		Assert.assertTrue(this.IA.cantarValeCuatroIA());
	}

}
