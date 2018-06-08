package fp.ciclismo;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import fp.utiles.Ficheros;

public class EstadisticasCarreraImpl implements EstadisticasCarrera {
	private String nombre;
	private Integer numEdiciones;
	private List<Ganador> ganadores;

	public EstadisticasCarreraImpl(String nombre, Integer numEdiciones, List<Ganador> ganadores) {
		super();
		this.nombre = nombre;
		this.numEdiciones = numEdiciones;
		this.ganadores = ganadores;
	}

	public EstadisticasCarreraImpl(String nombre, String ficheroCSV) {
		super();
		this.nombre = nombre;
		Ficheros.leeFichero(ficheroCSV);
	}

	@Override
	public String getNombre() {
		return nombre;
	}

	@Override
	public Integer getNumeroEdiciones() {
		return numEdiciones;
	}

	@Override
	public List<String> getGanadoresConRecorridoInferiorA(Integer km) {
		return ganadores.stream().filter(g -> g.getKmRecorridos() < km).map(g -> g.getNombre()).collect(Collectors.toList());
	}

	@Override
	public Boolean hanGanadoTodosAlgunaEtapa() {
		return ganadores.stream().allMatch(g -> g.getNumEtapasGanadas() > 0);
	}

	@Override
	public Long getNumeroGanadores() {
		return (long) ganadores.stream().filter(g -> g.getNumEtapasGanadas() > 0).map(g -> g.getNombre()).collect(Collectors.toSet()).size();
	}

	@Override
	public Set<String> getEquiposGanadores() {
		return ganadores.stream().filter(g -> g.getNumEtapasGanadas() > 0).map(g -> g.getEquipo()).collect(Collectors.toSet());
	}

	@Override
	public Ganador buscaGanador(String nombre) {
		return ganadores.stream().filter(g -> g.getNombre().equals(nombre)).findFirst().orElse(null);
	}

	@Override
	public Ganador buscaGanador(Integer anyo) {
		return ganadores.stream().filter(g -> g.getAnyo().equals(anyo)).findFirst().orElse(null);
	}

	@Override
	public Integer calculaDistanciaTotal() {
		// TODO Auto-generated method stub
		int primeraEdicion = ganadores.stream().min(Comparator.comparing(Ganador::getAnyo)).get().getAnyo();
		int ultimaEdicion = ganadores.stream().max(Comparator.comparing(Ganador::getAnyo)).get().getAnyo();
		int res = 0;
		for(int i = primeraEdicion; i < ultimaEdicion; i++) {
			res += 
		}
		return res;
	}

	@Override
	public Integer getKmMenorRecorrido() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Double getMediaEtapasGanadas(String equipo) {
		return ganadores.stream().filter(g -> g.getEquipo().equals(equipo)).mapToDouble(g -> g.getNumEtapasGanadas()).average().orElse(0);
	}

	@Override
	public String getGanadorMasRapido() {
		return ganadores.stream().max(Comparator.comparing(Ganador::getVelocidadMedia)).orElse(null).getNombre();
	}

	@Override
	public Map<String, List<Ganador>> getGanadoresPorNacionalidad() {
		return ganadores.stream().collect(Collectors.groupingBy(Ganador::getNacionalidad));
	}

	@Override
	public Map<String, Long> cuentaGanadoresPorNacionalidad() {
		return ganadores.stream().collect(Collectors.groupingBy(Ganador::getNacionalidad, Collectors.counting()));
	}

	@Override
	public Map<String, Integer> getTotalEtapasGanadasPorEquipo() {
		return ganadores.stream().collect(Collectors.groupingBy(Ganador::getEquipo, Collectors.summingInt(Ganador::getNumEtapasGanadas)));
	}

	@Override
	public Boolean hayAlgunGanadorNacionalidad(String nacionalidad) {
		return ganadores.stream().anyMatch(g -> g.getNacionalidad().equals(nacionalidad));
	}

	@Override
	public void escribeGanadoresNacionalidadConAnyos(String nombreFichero, String nacionalidad) {
		// TODO Auto-generated method stub

	}

	@Override
	public void escribeGanadoresDeAnyosOrdenados(String nombreFichero, Integer anyoInicial, Integer anyoFinal) {
		// TODO Auto-generated method stub

	}

	@Override
	public Long getNumeroNacionalidadesGanadoresUltimosAños(Integer n) {
		int inPer = ganadores.stream().max(Comparator.comparing(Ganador::getAnyo)).get().getAnyo() - n;
		return (long) ganadores.stream().filter(g -> g.getAnyo() >= inPer).map(g -> g.getNacionalidad()).collect(Collectors.toSet()).size();
	}

	@Override
	public Map<String, Integer> getNumeroEtapasLiderPorEquipo() {
		return ganadores.stream().filter(g -> g.getNumDiasMaillot() > 0).collect(Collectors.groupingBy(Ganador::getEquipo, Collectors.summingInt(Ganador::getNumDiasMaillot)));
	}

	@Override
	public void muestraEdiciones() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getNacionalidadMasGanadores() {
		// TODO Auto-generated method stub
		return null;
	}

}
