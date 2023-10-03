package proyecto.konrad.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import proyecto.konrad.entity.FormularioUsuario;
import proyecto.konrad.repository.IFormularioUsuarioRepository;

@Service
public class FormularioUsuarioServiceImpl implements IFormularioUsuarioService {

	@Autowired
	private IFormularioUsuarioRepository formularioUsuarioRepository;

	@Override
	@Transactional(readOnly = true)
	public Object findAll() {
		try {
			return (List<FormularioUsuario>) formularioUsuarioRepository.findAll();
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
	public Object update(FormularioUsuario formularioUsuario) {
		try {
			FormularioUsuario temp = formularioUsuarioRepository.save(formularioUsuario);
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
			formularioUsuarioRepository.deleteById(id);
			return Boolean.TRUE;
		} catch (Exception e) {
			return new String("Error " + e.getMessage());
		}
		
	}

}
