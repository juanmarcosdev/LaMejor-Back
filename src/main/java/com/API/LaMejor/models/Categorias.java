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
    @GeneratedValue(strategy=GenerationType.SEQUENCE,generator = "categoria_generador")
    @SequenceGenerator(name = "categoria_generador", sequenceName = "categorias_secuencia", initialValue = 1,allocationSize = 1)
    @Column(name = "categoria_id", nullable = true, updatable = false)
    private Long categoriaId;
    @Column(nullable = false,updatable = false)
    private String categoriaNombre;
    @Column(nullable = false,updatable = false)
    private String categoriaDescripcion;
    @Column(nullable = true,updatable = false)
    private Date categoriaFechaCreacion;
    @Column(nullable = false,updatable = true)
    private int categoriaEstado;


}