package proyecto.konrad.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import proyecto.konrad.entity.Formulario;
import proyecto.konrad.entity.Usuario;
import proyecto.konrad.repository.IFormularioRepository;

@Service
public class FormularioServiceImpl implements IFormularioService {

	@Autowired
	private IFormularioRepository iFormularioRepository;

	@Override
	@Transactional(readOnly = true)
	public Object findAll() {
		try {
			return (List<Formulario>) iFormularioRepository.findAll();
			
		} catch (Exception e) {
			return new Formulario("Error " + e.getMessage(), false);
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
			return new Formulario("Error " + e.getMessage(), false);
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
			return new Formulario("Error " + e.getMessage(), false);
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
			return new Formulario("Error " + e.getMessage(), false);
		}
	}

	@Override
	public Object delete(Long id) {
		try {
			iFormularioRepository.deleteById(id);
			return Boolean.TRUE;
		} catch (Exception e) {
			return new Formulario("Error " + e.getMessage(), false);
		}
		
	}

}
