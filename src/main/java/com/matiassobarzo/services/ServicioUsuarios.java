package com.matiassobarzo.services;

import java.util.List;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.matiassobarzo.models.LoginUsuario;
import com.matiassobarzo.models.Usuario;
import com.matiassobarzo.repositories.RepositorioUsuarios;

@Service
public class ServicioUsuarios {
	
	@Autowired
	private RepositorioUsuarios repositorioUsuarios;
	
	public Usuario crear(Usuario usuario) {
		String hashPassword = BCrypt.hashpw(usuario.getContraseña(), BCrypt.gensalt());
		usuario.setContraseña(hashPassword);
		return this.repositorioUsuarios.save(usuario);
	}
	
	public List<Usuario> obtenerTodos (){
		return (List<Usuario>) this.repositorioUsuarios.findAll();
	}
	
	public Usuario obtenerPorId(Long id) {
		return this.repositorioUsuarios.findById(id).orElse(null);
	}
	
	public Usuario obtenerPorNombreUsuario(String nombreUsuario) {
		return this.repositorioUsuarios.findByNombreUsuario(nombreUsuario).orElse(null);
	}
	
	public Usuario actualizar(Usuario usuario) {
		return this.repositorioUsuarios.save(usuario);
	}
	
	public void eliminarPorId(Long id) {
		this.repositorioUsuarios.deleteById(id);
	}
	
	public BindingResult validarRegistro(BindingResult validaciones, Usuario usuario) {
		if(!usuario.getContraseña().equals(usuario.getConfirmarContraseña())) {
			validaciones.rejectValue("confirmarContraseña", "contraseñasNoCoinciden", "Las contraseñas deben ser iguales");
		}
		
		return validaciones;
	}

	public BindingResult validarLogin (BindingResult validaciones, LoginUsuario usuario) {
		Usuario usuarioDb = this.obtenerPorNombreUsuario(usuario.getNombreUsuario());
		if (usuarioDb == null) {
			validaciones.rejectValue("nombreUsuario", "usuarioNoRegistrado", "El nombre de usuario ingresado no se encuentra en la base de datos");
		} else {
			if(!BCrypt.checkpw(usuario.getContraseña(), usuarioDb.getContraseña())) {
				validaciones.rejectValue("contraseña", "contraseñaIncorrecta", "Contraseña incorrecta");
			}
		}
		return validaciones;
	}

}