package fp.ciclismo;

import java.time.Duration;

public class GanadorImpl implements Ganador {
	private Integer anyo, kmRec, etapasGanadas, diasMallotAm;
	private String nacionalidad, nombre, equipo;
	private Duration tiempoEmpleado;
	
	public GanadorImpl(Integer anyo, String nacionalidad, String nombre, String equipo, Integer kmRec,
			Duration tiempoEmpleado, Integer etapasGanadas, Integer diasMallotAm) {
		super();
		checkDiasMAm(diasMallotAm);
		checkEtapasGanadas(etapasGanadas);
		checkKmRec(kmRec);
		checkTiempoEmpleado(tiempoEmpleado);
		this.anyo = anyo;
		this.kmRec = kmRec;
		this.etapasGanadas = etapasGanadas;
		this.diasMallotAm = diasMallotAm;
		this.nacionalidad = nacionalidad;
		this.nombre = nombre;
		this.equipo = equipo;
		this.tiempoEmpleado = tiempoEmpleado;
	}
	
	public GanadorImpl(String cadena) {
		String[] sp = cadena.split(",");
		if(sp.length != 8) {
			throw new IllegalArgumentException("La cadena no tiene un formato valido.");
		}
		int kmRec = Integer.parseInt(sp[4].trim());
		Duration tiempoEmpleado = Duration.parse(sp[5].trim());
		int diasMallotAm = Integer.parseInt(sp[7].trim());
		int etapasGanadas = Integer.parseInt(sp[6].trim());
		checkKmRec(kmRec);
		checkTiempoEmpleado(tiempoEmpleado);
		checkDiasMAm(diasMallotAm);
		checkEtapasGanadas(etapasGanadas);
		this.anyo = Integer.parseInt(sp[0].trim());
		this.nacionalidad = sp[1].trim();
		this.nombre = sp[2].trim();
		this.equipo = sp[3].trim();
		this.kmRec = kmRec;
		this.tiempoEmpleado = tiempoEmpleado;
		this.etapasGanadas = etapasGanadas;
		this.diasMallotAm = diasMallotAm;
	}

	public void checkKmRec(Integer kmRec) {
		if (kmRec <= 0) {
			throw new IllegalArgumentException("El ciclista no ha recorrido ningun kilometro.");
		}
	}
	
	public void checkEtapasGanadas(Integer etapasGanadas) {
		if (etapasGanadas < 0) {
			throw new IllegalArgumentException("El ciclista no puede haber ganado menos de 0 etapas.");
		}
	}
	
	public void checkDiasMAm(Integer diasMallotAm) {
		if (diasMallotAm < 0) {
			throw new IllegalArgumentException("El ciclista no puede haber llevado menos de un dia el mallot amarillo.");
		}
	}
	
	public void checkTiempoEmpleado(Duration tiempoEmpleado) {
		if (tiempoEmpleado.getSeconds() < Duration.ZERO.getSeconds()) {
			throw new IllegalArgumentException("El ciclista no puede haber tardado menos de 0 segundos.");
		}
	}
	
	@Override
	public Integer getAnyo() {
		// TODO Auto-generated method stub
		return anyo;
	}

	@Override
	public String getNacionalidad() {
		// TODO Auto-generated method stub
		return nacionalidad;
	}

	@Override
	public String getNombre() {
		// TODO Auto-generated method stub
		return nombre;
	}

	@Override
	public String getEquipo() {
		// TODO Auto-generated method stub
		return equipo;
	}

	@Override
	public Integer getKmRecorridos() {
		// TODO Auto-generated method stub
		return kmRec;
	}

	@Override
	public Duration getTiempoEmpleado() {
		// TODO Auto-generated method stub
		return tiempoEmpleado;
	}

	@Override
	public Integer getNumEtapasGanadas() {
		// TODO Auto-generated method stub
		return etapasGanadas;
	}

	@Override
	public Integer getNumDiasMaillot() {
		// TODO Auto-generated method stub
		return diasMallotAm;
	}

	@Override
	public Double getVelocidadMedia() {
		// TODO Auto-generated method stub
		Double velocidadMedia = new Double((kmRec*1000) / (int) tiempoEmpleado.getSeconds());
		return velocidadMedia;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((anyo == null) ? 0 : anyo.hashCode());
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		result = prime * result + ((equipo == null) ? 0 : equipo.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		GanadorImpl other = (GanadorImpl) obj;
		if (anyo == null) {
			if (other.anyo != null)
				return false;
		} else if (!anyo.equals(other.anyo))
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		if (equipo == null) {
			if (other.equipo != null)
				return false;
		} else if (!equipo.equals(other.equipo))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Ganador del año " + anyo + ": " + nombre + ", corriendo para " + equipo + ".";
	}

}
