package fiuba.algo3.tp2.modelo;

import java.util.LinkedList;


public class PartidaDeTrucoSimple extends PartidaDeTruco{
	
	    Mesa mesa;
	    Equipo equipoUno;
	    Equipo equipoDos;
	    Puntos puntos;
      	
		public PartidaDeTrucoSimple(String eq1, String eq2){
			this.mesa = new Mesa(eq1, eq2);
			this.equipoUno = new Equipo(eq1,mesa);
			this.equipoDos = new Equipo(eq2,mesa);
		}
		
	    /*@Override
		public void cargarJugadoresEnEquipoUno(String JugadorUno) {
			LinkedList<String> nombreJugadores = new LinkedList<String>();
			nombreJugadores.add(JugadorUno);
			this.equipoUno.cargarJugadores(nombreJugadores);
		}*/
	    @Override
		public void cargarJugadoresEnEquipoUno(String nombre) {
			this.equipoUno.cargarJugadores(nombre);
		}
	    public void cargarJugadoresEnEquipoDos(String nombre) {
			this.equipoDos.cargarJugadores(nombre);
		}
	    /*
        @Override
		public void cargarJugadoresEnEquipoDos(String jugadorDos) {
			LinkedList<String> nombreJugadores = new LinkedList<String>();
			nombreJugadores.add(jugadorDos);
			this.equipoDos.cargarJugadores(nombreJugadores);
		}*/

		@Override
		public void cantarEnvido(String jugador) {
			
		}
		
		public void repartir(){
			equipoUno.recibirCartas();
			equipoDos.recibirCartas();
		}
		
		public void jugarCartas() {
			equipoDos.jugarCarta();
			equipoUno.jugarCarta();
		}

		public void anotarPuntos() {
			Jugador ganador =  this.mesa.ganadorDeMano();
			//String equipo = ganador.returnEquipo();
			this.mesa.anotarPuntosEquipoDos(1);
		}

		public void sentarJugadores() {
			this.mesa.sentarJugadores(equipoUno.obtenerJugadores(),equipoDos.obtenerJugadores());
		}

		public void iniciar() {
			this.mesa.iniciar();
		}
		
	}

//