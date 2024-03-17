package com.beta.authenticationsystem.Repository.Registros;

import com.beta.authenticationsystem.Models.RegistrosUsuarios.direccion.Direccion;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DireccionRepository extends JpaRepository<Direccion, Long> {
    Page<Direccion> findByActivoTrue(Pageable paginacion);
}


