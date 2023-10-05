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
import lombok.Setter;
import proyecto.konrad.util.utilMensaje;

@Entity
@Table(name="Formulario")
@Getter
@Setter
@AllArgsConstructor

public class Formulario extends utilMensaje implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID_FORMULARIO")
	private Long idFormulario;

	@Column(name="NOMBRE_FORMULARIO")
	private String nombreFormulario;

	@Transient
	private Boolean userFrom;

	public Formulario() {

	}

	public Formulario(String mensaje, Boolean valor) {
		this.setMensaje(mensaje);
		this.setEstado(valor);
	}




	private static final long serialVersionUID = 1L;
}
