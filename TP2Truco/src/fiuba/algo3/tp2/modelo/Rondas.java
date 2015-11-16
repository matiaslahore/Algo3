package fiuba.algo3.tp2.modelo;

import java.util.ArrayList;
import java.util.List;

import fiuba.algo3.colecciones.ListaCircular;
import fiuba.algo3.tp2.modeloDeCartas.TipoDeCartas;

public abstract class Rondas{

	Juez juez;
	ArrayList<String> ganadoresRonda;
	ListaCircular<Jugador> jugadores;
	ArrayList<TipoDeCartas> cartasEnJuego;
	Rondas refRonda;
	int jugadorMano;
	int auxMano;

	public Rondas(Juez juez, ArrayList<String> ganadoresRonda, ListaCircular<Jugador> jugadores, Rondas ronda){
		this.juez=juez;
		this.ganadoresRonda = ganadoresRonda;
		this.jugadores = jugadores;
		this.refRonda = ronda;
		cartasEnJuego = new ArrayList<TipoDeCartas>();
		jugadorMano = 0;
		auxMano = 0;
	}

	public void recibirCarta(TipoDeCartas carta){
		this.cartasEnJuego.add(carta);
	}
	
	public abstract void repartir();
	
	public void jugar(int aQuienLeToca) {
		//VEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEER condicion for
		auxMano = aQuienLeToca;
		
		for ( int i = auxMano ; i == (this.jugadores.size() - 1) ; i=i+1 ){
			Jugador actual = this.jugadores.get(i);
			cartasEnJuego.add(actual.jugarCarta()); //VER!!
		}
		ganador();
	}
	
	public abstract void ganador();

	public void cantarTruco(){
		this.juez.puntosEnJuego(2);
	}
	public void cantarQuieroReTruco(){
		this.juez.puntosEnJuego(3);
	}
	public void cantarQuieroValeCuatro(){
		this.juez.puntosEnJuego(4);
	}

	public void cantarEnvido(){
		this.juez.puntosEnJuego(2);
	}
	public void cantarRealEnvido(){
		this.juez.puntosEnJuego(3);
	}
	public void cantarFaltaEnvido(){
		int puntosFalta = 4;
		//agregar un metodo que calcule los ptos que irian ACA
		this.juez.puntosEnJuego(puntosFalta);
	}
	
	public void cantarFlor(){
		this.juez.puntosEnJuego(3);
	}
	
}
