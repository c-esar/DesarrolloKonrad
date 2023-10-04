package proyecto.konrad.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import proyecto.konrad.entity.Formulario;
import proyecto.konrad.entity.Opcion;
import proyecto.konrad.entity.Pregunta;
import proyecto.konrad.repository.IOpcionRepository;
@Service
public class OpcionServiceImpl implements IOpcionService {

	@Autowired
	private IOpcionRepository iOpcionRepository;

	@Override
	@Transactional(readOnly = true)
	public Object findAll() {
		try {
			return (List<Opcion>) iOpcionRepository.findAll();
		} catch (Exception e) {
			return new String("Error " + e.getMessage());
		}
	}

	@Override
	public Object findById(Long id) {
		try {
			Optional<?> temp = iOpcionRepository.findById(id);
			if(temp.isPresent()) {
				return temp.get();
			}else {
				return new Formulario("Error al buscar", false);
			}
		} catch (Exception e) {
			return new Formulario("Error " + e.getMessage(), false);
		} 	
	}
	
	@Override
	@Transactional(readOnly = true)
	public Object findAllByPregunta(Long id) {
		try {
			return (List<Opcion>) iOpcionRepository.findAllByPreguntaIdPregunta(id);
		} catch (Exception e) {
			return new String("Error " + e.getMessage());
		}
	}

	@Override
	public Object save(Opcion opcion) {
		try {
			Opcion temp = iOpcionRepository.save(opcion);
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
	public Object update(Opcion opcion) {
		try {
			Opcion temp = iOpcionRepository.save(opcion);
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
			iOpcionRepository.deleteById(id);
			return Boolean.TRUE;
		} catch (Exception e) {
			return new String("Error " + e.getMessage());
		}
		
	}
	
	@Override
	public Object deleteByPregunta(Long id) {
		try {
			iOpcionRepository.deleteByPreguntaIdPregunta(id);
			return Boolean.TRUE;
		} catch (Exception e) {
			return new String("Error " + e.getMessage());
		}
		
	}

}
