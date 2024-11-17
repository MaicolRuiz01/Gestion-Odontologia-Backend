package com.odontologia.movil.serviceimplement;

import com.odontologia.movil.service.UsuarioService;

import com.odontologia.movil.entidades.Usuario;
import com.odontologia.movil.repository.UsuarioRepository;
import com.odontologia.movil.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioServiceImplement implements UsuarioService{
	
	private final UsuarioRepository usuarioRepository;

    @Autowired
    public UsuarioServiceImplement(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Usuario> findAll() {
        return usuarioRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Usuario> findById(Integer id) {
        return usuarioRepository.findById(id);
    }

    @Override
    @Transactional
    public Usuario save(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    @Override
    @Transactional
    public void deleteById(Integer id) {
        usuarioRepository.deleteById(id);
    }

}
