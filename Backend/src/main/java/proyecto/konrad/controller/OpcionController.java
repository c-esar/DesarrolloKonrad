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
import proyecto.konrad.entity.Opcion;
import proyecto.konrad.services.IOpcionService;

@CrossOrigin(origins = { "http://localhost:4200" })
@RestController
@RequestMapping("/opcion")
public class OpcionController {

	@Autowired
	private IOpcionService iOpcionService;

	@GetMapping("/all")
	public Object finadAll() {
		return iOpcionService.findAll();
	}
	
	@GetMapping("/byId/{id}")
	public Object findById(@PathVariable Long idOpcion) {
		return iOpcionService.findById(idOpcion);
	}
	
	@PostMapping("/save")
	public Object save(@RequestBody Opcion opcion) {
		return iOpcionService.save(opcion);
	}
	
	@PostMapping("/update")
	public Object update(@RequestBody Opcion opcion) {
		return iOpcionService.update(opcion);
	}
	
	@DeleteMapping("/delete/{id}")
	public Object delete(@PathVariable Long idOpcion) {
		return iOpcionService.delete(idOpcion);
	}

}
