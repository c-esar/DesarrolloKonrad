package proyecto.konrad.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

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
	
	@OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="ID_FORMULARIO", nullable=false)
    private Formulario idFormulario;
	
	@OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="ID_USUARIO", nullable=false)
    private Usuario idUsuario;
	
	@OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="ID_PREGUNTA", nullable=false)
    private Pregunta idPregunta;
	
	@OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="ID_OPCION_PREGUNTA", nullable=false)
    private Opcion idOpcionPregunta;
	
	
//	fecha
	
	


	private static final long serialVersionUID = 1L;


	public Long getIdFormularioUsuario() {
		return idFormularioUsuario;
	}


	public void setIdFormularioUsuario(Long idFormularioUsuario) {
		this.idFormularioUsuario = idFormularioUsuario;
	}


	public Formulario getIdFormulario() {
		return idFormulario;
	}


	public void setIdFormulario(Formulario idFormulario) {
		this.idFormulario = idFormulario;
	}


	public Usuario getIdUsuario() {
		return idUsuario;
	}


	public void setIdUsuario(Usuario idUsuario) {
		this.idUsuario = idUsuario;
	}


	public Pregunta getIdPregunta() {
		return idPregunta;
	}


	public void setIdPregunta(Pregunta idPregunta) {
		this.idPregunta = idPregunta;
	}


	public Opcion getIdOpcionPregunta() {
		return idOpcionPregunta;
	}


	public void setIdOpcionPregunta(Opcion idOpcionPregunta) {
		this.idOpcionPregunta = idOpcionPregunta;
	}
}
