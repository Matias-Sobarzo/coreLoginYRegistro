package com.matiassobarzo.models;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class LoginUsuario {

	@NotBlank(message = "El campo es requerido")
	@Size(min = 3, max = 15, message = "El nombre de usuario debe de contener entre 3 y 15 caracteres.")
	private String nombreUsuario;
	
	@NotBlank(message = "El campo es requerido")
	@Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z]).{8,}$", message = "La contraseña debe contener 8 caracteres o más, e incluir al menos una letra minúscula, una letra mayúscula y un número.")
	private String contraseña;

	public LoginUsuario(String nombreUsuario, String contraseña) {
		super();
		this.nombreUsuario = nombreUsuario;
		this.contraseña = contraseña;
	}
	
	public LoginUsuario() {
		super();
		this.nombreUsuario = "";
		this.contraseña = "";
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
	
	
	
	
}
