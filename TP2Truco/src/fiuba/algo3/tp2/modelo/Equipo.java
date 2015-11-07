package fiuba.algo3.tp2.modelo;

import java.util.ArrayList;

public class Equipo {
	//VER SI LE PONEMOS NOMBRE AL EQUIPO
	ArrayList<Jugador> listJugadores;
	Mesa refMesa;
	
	public Equipo(Mesa mesa){
	//ESTO TIENE Q SER UNA LISTA CIRCULAR DSPS VER IMPLEMENTACION HAY MUCHAS, SINO LA HACEMOS ES UNA BOLUDES
	//SI ES CIRCULAR LA LISTA NO ME IMPORTA LA CANT DE JUGADORES TRATO A TODOS POR IGUAL
		listJugadores = new ArrayList<Jugador>();
		this.refMesa = mesa;
	}
	
	public void cargarJugadores(String j1, String j2, String j3){
		/*
		* JUGADOR TENDRIA Q TIRAR UNA EXCEPCION SI LE PASO UN STRING VACIO O TOMAR
		* A VACIO COMO NULL NIL, O SIMPLEMENTE "" (NADA).
		* LA NADA LA TENDRIA Q CARGAR LA INTERFAZ GRAFICA.
		* CARGA X DEFECTO TODOS LOS NOMBRES EN "" (NADA) Y CUANDO
		* LE CARGAN EL NOMBRE CAMBIA ESE VALOR X EL NOMBRE
		* LA EXCEPCION NO HACE NADA! SOLO EVITA QUE SE CARGE UN JUGADOR EN LA LISTA CIRCULAR
		* ASI NO ME IMPORTA CUANTOS JUGADORES HAY Y ANDA PARA TODOS.
		*/
		
		Jugador newJugador = new Jugador(j1,refMesa);
		listJugadores.add(newJugador);
		
		newJugador = new Jugador(j2,refMesa);
		listJugadores.add(newJugador);
		
		newJugador = new Jugador(j3,refMesa);
		listJugadores.add(newJugador);
	}//repito codigo, ver si se puede cambiar.
	
	
	
}
