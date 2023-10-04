package proyecto.konrad.services;

import proyecto.konrad.entity.FormularioUsuario;

public interface IFormularioUsuarioService {
	
	public Object findAll();
	public Object findById(Long id);
	public Object save(FormularioUsuario formularioUsuario);
	public Object update(FormularioUsuario formularioUsuario);
	public Object delete(Long id);
	Object findAllByFormularioAndUsuario(Long formulario, Long usuario);
	

}
