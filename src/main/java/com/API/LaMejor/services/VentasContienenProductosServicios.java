package com.API.LaMejor.services;

import com.API.LaMejor.models.Productos;
import com.API.LaMejor.models.Ventas;
import com.API.LaMejor.models.VentasContienenProductos;
import com.API.LaMejor.models.VentasContienenProductosId;
import com.API.LaMejor.repositories.VentasContienenProductosRepositorio;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VentasContienenProductosServicios {

    private final VentasContienenProductosRepositorio ventasContienenProductosRepositorio;

    @Autowired
    public VentasContienenProductosServicios( VentasContienenProductosRepositorio ventasContienenProductosRepositorio){
        this.ventasContienenProductosRepositorio = ventasContienenProductosRepositorio;
    }

    public VentasContienenProductos adicionarProductos(List<VentasContienenProductos> nuevoProducto){
        System.out.println(nuevoProducto);
        ventasContienenProductosRepositorio.saveAll(nuevoProducto);
        return null;
    }

    public List<VentasContienenProductos> obtenerDetalleFactura(Long factura_id){
        return ventasContienenProductosRepositorio.findById_Venta(factura_id);
    }



}
