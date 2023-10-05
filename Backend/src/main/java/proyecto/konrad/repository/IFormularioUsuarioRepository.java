package proyecto.konrad.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import proyecto.konrad.entity.FormularioUsuario;
public interface IFormularioUsuarioRepository extends CrudRepository<FormularioUsuario, Long>{

	List<FormularioUsuario> findAllByFormularioAndUsuario(Long formulario, Long usuario);

	void deleteByFormularioAndUsuario(Long id, Long idUser);

}
