package fiuba.algo3.tp2.cantosPosibles;

import java.util.HashMap;
import java.util.Map;

import fiuba.algo3.tp2.modelo.Equipo;

public class CantosDisponibles {
	
	/* Tipos de CantosPosibles esperados
	 * - Cantos Ronda Uno
	 * - Cantos Ronda Dos
	 * - Cantos Ronda Tres
	 * - Cante Truco
	 * - Cantaron Truco
	 * - Cante ReTruco
	 * - Cantaron ReTruco
	 * - Cante ValeCuatro
	 * - Cantaron ValeCuatro
	 * - Cante Flor
	 * - Cantaron Flor
	 * - Cantaron Envido
	 * - Cante Envido
	 * - Cantaron EnvidoEnvido
	 * - Cante EnvidoEnvido
	 * - Cantaron RealEnvido
	 * - Cante RealEnvido
	 * - Cantaron FaltaEnvido
	 * - Cantaron FaltaEnvido
	 */
	
	private Map<Equipo,CantosPosiblesEntreEquipos> cantosPosibles;
	
	public CantosDisponibles(){
		this.cantosPosibles = new HashMap<Equipo,CantosPosiblesEntreEquipos>();
	}
	
	public CantosPosiblesEntreEquipos cantosPosibles(Equipo equipo){
		return this.cantosPosibles.get(equipo);
	}
	
	public void modificarCantos(Equipo equipo, CantosPosiblesEntreEquipos cantoReciente){
		this.cantosPosibles.put(equipo, cantoReciente);
	}
	
}
