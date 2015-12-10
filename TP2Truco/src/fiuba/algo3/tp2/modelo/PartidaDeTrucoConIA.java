package fiuba.algo3.tp2.modelo;

import java.util.List;

import fiuba.algo3.tp2.excepciones.EquipoIANoPuedeCargarJugadores;
import fiuba.algo3.tp2.modeloDeCartas.Carta;
import fiuba.algo3.tp2.modeloJugador.Oyente;

public abstract class PartidaDeTrucoConIA extends PartidaDeTruco implements Oyente {
	EventosIA eventosIA;
	
	public PartidaDeTrucoConIA(String nombreEquipoIA, String nombreEquipo2){
		super(nombreEquipoIA,nombreEquipo2);
		this.equipoUno.cargarJugadorIA(this.eventosIA);
		this.eventosIA = new EventosIA();
		this.eventosIA.addListener((Oyente) equipoUno.obtenerJugadores().get(0));
	}
	
	public void iniciar() {
		this.mesa.sentarJugadores(equipoUno.obtenerJugadores(), equipoDos.obtenerJugadores());
		this.mesa.iniciarRonda();
		this.jugadorTurnoActual = this.mesa.siguienteJugadorConTurno();
		this.jugadorTurnoActual.hacerJugarIA();
		this.jugadorTurnoActual = this.mesa.siguienteJugadorConTurno();
	}
	
	@Override
	public void cargarJugadoresEnEquipoUno(List<String> nombreJugadores) {
		throw new EquipoIANoPuedeCargarJugadores();
	}
	
	@Override
	public List<Carta> obtenerCartasDelJugadorConTurno() {
		return this.equipoDos.obtenerJugadores().get(0).obtenerCartasDelJugador();
	}
	
	@Override
	public void cantarTruco() {
		this.jugadorTurnoActual.cantarTruco();
		this.eventosIA.seCantoTruco();	
		this.jugadorTurnoActual = this.mesa.siguienteJugadorConTurno();
		this.jugadorTurnoActual.hacerJugarIA();
		this.jugadorTurnoActual = this.mesa.siguienteJugadorConTurno();
		if(this.jugadorTurnoActual.obtenerEquipo().obtenerNombre().equals(this.equipoUno.obtenerNombre())){
			this.jugadorTurnoActual.hacerJugarIA();
			this.jugadorTurnoActual = mesa.siguienteJugadorConTurno();
		}
	}
	
	@Override
	public void cantarQuieroReTruco() {
		this.jugadorTurnoActual.cantarQuieroReTruco();
		this.eventosIA.seCantoReTruco();
		this.jugadorTurnoActual = this.mesa.siguienteJugadorConTurno();
		//verificar una vez que ande todo, siempre va a entrar aca asi que habria que sacar el if
		if(this.jugadorTurnoActual.obtenerEquipo().obtenerNombre().equals(this.equipoUno.obtenerNombre())){
			this.jugadorTurnoActual.hacerJugarIA();
			this.jugadorTurnoActual = this.mesa.siguienteJugadorConTurno();		
		}
	}
	
	@Override
	public void cantarQuieroValeCuatro() {
		this.jugadorTurnoActual.cantarQuieroValeCuatro();
		this.eventosIA.seCantoValeCuatro();
		this.jugadorTurnoActual = this.mesa.siguienteJugadorConTurno();
		//verificar una vez que ande todo, siempre va a entrar aca asi que habria que sacar el if
		if(this.jugadorTurnoActual.obtenerEquipo().obtenerNombre().equals(this.equipoUno.obtenerNombre())){
			this.jugadorTurnoActual.hacerJugarIA();
			this.jugadorTurnoActual = this.mesa.siguienteJugadorConTurno();		
		}
	}
	
	public void cantarEnvido() {
		this.jugadorTurnoActual.cantarEnvido();
		this.eventosIA.seCantoEnvido();	
		this.jugadorTurnoActual = this.mesa.siguienteJugadorConTurno();
		this.jugadorTurnoActual.hacerJugarIA();
		this.jugadorTurnoActual = this.mesa.siguienteJugadorConTurno();
		//verificar una vez que ande todo, siempre va a entrar aca asi que habria que sacar el if
		if(this.jugadorTurnoActual.obtenerEquipo().obtenerNombre().equals(this.equipoUno.obtenerNombre())){
			this.jugadorTurnoActual.hacerJugarIA();
			this.jugadorTurnoActual = mesa.siguienteJugadorConTurno();
		}
	}
	
	public void cantarRealEnvido() {
		this.jugadorTurnoActual.cantarRealEnvido();
		this.eventosIA.seCantoRealEnvido();	
		this.jugadorTurnoActual = this.mesa.siguienteJugadorConTurno();
		this.jugadorTurnoActual.hacerJugarIA();
		this.jugadorTurnoActual = this.mesa.siguienteJugadorConTurno();
		if(this.jugadorTurnoActual.obtenerEquipo().obtenerNombre().equals(this.equipoUno.obtenerNombre())){
			this.jugadorTurnoActual.hacerJugarIA();
			this.jugadorTurnoActual = mesa.siguienteJugadorConTurno();
		}
	}
	
	public void cantarFaltaEnvido() {
		this.jugadorTurnoActual.cantarFaltaEnvido();
		this.eventosIA.seCantoFaltaEnvido();	
		this.jugadorTurnoActual = this.mesa.siguienteJugadorConTurno();
		this.jugadorTurnoActual.hacerJugarIA();
		this.jugadorTurnoActual = this.mesa.siguienteJugadorConTurno();
		if(this.jugadorTurnoActual.obtenerEquipo().obtenerNombre().equals(this.equipoUno.obtenerNombre())){
			this.jugadorTurnoActual.hacerJugarIA();
			this.jugadorTurnoActual = mesa.siguienteJugadorConTurno();
		}
	}
	
	public void jugarCarta(Carta carta) {
		this.jugadorTurnoActual.jugarCarta(carta);
		this.jugadorTurnoActual = this.mesa.siguienteJugadorConTurno();
		
		if(this.jugadorTurnoActual.obtenerEquipo().obtenerNombre().equals(this.equipoUno.obtenerNombre())){
			this.jugadorTurnoActual.hacerJugarIA();
			this.jugadorTurnoActual = this.mesa.siguienteJugadorConTurno();
		}
		if(this.jugadorTurnoActual.obtenerEquipo().obtenerNombre().equals(this.equipoUno.obtenerNombre())){
			this.jugadorTurnoActual.hacerJugarIA();
			this.jugadorTurnoActual = this.mesa.siguienteJugadorConTurno();
		} 
		//Hace dos veces lo mismo ya que humano juega carta, despues va la maquina, si gana la
		//maquina esa ronda, tiraria de nuevo la maquina, entonces hacemos que vuelva a jugar
	}
	
	public void irseAlMazo(){
		this.jugadorTurnoActual.irseAlMazo();
		this.eventosIA.seFueAlMazo();
		this.jugadorTurnoActual = this.mesa.siguienteJugadorConTurno();
		if(this.jugadorTurnoActual.obtenerEquipo().obtenerNombre().equals(this.equipoUno.obtenerNombre())){
			this.jugadorTurnoActual.hacerJugarIA();
			this.jugadorTurnoActual = this.mesa.siguienteJugadorConTurno();
		}
	}
	
	public void quiero(){
		this.jugadorTurnoActual.quiero();
		this.jugadorTurnoActual = this.mesa.siguienteJugadorConTurno();
		//verificar una vez que ande todo, siempre va a entrar aca asi que habria que sacar el if
		if(this.jugadorTurnoActual.obtenerEquipo().obtenerNombre() == this.equipoUno.obtenerNombre()){
			this.jugadorTurnoActual.hacerJugarIA();
			this.jugadorTurnoActual = this.mesa.siguienteJugadorConTurno();
		}
		
	}

	public void noQuiero(){
		this.jugadorTurnoActual.noQuiero();
		this.jugadorTurnoActual = this.mesa.siguienteJugadorConTurno();
		//verificar una vez que ande todo, siempre va a entrar aca asi que habria que sacar el if
		if(this.jugadorTurnoActual.obtenerEquipo().obtenerNombre().equals(this.equipoUno.obtenerNombre())){
			this.jugadorTurnoActual.hacerJugarIA();
			this.jugadorTurnoActual = this.mesa.siguienteJugadorConTurno();
		}
	}
	
	@Override
	public abstract void cantarFlor();
	
	@Override
	public abstract void cantarContraFlor();
	
	@Override
	public abstract void cantarContraFlorAJuego();
	
	//Metodos vacios para utlizar Oytente (No implementar nada aqui)
	@Override
	public void seCantoTruco() {}

	@Override
	public void seCantoReTruco() {}

	@Override
	public void seCantoValeCuatro() {}

	@Override
	public void seCantoEnvido() {}

	@Override
	public void seCantoRealEnvido() {}

	@Override
	public void seCantoFaltaEnvido() {}

	@Override
	public void seCantoFlor() {}

	@Override
	public void seCantoContraFlor() {}

	@Override
	public void seCantoContraFlorAJuego() {}

	@Override
	public void hacerJugarIA() {}

	@Override
	public void seFueAlMazo() {}

	//Metodos a implementar, cuando la IA Canta alguno de los cantos, partida de truco debe
	//pasar el mensaje
	@Override
	public void IACantoTruco() {
		System.out.println("IA Canto Truco" );//Por ahora muestro esto por pantalla, despues se lo paso a la visual
	}
	
	@Override
	public void IAquisoTruco() {
		System.out.println("IA quiso Truco" );//Por ahora muestro esto por pantalla, despues se lo paso a la visual
	}

}