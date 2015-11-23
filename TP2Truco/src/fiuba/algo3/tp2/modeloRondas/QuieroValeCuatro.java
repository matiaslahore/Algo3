package fiuba.algo3.tp2.modeloRondas;

public class QuieroValeCuatro extends TipoDeCantos{
	
	@Override
	public void canto(String equipo) {
		if (this.equipoQueCanta == equipo){
			return false;
		}
		else{
			this.equipoQueCanta = equipo;
			return true;
		}
	}

	@Override
	public void quiero() {
		//ver
	}

	@Override
	public void noQuiero() {
		//se va al mazo
	}

}
