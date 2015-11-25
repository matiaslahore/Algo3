package fiuba.algo3.tp2.tiposDeCanto;

import fiuba.algo3.tp2.excepciones.CantoInvalidoException;

public class ContraFlorAJuego extends TiposDeCantoFlor{

	public ContraFlorAJuego(String equipoQueCanta) {
		super(equipoQueCanta);
		// TODO Auto-generated constructor stub
	}

	@Override
	public TiposDeCantoFlor cantarFlor(String equipoQueCanta) throws CantoInvalidoException {
		throw new CantoInvalidoException();
	}

	@Override
	public TiposDeCantoFlor cantarContraFlor(String equipoQueCanta) throws CantoInvalidoException {
		throw new CantoInvalidoException();
	}

	@Override
	public TiposDeCantoFlor cantarContraFlorAJuego(String equipoQueCanta) throws CantoInvalidoException {
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

}
