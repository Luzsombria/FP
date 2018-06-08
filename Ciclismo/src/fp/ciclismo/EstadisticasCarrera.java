package fp.ciclismo;

import java.util.List;
import java.util.Map;
import java.util.Set;

public interface EstadisticasCarrera {
	String getNombre();
	Integer getNumeroEdiciones();

	List<String> getGanadoresConRecorridoInferiorA(Integer km);
	Boolean hanGanadoTodosAlgunaEtapa();
	Long getNumeroGanadores();
	Set<String> getEquiposGanadores();
	Ganador buscaGanador(String nombre);
	Ganador buscaGanador(Integer anyo);
	Integer calculaDistanciaTotal();
	Integer getKmMenorRecorrido();
	Double getMediaEtapasGanadas(String equipo);
	String getGanadorMasRapido();
	Map<String, List<Ganador>> getGanadoresPorNacionalidad();
	Map<String, Long> cuentaGanadoresPorNacionalidad();
	Map<String, Integer> getTotalEtapasGanadasPorEquipo();
	Boolean hayAlgunGanadorNacionalidad(String nacionalidad);
	void escribeGanadoresNacionalidadConAnyos(String nombreFichero, String nacionalidad);
	void escribeGanadoresDeAnyosOrdenados(String nombreFichero, Integer anyoInicial, Integer anyoFinal);
	Long getNumeroNacionalidadesGanadoresUltimosAños(Integer n);
	Map<String, Integer> getNumeroEtapasLiderPorEquipo();
	void muestraEdiciones();
	String getNacionalidadMasGanadores();
}
