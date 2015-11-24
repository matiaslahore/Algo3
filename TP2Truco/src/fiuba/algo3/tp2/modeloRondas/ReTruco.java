package fiuba.algo3.tp2.modeloRondas;

public class ReTruco extends TiposDeCantoTruco{

	public ReTruco(String equipo) {
		super(equipo);
	}

	@Override
	public int quiso() {
		return 3;
	}

	@Override
	public int noQuiso() {
		return 2;
	}

	@Override
	public TiposDeCantoTruco cantar(String equipo) throws EquipoQueCantaNoPuedeVolverACantarException {
		if(this.equipoQueCanta == equipo){
			throw new EquipoQueCantaNoPuedeVolverACantarException();
		}
		return(new ValeCuatro(equipo));
	}

}
