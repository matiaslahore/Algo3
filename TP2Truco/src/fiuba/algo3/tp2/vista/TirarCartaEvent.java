package fiuba.algo3.tp2.vista;

import fiuba.algo3.tp2.modelo.PartidaDeTruco;
import fiuba.algo3.tp2.modeloDeCartas.Carta;
import javafx.event.Event;
import javafx.scene.Scene;
import javafx.scene.input.*;
import javafx.stage.Stage;

@SuppressWarnings({ "hiding", "rawtypes" })
public class TirarCartaEvent<MouseEvent> implements javafx.event.EventHandler {

	private Carta carta;
	private PartidaDeTruco partida;
	private Visualizador visual;
	private Stage stageJugador;
	private Stage stageMesa;
	
	public TirarCartaEvent(PartidaDeTruco partida, Carta carta, Visualizador visual, Stage stageJugador, Stage stageMesa){
		this.partida = partida;
		this.carta = carta;
		this.visual = visual;
		this.stageJugador = stageJugador;
		this.stageMesa = stageMesa;
	}

	@Override
	public void handle(Event evento) {	
		System.out.println("tira");
		this.partida.jugarCarta(this.carta);
		
		Scene scene = this.visual.cargarSceneDelJugador();
        this.stageJugador.setScene(scene);
        
        Scene sceneMesa = this.visual.cargarSceneDeLaMesa();
        this.stageMesa.setScene(sceneMesa);
		
	}

}