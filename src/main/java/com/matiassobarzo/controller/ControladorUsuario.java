package com.matiassobarzo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.matiassobarzo.models.LoginUsuario;
import com.matiassobarzo.models.Usuario;
import com.matiassobarzo.services.ServicioUsuarios;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class ControladorUsuario {

	@Autowired
	private ServicioUsuarios servicioUsuarios;
	
	@GetMapping("/")
	public String inicio(HttpSession sesion, Model modelo) {
		modelo.addAttribute("usuario", new Usuario());
		modelo.addAttribute("loginUsuario", new LoginUsuario());
		return "index.jsp";
	}
	
	@PostMapping("/procesa/login")
	public String login(@Valid @ModelAttribute("loginUsuario") LoginUsuario loginUsuario, BindingResult validaciones, Model modelo, HttpSession sesion) {
		this.servicioUsuarios.validarLogin(validaciones, loginUsuario);
		if(validaciones.hasErrors()) {
			modelo.addAttribute("loginUsuario", new LoginUsuario());
			return "index.jsp";
		}
		Usuario usuario = this.servicioUsuarios.obtenerPorNombreUsuario(loginUsuario.getNombreUsuario());
		sesion.setAttribute("nombreUsuario", usuario.getNombreUsuario());
		return "inicio.jsp";
	}
	
	@PostMapping("/procesa/registro")
	public String registro(@Valid @ModelAttribute("usuario") Usuario usuario, BindingResult validaciones, Model modelo, HttpSession sesion) {
		this.servicioUsuarios.validarRegistro(validaciones, usuario);
		if (validaciones.hasErrors()) {
			modelo.addAttribute("loginUsuario", new LoginUsuario());
			return "index.jsp";
		}
		Usuario usuario2 = this.servicioUsuarios.crear(usuario);
		sesion.setAttribute("nombreUsuario", usuario2.getNombreUsuario());
		return "inicio.jsp";
	}
	

	
	
}
