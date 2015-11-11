package fiuba.algo3.tp2.modelo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Jugador {

	String nombre;
	ArrayList<Carta> cartas;
	String equipo;
	
	public Object cantaLosPuntos(){
		return cartas;
		
		
	}
	
	public Jugador(String name){
		nombre = name;
		cartas = new ArrayList<Carta>(); 
	}
	
	public void recibirCartas(Carta c1, Carta c2, Carta c3){
		cartas.add(c1);
		cartas.add(c2);
		cartas.add(c3);
	}

	public void recibirUnaCarta(Carta carta){
		
		cartas.add(carta);
	}
	
	public Carta jugarCarta(){
		//ACA ENTRA LA DECISION DEL JUGADOR.. PUSE LA PRIMERA POR PONER
		Carta actual = cartas.get(0);
		cartas.remove(0);
		return actual;
	}
	
	public String verCartasEnManoComoString() {
		
		String cartasComoString = "";
		for (Carta unaCarta : cartas){
			
			cartasComoString += unaCarta.obtenerCartaComoString();
		}
		return cartasComoString;
	}
	
	public String obtenerNombre(){
		return nombre;
	}
	
	public int cantidadDeCartas(){
		return cartas.size();
	}
	
	public void cargarEquipo(String nombre){
		this.equipo = nombre;
	}
	
	public String returnEquipo(){
		return this.equipo;
	}

	public int obtenerPuntosEnvido(){
		
		Map<String,List<Integer>> mapaDeCartas = new HashMap<String,List<Integer>>();
		
		mapaDeCartas.put("Oro", new ArrayList<Integer>());
		mapaDeCartas.put("Espada", new ArrayList<Integer>());
		mapaDeCartas.put("Basto", new ArrayList<Integer>());
		mapaDeCartas.put("Copa", new ArrayList<Integer>());
		
		for (Carta unaCarta : cartas){
		
			mapaDeCartas.get(unaCarta.obtenerPaloComoString()).add(unaCarta.obtenerValor());
		}
		
		int maximoTamanio = 0;
		List<Integer> listaConEnvido = new ArrayList<Integer>();
		for (List<Integer> listaDeValores : mapaDeCartas.values()){
			
			if (listaDeValores.size() > maximoTamanio){
				maximoTamanio = listaDeValores.size();
				listaConEnvido = listaDeValores;
			}
		}
		
		if (listaConEnvido.size()==1) return this.dameValorDeCartaMayor(cartas);	
		
		Collections.sort(listaConEnvido);
		if (listaConEnvido.size() == 3) listaConEnvido.remove(0);
		
		int envido = 0;
		
		for(int i=0; i<2; i=i+1){
			if (listaConEnvido.get(i) <= 7 ){
				envido = envido + listaConEnvido.get(i);
			}
		}
		return envido + 20;
	}
	
	private int dameValorDeCartaMayor(ArrayList<Carta> cartas) {
		
		List<Carta> cartasNoNegras = new ArrayList<Carta>();
		
		for (Carta unaCarta : cartas){
			
			if (unaCarta.obtenerValor() <= 7){
				
				cartasNoNegras.add(unaCarta);
			}
		}
		switch (cartasNoNegras.size()){
		
		case 0:
			return 0;
		case 1:
			return cartasNoNegras.get(0).obtenerValor();
		case 2:
			if (cartasNoNegras.get(0).obtenerValor() < cartasNoNegras.get(1).obtenerValor()){
				return cartasNoNegras.get(1).obtenerValor();
			}
			else{
				return cartasNoNegras.get(0).obtenerValor();
			}
		}
		int maximo = cartasNoNegras.get(0).obtenerValor();
		
		if (maximo < cartasNoNegras.get(1).obtenerValor()){
			maximo = cartasNoNegras.get(1).obtenerValor();
		}
		else{
			if (maximo < cartasNoNegras.get(2).obtenerValor()){
				maximo = cartasNoNegras.get(2).obtenerValor();
			}
		}
		return maximo;
	}

	public Carta jugarPrimera(){
		Carta actual = cartas.get(0);
		cartas.remove(0);
		return actual;
	}

	public int obtenerPuntosTruco() {

		return 0;
	}

	public int obtenerPuntosEnvidoConFlor() {

		int envidoConFlor = 0;
		
		for (Carta unaCarta : cartas){
			
			if (unaCarta.obtenerValor()<= 7){
			
				envidoConFlor += unaCarta.obtenerValor();
			}
		}
		return envidoConFlor + 20;
	}
}
