package fiuba.algo3.tp2.modelo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import fiuba.algo3.colecciones.ListaCircular;
import fiuba.algo3.tp2.excepciones.CantoInvalidoException;
import fiuba.algo3.tp2.excepciones.NoSeEncontroJugadorConFlorException;
import fiuba.algo3.tp2.excepciones.TodabiaNoFinalizoLaRondaException;
import fiuba.algo3.tp2.modeloDeCartas.*;
import fiuba.algo3.tp2.modeloJugador.Jugador;
import fiuba.algo3.tp2.modeloRondas.*;

public class Mesa {

	Juez juez;
	ArrayList<Equipo> ganadoresRonda; 
	ArrayList<Carta> cartasEnJuegoRondaActual;
	ListaCircular<Jugador> jugadores;
	Puntos puntos;
	EstadoRondas ronda;
	int indexMano;
	ArrayList<Carta> cartasJugadas;
	
	public Mesa(){
		jugadores = new ListaCircular<Jugador>();
		ganadoresRonda = new ArrayList<Equipo>();
		cartasEnJuegoRondaActual = new ArrayList<Carta>();
		cartasJugadas = new ArrayList<Carta>();
		indexMano = 0;
	}

	public void instanciarJuez(Equipo equipoUno, Equipo equipoDos){
		juez = new Juez(this, equipoUno, equipoDos);
	}

	public void iniciarRonda(){
		repartir();
		this.ronda = new EstadoRondaUno(this.ronda, juez, ganadoresRonda, jugadores, indexMano, indexMano);
	}

	public void recibirCarta(Carta carta){
		this.ronda.jugarCarta();
		this.cartasEnJuegoRondaActual.add(carta);
		this.cartasJugadas.add(carta);
		System.out.println("Mesa recibe: " + carta.cartaComoString());
	}

	public void repartirCartas() {
		Iterator<Jugador> itr = this.jugadores.iterator();
		List<Carta> listaCartas = new ArrayList<Carta>();

		while(itr.hasNext()) {
			Jugador jugador = (Jugador) itr.next();
			listaCartas.addAll(Arrays.asList(this.juez.repartir(), this.juez.repartir(), this.juez.repartir()));
			jugador.recibirCartas(listaCartas);
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

	public Jugador siguienteJugadorConTurno(){
		this.ronda = this.ronda.acualizarRonda();
		return this.ronda.turnoDe();
	}

	public void cantarEnvido( Jugador jugador) throws CantoInvalidoException{
		this.ronda = this.ronda.cantarEnvido(jugador);
	}

	public void cantarRealEnvido(Jugador jugador) throws CantoInvalidoException {
		
		this.ronda = this.ronda.cantarRealEnvido(jugador);
	}

	public void cantarFaltaEnvido( Jugador jugador) throws CantoInvalidoException{
		this.ronda = this.ronda.cantarFaltaEnvido(jugador);
	}

	public Equipo ganadorDeLaRonda() {
		try{
			return this.ganadoresRonda.get(this.ganadoresRonda.size()-1);
		}catch(ArrayIndexOutOfBoundsException e){
			throw new TodabiaNoFinalizoLaRondaException();
		}
	}

	public void cantarTruco(Jugador jugador){
		this.ronda = this.ronda.cantarTruco(jugador);
		//throw new seCantoTrucoEvent();
	}

	public void cantarQuieroReTruco(Jugador jugador) {
		this.ronda = this.ronda.cantarQuieroReTruco(jugador);
	}

	public void cantarQuieroValeCuatro(Jugador jugador) {	
		this.ronda = this.ronda.cantarQuieroValeCuatro(jugador);
	}

	public void cantarFlor(Jugador jugador) {
		this.ronda = this.ronda.cantarFlor(jugador);
	}

	public void cantarContraFlor(Jugador jugador) {
		this.ronda = this.ronda.cantarContraFlor(jugador);
	}

	public void cantarContraFlorAJuego(Jugador jugador) {
		this.ronda = this.ronda.cantarContraFlorAJuego(jugador);
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

	public List<Carta> obtenerCartasEnJuegoDeRondaActual() {
		return this.cartasEnJuegoRondaActual;
	}
	
	public List<Carta> obtenerListaDeCartasJugadas() {
		return this.cartasJugadas;
	}

	public void limpiarCartasEnJuegoDeRondaActual() {
		this.cartasEnJuegoRondaActual.clear();
	}
	
	public void limpiarCartasJugadas() {
		this.cartasJugadas.clear();
	}

	public boolean hayParda() {

		Iterator<Carta> itr = this.cartasEnJuegoRondaActual.iterator();

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

	public int cantidadDeCartasEnJuegoDeRondaActual() {
		return this.cartasEnJuegoRondaActual.size();
	}

	public void imprimirResultados() {
		this.juez.imprimirResultados();
	}

	public int cantidadDeJugadores() {
		return jugadores.size();
	}

	public boolean esMano() {
		return this.cantidadDeCartasEnJuegoDeRondaActual() == 0;
	}

	public Carta obtenerUltimaCartaJugada() {
		return this.cartasEnJuegoRondaActual.get(0);
	}

	public void irseAlMazo(Jugador jugador) {
		this.ronda = this.ronda.irseAlMazo(jugador);
	}

	public boolean seCantoEnvido() {
		return ronda.seCantoEnvido();
	}

	public boolean seCantoTruco() {
		return this.ronda.seCantoTruco();
	}

	public Jugador otroJugadorConFlor(Equipo equipoQueCanta) {
		
		for(Jugador unJugador : this.jugadores){
			if (unJugador.tieneFlor()){
				if(unJugador.obtenerEquipo() != equipoQueCanta){
					return unJugador;
				}
			}
		}
		throw new NoSeEncontroJugadorConFlorException();
	}


	public boolean hayOtroEquipoConFlor(Equipo equipoQueCanta) {
		
		for(Jugador unJugador : this.jugadores){
			if (unJugador.tieneFlor()){
				if(unJugador.obtenerEquipo() != equipoQueCanta){
					return true;
				}
			}
		}
		return false;
	}
	
	private void repartir(){
		for ( int i = 0 ; i <= (this.jugadores.size() - 1) ; i=i+1 ){
			Jugador actual = this.jugadores.get(i);
			actual.recibirCartas(new ArrayList<Carta>(Arrays.asList(this.juez.repartir(), this.juez.repartir(), this.juez.repartir())));
		}
	}
}
