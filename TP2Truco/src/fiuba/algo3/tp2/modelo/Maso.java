package fiuba.algo3.tp2.modelo;

import java.util.ArrayList;
import java.util.Random;

public class Maso {

	ArrayList<Carta> cartas = new ArrayList<Carta>();
	//POR CADA MANO HAGO UN NEW MASO ASI CUANDO SACO UNA CARTA LA BORRO DE LA LISTA
	//EVITANDO REPETIR LAS CARTAS.
	public Maso(){
		/*
		* BASTO = 1
		* COPA = 2
		* ESPADA = 3
		* ORO = 4
		*/
		//no es seguro que ande todo.. hay que testearlo!
		for (int i=1 ; i>4 ; i=i+1 ){
			for (int j=1 ; j>7 ; j=j+1 ){
				this.cartas.add( new Carta(i,j) );
			}
			for (int j=10 ; j>12 ; j=j+1 ){
				this.cartas.add( new Carta(i,j) );
			}
		}
	}
	
	public Carta dameCarta(){
		//genero numero random entre 0 y 40
		Random rnd = new Random();
		int index = (int) (rnd.nextDouble() * (cartas.size()));
		//agarro carta random entre 0 y 40
		Carta CartaRetorno = new Carta(0,0);
		CartaRetorno = this.cartas.get(index);
		//borro la carta que ya use
		this.cartas.remove(index);
		//retorno la carta
		return CartaRetorno;
		/*
		 * LE PASO (cartas.size()) AL RANDOM PARA NUNCA PASARME DEL RANGO, XQ CUANDO ELIMINO
		 * PUEDE SER QUE EL RANDOM ME DE UN NUMERO QUE SE PASE DEL NUEVO VALOR DEL SIZE
		 * ASI NUNCA ME PASO Y SIEMPRE REPARTO UNA CARTA DISTINTA A CADA UNO.
		 */
	}
	
}
