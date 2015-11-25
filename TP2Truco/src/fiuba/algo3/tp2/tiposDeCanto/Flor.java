package fiuba.algo3.tp2.tiposDeCanto;

import fiuba.algo3.tp2.excepciones.CantoInvalidoException;

public class Flor extends TiposDeCantoFlor {

	public Flor(String equipoQueCanta) {
		super(equipoQueCanta);
	}

	@Override
	public TiposDeCantoFlor cantarFlor(String equipoQueCanta) throws CantoInvalidoException {
		throw new CantoInvalidoException();
	}

	@Override
	public ContraFlor cantarContraFlor(String equipoQueCanta) throws CantoInvalidoException {
		return(new ContraFlor(equipoQueCanta));
	}

	@Override
	public ContraFlorAJuego cantarContraFlorAJuego(String equipoQueCanta) throws CantoInvalidoException {
		return(new ContraFlorAJuego(equipoQueCanta));
	}

	@Override
	public int noQuiso() {
		return 3;
	}

	@Override
	public int quiso() {
		return 3;
	}

}
