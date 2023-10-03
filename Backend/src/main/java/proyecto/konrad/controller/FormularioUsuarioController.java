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

import proyecto.konrad.entity.FormularioUsuario;
import proyecto.konrad.services.IFormularioUsuarioService;

@CrossOrigin(origins = { "http://localhost:4200" })
@RestController
@RequestMapping("/formularioUsuario")
public class FormularioUsuarioController {

	@Autowired
	private IFormularioUsuarioService formularioUsuarioService;

	@GetMapping("/all")
	public Object finadAll() {
		return formularioUsuarioService.findAll();
	}
	
	@GetMapping("/byId/{id}")
	public Object findById(@PathVariable Long idFormularioUsuario) {
		return formularioUsuarioService.findById(idFormularioUsuario);
	}
	
	@PostMapping("/save")
	public Object save(@RequestBody FormularioUsuario formularioUsuario) {
		return formularioUsuarioService.save(formularioUsuario);
	}
	
	@PostMapping("/update")
	public Object update(@RequestBody FormularioUsuario formularioUsuario) {
		return formularioUsuarioService.update(formularioUsuario);
	}
	
	@DeleteMapping("/delete/{id}")
	public Object delete(@PathVariable Long idFormularioUsuario) {
		return formularioUsuarioService.delete(idFormularioUsuario);
	}

}
