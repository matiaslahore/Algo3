package fiuba.algo3.tp2.modeloDeCartas;

import org.junit.Assert;
import org.junit.Test;

public class PruebaSumarTantoTodasLasCartas {

	@Test 
	public void pruebaTodosLosTantosEspada(){
		Assert.assertEquals(23, new AnchoDeEspada().sumarTanto(new DosDeEspada()));
		Assert.assertEquals(24, new AnchoDeEspada().sumarTanto(new TresDeEspada()));
		Assert.assertEquals(25, new AnchoDeEspada().sumarTanto(new CuatroDeEspada()));
		Assert.assertEquals(26, new AnchoDeEspada().sumarTanto(new CincoDeEspada()));
		Assert.assertEquals(27, new AnchoDeEspada().sumarTanto(new SeisDeEspada()));
		Assert.assertEquals(28, new AnchoDeEspada().sumarTanto(new SieteDeEspada()));
		Assert.assertEquals(21, new AnchoDeEspada().sumarTanto(new SotaDeEspada()));
		Assert.assertEquals(21, new AnchoDeEspada().sumarTanto(new CaballoDeEspada()));
		Assert.assertEquals(21, new AnchoDeEspada().sumarTanto(new ReyDeEspada()));
		
		Assert.assertEquals(23, new DosDeEspada().sumarTanto(new AnchoDeEspada()));
		Assert.assertEquals(25, new DosDeEspada().sumarTanto(new TresDeEspada()));
		Assert.assertEquals(26, new DosDeEspada().sumarTanto(new CuatroDeEspada()));
		Assert.assertEquals(27, new DosDeEspada().sumarTanto(new CincoDeEspada()));
		Assert.assertEquals(28, new DosDeEspada().sumarTanto(new SeisDeEspada()));
		Assert.assertEquals(29, new DosDeEspada().sumarTanto(new SieteDeEspada()));
		Assert.assertEquals(22, new DosDeEspada().sumarTanto(new SotaDeEspada()));
		Assert.assertEquals(22, new DosDeEspada().sumarTanto(new CaballoDeEspada()));
		Assert.assertEquals(22, new DosDeEspada().sumarTanto(new ReyDeEspada()));
		
		Assert.assertEquals(24, new TresDeEspada().sumarTanto(new AnchoDeEspada()));
		Assert.assertEquals(25, new TresDeEspada().sumarTanto(new DosDeEspada()));
		Assert.assertEquals(27, new TresDeEspada().sumarTanto(new CuatroDeEspada()));
		Assert.assertEquals(28, new TresDeEspada().sumarTanto(new CincoDeEspada()));
		Assert.assertEquals(29, new TresDeEspada().sumarTanto(new SeisDeEspada()));
		Assert.assertEquals(30, new TresDeEspada().sumarTanto(new SieteDeEspada()));
		Assert.assertEquals(23, new TresDeEspada().sumarTanto(new SotaDeEspada()));
		Assert.assertEquals(23, new TresDeEspada().sumarTanto(new CaballoDeEspada()));
		Assert.assertEquals(23, new TresDeEspada().sumarTanto(new ReyDeEspada()));
		
		Assert.assertEquals(25, new CuatroDeEspada().sumarTanto(new AnchoDeEspada()));
		Assert.assertEquals(26, new CuatroDeEspada().sumarTanto(new DosDeEspada()));
		Assert.assertEquals(27, new CuatroDeEspada().sumarTanto(new TresDeEspada()));
		Assert.assertEquals(29, new CuatroDeEspada().sumarTanto(new CincoDeEspada()));
		Assert.assertEquals(30, new CuatroDeEspada().sumarTanto(new SeisDeEspada()));
		Assert.assertEquals(31, new CuatroDeEspada().sumarTanto(new SieteDeEspada()));
		Assert.assertEquals(24, new CuatroDeEspada().sumarTanto(new SotaDeEspada()));
		Assert.assertEquals(24, new CuatroDeEspada().sumarTanto(new CaballoDeEspada()));
		Assert.assertEquals(24, new CuatroDeEspada().sumarTanto(new ReyDeEspada()));
		
		Assert.assertEquals(26, new CincoDeEspada().sumarTanto(new AnchoDeEspada()));
		Assert.assertEquals(27, new CincoDeEspada().sumarTanto(new DosDeEspada()));
		Assert.assertEquals(28, new CincoDeEspada().sumarTanto(new TresDeEspada()));
		Assert.assertEquals(29, new CincoDeEspada().sumarTanto(new CuatroDeEspada()));
		Assert.assertEquals(31, new CincoDeEspada().sumarTanto(new SeisDeEspada()));
		Assert.assertEquals(32, new CincoDeEspada().sumarTanto(new SieteDeEspada()));
		Assert.assertEquals(25, new CincoDeEspada().sumarTanto(new SotaDeEspada()));
		Assert.assertEquals(25, new CincoDeEspada().sumarTanto(new CaballoDeEspada()));
		Assert.assertEquals(25, new CincoDeEspada().sumarTanto(new ReyDeEspada()));
		
		Assert.assertEquals(27, new SeisDeEspada().sumarTanto(new AnchoDeEspada()));
		Assert.assertEquals(28, new SeisDeEspada().sumarTanto(new DosDeEspada()));
		Assert.assertEquals(29, new SeisDeEspada().sumarTanto(new TresDeEspada()));
		Assert.assertEquals(30, new SeisDeEspada().sumarTanto(new CuatroDeEspada()));
		Assert.assertEquals(31, new SeisDeEspada().sumarTanto(new CincoDeEspada()));
		Assert.assertEquals(33, new SeisDeEspada().sumarTanto(new SieteDeEspada()));
		Assert.assertEquals(26, new SeisDeEspada().sumarTanto(new SotaDeEspada()));
		Assert.assertEquals(26, new SeisDeEspada().sumarTanto(new CaballoDeEspada()));
		Assert.assertEquals(26, new SeisDeEspada().sumarTanto(new ReyDeEspada()));
		
		Assert.assertEquals(28, new SieteDeEspada().sumarTanto(new AnchoDeEspada()));
		Assert.assertEquals(29, new SieteDeEspada().sumarTanto(new DosDeEspada()));
		Assert.assertEquals(30, new SieteDeEspada().sumarTanto(new TresDeEspada()));
		Assert.assertEquals(31, new SieteDeEspada().sumarTanto(new CuatroDeEspada()));
		Assert.assertEquals(32, new SieteDeEspada().sumarTanto(new CincoDeEspada()));
		Assert.assertEquals(33, new SieteDeEspada().sumarTanto(new SeisDeEspada()));
		Assert.assertEquals(27, new SieteDeEspada().sumarTanto(new SotaDeEspada()));
		Assert.assertEquals(27, new SieteDeEspada().sumarTanto(new CaballoDeEspada()));
		Assert.assertEquals(27, new SieteDeEspada().sumarTanto(new ReyDeEspada()));
		
		Assert.assertEquals(21, new SotaDeEspada().sumarTanto(new AnchoDeEspada()));
		Assert.assertEquals(22, new SotaDeEspada().sumarTanto(new DosDeEspada()));
		Assert.assertEquals(23, new SotaDeEspada().sumarTanto(new TresDeEspada()));
		Assert.assertEquals(24, new SotaDeEspada().sumarTanto(new CuatroDeEspada()));
		Assert.assertEquals(25, new SotaDeEspada().sumarTanto(new CincoDeEspada()));
		Assert.assertEquals(26, new SotaDeEspada().sumarTanto(new SeisDeEspada()));
		Assert.assertEquals(27, new SotaDeEspada().sumarTanto(new SieteDeEspada()));
		Assert.assertEquals(20, new SotaDeEspada().sumarTanto(new CaballoDeEspada()));
		Assert.assertEquals(20, new SotaDeEspada().sumarTanto(new ReyDeEspada()));
		
		Assert.assertEquals(21, new CaballoDeEspada().sumarTanto(new AnchoDeEspada()));
		Assert.assertEquals(22, new CaballoDeEspada().sumarTanto(new DosDeEspada()));
		Assert.assertEquals(23, new CaballoDeEspada().sumarTanto(new TresDeEspada()));
		Assert.assertEquals(24, new CaballoDeEspada().sumarTanto(new CuatroDeEspada()));
		Assert.assertEquals(25, new CaballoDeEspada().sumarTanto(new CincoDeEspada()));
		Assert.assertEquals(26, new CaballoDeEspada().sumarTanto(new SeisDeEspada()));
		Assert.assertEquals(27, new CaballoDeEspada().sumarTanto(new SieteDeEspada()));
		Assert.assertEquals(20, new CaballoDeEspada().sumarTanto(new SotaDeEspada()));
		Assert.assertEquals(20, new CaballoDeEspada().sumarTanto(new ReyDeEspada()));
		
		Assert.assertEquals(21, new ReyDeEspada().sumarTanto(new AnchoDeEspada()));
		Assert.assertEquals(22, new ReyDeEspada().sumarTanto(new DosDeEspada()));
		Assert.assertEquals(23, new ReyDeEspada().sumarTanto(new TresDeEspada()));
		Assert.assertEquals(24, new ReyDeEspada().sumarTanto(new CuatroDeEspada()));
		Assert.assertEquals(25, new ReyDeEspada().sumarTanto(new CincoDeEspada()));
		Assert.assertEquals(26, new ReyDeEspada().sumarTanto(new SeisDeEspada()));
		Assert.assertEquals(27, new ReyDeEspada().sumarTanto(new SieteDeEspada()));
		Assert.assertEquals(20, new ReyDeEspada().sumarTanto(new SotaDeEspada()));
		Assert.assertEquals(20, new ReyDeEspada().sumarTanto(new CaballoDeEspada()));
	}
	
	@Test 
	public void pruebaTodosLosTantosBasto(){
		Assert.assertEquals(23, new AnchoDeBasto().sumarTanto(new DosDeBasto()));
		Assert.assertEquals(24, new AnchoDeBasto().sumarTanto(new TresDeBasto()));
		Assert.assertEquals(25, new AnchoDeBasto().sumarTanto(new CuatroDeBasto()));
		Assert.assertEquals(26, new AnchoDeBasto().sumarTanto(new CincoDeBasto()));
		Assert.assertEquals(27, new AnchoDeBasto().sumarTanto(new SeisDeBasto()));
		Assert.assertEquals(28, new AnchoDeBasto().sumarTanto(new SieteDeBasto()));
		Assert.assertEquals(21, new AnchoDeBasto().sumarTanto(new SotaDeBasto()));
		Assert.assertEquals(21, new AnchoDeBasto().sumarTanto(new CaballoDeBasto()));
		Assert.assertEquals(21, new AnchoDeBasto().sumarTanto(new ReyDeBasto()));
		
		Assert.assertEquals(23, new DosDeBasto().sumarTanto(new AnchoDeBasto()));
		Assert.assertEquals(25, new DosDeBasto().sumarTanto(new TresDeBasto()));
		Assert.assertEquals(26, new DosDeBasto().sumarTanto(new CuatroDeBasto()));
		Assert.assertEquals(27, new DosDeBasto().sumarTanto(new CincoDeBasto()));
		Assert.assertEquals(28, new DosDeBasto().sumarTanto(new SeisDeBasto()));
		Assert.assertEquals(29, new DosDeBasto().sumarTanto(new SieteDeBasto()));
		Assert.assertEquals(22, new DosDeBasto().sumarTanto(new SotaDeBasto()));
		Assert.assertEquals(22, new DosDeBasto().sumarTanto(new CaballoDeBasto()));
		Assert.assertEquals(22, new DosDeBasto().sumarTanto(new ReyDeBasto()));
		
		Assert.assertEquals(24, new TresDeBasto().sumarTanto(new AnchoDeBasto()));
		Assert.assertEquals(25, new TresDeBasto().sumarTanto(new DosDeBasto()));
		Assert.assertEquals(27, new TresDeBasto().sumarTanto(new CuatroDeBasto()));
		Assert.assertEquals(28, new TresDeBasto().sumarTanto(new CincoDeBasto()));
		Assert.assertEquals(29, new TresDeBasto().sumarTanto(new SeisDeBasto()));
		Assert.assertEquals(30, new TresDeBasto().sumarTanto(new SieteDeBasto()));
		Assert.assertEquals(23, new TresDeBasto().sumarTanto(new SotaDeBasto()));
		Assert.assertEquals(23, new TresDeBasto().sumarTanto(new CaballoDeBasto()));
		Assert.assertEquals(23, new TresDeBasto().sumarTanto(new ReyDeBasto()));
		
		Assert.assertEquals(25, new CuatroDeBasto().sumarTanto(new AnchoDeBasto()));
		Assert.assertEquals(26, new CuatroDeBasto().sumarTanto(new DosDeBasto()));
		Assert.assertEquals(27, new CuatroDeBasto().sumarTanto(new TresDeBasto()));
		Assert.assertEquals(29, new CuatroDeBasto().sumarTanto(new CincoDeBasto()));
		Assert.assertEquals(30, new CuatroDeBasto().sumarTanto(new SeisDeBasto()));
		Assert.assertEquals(31, new CuatroDeBasto().sumarTanto(new SieteDeBasto()));
		Assert.assertEquals(24, new CuatroDeBasto().sumarTanto(new SotaDeBasto()));
		Assert.assertEquals(24, new CuatroDeBasto().sumarTanto(new CaballoDeBasto()));
		Assert.assertEquals(24, new CuatroDeBasto().sumarTanto(new ReyDeBasto()));
		
		Assert.assertEquals(26, new CincoDeBasto().sumarTanto(new AnchoDeBasto()));
		Assert.assertEquals(27, new CincoDeBasto().sumarTanto(new DosDeBasto()));
		Assert.assertEquals(28, new CincoDeBasto().sumarTanto(new TresDeBasto()));
		Assert.assertEquals(29, new CincoDeBasto().sumarTanto(new CuatroDeBasto()));
		Assert.assertEquals(31, new CincoDeBasto().sumarTanto(new SeisDeBasto()));
		Assert.assertEquals(32, new CincoDeBasto().sumarTanto(new SieteDeBasto()));
		Assert.assertEquals(25, new CincoDeBasto().sumarTanto(new SotaDeBasto()));
		Assert.assertEquals(25, new CincoDeBasto().sumarTanto(new CaballoDeBasto()));
		Assert.assertEquals(25, new CincoDeBasto().sumarTanto(new ReyDeBasto()));
		
		Assert.assertEquals(27, new SeisDeBasto().sumarTanto(new AnchoDeBasto()));
		Assert.assertEquals(28, new SeisDeBasto().sumarTanto(new DosDeBasto()));
		Assert.assertEquals(29, new SeisDeBasto().sumarTanto(new TresDeBasto()));
		Assert.assertEquals(30, new SeisDeBasto().sumarTanto(new CuatroDeBasto()));
		Assert.assertEquals(31, new SeisDeBasto().sumarTanto(new CincoDeBasto()));
		Assert.assertEquals(33, new SeisDeBasto().sumarTanto(new SieteDeBasto()));
		Assert.assertEquals(26, new SeisDeBasto().sumarTanto(new SotaDeBasto()));
		Assert.assertEquals(26, new SeisDeBasto().sumarTanto(new CaballoDeBasto()));
		Assert.assertEquals(26, new SeisDeBasto().sumarTanto(new ReyDeBasto()));
		
		Assert.assertEquals(28, new SieteDeBasto().sumarTanto(new AnchoDeBasto()));
		Assert.assertEquals(29, new SieteDeBasto().sumarTanto(new DosDeBasto()));
		Assert.assertEquals(30, new SieteDeBasto().sumarTanto(new TresDeBasto()));
		Assert.assertEquals(31, new SieteDeBasto().sumarTanto(new CuatroDeBasto()));
		Assert.assertEquals(32, new SieteDeBasto().sumarTanto(new CincoDeBasto()));
		Assert.assertEquals(33, new SieteDeBasto().sumarTanto(new SeisDeBasto()));
		Assert.assertEquals(27, new SieteDeBasto().sumarTanto(new SotaDeBasto()));
		Assert.assertEquals(27, new SieteDeBasto().sumarTanto(new CaballoDeBasto()));
		Assert.assertEquals(27, new SieteDeBasto().sumarTanto(new ReyDeBasto()));
		
		Assert.assertEquals(21, new SotaDeBasto().sumarTanto(new AnchoDeBasto()));
		Assert.assertEquals(22, new SotaDeBasto().sumarTanto(new DosDeBasto()));
		Assert.assertEquals(23, new SotaDeBasto().sumarTanto(new TresDeBasto()));
		Assert.assertEquals(24, new SotaDeBasto().sumarTanto(new CuatroDeBasto()));
		Assert.assertEquals(25, new SotaDeBasto().sumarTanto(new CincoDeBasto()));
		Assert.assertEquals(26, new SotaDeBasto().sumarTanto(new SeisDeBasto()));
		Assert.assertEquals(27, new SotaDeBasto().sumarTanto(new SieteDeBasto()));
		Assert.assertEquals(20, new SotaDeBasto().sumarTanto(new CaballoDeBasto()));
		Assert.assertEquals(20, new SotaDeBasto().sumarTanto(new ReyDeBasto()));
		
		Assert.assertEquals(21, new CaballoDeBasto().sumarTanto(new AnchoDeBasto()));
		Assert.assertEquals(22, new CaballoDeBasto().sumarTanto(new DosDeBasto()));
		Assert.assertEquals(23, new CaballoDeBasto().sumarTanto(new TresDeBasto()));
		Assert.assertEquals(24, new CaballoDeBasto().sumarTanto(new CuatroDeBasto()));
		Assert.assertEquals(25, new CaballoDeBasto().sumarTanto(new CincoDeBasto()));
		Assert.assertEquals(26, new CaballoDeBasto().sumarTanto(new SeisDeBasto()));
		Assert.assertEquals(27, new CaballoDeBasto().sumarTanto(new SieteDeBasto()));
		Assert.assertEquals(20, new CaballoDeBasto().sumarTanto(new SotaDeBasto()));
		Assert.assertEquals(20, new CaballoDeBasto().sumarTanto(new ReyDeBasto()));
		
		Assert.assertEquals(21, new ReyDeBasto().sumarTanto(new AnchoDeBasto()));
		Assert.assertEquals(22, new ReyDeBasto().sumarTanto(new DosDeBasto()));
		Assert.assertEquals(23, new ReyDeBasto().sumarTanto(new TresDeBasto()));
		Assert.assertEquals(24, new ReyDeBasto().sumarTanto(new CuatroDeBasto()));
		Assert.assertEquals(25, new ReyDeBasto().sumarTanto(new CincoDeBasto()));
		Assert.assertEquals(26, new ReyDeBasto().sumarTanto(new SeisDeBasto()));
		Assert.assertEquals(27, new ReyDeBasto().sumarTanto(new SieteDeBasto()));
		Assert.assertEquals(20, new ReyDeBasto().sumarTanto(new SotaDeBasto()));
		Assert.assertEquals(20, new ReyDeBasto().sumarTanto(new CaballoDeBasto()));
	}
	
	@Test 
	public void pruebaTodosLosTantosOro(){
		Assert.assertEquals(23, new AnchoDeOro().sumarTanto(new DosDeOro()));
		Assert.assertEquals(24, new AnchoDeOro().sumarTanto(new TresDeOro()));
		Assert.assertEquals(25, new AnchoDeOro().sumarTanto(new CuatroDeOro()));
		Assert.assertEquals(26, new AnchoDeOro().sumarTanto(new CincoDeOro()));
		Assert.assertEquals(27, new AnchoDeOro().sumarTanto(new SeisDeOro()));
		Assert.assertEquals(28, new AnchoDeOro().sumarTanto(new SieteDeOro()));
		Assert.assertEquals(21, new AnchoDeOro().sumarTanto(new SotaDeOro()));
		Assert.assertEquals(21, new AnchoDeOro().sumarTanto(new CaballoDeOro()));
		Assert.assertEquals(21, new AnchoDeOro().sumarTanto(new ReyDeOro()));
		
		Assert.assertEquals(23, new DosDeOro().sumarTanto(new AnchoDeOro()));
		Assert.assertEquals(25, new DosDeOro().sumarTanto(new TresDeOro()));
		Assert.assertEquals(26, new DosDeOro().sumarTanto(new CuatroDeOro()));
		Assert.assertEquals(27, new DosDeOro().sumarTanto(new CincoDeOro()));
		Assert.assertEquals(28, new DosDeOro().sumarTanto(new SeisDeOro()));
		Assert.assertEquals(29, new DosDeOro().sumarTanto(new SieteDeOro()));
		Assert.assertEquals(22, new DosDeOro().sumarTanto(new SotaDeOro()));
		Assert.assertEquals(22, new DosDeOro().sumarTanto(new CaballoDeOro()));
		Assert.assertEquals(22, new DosDeOro().sumarTanto(new ReyDeOro()));
		
		Assert.assertEquals(24, new TresDeOro().sumarTanto(new AnchoDeOro()));
		Assert.assertEquals(25, new TresDeOro().sumarTanto(new DosDeOro()));
		Assert.assertEquals(27, new TresDeOro().sumarTanto(new CuatroDeOro()));
		Assert.assertEquals(28, new TresDeOro().sumarTanto(new CincoDeOro()));
		Assert.assertEquals(29, new TresDeOro().sumarTanto(new SeisDeOro()));
		Assert.assertEquals(30, new TresDeOro().sumarTanto(new SieteDeOro()));
		Assert.assertEquals(23, new TresDeOro().sumarTanto(new SotaDeOro()));
		Assert.assertEquals(23, new TresDeOro().sumarTanto(new CaballoDeOro()));
		Assert.assertEquals(23, new TresDeOro().sumarTanto(new ReyDeOro()));
		
		Assert.assertEquals(25, new CuatroDeOro().sumarTanto(new AnchoDeOro()));
		Assert.assertEquals(26, new CuatroDeOro().sumarTanto(new DosDeOro()));
		Assert.assertEquals(27, new CuatroDeOro().sumarTanto(new TresDeOro()));
		Assert.assertEquals(29, new CuatroDeOro().sumarTanto(new CincoDeOro()));
		Assert.assertEquals(30, new CuatroDeOro().sumarTanto(new SeisDeOro()));
		Assert.assertEquals(31, new CuatroDeOro().sumarTanto(new SieteDeOro()));
		Assert.assertEquals(24, new CuatroDeOro().sumarTanto(new SotaDeOro()));
		Assert.assertEquals(24, new CuatroDeOro().sumarTanto(new CaballoDeOro()));
		Assert.assertEquals(24, new CuatroDeOro().sumarTanto(new ReyDeOro()));
		
		Assert.assertEquals(26, new CincoDeOro().sumarTanto(new AnchoDeOro()));
		Assert.assertEquals(27, new CincoDeOro().sumarTanto(new DosDeOro()));
		Assert.assertEquals(28, new CincoDeOro().sumarTanto(new TresDeOro()));
		Assert.assertEquals(29, new CincoDeOro().sumarTanto(new CuatroDeOro()));
		Assert.assertEquals(31, new CincoDeOro().sumarTanto(new SeisDeOro()));
		Assert.assertEquals(32, new CincoDeOro().sumarTanto(new SieteDeOro()));
		Assert.assertEquals(25, new CincoDeOro().sumarTanto(new SotaDeOro()));
		Assert.assertEquals(25, new CincoDeOro().sumarTanto(new CaballoDeOro()));
		Assert.assertEquals(25, new CincoDeOro().sumarTanto(new ReyDeOro()));
		
		Assert.assertEquals(27, new SeisDeOro().sumarTanto(new AnchoDeOro()));
		Assert.assertEquals(28, new SeisDeOro().sumarTanto(new DosDeOro()));
		Assert.assertEquals(29, new SeisDeOro().sumarTanto(new TresDeOro()));
		Assert.assertEquals(30, new SeisDeOro().sumarTanto(new CuatroDeOro()));
		Assert.assertEquals(31, new SeisDeOro().sumarTanto(new CincoDeOro()));
		Assert.assertEquals(33, new SeisDeOro().sumarTanto(new SieteDeOro()));
		Assert.assertEquals(26, new SeisDeOro().sumarTanto(new SotaDeOro()));
		Assert.assertEquals(26, new SeisDeOro().sumarTanto(new CaballoDeOro()));
		Assert.assertEquals(26, new SeisDeOro().sumarTanto(new ReyDeOro()));
		
		Assert.assertEquals(28, new SieteDeOro().sumarTanto(new AnchoDeOro()));
		Assert.assertEquals(29, new SieteDeOro().sumarTanto(new DosDeOro()));
		Assert.assertEquals(30, new SieteDeOro().sumarTanto(new TresDeOro()));
		Assert.assertEquals(31, new SieteDeOro().sumarTanto(new CuatroDeOro()));
		Assert.assertEquals(32, new SieteDeOro().sumarTanto(new CincoDeOro()));
		Assert.assertEquals(33, new SieteDeOro().sumarTanto(new SeisDeOro()));
		Assert.assertEquals(27, new SieteDeOro().sumarTanto(new SotaDeOro()));
		Assert.assertEquals(27, new SieteDeOro().sumarTanto(new CaballoDeOro()));
		Assert.assertEquals(27, new SieteDeOro().sumarTanto(new ReyDeOro()));
		
		Assert.assertEquals(21, new SotaDeOro().sumarTanto(new AnchoDeOro()));
		Assert.assertEquals(22, new SotaDeOro().sumarTanto(new DosDeOro()));
		Assert.assertEquals(23, new SotaDeOro().sumarTanto(new TresDeOro()));
		Assert.assertEquals(24, new SotaDeOro().sumarTanto(new CuatroDeOro()));
		Assert.assertEquals(25, new SotaDeOro().sumarTanto(new CincoDeOro()));
		Assert.assertEquals(26, new SotaDeOro().sumarTanto(new SeisDeOro()));
		Assert.assertEquals(27, new SotaDeOro().sumarTanto(new SieteDeOro()));
		Assert.assertEquals(20, new SotaDeOro().sumarTanto(new CaballoDeOro()));
		Assert.assertEquals(20, new SotaDeOro().sumarTanto(new ReyDeOro()));
		
		Assert.assertEquals(21, new CaballoDeOro().sumarTanto(new AnchoDeOro()));
		Assert.assertEquals(22, new CaballoDeOro().sumarTanto(new DosDeOro()));
		Assert.assertEquals(23, new CaballoDeOro().sumarTanto(new TresDeOro()));
		Assert.assertEquals(24, new CaballoDeOro().sumarTanto(new CuatroDeOro()));
		Assert.assertEquals(25, new CaballoDeOro().sumarTanto(new CincoDeOro()));
		Assert.assertEquals(26, new CaballoDeOro().sumarTanto(new SeisDeOro()));
		Assert.assertEquals(27, new CaballoDeOro().sumarTanto(new SieteDeOro()));
		Assert.assertEquals(20, new CaballoDeOro().sumarTanto(new SotaDeOro()));
		Assert.assertEquals(20, new CaballoDeOro().sumarTanto(new ReyDeOro()));
		
		Assert.assertEquals(21, new ReyDeOro().sumarTanto(new AnchoDeOro()));
		Assert.assertEquals(22, new ReyDeOro().sumarTanto(new DosDeOro()));
		Assert.assertEquals(23, new ReyDeOro().sumarTanto(new TresDeOro()));
		Assert.assertEquals(24, new ReyDeOro().sumarTanto(new CuatroDeOro()));
		Assert.assertEquals(25, new ReyDeOro().sumarTanto(new CincoDeOro()));
		Assert.assertEquals(26, new ReyDeOro().sumarTanto(new SeisDeOro()));
		Assert.assertEquals(27, new ReyDeOro().sumarTanto(new SieteDeOro()));
		Assert.assertEquals(20, new ReyDeOro().sumarTanto(new SotaDeOro()));
		Assert.assertEquals(20, new ReyDeOro().sumarTanto(new CaballoDeOro()));
	}
	
	@Test 
	public void pruebaTodosLosTantosCopa(){
		Assert.assertEquals(23, new AnchoDeCopa().sumarTanto(new DosDeCopa()));
		Assert.assertEquals(24, new AnchoDeCopa().sumarTanto(new TresDeCopa()));
		Assert.assertEquals(25, new AnchoDeCopa().sumarTanto(new CuatroDeCopa()));
		Assert.assertEquals(26, new AnchoDeCopa().sumarTanto(new CincoDeCopa()));
		Assert.assertEquals(27, new AnchoDeCopa().sumarTanto(new SeisDeCopa()));
		Assert.assertEquals(28, new AnchoDeCopa().sumarTanto(new SieteDeCopa()));
		Assert.assertEquals(21, new AnchoDeCopa().sumarTanto(new SotaDeCopa()));
		Assert.assertEquals(21, new AnchoDeCopa().sumarTanto(new CaballoDeCopa()));
		Assert.assertEquals(21, new AnchoDeCopa().sumarTanto(new ReyDeCopa()));
		
		Assert.assertEquals(23, new DosDeCopa().sumarTanto(new AnchoDeCopa()));
		Assert.assertEquals(25, new DosDeCopa().sumarTanto(new TresDeCopa()));
		Assert.assertEquals(26, new DosDeCopa().sumarTanto(new CuatroDeCopa()));
		Assert.assertEquals(27, new DosDeCopa().sumarTanto(new CincoDeCopa()));
		Assert.assertEquals(28, new DosDeCopa().sumarTanto(new SeisDeCopa()));
		Assert.assertEquals(29, new DosDeCopa().sumarTanto(new SieteDeCopa()));
		Assert.assertEquals(22, new DosDeCopa().sumarTanto(new SotaDeCopa()));
		Assert.assertEquals(22, new DosDeCopa().sumarTanto(new CaballoDeCopa()));
		Assert.assertEquals(22, new DosDeCopa().sumarTanto(new ReyDeCopa()));
		
		Assert.assertEquals(24, new TresDeCopa().sumarTanto(new AnchoDeCopa()));
		Assert.assertEquals(25, new TresDeCopa().sumarTanto(new DosDeCopa()));
		Assert.assertEquals(27, new TresDeCopa().sumarTanto(new CuatroDeCopa()));
		Assert.assertEquals(28, new TresDeCopa().sumarTanto(new CincoDeCopa()));
		Assert.assertEquals(29, new TresDeCopa().sumarTanto(new SeisDeCopa()));
		Assert.assertEquals(30, new TresDeCopa().sumarTanto(new SieteDeCopa()));
		Assert.assertEquals(23, new TresDeCopa().sumarTanto(new SotaDeCopa()));
		Assert.assertEquals(23, new TresDeCopa().sumarTanto(new CaballoDeCopa()));
		Assert.assertEquals(23, new TresDeCopa().sumarTanto(new ReyDeCopa()));
		
		Assert.assertEquals(25, new CuatroDeCopa().sumarTanto(new AnchoDeCopa()));
		Assert.assertEquals(26, new CuatroDeCopa().sumarTanto(new DosDeCopa()));
		Assert.assertEquals(27, new CuatroDeCopa().sumarTanto(new TresDeCopa()));
		Assert.assertEquals(29, new CuatroDeCopa().sumarTanto(new CincoDeCopa()));
		Assert.assertEquals(30, new CuatroDeCopa().sumarTanto(new SeisDeCopa()));
		Assert.assertEquals(31, new CuatroDeCopa().sumarTanto(new SieteDeCopa()));
		Assert.assertEquals(24, new CuatroDeCopa().sumarTanto(new SotaDeCopa()));
		Assert.assertEquals(24, new CuatroDeCopa().sumarTanto(new CaballoDeCopa()));
		Assert.assertEquals(24, new CuatroDeCopa().sumarTanto(new ReyDeCopa()));
		
		Assert.assertEquals(26, new CincoDeCopa().sumarTanto(new AnchoDeCopa()));
		Assert.assertEquals(27, new CincoDeCopa().sumarTanto(new DosDeCopa()));
		Assert.assertEquals(28, new CincoDeCopa().sumarTanto(new TresDeCopa()));
		Assert.assertEquals(29, new CincoDeCopa().sumarTanto(new CuatroDeCopa()));
		Assert.assertEquals(31, new CincoDeCopa().sumarTanto(new SeisDeCopa()));
		Assert.assertEquals(32, new CincoDeCopa().sumarTanto(new SieteDeCopa()));
		Assert.assertEquals(25, new CincoDeCopa().sumarTanto(new SotaDeCopa()));
		Assert.assertEquals(25, new CincoDeCopa().sumarTanto(new CaballoDeCopa()));
		Assert.assertEquals(25, new CincoDeCopa().sumarTanto(new ReyDeCopa()));
		
		Assert.assertEquals(27, new SeisDeCopa().sumarTanto(new AnchoDeCopa()));
		Assert.assertEquals(28, new SeisDeCopa().sumarTanto(new DosDeCopa()));
		Assert.assertEquals(29, new SeisDeCopa().sumarTanto(new TresDeCopa()));
		Assert.assertEquals(30, new SeisDeCopa().sumarTanto(new CuatroDeCopa()));
		Assert.assertEquals(31, new SeisDeCopa().sumarTanto(new CincoDeCopa()));
		Assert.assertEquals(33, new SeisDeCopa().sumarTanto(new SieteDeCopa()));
		Assert.assertEquals(26, new SeisDeCopa().sumarTanto(new SotaDeCopa()));
		Assert.assertEquals(26, new SeisDeCopa().sumarTanto(new CaballoDeCopa()));
		Assert.assertEquals(26, new SeisDeCopa().sumarTanto(new ReyDeCopa()));
		
		Assert.assertEquals(28, new SieteDeCopa().sumarTanto(new AnchoDeCopa()));
		Assert.assertEquals(29, new SieteDeCopa().sumarTanto(new DosDeCopa()));
		Assert.assertEquals(30, new SieteDeCopa().sumarTanto(new TresDeCopa()));
		Assert.assertEquals(31, new SieteDeCopa().sumarTanto(new CuatroDeCopa()));
		Assert.assertEquals(32, new SieteDeCopa().sumarTanto(new CincoDeCopa()));
		Assert.assertEquals(33, new SieteDeCopa().sumarTanto(new SeisDeCopa()));
		Assert.assertEquals(27, new SieteDeCopa().sumarTanto(new SotaDeCopa()));
		Assert.assertEquals(27, new SieteDeCopa().sumarTanto(new CaballoDeCopa()));
		Assert.assertEquals(27, new SieteDeCopa().sumarTanto(new ReyDeCopa()));
		
		Assert.assertEquals(21, new SotaDeCopa().sumarTanto(new AnchoDeCopa()));
		Assert.assertEquals(22, new SotaDeCopa().sumarTanto(new DosDeCopa()));
		Assert.assertEquals(23, new SotaDeCopa().sumarTanto(new TresDeCopa()));
		Assert.assertEquals(24, new SotaDeCopa().sumarTanto(new CuatroDeCopa()));
		Assert.assertEquals(25, new SotaDeCopa().sumarTanto(new CincoDeCopa()));
		Assert.assertEquals(26, new SotaDeCopa().sumarTanto(new SeisDeCopa()));
		Assert.assertEquals(27, new SotaDeCopa().sumarTanto(new SieteDeCopa()));
		Assert.assertEquals(20, new SotaDeCopa().sumarTanto(new CaballoDeCopa()));
		Assert.assertEquals(20, new SotaDeCopa().sumarTanto(new ReyDeCopa()));
		
		Assert.assertEquals(21, new CaballoDeCopa().sumarTanto(new AnchoDeCopa()));
		Assert.assertEquals(22, new CaballoDeCopa().sumarTanto(new DosDeCopa()));
		Assert.assertEquals(23, new CaballoDeCopa().sumarTanto(new TresDeCopa()));
		Assert.assertEquals(24, new CaballoDeCopa().sumarTanto(new CuatroDeCopa()));
		Assert.assertEquals(25, new CaballoDeCopa().sumarTanto(new CincoDeCopa()));
		Assert.assertEquals(26, new CaballoDeCopa().sumarTanto(new SeisDeCopa()));
		Assert.assertEquals(27, new CaballoDeCopa().sumarTanto(new SieteDeCopa()));
		Assert.assertEquals(20, new CaballoDeCopa().sumarTanto(new SotaDeCopa()));
		Assert.assertEquals(20, new CaballoDeCopa().sumarTanto(new ReyDeCopa()));
		
		Assert.assertEquals(21, new ReyDeCopa().sumarTanto(new AnchoDeCopa()));
		Assert.assertEquals(22, new ReyDeCopa().sumarTanto(new DosDeCopa()));
		Assert.assertEquals(23, new ReyDeCopa().sumarTanto(new TresDeCopa()));
		Assert.assertEquals(24, new ReyDeCopa().sumarTanto(new CuatroDeCopa()));
		Assert.assertEquals(25, new ReyDeCopa().sumarTanto(new CincoDeCopa()));
		Assert.assertEquals(26, new ReyDeCopa().sumarTanto(new SeisDeCopa()));
		Assert.assertEquals(27, new ReyDeCopa().sumarTanto(new SieteDeCopa()));
		Assert.assertEquals(20, new ReyDeCopa().sumarTanto(new SotaDeCopa()));
		Assert.assertEquals(20, new ReyDeCopa().sumarTanto(new CaballoDeCopa()));
	}
	
	@Test
	public void pruebaVariosAnchos(){
		Assert.assertEquals(2, new AnchoDeOro().sumarTanto(new DosDeEspada()));
		Assert.assertEquals(3, new AnchoDeOro().sumarTanto(new TresDeEspada()));
		Assert.assertEquals(4, new AnchoDeOro().sumarTanto(new CuatroDeEspada()));
		Assert.assertEquals(5, new AnchoDeOro().sumarTanto(new CincoDeEspada()));
		Assert.assertEquals(6, new AnchoDeOro().sumarTanto(new SeisDeEspada()));
		Assert.assertEquals(7, new AnchoDeOro().sumarTanto(new SieteDeEspada()));
		Assert.assertEquals(1, new AnchoDeOro().sumarTanto(new SotaDeEspada()));
		Assert.assertEquals(1, new AnchoDeOro().sumarTanto(new CaballoDeEspada()));
		Assert.assertEquals(1, new AnchoDeOro().sumarTanto(new ReyDeEspada()));

		Assert.assertEquals(2, new AnchoDeCopa().sumarTanto(new DosDeEspada()));
		Assert.assertEquals(3, new AnchoDeCopa().sumarTanto(new TresDeEspada()));
		Assert.assertEquals(4, new AnchoDeCopa().sumarTanto(new CuatroDeEspada()));
		Assert.assertEquals(5, new AnchoDeCopa().sumarTanto(new CincoDeEspada()));
		Assert.assertEquals(6, new AnchoDeCopa().sumarTanto(new SeisDeEspada()));
		Assert.assertEquals(7, new AnchoDeCopa().sumarTanto(new SieteDeEspada()));
		Assert.assertEquals(1, new AnchoDeCopa().sumarTanto(new SotaDeEspada()));
		Assert.assertEquals(1, new AnchoDeCopa().sumarTanto(new CaballoDeEspada()));
		Assert.assertEquals(1, new AnchoDeCopa().sumarTanto(new ReyDeEspada()));

		Assert.assertEquals(2, new AnchoDeBasto().sumarTanto(new DosDeEspada()));
		Assert.assertEquals(3, new AnchoDeBasto().sumarTanto(new TresDeEspada()));
		Assert.assertEquals(4, new AnchoDeBasto().sumarTanto(new CuatroDeEspada()));
		Assert.assertEquals(5, new AnchoDeBasto().sumarTanto(new CincoDeEspada()));
		Assert.assertEquals(6, new AnchoDeBasto().sumarTanto(new SeisDeEspada()));
		Assert.assertEquals(7, new AnchoDeBasto().sumarTanto(new SieteDeEspada()));
		Assert.assertEquals(1, new AnchoDeBasto().sumarTanto(new SotaDeEspada()));
		Assert.assertEquals(1, new AnchoDeBasto().sumarTanto(new CaballoDeEspada()));
		Assert.assertEquals(1, new AnchoDeBasto().sumarTanto(new ReyDeEspada()));
	}
	
	@Test
	public void pruebaVariosDos(){
		Assert.assertEquals(2, new DosDeOro().sumarTanto(new DosDeEspada()));
		Assert.assertEquals(3, new DosDeOro().sumarTanto(new TresDeEspada()));
		Assert.assertEquals(4, new DosDeOro().sumarTanto(new CuatroDeEspada()));
		Assert.assertEquals(5, new DosDeOro().sumarTanto(new CincoDeEspada()));
		Assert.assertEquals(6, new DosDeOro().sumarTanto(new SeisDeEspada()));
		Assert.assertEquals(7, new DosDeOro().sumarTanto(new SieteDeEspada()));
		Assert.assertEquals(2, new DosDeOro().sumarTanto(new SotaDeEspada()));
		Assert.assertEquals(2, new DosDeOro().sumarTanto(new CaballoDeEspada()));
		Assert.assertEquals(2, new DosDeOro().sumarTanto(new ReyDeEspada()));

		Assert.assertEquals(2, new DosDeCopa().sumarTanto(new DosDeEspada()));
		Assert.assertEquals(3, new DosDeCopa().sumarTanto(new TresDeEspada()));
		Assert.assertEquals(4, new DosDeCopa().sumarTanto(new CuatroDeEspada()));
		Assert.assertEquals(5, new DosDeCopa().sumarTanto(new CincoDeEspada()));
		Assert.assertEquals(6, new DosDeCopa().sumarTanto(new SeisDeEspada()));
		Assert.assertEquals(7, new DosDeCopa().sumarTanto(new SieteDeEspada()));
		Assert.assertEquals(2, new DosDeCopa().sumarTanto(new SotaDeEspada()));
		Assert.assertEquals(2, new DosDeCopa().sumarTanto(new CaballoDeEspada()));
		Assert.assertEquals(2, new DosDeCopa().sumarTanto(new ReyDeEspada()));

		Assert.assertEquals(2, new DosDeBasto().sumarTanto(new DosDeEspada()));
		Assert.assertEquals(3, new DosDeBasto().sumarTanto(new TresDeEspada()));
		Assert.assertEquals(4, new DosDeBasto().sumarTanto(new CuatroDeEspada()));
		Assert.assertEquals(5, new DosDeBasto().sumarTanto(new CincoDeEspada()));
		Assert.assertEquals(6, new DosDeBasto().sumarTanto(new SeisDeEspada()));
		Assert.assertEquals(7, new DosDeBasto().sumarTanto(new SieteDeEspada()));
		Assert.assertEquals(2, new DosDeBasto().sumarTanto(new SotaDeEspada()));
		Assert.assertEquals(2, new DosDeBasto().sumarTanto(new CaballoDeEspada()));
		Assert.assertEquals(2, new DosDeBasto().sumarTanto(new ReyDeEspada()));
	}
	
	@Test
	public void pruebaVariosTres(){
		Assert.assertEquals(3, new TresDeOro().sumarTanto(new DosDeEspada()));
		Assert.assertEquals(3, new TresDeOro().sumarTanto(new TresDeEspada()));
		Assert.assertEquals(4, new TresDeOro().sumarTanto(new CuatroDeEspada()));
		Assert.assertEquals(5, new TresDeOro().sumarTanto(new CincoDeEspada()));
		Assert.assertEquals(6, new TresDeOro().sumarTanto(new SeisDeEspada()));
		Assert.assertEquals(7, new TresDeOro().sumarTanto(new SieteDeEspada()));
		Assert.assertEquals(3, new TresDeOro().sumarTanto(new SotaDeEspada()));
		Assert.assertEquals(3, new TresDeOro().sumarTanto(new CaballoDeEspada()));
		Assert.assertEquals(3, new TresDeOro().sumarTanto(new ReyDeEspada()));

		Assert.assertEquals(3, new TresDeCopa().sumarTanto(new DosDeEspada()));
		Assert.assertEquals(3, new TresDeCopa().sumarTanto(new TresDeEspada()));
		Assert.assertEquals(4, new TresDeCopa().sumarTanto(new CuatroDeEspada()));
		Assert.assertEquals(5, new TresDeCopa().sumarTanto(new CincoDeEspada()));
		Assert.assertEquals(6, new TresDeCopa().sumarTanto(new SeisDeEspada()));
		Assert.assertEquals(7, new TresDeCopa().sumarTanto(new SieteDeEspada()));
		Assert.assertEquals(3, new TresDeCopa().sumarTanto(new SotaDeEspada()));
		Assert.assertEquals(3, new TresDeCopa().sumarTanto(new CaballoDeEspada()));
		Assert.assertEquals(3, new TresDeCopa().sumarTanto(new ReyDeEspada()));

		Assert.assertEquals(3, new TresDeBasto().sumarTanto(new DosDeEspada()));
		Assert.assertEquals(3, new TresDeBasto().sumarTanto(new TresDeEspada()));
		Assert.assertEquals(4, new TresDeBasto().sumarTanto(new CuatroDeEspada()));
		Assert.assertEquals(5, new TresDeBasto().sumarTanto(new CincoDeEspada()));
		Assert.assertEquals(6, new TresDeBasto().sumarTanto(new SeisDeEspada()));
		Assert.assertEquals(7, new TresDeBasto().sumarTanto(new SieteDeEspada()));
		Assert.assertEquals(3, new TresDeBasto().sumarTanto(new SotaDeEspada()));
		Assert.assertEquals(3, new TresDeBasto().sumarTanto(new CaballoDeEspada()));
		Assert.assertEquals(3, new TresDeBasto().sumarTanto(new ReyDeEspada()));
	}
	
	@Test
	public void pruebaVariosCuatro(){
		Assert.assertEquals(4, new CuatroDeOro().sumarTanto(new DosDeEspada()));
		Assert.assertEquals(4, new CuatroDeOro().sumarTanto(new TresDeEspada()));
		Assert.assertEquals(4, new CuatroDeOro().sumarTanto(new CuatroDeEspada()));
		Assert.assertEquals(5, new CuatroDeOro().sumarTanto(new CincoDeEspada()));
		Assert.assertEquals(6, new CuatroDeOro().sumarTanto(new SeisDeEspada()));
		Assert.assertEquals(7, new CuatroDeOro().sumarTanto(new SieteDeEspada()));
		Assert.assertEquals(4, new CuatroDeOro().sumarTanto(new SotaDeEspada()));
		Assert.assertEquals(4, new CuatroDeOro().sumarTanto(new CaballoDeEspada()));
		Assert.assertEquals(4, new CuatroDeOro().sumarTanto(new ReyDeEspada()));

		Assert.assertEquals(4, new CuatroDeCopa().sumarTanto(new DosDeEspada()));
		Assert.assertEquals(4, new CuatroDeCopa().sumarTanto(new TresDeEspada()));
		Assert.assertEquals(4, new CuatroDeCopa().sumarTanto(new CuatroDeEspada()));
		Assert.assertEquals(5, new CuatroDeCopa().sumarTanto(new CincoDeEspada()));
		Assert.assertEquals(6, new CuatroDeCopa().sumarTanto(new SeisDeEspada()));
		Assert.assertEquals(7, new CuatroDeCopa().sumarTanto(new SieteDeEspada()));
		Assert.assertEquals(4, new CuatroDeCopa().sumarTanto(new SotaDeEspada()));
		Assert.assertEquals(4, new CuatroDeCopa().sumarTanto(new CaballoDeEspada()));
		Assert.assertEquals(4, new CuatroDeCopa().sumarTanto(new ReyDeEspada()));

		Assert.assertEquals(4, new CuatroDeBasto().sumarTanto(new DosDeEspada()));
		Assert.assertEquals(4, new CuatroDeBasto().sumarTanto(new TresDeEspada()));
		Assert.assertEquals(4, new CuatroDeBasto().sumarTanto(new CuatroDeEspada()));
		Assert.assertEquals(5, new CuatroDeBasto().sumarTanto(new CincoDeEspada()));
		Assert.assertEquals(6, new CuatroDeBasto().sumarTanto(new SeisDeEspada()));
		Assert.assertEquals(7, new CuatroDeBasto().sumarTanto(new SieteDeEspada()));
		Assert.assertEquals(4, new CuatroDeBasto().sumarTanto(new SotaDeEspada()));
		Assert.assertEquals(4, new CuatroDeBasto().sumarTanto(new CaballoDeEspada()));
		Assert.assertEquals(4, new CuatroDeBasto().sumarTanto(new ReyDeEspada()));
	}
	
	@Test
	public void pruebaVariosCinco(){
		Assert.assertEquals(5, new CincoDeOro().sumarTanto(new DosDeEspada()));
		Assert.assertEquals(5, new CincoDeOro().sumarTanto(new TresDeEspada()));
		Assert.assertEquals(5, new CincoDeOro().sumarTanto(new CuatroDeEspada()));
		Assert.assertEquals(5, new CincoDeOro().sumarTanto(new CincoDeEspada()));
		Assert.assertEquals(6, new CincoDeOro().sumarTanto(new SeisDeEspada()));
		Assert.assertEquals(7, new CincoDeOro().sumarTanto(new SieteDeEspada()));
		Assert.assertEquals(5, new CincoDeOro().sumarTanto(new SotaDeEspada()));
		Assert.assertEquals(5, new CincoDeOro().sumarTanto(new CaballoDeEspada()));
		Assert.assertEquals(5, new CincoDeOro().sumarTanto(new ReyDeEspada()));

		Assert.assertEquals(5, new CincoDeCopa().sumarTanto(new DosDeEspada()));
		Assert.assertEquals(5, new CincoDeCopa().sumarTanto(new TresDeEspada()));
		Assert.assertEquals(5, new CincoDeCopa().sumarTanto(new CuatroDeEspada()));
		Assert.assertEquals(5, new CincoDeCopa().sumarTanto(new CincoDeEspada()));
		Assert.assertEquals(6, new CincoDeCopa().sumarTanto(new SeisDeEspada()));
		Assert.assertEquals(7, new CincoDeCopa().sumarTanto(new SieteDeEspada()));
		Assert.assertEquals(5, new CincoDeCopa().sumarTanto(new SotaDeEspada()));
		Assert.assertEquals(5, new CincoDeCopa().sumarTanto(new CaballoDeEspada()));
		Assert.assertEquals(5, new CincoDeCopa().sumarTanto(new ReyDeEspada()));

		Assert.assertEquals(5, new CincoDeBasto().sumarTanto(new DosDeEspada()));
		Assert.assertEquals(5, new CincoDeBasto().sumarTanto(new TresDeEspada()));
		Assert.assertEquals(5, new CincoDeBasto().sumarTanto(new CuatroDeEspada()));
		Assert.assertEquals(5, new CincoDeBasto().sumarTanto(new CincoDeEspada()));
		Assert.assertEquals(6, new CincoDeBasto().sumarTanto(new SeisDeEspada()));
		Assert.assertEquals(7, new CincoDeBasto().sumarTanto(new SieteDeEspada()));
		Assert.assertEquals(5, new CincoDeBasto().sumarTanto(new SotaDeEspada()));
		Assert.assertEquals(5, new CincoDeBasto().sumarTanto(new CaballoDeEspada()));
		Assert.assertEquals(5, new CincoDeBasto().sumarTanto(new ReyDeEspada()));
	}
	
	@Test
	public void pruebaVariosSeis(){
		Assert.assertEquals(6, new SeisDeOro().sumarTanto(new DosDeEspada()));
		Assert.assertEquals(6, new SeisDeOro().sumarTanto(new TresDeEspada()));
		Assert.assertEquals(6, new SeisDeOro().sumarTanto(new CuatroDeEspada()));
		Assert.assertEquals(6, new SeisDeOro().sumarTanto(new CincoDeEspada()));
		Assert.assertEquals(6, new SeisDeOro().sumarTanto(new SeisDeEspada()));
		Assert.assertEquals(7, new SeisDeOro().sumarTanto(new SieteDeEspada()));
		Assert.assertEquals(6, new SeisDeOro().sumarTanto(new SotaDeEspada()));
		Assert.assertEquals(6, new SeisDeOro().sumarTanto(new CaballoDeEspada()));
		Assert.assertEquals(6, new SeisDeOro().sumarTanto(new ReyDeEspada()));

		Assert.assertEquals(6, new SeisDeCopa().sumarTanto(new DosDeEspada()));
		Assert.assertEquals(6, new SeisDeCopa().sumarTanto(new TresDeEspada()));
		Assert.assertEquals(6, new SeisDeCopa().sumarTanto(new CuatroDeEspada()));
		Assert.assertEquals(6, new SeisDeCopa().sumarTanto(new CincoDeEspada()));
		Assert.assertEquals(6, new SeisDeCopa().sumarTanto(new SeisDeEspada()));
		Assert.assertEquals(7, new SeisDeCopa().sumarTanto(new SieteDeEspada()));
		Assert.assertEquals(6, new SeisDeCopa().sumarTanto(new SotaDeEspada()));
		Assert.assertEquals(6, new SeisDeCopa().sumarTanto(new CaballoDeEspada()));
		Assert.assertEquals(6, new SeisDeCopa().sumarTanto(new ReyDeEspada()));

		Assert.assertEquals(6, new SeisDeBasto().sumarTanto(new DosDeEspada()));
		Assert.assertEquals(6, new SeisDeBasto().sumarTanto(new TresDeEspada()));
		Assert.assertEquals(6, new SeisDeBasto().sumarTanto(new CuatroDeEspada()));
		Assert.assertEquals(6, new SeisDeBasto().sumarTanto(new CincoDeEspada()));
		Assert.assertEquals(6, new SeisDeBasto().sumarTanto(new SeisDeEspada()));
		Assert.assertEquals(7, new SeisDeBasto().sumarTanto(new SieteDeEspada()));
		Assert.assertEquals(6, new SeisDeBasto().sumarTanto(new SotaDeEspada()));
		Assert.assertEquals(6, new SeisDeBasto().sumarTanto(new CaballoDeEspada()));
		Assert.assertEquals(6, new SeisDeBasto().sumarTanto(new ReyDeEspada()));
	}
	
	@Test
	public void pruebaVariosSiete(){
		Assert.assertEquals(7, new SieteDeOro().sumarTanto(new DosDeEspada()));
		Assert.assertEquals(7, new SieteDeOro().sumarTanto(new TresDeEspada()));
		Assert.assertEquals(7, new SieteDeOro().sumarTanto(new CuatroDeEspada()));
		Assert.assertEquals(7, new SieteDeOro().sumarTanto(new CincoDeEspada()));
		Assert.assertEquals(7, new SieteDeOro().sumarTanto(new SeisDeEspada()));
		Assert.assertEquals(7, new SieteDeOro().sumarTanto(new SieteDeEspada()));
		Assert.assertEquals(7, new SieteDeOro().sumarTanto(new SotaDeEspada()));
		Assert.assertEquals(7, new SieteDeOro().sumarTanto(new CaballoDeEspada()));
		Assert.assertEquals(7, new SieteDeOro().sumarTanto(new ReyDeEspada()));

		Assert.assertEquals(7, new SieteDeCopa().sumarTanto(new DosDeEspada()));
		Assert.assertEquals(7, new SieteDeCopa().sumarTanto(new TresDeEspada()));
		Assert.assertEquals(7, new SieteDeCopa().sumarTanto(new CuatroDeEspada()));
		Assert.assertEquals(7, new SieteDeCopa().sumarTanto(new CincoDeEspada()));
		Assert.assertEquals(7, new SieteDeCopa().sumarTanto(new SeisDeEspada()));
		Assert.assertEquals(7, new SieteDeCopa().sumarTanto(new SieteDeEspada()));
		Assert.assertEquals(7, new SieteDeCopa().sumarTanto(new SotaDeEspada()));
		Assert.assertEquals(7, new SieteDeCopa().sumarTanto(new CaballoDeEspada()));
		Assert.assertEquals(7, new SieteDeCopa().sumarTanto(new ReyDeEspada()));

		Assert.assertEquals(7, new SieteDeBasto().sumarTanto(new DosDeEspada()));
		Assert.assertEquals(7, new SieteDeBasto().sumarTanto(new TresDeEspada()));
		Assert.assertEquals(7, new SieteDeBasto().sumarTanto(new CuatroDeEspada()));
		Assert.assertEquals(7, new SieteDeBasto().sumarTanto(new CincoDeEspada()));
		Assert.assertEquals(7, new SieteDeBasto().sumarTanto(new SeisDeEspada()));
		Assert.assertEquals(7, new SieteDeBasto().sumarTanto(new SieteDeEspada()));
		Assert.assertEquals(7, new SieteDeBasto().sumarTanto(new SotaDeEspada()));
		Assert.assertEquals(7, new SieteDeBasto().sumarTanto(new CaballoDeEspada()));
		Assert.assertEquals(7, new SieteDeBasto().sumarTanto(new ReyDeEspada()));
	}
	
	@Test
	public void pruebaVariasSotas(){
		Assert.assertEquals(2, new SotaDeOro().sumarTanto(new DosDeEspada()));
		Assert.assertEquals(3, new SotaDeOro().sumarTanto(new TresDeEspada()));
		Assert.assertEquals(4, new SotaDeOro().sumarTanto(new CuatroDeEspada()));
		Assert.assertEquals(5, new SotaDeOro().sumarTanto(new CincoDeEspada()));
		Assert.assertEquals(6, new SotaDeOro().sumarTanto(new SeisDeEspada()));
		Assert.assertEquals(7, new SotaDeOro().sumarTanto(new SieteDeEspada()));
		Assert.assertEquals(0, new SotaDeOro().sumarTanto(new SotaDeEspada()));
		Assert.assertEquals(0, new SotaDeOro().sumarTanto(new CaballoDeEspada()));
		Assert.assertEquals(0, new SotaDeOro().sumarTanto(new ReyDeEspada()));

		Assert.assertEquals(2, new SotaDeCopa().sumarTanto(new DosDeEspada()));
		Assert.assertEquals(3, new SotaDeCopa().sumarTanto(new TresDeEspada()));
		Assert.assertEquals(4, new SotaDeCopa().sumarTanto(new CuatroDeEspada()));
		Assert.assertEquals(5, new SotaDeCopa().sumarTanto(new CincoDeEspada()));
		Assert.assertEquals(6, new SotaDeCopa().sumarTanto(new SeisDeEspada()));
		Assert.assertEquals(7, new SotaDeCopa().sumarTanto(new SieteDeEspada()));
		Assert.assertEquals(0, new SotaDeCopa().sumarTanto(new SotaDeEspada()));
		Assert.assertEquals(0, new SotaDeCopa().sumarTanto(new CaballoDeEspada()));
		Assert.assertEquals(0, new SotaDeCopa().sumarTanto(new ReyDeEspada()));

		Assert.assertEquals(2, new SotaDeBasto().sumarTanto(new DosDeEspada()));
		Assert.assertEquals(3, new SotaDeBasto().sumarTanto(new TresDeEspada()));
		Assert.assertEquals(4, new SotaDeBasto().sumarTanto(new CuatroDeEspada()));
		Assert.assertEquals(5, new SotaDeBasto().sumarTanto(new CincoDeEspada()));
		Assert.assertEquals(6, new SotaDeBasto().sumarTanto(new SeisDeEspada()));
		Assert.assertEquals(7, new SotaDeBasto().sumarTanto(new SieteDeEspada()));
		Assert.assertEquals(0, new SotaDeBasto().sumarTanto(new SotaDeEspada()));
		Assert.assertEquals(0, new SotaDeBasto().sumarTanto(new CaballoDeEspada()));
		Assert.assertEquals(0, new SotaDeBasto().sumarTanto(new ReyDeEspada()));
	}
	
	@Test
	public void pruebaVariasCaballos(){
		Assert.assertEquals(2, new CaballoDeOro().sumarTanto(new DosDeEspada()));
		Assert.assertEquals(3, new CaballoDeOro().sumarTanto(new TresDeEspada()));
		Assert.assertEquals(4, new CaballoDeOro().sumarTanto(new CuatroDeEspada()));
		Assert.assertEquals(5, new CaballoDeOro().sumarTanto(new CincoDeEspada()));
		Assert.assertEquals(6, new CaballoDeOro().sumarTanto(new SeisDeEspada()));
		Assert.assertEquals(7, new CaballoDeOro().sumarTanto(new SieteDeEspada()));
		Assert.assertEquals(0, new CaballoDeOro().sumarTanto(new SotaDeEspada()));
		Assert.assertEquals(0, new CaballoDeOro().sumarTanto(new CaballoDeEspada()));
		Assert.assertEquals(0, new CaballoDeOro().sumarTanto(new ReyDeEspada()));

		Assert.assertEquals(2, new CaballoDeCopa().sumarTanto(new DosDeEspada()));
		Assert.assertEquals(3, new CaballoDeCopa().sumarTanto(new TresDeEspada()));
		Assert.assertEquals(4, new CaballoDeCopa().sumarTanto(new CuatroDeEspada()));
		Assert.assertEquals(5, new CaballoDeCopa().sumarTanto(new CincoDeEspada()));
		Assert.assertEquals(6, new CaballoDeCopa().sumarTanto(new SeisDeEspada()));
		Assert.assertEquals(7, new CaballoDeCopa().sumarTanto(new SieteDeEspada()));
		Assert.assertEquals(0, new CaballoDeCopa().sumarTanto(new SotaDeEspada()));
		Assert.assertEquals(0, new CaballoDeCopa().sumarTanto(new CaballoDeEspada()));
		Assert.assertEquals(0, new CaballoDeCopa().sumarTanto(new ReyDeEspada()));

		Assert.assertEquals(2, new CaballoDeBasto().sumarTanto(new DosDeEspada()));
		Assert.assertEquals(3, new CaballoDeBasto().sumarTanto(new TresDeEspada()));
		Assert.assertEquals(4, new CaballoDeBasto().sumarTanto(new CuatroDeEspada()));
		Assert.assertEquals(5, new CaballoDeBasto().sumarTanto(new CincoDeEspada()));
		Assert.assertEquals(6, new CaballoDeBasto().sumarTanto(new SeisDeEspada()));
		Assert.assertEquals(7, new CaballoDeBasto().sumarTanto(new SieteDeEspada()));
		Assert.assertEquals(0, new CaballoDeBasto().sumarTanto(new SotaDeEspada()));
		Assert.assertEquals(0, new CaballoDeBasto().sumarTanto(new CaballoDeEspada()));
		Assert.assertEquals(0, new CaballoDeBasto().sumarTanto(new ReyDeEspada()));
	}
	
	@Test
	public void pruebaVariasReyes(){
		Assert.assertEquals(2, new ReyDeOro().sumarTanto(new DosDeEspada()));
		Assert.assertEquals(3, new ReyDeOro().sumarTanto(new TresDeEspada()));
		Assert.assertEquals(4, new ReyDeOro().sumarTanto(new CuatroDeEspada()));
		Assert.assertEquals(5, new ReyDeOro().sumarTanto(new CincoDeEspada()));
		Assert.assertEquals(6, new ReyDeOro().sumarTanto(new SeisDeEspada()));
		Assert.assertEquals(7, new ReyDeOro().sumarTanto(new SieteDeEspada()));
		Assert.assertEquals(0, new ReyDeOro().sumarTanto(new SotaDeEspada()));
		Assert.assertEquals(0, new ReyDeOro().sumarTanto(new CaballoDeEspada()));
		Assert.assertEquals(0, new ReyDeOro().sumarTanto(new ReyDeEspada()));

		Assert.assertEquals(2, new ReyDeCopa().sumarTanto(new DosDeEspada()));
		Assert.assertEquals(3, new ReyDeCopa().sumarTanto(new TresDeEspada()));
		Assert.assertEquals(4, new ReyDeCopa().sumarTanto(new CuatroDeEspada()));
		Assert.assertEquals(5, new ReyDeCopa().sumarTanto(new CincoDeEspada()));
		Assert.assertEquals(6, new ReyDeCopa().sumarTanto(new SeisDeEspada()));
		Assert.assertEquals(7, new ReyDeCopa().sumarTanto(new SieteDeEspada()));
		Assert.assertEquals(0, new ReyDeCopa().sumarTanto(new SotaDeEspada()));
		Assert.assertEquals(0, new ReyDeCopa().sumarTanto(new CaballoDeEspada()));
		Assert.assertEquals(0, new ReyDeCopa().sumarTanto(new ReyDeEspada()));

		Assert.assertEquals(2, new ReyDeBasto().sumarTanto(new DosDeEspada()));
		Assert.assertEquals(3, new ReyDeBasto().sumarTanto(new TresDeEspada()));
		Assert.assertEquals(4, new ReyDeBasto().sumarTanto(new CuatroDeEspada()));
		Assert.assertEquals(5, new ReyDeBasto().sumarTanto(new CincoDeEspada()));
		Assert.assertEquals(6, new ReyDeBasto().sumarTanto(new SeisDeEspada()));
		Assert.assertEquals(7, new ReyDeBasto().sumarTanto(new SieteDeEspada()));
		Assert.assertEquals(0, new ReyDeBasto().sumarTanto(new SotaDeEspada()));
		Assert.assertEquals(0, new ReyDeBasto().sumarTanto(new CaballoDeEspada()));
		Assert.assertEquals(0, new ReyDeBasto().sumarTanto(new ReyDeEspada()));
	}

	@Test
	public void pruebaVariosMeFuiAlCarajo(){
		Assert.assertEquals(2, new DosDeBasto().sumarTanto(new DosDeCopa()));
		Assert.assertEquals(3, new DosDeBasto().sumarTanto(new TresDeCopa()));
		Assert.assertEquals(4, new DosDeBasto().sumarTanto(new CuatroDeCopa()));
		Assert.assertEquals(5, new DosDeBasto().sumarTanto(new CincoDeCopa()));
		Assert.assertEquals(6, new DosDeBasto().sumarTanto(new SeisDeCopa()));
		Assert.assertEquals(7, new DosDeBasto().sumarTanto(new SieteDeCopa()));
		Assert.assertEquals(2, new DosDeBasto().sumarTanto(new SotaDeCopa()));
		Assert.assertEquals(2, new DosDeBasto().sumarTanto(new CaballoDeCopa()));
		Assert.assertEquals(2, new DosDeBasto().sumarTanto(new ReyDeCopa()));

		Assert.assertEquals(2, new DosDeOro().sumarTanto(new DosDeCopa()));
		Assert.assertEquals(3, new DosDeOro().sumarTanto(new TresDeCopa()));
		Assert.assertEquals(4, new DosDeOro().sumarTanto(new CuatroDeCopa()));
		Assert.assertEquals(5, new DosDeOro().sumarTanto(new CincoDeCopa()));
		Assert.assertEquals(6, new DosDeOro().sumarTanto(new SeisDeCopa()));
		Assert.assertEquals(7, new DosDeOro().sumarTanto(new SieteDeCopa()));
		Assert.assertEquals(2, new DosDeOro().sumarTanto(new SotaDeCopa()));
		Assert.assertEquals(2, new DosDeOro().sumarTanto(new CaballoDeCopa()));
		Assert.assertEquals(2, new DosDeOro().sumarTanto(new ReyDeCopa()));

		Assert.assertEquals(3, new TresDeBasto().sumarTanto(new DosDeCopa()));
		Assert.assertEquals(3, new TresDeBasto().sumarTanto(new TresDeCopa()));
		Assert.assertEquals(4, new TresDeBasto().sumarTanto(new CuatroDeCopa()));
		Assert.assertEquals(5, new TresDeBasto().sumarTanto(new CincoDeCopa()));
		Assert.assertEquals(6, new TresDeBasto().sumarTanto(new SeisDeCopa()));
		Assert.assertEquals(7, new TresDeBasto().sumarTanto(new SieteDeCopa()));
		Assert.assertEquals(3, new TresDeBasto().sumarTanto(new SotaDeCopa()));
		Assert.assertEquals(3, new TresDeBasto().sumarTanto(new CaballoDeCopa()));
		Assert.assertEquals(3, new TresDeBasto().sumarTanto(new ReyDeCopa()));

		Assert.assertEquals(3, new TresDeOro().sumarTanto(new DosDeCopa()));
		Assert.assertEquals(3, new TresDeOro().sumarTanto(new TresDeCopa()));
		Assert.assertEquals(4, new TresDeOro().sumarTanto(new CuatroDeCopa()));
		Assert.assertEquals(5, new TresDeOro().sumarTanto(new CincoDeCopa()));
		Assert.assertEquals(6, new TresDeOro().sumarTanto(new SeisDeCopa()));
		Assert.assertEquals(7, new TresDeOro().sumarTanto(new SieteDeCopa()));
		Assert.assertEquals(3, new TresDeOro().sumarTanto(new SotaDeCopa()));
		Assert.assertEquals(3, new TresDeOro().sumarTanto(new CaballoDeCopa()));
		Assert.assertEquals(3, new TresDeOro().sumarTanto(new ReyDeCopa()));

		Assert.assertEquals(4, new CuatroDeBasto().sumarTanto(new DosDeCopa()));
		Assert.assertEquals(4, new CuatroDeBasto().sumarTanto(new TresDeCopa()));
		Assert.assertEquals(4, new CuatroDeBasto().sumarTanto(new CuatroDeCopa()));
		Assert.assertEquals(5, new CuatroDeBasto().sumarTanto(new CincoDeCopa()));
		Assert.assertEquals(6, new CuatroDeBasto().sumarTanto(new SeisDeCopa()));
		Assert.assertEquals(7, new CuatroDeBasto().sumarTanto(new SieteDeCopa()));
		Assert.assertEquals(4, new CuatroDeBasto().sumarTanto(new SotaDeCopa()));
		Assert.assertEquals(4, new CuatroDeBasto().sumarTanto(new CaballoDeCopa()));
		Assert.assertEquals(4, new CuatroDeBasto().sumarTanto(new ReyDeCopa()));

		Assert.assertEquals(4, new CuatroDeOro().sumarTanto(new DosDeCopa()));
		Assert.assertEquals(4, new CuatroDeOro().sumarTanto(new TresDeCopa()));
		Assert.assertEquals(4, new CuatroDeOro().sumarTanto(new CuatroDeCopa()));
		Assert.assertEquals(5, new CuatroDeOro().sumarTanto(new CincoDeCopa()));
		Assert.assertEquals(6, new CuatroDeOro().sumarTanto(new SeisDeCopa()));
		Assert.assertEquals(7, new CuatroDeOro().sumarTanto(new SieteDeCopa()));
		Assert.assertEquals(4, new CuatroDeOro().sumarTanto(new SotaDeCopa()));
		Assert.assertEquals(4, new CuatroDeOro().sumarTanto(new CaballoDeCopa()));
		Assert.assertEquals(4, new CuatroDeOro().sumarTanto(new ReyDeCopa()));

		Assert.assertEquals(5, new CincoDeBasto().sumarTanto(new DosDeCopa()));
		Assert.assertEquals(5, new CincoDeBasto().sumarTanto(new TresDeCopa()));
		Assert.assertEquals(5, new CincoDeBasto().sumarTanto(new CuatroDeCopa()));
		Assert.assertEquals(5, new CincoDeBasto().sumarTanto(new CincoDeCopa()));
		Assert.assertEquals(6, new CincoDeBasto().sumarTanto(new SeisDeCopa()));
		Assert.assertEquals(7, new CincoDeBasto().sumarTanto(new SieteDeCopa()));
		Assert.assertEquals(5, new CincoDeBasto().sumarTanto(new SotaDeCopa()));
		Assert.assertEquals(5, new CincoDeBasto().sumarTanto(new CaballoDeCopa()));
		Assert.assertEquals(5, new CincoDeBasto().sumarTanto(new ReyDeCopa()));

		Assert.assertEquals(5, new CincoDeOro().sumarTanto(new DosDeCopa()));
		Assert.assertEquals(5, new CincoDeOro().sumarTanto(new TresDeCopa()));
		Assert.assertEquals(5, new CincoDeOro().sumarTanto(new CuatroDeCopa()));
		Assert.assertEquals(5, new CincoDeOro().sumarTanto(new CincoDeCopa()));
		Assert.assertEquals(6, new CincoDeOro().sumarTanto(new SeisDeCopa()));
		Assert.assertEquals(7, new CincoDeOro().sumarTanto(new SieteDeCopa()));
		Assert.assertEquals(5, new CincoDeOro().sumarTanto(new SotaDeCopa()));
		Assert.assertEquals(5, new CincoDeOro().sumarTanto(new CaballoDeCopa()));
		Assert.assertEquals(5, new CincoDeOro().sumarTanto(new ReyDeCopa()));

		Assert.assertEquals(6, new SeisDeBasto().sumarTanto(new DosDeCopa()));
		Assert.assertEquals(6, new SeisDeBasto().sumarTanto(new TresDeCopa()));
		Assert.assertEquals(6, new SeisDeBasto().sumarTanto(new CuatroDeCopa()));
		Assert.assertEquals(6, new SeisDeBasto().sumarTanto(new CincoDeCopa()));
		Assert.assertEquals(6, new SeisDeBasto().sumarTanto(new SeisDeCopa()));
		Assert.assertEquals(7, new SeisDeBasto().sumarTanto(new SieteDeCopa()));
		Assert.assertEquals(6, new SeisDeBasto().sumarTanto(new SotaDeCopa()));
		Assert.assertEquals(6, new SeisDeBasto().sumarTanto(new CaballoDeCopa()));
		Assert.assertEquals(6, new SeisDeBasto().sumarTanto(new ReyDeCopa()));

		Assert.assertEquals(6, new SeisDeOro().sumarTanto(new DosDeCopa()));
		Assert.assertEquals(6, new SeisDeOro().sumarTanto(new TresDeCopa()));
		Assert.assertEquals(6, new SeisDeOro().sumarTanto(new CuatroDeCopa()));
		Assert.assertEquals(6, new SeisDeOro().sumarTanto(new CincoDeCopa()));
		Assert.assertEquals(6, new SeisDeOro().sumarTanto(new SeisDeCopa()));
		Assert.assertEquals(7, new SeisDeOro().sumarTanto(new SieteDeCopa()));
		Assert.assertEquals(6, new SeisDeOro().sumarTanto(new SotaDeCopa()));
		Assert.assertEquals(6, new SeisDeOro().sumarTanto(new CaballoDeCopa()));
		Assert.assertEquals(6, new SeisDeOro().sumarTanto(new ReyDeCopa()));

		Assert.assertEquals(7, new SieteDeBasto().sumarTanto(new DosDeCopa()));
		Assert.assertEquals(7, new SieteDeBasto().sumarTanto(new TresDeCopa()));
		Assert.assertEquals(7, new SieteDeBasto().sumarTanto(new CuatroDeCopa()));
		Assert.assertEquals(7, new SieteDeBasto().sumarTanto(new CincoDeCopa()));
		Assert.assertEquals(7, new SieteDeBasto().sumarTanto(new SeisDeCopa()));
		Assert.assertEquals(7, new SieteDeBasto().sumarTanto(new SieteDeCopa()));
		Assert.assertEquals(7, new SieteDeBasto().sumarTanto(new SotaDeCopa()));
		Assert.assertEquals(7, new SieteDeBasto().sumarTanto(new CaballoDeCopa()));
		Assert.assertEquals(7, new SieteDeBasto().sumarTanto(new ReyDeCopa()));

		Assert.assertEquals(7, new SieteDeOro().sumarTanto(new DosDeCopa()));
		Assert.assertEquals(7, new SieteDeOro().sumarTanto(new TresDeCopa()));
		Assert.assertEquals(7, new SieteDeOro().sumarTanto(new CuatroDeCopa()));
		Assert.assertEquals(7, new SieteDeOro().sumarTanto(new CincoDeCopa()));
		Assert.assertEquals(7, new SieteDeOro().sumarTanto(new SeisDeCopa()));
		Assert.assertEquals(7, new SieteDeOro().sumarTanto(new SieteDeCopa()));
		Assert.assertEquals(7, new SieteDeOro().sumarTanto(new SotaDeCopa()));
		Assert.assertEquals(7, new SieteDeOro().sumarTanto(new CaballoDeCopa()));
		Assert.assertEquals(7, new SieteDeOro().sumarTanto(new ReyDeCopa()));

		Assert.assertEquals(2, new SotaDeBasto().sumarTanto(new DosDeCopa()));
		Assert.assertEquals(3, new SotaDeBasto().sumarTanto(new TresDeCopa()));
		Assert.assertEquals(4, new SotaDeBasto().sumarTanto(new CuatroDeCopa()));
		Assert.assertEquals(5, new SotaDeBasto().sumarTanto(new CincoDeCopa()));
		Assert.assertEquals(6, new SotaDeBasto().sumarTanto(new SeisDeCopa()));
		Assert.assertEquals(7, new SotaDeBasto().sumarTanto(new SieteDeCopa()));
		Assert.assertEquals(0, new SotaDeBasto().sumarTanto(new SotaDeCopa()));
		Assert.assertEquals(0, new SotaDeBasto().sumarTanto(new CaballoDeCopa()));
		Assert.assertEquals(0, new SotaDeBasto().sumarTanto(new ReyDeCopa()));

		Assert.assertEquals(2, new SotaDeOro().sumarTanto(new DosDeCopa()));
		Assert.assertEquals(3, new SotaDeOro().sumarTanto(new TresDeCopa()));
		Assert.assertEquals(4, new SotaDeOro().sumarTanto(new CuatroDeCopa()));
		Assert.assertEquals(5, new SotaDeOro().sumarTanto(new CincoDeCopa()));
		Assert.assertEquals(6, new SotaDeOro().sumarTanto(new SeisDeCopa()));
		Assert.assertEquals(7, new SotaDeOro().sumarTanto(new SieteDeCopa()));
		Assert.assertEquals(0, new SotaDeOro().sumarTanto(new SotaDeCopa()));
		Assert.assertEquals(0, new SotaDeOro().sumarTanto(new CaballoDeCopa()));
		Assert.assertEquals(0, new SotaDeOro().sumarTanto(new ReyDeCopa()));

		Assert.assertEquals(2, new CaballoDeBasto().sumarTanto(new DosDeCopa()));
		Assert.assertEquals(3, new CaballoDeBasto().sumarTanto(new TresDeCopa()));
		Assert.assertEquals(4, new CaballoDeBasto().sumarTanto(new CuatroDeCopa()));
		Assert.assertEquals(5, new CaballoDeBasto().sumarTanto(new CincoDeCopa()));
		Assert.assertEquals(6, new CaballoDeBasto().sumarTanto(new SeisDeCopa()));
		Assert.assertEquals(7, new CaballoDeBasto().sumarTanto(new SieteDeCopa()));
		Assert.assertEquals(0, new CaballoDeBasto().sumarTanto(new SotaDeCopa()));
		Assert.assertEquals(0, new CaballoDeBasto().sumarTanto(new CaballoDeCopa()));
		Assert.assertEquals(0, new CaballoDeBasto().sumarTanto(new ReyDeCopa()));

		Assert.assertEquals(2, new CaballoDeOro().sumarTanto(new DosDeCopa()));
		Assert.assertEquals(3, new CaballoDeOro().sumarTanto(new TresDeCopa()));
		Assert.assertEquals(4, new CaballoDeOro().sumarTanto(new CuatroDeCopa()));
		Assert.assertEquals(5, new CaballoDeOro().sumarTanto(new CincoDeCopa()));
		Assert.assertEquals(6, new CaballoDeOro().sumarTanto(new SeisDeCopa()));
		Assert.assertEquals(7, new CaballoDeOro().sumarTanto(new SieteDeCopa()));
		Assert.assertEquals(0, new CaballoDeOro().sumarTanto(new SotaDeCopa()));
		Assert.assertEquals(0, new CaballoDeOro().sumarTanto(new CaballoDeCopa()));
		Assert.assertEquals(0, new CaballoDeOro().sumarTanto(new ReyDeCopa()));

		Assert.assertEquals(2, new ReyDeBasto().sumarTanto(new DosDeCopa()));
		Assert.assertEquals(3, new ReyDeBasto().sumarTanto(new TresDeCopa()));
		Assert.assertEquals(4, new ReyDeBasto().sumarTanto(new CuatroDeCopa()));
		Assert.assertEquals(5, new ReyDeBasto().sumarTanto(new CincoDeCopa()));
		Assert.assertEquals(6, new ReyDeBasto().sumarTanto(new SeisDeCopa()));
		Assert.assertEquals(7, new ReyDeBasto().sumarTanto(new SieteDeCopa()));
		Assert.assertEquals(0, new ReyDeBasto().sumarTanto(new SotaDeCopa()));
		Assert.assertEquals(0, new ReyDeBasto().sumarTanto(new CaballoDeCopa()));
		Assert.assertEquals(0, new ReyDeBasto().sumarTanto(new ReyDeCopa()));

		Assert.assertEquals(2, new ReyDeOro().sumarTanto(new DosDeCopa()));
		Assert.assertEquals(3, new ReyDeOro().sumarTanto(new TresDeCopa()));
		Assert.assertEquals(4, new ReyDeOro().sumarTanto(new CuatroDeCopa()));
		Assert.assertEquals(5, new ReyDeOro().sumarTanto(new CincoDeCopa()));
		Assert.assertEquals(6, new ReyDeOro().sumarTanto(new SeisDeCopa()));
		Assert.assertEquals(7, new ReyDeOro().sumarTanto(new SieteDeCopa()));
		Assert.assertEquals(0, new ReyDeOro().sumarTanto(new SotaDeCopa()));
		Assert.assertEquals(0, new ReyDeOro().sumarTanto(new CaballoDeCopa()));
		Assert.assertEquals(0, new ReyDeOro().sumarTanto(new ReyDeCopa()));
	}

}
