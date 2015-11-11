package fiuba.algo3.tp2.modelo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Carta {

	Palo palo;
	int valor;
	Jugador jugador;
	int jerarquia;
		
	public Carta(Palo unPalo, int unValor){
		palo = unPalo;
		valor = unValor;
		
		if (this.valor == 4) this.jerarquia = 1;
		if (this.valor == 5) this.jerarquia = 2;
		if (this.valor == 6) this.jerarquia = 3;
		if (this.valor == 10) this.jerarquia = 5;
		if (this.valor == 11) this.jerarquia = 6;
		if (this.valor == 12) this.jerarquia = 7;
		if (this.valor == 2) this.jerarquia = 9;
		if (this.valor == 3) this.jerarquia = 10;
		
		if ((this.valor == 7) && (this.palo.getClass()==Espada.class)){
			this.jerarquia = 12;
		}else if (this.palo.getClass()==Oro.class) {
			this.jerarquia = 11;
			}else this.jerarquia = 4;//7 de basto o copa
		
		if ((this.valor == 1) && (this.palo.getClass()==Espada.class)){
			this.jerarquia = 14;
		}else if (this.palo.getClass()==Basto.class) {
			this.jerarquia = 13;
			}else this.jerarquia = 8;//1 de oro o copa
		//ESTO ESTA HECHO A MODO GROSERO PARA CHEQUEAR UNAS COSAS
		//HAY QUE PONERLO LINDO
	}
	
	public static Object decimeElEnvidoDeEstasCartas(List<Carta> cartas){
		
		Map<String,Integer> cuentoElEnvido = new HashMap<String,Integer>();
		int valorEnvido = 0;
		int valorCarta = 0;
		
		for (Carta unaCarta : cartas){
			
			valorCarta = unaCarta.obtenerValor();
			valorEnvido = unaCarta.obtenerValor();
			
			if (cuentoElEnvido.containsKey(unaCarta.obtenerPalo())){
				
				int valorCartaGuardada = cuentoElEnvido.get(unaCarta.obtenerPalo());
				if ((valorCarta < 7) && (valorCartaGuardada < 7)) valorEnvido = valorCarta + valorCartaGuardada;
				else
					if (valorCarta > 7) valorEnvido = valorCartaGuardada;
					else
						if (valorCartaGuardada > 7) valorEnvido = valorCarta;
						else
							valorEnvido = 20;
			}
			cuentoElEnvido.put(unaCarta.obtenerPalo(), valorEnvido);				
		}	
		return null;
	}
	
	public String obtenerPalo(){
		return palo.obtenerPalo();
	}
	
	public int obtenerValor(){
		return valor;
	}

	public Object obtenerCartaComoString() {
		return "'" + this.obtenerValor()+ " de " + this.obtenerPalo() + "' ";
	}

	public Palo palo(){
		return this.palo;
	}
	
	public int valor(){
		return this.valor;
	}

	public boolean esMenorQue(Carta b) {
		if (this.jerarquia < b.jerarquia()) return true;
		else return false;
		//Hay q contemplar el caso parda..
	}

	private int jerarquia() {
		return this.jerarquia;
	}

	public Jugador deQuienSos() {
		return this.jugador;
	}
	
	public void cargarJugador(Jugador jug){
		this.jugador = jug;
	}

	public int sumarMismoPalo(Carta c2, Carta c3) {
		int a = 0;
		int b = 0;
		int c = 0;
		
		if (this.palo.getClass() == c2.palo().getClass()) {
			a = (this.valor + c2.valor());
		}
		if (this.palo.getClass() == c3.palo().getClass()) {
			b = (this.valor + c3.valor());
		}
		if (c3.palo().getClass() == c2.palo().getClass()) {
			c = (c3.valor() + c2.valor());
		}
		
		if (a>b && a>c) return a;
		else if (b>c) return b;
		else return c;
		//ESTA FEO PERO ES PARA IR SAFANDO LAS PRUEBAS..
	}
	
}
