package ar.edu.utn.link.correlativas.app;

import java.util.Collection;

import ar.edu.utn.link.correlativas.model.Materia;

public interface RepoMateria {

	Collection<Materia> all();

	Materia findByName(String nombreMateria);

	Collection<Materia> findByYear(Integer anio);

	void save(Materia materia) throws MateriaRepetidaException;

}