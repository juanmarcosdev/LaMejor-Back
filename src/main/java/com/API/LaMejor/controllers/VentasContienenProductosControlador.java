package com.API.LaMejor.controllers;

import com.API.LaMejor.models.Productos;
import com.API.LaMejor.models.VentasContienenProductos;
import com.API.LaMejor.models.VentasContienenProductosId;
import com.API.LaMejor.services.VentasContienenProductosServicios;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ventasContienenProductos")
public class VentasContienenProductosControlador {

    private final VentasContienenProductosServicios ventasContienenProductosServicios;

    @Autowired
    public VentasContienenProductosControlador(VentasContienenProductosServicios ventasContienenProductosServicios){
        this.ventasContienenProductosServicios = ventasContienenProductosServicios;
    }

    //Crear producto
    @PostMapping("/crear")
    public ResponseEntity<VentasContienenProductos> adicionarProducto(@RequestBody List<VentasContienenProductos> nuevoProducto){
        VentasContienenProductos adicionarVenta = ventasContienenProductosServicios.adicionarProductos(nuevoProducto);
        return new ResponseEntity<>(adicionarVenta,HttpStatus.OK);
    }

    @GetMapping("/obtener/{factura_id}")
    public ResponseEntity<List<VentasContienenProductos>> obtenerDetalleFactura(@PathVariable("factura_id") Long factura_id){
        List<VentasContienenProductos>  listadoDetalles = ventasContienenProductosServicios.obtenerDetalleFactura(factura_id);

        return new ResponseEntity<>(listadoDetalles,HttpStatus.OK);
    }
}
