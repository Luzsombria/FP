package fp.ciclismo.test;

import java.time.Duration;

import fp.ciclismo.Ganador;
import fp.ciclismo.GanadorImpl;

public class TestGanador {

	public static void main(String[] args) {

		Ganador g = new GanadorImpl(1995, "Spain", "Miguel Indurain", "Banesto",
				3653, Duration.parse("PT92H44M59S"), 2, 12);
		System.out.println("Ganador de la carrera: " + g);
		System.out.println("Tiempo empleado: " + g.getTiempoEmpleado());
	}

}
