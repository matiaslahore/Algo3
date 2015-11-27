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
	ArrayList<Equipo> ganadoresRonda; //guarda el nombre del equipo q gano las rondas
	ArrayList<Carta> cartasEnJuego;
	ListaCircular<Jugador> jugadores;
	Puntos puntos;
	EstadoRondas ronda;
	int indexMano;
	//Truco truco;
	//Envido envido;
	
	
	public Mesa(){
		jugadores = new ListaCircular<Jugador>();
		ganadoresRonda = new ArrayList<Equipo>();
		cartasEnJuego = new ArrayList<Carta>();
		indexMano = 0;
	}
	
	public void instanciarJuez(Equipo equipoUno, Equipo equipoDos) {
		juez = new Juez(this, equipoUno, equipoDos);
	}
	
	public void iniciarRonda(){
		this.ronda = new EstadoRondaUno(this.ronda, juez, ganadoresRonda, jugadores, indexMano, indexMano);
	}
	
	public void recibirCarta(Carta carta){
		System.out.println("Mesa recibe: " + carta.cartaComoString());
		this.cartasEnJuego.add(carta);
	}
	
	public void repartirCartas() {
		Iterator<Jugador> itr = this.jugadores.iterator();
		
		while(itr.hasNext()) {
			Jugador jugador = (Jugador) itr.next();
			jugador.recibirCartas(this.juez.repartir(), this.juez.repartir(), this.juez.repartir());
		}
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

	public Equipo ultimoGanador() {
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
	
	public void cantarFlor(Jugador jugador) {
		try {
			this.ronda = this.ronda.cantarFlor(jugador);
		} catch (CantoInvalidoException | EquipoQueCantaNoPuedeVolverACantarException e) {
			//QueDevuelvo
		}
	}
	
	public void cantarContraFlor(Jugador jugador) {
		try {
			this.ronda = this.ronda.cantarContraFlor(jugador);
		} catch (CantoInvalidoException | EquipoQueCantaNoPuedeVolverACantarException e) {
			//QueDevuelvo
		}
	}
	
	public void cantarContraFlorAJuego(Jugador jugador) {
		try {
			this.ronda = this.ronda.cantarContraFlorAJuego(jugador);
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

	public int puntosEquipo(Equipo equipo) {
		return this.juez.puntosEquipo(equipo);
	}
	
	public int puntosEquipo(String equipo) {
		return this.juez.puntosEquipo(equipo);
	}

	public Carta obtenerCartaGanadoraDeRonda() {
		Iterator<Carta> itr = cartasEnJuego.iterator();
		
		Carta cartaUno = (Carta) itr.next();
		Carta cartaDos = (Carta) itr.next();
		Carta ganadora = ganador(cartaUno,cartaDos);
		
		while(itr.hasNext()) {
			Carta otraCarta = (Carta) itr.next();
			ganadora = ganador(ganadora,otraCarta);
		}
		
		return ganadora;		
	}	
	
	private Carta ganador(Carta a, Carta b){
		return a.vs(b);
	}

	public List<Carta> obtenerListaDeCartasEnJuego() {
		return this.cartasEnJuego;
	}

	public void limpiarCartasEnJuegoDeRondaActual() {
		this.cartasEnJuego.clear();
	}

	public boolean hayParda() {
		
		Iterator<Carta> itr = this.cartasEnJuego.iterator();

		List<Carta> cartasEquipoUno = new LinkedList<Carta>();
		List<Carta> cartasEquipoDos = new LinkedList<Carta>();
		
		while (itr.hasNext()){
			cartasEquipoUno.add(itr.next());
			cartasEquipoDos.add(itr.next());
		}
		
		Carta mejorCartaEquipoUno = this.obtenerMejorCartaDeLaLista(cartasEquipoUno);
		Carta mejorCartaEquipoDos = this.obtenerMejorCartaDeLaLista(cartasEquipoDos);
		
		return mejorCartaEquipoUno.hayParda(mejorCartaEquipoDos);
	}

	private Carta obtenerMejorCartaDeLaLista(List<Carta> cartas) {
		Iterator<Carta> iterador = cartas.iterator();
		
		Carta mejorCarta = iterador.next();
		
		while(iterador.hasNext()){
			
			mejorCarta = iterador.next().vs(mejorCarta);
		}
		return mejorCarta;
	}

	public int cantidadDeCartasEnJuego() {
		return this.cartasEnJuego.size();
	}

	public void imprimirResultados() {
		this.juez.imprimirResultados();
	}

	public int cantidadDeJugadores() {
		return jugadores.size();
	}
	
}
