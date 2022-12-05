/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.uv.apiSpringBo.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

/**
 *
 * @author mab99
 */
public class EmpleadosDTO {
    
    private long id;
    
    @NotEmpty
    @Size(min = 2, message ="El  nombre deberia tener mas de 2 caracteres")
    private String nombre;
    
    @NotEmpty
    @Size(min = 2, message ="El  apellido deberia tener mas de 2 caracteres")
    private String apellido;
    
    @NotEmpty
    @Size(min = 10, message ="La direccion deberia tener al menos 10 caracteres")
    private String direccion;
    
     @NotEmpty
    @Size(min = 10, message ="El  telefono debera tener al menos 10 caracteres")
    private String telefono;



    public EmpleadosDTO() {
        super();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

   
}
