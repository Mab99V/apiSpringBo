/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.uv.apiSpringBo.controlador;

import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.uv.apiSpringBo.dto.EmpleadosDTO;
import org.uv.apiSpringBo.servicio.EmpleadosServicio;


/**
 *
 * @author mab99
 */
@RestController
@RequestMapping("/api/empleados")
public class EmpleadosControlador {
    
    @Autowired
    private EmpleadosServicio empSer;
    
    @CrossOrigin(origins = "*")
   @PreAuthorize("hasRole('ADMIN')")
    @PostMapping
    public ResponseEntity<EmpleadosDTO>guardarEmpleado(@Valid @RequestBody EmpleadosDTO empDTO){
        return new ResponseEntity<>(empSer.guardarEmpleados(empDTO),HttpStatus.CREATED);
    }
    
    @CrossOrigin(origins = "*")
    @GetMapping
    public List<EmpleadosDTO>listarEmpleados(){
        return empSer.obtenerTodos();
    }
    @CrossOrigin(origins = "*")
    @GetMapping("/{id}")
    public ResponseEntity<EmpleadosDTO>obtenerById(@PathVariable(name ="id") long id){
        
        return ResponseEntity.ok(empSer.obtenerById(id));
    }
    
    @CrossOrigin(origins = "*")
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/{id}")
    public ResponseEntity<EmpleadosDTO>actualizarEmpleado(@Valid @RequestBody EmpleadosDTO empDTO, @PathVariable(name ="id") long id){
        
        EmpleadosDTO empResp = empSer.actualizarEmpleado(empDTO, id);
        return new ResponseEntity<>(empResp,HttpStatus.OK);
  }
    @CrossOrigin(origins = "*")
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/{id}")
    public ResponseEntity<String>eliminarEmpleado(@PathVariable(name ="id") long id){
        
        empSer.eliminarEmpleado(id);
        return new ResponseEntity<>("Empleado eliminado",HttpStatus.OK);
                
    }
}

