package fiuba.algo3.tp2.visualizador;

import org.junit.Assert;
import org.junit.Test;

import fiuba.algo3.tp2.vista.ImagenesCarta;

public class ImagenesCartaTest {
      
	ImagenesCarta imagenesCarta= new ImagenesCarta();
	
	@Test
	public void pruebaTodosLosNombresDeCartas(){
	 Assert.assertEquals("/fiuba/algo3/tp2/vista/imagenes/b7.jpg", this.imagenesCarta.obtenerDireccionDeCarta("Siete De Basto"));
	 Assert.assertEquals("/fiuba/algo3/tp2/vista/imagenes/b12.jpg", this.imagenesCarta.obtenerDireccionDeCarta("Doce De Basto"));
	 Assert.assertEquals("/fiuba/algo3/tp2/vista/imagenes/b11.jpg", this.imagenesCarta.obtenerDireccionDeCarta("Once De Basto"));
	 Assert.assertEquals("/fiuba/algo3/tp2/vista/imagenes/b10.jpg", this.imagenesCarta.obtenerDireccionDeCarta("Diez De Basto"));

	}
}
