package com.API.LaMejor.controllers;

import com.API.LaMejor.models.Productos;
import com.API.LaMejor.services.ProductosServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/productos")
public class ProductosControlador {

    private final ProductosServicio productosServicio;

    @Autowired
    public ProductosControlador(ProductosServicio productosServicio){
        this.productosServicio = productosServicio;
    }



    //Crear producto
    @PostMapping("/crear")
    public ResponseEntity<Productos> crearProducto(@RequestBody Productos nuevoProducto){
        Productos productoNuevo = productosServicio.crearProducto(nuevoProducto);
        return new ResponseEntity<>(productoNuevo, HttpStatus.OK);
    }

    //Listar producto
    @GetMapping("/listar")
    public ResponseEntity<List<Productos>> listarProductos(){

        List<Productos> productos = productosServicio.listarProductos();
        return new ResponseEntity<>(productos, HttpStatus.OK);
    }

    //editar producto
    @PutMapping("/editar")
    public ResponseEntity<Productos> editarProducto(@RequestBody Productos productoEditado){
        Productos producto = productosServicio.editarProducto(productoEditado);

        return new ResponseEntity<>(producto,HttpStatus.OK);
    }


}
