package proyecto.konrad.services;

import java.util.ArrayList;
import java.util.HashMap;
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
		HashMap<String, FormularioUsuario> usuario = new HashMap<>();
		HashMap<String, Long> formulario = new HashMap<>();
		List<FormularioUsuario> formUser = new ArrayList<>();
		boolean ban = false;
		try {
			List<FormularioUsuario> temp = (List<FormularioUsuario>) formularioUsuarioRepository.findAll();
			if (!temp.isEmpty()) {
				for (int i = 0; i < temp.size(); i++) {
					if (usuario.containsKey(temp.get(i).getUsuario().toString())) {
						if (!(usuario.get(temp.get(i).getUsuario().toString()).getFormulario() == temp.get(i).getFormulario()))  {
							ban = true;
						}
					}else {
						ban = true;
					}
					if (ban) {
						ban = false;
						usuario.put(String.valueOf(temp.get(i).getUsuario()), temp.get(i));
						temp.get(i).setIdUsuario(this.iUsuarioRepository.findById(temp.get(i).getUsuario()).get());
						temp.get(i).setIdFormulario(
								this.iFormularioRepository.findById(temp.get(i).getFormulario()).get());
						formUser.add(temp.get(i));
					}

				}
			}
			return formUser;
		} catch (Exception e) {
			return new FormularioUsuario("Error al procesar la información", false);
		}
	}

	@Override
	@Transactional(readOnly = true)
	public Object findAllByFormularioAndUsuario(Long formulario, Long usuario) {
		try {
			List<FormularioUsuario> temp = formularioUsuarioRepository.findAllByFormularioAndUsuario(formulario,
					usuario);
			if (!temp.isEmpty()) {
				for (FormularioUsuario element : temp) {
					element.setIdUsuario(this.iUsuarioRepository.findById(element.getUsuario()).get());
					element.setIdFormulario(this.iFormularioRepository.findById(element.getFormulario()).get());
					element.setIdPregunta(this.iPreguntaRepository.findById(element.getPregunta()).get());
					element.setIdOpcionPregunta(this.iOpcionRepository.findById(element.getOpcionPregunta()).get());
				}
			}
			return temp;
		} catch (Exception e) {
			return new FormularioUsuario("Error al procesar la información", false);
		}
	}

	@Override
	public Object findById(Long id) {
		try {
			formularioUsuarioRepository.findById(id);
			return Optional.ofNullable("Sin resultados");
		} catch (Exception e) {
			return new FormularioUsuario("Error al procesar la información", false);
		}
	}

	@Override
	public Object save(List<FormularioUsuario> formularioUsuario) {
		try {
			Iterable<FormularioUsuario> temp = formularioUsuarioRepository.saveAll(formularioUsuario);
			if (temp != null) {
				return temp;
			} else {
				return new Exception("Error al guardar");
			}
		} catch (Exception e) {
			return new FormularioUsuario("Error al procesar la información", false);
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
			return new FormularioUsuario("Error al procesar la información", false);
		}
	}

	@Override
	public Object delete(Long id) {
		try {
			formularioUsuarioRepository.deleteById(id);
			return Boolean.TRUE;
		} catch (Exception e) {
			return new FormularioUsuario("Error al procesar la información", false);
		}

	}

	@Override
	@Transactional
	public Object deleteByFormularioAndUsuario(Long idForm, Long idUser) {
		try {
			formularioUsuarioRepository.deleteByFormularioAndUsuario(idForm, idUser);
			return Boolean.TRUE;
		} catch (Exception e) {
			return new FormularioUsuario("Error al procesar la información", false);
		}

	}

}
