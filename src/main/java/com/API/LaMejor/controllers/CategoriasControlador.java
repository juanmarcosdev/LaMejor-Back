package com.API.LaMejor.controllers;

import com.API.LaMejor.services.CategoriasServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("categorias")
public class CategoriasControlador {

    private final CategoriasServicio categoriasServicio;

    @Autowired
    public CategoriasControlador(CategoriasServicio categoriasServicio){
        this.categoriasServicio = categoriasServicio;
    }

}
