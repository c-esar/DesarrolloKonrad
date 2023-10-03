package proyecto.konrad.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import proyecto.konrad.entity.Usuario;
import proyecto.konrad.services.IUsuarioService;

@CrossOrigin(origins = { "http://localhost:4200" })
@RestController
@RequestMapping("/usuario")
public class UsuarioController {

	@Autowired
	private IUsuarioService iUsuarioService;

	@GetMapping("/all")
	public Object finadAll() {
		return iUsuarioService.findAll();
	}
	
	@GetMapping("/byUsuario/{usuario}")
	public Object finadAll(@PathVariable String usuario) {
		return iUsuarioService.findByUsuario(usuario);
	}
	
	@GetMapping("/byId/{id}")
	public Object findById(@PathVariable String id) {
		return iUsuarioService.findById(Long.parseLong(id));
	}
	
	@PostMapping("/save")
	public Object save(@RequestBody Usuario usuario) {
		return iUsuarioService.save(usuario);
	}
	
	@PutMapping("/update")
	public Object update(@RequestBody Usuario usuario) {
		return iUsuarioService.update(usuario);
	}
	
	@DeleteMapping("/delete/{id}")
	public Object delete(@PathVariable Long idUsuario) {
		return iUsuarioService.delete(idUsuario);
	}


}
