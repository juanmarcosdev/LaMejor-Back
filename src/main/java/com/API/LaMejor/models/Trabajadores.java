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
public class Trabajadores {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "trabajadores_secuencia")
    @Column(name = "trabajador_id", nullable = false, updatable = false)
    private Long trabajadorId;
    @Column(nullable = false,updatable = false)
    private String trabajadorNombre;
    @Column(nullable = false,updatable = false)
    private String trabajadorApellido;
    @Column(nullable = false,updatable = false)
    private String trabajadorCorreo;
    @Column(nullable = false,updatable = false)
    private String trabajadorCelular;
    @Column(nullable = false,updatable = false)
    private String trabajadorDocumento;
    @Column(nullable = false,updatable = true)
    private String trabajadorContrasena;
    @Column(nullable = false,updatable = true)
    private int trabajadorEstado;
}