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
		this.maso.add(new TresDeOro()); // R4
		this.maso.add(new TresDeCopa()); // R4
		this.maso.add(new TresDeBasto()); // R4
		this.maso.add(new TresDeEspada()); // R4
		this.maso.add(new DosDeOro()); // R5
		this.maso.add(new DosDeCopa()); // R5
		this.maso.add(new DosDeBasto()); // R5
		this.maso.add(new DosDeEspada()); // R5
		this.maso.add(new AnchoDeCopa()); // R6
		this.maso.add(new AnchoDeOro()); // R6
		this.maso.add(new ReyDeOro()); // R7
		this.maso.add(new ReyDeCopa()); // R7
		this.maso.add(new ReyDeBasto()); // R7
		this.maso.add(new ReyDeEspada()); // R7
		this.maso.add(new CaballoDeOro()); // R8
		this.maso.add(new CaballoDeCopa()); // R8
		this.maso.add(new CaballoDeBasto()); // R8
		this.maso.add(new CaballoDeEspada()); // R8
		this.maso.add(new SotaDeOro()); // R9
		this.maso.add(new SotaDeCopa()); // R9
		this.maso.add(new SotaDeBasto()); // R9
		this.maso.add(new SotaDeEspada()); // R9
		this.maso.add(new SieteDeBasto()); // R10
		this.maso.add(new SieteDeCopa()); // R10
		this.maso.add(new SeisDeOro()); // R11
		this.maso.add(new SeisDeCopa()); // R11
		this.maso.add(new SeisDeBasto()); // R11
		this.maso.add(new SeisDeEspada()); // R11
		this.maso.add(new CincoDeOro()); // R12
		this.maso.add(new CincoDeCopa()); // R12
		this.maso.add(new CincoDeBasto()); // R12
		this.maso.add(new CincoDeEspada()); // R12
		this.maso.add(new CuatroDeOro()); // R13
		this.maso.add(new CuatroDeCopa()); // R13
		this.maso.add(new CuatroDeBasto()); // R13
		this.maso.add(new CuatroDeEspada()); // R13
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
