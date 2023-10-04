package proyecto.konrad.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import proyecto.konrad.util.utilMensaje;

@Entity
@Table(name="FormularioUsuario")
@Data
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
	
	
//	fecha
	
	


	private static final long serialVersionUID = 1L;


}
