package proyecto.konrad.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import proyecto.konrad.entity.Pregunta;
import proyecto.konrad.repository.IOpcionRepository;
import proyecto.konrad.repository.IPreguntaRepository;

@Service
public class PreguntaServiceImpl implements IPreguntaService {

	@Autowired
	private IPreguntaRepository iPreguntaRepository;

	@Autowired
	private IOpcionRepository iOpcionRepository;

	@Override
	@Transactional(readOnly = true)
	public Object findAll() {
		try {
			return iPreguntaRepository.findAll();
		} catch (Exception e) {
			return new Pregunta("Error al procesar la información", false);
		}
	}

	@Override
	@Transactional(readOnly = true)
	public Object findAllByFormulario(Long id) {
		try {
			return iPreguntaRepository.findAllByFormularioIdFormulario(id);
		} catch (Exception e) {
			return new Pregunta("Error al procesar la información", false);

		}
	}

	@Override
	public Object findById(Long id) {
		try {
			Optional<?> temp = iPreguntaRepository.findById(id);
			if(temp.isPresent()) {
				return temp.get();
			}else {
				throw new Exception("Error al buscar");
			}
		} catch (Exception e) {
			return new Pregunta("Error al procesar la información", false);

		}
	}

	@Override
	public Object save(Pregunta pregunta) {
		try {
			Pregunta temp = iPreguntaRepository.save(pregunta);
			if(temp != null) {
				return temp;
			}else {
				throw new Exception("Error al guardar");
			}
		} catch (Exception e) {
			return new Pregunta("Error al procesar la información", false);

		}
	}

	@Override
	public Object update(Pregunta pregunta) {
		try {
			Pregunta temp = iPreguntaRepository.save(pregunta);
			if(temp != null) {
				return temp;
			}else {
				throw new Exception("Error al guardar");
			}
		} catch (Exception e) {
			return new Pregunta("Error al procesar la información", false);

		}
	}

	@Override
	@Transactional
	public Object delete(Long id) {
		try {
			if(!iOpcionRepository.findAllByPreguntaIdPregunta(id).isEmpty()) {
				iOpcionRepository.deleteByPreguntaIdPregunta(id);
			}
			iPreguntaRepository.deleteById(id);
			return Boolean.TRUE;
		} catch (Exception e) {
			return new Pregunta("Error al procesar la información", false);

		}

	}

}
