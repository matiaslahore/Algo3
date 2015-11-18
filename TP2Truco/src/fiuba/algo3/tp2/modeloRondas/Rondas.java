package fiuba.algo3.tp2.modeloRondas;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import fiuba.algo3.colecciones.ListaCircular;
import fiuba.algo3.tp2.modelo.Juez;
import fiuba.algo3.tp2.modelo.Jugador;
import fiuba.algo3.tp2.modeloDeCartas.TipoDeCartas;

public abstract class Rondas{

	Juez juez;
	ArrayList<String> ganadoresRonda;
	ListaCircular<Jugador> jugadores;
	ArrayList<TipoDeCartas> cartasEnJuego;
	ArrayList<Integer> tantoEnJuego;
	Rondas refRonda;
	int jugadorMano;
	int indexMano;
	boolean sigue;

	public Rondas(Juez juez, ArrayList<String> ganadoresRonda, ArrayList<TipoDeCartas> cartasEnJuego,ListaCircular<Jugador> jugadores, int indexManoAux, int indexMano){
		this.juez=juez;
		this.ganadoresRonda = ganadoresRonda;
		this.cartasEnJuego = cartasEnJuego;
		this.jugadores = jugadores;
		cartasEnJuego = new ArrayList<TipoDeCartas>();
		tantoEnJuego = new ArrayList<Integer>();
		this.jugadorMano = new Integer(indexManoAux);
		this.indexMano = indexMano; //esto no se toca nunca salvo en la ronda 3 para indicar la mano sig.
	}

	public void recibirCarta(TipoDeCartas carta){
		this.cartasEnJuego.add(carta);
	}
	
	public abstract void repartir();
	
	public Rondas jugar() {
		repartir();
		//this.juez.puntosEnJuego(1);
		
        for ( int i = jugadorMano ; i <= (this.jugadores.size() - 1 + jugadorMano) ; i=i+1 ){
			Jugador actual = this.jugadores.get(i);
			System.out.println("TURNO DE: " + actual.obtenerNombre());
			interfaz(actual);
		}
		System.out.println(cartasEnJuego.get(0).cartaComoString() + " vs " + cartasEnJuego.get(1).cartaComoString());
		return ganador();
	}

	public abstract Rondas ganador();

	public void cantarTruco(){
		//actual.cantarTruco();
		this.juez.puntosEnJuego(2);
	}
	public void cantarQuieroReTruco(){
		this.juez.puntosEnJuego(3);
	}
	public void cantarQuieroValeCuatro(){
		this.juez.puntosEnJuego(4);
	}

	public void cantarFlor(){
		this.juez.puntosEnJuego(3);
		//tantoCantado();
	}
	
	//CASO ENVIDO
	public void cantarEnvido(){
		this.juez.puntosEnJuego(2);
		//tantoCantado();
	}
	public void cantarRealEnvido(){
		this.juez.puntosEnJuego(3);
		//tantoCantado();
	}
	public void cantarFaltaEnvido(){
		int puntosFalta = this.juez.puntosDeLaFalta();
		this.juez.puntosEnJuego(puntosFalta);
		//tantoCantado();
	}
	
	public ArrayList<String> getGanadores (){
		return this.ganadoresRonda;
	}
	
	public abstract void interfaz(Jugador actual);
	
	public int aQuienLeToca(){
		return this.jugadorMano;
	}
	
	public void interfazTanto(Jugador actual){
		Scanner leer = new Scanner(System.in);
		System.out.println("Acepta el tanto?: ");
		System.out.println(" 1-Si\n 2-No\n");
		int opcion = leer.nextInt();
		
		switch (opcion) {
			case 1:
				tantoAceptado();
				break;
			case 2:
				juez.puntosEnJuego(1);
				juez.anotarPuntos(actual.returnEquipo());
				break;
		}
	}
	
	private void tantoAceptado(){
		for ( int i = jugadorMano ; i <= (this.jugadores.size() - 1 + jugadorMano) ; i=i+1 ){
			Jugador actual = this.jugadores.get(i);
			tantoEnJuego.add(actual.obtenerPuntosEnvido());
		}
		
		int tantoGanador = this.juez.quienGanaElTanto(this.tantoEnJuego);
		int indexCartaGanadora = this.tantoEnJuego.indexOf(tantoGanador);
		
		Jugador ganador = this.jugadores.get(this.jugadorMano + indexCartaGanadora);
		this.juez.anotarPuntos(ganador.returnEquipo());
		this.juez.puntosEnJuego(1);
		this.tantoEnJuego.clear();
		
		System.out.println("EL TANTO LO GANA " + ganador.obtenerNombre());
	}

}
