package com.API.Disney.service;

import com.API.Disney.entity.Pelicula;

import java.util.Optional;

public interface PeliculaService {

    void savePelicula(Pelicula pelicula);

    Optional<Pelicula> getFilmById(Long id_pelicula);

}
