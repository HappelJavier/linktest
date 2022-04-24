package UTN.practicas.inscripciones;



public class Departamento {

	private int cantidadMinimaEstudiantes = 1;
	public Curso altaCurso (int año, String materia, String cuatrimestre, String[] correlativas) {
		Curso nuevoCurso = new Curso(año, materia, cuatrimestre, correlativas);
		return nuevoCurso; 
	}
	
	public Boolean abrirCurso (Curso curso) {
		if(curso.getAlumnos() >= cantidadMinimaEstudiantes) {
			curso.setEstaAbierto(true);
			return true;
		}
		return false;
	}
}
