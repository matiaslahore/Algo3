package fiuba.algo3.tp2.modeloRondas;

public class EmpezarTruco extends TiposDeCantoTruco {

	public EmpezarTruco() {
		super("");
	}
	
	@Override
	public Truco cantar(String equipo){
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
