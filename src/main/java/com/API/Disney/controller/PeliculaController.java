package com.API.Disney.controller;


import com.API.Disney.entity.Pelicula;
import com.API.Disney.service.PeliculaService;
import com.API.Disney.service.imp.PeliculaServiceImp;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RestController
@RequestMapping("api/peliculas")
public class PeliculaController {


    @Autowired
    PeliculaServiceImp peliculaServiceImp;

    @PostMapping(value = "/createPelicula", consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_FORM_URLENCODED_VALUE})
    public ResponseEntity<Pelicula> savePelicula(@Valid @RequestBody Pelicula pelicula){
        pelicula.setFechaCreacion(LocalDate.now());
        peliculaServiceImp.savePelicula(pelicula);
         return new ResponseEntity<>(pelicula, HttpStatus.CREATED);
    }

}
