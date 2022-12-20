/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.egg.biblioteca.servicios;

import com.egg.biblioteca.entidades.Autor;
import com.egg.biblioteca.excepciones.MiException;
import com.egg.biblioteca.repositorios.AutorRepositorio;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author milip
 */
@Service
public class AutorServicio {

    @Autowired
    AutorRepositorio autorRepo;

    @Transactional
    public void crearAutor(String nombre) throws MiException {
        validar(nombre);
        Autor autor = new Autor();
        autor.setNombre(nombre);

        autorRepo.save(autor); //guardar en la base de datos la entidad (Entity)
    }

    public List<Autor> listarAutores() {
        ArrayList<Autor> listaAutores = (ArrayList<Autor>) autorRepo.findAll();
        return listaAutores;
    }

    public void modificarAutor(String id, String nombre) throws MiException {
        validar(nombre);
        Optional<Autor> rta = autorRepo.findById(id);
        if (rta.isPresent()) {
            Autor autor = rta.get();
            autor.setNombre(nombre);

            autorRepo.save(autor);
        }
    }

    private void validar(String nombre) throws MiException {
        if (nombre.isEmpty() || nombre == null) {
            throw new MiException("El nombre del autor no puede estar vacío o nulo");
        }
    }

    public Autor getOne(String id) {
        return autorRepo.getOne(id);
    }
}
