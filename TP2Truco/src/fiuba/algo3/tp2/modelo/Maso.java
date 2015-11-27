package fiuba.algo3.tp2.modelo;

import java.util.ArrayList;
import java.util.Random;

import fiuba.algo3.tp2.modeloDeCartas.*;

public class Maso {

	ArrayList<TipoDeCartas> maso = new ArrayList<TipoDeCartas>();
	
	public Maso(){
		
		this.maso.add(new AnchoDeEspada());
		this.maso.add(new AnchoDeBasto());
		this.maso.add(new SieteDeEspada());
		this.maso.add(new SieteDeOro());
		this.maso.add(new TresDeOro());
		this.maso.add(new TresDeCopa());
		this.maso.add(new TresDeBasto());
		this.maso.add(new TresDeEspada());
		this.maso.add(new DosDeOro());
		this.maso.add(new DosDeCopa());
		this.maso.add(new DosDeBasto());
		this.maso.add(new DosDeEspada());
		this.maso.add(new AnchoDeCopa());
		this.maso.add(new AnchoDeOro());
		this.maso.add(new ReyDeOro());
		this.maso.add(new ReyDeCopa());
		this.maso.add(new ReyDeBasto());
		this.maso.add(new ReyDeEspada());
		this.maso.add(new CaballoDeOro());
		this.maso.add(new CaballoDeCopa());
		this.maso.add(new CaballoDeBasto());
		this.maso.add(new CaballoDeEspada());
		this.maso.add(new SotaDeOro());
		this.maso.add(new SotaDeCopa());
		this.maso.add(new SotaDeBasto());
		this.maso.add(new SotaDeEspada());
		this.maso.add(new SieteDeBasto());
		this.maso.add(new SieteDeCopa());
		this.maso.add(new SeisDeOro());
		this.maso.add(new SeisDeCopa());
		this.maso.add(new SeisDeBasto());
		this.maso.add(new SeisDeEspada());
		this.maso.add(new CincoDeOro());
		this.maso.add(new CincoDeCopa());
		this.maso.add(new CincoDeBasto());
		this.maso.add(new CincoDeEspada());
		this.maso.add(new CuatroDeOro());
		this.maso.add(new CuatroDeCopa());
		this.maso.add(new CuatroDeBasto());
		this.maso.add(new CuatroDeEspada());
	}
	
	public TipoDeCartas dameCarta(){
		
		Random rnd = new Random();
		int index = (int) (rnd.nextDouble() * (maso.size()));
		TipoDeCartas CartaRetorno = this.maso.get(index);
		this.maso.remove(index);
		return CartaRetorno;
	}

}
