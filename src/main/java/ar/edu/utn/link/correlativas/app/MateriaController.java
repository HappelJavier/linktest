package ar.edu.utn.link.correlativas.app;


import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ar.edu.utn.link.correlativas.model.Materia;

@RestController
@RequestMapping("/materias")
public class MateriaController {
	
	@Autowired
	private RepoMateria repo;
	
	@Value ("${correlativas.max}")
	private String correlativasMax;
	
	@GetMapping("")
	public Page<Materia> list(@RequestParam(value="anio",required = false)  Integer anio,
			Pageable page) {	
		
		System.out.println(correlativasMax);
		if(anio == null) {
			//System.out.println(page);
			List<Materia> all = new ArrayList<Materia>(repo.all());
			
			int fromIndex = page.getPageNumber() * page.getPageSize();
			
			return new PageImpl<Materia>(all, page, all.size());
		} else {
			return new PageImpl<Materia>(new ArrayList<>(repo.findByYear(anio) ) );	
		}
		
	}
	
	@GetMapping("/{nombre}")
	public Materia get(@PathVariable("nombre") String nombreMateria) {		
		return repo.findByName(nombreMateria) ;
	}
	
	@PostMapping("")
	public String post(@RequestBody @Valid Materia materia,
			BindingResult bindingResult) 
			throws MateriaRepetidaException {		
		if(!bindingResult.hasErrors()) {
			repo.save(materia) ;
			return "ok";
		}else {
			bindingResult.getFieldErrors().stream().forEach(x ->{
				x.getField();
				x.getDefaultMessage();
			});
			return "no ok, con errores";
		}
		
	}
	
}
