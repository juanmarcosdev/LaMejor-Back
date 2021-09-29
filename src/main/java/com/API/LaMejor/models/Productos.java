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
public class Productos {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "productos_secuencia")
    @Column(name = "producto_id", nullable = false, updatable = false)
    private Long productoId;
    @Column(nullable = false,updatable = false)
    private String productoNombre;
    @Column(nullable = false,updatable = false)
    private String productoDescripcion;
    @Column(nullable = false,updatable = true)
    private Date productoFechaCreacion;
    @Column(nullable = false,updatable = true)
    private double productoPrecio;
    @Column(nullable = false,updatable = true)
    private int productoExistencias;
    @Column(nullable = false,updatable = true)
    private int productoEstado;
}