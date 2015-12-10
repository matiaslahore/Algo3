package fiuba.algo3.tp2.visualizador;

import org.junit.Assert;
import org.junit.Test;

import fiuba.algo3.tp2.vista.ImagenesCarta;

public class ImagenesCartaTest {
      
	ImagenesCarta imagenesCarta = new ImagenesCarta();
	
	@Test
	public void pruebaTodosLosNombresDeCartas(){
	
	Assert.assertEquals("/fiuba/algo3/tp2/vista/imagenes/c2.jpg", this.imagenesCarta.obtenerDireccionDeCarta("Dos De Copa"));
	Assert.assertEquals("/fiuba/algo3/tp2/vista/imagenes/c3.jpg", this.imagenesCarta.obtenerDireccionDeCarta("Tres De Copa"));
	Assert.assertEquals("/fiuba/algo3/tp2/vista/imagenes/c4.jpg", this.imagenesCarta.obtenerDireccionDeCarta("Cuatro De Copa"));
	
	//basto
	Assert.assertEquals("/fiuba/algo3/tp2/vista/imagenes/b3.jpg", this.imagenesCarta.obtenerDireccionDeCarta("Tres De Basto"));
	Assert.assertEquals("/fiuba/algo3/tp2/vista/imagenes/b4.jpg", this.imagenesCarta.obtenerDireccionDeCarta("Cuatro De Basto"));
	Assert.assertEquals("/fiuba/algo3/tp2/vista/imagenes/b5.jpg", this.imagenesCarta.obtenerDireccionDeCarta("Cinco De Basto"));
	Assert.assertEquals("/fiuba/algo3/tp2/vista/imagenes/b6.jpg", this.imagenesCarta.obtenerDireccionDeCarta("Seis De Basto"));	
	 Assert.assertEquals("/fiuba/algo3/tp2/vista/imagenes/b7.jpg", this.imagenesCarta.obtenerDireccionDeCarta("Siete De Basto"));
	 Assert.assertEquals("/fiuba/algo3/tp2/vista/imagenes/b12.jpg", this.imagenesCarta.obtenerDireccionDeCarta("Doce De Basto"));
	 Assert.assertEquals("/fiuba/algo3/tp2/vista/imagenes/b11.jpg", this.imagenesCarta.obtenerDireccionDeCarta("Once De Basto"));
	 Assert.assertEquals("/fiuba/algo3/tp2/vista/imagenes/b10.jpg", this.imagenesCarta.obtenerDireccionDeCarta("Diez De Basto"));

	}
}
