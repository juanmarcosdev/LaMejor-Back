package com.API.LaMejor.repositories;

import com.API.LaMejor.models.Productos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface ProductosRepositorio extends JpaRepository<Productos,Long> {

    @Transactional(readOnly = true)
    @Query("FROM Productos p WHERE p.productoEstado = 1")
    public List<Productos> findProductosByProductoEstado();
}
