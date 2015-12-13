package fiuba.algo3.tp2.modelo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import fiuba.algo3.colecciones.ListaCircular;
import fiuba.algo3.tp2.cantos.EstadoCantoEnvido;
import fiuba.algo3.tp2.cantos.EstadoCantoTruco;
import fiuba.algo3.tp2.cantos.EstadoInicialEnvido;
import fiuba.algo3.tp2.cantos.EstadoInicialTruco;
import fiuba.algo3.tp2.cantos.EstadoEnvidoFinalizado;
import fiuba.algo3.tp2.modeloDeCartas.*;
import fiuba.algo3.tp2.modeloJugador.Jugador;
import fiuba.algo3.tp2.modeloRondas.EstadoRondas;

public class Juez {

	Maso maso;
	Mesa mesa;
	EstadoRondas mano;
	Puntos tanteadorDeLaPartida;
	int puntosEnJuego;
	int cantidadJugadasPicaPica = 0;
	int indiceJugadorMano;
	int indiceJugadorQueComienza;

	private EstadoCantoTruco cantosTruco;
	private EstadoCantoEnvido cantosEnvido;

	public Juez(Mesa mesa, Equipo equipoUno, Equipo equipoDos){
		this.maso = new Maso();
		this.mesa = mesa;
		this.puntosEnJuego = 1;
		this.tanteadorDeLaPartida = new Puntos(equipoUno, equipoDos);
		this.indiceJugadorMano = 0;

		this.cantosTruco = new EstadoInicialTruco();
		this.cantosEnvido = new EstadoInicialEnvido();
	}

	public List<Carta> obtenerListaDeCartasEnJuego(){
		return this.mesa.obtenerCartasEnJuegoDeRondaActual();
	}

	public Carta repartir(){
		return this.maso.dameCarta();
	}

	public Carta obtenerCartaGanadoraDeRonda() {
		Iterator<Carta> itr = this.mesa.obtenerCartasEnJuegoDeRondaActual().iterator();

		Carta cartaUno = (Carta) itr.next();
		Carta cartaDos = (Carta) itr.next();
		Carta ganadora = cartaGanadora(cartaUno,cartaDos);

		while(itr.hasNext()) {
			Carta otraCarta = (Carta) itr.next();
			ganadora = cartaGanadora(ganadora,otraCarta);
		}

		return ganadora;		
	}	

	private Carta cartaGanadora(Carta a, Carta b){
		return a.vs(b);
	}

	public boolean hayParda(){
		return this.mesa.hayParda();
	}

	public void puntosEnJuego(int puntos) {
		this.puntosEnJuego = puntos;
	}

	public int quienGanaElTanto(ArrayList<Integer> tantoEnJuego) {
		return Collections.max(tantoEnJuego);
	}

	public int puntosEquipo(Equipo equipo) {
		return this.tanteadorDeLaPartida.getPuntaje(equipo);
	}

	public boolean termino() {
		if (tanteadorDeLaPartida.getPuntajeMaximo() >= 30){
			return true;
		}
		return false;
	}

	public void AumentarPuntosEnJuego(int puntos) {
		this.puntosEnJuego = this.puntosEnJuego + puntos;
	}

	public void limpiarCartasJugadas() {
		this.mesa.limpiarCartasJugadas();
	}

	public int cantidadDeCartasEnJuego() {
		return this.mesa.cantidadDeCartasEnJuegoDeRondaActual();
	}

	public void imprimirResultados() {
		this.tanteadorDeLaPartida.imprimirResultados();
	}

	public Jugador otroJugadorConFlor(Equipo equipoQueCanta) {
		return this.mesa.otroJugadorConFlor(equipoQueCanta);
	}

	public boolean hayOtroEquipoConFlor(Equipo equipoQueCanta) {
		return this.mesa.hayOtroEquipoConFlor(equipoQueCanta);
	}

	public ListaCircular<Jugador> listaDeJugadores() {
		if (esPicaPica()){
			return listaDeJugadoresPicaPica();
		}
		this.mezclar();
		this.mesa.repartir(); //mezcla y reparte
		return this.mesa.listaDeJugadores();
	}

	public ListaCircular<Jugador> listaDeJugadoresPicaPica() {
		ListaCircular<Jugador> nuevosJugadores = new ListaCircular<Jugador>();
		nuevosJugadores.add(this.mesa.listaDeJugadores().get(this.indiceJugadorMano));
		nuevosJugadores.add(this.mesa.listaDeJugadores().get(this.indiceJugadorMano + 3));
		this.mesa.repartir(nuevosJugadores);
		return nuevosJugadores;
	}

	private boolean rangoDePuntajeEstaEnPicaPica() {
		return this.tanteadorDeLaPartida.rangoEstaEnPicaPica();
	}

	private boolean esPicaPica() {
		if (this.mesa.cantidadDeJugadores() == 6 && rangoDePuntajeEstaEnPicaPica()){
			if (this.cantidadJugadasPicaPica == 0) mezclar();
			
			if (cantidadJugadasPicaPica <= 3){
				this.indiceJugadorQueComienza = 0;
				return true;
			}
			cantidadJugadasPicaPica = 0;
			this.indiceJugadorMano = this.indiceJugadorMano - 2;
			this.indiceJugadorQueComienza = this.indiceJugadorMano;
			return false;
		}
		return false;
	}

	public int indiceJugadorQueComienza() {
		return this.indiceJugadorQueComienza;
	}

	public void finalizoLaMano(Equipo equipo) {
		this.anotarPuntos(equipo);
		this.limpiarCartasEnJuegoDeRondaActual();
		this.mesa.limpiarCartasJugadas();
		this.indiceJugadorMano = this.indiceJugadorMano + 1;
		this.indiceJugadorQueComienza = this.indiceJugadorMano;
		this.cantosTruco = new EstadoInicialTruco();
		this.cantosEnvido = new EstadoInicialEnvido();
		if (esPicaPica()){
			actualizarCantidadJugadasPicaPica();
		}
	}

	private void actualizarCantidadJugadasPicaPica(){
		this.cantidadJugadasPicaPica = this.cantidadJugadasPicaPica + 1;
	}

	private void mezclar(){
		this.maso = new Maso();
	}

	public void limpiarCartasEnJuegoDeRondaActual() {
		this.mesa.limpiarCartasEnJuegoDeRondaActual();
	}

	public int indiceJugadorMano() {
		return this.indiceJugadorMano;
	}

	//EN EL CANTO TRUCO, EL JUEZ CHEQUEA QUE SE PUEDA CANTAR
	public void seCantoTruco(Equipo equipoQueCanta) {
		this.cantosTruco = this.cantosTruco.cantarTruco(equipoQueCanta);
	}

	public void seCantoQuieroReTruco(Equipo equipoQueCanta) {
		this.cantosTruco = this.cantosTruco.cantarQuieroReTruco(equipoQueCanta);
	}

	public void seCantoQuieroValeCuatro(Equipo equipoQueCanta) {
		this.cantosTruco = this.cantosTruco.cantarQuieroValeCuatro(equipoQueCanta);
	}

	public void noQuisoTruco() {
		this.puntosEnJuego = this.cantosTruco.noQuiso();
	}

	public void quisoTruco() {
		this.puntosEnJuego = this.cantosTruco.quiso();
	}

	//EN EL CANTO ENVIDO, EL JUEZ CHEQUEA QUE SE PUEDA CANTAR
	public void seCantoEnvido(Equipo equipoQueCanta) {
		this.cantosEnvido = this.cantosEnvido.cantarEnvido(equipoQueCanta);
	}

	public void seCantoRealEnvido(Equipo equipoQueCanta) {
		this.cantosEnvido = this.cantosEnvido.cantarRealEnvido(equipoQueCanta);
	}

	public void seCantoFaltaEnvido(Equipo equipoQueCanta) {
		this.cantosEnvido = this.cantosEnvido.cantarFaltaEnvido(equipoQueCanta);
	}

	public void noQuisoEnvido() {
		this.puntosEnJuego = this.cantosEnvido.noQuiso();
		this.cantosEnvido = new EstadoEnvidoFinalizado();
	}

	public void anotarPuntos(Equipo equipo){
		this.tanteadorDeLaPartida.anotarPuntos(equipo, puntosEnJuego);
		this.puntosEnJuego = 1;
	}

	public void anotarPuntosEnvido(Equipo equipoGanador, Equipo equipoPerdedor) {
		this.puntosEnJuego = this.cantosEnvido.quiso(this.tanteadorDeLaPartida.getPuntaje(equipoGanador), this.tanteadorDeLaPartida.getPuntaje(equipoPerdedor));
		this.cantosEnvido = new EstadoEnvidoFinalizado();
		this.tanteadorDeLaPartida.anotarPuntos(equipoGanador, puntosEnJuego);
		this.puntosEnJuego = 1;
	}

}
