package fiuba.algo3.tp2.modelo;

public class PartidaDeTrucoConIAConFlor extends PartidaDeTrucoConIA {

	public PartidaDeTrucoConIAConFlor(String nombreEq1, String nombreEq2) {
		super(nombreEq1, nombreEq2);
	}

	@Override
	public void cantarFlor() {
		this.equipoDos.obtenerJugadores().get(0).cantarEnvido();
		this.eventosIA.seCantoFlor();
	}

	@Override
	public void cantarContraFlor() {
		this.equipoDos.obtenerJugadores().get(0).cantarEnvido();
		this.eventosIA.seCantoContraFlor();
	}

	@Override
	public void cantarContraFlorAJuego() {
		this.equipoDos.obtenerJugadores().get(0).cantarEnvido();
		this.eventosIA.seCantoContraFlorAJuego();
	}
}
