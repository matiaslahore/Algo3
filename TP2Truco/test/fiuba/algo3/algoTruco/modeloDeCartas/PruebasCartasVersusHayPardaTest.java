package fiuba.algo3.algoTruco.modeloDeCartas;

import org.junit.Assert;
import org.junit.Test;

import fiuba.algo3.tp2.modeloCartas.AnchoFalso;
import fiuba.algo3.tp2.modeloCartas.Basto;
import fiuba.algo3.tp2.modeloCartas.Caballo;
import fiuba.algo3.tp2.modeloCartas.Carta;
import fiuba.algo3.tp2.modeloCartas.Cinco;
import fiuba.algo3.tp2.modeloCartas.Copa;
import fiuba.algo3.tp2.modeloCartas.Cuatro;
import fiuba.algo3.tp2.modeloCartas.Dos;
import fiuba.algo3.tp2.modeloCartas.Espada;
import fiuba.algo3.tp2.modeloCartas.Oro;
import fiuba.algo3.tp2.modeloCartas.Seis;
import fiuba.algo3.tp2.modeloCartas.SieteFalso;
import fiuba.algo3.tp2.modeloCartas.Sota;
import fiuba.algo3.tp2.modeloCartas.Tres;

public class PruebasCartasVersusHayPardaTest{

	public Carta carta;
	
	public Carta cartaContra;
	
	@Test
	public void elTresDeBastoEmpardaConElTresDeCopa(){
		
		carta = new Tres(new Basto());
		cartaContra = new Tres(new Copa());
		
		Assert.assertTrue(carta.hayParda(cartaContra));
	}
	
	@Test
	public void elDosDeOroEmparaConElDosDeEspada(){
		
		carta = new Dos(new Oro());
		cartaContra = new Dos(new Espada());
		
		Assert.assertTrue(carta.hayParda(cartaContra));
	}
	
	@Test
	public void elAnchoDeCopaEmparaConElAnchoDeOro(){
		
		carta = new AnchoFalso(new Copa());
		cartaContra = new AnchoFalso(new Oro());
		
		Assert.assertTrue(carta.hayParda(cartaContra));
	}
	

	@Test
	public void elReyDeCopaEmparaConElReyDeOro(){
		
		carta = new AnchoFalso(new Copa());
		cartaContra = new AnchoFalso(new Oro());
		
		Assert.assertTrue(carta.hayParda(cartaContra));
	}
	

	@Test
	public void elCaballoDeCopaEmpataConElCaballoDeOro(){
		
		carta = new Caballo(new Copa());
		cartaContra = new Caballo(new Oro());
		
		Assert.assertTrue(carta.hayParda(cartaContra));
	}
	

	@Test
	public void laSotaDeCopaEmpataConLaSotaDeEspada(){
		
		carta = new Sota(new Copa());
		cartaContra = new Sota(new Espada());
		
		Assert.assertTrue(carta.hayParda(cartaContra));
	}
	
	@Test
	public void elSieteDeCopaEmpataConElSieteDeBasto(){
		
		carta = new SieteFalso(new Copa());
		cartaContra = new SieteFalso(new Basto());
		
		Assert.assertTrue(carta.hayParda(cartaContra));
	}
	
	
	@Test
	public void elSeisDeCopaEmparaConElSeisDeBasto(){
		
		carta = new Seis(new Copa());
		cartaContra = new Seis(new Basto());
		
		Assert.assertTrue(carta.hayParda(cartaContra));
	}
	

	@Test
	public void elSeisDeOroEmparaConElSeisDeEspada(){
		
		carta = new Seis(new Oro());
		cartaContra = new Seis(new Espada());
		
		Assert.assertTrue(carta.hayParda(cartaContra));
	}
	
	@Test
	public void elCincoDeOroEmparaConElCincoDeEspada(){
		
		carta = new Cinco(new Oro());
		cartaContra = new Cinco(new Espada());
		
		Assert.assertTrue(carta.hayParda(cartaContra));
	}
	
	@Test
	public void elCuatroDeOroEmparaConElCuatroDeEspada(){
		
		carta = new Cuatro(new Oro());
		cartaContra = new Cuatro(new Espada());
		
		Assert.assertTrue(carta.hayParda(cartaContra));
	}
}
