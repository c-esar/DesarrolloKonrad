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
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="Opcion")
@Data
@Getter
@Setter
@AllArgsConstructor
public class Opcion implements Serializable {
	
	public Opcion() {
		super();
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID_OPCION")
	private Long idOpcion;
	
	@Column(name="DESCRIPCION_OPCION")
	private String nombreOpcion;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="ID_Pregunta", nullable=false)
    private Pregunta idPregunta;
	

	public Long getIdOpcion() {
		return idOpcion;
	}





	public void setIdOpcion(Long idOpcion) {
		this.idOpcion = idOpcion;
	}





	public String getNombreOpcion() {
		return nombreOpcion;
	}





	public void setNombreOpcion(String nombreOpcion) {
		this.nombreOpcion = nombreOpcion;
	}





	public Pregunta getIdPregunta() {
		return idPregunta;
	}





	public void setIdPregunta(Pregunta idPregunta) {
		this.idPregunta = idPregunta;
	}


	private static final long serialVersionUID = 1L;
}
