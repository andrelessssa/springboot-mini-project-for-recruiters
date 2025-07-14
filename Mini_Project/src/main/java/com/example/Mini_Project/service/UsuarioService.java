package com.example.Mini_Project.service;

import org.springframework.stereotype.Service;

import com.example.Mini_Project.repository.UsuarioRepository;

@Service
public class UsuarioService {
    
    private UsuarioRepository usuarioRepository;
        
    
        public UsuarioService(UsuarioRepository repository) {
            this.usuarioRepository = repository;
    }

}
