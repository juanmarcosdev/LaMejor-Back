package com.API.LaMejor.controllers;

import com.API.LaMejor.models.Trabajadores;
import com.API.LaMejor.services.TrabajadoresServicio;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/trabajadores")
public class TrabajadoresControlador {

    private final TrabajadoresServicio trabajadoresServicio;

    @Autowired
    public TrabajadoresControlador(TrabajadoresServicio trabajadoresServicio){
        this.trabajadoresServicio = trabajadoresServicio;
    }

    @PutMapping("/loggin")

    public ResponseEntity<Trabajadores> logginTrabajador(@RequestBody ObjectNode data){

        Trabajadores loggeado = trabajadoresServicio.solocitudLoggin(data);

        return new ResponseEntity<>(loggeado, HttpStatus.OK);
    }
}
