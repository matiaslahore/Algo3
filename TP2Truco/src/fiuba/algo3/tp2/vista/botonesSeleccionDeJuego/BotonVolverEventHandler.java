package fiuba.algo3.tp2.vista.botonesSeleccionDeJuego;

import fiuba.algo3.tp2.vista.SeleccionDeJuego;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;

public class BotonVolverEventHandler implements EventHandler<ActionEvent> {
	
	private SeleccionDeJuego pantallaPrincipal;
    private Stage stage;
	
	public BotonVolverEventHandler (SeleccionDeJuego pantallaPrincipal, Stage stage){
		this.pantallaPrincipal= pantallaPrincipal;
		this.stage= stage;
	}
	
	@Override
	public void handle (ActionEvent actionEvent){
		this.stage.close();
		this.pantallaPrincipal.cargarPantallaPrincipal(stage);
	}

}
