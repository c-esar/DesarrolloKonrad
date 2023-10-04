package proyecto.konrad.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import proyecto.konrad.entity.FormularioUsuario;
public interface IFormularioUsuarioRepository extends CrudRepository<FormularioUsuario, Long>{

	List<FormularioUsuario> findAllByFormularioAndUsuario(Long formulario, Long usuario);

	@Query(value = "SELECT DISTINCT id_formulario_usuario, ID_USUARIO, ID_FORMULARIO FROM FORMULARIO_USUARIO", nativeQuery = true)
	List<FormularioUsuario> findAlldistint();

}
