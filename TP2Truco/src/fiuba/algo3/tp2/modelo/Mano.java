package fiuba.algo3.tp2.modelo;

public class Mano{
     
     EstadoDeMano estado;
     
     public Mano(){
    	 estado=new EstadoManoInicial();
     }
     
     public void rondaUno
     
     public void cantarTruco (){
    	 this.estado.cantarTruco(); //dependiendo en el estado que este 
    	                            // va a poder responder con envido
    	                            // o solo seguir el truco.
     }
     
     public void cantarEnvido (){
    	 this.estado.cantarEnvido();
    	 // espero respuesta haber que sucede
    	 
    	 // y cambio de estado la partida 
    	 this.estado= new EstadoManoFinal(); 
    	
     }
}
