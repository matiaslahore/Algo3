package fiuba.algo3.tp2.vista;



import fiuba.algo3.tp2.excepciones.CantoInvalidoException;
import fiuba.algo3.tp2.modelo.PartidaDeTruco;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class BotonIrseAlMazoEventHandler implements EventHandler<ActionEvent>{
	
	private PartidaDeTruco partida;
	private Visualizador visual;
	private Stage stageJugador;
	private Stage stageMesa;
	private Label etiqueta;
	
	//constructor
	public BotonIrseAlMazoEventHandler (PartidaDeTruco partida, Visualizador visual, Stage stageJugador, Stage stageMesa,Label etiqueta){
		this.partida= partida;
		this.visual = visual;
		this.stageJugador = stageJugador;
		this.stageMesa = stageMesa;
		this.etiqueta= etiqueta;
	}
	
	@Override
	public void handle(ActionEvent actionEvent){
        try{
    	  this.partida.irseAlMazo();
    		} catch (CantoInvalidoException IrseAlMazoError){
    			etiqueta.setText("NO DEBERIA APARECER NUNCA");
    		}
            etiqueta.setText("ME VOY AL MAZO!");
    		Scene scene = this.visual.cargarSceneDelJugador();
            this.stageJugador.setScene(scene);
            
            Scene sceneMesa = this.visual.cargarSceneDeLaMesa();
            this.stageMesa.setScene(sceneMesa);
	}

}