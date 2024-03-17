package com.beta.authenticationsystem.infra.Security;

import com.beta.authenticationsystem.Models.RegistrosUsuarios.usuario.Usuario;
import com.beta.authenticationsystem.Repository.Registros.UsuarioRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AutenticacionService implements UserDetailsService {

    @Autowired
    private UsuarioRepository usuarioRepository;
    @Override
    public UserDetails loadUserByUsername (String email) throws UsernameNotFoundException {
        Usuario usuario = (Usuario) usuarioRepository.findByEmail(email);

        return usuario;
    }
}
