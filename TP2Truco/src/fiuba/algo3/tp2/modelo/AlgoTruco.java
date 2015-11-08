package fiuba.algo3.tp2.modelo;

public class AlgoTruco {
		private PartidaDeTruco partida;
	
	public AlgoTruco(int cantidadJugadores,String Equipo1,String Equipo2){
		this.partida = new PartidaDeTruco(cantidadJugadores);
		this.partida.cargarJugadoresEnEquipoUno(Equipo1, "", "");
		this.partida.cargarJugadoresEnEquipoDos(Equipo2, "", "");
	}
	
	
}
