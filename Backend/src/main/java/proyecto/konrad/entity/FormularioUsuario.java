package proyecto.konrad.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import proyecto.konrad.util.utilMensaje;

@Entity
@Table(name="FormularioUsuario")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FormularioUsuario extends utilMensaje implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID_FORMULARIO_USUARIO")
	private Long idFormularioUsuario;

	@Column(name="ID_FORMULARIO")
    private Long formulario;

	@Column(name="ID_USUARIO")
    private Long usuario;

	@Column(name="ID_PREGUNTA")
    private Long pregunta;

	@Column(name="ID_OPCION_PREGUNTA")
    private Long opcionPregunta;

	@Transient
    private Formulario idFormulario;

	@Transient
    private Usuario idUsuario;

	@Transient
    private Pregunta idPregunta;

	@Transient
    private Opcion idOpcionPregunta;

	public FormularioUsuario(String mensaje, Boolean valor) {
		this.setMensaje(mensaje);
		this.setEstado(valor);
	}




	private static final long serialVersionUID = 1L;


}
