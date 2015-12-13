package fiuba.algo3.tp2.modelo;

import org.junit.Assert;
import org.junit.Test;

import fiuba.algo3.tp2.modeloDeCartas.AnchoDeBasto;
import fiuba.algo3.tp2.modeloDeCartas.AnchoDeEspada;
import fiuba.algo3.tp2.modeloDeCartas.AnchoFalso;
import fiuba.algo3.tp2.modeloDeCartas.Basto;
import fiuba.algo3.tp2.modeloDeCartas.Caballo;
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

public class PruebasCartasSumarEnvidoTest {

	@Test 
	public void pruebaSumarEnvidoCartasDeEspada(){
		Assert.assertEquals(23, new AnchoDeEspada().sumarEnvido(new Dos(new Espada())));
		Assert.assertEquals(24, new AnchoDeEspada().sumarEnvido(new Tres(new Espada())));
		Assert.assertEquals(25, new AnchoDeEspada().sumarEnvido(new Cuatro(new Espada())));
		Assert.assertEquals(26, new AnchoDeEspada().sumarEnvido(new Cinco(new Espada())));
		Assert.assertEquals(27, new AnchoDeEspada().sumarEnvido(new Seis(new Espada())));
		Assert.assertEquals(28, new AnchoDeEspada().sumarEnvido(new SieteDeEspada()));
		Assert.assertEquals(21, new AnchoDeEspada().sumarEnvido(new Sota(new Espada())));
		Assert.assertEquals(21, new AnchoDeEspada().sumarEnvido(new Caballo(new Espada())));
		Assert.assertEquals(21, new AnchoDeEspada().sumarEnvido(new Rey(new Espada())));
		
		Assert.assertEquals(23, new Dos(new Espada()).sumarEnvido(new AnchoDeEspada()));
		Assert.assertEquals(25, new Dos(new Espada()).sumarEnvido(new Tres(new Espada())));
		Assert.assertEquals(26, new Dos(new Espada()).sumarEnvido(new Cuatro(new Espada())));
		Assert.assertEquals(27, new Dos(new Espada()).sumarEnvido(new Cinco(new Espada())));
		Assert.assertEquals(28, new Dos(new Espada()).sumarEnvido(new Seis(new Espada())));
		Assert.assertEquals(29, new Dos(new Espada()).sumarEnvido(new SieteDeEspada()));
		Assert.assertEquals(22, new Dos(new Espada()).sumarEnvido(new Sota(new Espada())));
		Assert.assertEquals(22, new Dos(new Espada()).sumarEnvido(new Caballo(new Espada())));
		Assert.assertEquals(22, new Dos(new Espada()).sumarEnvido(new Rey(new Espada())));
		
		Assert.assertEquals(24, new Tres(new Espada()).sumarEnvido(new AnchoDeEspada()));
		Assert.assertEquals(25, new Tres(new Espada()).sumarEnvido(new Dos(new Espada())));
		Assert.assertEquals(27, new Tres(new Espada()).sumarEnvido(new Cuatro(new Espada())));
		Assert.assertEquals(28, new Tres(new Espada()).sumarEnvido(new Cinco(new Espada())));
		Assert.assertEquals(29, new Tres(new Espada()).sumarEnvido(new Seis(new Espada())));
		Assert.assertEquals(30, new Tres(new Espada()).sumarEnvido(new SieteDeEspada()));
		Assert.assertEquals(23, new Tres(new Espada()).sumarEnvido(new Sota(new Espada())));
		Assert.assertEquals(23, new Tres(new Espada()).sumarEnvido(new Caballo(new Espada())));
		Assert.assertEquals(23, new Tres(new Espada()).sumarEnvido(new Rey(new Espada())));
		
		Assert.assertEquals(25, new Cuatro(new Espada()).sumarEnvido(new AnchoDeEspada()));
		Assert.assertEquals(26, new Cuatro(new Espada()).sumarEnvido(new Dos(new Espada())));
		Assert.assertEquals(27, new Cuatro(new Espada()).sumarEnvido(new Tres(new Espada())));
		Assert.assertEquals(29, new Cuatro(new Espada()).sumarEnvido(new Cinco(new Espada())));
		Assert.assertEquals(30, new Cuatro(new Espada()).sumarEnvido(new Seis(new Espada())));
		Assert.assertEquals(31, new Cuatro(new Espada()).sumarEnvido(new SieteDeEspada()));
		Assert.assertEquals(24, new Cuatro(new Espada()).sumarEnvido(new Sota(new Espada())));
		Assert.assertEquals(24, new Cuatro(new Espada()).sumarEnvido(new Caballo(new Espada())));
		Assert.assertEquals(24, new Cuatro(new Espada()).sumarEnvido(new Rey(new Espada())));
		
		Assert.assertEquals(26, new Cinco(new Espada()).sumarEnvido(new AnchoDeEspada()));
		Assert.assertEquals(27, new Cinco(new Espada()).sumarEnvido(new Dos(new Espada())));
		Assert.assertEquals(28, new Cinco(new Espada()).sumarEnvido(new Tres(new Espada())));
		Assert.assertEquals(29, new Cinco(new Espada()).sumarEnvido(new Cuatro(new Espada())));
		Assert.assertEquals(31, new Cinco(new Espada()).sumarEnvido(new Seis(new Espada())));
		Assert.assertEquals(32, new Cinco(new Espada()).sumarEnvido(new SieteDeEspada()));
		Assert.assertEquals(25, new Cinco(new Espada()).sumarEnvido(new Sota(new Espada())));
		Assert.assertEquals(25, new Cinco(new Espada()).sumarEnvido(new Caballo(new Espada())));
		Assert.assertEquals(25, new Cinco(new Espada()).sumarEnvido(new Rey(new Espada())));
		
		Assert.assertEquals(27, new Seis(new Espada()).sumarEnvido(new AnchoDeEspada()));
		Assert.assertEquals(28, new Seis(new Espada()).sumarEnvido(new Dos(new Espada())));
		Assert.assertEquals(29, new Seis(new Espada()).sumarEnvido(new Tres(new Espada())));
		Assert.assertEquals(30, new Seis(new Espada()).sumarEnvido(new Cuatro(new Espada())));
		Assert.assertEquals(31, new Seis(new Espada()).sumarEnvido(new Cinco(new Espada())));
		Assert.assertEquals(33, new Seis(new Espada()).sumarEnvido(new SieteDeEspada()));
		Assert.assertEquals(26, new Seis(new Espada()).sumarEnvido(new Sota(new Espada())));
		Assert.assertEquals(26, new Seis(new Espada()).sumarEnvido(new Caballo(new Espada())));
		Assert.assertEquals(26, new Seis(new Espada()).sumarEnvido(new Rey(new Espada())));
		
		Assert.assertEquals(28, new SieteDeEspada().sumarEnvido(new AnchoDeEspada()));
		Assert.assertEquals(29, new SieteDeEspada().sumarEnvido(new Dos(new Espada())));
		Assert.assertEquals(30, new SieteDeEspada().sumarEnvido(new Tres(new Espada())));
		Assert.assertEquals(31, new SieteDeEspada().sumarEnvido(new Cuatro(new Espada())));
		Assert.assertEquals(32, new SieteDeEspada().sumarEnvido(new Cinco(new Espada())));
		Assert.assertEquals(33, new SieteDeEspada().sumarEnvido(new Seis(new Espada())));
		Assert.assertEquals(27, new SieteDeEspada().sumarEnvido(new Sota(new Espada())));
		Assert.assertEquals(27, new SieteDeEspada().sumarEnvido(new Caballo(new Espada())));
		Assert.assertEquals(27, new SieteDeEspada().sumarEnvido(new Rey(new Espada())));
		
		Assert.assertEquals(21, new Sota(new Espada()).sumarEnvido(new AnchoDeEspada()));
		Assert.assertEquals(22, new Sota(new Espada()).sumarEnvido(new Dos(new Espada())));
		Assert.assertEquals(23, new Sota(new Espada()).sumarEnvido(new Tres(new Espada())));
		Assert.assertEquals(24, new Sota(new Espada()).sumarEnvido(new Cuatro(new Espada())));
		Assert.assertEquals(25, new Sota(new Espada()).sumarEnvido(new Cinco(new Espada())));
		Assert.assertEquals(26, new Sota(new Espada()).sumarEnvido(new Seis(new Espada())));
		Assert.assertEquals(27, new Sota(new Espada()).sumarEnvido(new SieteDeEspada()));
		Assert.assertEquals(20, new Sota(new Espada()).sumarEnvido(new Caballo(new Espada())));
		Assert.assertEquals(20, new Sota(new Espada()).sumarEnvido(new Rey(new Espada())));
		
		Assert.assertEquals(21, new Caballo(new Espada()).sumarEnvido(new AnchoDeEspada()));
		Assert.assertEquals(22, new Caballo(new Espada()).sumarEnvido(new Dos(new Espada())));
		Assert.assertEquals(23, new Caballo(new Espada()).sumarEnvido(new Tres(new Espada())));
		Assert.assertEquals(24, new Caballo(new Espada()).sumarEnvido(new Cuatro(new Espada())));
		Assert.assertEquals(25, new Caballo(new Espada()).sumarEnvido(new Cinco(new Espada())));
		Assert.assertEquals(26, new Caballo(new Espada()).sumarEnvido(new Seis(new Espada())));
		Assert.assertEquals(27, new Caballo(new Espada()).sumarEnvido(new SieteDeEspada()));
		Assert.assertEquals(20, new Caballo(new Espada()).sumarEnvido(new Sota(new Espada())));
		Assert.assertEquals(20, new Caballo(new Espada()).sumarEnvido(new Rey(new Espada())));
		
		Assert.assertEquals(21, new Rey(new Espada()).sumarEnvido(new AnchoDeEspada()));
		Assert.assertEquals(22, new Rey(new Espada()).sumarEnvido(new Dos(new Espada())));
		Assert.assertEquals(23, new Rey(new Espada()).sumarEnvido(new Tres(new Espada())));
		Assert.assertEquals(24, new Rey(new Espada()).sumarEnvido(new Cuatro(new Espada())));
		Assert.assertEquals(25, new Rey(new Espada()).sumarEnvido(new Cinco(new Espada())));
		Assert.assertEquals(26, new Rey(new Espada()).sumarEnvido(new Seis(new Espada())));
		Assert.assertEquals(27, new Rey(new Espada()).sumarEnvido(new SieteDeEspada()));
		Assert.assertEquals(20, new Rey(new Espada()).sumarEnvido(new Sota(new Espada())));
		Assert.assertEquals(20, new Rey(new Espada()).sumarEnvido(new Caballo(new Espada())));
	}
	
	@Test 
	public void pruebaSumarEnvidoCartasDeBasto(){
		Assert.assertEquals(23, new AnchoDeBasto().sumarEnvido(new Dos(new Basto())));
		Assert.assertEquals(24, new AnchoDeBasto().sumarEnvido(new Tres(new Basto())));
		Assert.assertEquals(25, new AnchoDeBasto().sumarEnvido(new Cuatro(new Basto())));
		Assert.assertEquals(26, new AnchoDeBasto().sumarEnvido(new Cinco(new Basto())));
		Assert.assertEquals(27, new AnchoDeBasto().sumarEnvido(new Seis(new Basto())));
		Assert.assertEquals(28, new AnchoDeBasto().sumarEnvido(new SieteFalso(new Basto())));
		Assert.assertEquals(21, new AnchoDeBasto().sumarEnvido(new Sota(new Basto())));
		Assert.assertEquals(21, new AnchoDeBasto().sumarEnvido(new Caballo(new Basto())));
		Assert.assertEquals(21, new AnchoDeBasto().sumarEnvido(new Rey(new Basto())));
		
		Assert.assertEquals(23, new Dos(new Basto()).sumarEnvido(new AnchoDeBasto()));
		Assert.assertEquals(25, new Dos(new Basto()).sumarEnvido(new Tres(new Basto())));
		Assert.assertEquals(26, new Dos(new Basto()).sumarEnvido(new Cuatro(new Basto())));
		Assert.assertEquals(27, new Dos(new Basto()).sumarEnvido(new Cinco(new Basto())));
		Assert.assertEquals(28, new Dos(new Basto()).sumarEnvido(new Seis(new Basto())));
		Assert.assertEquals(29, new Dos(new Basto()).sumarEnvido(new SieteFalso(new Basto())));
		Assert.assertEquals(22, new Dos(new Basto()).sumarEnvido(new Sota(new Basto())));
		Assert.assertEquals(22, new Dos(new Basto()).sumarEnvido(new Caballo(new Basto())));
		Assert.assertEquals(22, new Dos(new Basto()).sumarEnvido(new Rey(new Basto())));
		
		Assert.assertEquals(24, new Tres(new Basto()).sumarEnvido(new AnchoDeBasto()));
		Assert.assertEquals(25, new Tres(new Basto()).sumarEnvido(new Dos(new Basto())));
		Assert.assertEquals(27, new Tres(new Basto()).sumarEnvido(new Cuatro(new Basto())));
		Assert.assertEquals(28, new Tres(new Basto()).sumarEnvido(new Cinco(new Basto())));
		Assert.assertEquals(29, new Tres(new Basto()).sumarEnvido(new Seis(new Basto())));
		Assert.assertEquals(30, new Tres(new Basto()).sumarEnvido(new SieteFalso(new Basto())));
		Assert.assertEquals(23, new Tres(new Basto()).sumarEnvido(new Sota(new Basto())));
		Assert.assertEquals(23, new Tres(new Basto()).sumarEnvido(new Caballo(new Basto())));
		Assert.assertEquals(23, new Tres(new Basto()).sumarEnvido(new Rey(new Basto())));
		
		Assert.assertEquals(25, new Cuatro(new Basto()).sumarEnvido(new AnchoDeBasto()));
		Assert.assertEquals(26, new Cuatro(new Basto()).sumarEnvido(new Dos(new Basto())));
		Assert.assertEquals(27, new Cuatro(new Basto()).sumarEnvido(new Tres(new Basto())));
		Assert.assertEquals(29, new Cuatro(new Basto()).sumarEnvido(new Cinco(new Basto())));
		Assert.assertEquals(30, new Cuatro(new Basto()).sumarEnvido(new Seis(new Basto())));
		Assert.assertEquals(31, new Cuatro(new Basto()).sumarEnvido(new SieteFalso(new Basto())));
		Assert.assertEquals(24, new Cuatro(new Basto()).sumarEnvido(new Sota(new Basto())));
		Assert.assertEquals(24, new Cuatro(new Basto()).sumarEnvido(new Caballo(new Basto())));
		Assert.assertEquals(24, new Cuatro(new Basto()).sumarEnvido(new Rey(new Basto())));
		
		Assert.assertEquals(26, new Cinco(new Basto()).sumarEnvido(new AnchoDeBasto()));
		Assert.assertEquals(27, new Cinco(new Basto()).sumarEnvido(new Dos(new Basto())));
		Assert.assertEquals(28, new Cinco(new Basto()).sumarEnvido(new Tres(new Basto())));
		Assert.assertEquals(29, new Cinco(new Basto()).sumarEnvido(new Cuatro(new Basto())));
		Assert.assertEquals(31, new Cinco(new Basto()).sumarEnvido(new Seis(new Basto())));
		Assert.assertEquals(32, new Cinco(new Basto()).sumarEnvido(new SieteFalso(new Basto())));
		Assert.assertEquals(25, new Cinco(new Basto()).sumarEnvido(new Sota(new Basto())));
		Assert.assertEquals(25, new Cinco(new Basto()).sumarEnvido(new Caballo(new Basto())));
		Assert.assertEquals(25, new Cinco(new Basto()).sumarEnvido(new Rey(new Basto())));
		
		Assert.assertEquals(27, new Seis(new Basto()).sumarEnvido(new AnchoDeBasto()));
		Assert.assertEquals(28, new Seis(new Basto()).sumarEnvido(new Dos(new Basto())));
		Assert.assertEquals(29, new Seis(new Basto()).sumarEnvido(new Tres(new Basto())));
		Assert.assertEquals(30, new Seis(new Basto()).sumarEnvido(new Cuatro(new Basto())));
		Assert.assertEquals(31, new Seis(new Basto()).sumarEnvido(new Cinco(new Basto())));
		Assert.assertEquals(33, new Seis(new Basto()).sumarEnvido(new SieteFalso(new Basto())));
		Assert.assertEquals(26, new Seis(new Basto()).sumarEnvido(new Sota(new Basto())));
		Assert.assertEquals(26, new Seis(new Basto()).sumarEnvido(new Caballo(new Basto())));
		Assert.assertEquals(26, new Seis(new Basto()).sumarEnvido(new Rey(new Basto())));
		
		Assert.assertEquals(28, new SieteFalso(new Basto()).sumarEnvido(new AnchoDeBasto()));
		Assert.assertEquals(29, new SieteFalso(new Basto()).sumarEnvido(new Dos(new Basto())));
		Assert.assertEquals(30, new SieteFalso(new Basto()).sumarEnvido(new Tres(new Basto())));
		Assert.assertEquals(31, new SieteFalso(new Basto()).sumarEnvido(new Cuatro(new Basto())));
		Assert.assertEquals(32, new SieteFalso(new Basto()).sumarEnvido(new Cinco(new Basto())));
		Assert.assertEquals(33, new SieteFalso(new Basto()).sumarEnvido(new Seis(new Basto())));
		Assert.assertEquals(27, new SieteFalso(new Basto()).sumarEnvido(new Sota(new Basto())));
		Assert.assertEquals(27, new SieteFalso(new Basto()).sumarEnvido(new Caballo(new Basto())));
		Assert.assertEquals(27, new SieteFalso(new Basto()).sumarEnvido(new Rey(new Basto())));
		
		Assert.assertEquals(21, new Sota(new Basto()).sumarEnvido(new AnchoDeBasto()));
		Assert.assertEquals(22, new Sota(new Basto()).sumarEnvido(new Dos(new Basto())));
		Assert.assertEquals(23, new Sota(new Basto()).sumarEnvido(new Tres(new Basto())));
		Assert.assertEquals(24, new Sota(new Basto()).sumarEnvido(new Cuatro(new Basto())));
		Assert.assertEquals(25, new Sota(new Basto()).sumarEnvido(new Cinco(new Basto())));
		Assert.assertEquals(26, new Sota(new Basto()).sumarEnvido(new Seis(new Basto())));
		Assert.assertEquals(27, new Sota(new Basto()).sumarEnvido(new SieteFalso(new Basto())));
		Assert.assertEquals(20, new Sota(new Basto()).sumarEnvido(new Caballo(new Basto())));
		Assert.assertEquals(20, new Sota(new Basto()).sumarEnvido(new Rey(new Basto())));
		
		Assert.assertEquals(21, new Caballo(new Basto()).sumarEnvido(new AnchoDeBasto()));
		Assert.assertEquals(22, new Caballo(new Basto()).sumarEnvido(new Dos(new Basto())));
		Assert.assertEquals(23, new Caballo(new Basto()).sumarEnvido(new Tres(new Basto())));
		Assert.assertEquals(24, new Caballo(new Basto()).sumarEnvido(new Cuatro(new Basto())));
		Assert.assertEquals(25, new Caballo(new Basto()).sumarEnvido(new Cinco(new Basto())));
		Assert.assertEquals(26, new Caballo(new Basto()).sumarEnvido(new Seis(new Basto())));
		Assert.assertEquals(27, new Caballo(new Basto()).sumarEnvido(new SieteFalso(new Basto())));
		Assert.assertEquals(20, new Caballo(new Basto()).sumarEnvido(new Sota(new Basto())));
		Assert.assertEquals(20, new Caballo(new Basto()).sumarEnvido(new Rey(new Basto())));
		
		Assert.assertEquals(21, new Rey(new Basto()).sumarEnvido(new AnchoDeBasto()));
		Assert.assertEquals(22, new Rey(new Basto()).sumarEnvido(new Dos(new Basto())));
		Assert.assertEquals(23, new Rey(new Basto()).sumarEnvido(new Tres(new Basto())));
		Assert.assertEquals(24, new Rey(new Basto()).sumarEnvido(new Cuatro(new Basto())));
		Assert.assertEquals(25, new Rey(new Basto()).sumarEnvido(new Cinco(new Basto())));
		Assert.assertEquals(26, new Rey(new Basto()).sumarEnvido(new Seis(new Basto())));
		Assert.assertEquals(27, new Rey(new Basto()).sumarEnvido(new SieteFalso(new Basto())));
		Assert.assertEquals(20, new Rey(new Basto()).sumarEnvido(new Sota(new Basto())));
		Assert.assertEquals(20, new Rey(new Basto()).sumarEnvido(new Caballo(new Basto())));
	}
	
	@Test 
	public void pruebaSumarEnvidoCartasDeOro(){
		Assert.assertEquals(23, new AnchoFalso(new Oro()).sumarEnvido(new Dos(new Oro())));
		Assert.assertEquals(24, new AnchoFalso(new Oro()).sumarEnvido(new Tres(new Oro())));
		Assert.assertEquals(25, new AnchoFalso(new Oro()).sumarEnvido(new Cuatro(new Oro())));
		Assert.assertEquals(26, new AnchoFalso(new Oro()).sumarEnvido(new Cinco(new Oro())));
		Assert.assertEquals(27, new AnchoFalso(new Oro()).sumarEnvido(new Seis(new Oro())));
		Assert.assertEquals(28, new AnchoFalso(new Oro()).sumarEnvido(new SieteDeOro()));
		Assert.assertEquals(21, new AnchoFalso(new Oro()).sumarEnvido(new Sota(new Oro())));
		Assert.assertEquals(21, new AnchoFalso(new Oro()).sumarEnvido(new Caballo(new Oro())));
		Assert.assertEquals(21, new AnchoFalso(new Oro()).sumarEnvido(new Rey(new Oro())));
		
		Assert.assertEquals(23, new Dos(new Oro()).sumarEnvido(new AnchoFalso(new Oro())));
		Assert.assertEquals(25, new Dos(new Oro()).sumarEnvido(new Tres(new Oro())));
		Assert.assertEquals(26, new Dos(new Oro()).sumarEnvido(new Cuatro(new Oro())));
		Assert.assertEquals(27, new Dos(new Oro()).sumarEnvido(new Cinco(new Oro())));
		Assert.assertEquals(28, new Dos(new Oro()).sumarEnvido(new Seis(new Oro())));
		Assert.assertEquals(29, new Dos(new Oro()).sumarEnvido(new SieteDeOro()));
		Assert.assertEquals(22, new Dos(new Oro()).sumarEnvido(new Sota(new Oro())));
		Assert.assertEquals(22, new Dos(new Oro()).sumarEnvido(new Caballo(new Oro())));
		Assert.assertEquals(22, new Dos(new Oro()).sumarEnvido(new Rey(new Oro())));
		
		Assert.assertEquals(24, new Tres(new Oro()).sumarEnvido(new AnchoFalso(new Oro())));
		Assert.assertEquals(25, new Tres(new Oro()).sumarEnvido(new Dos(new Oro())));
		Assert.assertEquals(27, new Tres(new Oro()).sumarEnvido(new Cuatro(new Oro())));
		Assert.assertEquals(28, new Tres(new Oro()).sumarEnvido(new Cinco(new Oro())));
		Assert.assertEquals(29, new Tres(new Oro()).sumarEnvido(new Seis(new Oro())));
		Assert.assertEquals(30, new Tres(new Oro()).sumarEnvido(new SieteDeOro()));
		Assert.assertEquals(23, new Tres(new Oro()).sumarEnvido(new Sota(new Oro())));
		Assert.assertEquals(23, new Tres(new Oro()).sumarEnvido(new Caballo(new Oro())));
		Assert.assertEquals(23, new Tres(new Oro()).sumarEnvido(new Rey(new Oro())));
		
		Assert.assertEquals(25, new Cuatro(new Oro()).sumarEnvido(new AnchoFalso(new Oro())));
		Assert.assertEquals(26, new Cuatro(new Oro()).sumarEnvido(new Dos(new Oro())));
		Assert.assertEquals(27, new Cuatro(new Oro()).sumarEnvido(new Tres(new Oro())));
		Assert.assertEquals(29, new Cuatro(new Oro()).sumarEnvido(new Cinco(new Oro())));
		Assert.assertEquals(30, new Cuatro(new Oro()).sumarEnvido(new Seis(new Oro())));
		Assert.assertEquals(31, new Cuatro(new Oro()).sumarEnvido(new SieteDeOro()));
		Assert.assertEquals(24, new Cuatro(new Oro()).sumarEnvido(new Sota(new Oro())));
		Assert.assertEquals(24, new Cuatro(new Oro()).sumarEnvido(new Caballo(new Oro())));
		Assert.assertEquals(24, new Cuatro(new Oro()).sumarEnvido(new Rey(new Oro())));
		
		Assert.assertEquals(26, new Cinco(new Oro()).sumarEnvido(new AnchoFalso(new Oro())));
		Assert.assertEquals(27, new Cinco(new Oro()).sumarEnvido(new Dos(new Oro())));
		Assert.assertEquals(28, new Cinco(new Oro()).sumarEnvido(new Tres(new Oro())));
		Assert.assertEquals(29, new Cinco(new Oro()).sumarEnvido(new Cuatro(new Oro())));
		Assert.assertEquals(31, new Cinco(new Oro()).sumarEnvido(new Seis(new Oro())));
		Assert.assertEquals(32, new Cinco(new Oro()).sumarEnvido(new SieteDeOro()));
		Assert.assertEquals(25, new Cinco(new Oro()).sumarEnvido(new Sota(new Oro())));
		Assert.assertEquals(25, new Cinco(new Oro()).sumarEnvido(new Caballo(new Oro())));
		Assert.assertEquals(25, new Cinco(new Oro()).sumarEnvido(new Rey(new Oro())));
		
		Assert.assertEquals(27, new Seis(new Oro()).sumarEnvido(new AnchoFalso(new Oro())));
		Assert.assertEquals(28, new Seis(new Oro()).sumarEnvido(new Dos(new Oro())));
		Assert.assertEquals(29, new Seis(new Oro()).sumarEnvido(new Tres(new Oro())));
		Assert.assertEquals(30, new Seis(new Oro()).sumarEnvido(new Cuatro(new Oro())));
		Assert.assertEquals(31, new Seis(new Oro()).sumarEnvido(new Cinco(new Oro())));
		Assert.assertEquals(33, new Seis(new Oro()).sumarEnvido(new SieteDeOro()));
		Assert.assertEquals(26, new Seis(new Oro()).sumarEnvido(new Sota(new Oro())));
		Assert.assertEquals(26, new Seis(new Oro()).sumarEnvido(new Caballo(new Oro())));
		Assert.assertEquals(26, new Seis(new Oro()).sumarEnvido(new Rey(new Oro())));
		
		Assert.assertEquals(28, new SieteDeOro().sumarEnvido(new AnchoFalso(new Oro())));
		Assert.assertEquals(29, new SieteDeOro().sumarEnvido(new Dos(new Oro())));
		Assert.assertEquals(30, new SieteDeOro().sumarEnvido(new Tres(new Oro())));
		Assert.assertEquals(31, new SieteDeOro().sumarEnvido(new Cuatro(new Oro())));
		Assert.assertEquals(32, new SieteDeOro().sumarEnvido(new Cinco(new Oro())));
		Assert.assertEquals(33, new SieteDeOro().sumarEnvido(new Seis(new Oro())));
		Assert.assertEquals(27, new SieteDeOro().sumarEnvido(new Sota(new Oro())));
		Assert.assertEquals(27, new SieteDeOro().sumarEnvido(new Caballo(new Oro())));
		Assert.assertEquals(27, new SieteDeOro().sumarEnvido(new Rey(new Oro())));
		
		Assert.assertEquals(21, new Sota(new Oro()).sumarEnvido(new AnchoFalso(new Oro())));
		Assert.assertEquals(22, new Sota(new Oro()).sumarEnvido(new Dos(new Oro())));
		Assert.assertEquals(23, new Sota(new Oro()).sumarEnvido(new Tres(new Oro())));
		Assert.assertEquals(24, new Sota(new Oro()).sumarEnvido(new Cuatro(new Oro())));
		Assert.assertEquals(25, new Sota(new Oro()).sumarEnvido(new Cinco(new Oro())));
		Assert.assertEquals(26, new Sota(new Oro()).sumarEnvido(new Seis(new Oro())));
		Assert.assertEquals(27, new Sota(new Oro()).sumarEnvido(new SieteDeOro()));
		Assert.assertEquals(20, new Sota(new Oro()).sumarEnvido(new Caballo(new Oro())));
		Assert.assertEquals(20, new Sota(new Oro()).sumarEnvido(new Rey(new Oro())));
		
		Assert.assertEquals(21, new Caballo(new Oro()).sumarEnvido(new AnchoFalso(new Oro())));
		Assert.assertEquals(22, new Caballo(new Oro()).sumarEnvido(new Dos(new Oro())));
		Assert.assertEquals(23, new Caballo(new Oro()).sumarEnvido(new Tres(new Oro())));
		Assert.assertEquals(24, new Caballo(new Oro()).sumarEnvido(new Cuatro(new Oro())));
		Assert.assertEquals(25, new Caballo(new Oro()).sumarEnvido(new Cinco(new Oro())));
		Assert.assertEquals(26, new Caballo(new Oro()).sumarEnvido(new Seis(new Oro())));
		Assert.assertEquals(27, new Caballo(new Oro()).sumarEnvido(new SieteDeOro()));
		Assert.assertEquals(20, new Caballo(new Oro()).sumarEnvido(new Sota(new Oro())));
		Assert.assertEquals(20, new Caballo(new Oro()).sumarEnvido(new Rey(new Oro())));
		
		Assert.assertEquals(21, new Rey(new Oro()).sumarEnvido(new AnchoFalso(new Oro())));
		Assert.assertEquals(22, new Rey(new Oro()).sumarEnvido(new Dos(new Oro())));
		Assert.assertEquals(23, new Rey(new Oro()).sumarEnvido(new Tres(new Oro())));
		Assert.assertEquals(24, new Rey(new Oro()).sumarEnvido(new Cuatro(new Oro())));
		Assert.assertEquals(25, new Rey(new Oro()).sumarEnvido(new Cinco(new Oro())));
		Assert.assertEquals(26, new Rey(new Oro()).sumarEnvido(new Seis(new Oro())));
		Assert.assertEquals(27, new Rey(new Oro()).sumarEnvido(new SieteDeOro()));
		Assert.assertEquals(20, new Rey(new Oro()).sumarEnvido(new Sota(new Oro())));
		Assert.assertEquals(20, new Rey(new Oro()).sumarEnvido(new Caballo(new Oro())));
	}
	
	@Test 
	public void pruebaSumarEnvidoCartasDeCopa(){
		Assert.assertEquals(23, new AnchoFalso(new Copa()).sumarEnvido(new Dos(new Copa())));
		Assert.assertEquals(24, new AnchoFalso(new Copa()).sumarEnvido(new Tres(new Copa())));
		Assert.assertEquals(25, new AnchoFalso(new Copa()).sumarEnvido(new Cuatro(new Copa())));
		Assert.assertEquals(26, new AnchoFalso(new Copa()).sumarEnvido(new Cinco(new Copa())));
		Assert.assertEquals(27, new AnchoFalso(new Copa()).sumarEnvido(new Seis(new Copa())));
		Assert.assertEquals(28, new AnchoFalso(new Copa()).sumarEnvido(new SieteFalso(new Copa())));
		Assert.assertEquals(21, new AnchoFalso(new Copa()).sumarEnvido(new Sota(new Copa())));
		Assert.assertEquals(21, new AnchoFalso(new Copa()).sumarEnvido(new Caballo(new Copa())));
		Assert.assertEquals(21, new AnchoFalso(new Copa()).sumarEnvido(new Rey(new Copa())));
		
		Assert.assertEquals(23, new Dos(new Copa()).sumarEnvido(new AnchoFalso(new Copa())));
		Assert.assertEquals(25, new Dos(new Copa()).sumarEnvido(new Tres(new Copa())));
		Assert.assertEquals(26, new Dos(new Copa()).sumarEnvido(new Cuatro(new Copa())));
		Assert.assertEquals(27, new Dos(new Copa()).sumarEnvido(new Cinco(new Copa())));
		Assert.assertEquals(28, new Dos(new Copa()).sumarEnvido(new Seis(new Copa())));
		Assert.assertEquals(29, new Dos(new Copa()).sumarEnvido(new SieteFalso(new Copa())));
		Assert.assertEquals(22, new Dos(new Copa()).sumarEnvido(new Sota(new Copa())));
		Assert.assertEquals(22, new Dos(new Copa()).sumarEnvido(new Caballo(new Copa())));
		Assert.assertEquals(22, new Dos(new Copa()).sumarEnvido(new Rey(new Copa())));
		
		Assert.assertEquals(24, new Tres(new Copa()).sumarEnvido(new AnchoFalso(new Copa())));
		Assert.assertEquals(25, new Tres(new Copa()).sumarEnvido(new Dos(new Copa())));
		Assert.assertEquals(27, new Tres(new Copa()).sumarEnvido(new Cuatro(new Copa())));
		Assert.assertEquals(28, new Tres(new Copa()).sumarEnvido(new Cinco(new Copa())));
		Assert.assertEquals(29, new Tres(new Copa()).sumarEnvido(new Seis(new Copa())));
		Assert.assertEquals(30, new Tres(new Copa()).sumarEnvido(new SieteFalso(new Copa())));
		Assert.assertEquals(23, new Tres(new Copa()).sumarEnvido(new Sota(new Copa())));
		Assert.assertEquals(23, new Tres(new Copa()).sumarEnvido(new Caballo(new Copa())));
		Assert.assertEquals(23, new Tres(new Copa()).sumarEnvido(new Rey(new Copa())));
		
		Assert.assertEquals(25, new Cuatro(new Copa()).sumarEnvido(new AnchoFalso(new Copa())));
		Assert.assertEquals(26, new Cuatro(new Copa()).sumarEnvido(new Dos(new Copa())));
		Assert.assertEquals(27, new Cuatro(new Copa()).sumarEnvido(new Tres(new Copa())));
		Assert.assertEquals(29, new Cuatro(new Copa()).sumarEnvido(new Cinco(new Copa())));
		Assert.assertEquals(30, new Cuatro(new Copa()).sumarEnvido(new Seis(new Copa())));
		Assert.assertEquals(31, new Cuatro(new Copa()).sumarEnvido(new SieteFalso(new Copa())));
		Assert.assertEquals(24, new Cuatro(new Copa()).sumarEnvido(new Sota(new Copa())));
		Assert.assertEquals(24, new Cuatro(new Copa()).sumarEnvido(new Caballo(new Copa())));
		Assert.assertEquals(24, new Cuatro(new Copa()).sumarEnvido(new Rey(new Copa())));
		
		Assert.assertEquals(26, new Cinco(new Copa()).sumarEnvido(new AnchoFalso(new Copa())));
		Assert.assertEquals(27, new Cinco(new Copa()).sumarEnvido(new Dos(new Copa())));
		Assert.assertEquals(28, new Cinco(new Copa()).sumarEnvido(new Tres(new Copa())));
		Assert.assertEquals(29, new Cinco(new Copa()).sumarEnvido(new Cuatro(new Copa())));
		Assert.assertEquals(31, new Cinco(new Copa()).sumarEnvido(new Seis(new Copa())));
		Assert.assertEquals(32, new Cinco(new Copa()).sumarEnvido(new SieteFalso(new Copa())));
		Assert.assertEquals(25, new Cinco(new Copa()).sumarEnvido(new Sota(new Copa())));
		Assert.assertEquals(25, new Cinco(new Copa()).sumarEnvido(new Caballo(new Copa())));
		Assert.assertEquals(25, new Cinco(new Copa()).sumarEnvido(new Rey(new Copa())));
		
		Assert.assertEquals(27, new Seis(new Copa()).sumarEnvido(new AnchoFalso(new Copa())));
		Assert.assertEquals(28, new Seis(new Copa()).sumarEnvido(new Dos(new Copa())));
		Assert.assertEquals(29, new Seis(new Copa()).sumarEnvido(new Tres(new Copa())));
		Assert.assertEquals(30, new Seis(new Copa()).sumarEnvido(new Cuatro(new Copa())));
		Assert.assertEquals(31, new Seis(new Copa()).sumarEnvido(new Cinco(new Copa())));
		Assert.assertEquals(33, new Seis(new Copa()).sumarEnvido(new SieteFalso(new Copa())));
		Assert.assertEquals(26, new Seis(new Copa()).sumarEnvido(new Sota(new Copa())));
		Assert.assertEquals(26, new Seis(new Copa()).sumarEnvido(new Caballo(new Copa())));
		Assert.assertEquals(26, new Seis(new Copa()).sumarEnvido(new Rey(new Copa())));
		
		Assert.assertEquals(28, new SieteFalso(new Copa()).sumarEnvido(new AnchoFalso(new Copa())));
		Assert.assertEquals(29, new SieteFalso(new Copa()).sumarEnvido(new Dos(new Copa())));
		Assert.assertEquals(30, new SieteFalso(new Copa()).sumarEnvido(new Tres(new Copa())));
		Assert.assertEquals(31, new SieteFalso(new Copa()).sumarEnvido(new Cuatro(new Copa())));
		Assert.assertEquals(32, new SieteFalso(new Copa()).sumarEnvido(new Cinco(new Copa())));
		Assert.assertEquals(33, new SieteFalso(new Copa()).sumarEnvido(new Seis(new Copa())));
		Assert.assertEquals(27, new SieteFalso(new Copa()).sumarEnvido(new Sota(new Copa())));
		Assert.assertEquals(27, new SieteFalso(new Copa()).sumarEnvido(new Caballo(new Copa())));
		Assert.assertEquals(27, new SieteFalso(new Copa()).sumarEnvido(new Rey(new Copa())));
		
		Assert.assertEquals(21, new Sota(new Copa()).sumarEnvido(new AnchoFalso(new Copa())));
		Assert.assertEquals(22, new Sota(new Copa()).sumarEnvido(new Dos(new Copa())));
		Assert.assertEquals(23, new Sota(new Copa()).sumarEnvido(new Tres(new Copa())));
		Assert.assertEquals(24, new Sota(new Copa()).sumarEnvido(new Cuatro(new Copa())));
		Assert.assertEquals(25, new Sota(new Copa()).sumarEnvido(new Cinco(new Copa())));
		Assert.assertEquals(26, new Sota(new Copa()).sumarEnvido(new Seis(new Copa())));
		Assert.assertEquals(27, new Sota(new Copa()).sumarEnvido(new SieteFalso(new Copa())));
		Assert.assertEquals(20, new Sota(new Copa()).sumarEnvido(new Caballo(new Copa())));
		Assert.assertEquals(20, new Sota(new Copa()).sumarEnvido(new Rey(new Copa())));
		
		Assert.assertEquals(21, new Caballo(new Copa()).sumarEnvido(new AnchoFalso(new Copa())));
		Assert.assertEquals(22, new Caballo(new Copa()).sumarEnvido(new Dos(new Copa())));
		Assert.assertEquals(23, new Caballo(new Copa()).sumarEnvido(new Tres(new Copa())));
		Assert.assertEquals(24, new Caballo(new Copa()).sumarEnvido(new Cuatro(new Copa())));
		Assert.assertEquals(25, new Caballo(new Copa()).sumarEnvido(new Cinco(new Copa())));
		Assert.assertEquals(26, new Caballo(new Copa()).sumarEnvido(new Seis(new Copa())));
		Assert.assertEquals(27, new Caballo(new Copa()).sumarEnvido(new SieteFalso(new Copa())));
		Assert.assertEquals(20, new Caballo(new Copa()).sumarEnvido(new Sota(new Copa())));
		Assert.assertEquals(20, new Caballo(new Copa()).sumarEnvido(new Rey(new Copa())));
		
		Assert.assertEquals(21, new Rey(new Copa()).sumarEnvido(new AnchoFalso(new Copa())));
		Assert.assertEquals(22, new Rey(new Copa()).sumarEnvido(new Dos(new Copa())));
		Assert.assertEquals(23, new Rey(new Copa()).sumarEnvido(new Tres(new Copa())));
		Assert.assertEquals(24, new Rey(new Copa()).sumarEnvido(new Cuatro(new Copa())));
		Assert.assertEquals(25, new Rey(new Copa()).sumarEnvido(new Cinco(new Copa())));
		Assert.assertEquals(26, new Rey(new Copa()).sumarEnvido(new Seis(new Copa())));
		Assert.assertEquals(27, new Rey(new Copa()).sumarEnvido(new SieteFalso(new Copa())));
		Assert.assertEquals(20, new Rey(new Copa()).sumarEnvido(new Sota(new Copa())));
		Assert.assertEquals(20, new Rey(new Copa()).sumarEnvido(new Caballo(new Copa())));
	}
	
	@Test
	public void pruebaSumarEnvidoDeTodosLosAnchos(){
		Assert.assertEquals(2, new AnchoFalso(new Oro()).sumarEnvido(new Dos(new Espada())));
		Assert.assertEquals(3, new AnchoFalso(new Oro()).sumarEnvido(new Tres(new Espada())));
		Assert.assertEquals(4, new AnchoFalso(new Oro()).sumarEnvido(new Cuatro(new Espada())));
		Assert.assertEquals(5, new AnchoFalso(new Oro()).sumarEnvido(new Cinco(new Espada())));
		Assert.assertEquals(6, new AnchoFalso(new Oro()).sumarEnvido(new Seis(new Espada())));
		Assert.assertEquals(7, new AnchoFalso(new Oro()).sumarEnvido(new SieteDeEspada()));
		Assert.assertEquals(1, new AnchoFalso(new Oro()).sumarEnvido(new Sota(new Espada())));
		Assert.assertEquals(1, new AnchoFalso(new Oro()).sumarEnvido(new Caballo(new Espada())));
		Assert.assertEquals(1, new AnchoFalso(new Oro()).sumarEnvido(new Rey(new Espada())));

		Assert.assertEquals(2, new AnchoFalso(new Copa()).sumarEnvido(new Dos(new Basto())));
		Assert.assertEquals(3, new AnchoFalso(new Copa()).sumarEnvido(new Tres(new Basto())));
		Assert.assertEquals(4, new AnchoFalso(new Copa()).sumarEnvido(new Cuatro(new Basto())));
		Assert.assertEquals(5, new AnchoFalso(new Copa()).sumarEnvido(new Cinco(new Basto())));
		Assert.assertEquals(6, new AnchoFalso(new Copa()).sumarEnvido(new Seis(new Basto())));
		Assert.assertEquals(7, new AnchoFalso(new Copa()).sumarEnvido(new SieteFalso(new Basto())));
		Assert.assertEquals(1, new AnchoFalso(new Copa()).sumarEnvido(new Sota(new Basto())));
		Assert.assertEquals(1, new AnchoFalso(new Copa()).sumarEnvido(new Caballo(new Basto())));
		Assert.assertEquals(1, new AnchoFalso(new Copa()).sumarEnvido(new Rey(new Basto())));

		Assert.assertEquals(2, new AnchoDeBasto().sumarEnvido(new Dos(new Copa())));
		Assert.assertEquals(3, new AnchoDeBasto().sumarEnvido(new Tres(new Copa())));
		Assert.assertEquals(4, new AnchoDeBasto().sumarEnvido(new Cuatro(new Copa())));
		Assert.assertEquals(5, new AnchoDeBasto().sumarEnvido(new Cinco(new Copa())));
		Assert.assertEquals(6, new AnchoDeBasto().sumarEnvido(new Seis(new Copa())));
		Assert.assertEquals(7, new AnchoDeBasto().sumarEnvido(new SieteFalso(new Copa())));
		Assert.assertEquals(1, new AnchoDeBasto().sumarEnvido(new Sota(new Copa())));
		Assert.assertEquals(1, new AnchoDeBasto().sumarEnvido(new Caballo(new Copa())));
		Assert.assertEquals(1, new AnchoDeBasto().sumarEnvido(new Rey(new Copa())));
	}
	
	@Test
	public void pruebaSumarEnvidoVariosDos(){
		Assert.assertEquals(2, new Dos(new Oro()).sumarEnvido(new Dos(new Espada())));
		Assert.assertEquals(3, new Dos(new Oro()).sumarEnvido(new Tres(new Espada())));
		Assert.assertEquals(4, new Dos(new Oro()).sumarEnvido(new Cuatro(new Espada())));
		Assert.assertEquals(5, new Dos(new Oro()).sumarEnvido(new Cinco(new Espada())));
		Assert.assertEquals(6, new Dos(new Oro()).sumarEnvido(new Seis(new Espada())));
		Assert.assertEquals(7, new Dos(new Oro()).sumarEnvido(new SieteDeEspada()));
		Assert.assertEquals(2, new Dos(new Oro()).sumarEnvido(new Sota(new Espada())));
		Assert.assertEquals(2, new Dos(new Oro()).sumarEnvido(new Caballo(new Espada())));
		Assert.assertEquals(2, new Dos(new Oro()).sumarEnvido(new Rey(new Espada())));

		Assert.assertEquals(2, new Dos(new Copa()).sumarEnvido(new Dos(new Espada())));
		Assert.assertEquals(3, new Dos(new Copa()).sumarEnvido(new Tres(new Espada())));
		Assert.assertEquals(4, new Dos(new Copa()).sumarEnvido(new Cuatro(new Espada())));
		Assert.assertEquals(5, new Dos(new Copa()).sumarEnvido(new Cinco(new Espada())));
		Assert.assertEquals(6, new Dos(new Copa()).sumarEnvido(new Seis(new Espada())));
		Assert.assertEquals(7, new Dos(new Copa()).sumarEnvido(new SieteDeEspada()));
		Assert.assertEquals(2, new Dos(new Copa()).sumarEnvido(new Sota(new Espada())));
		Assert.assertEquals(2, new Dos(new Copa()).sumarEnvido(new Caballo(new Espada())));
		Assert.assertEquals(2, new Dos(new Copa()).sumarEnvido(new Rey(new Espada())));

		Assert.assertEquals(2, new Dos(new Basto()).sumarEnvido(new Dos(new Espada())));
		Assert.assertEquals(3, new Dos(new Basto()).sumarEnvido(new Tres(new Espada())));
		Assert.assertEquals(4, new Dos(new Basto()).sumarEnvido(new Cuatro(new Espada())));
		Assert.assertEquals(5, new Dos(new Basto()).sumarEnvido(new Cinco(new Espada())));
		Assert.assertEquals(6, new Dos(new Basto()).sumarEnvido(new Seis(new Espada())));
		Assert.assertEquals(7, new Dos(new Basto()).sumarEnvido(new SieteDeEspada()));
		Assert.assertEquals(2, new Dos(new Basto()).sumarEnvido(new Sota(new Espada())));
		Assert.assertEquals(2, new Dos(new Basto()).sumarEnvido(new Caballo(new Espada())));
		Assert.assertEquals(2, new Dos(new Basto()).sumarEnvido(new Rey(new Espada())));
	}
	
	@Test
	public void pruebaSumarEnvidoVariosTres(){
		Assert.assertEquals(3, new Tres(new Oro()).sumarEnvido(new Dos(new Espada())));
		Assert.assertEquals(3, new Tres(new Oro()).sumarEnvido(new Tres(new Espada())));
		Assert.assertEquals(4, new Tres(new Oro()).sumarEnvido(new Cuatro(new Espada())));
		Assert.assertEquals(5, new Tres(new Oro()).sumarEnvido(new Cinco(new Espada())));
		Assert.assertEquals(6, new Tres(new Oro()).sumarEnvido(new Seis(new Espada())));
		Assert.assertEquals(7, new Tres(new Oro()).sumarEnvido(new SieteDeEspada()));
		Assert.assertEquals(3, new Tres(new Oro()).sumarEnvido(new Sota(new Espada())));
		Assert.assertEquals(3, new Tres(new Oro()).sumarEnvido(new Caballo(new Espada())));
		Assert.assertEquals(3, new Tres(new Oro()).sumarEnvido(new Rey(new Espada())));

		Assert.assertEquals(3, new Tres(new Copa()).sumarEnvido(new Dos(new Espada())));
		Assert.assertEquals(3, new Tres(new Copa()).sumarEnvido(new Tres(new Espada())));
		Assert.assertEquals(4, new Tres(new Copa()).sumarEnvido(new Cuatro(new Espada())));
		Assert.assertEquals(5, new Tres(new Copa()).sumarEnvido(new Cinco(new Espada())));
		Assert.assertEquals(6, new Tres(new Copa()).sumarEnvido(new Seis(new Espada())));
		Assert.assertEquals(7, new Tres(new Copa()).sumarEnvido(new SieteDeEspada()));
		Assert.assertEquals(3, new Tres(new Copa()).sumarEnvido(new Sota(new Espada())));
		Assert.assertEquals(3, new Tres(new Copa()).sumarEnvido(new Caballo(new Espada())));
		Assert.assertEquals(3, new Tres(new Copa()).sumarEnvido(new Rey(new Espada())));

		Assert.assertEquals(3, new Tres(new Basto()).sumarEnvido(new Dos(new Espada())));
		Assert.assertEquals(3, new Tres(new Basto()).sumarEnvido(new Tres(new Espada())));
		Assert.assertEquals(4, new Tres(new Basto()).sumarEnvido(new Cuatro(new Espada())));
		Assert.assertEquals(5, new Tres(new Basto()).sumarEnvido(new Cinco(new Espada())));
		Assert.assertEquals(6, new Tres(new Basto()).sumarEnvido(new Seis(new Espada())));
		Assert.assertEquals(7, new Tres(new Basto()).sumarEnvido(new SieteDeEspada()));
		Assert.assertEquals(3, new Tres(new Basto()).sumarEnvido(new Sota(new Espada())));
		Assert.assertEquals(3, new Tres(new Basto()).sumarEnvido(new Caballo(new Espada())));
		Assert.assertEquals(3, new Tres(new Basto()).sumarEnvido(new Rey(new Espada())));
	}
	
	@Test
	public void pruebasSumarEnvidoVariosCuatro(){
		Assert.assertEquals(4, new Cuatro(new Oro()).sumarEnvido(new Dos(new Espada())));
		Assert.assertEquals(4, new Cuatro(new Oro()).sumarEnvido(new Tres(new Espada())));
		Assert.assertEquals(4, new Cuatro(new Oro()).sumarEnvido(new Cuatro(new Espada())));
		Assert.assertEquals(5, new Cuatro(new Oro()).sumarEnvido(new Cinco(new Espada())));
		Assert.assertEquals(6, new Cuatro(new Oro()).sumarEnvido(new Seis(new Espada())));
		Assert.assertEquals(7, new Cuatro(new Oro()).sumarEnvido(new SieteDeEspada()));
		Assert.assertEquals(4, new Cuatro(new Oro()).sumarEnvido(new Sota(new Espada())));
		Assert.assertEquals(4, new Cuatro(new Oro()).sumarEnvido(new Caballo(new Espada())));
		Assert.assertEquals(4, new Cuatro(new Oro()).sumarEnvido(new Rey(new Espada())));

		Assert.assertEquals(4, new Cuatro(new Copa()).sumarEnvido(new Dos(new Espada())));
		Assert.assertEquals(4, new Cuatro(new Copa()).sumarEnvido(new Tres(new Espada())));
		Assert.assertEquals(4, new Cuatro(new Copa()).sumarEnvido(new Cuatro(new Espada())));
		Assert.assertEquals(5, new Cuatro(new Copa()).sumarEnvido(new Cinco(new Espada())));
		Assert.assertEquals(6, new Cuatro(new Copa()).sumarEnvido(new Seis(new Espada())));
		Assert.assertEquals(7, new Cuatro(new Copa()).sumarEnvido(new SieteDeEspada()));
		Assert.assertEquals(4, new Cuatro(new Copa()).sumarEnvido(new Sota(new Espada())));
		Assert.assertEquals(4, new Cuatro(new Copa()).sumarEnvido(new Caballo(new Espada())));
		Assert.assertEquals(4, new Cuatro(new Copa()).sumarEnvido(new Rey(new Espada())));

		Assert.assertEquals(4, new Cuatro(new Basto()).sumarEnvido(new Dos(new Espada())));
		Assert.assertEquals(4, new Cuatro(new Basto()).sumarEnvido(new Tres(new Espada())));
		Assert.assertEquals(4, new Cuatro(new Basto()).sumarEnvido(new Cuatro(new Espada())));
		Assert.assertEquals(5, new Cuatro(new Basto()).sumarEnvido(new Cinco(new Espada())));
		Assert.assertEquals(6, new Cuatro(new Basto()).sumarEnvido(new Seis(new Espada())));
		Assert.assertEquals(7, new Cuatro(new Basto()).sumarEnvido(new SieteDeEspada()));
		Assert.assertEquals(4, new Cuatro(new Basto()).sumarEnvido(new Sota(new Espada())));
		Assert.assertEquals(4, new Cuatro(new Basto()).sumarEnvido(new Caballo(new Espada())));
		Assert.assertEquals(4, new Cuatro(new Basto()).sumarEnvido(new Rey(new Espada())));
	}
	
	@Test
	public void purebasSumarEnvidoVariosCinco(){
		Assert.assertEquals(5, new Cinco(new Oro()).sumarEnvido(new Dos(new Espada())));
		Assert.assertEquals(5, new Cinco(new Oro()).sumarEnvido(new Tres(new Espada())));
		Assert.assertEquals(5, new Cinco(new Oro()).sumarEnvido(new Cuatro(new Espada())));
		Assert.assertEquals(5, new Cinco(new Oro()).sumarEnvido(new Cinco(new Espada())));
		Assert.assertEquals(6, new Cinco(new Oro()).sumarEnvido(new Seis(new Espada())));
		Assert.assertEquals(7, new Cinco(new Oro()).sumarEnvido(new SieteDeEspada()));
		Assert.assertEquals(5, new Cinco(new Oro()).sumarEnvido(new Sota(new Espada())));
		Assert.assertEquals(5, new Cinco(new Oro()).sumarEnvido(new Caballo(new Espada())));
		Assert.assertEquals(5, new Cinco(new Oro()).sumarEnvido(new Rey(new Espada())));

		Assert.assertEquals(5, new Cinco(new Copa()).sumarEnvido(new Dos(new Espada())));
		Assert.assertEquals(5, new Cinco(new Copa()).sumarEnvido(new Tres(new Espada())));
		Assert.assertEquals(5, new Cinco(new Copa()).sumarEnvido(new Cuatro(new Espada())));
		Assert.assertEquals(5, new Cinco(new Copa()).sumarEnvido(new Cinco(new Espada())));
		Assert.assertEquals(6, new Cinco(new Copa()).sumarEnvido(new Seis(new Espada())));
		Assert.assertEquals(7, new Cinco(new Copa()).sumarEnvido(new SieteDeEspada()));
		Assert.assertEquals(5, new Cinco(new Copa()).sumarEnvido(new Sota(new Espada())));
		Assert.assertEquals(5, new Cinco(new Copa()).sumarEnvido(new Caballo(new Espada())));
		Assert.assertEquals(5, new Cinco(new Copa()).sumarEnvido(new Rey(new Espada())));

		Assert.assertEquals(5, new Cinco(new Basto()).sumarEnvido(new Dos(new Espada())));
		Assert.assertEquals(5, new Cinco(new Basto()).sumarEnvido(new Tres(new Espada())));
		Assert.assertEquals(5, new Cinco(new Basto()).sumarEnvido(new Cuatro(new Espada())));
		Assert.assertEquals(5, new Cinco(new Basto()).sumarEnvido(new Cinco(new Espada())));
		Assert.assertEquals(6, new Cinco(new Basto()).sumarEnvido(new Seis(new Espada())));
		Assert.assertEquals(7, new Cinco(new Basto()).sumarEnvido(new SieteDeEspada()));
		Assert.assertEquals(5, new Cinco(new Basto()).sumarEnvido(new Sota(new Espada())));
		Assert.assertEquals(5, new Cinco(new Basto()).sumarEnvido(new Caballo(new Espada())));
		Assert.assertEquals(5, new Cinco(new Basto()).sumarEnvido(new Rey(new Espada())));
	}
	
	@Test
	public void purebasSumarEnvidoVariosSeis(){
		Assert.assertEquals(6, new Seis(new Oro()).sumarEnvido(new Dos(new Espada())));
		Assert.assertEquals(6, new Seis(new Oro()).sumarEnvido(new Tres(new Espada())));
		Assert.assertEquals(6, new Seis(new Oro()).sumarEnvido(new Cuatro(new Espada())));
		Assert.assertEquals(6, new Seis(new Oro()).sumarEnvido(new Cinco(new Espada())));
		Assert.assertEquals(6, new Seis(new Oro()).sumarEnvido(new Seis(new Espada())));
		Assert.assertEquals(7, new Seis(new Oro()).sumarEnvido(new SieteDeEspada()));
		Assert.assertEquals(6, new Seis(new Oro()).sumarEnvido(new Sota(new Espada())));
		Assert.assertEquals(6, new Seis(new Oro()).sumarEnvido(new Caballo(new Espada())));
		Assert.assertEquals(6, new Seis(new Oro()).sumarEnvido(new Rey(new Espada())));

		Assert.assertEquals(6, new Seis(new Copa()).sumarEnvido(new Dos(new Espada())));
		Assert.assertEquals(6, new Seis(new Copa()).sumarEnvido(new Tres(new Espada())));
		Assert.assertEquals(6, new Seis(new Copa()).sumarEnvido(new Cuatro(new Espada())));
		Assert.assertEquals(6, new Seis(new Copa()).sumarEnvido(new Cinco(new Espada())));
		Assert.assertEquals(6, new Seis(new Copa()).sumarEnvido(new Seis(new Espada())));
		Assert.assertEquals(7, new Seis(new Copa()).sumarEnvido(new SieteDeEspada()));
		Assert.assertEquals(6, new Seis(new Copa()).sumarEnvido(new Sota(new Espada())));
		Assert.assertEquals(6, new Seis(new Copa()).sumarEnvido(new Caballo(new Espada())));
		Assert.assertEquals(6, new Seis(new Copa()).sumarEnvido(new Rey(new Espada())));

		Assert.assertEquals(6, new Seis(new Basto()).sumarEnvido(new Dos(new Espada())));
		Assert.assertEquals(6, new Seis(new Basto()).sumarEnvido(new Tres(new Espada())));
		Assert.assertEquals(6, new Seis(new Basto()).sumarEnvido(new Cuatro(new Espada())));
		Assert.assertEquals(6, new Seis(new Basto()).sumarEnvido(new Cinco(new Espada())));
		Assert.assertEquals(6, new Seis(new Basto()).sumarEnvido(new Seis(new Espada())));
		Assert.assertEquals(7, new Seis(new Basto()).sumarEnvido(new SieteDeEspada()));
		Assert.assertEquals(6, new Seis(new Basto()).sumarEnvido(new Sota(new Espada())));
		Assert.assertEquals(6, new Seis(new Basto()).sumarEnvido(new Caballo(new Espada())));
		Assert.assertEquals(6, new Seis(new Basto()).sumarEnvido(new Rey(new Espada())));
	}
	
	@Test
	public void purebasSumarEnvidoVariosSiete(){
		Assert.assertEquals(7, new SieteDeOro().sumarEnvido(new Dos(new Espada())));
		Assert.assertEquals(7, new SieteDeOro().sumarEnvido(new Tres(new Espada())));
		Assert.assertEquals(7, new SieteDeOro().sumarEnvido(new Cuatro(new Espada())));
		Assert.assertEquals(7, new SieteDeOro().sumarEnvido(new Cinco(new Espada())));
		Assert.assertEquals(7, new SieteDeOro().sumarEnvido(new Seis(new Espada())));
		Assert.assertEquals(7, new SieteDeOro().sumarEnvido(new SieteDeEspada()));
		Assert.assertEquals(7, new SieteDeOro().sumarEnvido(new Sota(new Espada())));
		Assert.assertEquals(7, new SieteDeOro().sumarEnvido(new Caballo(new Espada())));
		Assert.assertEquals(7, new SieteDeOro().sumarEnvido(new Rey(new Espada())));

		Assert.assertEquals(7, new SieteFalso(new Copa()).sumarEnvido(new Dos(new Espada())));
		Assert.assertEquals(7, new SieteFalso(new Copa()).sumarEnvido(new Tres(new Espada())));
		Assert.assertEquals(7, new SieteFalso(new Copa()).sumarEnvido(new Cuatro(new Espada())));
		Assert.assertEquals(7, new SieteFalso(new Copa()).sumarEnvido(new Cinco(new Espada())));
		Assert.assertEquals(7, new SieteFalso(new Copa()).sumarEnvido(new Seis(new Espada())));
		Assert.assertEquals(7, new SieteFalso(new Copa()).sumarEnvido(new SieteDeEspada()));
		Assert.assertEquals(7, new SieteFalso(new Copa()).sumarEnvido(new Sota(new Espada())));
		Assert.assertEquals(7, new SieteFalso(new Copa()).sumarEnvido(new Caballo(new Espada())));
		Assert.assertEquals(7, new SieteFalso(new Copa()).sumarEnvido(new Rey(new Espada())));

		Assert.assertEquals(7, new SieteFalso(new Basto()).sumarEnvido(new Dos(new Espada())));
		Assert.assertEquals(7, new SieteFalso(new Basto()).sumarEnvido(new Tres(new Espada())));
		Assert.assertEquals(7, new SieteFalso(new Basto()).sumarEnvido(new Cuatro(new Espada())));
		Assert.assertEquals(7, new SieteFalso(new Basto()).sumarEnvido(new Cinco(new Espada())));
		Assert.assertEquals(7, new SieteFalso(new Basto()).sumarEnvido(new Seis(new Espada())));
		Assert.assertEquals(7, new SieteFalso(new Basto()).sumarEnvido(new SieteDeEspada()));
		Assert.assertEquals(7, new SieteFalso(new Basto()).sumarEnvido(new Sota(new Espada())));
		Assert.assertEquals(7, new SieteFalso(new Basto()).sumarEnvido(new Caballo(new Espada())));
		Assert.assertEquals(7, new SieteFalso(new Basto()).sumarEnvido(new Rey(new Espada())));
	}
	
	@Test
	public void purebasSumarEnvidoVariosSotas(){
		Assert.assertEquals(2, new Sota(new Oro()).sumarEnvido(new Dos(new Espada())));
		Assert.assertEquals(3, new Sota(new Oro()).sumarEnvido(new Tres(new Espada())));
		Assert.assertEquals(4, new Sota(new Oro()).sumarEnvido(new Cuatro(new Espada())));
		Assert.assertEquals(5, new Sota(new Oro()).sumarEnvido(new Cinco(new Espada())));
		Assert.assertEquals(6, new Sota(new Oro()).sumarEnvido(new Seis(new Espada())));
		Assert.assertEquals(7, new Sota(new Oro()).sumarEnvido(new SieteDeEspada()));
		Assert.assertEquals(0, new Sota(new Oro()).sumarEnvido(new Sota(new Espada())));
		Assert.assertEquals(0, new Sota(new Oro()).sumarEnvido(new Caballo(new Espada())));
		Assert.assertEquals(0, new Sota(new Oro()).sumarEnvido(new Rey(new Espada())));

		Assert.assertEquals(2, new Sota(new Copa()).sumarEnvido(new Dos(new Espada())));
		Assert.assertEquals(3, new Sota(new Copa()).sumarEnvido(new Tres(new Espada())));
		Assert.assertEquals(4, new Sota(new Copa()).sumarEnvido(new Cuatro(new Espada())));
		Assert.assertEquals(5, new Sota(new Copa()).sumarEnvido(new Cinco(new Espada())));
		Assert.assertEquals(6, new Sota(new Copa()).sumarEnvido(new Seis(new Espada())));
		Assert.assertEquals(7, new Sota(new Copa()).sumarEnvido(new SieteDeEspada()));
		Assert.assertEquals(0, new Sota(new Copa()).sumarEnvido(new Sota(new Espada())));
		Assert.assertEquals(0, new Sota(new Copa()).sumarEnvido(new Caballo(new Espada())));
		Assert.assertEquals(0, new Sota(new Copa()).sumarEnvido(new Rey(new Espada())));

		Assert.assertEquals(2, new Sota(new Basto()).sumarEnvido(new Dos(new Espada())));
		Assert.assertEquals(3, new Sota(new Basto()).sumarEnvido(new Tres(new Espada())));
		Assert.assertEquals(4, new Sota(new Basto()).sumarEnvido(new Cuatro(new Espada())));
		Assert.assertEquals(5, new Sota(new Basto()).sumarEnvido(new Cinco(new Espada())));
		Assert.assertEquals(6, new Sota(new Basto()).sumarEnvido(new Seis(new Espada())));
		Assert.assertEquals(7, new Sota(new Basto()).sumarEnvido(new SieteDeEspada()));
		Assert.assertEquals(0, new Sota(new Basto()).sumarEnvido(new Sota(new Espada())));
		Assert.assertEquals(0, new Sota(new Basto()).sumarEnvido(new Caballo(new Espada())));
		Assert.assertEquals(0, new Sota(new Basto()).sumarEnvido(new Rey(new Espada())));
	}
	
	@Test
	public void purebasSumarEnvidoVariosCaballos(){
		Assert.assertEquals(2, new Caballo(new Oro()).sumarEnvido(new Dos(new Espada())));
		Assert.assertEquals(3, new Caballo(new Oro()).sumarEnvido(new Tres(new Espada())));
		Assert.assertEquals(4, new Caballo(new Oro()).sumarEnvido(new Cuatro(new Espada())));
		Assert.assertEquals(5, new Caballo(new Oro()).sumarEnvido(new Cinco(new Espada())));
		Assert.assertEquals(6, new Caballo(new Oro()).sumarEnvido(new Seis(new Espada())));
		Assert.assertEquals(7, new Caballo(new Oro()).sumarEnvido(new SieteDeEspada()));
		Assert.assertEquals(0, new Caballo(new Oro()).sumarEnvido(new Sota(new Espada())));
		Assert.assertEquals(0, new Caballo(new Oro()).sumarEnvido(new Caballo(new Espada())));
		Assert.assertEquals(0, new Caballo(new Oro()).sumarEnvido(new Rey(new Espada())));

		Assert.assertEquals(2, new Caballo(new Copa()).sumarEnvido(new Dos(new Espada())));
		Assert.assertEquals(3, new Caballo(new Copa()).sumarEnvido(new Tres(new Espada())));
		Assert.assertEquals(4, new Caballo(new Copa()).sumarEnvido(new Cuatro(new Espada())));
		Assert.assertEquals(5, new Caballo(new Copa()).sumarEnvido(new Cinco(new Espada())));
		Assert.assertEquals(6, new Caballo(new Copa()).sumarEnvido(new Seis(new Espada())));
		Assert.assertEquals(7, new Caballo(new Copa()).sumarEnvido(new SieteDeEspada()));
		Assert.assertEquals(0, new Caballo(new Copa()).sumarEnvido(new Sota(new Espada())));
		Assert.assertEquals(0, new Caballo(new Copa()).sumarEnvido(new Caballo(new Espada())));
		Assert.assertEquals(0, new Caballo(new Copa()).sumarEnvido(new Rey(new Espada())));

		Assert.assertEquals(2, new Caballo(new Basto()).sumarEnvido(new Dos(new Espada())));
		Assert.assertEquals(3, new Caballo(new Basto()).sumarEnvido(new Tres(new Espada())));
		Assert.assertEquals(4, new Caballo(new Basto()).sumarEnvido(new Cuatro(new Espada())));
		Assert.assertEquals(5, new Caballo(new Basto()).sumarEnvido(new Cinco(new Espada())));
		Assert.assertEquals(6, new Caballo(new Basto()).sumarEnvido(new Seis(new Espada())));
		Assert.assertEquals(7, new Caballo(new Basto()).sumarEnvido(new SieteDeEspada()));
		Assert.assertEquals(0, new Caballo(new Basto()).sumarEnvido(new Sota(new Espada())));
		Assert.assertEquals(0, new Caballo(new Basto()).sumarEnvido(new Caballo(new Espada())));
		Assert.assertEquals(0, new Caballo(new Basto()).sumarEnvido(new Rey(new Espada())));
	}
	
	@Test
	public void purebasSumarEnvidoVariosReyes(){
		Assert.assertEquals(2, new Rey(new Oro()).sumarEnvido(new Dos(new Espada())));
		Assert.assertEquals(3, new Rey(new Oro()).sumarEnvido(new Tres(new Espada())));
		Assert.assertEquals(4, new Rey(new Oro()).sumarEnvido(new Cuatro(new Espada())));
		Assert.assertEquals(5, new Rey(new Oro()).sumarEnvido(new Cinco(new Espada())));
		Assert.assertEquals(6, new Rey(new Oro()).sumarEnvido(new Seis(new Espada())));
		Assert.assertEquals(7, new Rey(new Oro()).sumarEnvido(new SieteDeEspada()));
		Assert.assertEquals(0, new Rey(new Oro()).sumarEnvido(new Sota(new Espada())));
		Assert.assertEquals(0, new Rey(new Oro()).sumarEnvido(new Caballo(new Espada())));
		Assert.assertEquals(0, new Rey(new Oro()).sumarEnvido(new Rey(new Espada())));

		Assert.assertEquals(2, new Rey(new Copa()).sumarEnvido(new Dos(new Espada())));
		Assert.assertEquals(3, new Rey(new Copa()).sumarEnvido(new Tres(new Espada())));
		Assert.assertEquals(4, new Rey(new Copa()).sumarEnvido(new Cuatro(new Espada())));
		Assert.assertEquals(5, new Rey(new Copa()).sumarEnvido(new Cinco(new Espada())));
		Assert.assertEquals(6, new Rey(new Copa()).sumarEnvido(new Seis(new Espada())));
		Assert.assertEquals(7, new Rey(new Copa()).sumarEnvido(new SieteDeEspada()));
		Assert.assertEquals(0, new Rey(new Copa()).sumarEnvido(new Sota(new Espada())));
		Assert.assertEquals(0, new Rey(new Copa()).sumarEnvido(new Caballo(new Espada())));
		Assert.assertEquals(0, new Rey(new Copa()).sumarEnvido(new Rey(new Espada())));

		Assert.assertEquals(2, new Rey(new Basto()).sumarEnvido(new Dos(new Espada())));
		Assert.assertEquals(3, new Rey(new Basto()).sumarEnvido(new Tres(new Espada())));
		Assert.assertEquals(4, new Rey(new Basto()).sumarEnvido(new Cuatro(new Espada())));
		Assert.assertEquals(5, new Rey(new Basto()).sumarEnvido(new Cinco(new Espada())));
		Assert.assertEquals(6, new Rey(new Basto()).sumarEnvido(new Seis(new Espada())));
		Assert.assertEquals(7, new Rey(new Basto()).sumarEnvido(new SieteDeEspada()));
		Assert.assertEquals(0, new Rey(new Basto()).sumarEnvido(new Sota(new Espada())));
		Assert.assertEquals(0, new Rey(new Basto()).sumarEnvido(new Caballo(new Espada())));
		Assert.assertEquals(0, new Rey(new Basto()).sumarEnvido(new Rey(new Espada())));
	}

	@Test
	public void purebasSumarEnvidoVariasCombinaciones(){
		Assert.assertEquals(2, new Dos(new Basto()).sumarEnvido(new Dos(new Copa())));
		Assert.assertEquals(3, new Dos(new Basto()).sumarEnvido(new Tres(new Copa())));
		Assert.assertEquals(4, new Dos(new Basto()).sumarEnvido(new Cuatro(new Copa())));
		Assert.assertEquals(5, new Dos(new Basto()).sumarEnvido(new Cinco(new Copa())));
		Assert.assertEquals(6, new Dos(new Basto()).sumarEnvido(new Seis(new Copa())));
		Assert.assertEquals(7, new Dos(new Basto()).sumarEnvido(new SieteFalso(new Copa())));
		Assert.assertEquals(2, new Dos(new Basto()).sumarEnvido(new Sota(new Copa())));
		Assert.assertEquals(2, new Dos(new Basto()).sumarEnvido(new Caballo(new Copa())));
		Assert.assertEquals(2, new Dos(new Basto()).sumarEnvido(new Rey(new Copa())));

		Assert.assertEquals(2, new Dos(new Oro()).sumarEnvido(new Dos(new Copa())));
		Assert.assertEquals(3, new Dos(new Oro()).sumarEnvido(new Tres(new Copa())));
		Assert.assertEquals(4, new Dos(new Oro()).sumarEnvido(new Cuatro(new Copa())));
		Assert.assertEquals(5, new Dos(new Oro()).sumarEnvido(new Cinco(new Copa())));
		Assert.assertEquals(6, new Dos(new Oro()).sumarEnvido(new Seis(new Copa())));
		Assert.assertEquals(7, new Dos(new Oro()).sumarEnvido(new SieteFalso(new Copa())));
		Assert.assertEquals(2, new Dos(new Oro()).sumarEnvido(new Sota(new Copa())));
		Assert.assertEquals(2, new Dos(new Oro()).sumarEnvido(new Caballo(new Copa())));
		Assert.assertEquals(2, new Dos(new Oro()).sumarEnvido(new Rey(new Copa())));

		Assert.assertEquals(3, new Tres(new Basto()).sumarEnvido(new Dos(new Copa())));
		Assert.assertEquals(3, new Tres(new Basto()).sumarEnvido(new Tres(new Copa())));
		Assert.assertEquals(4, new Tres(new Basto()).sumarEnvido(new Cuatro(new Copa())));
		Assert.assertEquals(5, new Tres(new Basto()).sumarEnvido(new Cinco(new Copa())));
		Assert.assertEquals(6, new Tres(new Basto()).sumarEnvido(new Seis(new Copa())));
		Assert.assertEquals(7, new Tres(new Basto()).sumarEnvido(new SieteFalso(new Copa())));
		Assert.assertEquals(3, new Tres(new Basto()).sumarEnvido(new Sota(new Copa())));
		Assert.assertEquals(3, new Tres(new Basto()).sumarEnvido(new Caballo(new Copa())));
		Assert.assertEquals(3, new Tres(new Basto()).sumarEnvido(new Rey(new Copa())));

		Assert.assertEquals(3, new Tres(new Oro()).sumarEnvido(new Dos(new Copa())));
		Assert.assertEquals(3, new Tres(new Oro()).sumarEnvido(new Tres(new Copa())));
		Assert.assertEquals(4, new Tres(new Oro()).sumarEnvido(new Cuatro(new Copa())));
		Assert.assertEquals(5, new Tres(new Oro()).sumarEnvido(new Cinco(new Copa())));
		Assert.assertEquals(6, new Tres(new Oro()).sumarEnvido(new Seis(new Copa())));
		Assert.assertEquals(7, new Tres(new Oro()).sumarEnvido(new SieteFalso(new Copa())));
		Assert.assertEquals(3, new Tres(new Oro()).sumarEnvido(new Sota(new Copa())));
		Assert.assertEquals(3, new Tres(new Oro()).sumarEnvido(new Caballo(new Copa())));
		Assert.assertEquals(3, new Tres(new Oro()).sumarEnvido(new Rey(new Copa())));

		Assert.assertEquals(4, new Cuatro(new Basto()).sumarEnvido(new Dos(new Copa())));
		Assert.assertEquals(4, new Cuatro(new Basto()).sumarEnvido(new Tres(new Copa())));
		Assert.assertEquals(4, new Cuatro(new Basto()).sumarEnvido(new Cuatro(new Copa())));
		Assert.assertEquals(5, new Cuatro(new Basto()).sumarEnvido(new Cinco(new Copa())));
		Assert.assertEquals(6, new Cuatro(new Basto()).sumarEnvido(new Seis(new Copa())));
		Assert.assertEquals(7, new Cuatro(new Basto()).sumarEnvido(new SieteFalso(new Copa())));
		Assert.assertEquals(4, new Cuatro(new Basto()).sumarEnvido(new Sota(new Copa())));
		Assert.assertEquals(4, new Cuatro(new Basto()).sumarEnvido(new Caballo(new Copa())));
		Assert.assertEquals(4, new Cuatro(new Basto()).sumarEnvido(new Rey(new Copa())));

		Assert.assertEquals(4, new Cuatro(new Oro()).sumarEnvido(new Dos(new Copa())));
		Assert.assertEquals(4, new Cuatro(new Oro()).sumarEnvido(new Tres(new Copa())));
		Assert.assertEquals(4, new Cuatro(new Oro()).sumarEnvido(new Cuatro(new Copa())));
		Assert.assertEquals(5, new Cuatro(new Oro()).sumarEnvido(new Cinco(new Copa())));
		Assert.assertEquals(6, new Cuatro(new Oro()).sumarEnvido(new Seis(new Copa())));
		Assert.assertEquals(7, new Cuatro(new Oro()).sumarEnvido(new SieteFalso(new Copa())));
		Assert.assertEquals(4, new Cuatro(new Oro()).sumarEnvido(new Sota(new Copa())));
		Assert.assertEquals(4, new Cuatro(new Oro()).sumarEnvido(new Caballo(new Copa())));
		Assert.assertEquals(4, new Cuatro(new Oro()).sumarEnvido(new Rey(new Copa())));

		Assert.assertEquals(5, new Cinco(new Basto()).sumarEnvido(new Dos(new Copa())));
		Assert.assertEquals(5, new Cinco(new Basto()).sumarEnvido(new Tres(new Copa())));
		Assert.assertEquals(5, new Cinco(new Basto()).sumarEnvido(new Cuatro(new Copa())));
		Assert.assertEquals(5, new Cinco(new Basto()).sumarEnvido(new Cinco(new Copa())));
		Assert.assertEquals(6, new Cinco(new Basto()).sumarEnvido(new Seis(new Copa())));
		Assert.assertEquals(7, new Cinco(new Basto()).sumarEnvido(new SieteFalso(new Copa())));
		Assert.assertEquals(5, new Cinco(new Basto()).sumarEnvido(new Sota(new Copa())));
		Assert.assertEquals(5, new Cinco(new Basto()).sumarEnvido(new Caballo(new Copa())));
		Assert.assertEquals(5, new Cinco(new Basto()).sumarEnvido(new Rey(new Copa())));

		Assert.assertEquals(5, new Cinco(new Oro()).sumarEnvido(new Dos(new Copa())));
		Assert.assertEquals(5, new Cinco(new Oro()).sumarEnvido(new Tres(new Copa())));
		Assert.assertEquals(5, new Cinco(new Oro()).sumarEnvido(new Cuatro(new Copa())));
		Assert.assertEquals(5, new Cinco(new Oro()).sumarEnvido(new Cinco(new Copa())));
		Assert.assertEquals(6, new Cinco(new Oro()).sumarEnvido(new Seis(new Copa())));
		Assert.assertEquals(7, new Cinco(new Oro()).sumarEnvido(new SieteFalso(new Copa())));
		Assert.assertEquals(5, new Cinco(new Oro()).sumarEnvido(new Sota(new Copa())));
		Assert.assertEquals(5, new Cinco(new Oro()).sumarEnvido(new Caballo(new Copa())));
		Assert.assertEquals(5, new Cinco(new Oro()).sumarEnvido(new Rey(new Copa())));

		Assert.assertEquals(6, new Seis(new Basto()).sumarEnvido(new Dos(new Copa())));
		Assert.assertEquals(6, new Seis(new Basto()).sumarEnvido(new Tres(new Copa())));
		Assert.assertEquals(6, new Seis(new Basto()).sumarEnvido(new Cuatro(new Copa())));
		Assert.assertEquals(6, new Seis(new Basto()).sumarEnvido(new Cinco(new Copa())));
		Assert.assertEquals(6, new Seis(new Basto()).sumarEnvido(new Seis(new Copa())));
		Assert.assertEquals(7, new Seis(new Basto()).sumarEnvido(new SieteFalso(new Copa())));
		Assert.assertEquals(6, new Seis(new Basto()).sumarEnvido(new Sota(new Copa())));
		Assert.assertEquals(6, new Seis(new Basto()).sumarEnvido(new Caballo(new Copa())));
		Assert.assertEquals(6, new Seis(new Basto()).sumarEnvido(new Rey(new Copa())));

		Assert.assertEquals(6, new Seis(new Oro()).sumarEnvido(new Dos(new Copa())));
		Assert.assertEquals(6, new Seis(new Oro()).sumarEnvido(new Tres(new Copa())));
		Assert.assertEquals(6, new Seis(new Oro()).sumarEnvido(new Cuatro(new Copa())));
		Assert.assertEquals(6, new Seis(new Oro()).sumarEnvido(new Cinco(new Copa())));
		Assert.assertEquals(6, new Seis(new Oro()).sumarEnvido(new Seis(new Copa())));
		Assert.assertEquals(7, new Seis(new Oro()).sumarEnvido(new SieteFalso(new Copa())));
		Assert.assertEquals(6, new Seis(new Oro()).sumarEnvido(new Sota(new Copa())));
		Assert.assertEquals(6, new Seis(new Oro()).sumarEnvido(new Caballo(new Copa())));
		Assert.assertEquals(6, new Seis(new Oro()).sumarEnvido(new Rey(new Copa())));

		Assert.assertEquals(7, new SieteFalso(new Basto()).sumarEnvido(new Dos(new Copa())));
		Assert.assertEquals(7, new SieteFalso(new Basto()).sumarEnvido(new Tres(new Copa())));
		Assert.assertEquals(7, new SieteFalso(new Basto()).sumarEnvido(new Cuatro(new Copa())));
		Assert.assertEquals(7, new SieteFalso(new Basto()).sumarEnvido(new Cinco(new Copa())));
		Assert.assertEquals(7, new SieteFalso(new Basto()).sumarEnvido(new Seis(new Copa())));
		Assert.assertEquals(7, new SieteFalso(new Basto()).sumarEnvido(new SieteFalso(new Copa())));
		Assert.assertEquals(7, new SieteFalso(new Basto()).sumarEnvido(new Sota(new Copa())));
		Assert.assertEquals(7, new SieteFalso(new Basto()).sumarEnvido(new Caballo(new Copa())));
		Assert.assertEquals(7, new SieteFalso(new Basto()).sumarEnvido(new Rey(new Copa())));

		Assert.assertEquals(7, new SieteDeOro().sumarEnvido(new Dos(new Copa())));
		Assert.assertEquals(7, new SieteDeOro().sumarEnvido(new Tres(new Copa())));
		Assert.assertEquals(7, new SieteDeOro().sumarEnvido(new Cuatro(new Copa())));
		Assert.assertEquals(7, new SieteDeOro().sumarEnvido(new Cinco(new Copa())));
		Assert.assertEquals(7, new SieteDeOro().sumarEnvido(new Seis(new Copa())));
		Assert.assertEquals(7, new SieteDeOro().sumarEnvido(new SieteFalso(new Copa())));
		Assert.assertEquals(7, new SieteDeOro().sumarEnvido(new Sota(new Copa())));
		Assert.assertEquals(7, new SieteDeOro().sumarEnvido(new Caballo(new Copa())));
		Assert.assertEquals(7, new SieteDeOro().sumarEnvido(new Rey(new Copa())));

		Assert.assertEquals(2, new Sota(new Basto()).sumarEnvido(new Dos(new Copa())));
		Assert.assertEquals(3, new Sota(new Basto()).sumarEnvido(new Tres(new Copa())));
		Assert.assertEquals(4, new Sota(new Basto()).sumarEnvido(new Cuatro(new Copa())));
		Assert.assertEquals(5, new Sota(new Basto()).sumarEnvido(new Cinco(new Copa())));
		Assert.assertEquals(6, new Sota(new Basto()).sumarEnvido(new Seis(new Copa())));
		Assert.assertEquals(7, new Sota(new Basto()).sumarEnvido(new SieteFalso(new Copa())));
		Assert.assertEquals(0, new Sota(new Basto()).sumarEnvido(new Sota(new Copa())));
		Assert.assertEquals(0, new Sota(new Basto()).sumarEnvido(new Caballo(new Copa())));
		Assert.assertEquals(0, new Sota(new Basto()).sumarEnvido(new Rey(new Copa())));

		Assert.assertEquals(2, new Sota(new Oro()).sumarEnvido(new Dos(new Copa())));
		Assert.assertEquals(3, new Sota(new Oro()).sumarEnvido(new Tres(new Copa())));
		Assert.assertEquals(4, new Sota(new Oro()).sumarEnvido(new Cuatro(new Copa())));
		Assert.assertEquals(5, new Sota(new Oro()).sumarEnvido(new Cinco(new Copa())));
		Assert.assertEquals(6, new Sota(new Oro()).sumarEnvido(new Seis(new Copa())));
		Assert.assertEquals(7, new Sota(new Oro()).sumarEnvido(new SieteFalso(new Copa())));
		Assert.assertEquals(0, new Sota(new Oro()).sumarEnvido(new Sota(new Copa())));
		Assert.assertEquals(0, new Sota(new Oro()).sumarEnvido(new Caballo(new Copa())));
		Assert.assertEquals(0, new Sota(new Oro()).sumarEnvido(new Rey(new Copa())));

		Assert.assertEquals(2, new Caballo(new Basto()).sumarEnvido(new Dos(new Copa())));
		Assert.assertEquals(3, new Caballo(new Basto()).sumarEnvido(new Tres(new Copa())));
		Assert.assertEquals(4, new Caballo(new Basto()).sumarEnvido(new Cuatro(new Copa())));
		Assert.assertEquals(5, new Caballo(new Basto()).sumarEnvido(new Cinco(new Copa())));
		Assert.assertEquals(6, new Caballo(new Basto()).sumarEnvido(new Seis(new Copa())));
		Assert.assertEquals(7, new Caballo(new Basto()).sumarEnvido(new SieteFalso(new Copa())));
		Assert.assertEquals(0, new Caballo(new Basto()).sumarEnvido(new Sota(new Copa())));
		Assert.assertEquals(0, new Caballo(new Basto()).sumarEnvido(new Caballo(new Copa())));
		Assert.assertEquals(0, new Caballo(new Basto()).sumarEnvido(new Rey(new Copa())));

		Assert.assertEquals(2, new Caballo(new Oro()).sumarEnvido(new Dos(new Copa())));
		Assert.assertEquals(3, new Caballo(new Oro()).sumarEnvido(new Tres(new Copa())));
		Assert.assertEquals(4, new Caballo(new Oro()).sumarEnvido(new Cuatro(new Copa())));
		Assert.assertEquals(5, new Caballo(new Oro()).sumarEnvido(new Cinco(new Copa())));
		Assert.assertEquals(6, new Caballo(new Oro()).sumarEnvido(new Seis(new Copa())));
		Assert.assertEquals(7, new Caballo(new Oro()).sumarEnvido(new SieteFalso(new Copa())));
		Assert.assertEquals(0, new Caballo(new Oro()).sumarEnvido(new Sota(new Copa())));
		Assert.assertEquals(0, new Caballo(new Oro()).sumarEnvido(new Caballo(new Copa())));
		Assert.assertEquals(0, new Caballo(new Oro()).sumarEnvido(new Rey(new Copa())));

		Assert.assertEquals(2, new Rey(new Basto()).sumarEnvido(new Dos(new Copa())));
		Assert.assertEquals(3, new Rey(new Basto()).sumarEnvido(new Tres(new Copa())));
		Assert.assertEquals(4, new Rey(new Basto()).sumarEnvido(new Cuatro(new Copa())));
		Assert.assertEquals(5, new Rey(new Basto()).sumarEnvido(new Cinco(new Copa())));
		Assert.assertEquals(6, new Rey(new Basto()).sumarEnvido(new Seis(new Copa())));
		Assert.assertEquals(7, new Rey(new Basto()).sumarEnvido(new SieteFalso(new Copa())));
		Assert.assertEquals(0, new Rey(new Basto()).sumarEnvido(new Sota(new Copa())));
		Assert.assertEquals(0, new Rey(new Basto()).sumarEnvido(new Caballo(new Copa())));
		Assert.assertEquals(0, new Rey(new Basto()).sumarEnvido(new Rey(new Copa())));

		Assert.assertEquals(2, new Rey(new Oro()).sumarEnvido(new Dos(new Copa())));
		Assert.assertEquals(3, new Rey(new Oro()).sumarEnvido(new Tres(new Copa())));
		Assert.assertEquals(4, new Rey(new Oro()).sumarEnvido(new Cuatro(new Copa())));
		Assert.assertEquals(5, new Rey(new Oro()).sumarEnvido(new Cinco(new Copa())));
		Assert.assertEquals(6, new Rey(new Oro()).sumarEnvido(new Seis(new Copa())));
		Assert.assertEquals(7, new Rey(new Oro()).sumarEnvido(new SieteFalso(new Copa())));
		Assert.assertEquals(0, new Rey(new Oro()).sumarEnvido(new Sota(new Copa())));
		Assert.assertEquals(0, new Rey(new Oro()).sumarEnvido(new Caballo(new Copa())));
		Assert.assertEquals(0, new Rey(new Oro()).sumarEnvido(new Rey(new Copa())));
	}
}
