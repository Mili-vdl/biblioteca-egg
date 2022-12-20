/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.egg.biblioteca.entidades;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import org.hibernate.annotations.GenericGenerator;

/**
 *
 * @author milip
 */
@Entity
public class Autor {

    @Id
    @GeneratedValue(generator = "uuid") // genera una cadena de texto alfanumerica unica
    @GenericGenerator(name = "uuid", strategy = "uuid2") // estrategia alternativa para asegurar que no se repita ningun id
    private String id;
    private String nombre;

    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
     
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

}