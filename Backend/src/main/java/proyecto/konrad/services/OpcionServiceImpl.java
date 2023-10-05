package proyecto.konrad.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import proyecto.konrad.entity.Opcion;
import proyecto.konrad.repository.IOpcionRepository;
@Service
public class OpcionServiceImpl implements IOpcionService {

	@Autowired
	private IOpcionRepository iOpcionRepository;

	@Override
	@Transactional(readOnly = true)
	public Object findAll() {
		try {
			return iOpcionRepository.findAll();
		} catch (Exception e) {
			return new Opcion("Error al procesar la información", false);
		}
	}

	@Override
	public Object findById(Long id) {
		try {
			Optional<?> temp = iOpcionRepository.findById(id);
			if(temp.isPresent()) {
				return temp.get();
			}else {
				return new Opcion("Error al buscar", false);
			}
		} catch (Exception e) {
			return new Opcion("Error al procesar la información", false);
		}
	}

	@Override
	@Transactional(readOnly = true)
	public Object findAllByPregunta(Long id) {
		try {
			return iOpcionRepository.findAllByPreguntaIdPregunta(id);
		} catch (Exception e) {
			return new Opcion("Error al procesar la información", false);
		}
	}

	@Override
	public Object save(Opcion opcion) {
		try {
			Opcion temp = iOpcionRepository.save(opcion);
			if(temp != null) {
				return temp;
			}else {
				throw new Exception("Error al guardar");
			}
		} catch (Exception e) {
			return new Opcion("Error al procesar la información", false);
		}
	}

	@Override
	public Object update(Opcion opcion) {
		try {
			Opcion temp = iOpcionRepository.save(opcion);
			if(temp != null) {
				return temp;
			}else {
				throw new Exception("Error al guardar");
			}
		} catch (Exception e) {
			return new Opcion("Error al procesar la información", false);
		}
	}

	@Override
	@Transactional
	public Object delete(Long id) {
		try {
			iOpcionRepository.deleteById(id);
			return Boolean.TRUE;
		} catch (Exception e) {
			return new Opcion("Error al procesar la información", false);
		}

	}

	@Override
	@Transactional
	public Object deleteByPregunta(Long id) {
		try {
			iOpcionRepository.deleteByPreguntaIdPregunta(id);
			return Boolean.TRUE;
		} catch (Exception e) {
			return new Opcion("Error al procesar la información", false);
		}

	}

}
