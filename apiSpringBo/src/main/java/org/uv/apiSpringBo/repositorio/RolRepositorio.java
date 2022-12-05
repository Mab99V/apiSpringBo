package org.uv.apiSpringBo.repositorio;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.uv.apiSpringBo.entidades.Rol;



public interface RolRepositorio extends JpaRepository<Rol, Long>{

	public Optional<Rol> findByNombre(String nombre);
	
}
