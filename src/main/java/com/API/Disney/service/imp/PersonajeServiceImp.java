package com.API.Disney.service.imp;


import com.API.Disney.dto.PersonajeDTO;
import com.API.Disney.entity.Pelicula;
import com.API.Disney.entity.Personaje;
import com.API.Disney.repository.PeliculaRepository;
import com.API.Disney.repository.PersonajeRepository;
import com.API.Disney.repository.interfaces.PersonajeProyection;
import com.API.Disney.service.PersonajeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonajeServiceImp implements PersonajeService {

    @Autowired
    PersonajeRepository personajeRepository;

    @Autowired
    PeliculaRepository peliculaRepository;
    @Override
    public Optional<Personaje> getPersonajeById(Long id_personaje) {

        Optional<Personaje> findPersonaje= personajeRepository.findById(id_personaje);
        return findPersonaje;
    }

    @Override
    public void savePersonaje(PersonajeDTO personajeRequest) {
        Personaje personaje= new Personaje(personajeRequest.getImagen(),personajeRequest.getNombre(), personajeRequest.getEdad(), personajeRequest.getPeso(), personajeRequest.getHistoria());
        personajeRepository.save(personaje);
    }

    @Override
    public List<Personaje> getAllPersonaje() {
        return personajeRepository.findAll();
    }

    @Override
    public List<Personaje> deletePersonajeById(Long id_personaje) {
        return null;
    }

    @Override
    public Personaje updatePersonaje(Long id_personaje, String imagen, String name, int edad, Double peso, String historia, List<Pelicula> peliculas) {
        return null;
    }

    @Override
    public List<PersonajeProyection> GetAllByNameAndImagen() {
        return personajeRepository.findAllBy();
    }

    @Override
    public void addPeliculaEnPersonaje(Long id_personaje,Long id_pelicula) {
        Optional<Personaje> optionalPersonaje= personajeRepository.findById(id_personaje);
        Optional<Pelicula> optionalPelicula= peliculaRepository.findById(id_pelicula);

        if (optionalPersonaje.isPresent() && optionalPelicula.isPresent()){
            Personaje personaje = optionalPersonaje.get();
            Pelicula pelicula = optionalPelicula.get();

            personaje.getPeliculas().add(pelicula);
            personajeRepository.save(personaje);
        } else {
            System.out.println("Character or film doesn't exist");
        }
    }

    @Override
    public List<Personaje> findByName(String nombre) {
        return personajeRepository.findByNombre(nombre);
    }

    @Override
    public List<Personaje> findByEdad(Integer edad) {
        return personajeRepository.findByEdad(edad);
    }

    @Override
    public List<Personaje> getMayoresEdad() {
        return personajeRepository.getMayoresEdad();
    }


}
