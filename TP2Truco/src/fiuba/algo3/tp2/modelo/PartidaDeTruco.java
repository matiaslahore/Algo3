package fiuba.algo3.tp2.modelo;

import java.util.ArrayList;
import java.util.List;

import fiuba.algo3.tp2.modeloDeCartas.Carta;
import fiuba.algo3.tp2.modeloJugador.Jugador;
import fiuba.algo3.tp2.modeloJugador.OyenteJugador;

public abstract class PartidaDeTruco implements OyenteJugador{
	EventosDePartida eventosDePartida;
	Equipo equipoUno;
	Equipo equipoDos;
	Mesa mesa;
	Jugador jugadorTurnoActual;
	
	public PartidaDeTruco(String nombreEq1, String nombreEq2){
		this.mesa = new Mesa();
		this.equipoUno = new Equipo(nombreEq1, mesa);
		this.equipoDos = new Equipo(nombreEq2, mesa);
		this.mesa.instanciarJuez(equipoUno, equipoDos);
		this.eventosDePartida = new EventosDePartida();
	}
	
	public void cargarJugadoresEnEquipoUno(List<String> nombreJugadores) {
		this.equipoUno.cargarJugadores(nombreJugadores);
	}
	
	public void cargarJugadoresEnEquipoDos(List<String> nombreJugadores) {
		this.equipoDos.cargarJugadores(nombreJugadores);
	}
	
	private void agregarmeComoOyenteDeLosJugadores(ArrayList<Jugador> jugadores){
		for (Jugador jugador : jugadores)
            jugador.cargarOyente(this);
	}

	public void iniciar() {
		ArrayList<Jugador> jugadoresEquipoUno = equipoUno.obtenerJugadores();
		ArrayList<Jugador> jugadoresEquipoDos = equipoDos.obtenerJugadores();
		this.agregarmeComoOyenteDeLosJugadores(jugadoresEquipoUno);
		this.agregarmeComoOyenteDeLosJugadores(jugadoresEquipoDos);
		this.mesa.sentarJugadores(jugadoresEquipoUno, jugadoresEquipoDos);
		this.mesa.iniciarRonda();
		this.jugadorTurnoActual = this.mesa.siguienteJugadorConTurno();
	}
	
	public int obtenerPuntajeDeEquipoUno() {
		return this.mesa.puntosEquipo(equipoUno);
	}
	
	public int obtenerPuntajeDeEquipoDos() {
		return this.mesa.puntosEquipo(equipoDos);
	}
	
	public String obtenerNombreDeEquipoUno() {
		return this.equipoUno.obtenerNombre();
	}
	
	public String obtenerNombreDeEquipoDos() {
		return this.equipoDos.obtenerNombre();
	}
	
	public List<Carta> obtenerCartasDelJugadorConTurno() {
		return this.jugadorTurnoActual.obtenerCartasDelJugador();
	}
	
	public void jugarCarta(Carta carta) {
		this.jugadorTurnoActual.jugarCarta(carta);
		this.jugadorTurnoActual = this.mesa.siguienteJugadorConTurno();
	}
	
	public void cantarTruco() {
		this.jugadorTurnoActual.cantarTruco();
		this.jugadorTurnoActual = this.mesa.siguienteJugadorConTurno();
	}
	
	public void cantarQuieroReTruco() {
		this.jugadorTurnoActual.cantarQuieroReTruco();
		this.jugadorTurnoActual = this.mesa.siguienteJugadorConTurno();
	}
	
	public void cantarQuieroValeCuatro() {
		this.jugadorTurnoActual.cantarQuieroValeCuatro();
		this.jugadorTurnoActual = this.mesa.siguienteJugadorConTurno();
	}
	
	public void cantarEnvido() {
		this.jugadorTurnoActual.cantarEnvido();
		this.jugadorTurnoActual = this.mesa.siguienteJugadorConTurno();
	}
	
	public void cantarRealEnvido() {
		this.jugadorTurnoActual.cantarRealEnvido();
		this.jugadorTurnoActual = this.mesa.siguienteJugadorConTurno();
	}
	
	public void cantarFaltaEnvido() {
		this.jugadorTurnoActual.cantarFaltaEnvido();
		this.jugadorTurnoActual = this.mesa.siguienteJugadorConTurno();
	}
	
	public void irseAlMazo(){
		this.jugadorTurnoActual.irseAlMazo();
		this.jugadorTurnoActual = this.mesa.siguienteJugadorConTurno();
	}
	
	public void quiero(){
		this.jugadorTurnoActual.quiero();
		this.jugadorTurnoActual = this.mesa.siguienteJugadorConTurno();
	}

	public void noQuiero(){
		this.jugadorTurnoActual.noQuiero();
		this.jugadorTurnoActual = this.mesa.siguienteJugadorConTurno();
	}
	
	public abstract void cantarFlor();
	
	public abstract void cantarContraFlor();
	
	public abstract void cantarContraFlorAJuego();

	public List<Carta> cartasEnJuego() {
		return this.mesa.obtenerListaDeCartasJugadas();
	}

	public String obtenerNombreDelJugadorConTurno() {
		return this.jugadorTurnoActual.obtenerNombre();
	}
	
	public void cartearseParaHacerLosTest(Jugador unJugador, List<Carta> cartasParaJugador){
		unJugador.recibirCartas(cartasParaJugador);
	}
	
	public void agregarOyenteDeVista(OyenteDePartida toAdd){
		this.eventosDePartida.addListener(toAdd);
	}
	
	//cuando el jugador Canta alguno de los cantos, partida de truco debe
	//pasar el mensaje a la parte visual
	
	public void agregarOyentesALaPartida(OyenteDePartida oyente){
		this.eventosDePartida.addListener(oyente);
	}
	
	@Override
	public void jugadorCantoTruco() {
		//System.out.println("jugadorr Canto Truco" );//Por ahora muestro esto por pantalla, despues se lo paso a la visual
		this.eventosDePartida.seCantoTruco();
	}
	
	@Override
	public void jugadorQuiso() {
		//System.out.println("jugador quiso Truco" );
		this.eventosDePartida.seQuiso();
	}
	
	@Override
	public void jugadorNoQuiso() {
		//System.out.println("jugador no quiso el Truco" );
		this.eventosDePartida.noSeQuiso();
	}
	
	@Override
	public void jugadorCantoReTruco(){
		
	}
	
	@Override
	public void jugadorCantoValeCuatro(){
		
	}
	
	@Override
	public void jugadorCantoEnvido(){
		System.out.println("Envidooo" );
	}
	
	@Override
	public void jugadorCantoRealEnvido(){
		System.out.println("RealEnvidooo" );
	}
	
	@Override
	public void jugadorCantoFaltaEnvido(){
		System.out.println("FalaEnvidooo" );
	}
	
	@Override
	public void jugadorCantoFlor(){
		System.out.println("Flor" );
	}
	
	@Override
	public void jugadorCantoContraFlor(){
		System.out.println("Contra flor" );
	}
	
	@Override
	public void jugadorCantoContraFlorAJuego(){
		System.out.println("CFAJ" );
	}

	@Override
	public void hacerJugarIA(){
		
	}
	
	@Override
	public void jugadorSeFueAlMazo(){
		
	}

	
}
