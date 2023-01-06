/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.egg.biblioteca.repositorios;

import com.egg.biblioteca.entidades.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 *
 * @author milip
 */
@Repository
public interface UsuarioRepositorio extends JpaRepository<Usuario, String> {    
    
    @Query("select u from Usuario u where u.email = :email")
    public Usuario buscarPorEmail(@Param("email") String email);
}
