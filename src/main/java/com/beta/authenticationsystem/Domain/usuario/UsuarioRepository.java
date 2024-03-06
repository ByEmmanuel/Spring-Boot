package com.beta.authenticationsystem.Domain.usuario;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
        Page<Usuario> findByActivoTrue(Pageable paginacion);
}

