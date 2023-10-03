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

import proyecto.konrad.entity.Formulario;
import proyecto.konrad.services.IFormularioService;

@CrossOrigin(origins = { "http://localhost:4200" })
@RestController
@RequestMapping("/formulario")
public class FormularioController {

	@Autowired
	private IFormularioService iFormularioService;

	@GetMapping("/all")
	public Object finadAll() {
		return iFormularioService.findAll();
	}
	
	@GetMapping("/byId/{id}")
	public Object findById(@PathVariable String id) {
		return iFormularioService.findById(Long.parseLong(id));
	}
	
	@PostMapping("/save")
	public Object save(@RequestBody Formulario formulario) {
		return iFormularioService.save(formulario);
	}
	
	@PostMapping("/update")
	public Object update(@RequestBody Formulario formulario) {
		return iFormularioService.update(formulario);
	}
	
	@DeleteMapping("/delete/{id}")
	public Object delete(@PathVariable Long idFormulario) {
		return iFormularioService.delete(idFormulario);
	}

}
