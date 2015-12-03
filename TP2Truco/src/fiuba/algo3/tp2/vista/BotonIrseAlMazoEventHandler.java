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
	private Label etiqueta;
	private Visualizador visual;
	private Stage stage;
	
	//constructor
	public BotonIrseAlMazoEventHandler (Visualizador visual, Stage stage, PartidaDeTruco partida, Label etiqueta){
		this.partida= partida;
		this.etiqueta= etiqueta;
		this.visual = visual;
		this.stage = stage;
	}
	
	@Override
	public void handle(ActionEvent actionEvent){
        try{
    	  this.partida.irseAlMazo();
    		} catch (CantoInvalidoException IrseAlMazoError){
    			etiqueta.setText("NO DEBERIA TIRAR EXCEPCION");
    	        etiqueta.setTextFill(Color.web("#FF0000"));
    		}
    		etiqueta.setText("ME VOY AL MAZO!");
            etiqueta.setTextFill(Color.web("#008000"));
            
            //esto no va aca pero para probar
            Scene scene= this.visual.ventanaPrincipal(stage);
            this.stage.setScene(scene);
	}

}