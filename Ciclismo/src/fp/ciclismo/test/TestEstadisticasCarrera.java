package fp.ciclismo.test;

import java.util.Map;

import fp.ciclismo.EstadisticasCarrera;
import fp.ciclismo.EstadisticasCarreraImpl;

public class TestEstadisticasCarrera {

	public static void main(String[] args) {
		
		// Crea un objeto 'e' de tipo EstadisticasCarrera con el nombre "Tour de France"
		// y los ganadores que hay en el fichero ganadores_Tour.csv de la carpeta datos
		
		EstadisticasCarrera e = new EstadisticasCarreraImpl("Tour de France", "ganadores_Tour.csv");
		
		// Muestra el nombre y el número de ediciones de la carrera
		
		System.out.println(e.getNombre() + e.getNumeroEdiciones());

		// Llamada al método que realizará los tratamientos secuenciales
		mostrarEstadisticas(e);
	}

	private static void mostrarEstadisticas(EstadisticasCarrera est) {
		
		// Prueba aquí los tratamientos secuenciales
		

	}

	// Utiliza este método para mostrar en pantalla un Map de una forma más amigable
	private static <K,T> void mostrarMapPorLinea(Map<K, T> map) {
		map.entrySet().stream()
			.forEach(entry-> System.out.println(entry.getKey() + " --> " + entry.getValue()));
	}

}
