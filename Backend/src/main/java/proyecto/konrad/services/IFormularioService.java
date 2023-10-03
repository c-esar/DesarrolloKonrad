package proyecto.konrad.services;

import proyecto.konrad.entity.Formulario;

public interface IFormularioService {
	
	public Object findAll();
	public Object findById(Long id);
	public Object save(Formulario formulario);
	public Object update(Formulario formulario);
	public Object delete(Long id);
	

}
