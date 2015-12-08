package fiuba.algo3.tp2.modelo;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

import fiuba.algo3.tp2.excepciones.CartaInexistenteEnManoDeJugadorExeption;
import fiuba.algo3.tp2.modeloDeCartas.*;

public class PruebasManoTest {

	private Mano mano;
	
	@Test
	public void pruebaObtenerCarta(){
		
		Carta sieteDeCopa = new SieteFalso(new Copa());
		Carta sieteDeBasto = new SieteFalso(new Basto());
		Carta cuatroDeBasto = new Cuatro(new Basto());
		
		Mano mano = new Mano(Arrays.asList(sieteDeCopa, sieteDeBasto, cuatroDeBasto));
		
		Assert.assertEquals(sieteDeBasto, mano.obtenerCarta(sieteDeBasto));
		Assert.assertEquals(sieteDeCopa, mano.obtenerCarta(sieteDeCopa));
		Assert.assertEquals(cuatroDeBasto, mano.obtenerCarta(cuatroDeBasto));
	}
	
	@Test
	(expected = CartaInexistenteEnManoDeJugadorExeption.class)
	public void pruebaConCartaInexistenteEnMano(){
		
		Carta sieteDeCopa = new SieteFalso(new Copa());
		Carta sieteDeBasto = new SieteFalso(new Basto());
		Carta cuatroDeBasto = new Cuatro(new Basto());
		
		Mano mano = new Mano(Arrays.asList(sieteDeCopa, sieteDeBasto, cuatroDeBasto));
		
		mano.obtenerCarta(new SieteDeOro());
	}
	
	
	@Test
	public void pruebaTantoEnMano(){
		mano = new Mano(Arrays.asList(new Tres(new Copa()), new SieteDeEspada(), new Cuatro(new Copa())));
		Assert.assertEquals(27,mano.calcularEnvido());
	}
}
