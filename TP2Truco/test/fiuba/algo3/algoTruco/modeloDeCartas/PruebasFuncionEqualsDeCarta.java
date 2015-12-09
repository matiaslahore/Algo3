package fiuba.algo3.algoTruco.modeloDeCartas;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import fiuba.algo3.tp2.modeloDeCartas.AnchoDeBasto;
import fiuba.algo3.tp2.modeloDeCartas.AnchoFalso;
import fiuba.algo3.tp2.modeloDeCartas.Basto;
import fiuba.algo3.tp2.modeloDeCartas.Carta;
import fiuba.algo3.tp2.modeloDeCartas.Copa;
import fiuba.algo3.tp2.modeloDeCartas.Dos;
import fiuba.algo3.tp2.modeloDeCartas.Tres;

public class PruebasFuncionEqualsDeCarta {

	
	@Test
	public void creoDosAnchosDeBastoYPreguntoSinSonIguales(){
		
		Carta anchoDeBasto = new AnchoDeBasto();
		Carta anchoDeBastoDos = new AnchoDeBasto();
		
		Assert.assertTrue(anchoDeBasto.equals(anchoDeBastoDos));
	}
	
	@Test
	public void elDosDeCopaEsDistintoAlDosDeBasto(){
		
		Carta dosDeCopa = new Dos(new Copa());
		Carta dosDeBasto = new Dos(new Basto());
		
		Assert.assertFalse(dosDeCopa.equals(dosDeBasto));
	}
	
	@Test
	public void pruebasEliminarUnaCartaDeUnaLista(){
		
		Carta dosDeCopa = new Dos(new Copa());
		Carta tresDeBasto = new Tres(new Basto());
		Carta anchoDeCopa = new AnchoFalso(new Copa());
		
		List<Carta> listaDeCartas = new ArrayList<Carta>();
		listaDeCartas.add(dosDeCopa);
		listaDeCartas.add(tresDeBasto);
		listaDeCartas.add(anchoDeCopa);
		
		Assert.assertTrue(listaDeCartas.contains(new Dos(new Copa())));
		
	}
}
