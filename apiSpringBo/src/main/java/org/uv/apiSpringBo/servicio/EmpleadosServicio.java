/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package org.uv.apiSpringBo.servicio;

import java.util.List;
import org.uv.apiSpringBo.dto.EmpleadosDTO;

/**
 *
 * @author mab99
 */
public interface EmpleadosServicio {
    public EmpleadosDTO guardarEmpleados(EmpleadosDTO empDTO);
    
    public List<EmpleadosDTO>obtenerTodos();
    
    public EmpleadosDTO obtenerById(long id);
    
    public  EmpleadosDTO actualizarEmpleado( EmpleadosDTO empDTO,long id);
    
    public void eliminarEmpleado(long id);
}
