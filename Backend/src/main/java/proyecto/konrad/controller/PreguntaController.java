package proyecto.konrad.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import proyecto.konrad.entity.Pregunta;
import proyecto.konrad.services.IPreguntaService;

@CrossOrigin(origins = { "http://localhost:4200","*" })
@RestController
@RequestMapping("/pregunta")
public class PreguntaController {

	@Autowired
	private IPreguntaService iPreguntaService;
	
	@GetMapping("/all")
	public Object finadAll() {
		return iPreguntaService.findAll();
	}
	
	@GetMapping("/byId/{id}")
	public Object findById(@PathVariable String id) {
		return iPreguntaService.findById(Long.parseLong(id));
	}
	
	@GetMapping("/byFormulario/{id}")
	public Object findByFormulario(@PathVariable String id) {
		return iPreguntaService.findAllByFormulario(Long.parseLong(id));
	}
	
	@PostMapping("/save")
	public Object save(@RequestBody Pregunta pregunta) {
		return iPreguntaService.save(pregunta);
	}
	
	@PostMapping("/update")
	public Object update(@RequestBody Pregunta pregunta) {
		return iPreguntaService.update(pregunta);
	}
	
	@DeleteMapping("/delete/{id}")
	public Object delete(@PathVariable String id) {
		return iPreguntaService.delete(Long.parseLong(id));
	}

}
