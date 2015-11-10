package fiuba.algo3.tp2.modelo;

public class EstadoManoInicial implements EstadoDeMano {
         
	Envido envido;
    Truco truco;
    
    public void cantarEnvido(){
    	this.envido= new Envido();
    }
    
    
    
    public void cantarTruco(){
    	//si cantan truco en este estado inicial de la partida
    	// le tiene que dejar la posibilidad de cantar el envido 
    	// al equipo contrario
    }
    
    public void cantarFlor (){
    	// ver el tema de como implementar flor
    }
    
}
