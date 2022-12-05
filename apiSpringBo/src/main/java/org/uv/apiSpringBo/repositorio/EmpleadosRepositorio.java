/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package org.uv.apiSpringBo.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.uv.apiSpringBo.entidades.Empleados;

/**
 *
 * @author mab99
 */
public interface EmpleadosRepositorio extends JpaRepository<Empleados, Long>{
    
}
