/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.egg.biblioteca.servicios;

import com.egg.biblioteca.entidades.Autor;
import com.egg.biblioteca.entidades.Editorial;
import com.egg.biblioteca.entidades.Libro;
import com.egg.biblioteca.excepciones.MiException;
import com.egg.biblioteca.repositorios.AutorRepositorio;
import com.egg.biblioteca.repositorios.EditorialRepositorio;
import com.egg.biblioteca.repositorios.LibroRepositorio;
import java.util.ArrayList;
import java.util.Date;
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
public class LibroServicio {

    @Autowired //indicar al servidor de aplicaciones que esta variable va a ser iniciada por el.
    //no hace falta inicializar la variable para poder operar con ella (inyeccion de dependencias)
    private LibroRepositorio libroRepo;
    @Autowired
    private AutorRepositorio autorRepo;
    @Autowired
    private EditorialRepositorio editorialRepo;

//metodo de creacion de un libro
    @Transactional
    public void crearLibro(Long isbn, String titulo, Integer ejemplares, String idAutor, String idEditorial) throws MiException {

        validar(isbn, titulo, ejemplares, idAutor, idEditorial);

        Libro l = new Libro();
        Autor a = autorRepo.findById(idAutor).get();
        Editorial ed = editorialRepo.findById(idEditorial).get();

        l.setIsbn(isbn);
        l.setTitulo(titulo);
        l.setEjemplares(ejemplares);
        l.setAutor(a);
        l.setEditorial(ed);
        l.setAlta(new Date()); //setea con la fecha del momento en que se crea

        libroRepo.save(l);
    }

    public List<Libro> listarLibros() {
        List<Libro> listaLibros = libroRepo.findAll();
        return listaLibros;
    }

    public void modificarLibro(Long isbn, String titulo, String idAutor, String idEditorial, Integer ejemplares) throws MiException {

        validar(isbn, titulo, ejemplares, idAutor, idEditorial);
        //Libro l = libroRepo.findById(isbn).get();
        Optional<Libro> respuesta = libroRepo.findById(isbn);
        Optional<Autor> rtaAutor = autorRepo.findById(idAutor);
        Optional<Editorial> rtaEditorial = editorialRepo.findById(idEditorial);

        Autor a = new Autor();
        Editorial ed = new Editorial();

        if (rtaAutor.isPresent()) {
            a = rtaAutor.get();
        }

        if (rtaEditorial.isPresent()) {
            ed = rtaEditorial.get();
        }

        if (respuesta.isPresent()) {
            Libro l = respuesta.get();

            l.setTitulo(titulo);
            l.setAutor(a);
            l.setEditorial(ed);
            l.setEjemplares(ejemplares);

            libroRepo.save(l);
        }
    }

    private void validar(Long isbn, String titulo, Integer ejemplares, String idAutor, String idEditorial) throws MiException {
        //validaciones
        if (isbn == null) {
            throw new MiException("El isbn no puede ser nulo");
        }
        if (titulo.isEmpty() || titulo == null) {
            throw new MiException("El título no puede ser nulo o estar vacío");
        }
        if (ejemplares == null) {
            throw new MiException("El número de ejemplares no puede ser nulo");
        }
        if (idAutor.isEmpty() || idAutor == null) {
            throw new MiException("El autor no puede ser nulo o estar vacío");
        }
        if (idEditorial.isEmpty() || idEditorial == null) {
            throw new MiException("La editorial no puede ser nula o estar vacía");
        }
    }
}
