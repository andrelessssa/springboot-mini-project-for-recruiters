package com.example.Mini_Project.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.example.Mini_Project.dto.UsuarioDTO;
import com.example.Mini_Project.model.Usuario;
import com.example.Mini_Project.repository.UsuarioRepository;

@Service
public class UsuarioService {
    
    private UsuarioRepository usuarioRepository;
        
    
    public UsuarioService(UsuarioRepository repository) {
        this.usuarioRepository = repository;
    }
    public Usuario criar(UsuarioDTO usuarioDTO){
        Usuario usuario = new Usuario();
        BeanUtils.copyProperties(usuarioDTO, usuario);
        return usuarioRepository.save(usuario);
    }
    public List<Usuario> listar(){
        return usuarioRepository.findAll();
    }
    public Usuario buscarPorNome(String nome){
        Optional<Usuario> usuario = usuarioRepository.findByNome(nome);
        return usuario.orElseThrow(() -> new RuntimeException("Usuário não encontrado"));
    }
    public Usuario atualizar(Integer id, UsuarioDTO usuarioDTO){
        Usuario usuario = usuarioRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("Usuário com ID " + id + " não encontrado."));
        BeanUtils.copyProperties(usuarioDTO, usuario, "id");
        return usuarioRepository.save(usuario);
    }
    public void deletar(Integer id){
        usuarioRepository.deleteById(id);

    }



}
