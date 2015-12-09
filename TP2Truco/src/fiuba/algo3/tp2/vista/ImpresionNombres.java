package fiuba.algo3.tp2.vista;

import javafx.event.EventHandler;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

public class ImpresionNombres implements EventHandler<KeyEvent>{
	
	Stage stage;
	TextField textoIngresado;
	
	
	public ImpresionNombres (Stage stage, TextField textoIngresado){
		
		this.stage=stage;
		this.textoIngresado=textoIngresado;
	}
	
	 @Override
     public void handle(KeyEvent ke)
     {
         if (ke.getCode().equals(KeyCode.ENTER))
         {
           String ingresado= this.textoIngresado.getText(); 
           this.stage.close();
         }
     }
	

}
