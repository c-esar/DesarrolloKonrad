package proyecto.konrad.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import proyecto.konrad.entity.Formulario;
import proyecto.konrad.entity.Pregunta;
import proyecto.konrad.repository.IFormularioRepository;
import proyecto.konrad.repository.IFormularioUsuarioRepository;
import proyecto.konrad.repository.IOpcionRepository;
import proyecto.konrad.repository.IPreguntaRepository;

@Service
public class FormularioServiceImpl implements IFormularioService {

	@Autowired
	private IFormularioRepository iFormularioRepository;

	@Autowired
	private IFormularioUsuarioRepository iFormularioUsuarioRepository;

	@Autowired
	private IPreguntaRepository iPreguntaRepository;

	@Autowired
	private IOpcionRepository iOpcionRepository;

	@Override
	@Transactional(readOnly = true)
	public Object findAll() {
		try {
			return iFormularioRepository.findAll();

		} catch (Exception e) {
			return new Formulario("Error al procesar la información", false);
		}
	}

	@Override
	@Transactional(readOnly = true)
	public Object findAllByUser(Long idUser) {
		try {
			List<Formulario> temp = (List<Formulario>) iFormularioRepository.findAll();
			for (Formulario element : temp) {
				element.setUserFrom(
						this.iFormularioUsuarioRepository.findAllByFormularioAndUsuario(element.getIdFormulario(), idUser)
						.isEmpty() ? false : true);
			}
			return temp;

		} catch (Exception e) {
			return new Formulario("Error al procesar la información", false);

		}
	}

	@Override
	public Object findById(Long id) {
		try {
			Optional<?> temp = iFormularioRepository.findById(id);
			if(temp.isPresent()) {
				return temp.get();
			}else {
				return new Formulario("Error al buscar", false);
			}
		} catch (Exception e) {
			return new Formulario("Error al procesar la información", false);

		}
	}

	@Override
	public Object save(Formulario formulario) {
		try {
			Formulario temp = iFormularioRepository.save(formulario);
			if(temp != null) {
				return temp;
			}else {
				return new Exception("Error al guardar");
			}
		} catch (Exception e) {
			return new Formulario("Error al procesar la información", false);

		}
	}

	@Override
	public Object update(Formulario formulario) {
		try {
			Formulario temp = iFormularioRepository.save(formulario);
			if(temp != null) {
				return temp;
			}else {
				return new Exception("Error al guardar");
			}
		} catch (Exception e) {
			return new Formulario("Error al procesar la información", false);

		}
	}

	@Override
	@Transactional
	public Object delete(Long id) {
		try {
			List<Pregunta> preguntas = this.iPreguntaRepository.findAllByFormularioIdFormulario(id);
			for(Pregunta pre: preguntas) {
				if(!iOpcionRepository.findAllByPreguntaIdPregunta(pre.getIdPregunta()).isEmpty()) {
					iOpcionRepository.deleteByPreguntaIdPregunta(pre.getIdPregunta());
				}
				iPreguntaRepository.deleteById(pre.getIdPregunta());
			}
			iFormularioRepository.deleteById(id);
			return Boolean.TRUE;
		} catch (Exception e) {
			return new Formulario("Error al procesar la información", false);

		}

	}

}
