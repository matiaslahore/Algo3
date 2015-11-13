package fiuba.algo3.tp2.modelo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import fiuba.algo3.tp2.modeloDeCartas.*;

public class Maso {

	ArrayList<TipoDeCartas> maso = new ArrayList<TipoDeCartas>();
	
	public Maso(){
		
		this.maso.add(new AnchoDeEspada());
		this.maso.add(new AnchoDeBasto());
		this.maso.add(new SieteDeEspada());
		this.maso.add(new SieteDeOro(new Oro()));
		this.maso.add(new SieteFalso(new Basto()));
		this.maso.add(new SieteFalso(new Copa()));
		this.maso.add(new AnchoFalso(new Copa()));
		this.maso.add(new AnchoFalso(new Oro()));
		
		//CASO TODOS LOS PALOS
		List<Palo> listaDePalos = Arrays.asList(new Basto(), new Copa(), new Espada(), new Oro());
		for (Palo unPalo : listaDePalos){
			for (int valor = 1 ; valor <= 8 ; valor = valor + 1 ){
				this.maso.add(new Dos(unPalo));
				this.maso.add(new Tres(unPalo));
				this.maso.add(new Cuatro(unPalo));
				this.maso.add(new Cinco(unPalo));
				this.maso.add(new Seis(unPalo));
				this.maso.add(new Sota(unPalo));
				this.maso.add(new Caballo(unPalo));
				this.maso.add(new Rey(unPalo));
			}
		}
	}
	
	public TipoDeCartas dameCarta(){
		Random rnd = new Random();
		int index = (int) (rnd.nextDouble() * (maso.size()));
		TipoDeCartas CartaRetorno = this.maso.get(index);
		this.maso.remove(index);
		return CartaRetorno;
	}
	
}
