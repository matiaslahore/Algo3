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
	ArrayList<Integer> tantoEnJuego;
	Rondas refRonda;
	int jugadorMano;
	boolean sigue;

	public Rondas(Juez juez, ArrayList<String> ganadoresRonda, ListaCircular<Jugador> jugadores, int indexMano){
		this.juez=juez;
		this.ganadoresRonda = ganadoresRonda;
		this.jugadores = jugadores;
		cartasEnJuego = new ArrayList<TipoDeCartas>();
		tantoEnJuego = new ArrayList<Integer>();
		jugadorMano = new Integer(indexMano);
	}

	public void recibirCarta(TipoDeCartas carta){
		this.cartasEnJuego.add(carta);
	}
	
	public abstract void repartir();
	
	public Rondas jugar() {
		repartir();
		this.juez.puntosEnJuego(1);
		
		//cantarEnvido();
		//cantarFaltaEnvido();
		//cantarRealEnvido();
		//cantarTruco();
		//cantarQuieroReTruco();
		//cantarQuieroValeCuatro();
		//ESTO LO UNICO QUE CHEQUEA ES QUE SE SUMEN LOS PUNTOS CORRECTAMENE
		
		//VER SI CONVIENE HACER OTRO TIPO DE CICLO..
		//le sumo aux mano xq sino esto siempre seria 2 y cuando le toqe jugar primero
		//al jugador 2, i=2 y corta en 2.. osea nunca juega el 1 que es el i=3 (lista circular)
		for ( int i = jugadorMano ; i <= (this.jugadores.size() - 1 + jugadorMano) ; i=i+1 ){
			Jugador actual = this.jugadores.get(i);
			cartasEnJuego.add(actual.jugarCarta()); //VER!!
			System.out.println("JUEGA: " + actual.nombre);
		}
		System.out.println(cartasEnJuego.get(0).cartaComoString() + " vs " + cartasEnJuego.get(1).cartaComoString());
		return ganador();
	}
	
	public abstract Rondas ganador();

	public void cantarTruco(){
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
		tantoCantado();
	}
	
	//CASO ENVIDO
	public void cantarEnvido(){
		this.juez.puntosEnJuego(2);
		tantoCantado();
	}
	public void cantarRealEnvido(){
		this.juez.puntosEnJuego(3);
		tantoCantado();
	}
	public void cantarFaltaEnvido(){
		int puntosFalta = this.juez.puntosDeLaFalta();
		this.juez.puntosEnJuego(puntosFalta);
		tantoCantado();
	}
	
	public void tantoCantado(){
		//VER COMO HACER PARA QUE QUIERAN..
		for ( int i = jugadorMano ; i <= (this.jugadores.size() - 1 + jugadorMano) ; i=i+1 ){
			Jugador actual = this.jugadores.get(i);
			tantoEnJuego.add(actual.obtenerPuntosEnvido());
		}
		
		int tantoGanador = this.juez.quienGanaElTanto(this.tantoEnJuego);
		int indexCartaGanadora = this.tantoEnJuego.lastIndexOf(tantoGanador);
		//esto esta mal xq si empatan en tanto gana el q no es mano.
		
		Jugador ganador = this.jugadores.get(this.jugadorMano + indexCartaGanadora);
		this.juez.anotarPuntos(ganador.returnEquipo());
		this.juez.puntosEnJuego(1);
		this.tantoEnJuego.clear();
		
		System.out.println("EL TANTO LO GANA " + ganador.nombre);
	}
    
	public ArrayList<String> getGanadores (){
		return this.ganadoresRonda;
	}
	
}
