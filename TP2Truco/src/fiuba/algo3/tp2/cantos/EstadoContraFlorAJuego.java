package fiuba.algo3.tp2.cantos;

import fiuba.algo3.tp2.excepciones.CantoInvalidoException;
import fiuba.algo3.tp2.modelo.Equipo;
import fiuba.algo3.tp2.modelo.EventosJuez;

public class EstadoContraFlorAJuego extends EstadoCantoFlor{

	public EstadoContraFlorAJuego(Equipo equipoQueCanta) {
		super(equipoQueCanta);
		// TODO Auto-generated constructor stub
	}

	@Override
	public EstadoCantoFlor cantarFlor(Equipo equipoQueCanta) throws CantoInvalidoException {
		throw new CantoInvalidoException();
	}

	@Override
	public EstadoCantoFlor cantarContraFlor(Equipo equipoQueCanta) throws CantoInvalidoException {
		throw new CantoInvalidoException();
	}

	@Override
	public EstadoCantoFlor cantarContraFlorAJuego(Equipo equipoQueCanta) throws CantoInvalidoException {
		throw new CantoInvalidoException();
	}

	@Override
	public int noQuiso() {
		return 3;
	}

	@Override
	public int quiso() {
		return 30;
	}
	
	@Override
	public void avisarAPartida(EventosJuez eventosJuez) {
		eventosJuez.cantoContraFlorAJuego(this.equipoQueCanta);
	}

}
