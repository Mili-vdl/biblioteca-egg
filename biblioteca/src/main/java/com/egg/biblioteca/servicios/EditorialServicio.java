/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.egg.biblioteca.servicios;

import com.egg.biblioteca.entidades.Editorial;
import com.egg.biblioteca.excepciones.MiException;
import com.egg.biblioteca.repositorios.EditorialRepositorio;
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
public class EditorialServicio {

    @Autowired
    EditorialRepositorio editorialRepo;

    @Transactional
    public void crearEditorial(String nombre) throws MiException {
        validar(nombre);
        Editorial ed = new Editorial();
        ed.setNombre(nombre);

        editorialRepo.save(ed);
    }

    public List<Editorial> listarEditorial() {
        List<Editorial> listaEditoriales = new ArrayList();
        listaEditoriales = editorialRepo.findAll();
        return listaEditoriales;
    }

    public void modificarEditorial(String id, String nombre) throws MiException {
        validar(nombre);
        Optional<Editorial> rta = editorialRepo.findById(id);
        if (rta.isPresent()) {
            Editorial editorial = rta.get();
            editorial.setNombre(nombre);

            editorialRepo.save(editorial);
        }
    }

    private void validar(String nombre) throws MiException {
        if (nombre.isEmpty() || nombre == null) {
            throw new MiException("El nombre de la editorial no puede estar vacío o nulo");
        }
    }

    public Editorial getOne(String id) {
        return editorialRepo.getOne(id);
    }
}
