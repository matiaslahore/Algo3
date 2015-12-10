package fiuba.algo3.tp2.modeloDeCartas;

import org.junit.Assert;
import org.junit.Test;

import fiuba.algo3.tp2.modeloDeCartas.AnchoDeBasto;
import fiuba.algo3.tp2.modeloDeCartas.AnchoDeEspada;
import fiuba.algo3.tp2.modeloDeCartas.AnchoFalso;
import fiuba.algo3.tp2.modeloDeCartas.Basto;
import fiuba.algo3.tp2.modeloDeCartas.Caballo;
import fiuba.algo3.tp2.modeloDeCartas.Carta;
import fiuba.algo3.tp2.modeloDeCartas.Cinco;
import fiuba.algo3.tp2.modeloDeCartas.Copa;
import fiuba.algo3.tp2.modeloDeCartas.Cuatro;
import fiuba.algo3.tp2.modeloDeCartas.Dos;
import fiuba.algo3.tp2.modeloDeCartas.Espada;
import fiuba.algo3.tp2.modeloDeCartas.Oro;
import fiuba.algo3.tp2.modeloDeCartas.Rey;
import fiuba.algo3.tp2.modeloDeCartas.Seis;
import fiuba.algo3.tp2.modeloDeCartas.SieteDeEspada;
import fiuba.algo3.tp2.modeloDeCartas.SieteDeOro;
import fiuba.algo3.tp2.modeloDeCartas.SieteFalso;
import fiuba.algo3.tp2.modeloDeCartas.Sota;
import fiuba.algo3.tp2.modeloDeCartas.Tres;

public class PruebasCartasVersusTodasLaCartasTest {
	

	Carta carta;
	Carta cartaContra;
	
	@Test
	public void elAnchoDeEspadaLeGanaATodos(){
		
		carta = new AnchoDeEspada();
		cartaContra = new AnchoDeBasto();
		
		Assert.assertEquals(carta,carta.vs(cartaContra));
		
		cartaContra = new SieteDeOro();
		Assert.assertEquals(carta,carta.vs(cartaContra));
	
		cartaContra = new SieteDeEspada();
		Assert.assertEquals(carta,carta.vs(cartaContra));
		
		cartaContra = new Tres(new Copa());
		Assert.assertEquals(carta,carta.vs(cartaContra));

		cartaContra = new Dos(new Copa());
		Assert.assertEquals(carta,carta.vs(cartaContra));

		cartaContra = new AnchoFalso(new Copa());
		Assert.assertEquals(carta,carta.vs(cartaContra));
		
		cartaContra = new Caballo(new Basto());
		Assert.assertEquals(carta,carta.vs(cartaContra));

		cartaContra = new Rey(new Copa());
		Assert.assertEquals(carta,carta.vs(cartaContra));

		cartaContra = new Sota(new Oro());
		Assert.assertEquals(carta,carta.vs(cartaContra));
		
		cartaContra = new SieteFalso(new Copa());
		Assert.assertEquals(carta,carta.vs(cartaContra));

		cartaContra = new SieteFalso(new Basto());
		Assert.assertEquals(carta,carta.vs(cartaContra));

		cartaContra = new Seis(new Copa());
		Assert.assertEquals(carta,carta.vs(cartaContra));

		cartaContra = new Cinco(new Copa());
		Assert.assertEquals(carta,carta.vs(cartaContra));

		cartaContra = new Cuatro(new Oro());
		Assert.assertEquals(carta,carta.vs(cartaContra));
	}
	
	@Test
	public void sieteDeOroLeGanaAtodosLasCartasMenores(){
		
		carta = new SieteDeOro();
	
		cartaContra = new Tres(new Copa());
		Assert.assertEquals(carta,carta.vs(cartaContra));

		cartaContra = new Dos(new Copa());
		Assert.assertEquals(carta,carta.vs(cartaContra));

		cartaContra = new AnchoFalso(new Copa());
		Assert.assertEquals(carta,carta.vs(cartaContra));
		
		cartaContra = new Caballo(new Basto());
		Assert.assertEquals(carta,carta.vs(cartaContra));

		cartaContra = new Rey(new Copa());
		Assert.assertEquals(carta,carta.vs(cartaContra));
		
		cartaContra = new Sota(new Oro());
		Assert.assertEquals(carta,carta.vs(cartaContra));
		
		cartaContra = new SieteFalso(new Copa());
		Assert.assertEquals(carta,carta.vs(cartaContra));

		cartaContra = new SieteFalso(new Basto());
		Assert.assertEquals(carta,carta.vs(cartaContra));

		cartaContra = new Seis(new Copa());
		Assert.assertEquals(carta,carta.vs(cartaContra));

		cartaContra = new Cinco(new Copa());
		Assert.assertEquals(carta,carta.vs(cartaContra));

		cartaContra = new Cuatro(new Oro());
		Assert.assertEquals(carta,carta.vs(cartaContra));
	}
	
	@Test
	public void elTresDeOroLeGanaAtodosLasCartasMenores(){
		
		carta = new Tres(new Oro());

		cartaContra = new Dos(new Copa());
		Assert.assertEquals(carta,carta.vs(cartaContra));

		cartaContra = new AnchoFalso(new Copa());
		Assert.assertEquals(carta,carta.vs(cartaContra));
		
		cartaContra = new Caballo(new Basto());
		Assert.assertEquals(carta,carta.vs(cartaContra));

		cartaContra = new Rey(new Copa());
		Assert.assertEquals(carta,carta.vs(cartaContra));
		
		cartaContra = new Sota(new Oro());
		Assert.assertEquals(carta,carta.vs(cartaContra));

		cartaContra = new SieteFalso(new Copa());
		Assert.assertEquals(carta,carta.vs(cartaContra));

		cartaContra = new SieteFalso(new Basto());
		Assert.assertEquals(carta,carta.vs(cartaContra));

		cartaContra = new Seis(new Copa());
		Assert.assertEquals(carta,carta.vs(cartaContra));

		cartaContra = new Cinco(new Copa());
		Assert.assertEquals(carta,carta.vs(cartaContra));

		cartaContra = new Cuatro(new Oro());
		Assert.assertEquals(carta,carta.vs(cartaContra));
	}
	
	@Test
	public void elDosDeOroLeGanaAtodosLasCartasMenores(){
		
		carta = new Dos(new Oro());

		cartaContra = new AnchoFalso(new Copa());
		Assert.assertEquals(carta,carta.vs(cartaContra));

		cartaContra = new Rey(new Copa());
		Assert.assertEquals(carta,carta.vs(cartaContra));
		
		cartaContra = new Caballo(new Basto());
		Assert.assertEquals(carta,carta.vs(cartaContra));

		cartaContra = new Sota(new Oro());
		Assert.assertEquals(carta,carta.vs(cartaContra));
		
		cartaContra = new SieteFalso(new Copa());
		Assert.assertEquals(carta,carta.vs(cartaContra));

		cartaContra = new SieteFalso(new Basto());
		Assert.assertEquals(carta,carta.vs(cartaContra));

		cartaContra = new Seis(new Copa());
		Assert.assertEquals(carta,carta.vs(cartaContra));

		cartaContra = new Cinco(new Copa());
		Assert.assertEquals(carta,carta.vs(cartaContra));

		cartaContra = new Cuatro(new Oro());
		Assert.assertEquals(carta,carta.vs(cartaContra));
	}
	
	@Test
	public void elAnchoDeCopaLeGanaATodasLasCartasMenores(){

		carta = new AnchoFalso(new Copa());
		
		cartaContra = new Rey(new Copa());
		Assert.assertEquals(carta,carta.vs(cartaContra));
		
		cartaContra = new Caballo(new Basto());
		Assert.assertEquals(carta,carta.vs(cartaContra));

		cartaContra = new Sota(new Oro());
		Assert.assertEquals(carta,carta.vs(cartaContra));
		
		cartaContra = new SieteFalso(new Copa());
		Assert.assertEquals(carta,carta.vs(cartaContra));

		cartaContra = new SieteFalso(new Basto());
		Assert.assertEquals(carta,carta.vs(cartaContra));

		cartaContra = new Seis(new Copa());
		Assert.assertEquals(carta,carta.vs(cartaContra));

		cartaContra = new Cinco(new Copa());
		Assert.assertEquals(carta,carta.vs(cartaContra));

		cartaContra = new Cuatro(new Oro());
		Assert.assertEquals(carta,carta.vs(cartaContra));
	}

	@Test
	public void elReyDeEspadaLeGanaATodasLasCartasMenores(){

		carta = new Rey(new Espada());
		
		cartaContra = new Caballo(new Basto());
		Assert.assertEquals(carta,carta.vs(cartaContra));
	
		cartaContra = new Sota(new Oro());
		Assert.assertEquals(carta,carta.vs(cartaContra));
		
		cartaContra = new SieteFalso(new Copa());
		Assert.assertEquals(carta,carta.vs(cartaContra));
	
		cartaContra = new SieteFalso(new Basto());
		Assert.assertEquals(carta,carta.vs(cartaContra));
	
		cartaContra = new Seis(new Copa());
		Assert.assertEquals(carta,carta.vs(cartaContra));
	
		cartaContra = new Cinco(new Copa());
		Assert.assertEquals(carta,carta.vs(cartaContra));
	
		cartaContra = new Cuatro(new Oro());
		Assert.assertEquals(carta,carta.vs(cartaContra));
	}
	
	@Test
	public void elCaballoDeEspadaLeGanaATodasLasCartasMenores(){

		carta = new Caballo(new Espada());
		
		cartaContra = new Sota(new Oro());
		Assert.assertEquals(carta,carta.vs(cartaContra));
		
		cartaContra = new SieteFalso(new Copa());
		Assert.assertEquals(carta,carta.vs(cartaContra));
	
		cartaContra = new SieteFalso(new Basto());
		Assert.assertEquals(carta,carta.vs(cartaContra));
	
		cartaContra = new Seis(new Copa());
		Assert.assertEquals(carta,carta.vs(cartaContra));
	
		cartaContra = new Cinco(new Copa());
		Assert.assertEquals(carta,carta.vs(cartaContra));
	
		cartaContra = new Cuatro(new Oro());
		Assert.assertEquals(carta,carta.vs(cartaContra));
	}
	
	@Test
	public void laSotaDeOroLeGanaATodasLasCartasMenores(){

		carta = new Sota(new Oro());
		
		cartaContra = new SieteFalso(new Copa());
		Assert.assertEquals(carta,carta.vs(cartaContra));
	
		cartaContra = new SieteFalso(new Basto());
		Assert.assertEquals(carta,carta.vs(cartaContra));
	
		cartaContra = new Seis(new Copa());
		Assert.assertEquals(carta,carta.vs(cartaContra));
	
		cartaContra = new Cinco(new Copa());
		Assert.assertEquals(carta,carta.vs(cartaContra));
	
		cartaContra = new Cuatro(new Oro());
		Assert.assertEquals(carta,carta.vs(cartaContra));
	}
	
	@Test
	public void elSieteDeBastoLeGanaATodasLasCartasMenores(){

		carta = new SieteFalso(new Basto());
		
		cartaContra = new Seis(new Copa());
		Assert.assertEquals(carta,carta.vs(cartaContra));
	
		cartaContra = new Cinco(new Copa());
		Assert.assertEquals(carta,carta.vs(cartaContra));
	
		cartaContra = new Cuatro(new Oro());
		Assert.assertEquals(carta,carta.vs(cartaContra));
	}
	
	@Test
	public void elSeisDeBastoLeGanaATodasLasCartasMenores(){

		carta = new Seis(new Basto());
	
		cartaContra = new Cinco(new Copa());
		Assert.assertEquals(carta,carta.vs(cartaContra));
	
		cartaContra = new Cuatro(new Oro());
		Assert.assertEquals(carta,carta.vs(cartaContra));
	}
	
	@Test
	public void elCincoDeBastoLeGanaAlCuatroDeOro(){

		carta = new Cinco(new Basto());
	
		cartaContra = new Cuatro(new Oro());
		Assert.assertEquals(carta,carta.vs(cartaContra));
	}
}