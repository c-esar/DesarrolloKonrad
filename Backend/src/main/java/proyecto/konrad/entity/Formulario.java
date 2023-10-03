package proyecto.konrad.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

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

	public Formulario() {
		
	}
    
	public Formulario(String mensaje, Boolean valor) {
		this.setMensaje(mensaje);
		this.setEstado(valor);
	}




	private static final long serialVersionUID = 1L;
}
