package com.API.LaMejor.models;


import com.fasterxml.jackson.databind.JsonNode;
import lombok.*;

import javax.persistence.Embeddable;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Embeddable
public final class VentasContienenProductosId implements Serializable {
    @ManyToOne
    @JoinColumn(name = "venta_id",referencedColumnName = "venta_id",foreignKey = @ForeignKey(name = "FK_Venta"))
    protected Ventas venta;
    @ManyToOne
    @JoinColumn(name = "producto_id",referencedColumnName = "producto_id",foreignKey = @ForeignKey(name = "FK_Producto"))
    protected Productos producto;



}