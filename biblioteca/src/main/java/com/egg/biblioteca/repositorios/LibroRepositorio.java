/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.egg.biblioteca.repositorios;

import com.egg.biblioteca.entidades.Libro;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 *
 * @author milip
 */
@Repository
public interface LibroRepositorio extends JpaRepository<Libro, Long> { //maneja la entidad libro, cuya llave id es de tipo (de dato) long

    //trae como metodo intrinseco de jpa repository buscar por id entre otros
    //metodo propio
    @Query("select l from Libro l where l.titulo = titulo")
    public Libro buscarPorTitulo(@Param("titulo") String titulo); //param titulo conecta con la query l.titulo;
    // el string titulo con el = titulo;

    @Query("select l from Libro l where l.autor.nombre = nombre")
    public List<Libro> buscarPorAutor(@Param("nombre") String nombre);
}
