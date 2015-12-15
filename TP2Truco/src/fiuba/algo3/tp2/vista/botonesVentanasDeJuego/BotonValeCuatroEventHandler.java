package fiuba.algo3.tp2.vista.botonesVentanasDeJuego;

import fiuba.algo3.tp2.excepciones.CantoInvalidoException;
import fiuba.algo3.tp2.excepciones.EquipoQueCantaNoPuedeVolverACantarException;
import fiuba.algo3.tp2.modelo.PartidaDeTruco;
import fiuba.algo3.tp2.vista.VentanasDelJuego;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class BotonValeCuatroEventHandler implements EventHandler<ActionEvent>{

	private PartidaDeTruco partida;
	private VentanasDelJuego visual;

	//constructor
	public BotonValeCuatroEventHandler(PartidaDeTruco partida, VentanasDelJuego visual){
		this.partida= partida;
		this.visual = visual;
	}

	@Override
	public void handle(ActionEvent actionEvent){
		try{
			this.partida.cantarQuieroValeCuatro();
			visual.modificarEtiquetaInformacion(this.partida.obtenerNombreDelJugadorConTurno() + " CANTO: "+ "  QUIERO VALE CUAAATRO!!!");
			this.visual.modificarStageJugador();
			this.visual.modificarStageCartasEnMesa();

		} catch (CantoInvalidoException | EquipoQueCantaNoPuedeVolverACantarException e){
		}
	}

}