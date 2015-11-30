package fiuba.algo3.tp2.vista;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class ImagenesCarta {
	
	private Map<String,String> cartas;
	
	public void ImaganesCarta(){
		
		this.cartas = new HashMap<String,String>();
		//copas
        this.cartas.put("Uno De Copa","/fiuba/algo3/tp2/vista/c1.jpg");
        this.cartas.put("Dos De Copa", "/fiuba/algo3/tp2/vista/imagenes/c2.jpg");
        this.cartas.put("Tres De Copa", "/fiuba/algo3/tp2/vista/imagenes/c3.jpg");
        this.cartas.put("Cuatro De Copa", "/fiuba/algo3/tp2/vista/imagenes/c4.jpg");
        this.cartas.put("Cinco De Copa", "/fiuba/algo3/tp2/vista/imagenes/c5.jpg");
        this.cartas.put("Seis De Copa", "/fiuba/algo3/tp2/vista/imagenes/c6.jpg");
        this.cartas.put("Siete De Copa", "/fiuba/algo3/tp2/vista/imagenes/c7.jpg");
        this.cartas.put("Diez De Copa", "/fiuba/algo3/tp2/vista/imagenes/c10.jpg");
        this.cartas.put("Once De Copa", "/fiuba/algo3/tp2/vista/imagenes/c11.jpg");
        this.cartas.put("Doce De Copa", "/fiuba/algo3/tp2/vista/imagenes/c12.jpg");
        //oro
        this.cartas.put("Uno De Oro", "/fiuba/algo3/tp2/vista/imagenes/o1.jpg");
        this.cartas.put("Dos De Oro", "/fiuba/algo3/tp2/vista/imagenes/o2.jpg");
        this.cartas.put("Tres De Oro", "/fiuba/algo3/tp2/vista/imagenes/o3.jpg");
        this.cartas.put("Cuatro De Oro", "/fiuba/algo3/tp2/vista/imagenes/o4.jpg");
        this.cartas.put("Cinco De Oro", "/fiuba/algo3/tp2/vista/imagenes/o5.jpg");
        this.cartas.put("Seis De Oro", "/fiuba/algo3/tp2/vista/imagenes/o6.jpg");
        this.cartas.put("Siete De Oro", "/fiuba/algo3/tp2/vista/imagenes/o7.jpg");
        this.cartas.put("Diez De Oro", "/fiuba/algo3/tp2/vista/imagenes/o10.jpg");
        this.cartas.put("Once De Oro", "/fiuba/algo3/tp2/vista/imagenes/o11.jpg");
        this.cartas.put("Doce De Oro", "/fiuba/algo3/tp2/vista/imagenes/o12.jpg");
        //espada
        this.cartas.put("Uno De Espada", "/fiuba/algo3/tp2/vista/imagenes/e1.jpg");
        this.cartas.put("Dos De Espada", "/fiuba/algo3/tp2/vista/imagenes/e2.jpg");
        this.cartas.put("Tres De Espada", "/fiuba/algo3/tp2/vista/imagenes/e3.jpg");
        this.cartas.put("Cuatro De Espada", "/fiuba/algo3/tp2/vista/imagenes/e4.jpg");
        this.cartas.put("Cinco De Espada", "/fiuba/algo3/tp2/vista/imagenes/e5.jpg");
        this.cartas.put("Seis De Espada", "/fiuba/algo3/tp2/vista/imagenes/e6.jpg");
        this.cartas.put("Siete De Espada", "/fiuba/algo3/tp2/vista/imagenes/e7.jpg");
        this.cartas.put("Diez De Espada", "/fiuba/algo3/tp2/vista/imagenes/e10.jpg");
        this.cartas.put("Once De Espada", "/fiuba/algo3/tp2/vista/imagenes/e11.jpg");
        this.cartas.put("Doce De Espada", "/fiuba/algo3/tp2/vista/imagenes/e12.jpg");
        //basto
        this.cartas.put("Uno De Basto", "/fiuba/algo3/tp2/vista/imagenes/b1.jpg");
        this.cartas.put("Dos De Basto", "/fiuba/algo3/tp2/vista/imagenes/b2.jpg");
        this.cartas.put("Tres De Basto", "/fiuba/algo3/tp2/vista/imagenes/b3.jpg");
        this.cartas.put("Cuatro De Basto", "/fiuba/algo3/tp2/vista/imagenes/b4.jpg");
        this.cartas.put("Cinco De Basto", "/fiuba/algo3/tp2/vista/imagenes/b5.jpg");
        this.cartas.put("Seis De Basto", "/fiuba/algo3/tp2/vista/imagenes/b6.jpg");
        this.cartas.put("Siete De Basto", "/fiuba/algo3/tp2/vista/imagenes/b7.jpg");
        this.cartas.put("Diez De Basto", "/fiuba/algo3/tp2/vista/imagenes/b10.jpg");
        this.cartas.put("Once De Basto", "/fiuba/algo3/tp2/vista/imagenes/b11.jpg");
        this.cartas.put("Doce De Basto", "/fiuba/algo3/tp2/vista/imagenes/b12.jpg");
        
	}
	
	public String obtenerDireccionDeCarta (String nombreDeLaCarta){
		return this.cartas.get(nombreDeLaCarta);
	}
	
}
