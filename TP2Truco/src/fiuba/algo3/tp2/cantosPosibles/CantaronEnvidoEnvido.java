package fiuba.algo3.tp2.cantosPosibles;

import fiuba.algo3.tp2.vista.ContenedorDeBotones;
import javafx.scene.layout.VBox;

public class CantaronEnvidoEnvido implements CantosPosiblesEntreEquipos {

	@Override
	public VBox botonesParaCanto(ContenedorDeBotones contenedor) {
		return contenedor.botonesPara(this);
	}
	
}
