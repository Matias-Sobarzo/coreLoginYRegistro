package com.matiassobarzo.models;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.persistence.Transient;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@Entity
@Table(name ="usuarios")
public class Usuario {
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(unique = true)
	@NotBlank(message = "El campo es requerido")
	@Size(min = 3, max = 15, message = "El nombre de usuario debe de contener entre 3 y 15 caracteres.")
	private String nombreUsuario;
	
	@NotBlank(message = "El campo es requerido")
	@Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z]).{8,}$", message = "La contraseña debe contener 8 caracteres o más, e incluir al menos una letra minúscula, una letra mayúscula y un número.")
	private String contraseña;
	
	@Transient
	private String confirmarContraseña;
	
	@Column(unique = true)
	@NotBlank(message = "El campo es requerido")
	@Email(message="Debe ser un correo electronico valido")
	private String correo;
	
	@NotBlank(message = "El campo es requerido")
	@Size(min = 3, message = "Debe contener al menos 3 caracteres")
	private String nombre;
	
	@NotBlank(message = "El campo es requerido")
	@Size(min = 3, message = "Debe contener al menos 3 caracteres")	
	private String apellido;
	
	@Past(message = "Tu fecha de nacimiento necesita ser una fecha en el pasado.")
	@DateTimeFormat(pattern="yyyy-MM-dd")
	@Temporal(TemporalType.DATE)
	private LocalDate fechaDeNacimiento;
	
	@Column(updatable=false)
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private LocalDate fechaCreacion;

	@DateTimeFormat(pattern="yyyy-MM-dd")
	private LocalDate fechaActualizacion;

	
	public Usuario(Long id, String nombreUsuario, String contraseña, String confirmarContraseña, String correo, String nombre, String apellido, LocalDate fechaDeNacimiento, LocalDate fechaCreacion, LocalDate fechaActualizacion) {
		super();
		this.id = id;
		this.nombreUsuario = nombreUsuario;
		this.contraseña = contraseña;
		this.confirmarContraseña = confirmarContraseña;
		this.correo = correo;
		this.nombre = nombre;
		this.apellido = apellido;
		this.fechaDeNacimiento = fechaDeNacimiento;
		this.fechaCreacion = fechaCreacion;
		this.fechaActualizacion = fechaActualizacion;
	}
	
	public Usuario() {
		this.id = 0l;
		this.nombreUsuario = "";
		this.contraseña = "";
		this.confirmarContraseña = "";
		this.correo = "";
		this.nombre = "";
		this.apellido = "";
		this.fechaDeNacimiento = LocalDate.now();
		this.fechaCreacion = LocalDate.now();
		this.fechaActualizacion = LocalDate.now();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombreUsuario() {
		return nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	public String getContraseña() {
		return contraseña;
	}

	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}

	public String getConfirmarContraseña() {
		return confirmarContraseña;
	}

	public void setConfirmarContraseña(String confirmarContraseña) {
		this.confirmarContraseña = confirmarContraseña;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public LocalDate getFechaDeNacimiento() {
		return fechaDeNacimiento;
	}

	public void setFechaDeNacimiento(LocalDate fechaDeNacimiento) {
		this.fechaDeNacimiento = fechaDeNacimiento;
	}

	public LocalDate getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(LocalDate fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public LocalDate getFechaActualizacion() {
		return fechaActualizacion;
	}

	public void setFechaActualizacion(LocalDate fechaActualizacion) {
		this.fechaActualizacion = fechaActualizacion;
	}

	@Override
	public String toString() {
		return "Usuario [id=" + id + ", nombreUsuario=" + nombreUsuario + ", contraseña=" + contraseña
				+ ", confirmarContraseña=" + confirmarContraseña + ", correo=" + correo + ", nombre=" + nombre
				+ ", apellido=" + apellido + ", fechaDeNacimiento=" + fechaDeNacimiento + ", fechaCreacion="
				+ fechaCreacion + ", fechaActualizacion=" + fechaActualizacion + "]";
	}
	
	
	

}
