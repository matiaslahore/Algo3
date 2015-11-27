package fiuba.algo3.tp2.tiposDeCanto;

import fiuba.algo3.tp2.modelo.Equipo;

public class EmpezarTruco extends TiposDeCantoTruco {

	public EmpezarTruco() {
		super(null);
	}
	
	@Override
	public Truco cantar(Equipo equipo){
		return(new Truco(equipo));
	}

	@Override
	public int quiso() {
		// TODO Auto-generated method stub
		return 1;
	}

	@Override
	public int noQuiso() {
		// TODO Auto-generated method stub
		return 1;
	}

}
