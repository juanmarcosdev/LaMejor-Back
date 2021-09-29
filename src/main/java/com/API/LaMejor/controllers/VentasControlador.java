package com.API.LaMejor.controllers;

import com.API.LaMejor.models.Ventas;
import com.API.LaMejor.services.VentasServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ventas")
public class VentasControlador {

    private final VentasServicio ventasServicio;

    @Autowired
    public VentasControlador(VentasServicio ventasServicio){
        this.ventasServicio = ventasServicio;
    }

    @PostMapping("/crear")

    public ResponseEntity<Ventas> crearVenta(@RequestBody Ventas nuevaVenta){
        Ventas venta = ventasServicio.crearVenta(nuevaVenta);
        return new ResponseEntity<>(venta, HttpStatus.OK);
    }
    @GetMapping("/listar")

    public ResponseEntity<List<Ventas>> listarVentas(){
        List<Ventas> ventas = ventasServicio.listarVentas();
        return new ResponseEntity<>(ventas, HttpStatus.OK);
    }
}
