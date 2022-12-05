/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.uv.apiSpringBo.servicio;


import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.uv.apiSpringBo.dto.EmpleadosDTO;
import org.uv.apiSpringBo.entidades.Empleados;
import org.uv.apiSpringBo.excepciones.ResourceNotFoundException;
import org.uv.apiSpringBo.repositorio.EmpleadosRepositorio;

/**
 *
 * @author mab99
 */
@Service
public class EmpleadosServicioImp implements EmpleadosServicio {
    
    @Autowired
    private EmpleadosRepositorio empRepo;

    @Override
    public EmpleadosDTO guardarEmpleados(EmpleadosDTO empDTO) {
        Empleados empleados = mapearEntidad(empDTO);
        
        Empleados nuevoEmpleado = empRepo.save(empleados);
        
        EmpleadosDTO empleadoRespu = mapearDTO(nuevoEmpleado);
        return empleadoRespu;
       
    }
    @Override
    public List<EmpleadosDTO> obtenerTodos(){
        List<Empleados>empleados = empRepo.findAll();
        return empleados.stream().map(empleado -> mapearDTO(empleado)).collect(Collectors.toList());
        
    }
    
    //convierte entidad a dto
    private EmpleadosDTO mapearDTO(Empleados empleados){
        EmpleadosDTO empDTO = new EmpleadosDTO();
         empDTO.setId(empleados.getId());
        empDTO.setNombre(empleados.getNombre());
        empDTO.setApellido(empleados.getApellido());
        empDTO.setDireccion(empleados.getDireccion());
        empDTO.setTelefono(empleados.getTelefono());
        
        return empDTO;
    }
    
      private Empleados mapearEntidad(EmpleadosDTO empDTO){
        Empleados empleados = new Empleados();
        
        empleados.setNombre(empDTO.getNombre());
        empleados.setApellido(empDTO.getApellido());
        empleados.setDireccion(empDTO.getDireccion());
        empleados.setTelefono(empDTO.getTelefono());
        
        return empleados;
    }

    @Override
    public EmpleadosDTO obtenerById(long id) {
        
        Empleados empleados = empRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Empledos", "id",id));
             return mapearDTO(empleados);
    }

    @Override
    public EmpleadosDTO actualizarEmpleado(EmpleadosDTO empDTO, long id) {
   
           Empleados empleados = empRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Empledos", "id",id));
        
        empleados.setNombre(empDTO.getNombre());
        empleados.setApellido(empDTO.getApellido());
        empleados.setDireccion(empDTO.getDireccion());
        empleados.setTelefono(empDTO.getTelefono());
           
        Empleados empleadoActu = empRepo.save(empleados);
                
                return mapearDTO(empleadoActu);
       
    }

    @Override
    public void eliminarEmpleado(long id) {
     Empleados empleado = empRepo.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Empledos", "id",id));
     
       empRepo.delete(empleado);
    }
    
}
