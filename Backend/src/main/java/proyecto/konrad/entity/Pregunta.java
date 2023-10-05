package proyecto.konrad.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import proyecto.konrad.util.utilMensaje;

@Entity
@Table(name="Pregunta")
@Getter
@Setter
@AllArgsConstructor
public class Pregunta extends utilMensaje implements Serializable {

	public Pregunta() {
		super();
	}



	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID_PREGUNTA")
	private Long idPregunta;

	@Column(name="NOMBRE_PREGUNTA")
	private String nombrePregunta;

	@ManyToOne
    @JoinColumn(name="ID_FORMULARIO")
    private Formulario formulario;

	public Pregunta(String mensaje, Boolean valor) {
		this.setMensaje(mensaje);
		this.setEstado(valor);
	}

	private static final long serialVersionUID = 1L;
}
