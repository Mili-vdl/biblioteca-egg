/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.egg.biblioteca.controladores;

import com.egg.biblioteca.servicios.UsuarioServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author milip
 */
@Controller
@RequestMapping("/") //configurar la url que va a escuchar a este controlador
public class PortalControlador {
    
    @Autowired
    UsuarioServicio usuarioServicio;

    @GetMapping("/") //operacion de http, mapea la url cuando se ingresa /
    public String index() {
        return "index.html";
    }

    @GetMapping("/registrar")
    public String registrar() {
        return "registro.html";
    }

    @PostMapping("/registro")
    public String registro(@RequestParam String nombre, @RequestParam String email, @RequestParam String password,
            String password2, ModelMap modelo) {
        usuarioServicio.registrar(nombre, email, password, password2);
    }

    @GetMapping("/login")
    public String login() {
        return "login.html";
    }
}
