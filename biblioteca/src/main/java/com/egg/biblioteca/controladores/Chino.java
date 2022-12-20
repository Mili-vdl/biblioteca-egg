/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.egg.biblioteca.controladores;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author milip
 */
@Controller
@RequestMapping("/chino") //configurar la url que va a escuchar a este controlador
public class Chino {

    @GetMapping("/") //operacion de http, mapea la url cuando se ingresa /
    public String index() {
        return "chino.html";
    }
}
