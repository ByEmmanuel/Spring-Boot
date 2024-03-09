package com.beta.authenticationsystem.Repository;

import com.beta.authenticationsystem.Models.usuario.Usuario;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BancariosRepository extends JpaRepository<Usuario, Long> {
    Page<Usuario> findByActivoTrue(Pageable paginacion);
}

// Path: src/main/java/com/beta/authenticationsystem/Repository/DireccionRepository.java
// Compare this snippet from src/main/java/com/beta/authenticationsystem/Models/usuario/DatosRespuestaUsuario.java:
//¿?¿?¿?¿?¿