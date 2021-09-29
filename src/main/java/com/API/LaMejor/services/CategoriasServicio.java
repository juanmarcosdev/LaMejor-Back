package com.API.LaMejor.services;

import com.API.LaMejor.repositories.CategoriasRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoriasServicio {

    private final CategoriasRepositorio categoriasRepositorio;

    @Autowired
    public CategoriasServicio(CategoriasRepositorio categoriasRepositorio){
        this.categoriasRepositorio = categoriasRepositorio;
    }
}
