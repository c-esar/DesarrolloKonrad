package proyecto.konrad.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import proyecto.konrad.entity.Opcion;
public interface IOpcionRepository extends CrudRepository<Opcion, Long>{

	List<Opcion> findAllByPreguntaIdPregunta(Long id);

	void deleteByPreguntaIdPregunta(Long id);

}
