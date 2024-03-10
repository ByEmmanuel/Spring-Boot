package com.beta.authenticationsystem.Repository;

import com.beta.authenticationsystem.Models.DatosBancarios.Bancario;
import com.beta.authenticationsystem.Models.usuario.Usuario;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BancariosRepository extends JpaRepository<Bancario, Long> {
    Page<Bancario> findByActivoTrue(Pageable paginacion);

}

// Path: src/main/java/com/beta/authenticationsystem/Repository/DireccionRepository.java
// Compare this snippet from src/main/java/com/beta/authenticationsystem/Models/usuario/DatosRespuestaUsuario.java:
//¿?¿?¿?¿?¿