package proyecto.konrad.services;

import proyecto.konrad.entity.Pregunta;

public interface IPreguntaService {

	public Object findAll();
	public Object findById(Long id);
	public Object save(Pregunta pregunta);
	public Object update(Pregunta pregunta);
	public Object delete(Long id);
	public Object findAllByFormulario(Long id);


}
