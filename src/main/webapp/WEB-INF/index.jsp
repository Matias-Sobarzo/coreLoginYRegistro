<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
          <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Registro y login</title>
<link rel="stylesheet" href="/css/styles.css">
</head>
<body>
<div class="content">
	<form:form action="/procesa/registro" method="POST" modelAttribute="usuario">
	<h2>Registrarse</h2>
		<form:label path="nombreUsuario">Nombre de usuario:</form:label> 
		<form:input type="text" path="nombreUsuario"/>
		<form:errors class="error" path="nombreUsuario"/>	
		
		<form:label path="correo">Correo Electronico:</form:label> 
		<form:input type="email" path="correo"/>
		<form:errors class="error" path="correo"/>
	
		<form:label path="nombre">Nombre:</form:label> 
		<form:input type="text" path="nombre"/>
		<form:errors class="error" path="nombre"/>

		<form:label path="apellido">Apellido:</form:label>
		<form:input type="text" path="apellido"/>
		<form:errors class="error" path="apellido"/>

		<form:label path="fechaDeNacimiento">Fecha de nacimiento:</form:label> 
		<form:input type="date" path="fechaDeNacimiento"/>
		<form:errors class="error" path="fechaDeNacimiento"/>

		<form:label path="contraseña">Contraseña:</form:label> 
		<form:input type="password" path="contraseña"/> 
		<form:errors class="error" path="contraseña"/>
		
		<form:label path="confirmarContraseña">Confirmar contraseña:</form:label> 
		<form:input type="password" path="confirmarContraseña"/> 
		<form:errors class="error" path="confirmarContraseña"/>
		
		<input type="submit" value="Registrarse">
	</form:form>
	
	<form:form action="/procesa/login" method="POST" modelAttribute="loginUsuario">
	<h2>Iniciar Sesión</h2>
		<form:label path="nombreUsuario">Nombre de usuario:</form:label> 
		<form:input type="text" path="nombreUsuario"/>
		<form:errors class="error" path="nombreUsuario"/>	

		<form:label path="contraseña">Contraseña:</form:label> 
		<form:input type="password" path="contraseña"/> 
		<form:errors class="error" path="contraseña"/>
		
		<input type="submit" value="Iniciar Sesión">
	</form:form>

</body>
</html>