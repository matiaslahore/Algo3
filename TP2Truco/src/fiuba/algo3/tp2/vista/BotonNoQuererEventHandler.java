package fiuba.algo3.tp2.vista;



import fiuba.algo3.tp2.excepciones.CantoInvalidoException;
import fiuba.algo3.tp2.modelo.PartidaDeTruco;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;

public class BotonNoQuererEventHandler implements EventHandler<ActionEvent>{
	
	private PartidaDeTruco partida;
	private Label etiqueta;
	
	//constructor
	public BotonNoQuererEventHandler (PartidaDeTruco partida, Label etiqueta){
		this.partida= partida;
		this.etiqueta= etiqueta;
	}
	
	@Override
	public void handle(ActionEvent actionEvent){
        try{
    	  this.partida.noQuiero();
    		} catch (CantoInvalidoException noQuererError){
    			etiqueta.setText("NO SE CANTO NADA");
    	        etiqueta.setTextFill(Color.web("#FF0000"));
    		}
    		etiqueta.setText("NO QUIERO!");
            etiqueta.setTextFill(Color.web("#008000"));
	}

}