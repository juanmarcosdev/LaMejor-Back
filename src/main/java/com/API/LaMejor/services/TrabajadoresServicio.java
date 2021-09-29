package com.API.LaMejor.services;

import com.API.LaMejor.excepciones.TrabajadorContrasenaIncorrectaExcepcion;
import com.API.LaMejor.excepciones.TrabajadorNoEncontradoExcepcion;
import com.API.LaMejor.models.Trabajadores;
import com.API.LaMejor.repositories.TrabajadoresRepositorio;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TrabajadoresServicio {

    private final TrabajadoresRepositorio trabajadoresRepositorio;


    @Autowired
    public TrabajadoresServicio (TrabajadoresRepositorio trabajadoresRepositorio){
        this.trabajadoresRepositorio = trabajadoresRepositorio;
    }

    public Trabajadores solocitudLoggin(ObjectNode data){

        String documento = data.get("documento").asText();
        String contrasena = data.get("contrasena").asText();

        Trabajadores respuestaTrabajador = trabajadoresRepositorio.findTrabajadoresByTrabajadorDocumento(documento)
                .orElseThrow(() -> new TrabajadorNoEncontradoExcepcion("No se encontró trabajador con el documento especificado" ));

        if(respuestaTrabajador.getTrabajadorContrasena().equals(contrasena) ){
            return respuestaTrabajador;
        }
        else{
            throw new TrabajadorContrasenaIncorrectaExcepcion("Contraseña incorrecta");
        }
    }
}
