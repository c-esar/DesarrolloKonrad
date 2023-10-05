package proyecto.konrad.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
@Table(name="Opcion")
@Getter
@Setter
@AllArgsConstructor
public class Opcion extends utilMensaje implements Serializable {

	public Opcion() {
		super();
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID_OPCION")
	private Long idOpcion;

	@Column(name="DESCRIPCION_OPCION")
	private String nombreOpcion;

	@ManyToOne(optional = false, fetch = FetchType.EAGER)
    @JoinColumn(name="ID_Pregunta",nullable = false)
    private Pregunta pregunta;

	public Opcion(String mensaje, Boolean valor) {
		this.setMensaje(mensaje);
		this.setEstado(valor);
	}
	private static final long serialVersionUID = 1L;
}
