/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.egg.biblioteca.excepciones;

/**
 *
 * @author milip
 */
public class MiException extends Exception{
    
    //errores en nuestra logica del negocio
    public MiException(String msg) {
        super(msg);
    }
}
