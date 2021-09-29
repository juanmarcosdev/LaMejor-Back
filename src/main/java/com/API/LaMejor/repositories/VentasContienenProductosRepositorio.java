package com.API.LaMejor.repositories;

import com.API.LaMejor.models.Trabajadores;
import com.API.LaMejor.models.VentasContienenProductos;
import com.API.LaMejor.models.VentasContienenProductosId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

public interface VentasContienenProductosRepositorio extends JpaRepository<VentasContienenProductos, VentasContienenProductosId> {

    @Transactional(readOnly = true)
    @Query("From VentasContienenProductos v WHERE v.id.venta.ventaId = :venta_id")
    public List<VentasContienenProductos> findById_Venta(@Param("venta_id") Long venta_id);
}
