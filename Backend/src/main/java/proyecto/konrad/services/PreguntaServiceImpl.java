package proyecto.konrad.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import proyecto.konrad.entity.Pregunta;

import proyecto.konrad.repository.IPreguntaRepository;

@Service
public class PreguntaServiceImpl implements IPreguntaService {

	@Autowired
	private IPreguntaRepository iPreguntaRepository;

	@Override
	@Transactional(readOnly = true)
	public Object findAll() {
		try {
			return (List<Pregunta>) iPreguntaRepository.findAll();
		} catch (Exception e) {
			return new String("Error " + e.getMessage());
		}
	}
	
	@Override
	@Transactional(readOnly = true)
	public Object findAllByFormulario(Long id) {
		try {
			return (List<Pregunta>) iPreguntaRepository.findAllByFormularioIdFormulario(id);
		} catch (Exception e) {
			return new String("Error " + e.getMessage());
		}
	}

	@Override
	public Object findById(Long id) {
		try {
			iPreguntaRepository.findById(id);
			return Optional.ofNullable("Sin resultados");
		} catch (Exception e) {
			return new String("Error " + e.getMessage());
		} 
	}

	@Override
	public Object save(Pregunta pregunta) {
		try {
			Pregunta temp = iPreguntaRepository.save(pregunta);
			if(temp != null) {
				return temp;
			}else {
				return new Exception("Error al guardar");
			}
		} catch (Exception e) {
			return new String("Error " + e.getMessage());
		}
	}

	@Override
	public Object update(Pregunta pregunta) {
		try {
			Pregunta temp = iPreguntaRepository.save(pregunta);
			if(temp != null) {
				return temp;
			}else {
				return new Exception("Error al guardar");
			}
		} catch (Exception e) {
			return new String("Error " + e.getMessage());
		}
	}

	@Override
	public Object delete(Long id) {
		try {
			iPreguntaRepository.deleteById(id);
			return Boolean.TRUE;
		} catch (Exception e) {
			return new String("Error " + e.getMessage());
		}
		
	}

}
