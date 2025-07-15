package com.example.Mini_Project.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Mini_Project.model.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer>{

    Optional<Usuario> findByNome(String nome);
   
    
}
