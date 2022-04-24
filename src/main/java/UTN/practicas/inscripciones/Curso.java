package UTN.practicas.inscripciones;

public class Curso {
	
	private int año;
	private String materia;
	private String cuatrimestre;
	private int alumnos=0;
	private boolean estaAbierto = false;
	private String[] correlativas;
	
	public int getAño() {
		return año;
	}
	public boolean isEstaAbierto() {
		return estaAbierto;
	}
	public void setEstaAbierto(boolean estaAbierto) {
		this.estaAbierto = estaAbierto;
	}
	public void setAño(int año) {
		this.año = año;
	}
	public String getMateria() {
		return materia;
	}
	public void setMateria(String materia) {
		this.materia = materia;
	}
	public String getCuatrimestre() {
		return cuatrimestre;
	}
	public void setCuatrimestre(String cuatrimestre) {
		this.cuatrimestre = cuatrimestre;
	}
	public String[] getCorrelativas() {
		return correlativas;
	}
	public void setCorrelativas(String[] correlativas) {
		this.correlativas = correlativas;
	}
	public int getAlumnos() {
		return alumnos;
	}
	public void setAlumnos(int alumnos) {
		this.alumnos = alumnos;
	}
	public Curso(int año, String materia, String cuatrimestre, String[] correlativas) {
		super();
		this.año = año;
		this.materia = materia;
		this.cuatrimestre = cuatrimestre;
		this.correlativas = correlativas;
	}
	
	
}
