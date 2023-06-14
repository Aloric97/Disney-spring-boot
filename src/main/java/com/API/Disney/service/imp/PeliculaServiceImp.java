package com.API.Disney.service.imp;

import com.API.Disney.entity.Pelicula;
import com.API.Disney.repository.PeliculaRepository;
import com.API.Disney.service.PeliculaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class PeliculaServiceImp implements PeliculaService {

    @Autowired
    PeliculaRepository peliculaRepository;
    @Override
    public void savePelicula(Pelicula pelicula) {
        peliculaRepository.save(pelicula);
    }

    @Override
    public Optional<Pelicula> getFilmById(Long id_pelicula) {
        return peliculaRepository.findById(id_pelicula);
    }


}
