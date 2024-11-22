package com.matiassobarzo.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.matiassobarzo.models.Usuario;

@Repository
public interface RepositorioUsuarios extends CrudRepository<Usuario, Long>{
	
	Optional<Usuario> findByNombreUsuario(String nombreUsuario);

}
