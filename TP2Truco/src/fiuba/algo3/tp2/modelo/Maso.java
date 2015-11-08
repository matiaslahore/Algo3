package fiuba.algo3.tp2.modelo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Maso {

	ArrayList<Carta> maso = new ArrayList<Carta>();
	
	public Maso(){
		
		List<Palo> listaDePalos = Arrays.asList(new Basto(), new Copa(), new Espada(), new Oro());

		for (Palo unPalo : listaDePalos){
			
			for (int valor=1 ; valor<=7 ; valor = valor + 1 ){
				this.maso.add( new Carta(unPalo, valor) );
			}
			for (int valor=10 ; valor <= 12 ; valor = valor +1 ){
				this.maso.add( new Carta(unPalo, valor ));
			}
		}
	}
	
	public Carta dameCarta(){
		//genero numero random entre 0 y 40
		Random rnd = new Random();
		int index = (int) (rnd.nextDouble() * (maso.size()));
		//agarro carta random entre 0 y 40
		Carta CartaRetorno = this.maso.get(index);
		//borro la carta que ya use
		this.maso.remove(index);
		//retorno la carta
		return CartaRetorno;
		/*
		 * LE PASO (cartas.size()) AL RANDOM PARA NUNCA PASARME DEL RANGO, XQ CUANDO ELIMINO
		 * PUEDE SER QUE EL RANDOM ME DE UN NUMERO QUE SE PASE DEL NUEVO VALOR DEL SIZE
		 * ASI NUNCA ME PASO Y SIEMPRE REPARTO UNA CARTA DISTINTA A CADA UNO.
		 */
	}
	
}
