package fiuba.algo3.tp2.tiposDeCanto;

import fiuba.algo3.tp2.excepciones.CantoInvalidoException;

public class ContraFlor extends TiposDeCantoFlor{

	public ContraFlor(String equipoQueCanta) {
		super(equipoQueCanta);
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
	public ContraFlorAJuego cantarContraFlorAJuego(String equipoQueCanta) throws CantoInvalidoException {
		return(new ContraFlorAJuego(equipoQueCanta));
	}

	@Override
	public int noQuiso() {
		return 3;
	}

	@Override
	public int quiso() {
		return 6;
	}

}
