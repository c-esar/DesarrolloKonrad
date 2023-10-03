package proyecto.konrad.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="Formulario")
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Formulario implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID_FORMULARIO")
	private Long idFormulario;
	
	@Column(name="NOMBRE_FORMULARIO")
	private String nombreFormulario;
	
//	@Column(name="FECHA_REGISTRO")
//	private Date fechaRegistro;
	
	@OneToMany(mappedBy="idFormulario")
    private Set<Pregunta> pregunta;
	
    public void addPregunta(Pregunta pregun) {
    	pregunta.add(pregun);
    	pregun.setIdFormulario(this);
    }
    public void removePregunta(Pregunta pregun) {
    	pregunta.remove(pregun);
    	pregun.setIdFormulario(null);
    }
    
    





	private static final long serialVersionUID = 1L;
}
