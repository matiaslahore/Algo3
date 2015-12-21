package fiuba.algo3.tp2.modelo;

import java.util.ArrayList;
import java.util.Random;

import fiuba.algo3.tp2.modeloDeCartas.*;

public class Maso {

	ArrayList<Carta> maso = new ArrayList<Carta>();
	
	public Maso(){
		this.maso.add(new AnchoDeEspada()); // R0
		this.maso.add(new AnchoDeBasto()); // R1
		this.maso.add(new SieteDeEspada()); // R2
		this.maso.add(new SieteDeOro()); // R3
		this.maso.add(new Tres(new Oro())); // R4
		this.maso.add(new Tres(new Copa())); // R4
		this.maso.add(new Tres(new Basto())); // R4
		this.maso.add(new Tres(new Espada())); // R4
		this.maso.add(new Dos(new Oro())); // R5
		this.maso.add(new Dos(new Copa())); // R5
		this.maso.add(new Dos(new Basto())); // R5
		this.maso.add(new Dos(new Espada())); // R5
		this.maso.add(new AnchoFalso(new Copa())); // R6
		this.maso.add(new AnchoFalso(new Oro())); // R6
		this.maso.add(new Rey(new Oro())); // R7
		this.maso.add(new Rey(new Copa())); // R7
		this.maso.add(new Rey(new Basto())); // R7
		this.maso.add(new Rey(new Espada())); // R7
		this.maso.add(new Caballo(new Oro())); // R8
		this.maso.add(new Caballo(new Copa())); // R8
		this.maso.add(new Caballo(new Basto())); // R8
		this.maso.add(new Caballo(new Espada())); // R8
		this.maso.add(new Sota(new Oro())); // R9
		this.maso.add(new Sota(new Copa())); // R9
		this.maso.add(new Sota(new Basto())); // R9
		this.maso.add(new Sota(new Espada())); // R9
		this.maso.add(new SieteFalso(new Basto())); // R10
		this.maso.add(new SieteFalso(new Copa())); // R10
		this.maso.add(new Seis(new Oro())); // R11
		this.maso.add(new Seis(new Copa())); // R11
		this.maso.add(new Seis(new Basto())); // R11
		this.maso.add(new Seis(new Espada())); // R11
		this.maso.add(new Cinco(new Oro())); // R12
		this.maso.add(new Cinco(new Copa())); // R12
		this.maso.add(new Cinco(new Basto())); // R12
		this.maso.add(new Cinco(new Espada())); // R12
		this.maso.add(new Cuatro(new Oro())); // R13
		this.maso.add(new Cuatro(new Copa())); // R13
		this.maso.add(new Cuatro(new Basto())); // R13
		this.maso.add(new Cuatro(new Espada())); // R13
	}
	
	public Carta dameCarta(){
		
		Random rnd = new Random();
		int index = (int) (rnd.nextDouble() * (maso.size()));
		Carta CartaRetorno = this.maso.get(index);
		this.maso.remove(index);
		return CartaRetorno;
	}
	
	public int obtenerRankingDeLaCarta(String nombreDeLaCarta){
		int iterador = 0;
		
		for(; iterador<= 3; iterador++){ //Ancho espada,basto ; Siete espada,copa
			if(this.maso.get(iterador).cartaComoString() == nombreDeLaCarta)
				return 13-iterador;
		}
		for(; iterador<= 7; iterador++){//Los 3
			if(this.maso.get(iterador).cartaComoString() == nombreDeLaCarta)
				return 9;
		}
		for(; iterador<= 11; iterador++){//Los 2
			if(this.maso.get(iterador).cartaComoString() == nombreDeLaCarta)
				return 8;
		}
		for(; iterador<= 13; iterador++){//Los anchos falsos
			if(this.maso.get(iterador).cartaComoString() == nombreDeLaCarta)
				return 7;
		}
		for(; iterador<= 17; iterador++){//Los 12
			if(this.maso.get(iterador).cartaComoString() == nombreDeLaCarta)
				return 6;
		}
		for(; iterador<= 21; iterador++){//Los 11
			if(this.maso.get(iterador).cartaComoString() == nombreDeLaCarta)
				return 5;
		}
		for(; iterador<= 25; iterador++){//Los 10
			if(this.maso.get(iterador).cartaComoString() == nombreDeLaCarta)
				return 4;
		}
		for(; iterador<= 27; iterador++){//Los 7 falsos
			if(this.maso.get(iterador).cartaComoString() == nombreDeLaCarta)
				return 3;
		}
		for(; iterador<= 31; iterador++){//Los 6
			if(this.maso.get(iterador).cartaComoString() == nombreDeLaCarta)
				return 2;
		}
		for(; iterador<= 35; iterador++){//Los 5
			if(this.maso.get(iterador).cartaComoString() == nombreDeLaCarta)
				return 1;
		}
		return 0; //Los 4
	}

}
