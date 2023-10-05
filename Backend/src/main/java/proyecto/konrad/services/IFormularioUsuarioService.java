package proyecto.konrad.services;

import java.util.List;

import proyecto.konrad.entity.FormularioUsuario;

public interface IFormularioUsuarioService {

	public Object findAll();
	public Object findById(Long id);
	public Object save(List<FormularioUsuario> formularioUsuario);
	public Object update(FormularioUsuario formularioUsuario);
	public Object delete(Long id);
	Object findAllByFormularioAndUsuario(Long formulario, Long usuario);
	Object deleteByFormularioAndUsuario(Long idForm, Long idUser);


}
