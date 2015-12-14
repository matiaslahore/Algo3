package fiuba.algo3.tp2.cantos;

import fiuba.algo3.tp2.excepciones.CantoInvalidoException;
import fiuba.algo3.tp2.modelo.Equipo;
import fiuba.algo3.tp2.modelo.EventosJuez;

public class EstadoContraFlor extends EstadoCantoFlor{

	public EstadoContraFlor(Equipo equipoQueCanta) {
		super(equipoQueCanta);
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
	public EstadoContraFlorAJuego cantarContraFlorAJuego(Equipo equipoQueCanta) throws CantoInvalidoException {
		return(new EstadoContraFlorAJuego(equipoQueCanta));
	}

	@Override
	public int noQuiso() {
		return 3;
	}

	@Override
	public int quiso() {
		return 6;
	}
	
	@Override
	public void avisarAPartida(EventosJuez eventosJuez) {
		eventosJuez.cantoContraFlor(this.equipoQueCanta);
	}

}
