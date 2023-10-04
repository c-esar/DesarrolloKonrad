package proyecto.konrad.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import proyecto.konrad.entity.FormularioUsuario;
import proyecto.konrad.repository.IFormularioRepository;
import proyecto.konrad.repository.IFormularioUsuarioRepository;
import proyecto.konrad.repository.IOpcionRepository;
import proyecto.konrad.repository.IPreguntaRepository;
import proyecto.konrad.repository.IUsuarioRepository;

@Service
public class FormularioUsuarioServiceImpl implements IFormularioUsuarioService {

	@Autowired
	private IFormularioUsuarioRepository formularioUsuarioRepository;
	
	@Autowired
	private IUsuarioRepository iUsuarioRepository;
	
	@Autowired
	private IFormularioRepository iFormularioRepository;
	
	@Autowired
	private IPreguntaRepository iPreguntaRepository;
	
	@Autowired
	private IOpcionRepository iOpcionRepository;

	@Override
	@Transactional(readOnly = true)
	public Object findAll() {
		try {
			List<FormularioUsuario> temp = (List<FormularioUsuario>) formularioUsuarioRepository.findAlldistint();
			if (!temp.isEmpty()) {
				for(int i=0; i<temp.size(); i++) {
					temp.get(i).setIdUsuario(this.iUsuarioRepository.findById(temp.get(i).getUsuario()).get());
					temp.get(i).setIdFormulario(this.iFormularioRepository.findById(temp.get(i).getFormulario()).get());
				}
			}
			return temp;
		} catch (Exception e) {
			return new String("Error " + e.getMessage());
		}
	}
	
	@Override
	@Transactional(readOnly = true)
	public Object findAllByFormularioAndUsuario(Long formulario, Long usuario) {
		try {
			List<FormularioUsuario> temp = (List<FormularioUsuario>) formularioUsuarioRepository.findAllByFormularioAndUsuario(formulario,usuario);
			if (!temp.isEmpty()) {
				for(int i=0; i<temp.size(); i++) {
					temp.get(i).setIdUsuario(this.iUsuarioRepository.findById(temp.get(i).getUsuario()).get());
					temp.get(i).setIdFormulario(this.iFormularioRepository.findById(temp.get(i).getFormulario()).get());
					temp.get(i).setIdPregunta(this.iPreguntaRepository.findById(temp.get(i).getPregunta()).get());
					temp.get(i).setIdOpcionPregunta(this.iOpcionRepository.findById(temp.get(i).getOpcionPregunta()).get());
				}
			}
			return temp;
		} catch (Exception e) {
			return new String("Error " + e.getMessage());
		}
	}

	@Override
	public Object findById(Long id) {
		try {
			formularioUsuarioRepository.findById(id);
			return Optional.ofNullable("Sin resultados");
		} catch (Exception e) {
			return new String("Error " + e.getMessage());
		}
	}

	@Override
	public Object save(FormularioUsuario formularioUsuario) {
		try {
			FormularioUsuario temp = formularioUsuarioRepository.save(formularioUsuario);
			if (temp != null) {
				return temp;
			} else {
				return new Exception("Error al guardar");
			}
		} catch (Exception e) {
			return new String("Error " + e.getMessage());
		}
	}

	@Override
	public Object update(FormularioUsuario formularioUsuario) {
		try {
			FormularioUsuario temp = formularioUsuarioRepository.save(formularioUsuario);
			if (temp != null) {
				return temp;
			} else {
				return new Exception("Error al guardar");
			}
		} catch (Exception e) {
			return new String("Error " + e.getMessage());
		}
	}

	@Override
	public Object delete(Long id) {
		try {
			formularioUsuarioRepository.deleteById(id);
			return Boolean.TRUE;
		} catch (Exception e) {
			return new String("Error " + e.getMessage());
		}

	}

}
