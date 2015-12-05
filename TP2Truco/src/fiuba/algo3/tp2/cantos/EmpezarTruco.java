package fiuba.algo3.tp2.cantos;

import fiuba.algo3.tp2.excepciones.CantoInvalidoException;
import fiuba.algo3.tp2.modelo.Equipo;

public class EmpezarTruco extends CantosTruco {

	public EmpezarTruco() {
		super(null);
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

	@Override
	public CantosTruco cantarTruco(Equipo equipo) {
		return(new Truco(equipo));
	}

	@Override
	public CantosTruco cantarQuieroReTruco(Equipo equipo) {
		throw new CantoInvalidoException();
	}

	@Override
	public CantosTruco cantarQuieroValeCuatro(Equipo equipo) {
		throw new CantoInvalidoException();
	}

}
