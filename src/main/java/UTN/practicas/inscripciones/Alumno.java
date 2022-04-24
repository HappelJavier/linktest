package UTN.practicas.inscripciones;

import java.util.ArrayList;
import java.util.Arrays;

public class Alumno {

	private String nombre;
	private String[] materiasAprovadas;

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String[] getMateriasAprovadas() {
		return materiasAprovadas;
	}

	public void setMateriasAprovadas(String[] materiasAprovadas) {
		this.materiasAprovadas = materiasAprovadas;
	}

	public Alumno(String nombre, String[] materiasAprovadas) {
		super();
		this.nombre = nombre;
		this.materiasAprovadas = materiasAprovadas;
	}

	public boolean inscribirse(Curso curso) {
		if (Arrays.asList(curso.getCorrelativas()).containsAll(Arrays.asList(materiasAprovadas))) {
			curso.setAlumnos(curso.getAlumnos() + 1);
			return true;
		}

		return false;
	}
}
