package com.API.Disney.service;

import com.API.Disney.dto.PersonajeDTO;
import com.API.Disney.entity.Pelicula;
import com.API.Disney.entity.Personaje;
import com.API.Disney.repository.interfaces.PersonajeProyection;

import java.util.List;
import java.util.Optional;


public interface PersonajeService {

     Optional<Personaje> getPersonajeById(Long id_personaje);
     void savePersonaje (PersonajeDTO personajeRequest);

     List<Personaje> getAllPersonaje();

     List<Personaje> deletePersonajeById(Long id_personaje);

     Personaje updatePersonaje(Long id_personaje, String imagen, String name, int edad, Double peso, String historia, List<Pelicula> peliculas);

     List<PersonajeProyection> GetAllByNameAndImagen();
     void addPeliculaEnPersonaje(Long id_personaje,Long id_pelicula);

     List<Personaje> findByName(String nombre);
     List<Personaje> findByEdad(Integer edad);

     List<Personaje> getMayoresEdad();

}
