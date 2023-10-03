package proyecto.konrad.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
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

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import proyecto.konrad.util.utilMensaje;

@Entity
@Table(name="Pregunta")
@Data
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
	 
	@JsonIgnoreProperties("pregunta")
	@ManyToOne
    @JoinColumn(name="ID_FORMULARIO")
    private Formulario formulario;
	
//	@JsonIgnore
//	@OneToMany(mappedBy="idOpcion")
//    private Set<Opcion> opcion;
	
//    public void addOpcion(Opcion opci) {
//    	opcion.add(opci);
//    	opci.setIdPregunta(this);
//    }
//    public void removePregunta(Opcion opci) {
//    	opcion.remove(opci);
//    	opci.setIdPregunta(null);
//    }
    
	



	public Long getIdPregunta() {
		return idPregunta;
	}






	public void setIdPregunta(Long idPregunta) {
		this.idPregunta = idPregunta;
	}






	public String getNombreOpcion() {
		return nombrePregunta;
	}






	public void setNombreOpcion(String nombreOpcion) {
		this.nombrePregunta = nombreOpcion;
	}






	public Formulario getIdFormulario() {
		return formulario;
	}






	public void setIdFormulario(Formulario formulario) {
		this.formulario = formulario;
	}


	public Pregunta(String nombreOpcion, Formulario idFormulario, Set<Opcion> opcion) {
		super();
		this.nombrePregunta = nombreOpcion;
		this.formulario = idFormulario;
	}



	private static final long serialVersionUID = 1L;
}
