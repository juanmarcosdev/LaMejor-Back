package com.API.LaMejor.models;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Cacheable(false)
public class Categorias {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "categorias_secuencia")
    @Column(name = "categoria_id", nullable = false, updatable = false)
    private Long categoriaId;
    @Column(nullable = false,updatable = false)
    private String categoriaNombre;
    @Column(nullable = false,updatable = false)
    private String categoriaDescripcion;
    @Column(nullable = false,updatable = true)
    private Date categoriaFechaCreacion;
    @Column(nullable = false,updatable = true)
    private int categoriaEstado;
}