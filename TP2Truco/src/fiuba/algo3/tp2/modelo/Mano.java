package fiuba.algo3.tp2.modelo;

public class Mano implements EstadoDeMano{
     
     EstadoDeMano estado;
     
     public Mano(){
    	 estado=new EstadoManoInicial();
     }
}
