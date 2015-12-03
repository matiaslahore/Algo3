package fiuba.algo3.tp2.vista;

import fiuba.algo3.tp2.excepciones.CantoInvalidoException;
import fiuba.algo3.tp2.modelo.PartidaDeTruco;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class BotonEnvidoEventHandler implements EventHandler<ActionEvent>{
	
	private PartidaDeTruco partida;
	private Label etiqueta;
	private Visualizador visual;
	private Stage stageJugador;
	private Stage stageMesa;
	
	//constructor
	public BotonEnvidoEventHandler (PartidaDeTruco partida, Visualizador visual, Stage stageJugador, Stage stageMesa){
		this.partida= partida;
		this.visual = visual;
		this.stageJugador = stageJugador;
		this.stageMesa = stageMesa;
	}
	
	@Override
	public void handle(ActionEvent actionEvent){
		System.out.println("ENVIDO");
		try{
			this.partida.cantarEnvido();
		} catch (CantoInvalidoException envidoError){
			etiqueta.setText("NO PUEDE CANTAR ENVIDO");
	        etiqueta.setTextFill(Color.web("#FF0000"));
		}
		etiqueta.setText("RONDA EN ESTADO: ENVIDO");
        etiqueta.setTextFill(Color.web("#FF0000"));
        
        Scene scene = this.visual.cargarSceneDelJugador();
        this.stageJugador.setScene(scene);
        
        Scene sceneMesa = this.visual.cargarSceneDeLaMesa();
        this.stageMesa.setScene(sceneMesa);
	}

}
