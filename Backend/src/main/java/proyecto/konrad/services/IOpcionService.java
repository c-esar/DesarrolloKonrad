package proyecto.konrad.services;

import proyecto.konrad.entity.Opcion;

public interface IOpcionService {
	
	public Object findAll();
	public Object findById(Long id);
	public Object save(Opcion opcion);
	public Object update(Opcion opcion);
	public Object delete(Long id);
	

}
