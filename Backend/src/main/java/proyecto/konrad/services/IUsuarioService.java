package proyecto.konrad.services;

import proyecto.konrad.entity.Usuario;

public interface IUsuarioService {

	public Object findAll();
	public Object findById(Long id);
	public Object save(Usuario usuario);
	public Object update(Usuario usuario);
	public Object delete(Long id);
	public Object findByUsuario(String usuario);


}
