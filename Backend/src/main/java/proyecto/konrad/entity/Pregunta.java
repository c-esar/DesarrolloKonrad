package proyecto.konrad.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="Pregunta")
@Data
@Getter
@Setter
@AllArgsConstructor
public class Pregunta implements Serializable {
	
	public Pregunta() {
		super();
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID_PREGUNTA")
	private Long idPregunta;
	
	@Column(name="NOMBRE_PREGUNTA")
	private String nombreOpcion;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="ID_FORMULARIO", nullable=false)
    private Formulario idFormulario;
	
	@OneToMany(mappedBy="idOpcion")
    private Set<Opcion> opcion;
	
    public void addOpcion(Opcion opci) {
    	opcion.add(opci);
    	opci.setIdPregunta(this);
    }
    public void removePregunta(Opcion opci) {
    	opcion.remove(opci);
    	opci.setIdPregunta(null);
    }
    
	



	public Long getIdPregunta() {
		return idPregunta;
	}






	public void setIdPregunta(Long idPregunta) {
		this.idPregunta = idPregunta;
	}






	public String getNombreOpcion() {
		return nombreOpcion;
	}






	public void setNombreOpcion(String nombreOpcion) {
		this.nombreOpcion = nombreOpcion;
	}






	public Formulario getIdFormulario() {
		return idFormulario;
	}






	public void setIdFormulario(Formulario idFormulario) {
		this.idFormulario = idFormulario;
	}


	private static final long serialVersionUID = 1L;
}
