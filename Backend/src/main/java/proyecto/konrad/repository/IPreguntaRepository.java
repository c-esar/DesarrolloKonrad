package proyecto.konrad.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import proyecto.konrad.entity.Pregunta;
public interface IPreguntaRepository extends CrudRepository<Pregunta, Long>{

	List<Pregunta> findAllByFormulario(Long id);

	List<Pregunta> findAllByFormularioIdFormulario(Long id);

}
