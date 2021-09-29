package com.API.LaMejor.repositories;

import com.API.LaMejor.models.Trabajadores;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

public interface TrabajadoresRepositorio extends JpaRepository<Trabajadores,Long> {

    @Transactional(readOnly = true)
    @Query("From Trabajadores t WHERE t.trabajadorDocumento = :trabajador_documento")
    public Optional<Trabajadores> findTrabajadoresByTrabajadorDocumento(@Param("trabajador_documento") String trabajador_documento);
}
