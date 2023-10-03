package proyecto.konrad.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import proyecto.konrad.util.utilMensaje;

@Entity
@Table(name="Usuario")
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Usuario extends utilMensaje implements Serializable  {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID_USUARIO")
	private Long idUsuario;
	
	@Column(name="NOMBRE_USUARIO")
	private String nombreUsuario;
	
	@Column(name="USUARIO", unique = true)
	private String usuario;
	
	@Column(name="CONTRASENA")
	private String contrasena;
	
	@Column(name="ROL")
	private String rol;
	
	@Column(name="CORREO", unique = true)
	private String correo;

	public Usuario(String mensaje, Boolean valor) {
		this.setMensaje(mensaje);
		this.setEstado(valor);
	}
	
	public Long getIdUsuario() {
		return idUsuario;
	}



	public void setIdUsuario(Long idUsuario) {
		this.idUsuario = idUsuario;
	}



	public String getNombreUsuario() {
		return nombreUsuario;
	}



	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}



	public String getUsuario() {
		return usuario;
	}



	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}



	public String getContrasena() {
		return contrasena;
	}



	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}



	public String getRol() {
		return rol;
	}



	public void setRol(String rol) {
		this.rol = rol;
	}



	public String getCorreo() {
		return correo;
	}



	public void setCorreo(String correo) {
		this.correo = correo;
	}



	private static final long serialVersionUID = 1L;
}
