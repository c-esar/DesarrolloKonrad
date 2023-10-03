package proyecto.konrad.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import proyecto.konrad.entity.Usuario;

public interface IUsuarioRepository extends CrudRepository<Usuario, Long>{

	Optional<?> findByUsuario(String usuario);

}
