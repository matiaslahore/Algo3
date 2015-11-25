package fiuba.algo3.tp2.modelo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import fiuba.algo3.colecciones.ListaCircular;
import fiuba.algo3.tp2.excepciones.CantoInvalidoException;
import fiuba.algo3.tp2.excepciones.EquipoQueCantaNoPuedeVolverACantarException;
import fiuba.algo3.tp2.modeloDeCartas.*;
import fiuba.algo3.tp2.modeloJugador.Jugador;
import fiuba.algo3.tp2.modeloRondas.*;

public class Mesa {
    
	Juez juez;
	ArrayList<String> ganadoresRonda; //guarda el nombre del equipo q gano las rondas
	ArrayList<TipoDeCartas> cartasEnJuego;
	ListaCircular<Jugador> jugadores;
	Puntos puntos;
	EstadoRondas ronda;
	int indexMano;
	//Truco truco;
	//Envido envido;
	
	
	public Mesa(String equipoUno, String equipoDos){
		jugadores = new ListaCircular<Jugador>();
		juez = new Juez(this, equipoUno, equipoDos);
		ganadoresRonda = new ArrayList<String>();
		cartasEnJuego = new ArrayList<TipoDeCartas>();
		puntos = new Puntos(equipoUno,equipoDos);
		indexMano = 0;
		//this.truco= new Truco();
		//this.envido = new Envido();
		//this.ronda = new EstadoRondaUno(ronda, juez, ganadoresRonda, cartasEnJuego, jugadores, indexMano, indexMano);
	}
	
	public void iniciarRonda(){
		this.ronda = new EstadoRondaUno(this.ronda, juez, ganadoresRonda, jugadores, indexMano, indexMano);
	}
	
	public void recibirCarta(TipoDeCartas carta){
		System.out.println("Mesa recibe: " + carta.cartaComoString());
		this.cartasEnJuego.add(carta);
	}

	public TipoDeCartas repartirCarta() {
		return juez.repartir();
	}
	
	public void repartirCartas() {
		juez.repartir();
	}
	
	public void anotarPuntos(String equipo, int cantidad){
		this.puntos.anotarPuntos(equipo, cantidad);
	}

	public void sentarJugadores(ArrayList<Jugador> equipoUno, ArrayList<Jugador> equipoDos) {
		Iterator<Jugador> itrEqUno = equipoUno.iterator();
		Iterator<Jugador> itrEqDos = equipoDos.iterator();
				
		while(itrEqUno.hasNext() && itrEqDos.hasNext()) {
			Jugador jugadorEqUno = (Jugador) itrEqUno.next();
			jugadores.add(jugadorEqUno);
			Jugador jugadorEqDos = (Jugador) itrEqDos.next();
			jugadores.add(jugadorEqDos);
		}
	}
	
	public Jugador siguiente(){
		this.ronda = this.ronda.acualizarRonda();
		return this.ronda.turnoDe();
	}
    
	public void cantarEnvido( Jugador jugador) throws CantoInvalidoException{
		try {
			this.ronda = this.ronda.cantarEnvido(jugador);
		} catch (CantoInvalidoException e) {
			throw e;
		}
	}
	
	public void cantarRealEnvido(Jugador jugador) throws CantoInvalidoException {
		try {
			this.ronda = this.ronda.cantarRealEnvido(jugador);
		} catch (CantoInvalidoException e) {
			throw e;
		}
	}
	
	public void cantarFaltaEnvido( Jugador jugador) throws CantoInvalidoException{
		try {
			this.ronda = this.ronda.cantarFaltaEnvido(jugador);
		} catch (CantoInvalidoException e) {
			throw e;
		}
	}

	public String ultimoGanador() {
		return this.ganadoresRonda.get(this.ganadoresRonda.size()-1);
	}

	public void cantarTruco(Jugador jugador){
		try {
			this.ronda = this.ronda.cantarTruco(jugador);
		} catch (CantoInvalidoException | EquipoQueCantaNoPuedeVolverACantarException e) {
			//QueDevuelvo
		}
	}
	
	public void cantarQuieroReTruco(Jugador jugador) {
		try {
			this.ronda = this.ronda.cantarQuieroReTruco(jugador);
		} catch (CantoInvalidoException | EquipoQueCantaNoPuedeVolverACantarException e) {
			//QueDevuelvo
		}
	}
	
	public void cantarQuieroValeCuatro(Jugador jugador) {
		try {
			this.ronda = this.ronda.cantarQuieroValeCuatro(jugador);
		} catch (CantoInvalidoException | EquipoQueCantaNoPuedeVolverACantarException e) {
			//QueDevuelvo
		}
	}

	public void quiero(Jugador jugador){
		this.ronda = this.ronda.quiero(jugador);
	}

	public void noQuiero(Jugador jugador){
		this.ronda = this.ronda.noQuiero(jugador);
	}

	public int puntosEquipo(String equipo) {
		return this.juez.puntosEquipo(equipo);
	}

	public TipoDeCartas obtenerCartaGanadoraDeRonda() {
		Iterator<TipoDeCartas> itr = cartasEnJuego.iterator();
		
		TipoDeCartas cartaUno = (TipoDeCartas) itr.next();
		TipoDeCartas cartaDos = (TipoDeCartas) itr.next();
		TipoDeCartas ganadora = ganador(cartaUno,cartaDos);
		
		while(itr.hasNext()) {
			TipoDeCartas otraCarta = (TipoDeCartas) itr.next();
			ganadora = ganador(ganadora,otraCarta);
		}
		
		return ganadora;		
	}	
	
	private TipoDeCartas ganador(TipoDeCartas a, TipoDeCartas b){
		return a.vs(b);
	}

	public List<TipoDeCartas> obtenerListaDeCartasEnJuego() {
		return this.cartasEnJuego;
	}

	public void limpiarCartasEnJuegoDeRondaActual() {
		this.cartasEnJuego.clear();
	}

	public boolean hayParda() {
		
		Iterator<TipoDeCartas> itr = this.cartasEnJuego.iterator();

		List<TipoDeCartas> cartasEquipoUno = new LinkedList<TipoDeCartas>();
		List<TipoDeCartas> cartasEquipoDos = new LinkedList<TipoDeCartas>();
		
		while (itr.hasNext()){
			cartasEquipoUno.add(itr.next());
			cartasEquipoDos.add(itr.next());
		}
		
		TipoDeCartas mejorCartaEquipoUno = this.obtenerMejorCartaDeLaLista(cartasEquipoUno);
		TipoDeCartas mejorCartaEquipoDos = this.obtenerMejorCartaDeLaLista(cartasEquipoDos);
		
		return mejorCartaEquipoUno.hayParda(mejorCartaEquipoDos);
	}

	private TipoDeCartas obtenerMejorCartaDeLaLista(List<TipoDeCartas> cartas) {
		Iterator<TipoDeCartas> iterador = cartas.iterator();
		
		TipoDeCartas mejorCarta = iterador.next();
		
		while(iterador.hasNext()){
			
			mejorCarta = iterador.next().vs(mejorCarta);
		}
		return mejorCarta;
	}

	public int cantidadDeCartasEnJuego() {
		return this.cartasEnJuego.size();
	}

	/*
	do{
		ronda = ronda.jugar();
	}while(juez.termina());
	*/
	
}
