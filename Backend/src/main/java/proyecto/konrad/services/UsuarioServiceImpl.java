package proyecto.konrad.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import proyecto.konrad.entity.Usuario;
import proyecto.konrad.repository.IUsuarioRepository;

@Service
public class UsuarioServiceImpl implements IUsuarioService {

	@Autowired
	private IUsuarioRepository iUsuarioRepository;

	@Override
	@Transactional(readOnly = true)
	public Object findAll() {
		try {
			return (List<Usuario>) iUsuarioRepository.findAll();
		} catch (Exception e) {
			return new String("Error " + e.getMessage());
		}
	}

	@Override
	public Object findById(Long id) {
		try {
			Optional<?> temp = iUsuarioRepository.findById(id);
			if(temp.isPresent()) {
				return temp.get();
			}else {
				return new Usuario("Error al buscar", false);
			}
		} catch (Exception e) {
			return new String("Error " + e.getMessage());
		} 
	}
	
	@Override
	public Object findByUsuario(String usuario) {
		try {
			Optional<?> temp = iUsuarioRepository.findByUsuario(usuario);
			if(temp.isPresent()) {
				return temp.get();
			}else {
				return new Usuario("Error al buscar", false);
			}
			
		} catch (Exception e) {
			return new String("Error " + e.getMessage());
		} 
	}

	@Override
	public Object save(Usuario usuario) {
		try {
			Usuario temp = iUsuarioRepository.save(usuario);
			if(temp != null) {
				return temp;
			}else {
				return new Usuario("Error al guardar", false);
			}
		} catch (Exception e) {
			return new Usuario("Error " + e.getMessage(), false);
		}
	}

	@Override
	public Object update(Usuario usuario) {
		try {
			Usuario temp = iUsuarioRepository.save(usuario);
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
			iUsuarioRepository.deleteById(id);
			return Boolean.TRUE;
		} catch (Exception e) {
			return new String("Error " + e.getMessage());
		}
		
	}

}
