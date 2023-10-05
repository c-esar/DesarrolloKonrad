package proyecto.konrad.controller;

import java.util.List;

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

@CrossOrigin(origins = { "http://localhost:4200", "*" })
@RestController
@RequestMapping("/formularioUsuario")
public class FormularioUsuarioController {

	@Autowired
	private IFormularioUsuarioService formularioUsuarioService;

	@GetMapping("/all")
	public Object finadAll() {
		return formularioUsuarioService.findAll();
	}

	@GetMapping("/allFinally/{from}/{usu}")
	public Object finadAllFinally(@PathVariable String from, @PathVariable String usu) {
		return formularioUsuarioService.findAllByFormularioAndUsuario(Long.parseLong(from), Long.parseLong(usu));
	}

	@GetMapping("/byId/{id}")
	public Object findById(@PathVariable Long id) {
		return formularioUsuarioService.findById(id);
	}

	@PostMapping("/save")
	public Object save(@RequestBody List<FormularioUsuario> formularioUsuario) {
		return formularioUsuarioService.save(formularioUsuario);
	}

	@PostMapping("/update")
	public Object update(@RequestBody FormularioUsuario formularioUsuario) {
		return formularioUsuarioService.update(formularioUsuario);
	}

	@DeleteMapping("/delete/{id}")
	public Object delete(@PathVariable Long id) {
		return formularioUsuarioService.delete(id);
	}

	@DeleteMapping("/deleteByFormAndUser/{idForm}/{idUser}")
	public Object delete(@PathVariable String idForm, @PathVariable String idUser) {
		return formularioUsuarioService.deleteByFormularioAndUsuario(Long.parseLong(idForm), Long.parseLong(idUser));
	}

}
