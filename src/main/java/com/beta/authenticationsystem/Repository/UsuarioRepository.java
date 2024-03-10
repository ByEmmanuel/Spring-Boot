package com.beta.authenticationsystem.Repository;

import com.beta.authenticationsystem.Models.usuario.Usuario;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
        Page<Usuario> findByActivoTrue(Pageable paginacion);
}

